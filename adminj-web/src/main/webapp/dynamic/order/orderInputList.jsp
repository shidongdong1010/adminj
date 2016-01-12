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
				title:'晒单信息录入',
				align:'center',
				url:'${ctx }/dynamic/orderInputList.json',
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
						field : 'user_name',
						title : '用户名',
						align:'center',
						width : 100
					},{
						field : 'title',
						title : '标题',
						align:'center',
						width : 150
					},{
						field : 'mark',
						title : '内容',
						align:'center',
						width : 350
					},{
						field : 'create_date',
						title : '创建日期',
						align:'center',
						width : 140
					},{
						field : 'isDel',
						title : '是否删除',
						align:'center',
						width : 80,
						formatter: function(value,row,index){
							if(value == 'Y'){
								return  "<span color='red'>是</span>";
							}else {
								return "否";
							}
						}
					},{
						field : '',
						title : '操作',
						align:'center',
						width : 140,
						formatter: function(value,row,index){
							return "<a href='${ctx }/dynamic/orderInput.html?dynamicId="+row['dynamic_id']+"'>录入</a>";
						}
					}
				]]
			});
			//查询按钮
			$("#queryBtn").click(function(){
				$('#dg').datagrid('load',{
					userName : $("#userName").textbox("getValue"),
					groupName : $("#groupName").textbox("getValue")
				});
				return false;
			});

			// 录入界面的设置
			$('#inputView').dialog({
				title: '修改角色',
				width: 500,
				height: 260,
				closed: true,
				cache: false,
				modal: true,
				buttons:[{
					text:'确定',
					handler:function(){
						$('#inputForm').submit();
						return false;
					}
				},{
					text:'取消',
					handler:function(){
						$('#inputForm').form('clear'); // 重置表单
						$('#inputView').dialog('close');
						return false;
					}
				}]
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
			用户名： <input type="text" name="title" id="userName" class="easyui-textbox" style="width:200px;"/>
			组合名称： <input type="text" name="title" id="groupName" class="easyui-textbox" style="width:200px;"/>
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
