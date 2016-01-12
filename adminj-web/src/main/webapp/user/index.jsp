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
				title:'用户信息管理',
				align:'center',
				url:'${ctx }/user/list.json',
				singleSelect:true,
				pagination:true,
				pageSize:15,
				pageList:[15,20,30,50,100,200],
				rowNumbers: true,
				striped:true,
				singleSelect:true,
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
						field : 'userName',
						title : '用户名',
						align:'center',
						width : 100
					},{
						field : 'mobile',
						title : '绑定手机',
						align:'center',
						width : 100
					},{
						field : 'type',
						title : '会员类型',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value=='0'){
								return "内部";
							}else if(value=='1'){
								return "牛人";
							}else if(value=='2'){
								return "一般投资者";
							}
						}
					},{
						field : 'status',
						title : '账号状态',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value=='0'){
								return "正常";
							}else if(value=='1'){
								return "锁定";
							}else if(value=='2'){
								return "已删除";
							}
						}
					},{
						field : 'clientType',
						title : '客户端类型',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value=='0'){
								return "android";
							}else if(value=='1'){
								return "iOS";
							}
						}
					},{
						field : 'email',
						title : '邮箱',
						align:'center',
						width : 180
					},{
						field : 'userSource',
						title : '用户来源',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value=='0'){
								return "领航员";
							}else if(value=='1'){
								return "QQ";
							}else if(value=='2'){
								return "微信";
							}else if(value=='3'){
								return "新浪微博";
							}
						}
					},{
						field : 'ss',
						title : '操作',
						align:'center',
						width : 140,
						formatter: function(value,row,index){
							return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick=\"info('"+row['userId']+"');\">重置密码</a> ";
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					userName : $("#userName-query").textbox("getValue"),
					mobile : $("#mobile-query").textbox("getValue")
				});
				return false;
			});
			$("#restBtn").click(function(){
				var item =  $('#dg').datagrid('getChecked');
				if(item.length==1){
					info(item[0].userId);
				}else{
					$.messager.alert('提示', '请选择一条记录！', 'info');
				}
				
			});
			$("#addBtn").click(function(){
				showAdd();
			});
			$("#editBtn").click(function(){
				var item =  $('#dg').datagrid('getChecked');
				if(item.length==1){
					showEdit(item[0].userId);
				}else{
					$.messager.alert('提示', '请选择一条记录！', 'info');
				}
			});
			//初始化省份
			$('#provinceCode').combobox({
			    url:'${ctx }/sys/province/queryAll.json',
			    valueField:'provinceId',
			    textField:'provCnName',
			    onSelect: function(rec){
		            var url = '${ctx }/sys/city/queryByProvinceId.json?provinceId='+(rec==undefined?"9":rec.provinceId);
		            $('#cityCode').combobox('reload', url);
		        }
			});
		});
		function info(userId){
			$("#password-update").val("");
			$("#newPassword-update").val("");
			$("#userId").val(userId);
			$("#cc").show();
			$('#cc').dialog({
			    title: '操作',
			    width: 400,
			    height: 200,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		function submit(){
			var userId = $("#userId").val();
			var password = $("#password-update").val();
			var newPassword = $("#newPassword-update").val();
			if(password==''){
				$.messager.alert('提示', '请输入新密码！', 'info',function(){
					$("#password").focus();
				});
				return false;
			}
			if(newPassword==''){
				$.messager.alert('提示', '请确认新密码！', 'info',function(){
					$("#newPassword").focus();
				});
				return false;
			}
			if(password!=newPassword){
				$.messager.alert('提示', '两次密码输入不一致,请重新输入！', 'info',function(){
					$("#newPassword").focus();
				});
				return false;
			}
			$.post("${ctx }/user/restPwd.json",{userId:userId,password:password},function(data){
				if(data=='1'){
					$.messager.alert('提示', '密码重置成功！', 'info',function(){
						$('#cc').dialog('close');
					});
				}else{
					$.messager.alert('提示', '密码重置失败！', 'info');
				}
			});
		}
		function showAdd(){
			$('#provinceCode').combobox("select","9");
			$('#cityCode').combobox("select","901");
			clearAddDiv();
			$("#addDiv").show();
			$('#addDiv').dialog({
			    title: '添加用户',
			    width: 800,
			    height: 600,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		function showEdit(userId){
			clearAddDiv();
			$.post("${ctx }/user/edit.json",{userId:userId},function(data){
				var user = data.user;
				var userDetail = data.userDetail;
				var userStatRecord = data.userStatRecord;
				var userBacklist = data.userBacklist;

				$("#user_id").val(user.userId);
				$("#userName").textbox("setValue",user.userName);
				$("#password").textbox("setValue",user.password);
				$("#newPassword").textbox("setValue",user.password);
				$("#clientId").textbox("setValue",user.clientId);
				$("#mobile").textbox("setValue",user.mobile);
				$("#type").combobox("setValue",user.type);
				$("#status").combobox("setValue",user.status);
				$("#clientType").combobox("setValue",user.clientType);
				$("#pushSwitch").combobox("setValue",user.pushSwitch);
				$("#sailCurrency").textbox("setValue",user.sailCurrency);
				$("#level").textbox("setValue",user.level);
				$("#email").textbox("setValue",user.email);
				$("#userSource").combobox("setValue",user.userSource);
				$("#qq").textbox("setValue",user.qq);
				$("#weChat").textbox("setValue",user.weChat);
				$("#weibo").textbox("setValue",user.weibo);
				$("#openId").textbox("setValue",user.openId);
				$("#longitude").textbox("setValue",user.longitude);
				$("#latitude").textbox("setValue",user.latitude);
				$("#lastcity").textbox("setValue",user.lastcity);
				$("#nickName").textbox("setValue",userDetail.nickName);
				$("#sex").combobox("setValue",userDetail.sex);
				$("#age").textbox("setValue",userDetail.age);
				$("#companyDuties").combobox("setValue",userDetail.companyDuties);
				$("#resume").textbox("setValue",userDetail.resume);
				$("#signature").textbox("setValue",userDetail.signature);
				$("#dynamicNum").textbox("setValue",userStatRecord.dynamicNum);
				$("#attentionNum").textbox("setValue",userStatRecord.attentionNum);
				$("#followBuyNum").textbox("setValue",userStatRecord.followBuyNum);
				$("#friendsNum").textbox("setValue",userStatRecord.friendsNum);
				$("#groupNum").textbox("setValue",userStatRecord.groupNum);
				$("#tradeNum").textbox("setValue",userStatRecord.tradeNum);
				$("#loginNum").textbox("setValue",userStatRecord.loginNum);
				$("#talkNum").textbox("setValue",userStatRecord.followBuyNum);
				$("#orderNum").textbox("setValue",userStatRecord.orderNum);
				$("#forwardNum").textbox("setValue",userStatRecord.forwardNum);
				$("#praiseNum").textbox("setValue",userStatRecord.praiseNum);
				$("#commentNum").textbox("setValue",userStatRecord.commentNum);
				$("#shareNum").textbox("setValue",userStatRecord.shareNum);
				$("#coinNum").textbox("setValue",userStatRecord.coinNum);
				$("#replyBlacklist").combobox("setValue",userBacklist.replyBlacklist);
				$("#talkBlacklist").combobox("setValue",userBacklist.talkBlacklist);
				$("#showBlacklist").combobox("setValue",userBacklist.showBlacklist);
				var provinceCode =  userDetail.provinceCode;
				var cityCode = userDetail.cityCode;
				$('#provinceCode').combobox("select",provinceCode);
				$('#cityCode').combobox("select",cityCode);
				$("#addDiv").show();
				$('#addDiv').dialog({
				    title: '修改用户',
				    width: 800,
				    height: 600,
				    closed: false,
				    cache: false,
				    modal: true
				});
			});
			
		}
		function clearAddDiv(){
			$("#user_id").val("");
			$("#userName").textbox("setValue","");
			$("#password").textbox("setValue","");
			$("#newPassword").textbox("setValue","");
			$("#clientId").textbox("setValue","");
			$("#mobile").textbox("setValue","");
			$("#type").combobox("setValue","");
			$("#status").combobox("setValue","");
			$("#clientType").combobox("setValue","");
			$("#pushSwitch").combobox("setValue","");
			$("#sailCurrency").textbox("setValue","");
			$("#level").textbox("setValue","");
			$("#email").textbox("setValue","");
			$("#userSource").combobox("setValue","");
			$("#qq").textbox("setValue","");
			$("#weChat").textbox("setValue","");
			$("#weibo").textbox("setValue","");
			$("#openId").textbox("setValue","");
			$("#longitude").textbox("setValue","");
			$("#latitude").textbox("setValue","");
			$("#lastcity").textbox("setValue","");
			$("#nickName").textbox("setValue","");
			$("#sex").combobox("setValue","");
			$("#age").textbox("setValue","");
			$("#companyDuties").combobox("setValue","");
			$("#resume").textbox("setValue","");
			$("#signature").textbox("setValue","");
			$("#dynamicNum").textbox("setValue","");
			$("#attentionNum").textbox("setValue","");
			$("#followBuyNum").textbox("setValue","");
			$("#friendsNum").textbox("setValue","");
			$("#groupNum").textbox("setValue","");
			$("#tradeNum").textbox("setValue","");
			$("#loginNum").textbox("setValue","");
			$("#talkNum").textbox("setValue","");
			$("#orderNum").textbox("setValue","");
			$("#forwardNum").textbox("setValue","");
			$("#praiseNum").textbox("setValue","");
			$("#commentNum").textbox("setValue","");
			$("#shareNum").textbox("setValue","");
			$("#coinNum").textbox("setValue","");
			$("#replyBlacklist").combobox("setValue","");
			$("#talkBlacklist").combobox("setValue","");
			$("#showBlacklist").combobox("setValue","");
		}
		function add(){
			$.messager.progress();	
			$('#addForm').form('submit', {
				url: "${ctx }/user/add.json",
				onSubmit: function(){
					var isValid = $(this).form('validate');
					var password = $("#password").textbox("getValue");
					var newPassword = $("#newPassword").textbox("getValue");
					if (!isValid){
						$.messager.progress('close');	
					}else if(password!=newPassword){
						$.messager.alert('提示', '两次密码输入不一致,请重新输入！', 'info',function(){
							$("#newPassword").textbox("setValue","");
						});
						isValid = false;
						$.messager.progress('close');	
					} 
					return isValid;	
				},
				success: function(data){
					$.messager.progress('close');	
					if(data=='1'){
						$.messager.alert('提示', '用户添加成功！', 'info',function(){
							$('#addDiv').dialog('close');
							window.location = "${ctx }/user/index.html";
						});
					}else{
						$.messager.alert('提示', '用户添加失败！', 'info');
					}
				}
			});
		}
		
	</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
	<div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
		<div id="tb" style="padding:2px 5px;">
			用户名： <input type="text" name="userName-query" id="userName-query" class="easyui-textbox" style="width:200px;"/>
			绑定手机： <input type="text" name="mobile-query" id="mobile-query" class="easyui-textbox" style="width:200px;"/>
			&nbsp;
			<a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
		</div>
	</div>

	<table id="dg">
	</table>
	<div style="text-align:right;padding:5px">
		<a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">添加用户</a>
		<a href="#" class="easyui-linkbutton" id="editBtn" iconCls="icon-edit">修改用户</a>
		<a href="#" class="easyui-linkbutton" id="restBtn" iconCls="icon-edit">重置密码</a>
	</div>
	<!-- 查看 -->
	<div id ="cc" style="display: none">
		<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="userId" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">重置密码<br></td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>新密码：</b></td>
					<td width="20%" align="left" valign="middle"><input type="password" id="password-update" name="password-update"/></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>确认新密码：</b></td>
					<td width="20%" align="left" valign="middle"><input type="password" id="newPassword-update" name="newPassword-update"/></td>
				</tr>
			</table><p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" height="40" align="center">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submit()">提  交</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-no" onclick="$('#cc').dialog('close')">关  闭</a>
					</td>
				</tr>
			</table>
	</div>
	<!-- 添加 -->
	<div id ="addDiv" style="display: none">
		<form id="addForm" method="post" enctype="multipart/form-data">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="user_id" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">必填信息</td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>用户名：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3"><input type="text" id="userName" name="userName" data-options="required:true" class="easyui-textbox" style="width:200px;"/></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>密码：</b></td>
					<td width="20%" align="left" valign="middle"><input type="password" id="password" name="password" data-options="required:true" class="easyui-textbox" style="width:200px;"/></td>
					<td width="20%" align="center" valign="middle"><b>确认密码：</b></td>
					<td width="20%" align="left" valign="middle"><input type="password" id="newPassword" name="newPassword" data-options="required:true"  class="easyui-textbox" style="width:200px;"/></td>
				</tr>
			</table>
			<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="userId" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">其他信息</td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>客户端ID：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="clientId" name="clientId"  class="easyui-textbox" style="width:200px;"/></td>
					<td width="20%" align="center" valign="middle"><b>绑定手机：</b></td>
					<td width="20%" align="left" valign="middle"><input type="text" id="mobile" name="mobile"  class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'mobile'"  style="width:200px;"/></td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>会员类型：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="type" name="type" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="0">内部</option>
							<option value="1">牛人</option>
							<option value="2">一般投资者</option>
						</select>
					</td>
					<td width="20%" align="center" valign="middle"><b>账号状态：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="status" name=status class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="0">正常</option>
							<option value="1">锁定</option>
							<option value="2">已删除</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>客户端类型：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="clientType" name="clientType" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="0">android</option>
							<option value="1">iOS</option>
						</select>
					</td>
					<td width="20%" align="center" valign="middle"><b>推送设置：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="pushSwitch" name="pushSwitch" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="0">关</option>
							<option value="1">开</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>航币数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="sailCurrency" name="sailCurrency" class="easyui-numberbox"  data-options="min:0" style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>级别：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="level" name="level" class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>邮箱：</b></td>
					<td width="20%" align="left" valign="middle">
						<input id="email" name="email"  class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'email'"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>用户来源：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="userSource" name="userSource" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="0">领航员</option>
							<option value="1">QQ</option>
							<option value="2">微信</option>
							<option value="3">新浪微博</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>QQ号：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="qq" name="qq"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>微信号：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="weChat" name="weChat" class="easyui-textbox" style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>微博：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="weibo" name="weibo"  class="easyui-textbox" style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>第三方用户ID：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="openId" name="openId" class="easyui-textbox" style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>经度：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="longitude" name="longitude"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>纬度：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="latitude" name="latitude" class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>最后一次登录城市：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3">
						<input type="text" id="lastcity" name="lastcity"  class="easyui-textbox" style="width:200px;"/>
					</td>
				</tr>
			</table>
			<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="userId" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">用户简介</td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>昵称：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="nickName" name="nickName"  class="easyui-textbox" style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>性别：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="sex" name="sex" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="M">男</option>
							<option value="F">女</option>
							<option value="S">保密</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>年龄：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="age" name="age"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>公司职务：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="companyDuties" name="companyDuties" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="1">董事长</option>
							<option value="2">总裁</option>
							<option value="3">总经理</option>
							<option value="4">部门经理</option>
							<option value="5">员工</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>所在省份：</b></td>
					<td width="20%" align="left" valign="middle">
						<input id="provinceCode" name="provinceCode" style="width:200px;" >
					</td>
					<td width="20%" align="center" valign="middle"><b>所在城市：</b></td>
					<td width="20%" align="left" valign="middle">
						<input id="cityCode" name="cityCode" class="easyui-combobox" data-options="valueField:'cityId',textField:'cityName'" style="width:200px;">
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>上传头像：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3">
						<input class="easyui-filebox" name="headImgFile" data-options="prompt:'Choose a file...'" style="width:200px">
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>个性签名：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3">
						<input type="text" id="signature" name="signature"  class="easyui-textbox" style="width:400px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>个人简介 ：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3">
						<input type="text" id="resume" name="resume" class="easyui-textbox" style="width:400px;"/>
					</td>
				</tr>
				
				
			</table>
			<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="userId" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">用户统计记录</td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>动态数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="dynamicNum" name="dynamicNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>关注数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="attentionNum" name="attentionNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>跟买数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="followBuyNum" name="followBuyNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>好友数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="friendsNum" name="friendsNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>组合数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="groupNum" name="groupNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>交易数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="tradeNum" name="tradeNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>登陆数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="loginNum" name="loginNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>说说数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="talkNum" name="talkNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>晒单数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="orderNum" name="orderNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>转发数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="forwardNum" name="forwardNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>点赞数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="praiseNum" name="praiseNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>评论数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="commentNum" name="commentNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>分享数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="shareNum" name="shareNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
					<td width="20%" align="center" valign="middle"><b>打赏数：</b></td>
					<td width="20%" align="left" valign="middle">
						<input type="text" id="coinNum" name="coinNum"  class="easyui-numberbox" data-options="min:0"  style="width:200px;"/>
					</td>
				</tr>
			</table>
			<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: -10px;">
				<tr>
					<td width="20" height="25" class="biao">
						<input type="hidden" id="userId" name="userId"/>
						<img src="${ctx}/images/main/pic02.gif" width="20" height="11"><br>
					</td>
					<td class="biao">黑名单信息</td>
				</tr>
			</table>
			<table align="center" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="88B3E0" id="P1">
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>是否是评价回复黑名单：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="replyBlacklist" name="replyBlacklist" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
					</td>
					<td width="20%" align="center" valign="middle"><b>是否说说黑名单：</b></td>
					<td width="20%" align="left" valign="middle">
						<select id="talkBlacklist" name="talkBlacklist" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
					</td>
				</tr>
				<tr class="px4" >
					<td width="20%" align="center" valign="middle"><b>是否晒图黑名单：</b></td>
					<td width="20%" align="left" valign="middle" colspan="3">
						<select id="showBlacklist" name="showBlacklist" class="easyui-combobox" data-options="editable:false" style="width:200px;" >
							<option value="">请选择</option>
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
					</td>
				</tr>
			</table>
			<p></p>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%" height="40" align="center">
						<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="add()">保  存</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-no" onclick="$('#addDiv').dialog('close')">关  闭</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</div>
</body>
</html>
