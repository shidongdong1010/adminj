<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领导员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        function myformatter(date) {
            return date.Format("yyyy-MM-dd hh:mm:ss");
            /*var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            var h = date.getHours();
            var mi = date.getMinutes();
            var s = date.getSeconds();

            return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d) + ' ' + (h < 10 ? ('0' + h) : h) + ' ' + (mi < 10 ? ('0' + mi) : mi) + ' ' + (s < 10 ? ('0' + s) : s);*/
        }
        function myparser(s) {
            var t = Date.parse(s);
            if (!isNaN(t)) {
                return new Date(Date.parse(s.replace(/-/g, "/")));
            } else {
                return new Date();
            }
            /*if (!s) return new Date();
            var ss = (s.split('-'));
            var y = parseInt(ss[0], 10);
            var m = parseInt(ss[1], 10);
            var d = parseInt(ss[2], 10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
                return new Date(y, m - 1, d);
            } else {
                return new Date();
            }*/
        }

        $(function () {
           $("#addBtn").click(function(){
               // FORM提交
               $('#addForm').form('submit', {
                   success:function(data){
                       var msg = $.parseJSON(data);
                       if(msg['code'] == 200){
                           $.messager.alert("操作提示", msg['msg'],"info", function(){
                               window.location = '${ctx }/tactics/coinConvertGoodList.html';
                           });
                       }else{
                           $.messager.alert("操作提示", msg['msg'],"error");
                       }
                   }
               });

               return false;
           });

            $("#coin").numberbox({
                min:1,
                precision: 2,
                required:true,
                onChange: function(newValue,oldValue){
                    var rate = ${coinConvertRule.coin / coinConvertRule.rmb};
                    var amount = (newValue / rate).toFixed(2);
                    $("#coinCoverRmb").text(amount);
                    $("input[name='amount']").val(amount)
                }
            });

            $("#coin").numberbox("setValue", ${coinConvertGood.coin});
        });
    </script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<div class="bg1">
    <form id="addForm" action="${ctx }/tactics/updateCoinConvertGood.json" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${coinConvertGood.id}" name="id" />
        <div class="easyui-panel" title="商品上架" style="padding:7px 10px; margin-bottom: 10px;">
            <table>
                <tbody>
                <tr>
                    <th width="100px;">商品名称</th>
                    <td><input type="text" name="name" class="easyui-textbox" value="${coinConvertGood.name}" data-options="required:true" style="width:500px;"/></td>
                </tr>
                <tr>
                    <th>有效期</th>
                    <td>
                        <input type="text" name="beginTime" class="easyui-datetimebox" value="${coinConvertGood.beginTime}" style="width:150px;"
                               data-options="formatter:myformatter,parser:myparser,required:true"/>
                        至
                        <input type="text" name="endTime" class="easyui-datetimebox" value="${coinConvertGood.endTime}" style="width:150px;"
                               data-options="formatter:myformatter,parser:myparser,required:true"/>
                    </td>
                </tr>
                <tr>
                    <th>商品金额</th>
                    <td><input type="text" name="coin" id="coin" style="width:100px;"/>
                        (价值<span style="color: red;" id="coinCoverRmb">${coinConvertGood.amount}</span>人民币)
                        <input type="hidden" name="amount" value="${coinConvertGood.amount}" />
                    </td>
                </tr>
                <tr>
                    <th>商品数量</th>
                    <td><input type="text" name="num" class="easyui-numberspinner" value="${coinConvertGood.num}" data-options="min:1,required:true"
                               style="width:100px;"/></td>
                </tr>
                <tr>
                    <th>每日数量</th>
                    <td><input type="text" name="dayNum" class="easyui-numberspinner" value="${coinConvertGood.dayNum}" data-options="min:1"
                               style="width:100px;"/></td>
                </tr>
                <tr>
                    <th>收货地址</th>
                    <td>
                        <select name="isAddr" class="easyui-combobox">
                            <option value="1" ${coinConvertGood.isAddr eq 1 ? "selected" : ""}>是</option>
                            <option value="0" ${coinConvertGood.isAddr eq 0 ? "selected" : ""}>否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>商品简介</th>
                    <td><input type="text" name="summary" class="easyui-textbox" value="${coinConvertGood.summary}" data-options="multiline:true,required:true"
                               style="height:80px; width: 500px;"/></td>
                </tr>
                <tr>
                    <th>使用说明</th>
                    <td><input type="text" name="useDesc" class="easyui-textbox" value="${coinConvertGood.useDesc}" data-options="multiline:true,required:true"
                               style="height:80px; width: 500px;"/></td>
                </tr>
                <tr>
                    <th>兑换说明</th>
                    <td><input type="text" name="convertDesc" class="easyui-textbox" value="${coinConvertGood.convertDesc}" data-options="multiline:true,required:true"
                               style="height:80px; width: 500px;"/></td>
                </tr>
                <tr>
                    <th>小图片</th>
                    <td><input name="minFile" class="easyui-filebox" data-options="buttonText: '选择小图片'"></td>
                </tr>
                <tr>
                    <th>大图片</th>
                    <td><input name="maxFile" class="easyui-filebox" data-options="buttonText: '选择大图片'"></td>
                </tr>
                </tbody>
            </table>
        </div>
        <a href="#" class="easyui-linkbutton" id="addBtn" iconCls="icon-add">保存</a>
    </form>
</div>
</body>
</html>
