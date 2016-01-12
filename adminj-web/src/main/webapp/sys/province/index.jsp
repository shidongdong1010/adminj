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
				title:'省份信息管理',
				align:'center',
				url:'${ctx }/sys/province/list.json',
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
						field : 'provCnName',
						title : '省份中文名称',
						align:'center',
						width : 100
					},{
						field : 'shortName',
						title : '省份简称',
						align:'center',
						width : 100
					},{
						field : 'provEnName',
						title : '省份英文名称',
						align:'center',
						width : 100
					},{
						field : 'validFlag',
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
							if(row['validFlag']=='Y'){
								return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick=\"valid('"+row['provinceId']+"','N','"+row['provCnName']+"','"+row['shortName']+"','"+row['provEnName']+"');\">隐藏</a> ";
							}else{
								return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick=\"valid('"+row['provinceId']+"','Y','"+row['provCnName']+"','"+row['shortName']+"','"+row['provEnName']+"');\">显示</a> ";
							}
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					provCnName : $("#provCnName").textbox("getValue"),
					shortName : $("#shortName").textbox("getValue"),
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
							var provinceIds = "";
							$.each(items, function(index, item){
								provinceIds += item.provinceId+","
							});
							provinceIds = provinceIds.substring(0, provinceIds.length-1);
							$.post("${ctx }/sys/province/remove.json",{provinceIds:provinceIds},function(data){
								if(data=='1'){
									$.messager.alert('提示', '删除成功！', 'info',function(){
										window.location = "${ctx }/sys/province/index.html";
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
		function info(province){
			if(province==""){
				$("#provCnName-edit").textbox('setValue',"");
				$("#shortName-edit").textbox('setValue',"");
				$("#provEnName-edit").textbox('setValue',"");
				$("#provinceId-edit").val("");
			}else{
				$("#provCnName-edit").textbox("setValue",province.provCnName);
				$("#shortName-edit").textbox("setValue",province.shortName);
				$("#provEnName-edit").textbox("setValue",province.provEnName);
				$("#provinceId-edit").val(province.provinceId);
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
			var provinceId = $("#provinceId-edit").val();
			var provCnName = $("#provCnName-edit").textbox("getValue");
			var shortName = $("#shortName-edit").textbox("getValue");
			var provEnName = $("#provEnName-edit").textbox("getValue");
			if(provCnName==''){
				$.messager.alert('提示', '请输入省份中文名称！', 'info',function(){
					$("#provCnName").focus();
				});
				return false;
			}
			if(shortName==''){
				$.messager.alert('提示', '请输入省份简称！', 'info',function(){
					$("#shortName").focus();
				});
				return false;
			}
			if(provEnName==''){
				$.messager.alert('提示', '请输入省份英文名称！', 'info',function(){
					$("#provEnName").focus();
				});
				return false;
			}
			$.post("${ctx }/sys/province/saveOrUpdate.json",{
				provinceId:provinceId,
				provCnName:provCnName,
				shortName:shortName,
				provEnName:provEnName,
				validFlag:'Y'
			},function(data){
				if(data=='1'){
					$.messager.alert('提示', '操作成功！', 'info',function(){
						$('#cc').dialog('close');
						window.location = "${ctx }/sys/province/index.html";
					});
				}else{
					$.messager.alert('提示', '操作失败！', 'info');
				}
			});
		}
		function valid(provinceId,validFlag,provCnName,shortName,provEnName){
			$.post("${ctx }/sys/province/saveOrUpdate.json",{
				provinceId:provinceId,
				provCnName:provCnName,
				shortName:shortName,
				provEnName:provEnName,
				validFlag:validFlag
			},function(data){
				if(data=='1'){
					$.messager.alert('提示', '操作成功！', 'info',function(){
						window.location = "${ctx }/sys/province/index.html";
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
			省份中文名称： <input type="text" name="provCnName" id="provCnName" class="easyui-textbox" style="width:100px;"/>
			省份简称： <input type="text" name="shortName" id="shortName" class="easyui-textbox" style="width:100px;"/>
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
						<input type="hidden" id="provinceId-edit" name="provinceId-edit"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">省份信息维护<br></td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>省份中文名称：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="provCnName-edit" data-options="required:true" name="provCnName-edit" style="width:150px;" class="easyui-textbox"/></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>省份英文名称：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="provEnName-edit" data-options="required:true" name="provEnName-edit" style="width:150px;" class="easyui-textbox"/></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>省份简称：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="shortName-edit" data-options="required:true" name="shortName-edit" style="width:150px;" class="easyui-textbox"/></td>
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
