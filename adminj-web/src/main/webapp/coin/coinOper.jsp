<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>领航员综合服务平台</title>
	<%@ include file="/common/header.jsp"%>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
	<div class="bg1">
		<div align="center">
			
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<form id="form1" method="post" class="easyui-form" action="${ctx }/coin/editCoin.json">
						<input id="index" name="index" value="1" type="hidden"/>
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="100%" align="left" colspan="4">
									<h4>用户账户相关送航币规则</h4>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									注册:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="registNum" id="registNum" data-options="required:true,precision:1"  style="width:100px;"
											value="${regist.coinNum}"/> 个
								</td>
								<td width="16%" align="right">
									推荐好友下载:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="recoFrienNum" id="recoFrienNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${recofrien.coinNum}"/> 个
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									上传头像:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="uploadPhotosNum" id="uploadPhotosNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${uploadphotos.coinNum}"/> 个
								</td>
								<td width="16%" align="right">
									完善账户信息:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="perfectInfoNum" id="perfectInfoNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${perfectinfo.coinNum}"/> 个
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									实名认证:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="verifiedNum" id="verifiedNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${verified.coinNum}"/> 个
								</td>
								<td width="16%" align="right">
									绑定银行卡:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="bindBankCardNum" id="bindBankCardNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${bindbankcard.coinNum}"/> 个
								</td>
							</tr>
							<tr class=px4>
								<td width="100%" align="right" colspan="4">
									<div style="text-align:center;padding:5px">
							    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm1();">保存</a>
							    	</div>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr>
					<td class="bg1">
						<form id="form2" method="post" class="easyui-form" action="${ctx }/coin/editCoin.json">
						<input id="index" name="index" value="2" type="hidden"/>
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="100%" align="left" colspan="4">
									<h4>用户活跃赠送航币规则</h4>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									说说:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="postedTalkNum" id="postedTalkNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${postedtalk.coinNum}"/> 个
								</td>
								<td width="16%" align="right">
									提问:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="askNum" id="askNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${ask.coinNum}"/> 个
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									晒单:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="showOrderNum" id="showOrderNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${showorder.coinNum}"/> 个
								</td>
								<td width="16%" align="right">
									操作:
								</td>
								<td width="34%">
									<input class="easyui-numberbox" type="text" name="operatingNum" id="operatingNum" data-options="required:true,precision:1"  style="width:100px;"
										value="${operating.coinNum}"/> 个
								</td>
							</tr>
							<tr class=px4>
								<td width="100%" align="right" colspan="4">
									<div style="text-align:center;padding:5px">
							    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm2();">保存</a>
							    	</div>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr>
					<td class="bg1">
						<form id="form3" method="post" class="easyui-form" action="${ctx }/coin/editCoin.json">
						<input id="index" name="index" value="3" type="hidden"/>
						<table id="logoTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="100%" align="left" colspan="4">
									<h4>用户登录赠送航币规则</h4>
								</td>
							</tr>
							<tr class=px4>
								<td width="100%" align="center" colspan="3">
									
									<div style="padding:5px;" >
										<table id="myTable" align="center" width="60%" 
											cellpadding="0" cellspacing="0" style="border:1px #88B3E0 solid;">
											<tr class=px4>
												<th width="50%" align="center" bgcolor="88B3E0" valign="middle">
													连续登录天数范围
												</th>
												<th width="30%" align="center" bgcolor="88B3E0" valign="middle">
													每天增长航币
												</th>
												<th width="20%" align="center" bgcolor="88B3E0" valign="middle">
													操作
												</th>
											</tr>
											<tbody id="inputLogoTbody">
											<c:choose>
												<c:when test="${flag==1}">
													<c:forEach items="${userSailCoinRuleLoginList}" var="userSailCoinRuleLogin"  varStatus="index">
														<tr >
															<td width="50%" align="center" style="padding:5px;" >
																第 <input class="easyui-textbox day" type="text" name="fromDay" id="fromDay" data-options="required:true"  style="width:100px;"
																	value="${userSailCoinRuleLogin.minDay}"/> 天 - 第
																 <input class="easyui-textbox day1" type="text" name="toDay" id="toDay" style="width:100px;"
																 	value="${userSailCoinRuleLogin.maxDay}"/> 天
															</td>
															<td width="30%" align="center" style="padding:5px;" >
																<input class="easyui-numberbox" type="text" name="coinNum" id="coinNum" data-options="required:true,precision:1"  style="width:100px;" 
																	value="${userSailCoinRuleLogin.coinNum}"/> 个
															</td>
															<td width="20%" align="center" style="padding:5px;" >
															<c:choose>
																<c:when test="${index.first}">
																	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" id="addBtn"></a>
																</c:when>
																<c:otherwise>
																	<a href="javascript:void(0)" class="easyui-linkbutton delBtn" iconCls="icon-remove">${i}</a>
																</c:otherwise>
															</c:choose>
															</td>
														</tr>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<tr >
														<td width="50%" align="center" style="padding:5px;" >
															第 <input class="easyui-textbox day" type="text" name="fromDay" id="fromDay" data-options="required:true"  style="width:100px;"/> 天 - 第
															 <input class="easyui-textbox day1" type="text" name="toDay" id="toDay" style="width:100px;"/> 天
														</td>
														<td width="30%" align="center" style="padding:5px;" >
															<input class="easyui-numberbox" type="text" name="coinNum" id="coinNum" data-options="required:true,precision:1"  style="width:100px;" /> 个
														</td>
														<td width="20%" align="center" style="padding:5px;" >
															<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" id="addBtn"></a>
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</table>
										
									</div>
									
								</td>
							</tr>
							<tr class=px4>
								<td width="100%" align="right" colspan="4">
									<div style="text-align:center;padding:5px">
							    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm3();">保存</a>
							    	</div>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
	    $(".day").textbox('textbox').bind('keyup', function(e){
	    	$(this).val($(this).val().replace(/[^1-9]/g,''));
	    });
	    
	    $(".day1").textbox('textbox').bind('keyup', function(e){
	    	$(this).val($(this).val().replace(/[^1-9]/g,''));
	    });
	    
	 	// 添加一行数据
	    $("table").on("click", "#addBtn", function(){
	        addLogoTableTr($(this));
	        return false;
	    });
	 	
	 // 删除一行数据
        $("table").on("click", ".delBtn", function(){
             $(this).parents("tr").first().remove();
            return false;
        });
	 	function addLogoTableTr(target){
	 		var tr = $('<tr >'+
	 		'<td width="50%" align="center" style="padding:5px;" >第 <input class="easyui-textbox day" type="text" name="fromDay" id="fromDay" data-options="required:true"  style="width:100px;"/> 天 - 第 <input class="easyui-textbox day" type="text" name="toDay" id="toDay" style="width:100px;"/> 天</td>'+
	 		'<td width="30%" align="center" style="padding:5px;" ><input class="easyui-numberbox" type="text" name="coinNum" id="coinNum" data-options="required:true,precision:1"  style="width:100px;" /> 个</td>'+
	 		'<td width="20%" align="center" style="padding:5px;" ><a href="javascript:void(0)" class="easyui-linkbutton delBtn" iconCls="icon-remove"></a></td>'+
	 		'</tr>');
            var tbody = target.parents("tbody").first();
            tbody.append(tr);
            // 重新渲染easyui组件
            $.parser.parse(tr);
	 	}
	});
	
	$.extend($.fn.validatebox.defaults.rules, {  
	    alpha:{  
	        validator:function(value,param){  
	            if (value){  
	                return /^[a-zA-Z\u00A1-\uFFFF]*$/.test(value);  
	            } else {  
	                return true;  
	            }  
	        },  
	        message:'只能输入字母.'  
	    },  
	    alphanum:{  
	        validator:function(value,param){  
	            if (value){  
	                return /^([a-zA-Z\u00A1-\uFFFF0-9])*$/.test(value);  
	            } else {  
	                return true;  
	            }  
	        },  
	        message:'只能输入字母和数字.'  
	    },  
	    positive_int:{  
	        validator:function(value,param){  
	            if (value){  
	                return /^[0-9]*[1-9][0-9]*$/.test(value);  
	            } else {  
	                return true;  
	            }  
	        },  
	        message:'只能输入正整数.'  
	    },  
	    numeric:{  
	        validator:function(value,param){  
	            if (value){  
	                return /^[0-9]*(\.[0-9]+)?$/.test(value);  
	            } else {  
	                return true;  
	            }  
	        },  
	        message:'只能输入数字.'  
	    },  
	    chinese:{  
	        validator:function(value,param){  
	        if (value){  
	             return /[^\u4E00-\u9FA5]/g.test(value);  
	        } else {  
	            return true;  
	        }  
	    },  
	    message:'只能输入中文'  
	}  
	          
	});  
		//保存按钮1
		function submitForm1() {
			$('#form1').form('submit', {
				onSubmit : function() {
					var flag = $(this).form('enableValidation').form('validate')
					if(!flag){
						return false;
					}
					return true;
				},
				 success:function(data){
					var msg = $.parseJSON(data);
					if(msg["code"]==200){
						$.messager.alert("操作提示", msg['data'],"info", function(){
			            	window.location = '${ctx }/coin/coinInfo.html';
						});
					}else{
						$.messager.alert("操作提示", msg['data'],"error");
					}
		        }
			});
		}
		
		//保存按钮2
		function submitForm2() {
			$('#form2').form('submit', {
				onSubmit : function() {
					var flag = $(this).form('enableValidation').form('validate')
					if(!flag){
						return false;
					}
					return true;
				},
				 success:function(data){
					var msg = $.parseJSON(data);
					if(msg["code"]==200){
						$.messager.alert("操作提示", msg['data'],"info", function(){
			            	window.location = '${ctx }/coin/coinInfo.html';
						});
					}else{
						$.messager.alert("操作提示", msg['data'],"error");
					}
		        }
			});
		}
		
		//保存按钮3
		function submitForm3() {
			$('#form3').form('submit', {
				onSubmit : function() {
					var flag = $(this).form('enableValidation').form('validate')
					if(!flag){
						return false;
					}
					return true;
				},
				 success:function(data){
					var msg = $.parseJSON(data);
					if(msg["code"]==200){
						$.messager.alert("操作提示", msg['data'],"info", function(){
			            	window.location = '${ctx }/coin/coinInfo.html';
						});
					}else{
						$.messager.alert("操作提示", msg['data'],"error");
					}
		        }
			});
		}
	</script>
</body>
</html>
