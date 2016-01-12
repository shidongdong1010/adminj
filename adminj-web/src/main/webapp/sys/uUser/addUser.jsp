<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>领导员综合服务平台</title>
		<%@ include file="/common/header.jsp"%>
		<script type="text/javascript">
		//提交按钮
		function submitForm() {
			$('#ff').form('submit', {
				onSubmit : function() {
					var flag = $(this).form('enableValidation').form('validate')
					if(!flag){
						return false;
					}
					var password = $("#password").textbox("getValue");
					var password1 = $("#password1").textbox("getValue");
					if(password.length<6 || password.length>12){
						$.messager.alert('温馨提示',"密码的长度应在6-12位!","warning");
						document.all.newPsw.focus();
						return false;
					}
					if (trim(password) != trim(password1)) {
						$.messager.alert('温馨提示',"两次输入的密码不一致!","warning");
						document.all.newPsw2.focus();
						return false;
					}
					return true;
				},
				 success:function(data){
					var msg = $.parseJSON(data);
					if(msg['code'] == 200){
						$.messager.alert("操作提示", msg['msg'],"info", function(){
			            	window.location = '${ctx }/sys/uUser/userList.html';
						});
					}else{
						$.messager.alert("操作提示", msg['msg'],"error");
					}
		        }
			});
		}
		</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="28" height="27">
					<img src="${pageContext.request.contextPath}/images/main/pic01.gif"
						width="28" height="27">
				</td>
				<td bgcolor="EFF6FE" class="text">
					当前位置：用户管理&gt; 新增用户
				</td>
			</tr>
		</table>

		<form id="ff" action="${ctx }/sys/uUser/addUser.json" class="easyui-form" method="post" data-options="novalidate:true">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="16%" align="right">
									登陆名：
								</td>
								<td width="34%">
									<input type="text" name="userName" id="userName"  class="easyui-textbox" data-options="required:true" style="width:300px;"/>
									&nbsp;
									<font color="red">*</font>
								</td>
								<td width="16%" align="right">
									姓名：
								</td>
								<td width="34%">
									<input type="text" name="fullname" id="fullname" class="easyui-textbox" data-options="required:true" style="width:300px;"/>
									&nbsp;
									<font color="red">*</font>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									密码：
								</td>
								<td width="34%">
									<input type="password" name="password" id="password"  class="easyui-textbox" data-options="required:true" style="width:300px;"/>
									&nbsp;
									<font color="red">*</font>
								</td>
								<td width="16%" align="right">
									工号：
								</td>
								<td width="34%">
									<input type="text" name="jobNo" id="jobNo"  class="easyui-textbox" data-options="required:true" style="width:300px;"/>
									&nbsp;
									<font color="red">*</font>
								</td>
								
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									重新输入密码：
								</td>
								<td width="34%">
									<input type="password" name="password1" id="password1" class="easyui-textbox" data-options="required:true" style="width:300px;"/>
									&nbsp;
									<font color="red">*</font>
								</td>
								<td width="16%" align="right">
									移动电话：
								</td>
								<td width="34%">
									<input type="text" name="mobile" id="mobile" class="easyui-textbox"  style="width:300px;"/>
									&nbsp;
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									状态：
								</td>
								<td width="34%" colspan="3">
									<label><input name="isEnable" type="radio" value="0" class="easyui-radio" checked="checked"/>启用</label>&nbsp;&nbsp;&nbsp;&nbsp;
									<label><input name="isEnable" type="radio" value="1" class="easyui-radio" />禁用 </label>&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="red">*</font>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									是否锁定：
								</td>
								<td width="34%" colspan="3">
									<label><input name="isLocked" type="radio" value="0" class="easyui-radio" checked="checked"/>正常</label>&nbsp;&nbsp;&nbsp;&nbsp;
									<label><input name="isLocked" type="radio" value="1" class="easyui-radio" />锁定</label>&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="red">*</font>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									用户角色：
								</td>
								<td width="34%" colspan="3">
									<c:forEach items="${allrolelist}" var="role">
										<span style="width: 160px; display: block; float: left;">
											<input name="roleId" id="roleId${role.id}" type="checkbox" value="${role.id}" class="easyui-checkbox" />
											<label for="roleId${role.id}">${role.name}</label>
										</span>
									</c:forEach>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm();">提交</a>
	    		<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearForm()">重置</a> -->
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="javascript:window.location='${ctx }/sysmanager/queryuserInit.do'">返回</a>
	    	</div>
		</form>
	</body>
</html>
