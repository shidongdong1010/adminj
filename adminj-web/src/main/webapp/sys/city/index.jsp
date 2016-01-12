<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>领航员综合服务平台</title>
	<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		$(function() {
			$('#dg').datagrid( {
				title:'城市信息管理',
				align:'center',
				url:'${ctx }/sys/city/list.json',
				singleSelect:true,
				pagination:true,
				pageSize:15,
				pageList:[15,20,30,50,100,200],
				rowNumbers: true,
				striped:true,
				singleSelect:false,
				height: '460',
				width: 'auto',
				frozenColumns : [[
					{
						field:'ck',
						checkbox:true
					}
				]],
				columns : [[
					{
						field : 'city_name',
						title : '城市名称',
						align:'center',
						width : 100
					},{
						field : 'prov_cn_name',
						title : '所属省份',
						align:'center',
						width : 100
					},{
						field : 'valid_flag',
						title : '是否显示',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value=='Y'){
								return "是";
							}else if(value=='N'){
								return "否";
							}
						}
					},{
						field : 'sss',
						title : '操作',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(row['valid_flag']=='Y'){
								return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick=\"valid('"+row['city_id']+"','N','"+row['city_name']+"','"+row['province_id']+"');\">隐藏</a> ";
							}else{
								return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick=\"valid('"+row['city_id']+"','Y','"+row['city_name']+"','"+row['province_id']+"');\">显示</a> ";
							}
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					cityName : $("#cityName").textbox("getValue"),
					provinceId : $("#provinceId").combobox("getValue"),
					validFlag : $("#validFlag").combobox("getValue")
				});
				return false;
			});
			$("#addBtn").click(function(){
				info("");
			});
			$("#editBtn").click(function(){
				var item =  $('#dg').datagrid('getChecked');
				if(item.length==1){
					info(item[0]);
				}else{
					$.messager.alert('提示', '请选择一条记录！', 'info');
				}
			});
			$("#removeBtn").click(function(){
				var items =  $('#dg').datagrid('getChecked');
				if(items.length>0){
					$.messager.confirm("提示", "您确定要删除选择信息吗?", function(data){
						if(data){
							var cityIds = "";
							$.each(items, function(index, item){
								cityIds += item.city_id+","
							});
							cityIds = cityIds.substring(0, cityIds.length-1);
							$.post("${ctx }/sys/city/remove.json",{cityIds:cityIds},function(data){
								if(data=='1'){
									$.messager.alert('提示', '删除成功！', 'info',function(){
										window.location = "${ctx }/sys/city/index.html";
									});
								}else{
									$.messager.alert('提示', '删除失败！', 'error');
								}
							});
						}
					});
				}else{
					$.messager.alert('提示', '请选择一条记录！', 'info');
				}
			});
			
		});
		function info(city){
			if(city==""){
				$("#cityName-edit").textbox('setValue',"");
				$("#provinceId-edit").combobox('select',"");
				$("#cityId-edit").val("");
			}else{
				$("#cityName-edit").textbox("setValue",city.city_name);
				$("#provinceId-edit").combobox("select",city.province_id);
				$("#cityId-edit").val(city.city_id);
			}
			$("#cc").show();
			$('#cc').dialog({
			    title: '操作',
			    width: 600,
			    height: 260,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		function submit(){
			var cityId = $("#cityId-edit").val();
			var cityName = $("#cityName-edit").textbox("getValue");
			var provinceId = $("#provinceId-edit").combobox("getValue");
			if(cityName==''){
				$.messager.alert('提示', '请输入城市名称！', 'info',function(){
					$("#cityName-edit").focus();
				});
				return false;
			}
			if(provinceId==''){
				$.messager.alert('提示', '请选择所属省份！', 'info',function(){
					$("#provinceId-edit").focus();
				});
				return false;
			}
			$.post("${ctx }/sys/city/saveOrUpdate.json",{
				cityId:cityId,
				cityName:cityName,
				provinceId:provinceId,
				validFlag:'Y'
			},function(data){
				if(data=='1'){
					$.messager.alert('提示', '操作成功！', 'info',function(){
						$('#cc').dialog('close');
						window.location = "${ctx }/sys/city/index.html";
					});
				}else{
					$.messager.alert('提示', '操作失败！', 'info');
				}
			});
		}
		function valid(cityId,validFlag,cityName,provinceId){
			$.post("${ctx }/sys/city/saveOrUpdate.json",{
				cityId:cityId,
				validFlag:validFlag,
				cityName:cityName,
				provinceId:provinceId
			},function(data){
				if(data=='1'){
					$.messager.alert('提示', '操作成功！', 'info',function(){
						window.location = "${ctx }/sys/city/index.html";
					});
				}else{
					$.messager.alert('提示', '操作失败！', 'info');
				}
			});
		}
	</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
	<div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
		<div id="tb" style="padding:2px 5px;">
			城市名称： <input type="text" name="cityName" id="cityName" class="easyui-textbox" style="width:100px;"/>
			所属省份：<select id="provinceId" name="provinceId" class="easyui-combobox" data-options="editable:false" style="width:150px;" >
							<option value="">全部</option>
							<c:forEach items="${provinces }" var="province">
								<option value="${province.provinceId }">${province.provCnName }</option>
							</c:forEach>
						</select>
			是否显示： <select id="validFlag" name="validFlag" class="easyui-combobox" data-options="editable:false" style="width:70px;" >
					<option value="">全部</option>
					<option value="Y">是</option>
					<option value="N">否</option>
				</select>
			&nbsp;
			<a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
		</div>
	</div>

	<table id="dg">
	</table>
	
	<div style="text-align:right;padding:5px">
		<a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">添加</a>
		<a href="#" class="easyui-linkbutton" id="editBtn" iconCls="icon-edit">修改</a>
		<a href="#" class="easyui-linkbutton" id="removeBtn" iconCls="icon-remove">删除</a>
	</div>
	<!-- 查看 -->
	<div id ="cc" style="display: none">
		<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="cityId-edit" name="cityId-edit"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">城市信息维护<br></td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>所属省份：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="provinceId-edit" name="provinceId-edit" class="easyui-combobox" data-options="editable:false" style="width:150px;" >
							<option value="">全部</option>
							<c:forEach items="${provinces }" var="province">
								<option value="${province.provinceId }">${province.provCnName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>城市名称：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="cityName-edit" data-options="required:true" name="cityName-edit" style="width:150px;" class="easyui-textbox"/></td>
				</tr>
			</table><p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" height="40" align="center">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submit()">保 存</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-no" onclick="$('#cc').dialog('close')">关  闭</a>
					</td>
				</tr>
			</table>
	</div>
	
</div>
</body>
</html>
