<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>领航员综合服务平台</title>
	<link href="${ctx}/js/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/js/umeditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/umeditor/lang/zh-cn/zh-cn.js"></script>
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
	<style type="text/css">
        h1{
            font-family: "微软雅黑";
            font-weight: normal;
        }
        .btn {
            display: inline-block;
            *display: inline;
            padding: 4px 12px;
            margin-bottom: 0;
            *margin-left: .3em;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            cursor: pointer;
            background-color: #f5f5f5;
            *background-color: #e6e6e6;
            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
            background-repeat: repeat-x;
            border: 1px solid #cccccc;
            *border: 0;
            border-color: #e6e6e6 #e6e6e6 #bfbfbf;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            border-bottom-color: #b3b3b3;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
            *zoom: 1;
            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn:hover,
        .btn:focus,
        .btn:active,
        .btn.active,
        .btn.disabled,
        .btn[disabled] {
            color: #333333;
            background-color: #e6e6e6;
            *background-color: #d9d9d9;
        }

        .btn:active,
        .btn.active {
            background-color: #cccccc \9;
        }

        .btn:first-child {
            *margin-left: 0;
        }

        .btn:hover,
        .btn:focus {
            color: #333333;
            text-decoration: none;
            background-position: 0 -15px;
            -webkit-transition: background-position 0.1s linear;
            -moz-transition: background-position 0.1s linear;
            -o-transition: background-position 0.1s linear;
            transition: background-position 0.1s linear;
        }

        .btn:focus {
            outline: thin dotted #333;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .btn.active,
        .btn:active {
            background-image: none;
            outline: 0;
            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn.disabled,
        .btn[disabled] {
            cursor: default;
            background-image: none;
            opacity: 0.65;
            filter: alpha(opacity=65);
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }
    </style>
	
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
	<div class="bg1">
		<div align="center">
			<form id="addForm" method="post" class="easyui-form" action="${ctx }/announcement/insertAnnouncement.json" enctype="multipart/form-data">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="16%" align="right">
									公告标题:
								</td>
								<td width="34%">
									<input  type="hidden" name="announcementId" id="announcementId"  value="${announcementInfo.announcementId}" />
									<input class="easyui-textbox" type="text" name="announcementTitle" id="announcementTitle" data-options="required:true"  style="width:400px;" maxlength="65" value="${announcementInfo.announcementTitle}"/>
									&nbsp;<font color="red" >*</font>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告标语:
								</td>
								<td width="34%">
									<input type="easyui-textbox" name="announcementLogo" id="announcementLogo"  class="easyui-textbox" data-options="required:true" style="width:400px;" maxlength="65" value="${announcementInfo.announcementLogo}"/>
									&nbsp;<font color="red">*</font>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告logo:
								</td>
								<td width="34%">
									<input id="announcementUrl" name="announcementUrl" class="easyui-filebox" data-options="buttonText:'选择文件',onChange:changeAnnouncementImg" style="width:400px" value="${ctx}${announcementInfo.announcementUrl}"/>
									&nbsp;<font color="red">*</font>
									
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告logo预览:
								</td>
								<td width="34%">
									<div id="prizeTableImgDiv">
								        <img id="prizeTableImg"  style="width:100px;height:80px" src="${ctx}${announcementInfo.announcementUrl}"/>
								    </div>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告内容:
								</td>
								<td width="34%">
									<script type="text/plain" id="announcementDesc" name="announcementDesc" style="width:900px;height:240px;">${announcementInfo.announcementDesc}</script>&nbsp;<font color="red" >*</font>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm();">提交</a>
	    		<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearForm()">重置</a> -->
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="javascript:window.location='${ctx }/announcement/announcementList.html'">返回</a>
	    	</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
			//实例化编辑器
			var um = UM.getEditor('announcementDesc');
			UM.getEditor('announcementDesc').setContent('${announcementInfo.announcementDesc}');
			um.addListener('blur',function(){
			    $('#focush2').html('编辑器失去焦点了')
			});
			um.addListener('focus',function(){
			    $('#focush2').html('')
			});
			//按钮的操作
			function insertHtml() {
			    var value = prompt('插入html代码', '');
			    um.execCommand('insertHtml', value)
			}
			function isFocus(){
			    alert(um.isFocus())
			}
			function doBlur(){
			    um.blur()
			}
			function createEditor() {
			    enableBtn();
			    um = UM.getEditor('announcementDesc');
			}
			function getAllHtml() {
			    alert(UM.getEditor('announcementDesc').getAllHtml())
			}
			function getContent() {
			    var arr = [];
			    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			    arr.push("内容为：");
			    arr.push(UM.getEditor('announcementDesc').getContent());
			    alert(arr.join("\n"));
			}
			function getPlainTxt() {
			    var arr = [];
			    arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			    arr.push("内容为：");
			    arr.push(UM.getEditor('announcementDesc').getPlainTxt());
			    alert(arr.join('\n'))
			}
			function setContent(isAppendTo) {
			    var arr = [];
			    arr.push("使用editor.setContent('欢迎使用umeditor')方法可以设置编辑器的内容");
			    UM.getEditor('announcementDesc').setContent('欢迎使用umeditor', isAppendTo);
			    alert(arr.join("\n"));
			}
			function setDisabled() {
			    UM.getEditor('announcementDesc').setDisabled('fullscreen');
			    disableBtn("enable");
			}
			
			function setEnabled() {
			    UM.getEditor('announcementDesc').setEnabled();
			    enableBtn();
			}
			
			function getText() {
			    //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			    var range = UM.getEditor('announcementDesc').selection.getRange();
			    range.select();
			    var txt = UM.getEditor('announcementDesc').selection.getText();
			    alert(txt)
			}
			
			function getContentTxt() {
			    var arr = [];
			    arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			    arr.push("编辑器的纯文本内容为：");
			    arr.push(UM.getEditor('announcementDesc').getContentTxt());
			    alert(arr.join("\n"));
			}
			function hasContent() {
			    var arr = [];
			    arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			    arr.push("判断结果为：");
			    arr.push(UM.getEditor('announcementDesc').hasContents());
			    alert(arr.join("\n"));
			}
			function setFocus() {
			    UM.getEditor('announcementDesc').focus();
			}
			function deleteEditor() {
			    disableBtn();
			    UM.getEditor('announcementDesc').destroy();
			}
			function disableBtn(str) {
			    var div = document.getElementById('btns');
			    var btns = domUtils.getElementsByTagName(div, "button");
			    for (var i = 0, btn; btn = btns[i++];) {
			        if (btn.id == str) {
			            domUtils.removeAttributes(btn, ["disabled"]);
			        } else {
			            btn.setAttribute("disabled", "true");
			        }
			    }
			}
			function enableBtn() {
			    var div = document.getElementById('btns');
			    var btns = domUtils.getElementsByTagName(div, "button");
			    for (var i = 0, btn; btn = btns[i++];) {
			        domUtils.removeAttributes(btn, ["disabled"]);
			    }
			}
			function changeAnnouncementImg (){
				previewImage($("input[name='announcementUrl']")[0], 'prizeTableImg', 'prizeTableImgDiv');
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
						var title = $("#announcementTitle").textbox("getValue");
						var logo = $("#announcementLogo").textbox("getValue");
						var content = UM.getEditor('announcementDesc').getContent();
						if(content == "" || content==null){
							$.messager.alert('温馨提示',"公告内容不能为空!","warning");
							return false;
						}
						return true;
					},
					 success:function(data){
						var msg = $.parseJSON(data);
						if(msg["code"]==200){
							$.messager.alert("操作提示", msg['data'],"info", function(){
				            	window.location = '${ctx }/announcement/announcementList.html';
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
