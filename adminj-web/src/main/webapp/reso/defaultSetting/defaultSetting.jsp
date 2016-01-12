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
                url: '${ctx}/reso/defaultSetting.json',
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
                        field: 'code',
                        title: '代码',
                        align: 'center',
                        width: 200,
                        editor: {
                            type: 'textbox',
                            required: true
                        }
                    }, {
                        field: 'value',
                        title: '默认值',
                        align: 'left',
                        width: 200,
                        editor: {
                            type: 'textbox',
                            required: true
                        }
                    }, {
                        field: 'desc',
                        title: '说明',
                        align: 'center',
                        width: 350,
                        editor: {
                            type: 'textbox'
                        }
                    }
                ]]
            });

        });

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
                for (var i = 0; i < updated.length; i++) {
                    updated[i]['action'] = 'update';
                    rows.push(updated[i]);
                }
                for (var i = 0; i < inserted.length; i++) {
                    inserted[i]['action'] = 'insert';
                    rows.push(inserted[i]);
                }
                for (var i = 0; i < deleted.length; i++) {
                    deleted[i]['action'] = 'delete';
                    rows.push(deleted[i]);
                }
                if (rows.length <= 0) {
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
                url: "${ctx }/reso/saveDefaultSetting.json",
                data: JSON.stringify(rows),//将对象序列化成JSON字符串
                dataType: "json",
                contentType: 'application/json;charset=utf-8', //设置请求头信息
                success: function (msg) {
                    if (msg['code'] == 200) {
                        $.messager.alert("操作提示", msg['msg'], "info");
                    } else {
                        $.messager.alert("操作提示", msg['msg'], "error");
                    }
                },
                error: function (res) {
                }
            });
        }
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <form action="${ctx }/reso/saveDefaultSetting.json" method="POST" id="batchForm">
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
