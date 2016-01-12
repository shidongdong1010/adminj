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
                title: '兑换订单列表',
                align: 'center',
                url: '${ctx }/tactics/coinConvertOrderList.json',
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
                        field: 'orderNo',
                        title: '订单号',
                        align: 'center',
                        width: 150
                    },{
                        field: 'orderTime',
                        title: '订单时间',
                        align: 'center',
                        width: 130,
                        formatter: function(value,row,index){
                            var date = new Date();
                            date.setTime(value);
                            return date.Format("yyyy-MM-dd hh:mm:ss");
                        }
                    },{
                        field: 'orderStatus',
                        title: '订单状态',
                        align: 'center',
                        width: 120,
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "失败";
                            }
                            return "成功";
                        }
                    }, {
                        field: 'userId',
                        title: '用户ID',
                        align: 'center',
                        width: 100
                    }, {
                        field: 'userName',
                        title: '用户名',
                        align: 'center',
                        width: 100
                    }, {
                        field: 'userMobile',
                        title: '手机号码',
                        align: 'center',
                        width: 100
                    }, {
                        field: 'expressAddr',
                        title: '地址',
                        align: 'center',
                        width: 140
                    }, {
                        field: 'payCoin',
                        title: '航币',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'num',
                        title: '数量',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'status',
                        title: '状态',
                        align: 'center',
                        width: 80,
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "未确认";
                            }
                            return "已确认";
                        }
                    }
                ]]
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

            // 确认界面
            $('#makeCoinConvertOrderView').dialog({
                title: '确认',
                width: 450,
                height: 250,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#makeCoinConvertOrderForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $("#makeCoinConvertOrderForm").form('clear');   // 重置表单
                        $('#makeCoinConvertOrderView').dialog('close');
                        return false;
                    }
                }]
            });

            $('#makeCoinConvertOrderForm').form({
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "确认成功！", "info", function () {
                            $("#makeCoinConvertOrderForm").form('clear');   // 重置表单
                            $('#makeCoinConvertOrderView').dialog('close');
                            $('#dg').datagrid('load', {}); // 刷新页面
                        });
                    } else {
                        $.messager.alert("操作提示", "确认失败", "error");
                    }
                }
            });

            //重置密码按钮
            $("#makeBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                }
                if (items[0]["status"] == "1") {
                    $.messager.alert('温馨提示', '此已确认不能进行此操作！', "info");
                    return;
                }
                $('#makeCoinConvertOrderView').dialog("open");
                $("#makeCoinConvertOrderView input[name='id']").val(items[0]['id']);
                $("#makeCoinConvertOrderView input[name='expressNo']").val(items[0]['expressNo']);
                $("#makeCoinConvertOrderView input[name='expressNo']").textbox({});
                $("#makeCoinConvertOrderView input[name='expressType']").val(items[0]['expressType']);
                $("#makeCoinConvertOrderView input[name='expressType']").textbox({});
                $("#makeCoinConvertOrderView input[name='expressName']").val(items[0]['expressName']);
                $("#makeCoinConvertOrderView input[name='expressName']").textbox({});
                $("#makeCoinConvertOrderView input[name='expressAddr']").val(items[0]['expressAddr']);
                $("#makeCoinConvertOrderView input[name='expressAddr']").textbox({});
                $("#makeCoinConvertOrderView input[name='expressMobile']").val(items[0]['expressMobile']);
                $("#makeCoinConvertOrderView input[name='expressMobile']").textbox({});
                return false;
            });
        });
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <div class="easyui-panel" title="商品信息" style="padding:7px 10px; margin-bottom: 10px;">
        <div id="tb" style="padding:2px 5px;">
            <b>商品名称：</b> ${coinConvertGood.name}&nbsp;&nbsp;
            <b>有效期：</b> ${coinConvertGood.beginTime }至${coinConvertGood.endTime }&nbsp;&nbsp;
            <b>数量：</b> ${coinConvertGood.num}
        </div>
    </div>

    <table id="dg">
    </table>

    <div style="text-align:right;padding:5px">
        <a href="#" class="easyui-linkbutton" id="makeBtn" iconCls="icon-edit">确认</a>
    </div>
</div>

<div id="makeCoinConvertOrderView">
    <form id="makeCoinConvertOrderForm" method="post" action="${ctx }/tactics/makeCoinConvertOrder.json">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <th>快递单号:</th>
                <td>
                    <input type="text" name="expressNo" data-options="required:true"
                           style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <th>快递类型:</th>
                <td><input type="text" name="expressType" data-options="required:true"
                           style="width:300px;"/></td>
            </tr>
            <tr>
                <th>收件人姓名:</th>
                <td><input type="text" name="expressName" data-options="required:true"
                           style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <th>收件地址:</th>
                <td><input type="text" name="expressAddr" data-options="required:true"
                           style="width:300px;"/></td>
            </tr>
            <tr>
                <th>收件人手机:</th>
                <td><input type="text" name="expressMobile" data-options="required:true"
                           style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>