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
				title:'反馈意见列表',
				align:'center',
				url:'${ctx }/feedBack/feedBackDataList.json',
				singleSelect:true,
				pagination:true,
				pageSize:10,
				pageList:[10,15,20,30,50,100,200],
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
						title : '用户名称',
						align:'center',
						width : 140
					},{
						field : 'contect',
						title : '反馈内容',
						align:'center',
						width : 400
					},{
						field : 'createTime',
						title : '创建日期',
						align:'center',
						width : 140,
						formatter: function(value,row,index){
							var date = new Date();
							date.setTime(value);
							return date.Format("yyyy-MM-dd hh:mm:ss");
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					userName : $("#userName").textbox("getValue")
				});
				return false;
			});
		});
	</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
	<div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
		<div id="tb" style="padding:2px 5px;">
			用户名： <input type="text" name="userName" id="userName" class="easyui-textbox" style="width:200px;"/>
			<a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
		</div>
	</div>

	<table id="dg">
	</table>
</div>
</body>
</html>
