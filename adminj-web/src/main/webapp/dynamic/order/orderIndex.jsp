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
				title:'晒单信息管理',
				align:'center',
				url:'${ctx }/dynamic/orderList.json',
				singleSelect:true,
				pagination:true,
				pageSize:15,
				pageList:[15,20,30,50,100,200],
				rowNumbers: true,
				striped:true,
				singleSelect:true,
				height: '460',
				width: 'auto',
				columns : [[
					{
						field : 'user_name',
						title : '用户名',
						align:'center',
						width : 100
					},{
						field : 'group_name',
						title : '组合名',
						align:'center',
						width : 150
					},{
						field: 'mark',
						title : '晒单内容',
						align:'center',
						width : 200
					},{
						field : 'total_income',
						title : '总收益额',
						align:'center',
						width : 100
					},{
						field : 'day_float_limit',
						title : '日收益额',
						align:'center',
						width : 100
					},{
						field : 'total_cost',
						title : '组合总成本',
						align:'center',
						width : 100
					},{
						field : 'follow_buy_num',
						title : '跟买人数',
						align:'center',
						width : 100
					},{
						field : 'audit_status',
						title : '审核状态',
						align:'center',
						width : 100,
						formatter: function(value,row,index){
							if(value=='W'){
								return "待审核";
							}else if(value=='P'){
								return "审核通过";
							}else if(value=='D'){
								return "审核拒绝";
							}
						}
					},{
						field : 'ss',
						title : '操作',
						align:'center',
						width : 140,
						formatter: function(value,row,index){
							return "<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"info("+index+");\">查看/编辑</a> ";
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					userName : $("#user_name").textbox("getValue"),
					groupName:$("#group_name").textbox("getValue"),
					auditStatus:$("#auditStatus").combobox("getValue")
				});
				return false;
			});
			
		});
		function info(index){
			var rows = $("#dg").datagrid("getRows");
			var row = rows[index];
			var dynamic_id = row['dynamic_id'];
			var create_date = row['create_date'];
			var user_name = row['user_name'];
			var title = row['title'];
			var mark = row['mark'];
			var image_path = row['image_path'];
			var user_id = row['user_id'];
			
			$("#dynamic_id").val(dynamic_id);
			$("#user_id").val(user_id);
			$("#create_date").text(create_date);
			$("#userName").text(user_name);
			$("#title").text(title);
			$("#mark").text(mark);
			if(image_path!="undefined"&&image_path!=""){
				var imgs = image_path.split(";");
				var html = "";
				for(var i=0;i<imgs.length;i++){
					if(imgs[i]!=""){
						html+="<img src=\"${sail_web_url}/dynamic/info/query/dynamicImg.json?path="+imgs[i]+"\" width=\"300px\"/>";
					}
				}
				$("#img").html(html);
			}
			$("#cc").show();
			$('#cc').dialog({
			    title: '详细信息',
			    width: 900,
			    height: 600,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		function cancel(){
			var dynamic_id = $("#dynamic_id").val();
			var cancelDesc = $("#cancelDesc").val();
			if(cancelDesc==''){
				$.messager.alert('提示', '请输入屏蔽理由！', 'info');
				return false;
			}
			$.post("${ctx }/dynamic/orderCancel.json",{dynamic_id:dynamic_id,auditDesc:cancelDesc},function(data){
				if(data=='1'){
					$.messager.alert('提示', '屏蔽成功！', 'info');
				}else{
					$.messager.alert('提示', '屏蔽失败！', 'info');
				}
			});
		}
		function submit(){
			var content = $("#content").val();
			if(content==''){
				$.messager.alert('提示', '请输入回复内容！', 'info');
				return false;
			}
			var fileName = $("#commentFile").val();
			var fileSuffix = fileName.substring(fileName.lastIndexOf(".") , fileName.length);
			if ('' != fileName && ".jpg" != fileSuffix && ".png" != fileSuffix && ".3jp" != fileSuffix && ".gif" != fileSuffix) {
				$.messager.alert('提示', '文件格式不对，只支持图片上传！', 'warning');
				return false;
			}
			$("#myForm").submit();
		}
	</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
	<div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
		<div id="tb" style="padding:2px 5px;">
			用户名： <input type="text" name="user_name" id="user_name" class="easyui-textbox" style="width:200px;"/>
			组合名： <input type="text" name="group_name" id="group_name" class="easyui-textbox" style="width:200px;"/>
			状态： <select id="auditStatus" name="auditStatus" class="easyui-combobox" data-options="editable:false" style="width:170px;" >
					<option value="">全部</option>
					<option value="W">待审核</option>
					<option value="P">审核通过</option>
					<option value="D">审核拒绝</option>
				</select>&nbsp;
			<a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
		</div>
	</div>

	<table id="dg">
	</table>
	
	<!-- 查看 -->
	<div id ="cc" style="display: none">
		<form id='myForm' action="${ctx }/dynamic/orderComment.html" method="POST" enctype="multipart/form-data">
		<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao"><img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br></td>
					<td class="biao">动态详情<br></td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<input type="hidden" id="dynamic_id" name="dynamic_id"/>
					<input type="hidden" id="user_id" name="user_id"/>
					<input type="hidden" id="fowordPath" name="fowordPath" value="/dynamic/order/orderIndex"/>
					<td width="20%" align="center" valign="middle"><b>用户名</b></td>
					<td width="20%" align="left" valign="middle" id="userName"></td>
					<td width="20%" align="center" valign="middle" ><b>时间</b></td>
					<td width="20%" align="left" valign="middle" id="create_date"></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>标题</b></td>
					<td width="20%" align="left" valign="middle" colspan="3" id="title"></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>内容</b></td>
					<td width="20%" align="left" valign="middle" colspan="3" id="mark"></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle" colspan="4" id="img">
					</td>
				</tr>
			</table><p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao"><img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br></td>
					<td class="biao">回复<br></td>
				</tr>
			</table>
				<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
					<tr class="px4" >
						<td width="20%" align="center" valign="middle"><b>回复内容</b></td>
						<td width="20%" align="left" valign="middle">
							<textarea rows="5" cols="100%" id="content" name="content" placeholder="200字以内" maxlength="200"></textarea>
						</td>
					</tr>
					<tr class="px4" >
						<td width="20%" align="center" valign="middle"><b>图片上传</b></td>
						<td width="20%" align="left" valign="middle" colspan="3">
							<input type="file" name="commentFile" id = "commentFile" style="border:0px"/>
						</td>
					</tr>
					<tr class="px4" >
						<td width="100%" height="40" align="center" colspan="4">
							<input type="button" onclick="submit()" value="回复"/>
						</td>
					</tr>
				</table><p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>屏蔽理由</b></td>
					<td width="20%" align="left" valign="middle">
						<textarea rows="5" cols="100%" id="cancelDesc" name="cancelDesc" placeholder="200字以内" maxlength="200"></textarea>
					</td>
				</tr>
				<tr>
					<td width="100%" height="40" align="center" colspan="2">
						<a href="#" class="easyui-linkbutton" onclick="cancel()">屏  蔽</a>
						<a href="#" class="easyui-linkbutton" onclick="$('#cc').dialog('close')">关  闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</div>
</body>
</html>
