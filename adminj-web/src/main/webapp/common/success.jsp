<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/header.jsp" %>
    <title>成功提示</title>
</head>
<script language="javascript">
    document.onkeydown = onQuery;
    function onQuery() {
        if (event.keyCode == 13) {
            goBack('${returnURL}');
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
</script>
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
                                                    src="${ctx}/images/main/success.png"></td>
                                            <td width="2%"></td>
                                            <c:if test="${empty successReason}">
                                                <td class="red" align="left" style="width:49%" height="30" valign="top">
                                                    操作成功！
                                                </td>
                                            </c:if>
                                            <c:if test="${!empty successReason}">
                                                <td class="red" align="left" style="width:49%" height="30"
                                                    valign="top">${successReason}</td>
                                            </c:if>
                                        </tr>
                                        <tr valign="baseline" align="center">
                                            <td></td>
                                            <td></td>
                                            <td height="50" align="left">
                                                <img src="${ctx}/images/button/fh.jpg" style="cursor: pointer"
                                                     onclick="javascript:goBack('${returnURL}');"/>
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
