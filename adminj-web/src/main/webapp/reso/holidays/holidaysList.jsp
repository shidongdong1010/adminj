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
                title: '节假日列表',
                align: 'center',
                url: '${ctx }/reso/holidays/holidaysList.json',
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
                        field: 'year',
                        title: '年份',
                        align: 'center',
                        width: 120
                    }, {
                        field: 'holidays',
                        title: '节假日',
                        align: 'center',
                        width: 100,
                        formatter: function (value, row, index) {
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd");
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
                    year: $("#year").textbox("getValue"),
                    holidays: $("#holidays").textbox("getValue"),
                    isValid: $("#isValid").combobox("getValue")
                });
                return false;
            });

            // 添加的界面
            $('#addHolidaysView').dialog({
                title: '添加节假日',
                width: 350,
                height: 150,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#addHolidaysForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#addHolidaysView').dialog('close');
                        return false;
                    }
                }]
            });

            // 添加按钮
            $("#addBtn").click(function () {
                $('#addHolidaysView').dialog("open");
                return false;
            });

            // 添加的提交事件
            $('#addHolidaysForm').form({
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "操作成功！", "info", function () {
                            $('#addHolidaysView').dialog('close'); // 关闭窗口
                            $("#queryBtn").trigger("click"); // 刷新页面
                            $('#addHolidaysForm').form('clear');	// 重置表单
                        });
                    } else {
                        $.messager.alert("操作提示", msg["msg"], "error");
                    }
                }
            });


            // 修改的界面
            $('#updateHolidaysView').dialog({
                title: '添加节假日',
                width: 350,
                height: 150,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#updateHolidaysForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#updateHolidaysForm').form('clear'); // 重置表单
                        $('#updateHolidaysView').dialog('close');
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

                $('#updateHolidaysView').dialog("open");

                $('#updateHolidaysId').val(items[0]["holidaysId"]);
                var date = new Date();
                date.setTime(items[0]["holidays"]);
                $('#updateHolidays').textbox("setValue", date.Format("yyyy-MM-dd"));
                $('#updateIsValid').combobox("setValue", items[0]["isValid"]);
                return false;
            });

            // 修改的提交事件
            $('#updateHolidaysForm').form({
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "操作成功！", "info", function () {
                            $('#updateHolidaysView').dialog('close'); // 关闭窗口
                            $("#queryBtn").trigger("click"); // 刷新页面
                            $('#updateHolidaysForm').form('clear');	// 重置表单
                        });
                    } else {
                        $.messager.alert("操作提示", msg["msg"], "error");
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

        function myformatter(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
        }
        function myparser(s) {
            if (!s) return new Date();
            var ss = (s.split('-'));
            var y = parseInt(ss[0], 10);
            var m = parseInt(ss[1], 10);
            var d = parseInt(ss[2], 10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
                return new Date(y, m - 1, d);
            } else {
                return new Date();
            }
        }
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
        <div id="tb" style="padding:2px 5px;">
            年份： <input type="text" name="year" id="year" class="easyui-textbox" style="width:150px;"/>
            节假日 ： <input type="text" name="holidays" id="holidays" class="easyui-textbox" style="width:150px;"/>
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
<div id="updateHolidaysView">
    <form id="updateHolidaysForm" method="post" action="${ctx }/reso/holidays/updateHolidays.json">
        <input type="hidden" name="holidaysId" id="updateHolidaysId"/>
        <table>
            <tbody>
            <tr>
                <th>节假日</th>
                <td>
                    <input class="easyui-textbox" name="holidays" id="updateHolidays" data-options="disabled:true">
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
<div id="addHolidaysView">
    <form id="addHolidaysForm" method="post" action="${ctx }/reso/holidays/addHolidays.json">
        <table>
            <tbody>
            <tr>
                <th>节假日</th>
                <td>
                    <input class="easyui-datebox" name="holidays"
                           data-options="formatter:myformatter,parser:myparser,required:true"/>
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