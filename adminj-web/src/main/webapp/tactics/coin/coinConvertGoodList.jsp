<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领航员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                title: '商品列表',
                align: 'center',
                url: '${ctx }/tactics/coinConvertGoodList.json',
                singleSelect: true,
                pagination: true,
                pageSize: 15,
                pageList: [15, 20, 30, 50, 100, 200],
                rowNumbers: true,
                striped: true,
                singleSelect: true,
                height: '460',
                width: 'auto',
                frozenColumns: [[
                    {
                        field: 'ck',
                        checkbox: true
                    }
                ]],
                columns: [[
                    {
                        field: 'name',
                        title: '名称',
                        align: 'center',
                        width: 200
                    }, {
                        field: 'beginTime',
                        title: '开始时间',
                        align: 'center',
                        width: 140,
                        formatter: function (value, row, index) {
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd hh:mm:ss");
                        }
                    }, {
                        field: 'endTime',
                        title: '结束时间',
                        align: 'center',
                        width: 140,
                        formatter: function (value, row, index) {
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd hh:mm:ss");
                        }
                    }, {
                        field: 'coin',
                        title: '航币',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'num',
                        title: '数量',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'summary',
                        title: '商品简介',
                        align: 'center',
                        width: 200
                    }, {
                        field: 'isEnable',
                        title: '状态',
                        align: 'center',
                        width: 140,
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "正常";
                            }
                            return "已下架";
                        }
                    }, {
                        field: 'f',
                        title: '操作',
                        align: 'center',
                        width: 100,
                        formatter: function (value, row, index) {
                            return "<a href='${ctx }/tactics/updateCoinConvertGood.html?id=" + row['id'] + "'>修改</a>"
                            + "&nbsp;<a href='${ctx }/tactics/coinConvertOrderList.html?id=" + row['id'] + "'>查看</a>";
                        }
                    }
                ]]
            });
            //查询按钮
            $("#queryBtn").click(function () {
                $('#dg').datagrid('load', {
                    name: $("#name").textbox("getValue"),
                    isEnable: $("#isEnable").combobox("getValue")
                });
                return false;
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
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <div class="easyui-panel" title="查询条件" style="padding:7px 10px; margin-bottom: 10px;">
        <div id="tb" style="padding:2px 5px;">
            名称： <input type="text" name="name" id="name" class="easyui-textbox" style="width:200px;"/>
            状态：
            <select id="isEnable" name="isEnable" class="easyui-combobox" data-options="editable:false" style="width:170px;">
                <option value="">全部</option>
                <option value="0">正常</option>
                <option value="1">已下架</option>
            </select>&nbsp;
            <a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
        </div>
    </div>

    <table id="dg">
    </table>

    <div style="text-align:right;padding:5px">
        <a href="${ctx }/tactics/addCoinConvertGood.html" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">新增</a>
    </div>
</div>
</body>
</html>