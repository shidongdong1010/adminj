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
				title:'公告列表',
				align:'center',
				url:'${ctx }/announcement/announcementDataList.json',
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
						field : 'announcementTitle',
						title : '标题',
						align:'center',
						width : 400
					},{
						field : 'announcementLogo',
						title : '标语',
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
					},{
						field : 'isDel',
						title : '是否删除',
						align:'center',
						width : 200,
						formatter: function(value,row,index){
							if(value == '0'){
								return  "<font color='red'>已删除</font>";
							}else {
								return "未删除";
							}
						}
					},{
						field : '',
						title : '操作',
						align:'center',
						width : 200,
						formatter: function(value,row,index){
							return "<a href='${ctx }/announcement/checkAnnouncement.html?announcementId="+row['announcementId']+"'>预览</a>";
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					announcementTitle : $("#announcementTitle").textbox("getValue"),
					isDel:$("#isDel").combobox("getValue")
				});
				return false;
			});

			//新增按钮				
			$("#addBtn").click(function(){
				window.location = "${ctx }/announcement/toinsertAnnouncement.html";
				return false;
			});
			
			//修改按钮
			$("#updateBtn").click(function(){
				var items = getItems();
				if(items == null || items.length == 0){
					$.messager.alert('温馨提示','亲，请先选择一条记录再进行操作！',"info");
					return;
				} else {
					if(items[0]["isDel"]=='0'){
						$.messager.alert('温馨提示','记录已删除，不能修改。',"info");
						return;
					}
					window.location = "${ctx}/announcement/preUpdateAnnouncement.html?announcementId=" + items[0]['announcementId'];
				}
				return false;
			});
			
			//删除按钮
			$("#deleteBtn").click(function(){
				var items = getItems();
				if(items == null || items.length == 0){
					$.messager.alert('温馨提示','亲，请先选择一条记录再进行操作！',"info");
					return;
				} else {
					if(items[0]["isDel"]=='0'){
						$.messager.alert('温馨提示','记录已删除。',"info");
						return;
					}
					$.messager.confirm('确认提示', '确定要删除记录吗？', function(r){
						if(r){
							var url = "${ctx}/announcement/delAnnouncement.json";
							$.post(url,{announcementId:items[0]['announcementId']}, function(data){
								if(data){
									if(data["code"]==200){
										$.messager.alert("操作提示", data['data'],"info", function(){
											$("#queryBtn").click();
										});
									}else{
										$.messager.alert("操作提示", data['data'],"error");
									}
								}
							}, "json");
						}
					});
				}
				return false;
			});

			//获取Items
			function getItems(){
				var checkedItems = $('#dg').datagrid('getChecked');
				var objects = [];
				$.each(checkedItems, function(index, item){
					objects.push(item);
				});
				return objects;
			}
		});
	</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
	<div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
		<div id="tb" style="padding:2px 5px;">
			标题： <input type="text" name="announcementTitle" id="announcementTitle" class="easyui-textbox" style="width:200px;"/>
			状态：
			<select id="isDel" name="isDel" class="easyui-combobox" data-options="editable:false" style="width:170px;" >
				<option value="">全部</option>
				<option value="0">已删除</option>
				<option value="1">未删除</option>
			</select>&nbsp;
			<a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
		</div>
	</div>

	<table id="dg">
	</table>

	<div style="text-align:right;padding:5px">
		<a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">新增</a>
		<a href="#" class="easyui-linkbutton" id="updateBtn" iconCls="icon-edit">修改</a>
		<a href="#" class="easyui-linkbutton" id="deleteBtn" iconCls="icon-remove">删除</a>
	</div>
</div>
</body>
</html>
