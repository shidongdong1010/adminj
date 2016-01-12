<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/header.jsp" %>
    <title>系统错误提示</title>
    <script language="javascript">
        document.onkeydown = onQuery;
        function onQuery() {
            if (event.keyCode == 13) {
                goBack();
            }
        }
        function goBack(returnUrl) {
            if (isObjNull(returnUrl)) {
                history.back(-1);
            } else {
                if (returnUrl.indexOf("/") != 0) {
                    returnUrl = "/" + returnUrl;
                }
                document.location = "${ctx}" + returnUrl;
            }
        }
        function relogin() {
            var parent = window.parent;
            for (; parent != top;) {
                parent = parent.parent;
            }
            top.location = "logon.do?method=reLogin"
        }
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="28" height="27"><img src="${ctx}/images/main/pic01.gif" width="28" height="27"></td>
        <td bgcolor="EFF6FE" class="text"> 当前位置：操作结果提示</td>
    </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td class="bg1">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                   bgcolor="819CB9">
                <tr>
                    <td bgcolor="#FFFFFF">
                        <table width="100%" border="0" cellspacing="0" cellpadding="8">
                            <tr>
                                <td bgcolor="EFF6FE">
                                    <table width="98%" border="0" align="center" cellpadding="0" height="200"
                                           cellspacing="0">
                                        <tr valign="baseline" align="center">
                                            <td height="20"></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr valign="baseline" align="center">
                                            <td align="right" valign="baseline" style="width:49%" height="30"><img
                                                    src="${ctx}/images/main/error.png"></td>
                                            <td width="2%"></td>
                                            <td class="red" align="left" style="width:49%" height="30" valign="top">
                                                对不起！您的操作失败了，错误原因如下：
                                            </td>
                                        </tr>
                                        <tr valign="baseline" align="center">
                                            <td></td>
                                            <td></td>
                                            <td align="left" class="red">
                                                ${reason }
                                                <c:if test="${!empty ex }">
                                                    ${ex }
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr valign="baseline" align="center">
                                            <td></td>
                                            <td></td>
                                            <td height="50" align="left">
                                                <img src="${ctx}/images/button/fh.jpg" style="cursor: pointer"
                                                     onclick="javascript:goBack('${returnURL}');">
                                            </td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
