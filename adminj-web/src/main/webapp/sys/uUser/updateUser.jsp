<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领导员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        //提交按钮
        function submitForm() {
            $('#ff').form('submit', {
                success: function (data) {
                    var msg = $.parseJSON(data);
                    if (msg['code'] == 200) {
                        $.messager.alert("操作提示","操作成功", "info", function () {
                            window.location = '${ctx }/sys/uUser/userList.html';
                        });
                    } else {
                        $.messager.alert("操作提示", msg['msg'], "error");
                    }
                }
            });
        }

    </script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="28" height="27">
            <img src="${pageContext.request.contextPath}/images/main/pic01.gif"
                 width="28" height="27">
        </td>
        <td bgcolor="EFF6FE" class="text">
            当前位置：用户管理&gt; 修改用户
        </td>
    </tr>
</table>

<form id="ff" action="${ctx }/sys/uUser/updateUser.json" class="easyui-form" method="post"
      data-options="novalidate:true">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td class="bg1">
                <table id="myTable" align="center" width="98%" border="0"
                       cellpadding="2" cellspacing="1" bgcolor="88B3E0">
                    <tr class=px4>
                        <td width="16%" align="right">
                            登陆名：
                        </td>
                        <td width="34%">
                            <input type="text" name="userName" id="userName" class="easyui-textbox"
                                   data-options="editable:false,required:true" style="width:300px;"
                                   value="${user.userName}"/>
                            &nbsp;
                            <font color="red">*</font>
                        </td>
                        <td width="16%" align="right">
                            姓名：
                        </td>
                        <td width="34%">
                            <input type="text" name="fullname" id="fullname" class="easyui-textbox"
                                   data-options="required:true" style="width:300px;" value="${user.fullname}"/>
                            &nbsp;
                            <font color="red">*</font>
                        </td>
                    </tr>
                    <tr class=px4>
                        <td width="16%" align="right">
                            工号：
                        </td>
                        <td width="34%">
                            <input type="text" name="jobNo" id="jobNo" class="easyui-textbox"
                                   data-options="required:true" style="width:300px;" value=""/>
                            &nbsp;
                            <font color="red">*</font>
                        </td>
                        <td width="16%" align="right">
                            移动电话：
                        </td>
                        <td width="34%">
                            <input type="text" name="mobile" id="mobile" class="easyui-textbox" style="width:300px;"
                                   value="${user.mobile}"/>
                        </td>
                    </tr>
                    <tr class=px4>
                        <td width="16%" align="right">
                            状态：
                        </td>
                        <td width="34%" colspan="3">
                            <label><input name="isEnable" type="radio" value="0"
                                          class="easyui-radio" ${user.isEnable == '0' ?'checked':'' }/>启用</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input name="isEnable" type="radio" value="3"
                                          class="easyui-radio" ${user.isEnable == '1' ?'checked':'' }/>禁用</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <font color="red">*</font>&nbsp;
                        </td>
                    </tr>
                    <tr class=px4>
                        <td width="16%" align="right">
                            是否锁定：
                        </td>
                        <td width="34%" colspan="3">
                            <label><input name="isLocked" type="radio" value="0" class="easyui-radio"  ${user.isLocked == '0' ?'checked':'' }/>正常</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input name="isLocked" type="radio" value="1" class="easyui-radio"  ${user.isLocked == '1' ?'checked':'' }/>锁定</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <font color="red">*</font>
                        </td>
                    </tr>
                    <tr class=px4>
                        <td width="16%" align="right">
                            用户角色：
                        </td>
                        <td width="34%" colspan="3">
                            <c:forEach items="${allrolelist}" var="role">
                                <c:set var="flag" value="false" />
                                <c:forEach items="${userRoles}" var="userRole">
                                    <c:if test="${role.id eq userRole.roleId }">
                                        <c:set var="flag" value="true" />
                                    </c:if>
                                </c:forEach>
                                <input type="checkbox" id="roleId${role.id}" name="roleId" value="${role.id}"
                                       class="easyui-checkbox" ${flag ? 'checked':'' }/>
                                <label for="roleId${role.id}">${role.name}</label>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <div style="text-align:center;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm();">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-back"
           onclick="javascript:window.location='${ctx }/sys/uUser/userList.html'">返回</a>
    </div>
    <input type="hidden" name="id" id="id" value="${user.id}"/>
</form>
</body>
</html>
