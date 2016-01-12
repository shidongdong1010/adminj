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
                title: '用户列表',
                align: 'center',
                url: '${ctx }/sys/uUser/userList.json',
                singleSelect: true,
                pagination: true,
                pageSize: 15,
                pageList: [15, 20, 30, 50, 100, 200],
                rownumbers: true,
                striped: true,
                singleSelect: true,
                height: '460',
                width: 'auto',
                queryParams: {
                    ordertype: $("#ordertype").combobox("getValue")
                },
                frozenColumns: [[
                    {
                        field: 'ck',
                        checkbox: true
                    },
                    {
                        field: 'userName',
                        title: '登陆名',
                        align: 'center',
                        width: 120
                    }, {
                        field: 'fullname',
                        title: '姓名',
                        align: 'center',
                        width: 100
                    }, {
                        field: 'jobNo',
                        title: '工号',
                        align: 'center',
                        width: 90
                    }
                ]],
                columns: [[
                    {
                        field: 'mobile',
                        title: '手机',
                        align: 'center',
                        width: 150
                    }, {

                        field: 'isLocked',
                        title: '是否锁定',
                        align: 'center',
                        width: 80,
                        formatter: function (value, row, index) {
                            if (value == '0') {
                                return "未锁定";
                            } else {
                                return "已锁定";
                            }
                        }
                    }, {
                        field: 'isEnable',
                        title: '状态',
                        align: 'center',
                        width: 80,
                        formatter: function (value, row, index) {
                            if (value == '0') {
                                return "启用";
                            } else {
                                return "禁用";
                            }
                        }
                    }
                ]]
            });


            //查询按钮
            $("#queryBtn").click(function () {
                $('#dg').datagrid('load', {
                    userName: $("#username").textbox("getValue"),
                    fullname: $("#fullname").textbox("getValue"),
                    jobNo: $("#jobno").textbox("getValue"),
                    ordertype: $("#ordertype").combobox("getValue")
                });
                return false;
            });

            $('#modifypassView').dialog({
                title: '重置密码',
                width: 350,
                height: 250,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        $('#modifypassForm').submit();
                        return false;
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#modifypassForm').form('clear'); // 重置表单
                        $("#newPsw").textbox("setValue", "");
                        $("#newPsw2").textbox("setValue", "");
                        $('#modifypassView').dialog('close');
                        return false;
                    }
                }]
            });

            //重置密码按钮
            $("#modifypassBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                }
                if (items[0]["deleteFlag"] == "1") {
                    $.messager.alert('温馨提示', '此用户已注销不能进行此操作！', "info");
                    return;
                }
                $('#modifypassView').dialog("open");
                $("#mUserName").textbox("setValue", items[0]['userName']);
                $("#mFullname").textbox("setValue", items[0]['fullname']);
                $("#modifypassForm input[name='userId']").val(items[0]['id']);
                return false;
            });

            $('#modifypassForm').form({
                onSubmit: function () {
                    var flag = $(this).form('enableValidation').form('validate');
                    if (!flag) {
                        return flag;
                    }
                    var newPsw = $("#newPsw").textbox("getValue");
                    var newPsw2 = $("#newPsw2").textbox("getValue");
                    if (newPsw.length < 6 || newPsw.length > 12) {
                        $.messager.alert('温馨提示', "密码的长度应在6-12位!", "warning");
                        document.all.newPsw.focus();
                        return false;
                    }
                    if (trim(newPsw) != trim(newPsw2)) {
                        $.messager.alert('温馨提示', "两次输入的密码不一致!", "warning");
                        document.all.newPsw2.focus();
                        return false;
                    }
                },
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg["code"] == 200) {
                        $.messager.alert("操作提示", "重置成功！", "info", function () {
                            $('#modifypassView').dialog('close'); // 关闭窗口
                            $("#queryBtn").trigger("click"); // 刷新页面
                            $('#modifypassForm').form('clear'); // 重置表单
                            $("#newPsw").textbox("setValue", "");
                            $("#newPsw2").textbox("setValue", "");
                        });
                    } else {
                        $.messager.alert("操作提示", "重置失败", "error");
                    }
                }
            });


            $('#cancelUserView').dialog({
                title: '注销',
                width: 0,
                height: 0,
                closed: true,
                cache: false,
                modal: true
            });

            //注销按钮
            $("#deleteconfigBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                } else {
                    if (items[0]["isEnable"] == "1") {
                        $.messager.alert('温馨提示', '此用户已注销不能进行此操作！', "info");
                        return;
                    }
                    $.messager.confirm('确认提示', '确定要注销此用户的信息吗？', function (r) {
                        if (r) {
                            $.post("${ctx }/sys/uUser/deleteUser.json", {userId: items[0]['id']}, function(data){
                                if (data["code"] == 200) {
                                    $.messager.alert("操作提示", "注销成功！", "info", function (data) {
                                        $("#queryBtn").trigger("click"); // 刷新页面
                                    });
                                } else {
                                    $.messager.alert("操作提示", "注销失败", "error");
                                }
                            }, "json");
                        }
                    });
                }
                return false;
            });

            // 锁定按钮
            $("#lockconfigBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                } else {
                    var m = "确定要锁定此用户吗";
                    if (items[0]["isLocked"] == "1") {
                        m = "该用户已锁定，确定要解锁此用户吗？";
                    }
                    $.messager.confirm('确认提示', m, function (r) {
                        if (r) {
                            $.post("${ctx }/sys/uUser/lockUser.json", {userId: items[0]['id']}, function(data){
                                if (data["code"] == 200) {
                                    $.messager.alert("操作提示", "操作成功！", "info", function (data) {
                                        $("#queryBtn").trigger("click"); // 刷新页面
                                    });
                                } else {
                                    $.messager.alert("操作提示", "操作失败", "error");
                                }
                            }, "json");
                        }
                    });
                }
                return false;
            });

            //新增按钮
            $("#addBtn").click(function () {
                window.location = "${ctx }/sys/uUser/addUser.html";
                return false;
            });

            //修改按钮
            $("#updateBtn").click(function () {
                var items = getItems();
                if (items == null || items.length == 0) {
                    $.messager.alert('温馨提示', '亲，请先选择一条记录再进行操作！', "info");
                    return;
                } else {
                    if (items[0]["isEnable"] == "1") {
                        $.messager.alert('温馨提示', '此用户已注销不能进行此操作！', "info");
                        return;
                    }
                    window.location = "${ctx}/sys/uUser/updateUser.html?userId=" + items[0]['id'];
                }
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
            登陆名： <input type="text" name="username" id="username" class="easyui-textbox" style="width:150px;"/>
            用户姓名： <input type="text" name="fullname" id="fullname" class="easyui-textbox" style="width:150px;"/>
            用户工号： <input type="text" name="jobno" id="jobno" class="easyui-textbox" style="width:150px;"/>
            排序：
            <select id="ordertype" name="ordertype" class="easyui-combobox" data-options="editable:false"
                    style="width:170px;">
                <option value="CREATE_TIME">创建日期</option>
                <option value="DELETE_FLAG,IS_ENABLE">状态</option>
            </select>&nbsp;
            <a href="#" class="easyui-linkbutton" id="queryBtn" iconCls="icon-search">查询</a>
        </div>
    </div>

    <table id="dg">
    </table>

    <div style="text-align:right;padding:5px">
        <a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">新增</a>
        <a href="#" class="easyui-linkbutton" id="updateBtn" iconCls="icon-edit">修改</a>
        <a href="#" class="easyui-linkbutton" id="modifypassBtn">重置密码</a>
        <a href="#" class="easyui-linkbutton" id="deleteconfigBtn">注销</a>
        <a href="#" class="easyui-linkbutton" id="lockconfigBtn">锁定</a>
    </div>
</div>
<div id="modifypassView">
    <form id="modifypassForm" method="post" action="${ctx }/sys/uUser/resetUserPwd.json">
        <table cellpadding="5">
            <tr>
                <td>用户名:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="mUserName" id="mUserName"
                           data-options="editable:false" style="width:200px;"/>
                    <input type="hidden" name="userId" />
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input class="easyui-textbox" type="text" name="mFullname" id="mFullname"
                           data-options="editable:false" style="width:200px;"/></td>
            </tr>
            <tr>
                <td>新密码:</td>
                <td><input class="easyui-textbox" type="password" name="newPsw" id="newPsw" data-options="required:true"
                           style="width:200px;"/>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>确认新密码:</td>
                <td><input class="easyui-textbox" type="password" name="password" id="newPsw2"
                           data-options="required:true" style="width:200px;"/>&nbsp;<font color="red">*</font></td>
            </tr>

        </table>

    </form>
</div>
<div id="cancelUserView">
    <form id="cancelUserForm" method="post" action="${ctx }/sysmanager/cancelUser.do">
        <input type="hidden" name="canUser_id" id="canUser_id"/>
    </form>
</div>
</body>
</html>