<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>领导员综合服务平台</title>
		<%@ include file="/common/header.jsp"%>
		<link href="${ctx}/js/jquery-easyui/default.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx }/js/jquery-easyui/outlook2.js"></script>
		<script type="text/javascript">
			// 加载菜单
			var _menus = {
				menus : []
			};
			
			$.ajax({
				url : "${ctx }/treeMenu/tree.json",
				type : "post",
				async : false,
				dataType : "json",
				success : function(data) {
					if (data) {
						$.each(data, function(i, n) {
							if(n.isLeaf == null || n.isLeaf != "1"){
								_menus.menus.push({
									"menuid" : n.id,
									"icon" : "icon-sys",
									"menuname" : n.name,
									"menus" : []
								});
							}
						});
						$.each(data, function(i, n) {
							if(n.isLeaf != null && n.isLeaf == "1"){
								var parentMenu = findMenu(n.parentId);
								if(parentMenu != null && parentMenu.menus != null){
									parentMenu.menus.push({
										"menuid" : n.id,
										"menuname" : n.name,
										"icon" : "icon-nav",
										"url" : n.url
									});
								}
							}
						});
					}
				},
				error : function(e) {
					//alert(e);
				}
			});

	        $(function() {
	            // 修改密码
	            $('#editpass').click(function() {
					$('#updateUserPwdView').dialog('open');
	                return false;
	            });

	        	// 退出登陆
	            $('#loginOut').click(function() {
	                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
	                    if (r) {
	                    	window.location = '/j_spring_security_logout';
	                    }
	                });
	                return false;
	            });

				// 修改密码弹框
				$('#updateUserPwdView').dialog({
					title: '修改密码',
					width: 350,
					height: 180,
					closed: true,
					cache: false,
					modal: true,
					buttons: [{
						text: '确定',
						handler: function () {
							$('#updateUserPwdForm').submit();
							return false;
						}
					}, {
						text: '取消',
						handler: function () {
							$('#updateUserPwdForm').form('clear'); // 重置表单
							$('#updateUserPwdView').dialog('close');
							return false;
						}
					}]
				});

				// 修改密码提交事件
				$('#updateUserPwdForm').form({
					onSubmit: function () {
						var flag = $(this).form('enableValidation').form('validate');
						if (!flag) {
							return flag;
						}
						var newPsw = $("#password").textbox("getValue");
						var newPsw2 = $("#password2").textbox("getValue");
						if (newPsw.length < 6 || newPsw.length > 12) {
							$.messager.alert('温馨提示', "密码的长度应在6-12位!", "warning");
							document.all.newPsw.focus();
							return false;
						}
						if (trim(newPsw) != trim(newPsw2)) {
							$.messager.alert('温馨提示', "两次输入的密码不一致!", "warning");
							document.all.newPsw2.focus();
							return false;
						}
					},
					success: function (data) {
						var msg = $.parseJSON(data);
						if (msg["code"] == 200) {
							$.messager.alert("操作提示", "修改成功！", "info", function () {
								$('#updateUserPwdView').dialog('close'); // 关闭窗口
								$('#updateUserPwdForm').form('clear'); // 重置表单
							});
						} else {
							$.messager.alert("操作提示", msg["msg"], "error");
						}
					}
				});
			});

	        function doChoice(url, menuId, tabTitle){
        		addTab(tabTitle, url);
        	}
    	</script>
	</head>
	<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
		<noscript>
			<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
			    <img src="${ctx }/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
			</div>
		</noscript>
		
		<div region="north" split="true" border="false" style="overflow: hidden; height: 70px;
	        background: url(${ctx }/images/top/bg01.gif) #7f99be repeat-x center 50%;
	        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
	        <span style="float:right; padding-right:20px;" class="head">
	        	您好:<sec:authentication property="principal.fullname"/>
	        	<a href="#" id="editpass">修改密码</a>
	        	<a href="#" id="loginOut">安全退出</a>
	        </span>
	        <span style="padding-left:10px; font-size: 16px; ">
				<H1>LOGO</H1>
				<!--
	        	<img src="${ctx }/images/top/APS-LOGO.gif" align="absmiddle" />
	        	-->
	        </span>
	    </div>
	    <div region="south" split="true" style="height: 30px; background: #D2E0F2; text-align: center;">
	        <div class="footer">Copyright ◎2011 版权所有 XXXXXX有限公司</div>
	    </div>
	    <div region="west" split="true" title="导航菜单" style="width:200px; " id="west">
			<div class="easyui-accordion" fit="true" border="false">
			</div>
	    </div>
	    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden;">
	        <div id="tabs" class="easyui-tabs" fit="true" border="false" >
				<div title="欢迎使用" id="home">
					<iframe scrolling="auto" frameborder="0" src="${ctx }/treeMenu/viewMain.do" style="width:100%;height:100%;"></iframe>
				</div>
			</div>
	    </div>

		<!-- 修改密码 -->
		<div id="updateUserPwdView">
			<form id="updateUserPwdForm" style=" margin-top: 10px;" action="${ctx }/sys/uUser/updateUserPwd.json" method="post">
				<input type="hidden" name="userId" id="userId" value="<sec:authentication property="principal.userId"/>"/>
				<table>
					<tbody>
					<tr>
						<th style="width: 90px; text-align: right;">原密码</th>
						<td><input type="password" name="oldPassword" style="width: 200px;" id="oldPassword" class="easyui-textbox" data-options="prompt:'Password', required:true"></td>
					</tr>
					<tr>
						<th style="width: 90px; text-align: right;">新密码</th>
						<td><input type="password" name="password" style="width: 200px;" id="password" class="easyui-textbox" data-options="prompt:'Password', required:true"></td>
					</tr>
					<tr>
						<th style="width: 90px; text-align: right;">确认密码</th>
						<td><input type="password" name="password2" style="width: 200px;" id="password2" class="easyui-textbox" data-options="prompt:'Password', required:true"></td>
					</tr>
					</tbody>
				</table>
			</form>
		</div>

		<div id="mm" class="easyui-menu" style="width:150px;">
			<div id="mm-tabclose">关闭</div>
			<div id="mm-tabcloseall">全部关闭</div>
			<div id="mm-tabcloseother">除此之外全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">当前页右侧全部关闭</div>
			<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">退出</div>
		</div>
	</body>
</html>