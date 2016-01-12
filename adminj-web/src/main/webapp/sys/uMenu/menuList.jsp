<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领导员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                title: '${sysName}菜单管理',
                align: 'center',
                url: '${ctx}/sys/uMenu/menuList.json',
                pagination: false,
                striped: true,
                singleSelect: true,
                height: '460',
                width: 'auto',
                toolbar: '#tb',
                queryParams: {
                    parentId: 0
                },
                onClickCell: onClickCell,
                columns: [[
                    {
                        field: 'ck',
                        checkbox: true
                    }, {
                        field: 'id',
                        title: '菜单Id',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'name',
                        title: '菜单名',
                        align: 'left',
                        width: 150,
                        editor: {
                            type: 'textbox',
                            required: true
                        }
                    }, {
                        field: 'url',
                        title: '菜单路径',
                        align: 'center',
                        width: 350,
                        editor: {
                            type: 'textbox'
                        }
                    }, {
                        field: 'sort',
                        title: '排序',
                        align: 'left',
                        width: 80,
                        editor: {
                            type: 'numberbox',
                            required: true
                        }
                    }, {
                        field: 'isEnable',
                        title: '状态',
                        align: 'center',
                        width: 80,
                        formatter: function (value, row, index) {
                            if (value == '0') {
                                return "启用";
                            }
                            return "禁用";
                        },
                        editor: {
                            type: 'checkbox',
                            required: true,
                            options: {on: '0', off: '1'}
                        }
                    }, {
                        field: '11',
                        title: '操作',
                        align: 'center',
                        width: 100,
                        formatter: function (value, row, index) {
                            var html = "";
                            if (row["isLeaf"] == '0') {
                                html += "<a href='javascript:void(0)' onclick=\"getChildrenMenuInfo(\'" + row['id'] + "\');\">子菜单</a>";
                            }
                            if (row["level"] != '1') {
                                html += "<a href='javascript:void(0)' onclick=\"getChildrenMenuInfo('0');\">上一级</a>";
                            }
                            return html;
                        }
                    }
                ]]
            });

        });

        /** 加载子菜单 **/
        function getChildrenMenuInfo(meunId) {
            $("#pId").val(meunId);
            $('#dg').datagrid('load', {
                parentId: meunId
            });
            return false;
        }

        /** 加载上级菜单 **/
        function getChildrenMenuInfo(meunId) {
            $("#pId").val(meunId);
            $('#dg').datagrid('load', {
                parentId: meunId
            });
            return false;
        }

        var editIndex = undefined;

        function endEditing() {
            if (editIndex == undefined) {
                return true
            }
            if ($('#dg').datagrid('validateRow', editIndex)) {
                //var ed = $('#dg').datagrid('getEditor', {index: editIndex, field: 'isEnable'});
                // var value = $(ed.target).combobox('getValue');
                //$('#dg').datagrid('getRows')[editIndex]['isEnable'] = value;
                $('#dg').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        }

        function onClickCell(index, field) {
            if (editIndex != index) {
                if (endEditing()) {
                    $('#dg').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                    var ed = $('#dg').datagrid('getEditor', {index: index, field: field});
                    if (ed) {
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    $('#dg').datagrid('selectRow', editIndex);
                }
            }
        }

        function append() {
            if (endEditing()) {
                $('#dg').datagrid('appendRow', {status: 'P'});
                editIndex = $('#dg').datagrid('getRows').length - 1;
                $('#dg').datagrid('selectRow', editIndex)
                        .datagrid('beginEdit', editIndex);
            }
        }

        function removeit() {
            if (editIndex == undefined) {
                return
            }
            $('#dg').datagrid('cancelEdit', editIndex)
                    .datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }

        function accept() {
            if (endEditing()) {
                //saveData(row);
                // 获得变动的行 inserted,deleted,updated
                //var rows = $('#dg').datagrid('getChanges');
                var updated = $('#dg').datagrid('getChanges', 'updated');
                var inserted = $('#dg').datagrid('getChanges', 'inserted');
                var deleted = $('#dg').datagrid('getChanges', 'deleted');
                var rows = [];
                for(var i = 0; i < updated.length; i++){
                    updated[i]['action'] = 'update';
                    rows.push(updated[i]);
                }
                for(var i = 0; i <inserted.length; i++){
                    inserted[i]['action'] = 'insert';
                    inserted[i]['parentId'] = $("#pId").val();
                    rows.push(inserted[i]);
                }
                for(var i = 0; i < deleted.length; i++){
                    deleted[i]['action'] = 'delete';
                    rows.push(deleted[i]);
                }
                if(rows.length <= 0){
                    return false;
                }
                saveData(rows);
            }
            return false;
        }

        function reject() {
            $('#dg').datagrid('rejectChanges');
            editIndex = undefined;
        }

        function saveData(rows) {
            $.ajax({
                type: "POST",
                url: "${ctx }/sys/uMenu/saveMenu.json",
                data: JSON.stringify(rows),//将对象序列化成JSON字符串
                dataType:"json",
                contentType : 'application/json;charset=utf-8', //设置请求头信息
                success: function(msg){
                    if (msg['code'] == 200) {
                        $.messager.alert("操作提示", msg['msg'], "info");
                    } else {
                        $.messager.alert("操作提示", msg['msg'], "error");
                    }
                },
                error: function(res){
                }
            });
        }
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <form action="${ctx }/sys/uMenu/batchUpdateMenu.json" method="POST" id="batchForm">
        <table id="dg">
        </table>

        <div id="tb" style="height:auto">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
               onclick="append()">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
               onclick="removeit()">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
               onclick="accept()">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
               onclick="reject()">撤销</a>
        </div>

        <input type="hidden" name="pId" id="pId" value="0"/>
        <input type="hidden" name="psysCode" id="psysCode" value="${sysCode}"/>
        <input type="hidden" name="psysName" id="psysName" value="${sysName}"/>
    </form>

</div>
</body>
</html>