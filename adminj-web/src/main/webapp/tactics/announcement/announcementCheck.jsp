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
	
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
	<div class="bg1">
		<div align="center">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<table id="myTable" align="center" width="98%" border="0"
							cellpadding="2" cellspacing="1" bgcolor="88B3E0">
							<tr class=px4>
								<td width="16%" align="right">
									公告标题:
								</td>
								<td width="84%">
									${announcementInfo.announcementTitle}
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告标语:
								</td>
								<td width="84%">
									${announcementInfo.announcementLogo}
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告logo:
								</td>
								<td width="84%">
									<img id="prizeTableImg"  style="width:100px;height:80px" src="${ctx}${announcementInfo.announcementUrl}"/>
								</td>
							</tr>
							<tr class=px4>
								<td width="16%" align="right">
									公告内容:
								</td>
								<td width="84%">
									${announcementInfo.announcementDesc}
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div style="text-align:center;padding:5px">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back" onclick="javascript:window.location='${ctx }/announcement/announcementList.html'">返回</a>
	    	</div>
		</div>
	</div>
</body>
</html>
