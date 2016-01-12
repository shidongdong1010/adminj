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
                title: '敏感词列表',
                align: 'center',
                url: '${ctx }/reso/sensitiveWord/sensitiveWordList.json',
                singleSelect: true,
                pagination: true,
                pageSize: 15,
                pageList: [15, 20, 30, 50, 100, 200],
                rowNumbers: true,
                striped: true,
                singleSelect: true,
                height: '460',
                width: 'auto',
                columns: [[
                    {
                        field: 'ck',
                        checkbox: true
                    }, {
                        field: 'word',
                        title: '敏感词',
                        align: 'center',
                        width: 120
                    }, {
                        field: 'mathType',
                        title: '匹配类型',
                        align: 'center',
                        width: 100,
                        formatter: function (value, row, index) {
                            if(value == '1'){
                                return "最小匹配";
                            }
                            return "最大匹配";
                        }
                    }, {
                        field: 'createDate',
                        title: '创建时间',
                        align: 'center',
                        width: 150,
                        formatter: function (value, row, index) {
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd hh:mm:ss");
                        }
                    }, {
                        field: 'updateDate',
                        title: '修改时间',
                        align: 'center',
                        width: 150,
                        formatter: function (value, row, index) {
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd hh:mm:ss");
                        }
                    }, {
                        field: 'isValid',
                        title: '状态',
                        align: 'center',
                        width: 80,
                        formatter: function (value, row, index) {
                            if (value == 'Y') {
                                return "启用";
                            } else {
                                return "无效";
                            }
                        }
                    }
                ]]
            });


            //查询按钮
            $("#queryBtn").click(function () {
                $('#dg').datagrid('load', {
                    word: $("#word").textbox("getValue"),
                    mathType: $("#mathType").combobox("getValue"),
                    isValid: $("#isValid").combobox("getValue")
                });
                return false;
            });

            // 添加的界面
            $('#addSensitiveWordView').dialog({
                title: '添加敏感词',
                width: 350,
                height: 180,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#addSensitiveWordForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#addSensitiveWordView').dialog('close');
                        return false;
                    }
                }]
            });

            // 添加按钮
            $("#addBtn").click(function () {
                $('#addSensitiveWordView').dialog("open");
                return false;
            });

            // 添加的提交事件
            $('#addSensitiveWordForm').form({
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "操作成功！", "info", function () {
                            $('#addSensitiveWordView').dialog('close'); // 关闭窗口
                            $("#queryBtn").trigger("click"); // 刷新页面
                            $('#addSensitiveWordForm').form('clear');	// 重置表单
                        });
                    } else {
                        $.messager.alert("操作提示", msg["msg"], "error");
                    }
                }
            });


            // 修改的界面
            $('#updateSensitiveWordView').dialog({
                title: '修改敏感词',
                width: 350,
                height: 170,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#updateSensitiveWordForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#updateSensitiveWordForm').form('clear'); // 重置表单
                        $('#updateSensitiveWordView').dialog('close');
                        return false;
                    }
                }]
            });

            // 修改按钮
            $("#updateBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                }

                $('#updateSensitiveWordView').dialog("open");

                $('#updateWordId').val(items[0]["wordId"]);
                $('#updateWord').textbox("setValue", items[0]["word"]);
                $('#updateMathType').combobox("setValue", items[0]["mathType"]);
                $('#updateIsValid').combobox("setValue", items[0]["isValid"]);
                return false;
            });

            // 修改的提交事件
            $('#updateSensitiveWordForm').form({
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "重置成功！", "info", function () {
                            $('#updateSensitiveWordView').dialog('close'); // 关闭窗口
                            $("#queryBtn").trigger("click"); // 刷新页面
                            $('#updateSensitiveWordForm').form('clear');	// 重置表单
                        });
                    } else {
                        $.messager.alert("操作提示", "重置失败", "error");
                    }
                }
            });


            //获取Items
            function getItems() {
                var checkedItems = $('#dg').datagrid('getChecked');
                var objects = [];
                $.each(checkedItems, function (index, item) {
                    objects.push(item);
                });
                return objects;
            }
        });

        //获取priNumber唯一ID
        function getPriNumber() {
            var checkedItems = $('#dg').datagrid('getChecked');
            var names = [];
            $.each(checkedItems, function (index, item) {
                names.push(item['priNumber']);
            });
            var priNumber = names.join(",");
            return priNumber;
        }

    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
        <div id="tb" style="padding:2px 5px;">
            敏感词 ： <input type="text" name="word" id="word" class="easyui-textbox" style="width:150px;"/>
            匹配类型：
            <select id="mathType" name="mathType" class="easyui-combobox" data-options="editable:false"
                         style="width:170px;">
                <option value="">全部</option>
                <option value="1">最小匹配</option>
                <option value="2">最大匹配</option>
            </select>
            状态：
            <select id="isValid" name="isValid" class="easyui-combobox" data-options="editable:false"
                    style="width:170px;">
                <option value="">全部</option>
                <option value="Y">有效</option>
                <option value="N">无效</option>
            </select>&nbsp;
            <a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
        </div>
    </div>

    <table id="dg">
    </table>

    <div style="text-align:right;padding:5px">
        <a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">新增</a>
        <a href="#" class="easyui-linkbutton" id="updateBtn" iconCls="icon-edit">修改</a>
    </div>
</div>
<div id="updateSensitiveWordView">
    <form id="updateSensitiveWordForm" method="post" action="${ctx }/reso/sensitiveWord/updateSensitiveWord.json">
        <input type="hidden" name="wordId" id="updateWordId"/>
        <table>
            <tbody>
            <tr>
                <th>敏感词</th>
                <td>
                    <input class="easyui-textbox" name="word" id="updateWord" data-options="required:true,disabled:true"/>
                </td>
            </tr>
            <tr>
                <th>匹配类型</th>
                <td>
                    <select class="easyui-combobox" name="mathType" id="updateMathType" data-options="required:true">
                        <option value="1">最小匹配</option>
                        <option value="2">最大匹配</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>是否有效</th>
                <td>
                    <select class="easyui-combobox" name="isValid" id="updateIsValid" data-options="required:true">
                        <option value="Y">有效</option>
                        <option value="N">无效</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div id="addSensitiveWordView">
    <form id="addSensitiveWordForm" method="post" action="${ctx }/reso/sensitiveWord/addSensitiveWord.json">
        <table>
            <tbody>
            <tr>
                <th>敏感词</th>
                <td>
                    <input class="easyui-textbox" name="word" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <th>匹配类型</th>
                <td>
                    <select class="easyui-combobox" name="mathType" data-options="required:true">
                        <option value="1">最小匹配</option>
                        <option value="2">最大匹配</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>是否有效</th>
                <td>
                    <select class="easyui-combobox" name="isValid" data-options="required:true">
                        <option value="Y">有效</option>
                        <option value="N">无效</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>