<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>领导员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <link href="${ctx}/css/xwcss.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        document.onkeydown = onQuery;
        function onQuery() {
            if (event.keyCode == 13) {
                submitForm();
            }
        }
        function changeSty(id) {
            var imgID, imgSrc;
            //鼠标移到提交按钮上
            if (id == "s") {
                imgID = "smtBtn";
                imgSrc = "${contextPath}/images/main/img_04-2.gif";
            }
            //鼠标离开提交按钮
            if (id == "sm") {
                imgID = "smtBtn";
                imgSrc = "${contextPath}/images/main/img_04.gif";
            }
            //鼠标移到取消按钮
            if (id == "c") {
                imgID = "cleBtn";
                imgSrc = "${contextPath}/images/main/img_05-2.gif";
            }
            //鼠标离开取消按钮
            if (id == "cm") {
                imgID = "cleBtn";
                imgSrc = "${contextPath}/images/main/img_05.gif";
            }
            document.getElementById(imgID).src = imgSrc;
        }

        function submitForm() {
            var arrname = new Array("userName", "password");
            var array = new Array("用户名", "密码");

            var result = isnull(arrname, array);
            if (result != "") {
                alert(result);
                return;
            }
            document.forms[0].target = "_self";
            document.forms[0].submit();
        }

        function resetForm() {
            setElementValue(null, "userName", "");
            setElementValue(null, "password", "");
        }

        function init() {
            document.getElementById("userName").focus();
        }

        //
        var url = window.location.href;
        var url2 = window.parent.location.href;
        if (url.indexOf("login.html") != -1 && url2 != url) {
            window.parent.location = "login.html?error=1";
        }
    </script>
</head>
<body class="login_bg" scroll="no">
<form action="${ctx }/j_spring_security_check" name="loginForm" method="post">
    <!--登录页面-->
    <div class="lg-area">
        <div class="logo">
            <%--<img src="images/logo.png" border="0" width="950px">--%>
            <h1>LOGO</h1>
        </div>
        <div class="submit-up">
            <div class="ipt"><i class="user"></i> <input type="text" id="userName" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" placeholder="用户名">
            </div>
            <div class="ipt"><i class="pw"></i> <input type="password" id="password" name="j_password" placeholder="密码">
            </div>
            <div class="btn"><a href="#" onclick="submitForm()">登陆</a></div>
        </div>
        <div style="color: red;">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>
        <div class="cpr">©2015epaybank.com All rights reserved<br>
            版权所有：XXXXXX有限公司
        </div>
    </div>
    <!--登录页面-->
</form>
</body>
</html>
