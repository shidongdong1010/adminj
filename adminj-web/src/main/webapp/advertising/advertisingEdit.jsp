<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>领航员综合服务平台</title>
	<link href="../themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="../lang/zh-cn/zh-cn.js"></script>
	<%@ include file="/common/meta.jsp" %>
	<link href="${ctx}/css/main.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/js/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
	<link href="${ctx}/js/jquery-easyui/themes/icon.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/json2.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/validator.js"></script>
	<script type="text/javascript" src="${ctx}/js/ajaxLoading.js"></script>
	<script type="text/javascript" src="${ctx}/js/map.js"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
	<div class="bg1">
		<div align="center">
			<form id="addForm" method="post" class="easyui-form" action="${ctx }/advertising/insertAdvertising.json" enctype="multipart/form-data">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="16%" align="right">
									广告url:
								</td>
								<td width="34%">
									<input  type="hidden" name="advertisingId" id="advertisingId"  value="${advertisingInfo.advertisingId}"/>
									<input class="easyui-textbox" type="text" name="advertisingUrl" id="advertisingUrl" data-options="required:true"  style="width:400px;" maxlength="500" value="${advertisingInfo.advertisingUrl}"/>
									&nbsp;<font color="red" >*</font>
								</td>
							</tr>
							
							<tr class=px4>
								<td width="16%" align="right">
									广告logo:
								</td>
								<td width="34%">
									<input id="advertisingLogo" name="advertisingLogo" class="easyui-filebox" data-options="buttonText:'选择文件',onChange:changeAdvertisingImg" style="width:400px" value="${ctx}${advertisingInfo.advertisingLogo}"/>
									&nbsp;<font color="red">*</font>
									
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									广告logo预览:
								</td>
								<td width="34%">
									<div id="prizeTableImgDiv">
								        <img id="prizeTableImg"  style="width:100px;height:80px" src="${ctx}${advertisingInfo.advertisingLogo}"/>
								    </div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm();">提交</a>
	    		<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearForm()">重置</a> -->
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="javascript:window.location='${ctx }/advertising/advertisingList.html'">返回</a>
	    	</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
			function changeAdvertisingImg (){
				previewImage($("input[name='advertisingLogo']")[0], 'prizeTableImg', 'prizeTableImgDiv');
		    }
			function previewImage(fileObj, imgPreviewId, divPreviewId) {
				var allowExtention = ".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;  
				var extention = fileObj.value.substring(
						fileObj.value.lastIndexOf(".") + 1).toLowerCase();
				var browserVersion = window.navigator.userAgent.toUpperCase();
				if (allowExtention.indexOf(extention) > -1) {
					if (fileObj.files) {   //HTML5实现预览，兼容chrome、火狐7+等  
						if (window.FileReader) {
							var reader = new FileReader();
							reader.onload = function(e) {
								document.getElementById(imgPreviewId).setAttribute(
										"src", e.target.result);
							}
							reader.readAsDataURL(fileObj.files[0]);
						} else if (browserVersion.indexOf("SAFARI") > -1) {
							alert("不支持Safari6.0以下浏览器的图片预览!");
						}
					} else if (browserVersion.indexOf("MSIE") > -1) {
						if (browserVersion.indexOf("MSIE 6") > -1) {//ie6  
							document.getElementById(imgPreviewId).setAttribute("src",
									fileObj.value);
						} else {//ie[7-9]  
							fileObj.select();
							if (browserVersion.indexOf("MSIE 9") > -1)
								fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问  
							var newPreview = document.getElementById(divPreviewId
									+ "New");
							if (newPreview == null) {
								newPreview = document.createElement("div");
								newPreview.setAttribute("id", divPreviewId + "New");
								newPreview.style.width = document
										.getElementById(imgPreviewId).width
										+ "px";
								newPreview.style.height = document
										.getElementById(imgPreviewId).height
										+ "px";
								newPreview.style.border = "solid 1px #d2e2e2";
							}
							newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='"
									+ document.selection.createRange().text + "')";
							var tempDivPreview = document.getElementById(divPreviewId);
							tempDivPreview.parentNode.insertBefore(newPreview,
									tempDivPreview);
							tempDivPreview.style.display = "none";
						}
					} else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox  
						var firefoxVersion = parseFloat(browserVersion.toLowerCase()
								.match(/firefox\/([\d.]+)/)[1]);
						if (firefoxVersion < 7) {//firefox7以下版本  
							document.getElementById(imgPreviewId).setAttribute("src",
									fileObj.files[0].getAsDataURL());
						} else {//firefox7.0+                      
							document.getElementById(imgPreviewId).setAttribute("src",
									window.URL.createObjectURL(fileObj.files[0]));
						}
					} else {
						document.getElementById(imgPreviewId).setAttribute("src",
								fileObj.value);
					}
				} else {
					alert("仅支持" + allowExtention + "为后缀名的文件!");
					fileObj.value = "";//清空选中文件  
					if (browserVersion.indexOf("MSIE") > -1) {
						fileObj.select();
						document.selection.clear();
					}
					fileObj.outerHTML = fileObj.outerHTML;
				}
			}
			//提交按钮
			function submitForm() {
				$('#addForm').form('submit', {
					onSubmit : function() {
						var flag = $(this).form('enableValidation').form('validate')
						if(!flag){
							return false;
						}
						var url = $("#advertisingUrl").textbox("getValue");
						var logo = $("#advertisingLogo").textbox("getValue");
						
						return true;
					},
					 success:function(data){
						var msg = $.parseJSON(data);
						if(msg["code"]==200){
							$.messager.alert("操作提示", msg['data'],"info", function(){
				            	window.location = '${ctx }/advertising/advertisingList.html';
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
