<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领导员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <div class="easyui-panel" title="航币兑换规则" style="padding:7px 10px; margin-bottom: 10px;">
        <form action="${ctx }/tactics/submitCoinConvertRule.html" method="post">
            航币数
            <input type="text" class="easyui-textbox" style="width:100px" name="coin" value="${coinConvertRule.coin}" />
                =
            人民币
            <input type="text" class="easyui-textbox" style="width:100px" name="rmb"  value="${coinConvertRule.rmb}"/>
            <input type="submit" value="确定" />
        </form>
    </div>
</div>
</body>
</html>
