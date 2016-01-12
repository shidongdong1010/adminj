<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>领航员综合服务平台</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">

        var $inputStockCodeObj = null;
        $(function () {
            // 加载股票事件
            stockCodeLoadInit();

            $("#inputPositionView").css("display", "none");

            // 保存事件
            $("#saveOrderBtn").click(function(){
                if($("#inputPositionView").css("display") == "none"){
                    // 交易的FORM提交
                    $('#inputTradeForm').form('submit', {
                        success:function(data){
                            var msg = $.parseJSON(data);
                            if(msg['code'] == 200){
                                $.messager.alert("操作提示", msg['msg'],"info", function(){
                                    window.location = '${ctx }/dynamic/orderInputList.html';
                                });
                            }else{
                                $.messager.alert("操作提示", msg['msg'],"error");
                            }
                        }
                    });
                }else{
                    // 持仓的FORM提交
                    $('#inputPositionForm').form('submit', {
                        success:function(data){
                            var msg = $.parseJSON(data);
                            if(msg['code'] == 200){
                                $.messager.alert("操作提示", msg['msg'],"info", function(){
                                    window.location = '${ctx }/dynamic/orderInputList.html';
                                });
                            }else{
                                $.messager.alert("操作提示", msg['msg'],"error");
                            }
                        }
                    });
                }
                return false;
            });

            // 废图按钮
            $("#wasteBtn").click(function(){
                $.messager.confirm("操作提示", "确认是否进行作废操作", function(m){
                    if(m){
                        var dynamicId = "${userDynamicInfo.dynamicId}";
                        $.post("${ctx}/dynamic/orderInputCancel.json", {dynamicId: dynamicId}, function(msg){
                            if(msg['code'] == 200){
                                window.location = '${ctx }/dynamic/orderInputList.html';
                            }else{
                                $.messager.alert("操作提示", msg['msg'],"error");
                            }
                        }, "json");
                    }
                });
            });

            // 交易按钮
            $("#tradeBtn").click(function(){
                $("#inputPositionView").hide();
                $("#inputTradeView").show();
                return false;
            });

            // 持仓按钮
            $("#positionBtn").click(function(){
                $("#inputTradeView").hide();
                $("#inputPositionView").show();
                return false;
            });

            // 根据交易记录计算持仓
            $("#inputTradeCalcBtn").click(function(){
                calcPosition();
               return false;
            });

            // 根据持仓记录计算交易
            $("#inputPositionCalcBtn").click(function(){
                calcTrade();
                return false;
            });

            // 添加一行数据
            $("table").on("click", ".addBtn", function(){
                if($("#inputPositionView").css("display") == "none"){
                    addInputTradeTradeTr($(this));
                }else{
                    addInputPositionPositionTr($(this));
                }
                return false;
            });

            // 删除一行数据
            $("table").on("click", ".delBtn", function(){
                 $(this).parents("tr").first().remove();
                return false;
            });
        });

        // 根据交易计算持仓
        function calcPosition(){
            // 获得当前的持仓数据
            var currentPositions = getCurrentPosition();
            // 获得录入的交易数据
            var trades = getInputTradeTrade();

            $("#inputTradePositionTbody").children().remove();

            for(var i = 0; i < trades.length; i++){
                var trade = trades[i];
                var flag = false;
                for(var j = 0; j < currentPositions.length; j++){
                    var currentPosition = currentPositions[j];
                    if(currentPosition.stockCode == trade.stockCode){
                        flag = true;
                        // 计算
                        if(trade.tradeType == 'B'){
                            // 买入 添加持仓
                            var stockNum =  currentPosition.stockNum + trade.stockNum;
                            var costAmount = currentPosition.costAmount + trade.stockNum * trade.tradePrice;
                            addInputTradePositionTr({stockCode: currentPosition.stockCode, stockName: currentPosition.stockName, stockNum: stockNum, costAmount: costAmount});
                            break;
                        }else{
                            // 卖出 减少持仓
                            var stockNum =  currentPosition.stockNum - trade.stockNum;
                            var costAmount = currentPosition.costAmount - trade.stockNum * trade.tradePrice;
                            addInputTradePositionTr({stockCode: currentPosition.stockCode, stockName: currentPosition.stockName, stockNum: stockNum, costAmount: costAmount});
                            break
                        }
                    }
                }

                if(!flag){
                    // 原持仓没有，添加持仓
                    var costAmount = trade.stockNum * trade.tradePrice;
                    addInputTradePositionTr({stockCode: trade.stockCode, stockName: trade.stockName, stockNum: trade.stockNum, costAmount: costAmount});
                }
            }

            // 如果没有变动，则显示当前的持仓
            for (var j = 0; j < currentPositions.length; j++) {
                var currentPosition = currentPositions[j];
                var flag = false;
                for (var i = 0; i < trades.length; i++) {
                    var trade = trades[i];
                    if (currentPosition.stockCode == trade.stockCode) {
                        flag = true;
                    }
                }
                if (!flag) {
                    addInputTradePositionTr(currentPosition);
                }
            }
        }


        // 根据持仓计算交易
        function calcTrade(){
            // 获得当前的持仓数据
            var currentPositions = getCurrentPosition();
            // 获得录入的持仓
            var inputPositions = getInputPosition();

            $("#inputPositionTradeTbody").children().remove();

            for(var i = 0; i < inputPositions.length; i++) {
                var inputPosition = inputPositions[i];
                var flag = false;
                for (var j = 0; j < currentPositions.length; j++) {
                    var currentPosition = currentPositions[j];
                    if (currentPosition.stockCode == inputPosition.stockCode) {
                        flag = true;

                        var stockNum = inputPosition.stockNum - currentPosition.stockNum;
                        var tradeType = "B";  // 默认为买入

                        if(stockNum <= 0){
                            // 卖出 减少持仓
                            tradeType = "S";
                            stockNum = -stockNum;
                        }
                        // 计算交易价格
                        var tradePrice = (inputPosition.costAmount - currentPosition.costAmount) / stockNum;
                        addInputPositionTradeTr({stockCode: inputPosition.stockCode, stockName: inputPosition.stockName, num: stockNum, tradeType: tradeType, tradePrice: tradePrice});
                    }
                }

                if(!flag){
                    var tradeType = "B";
                    // 原持仓没有，添加持仓
                    // 计算交易价格
                    var tradePrice = inputPosition.costAmount / inputPosition.stockNum;
                    addInputPositionTradeTr({stockCode: inputPosition.stockCode, stockName: inputPosition.stockName, num: inputPosition.stockNum, tradeType: tradeType, tradePrice: tradePrice});
                }
            }

            // 没有持仓，则说明卖出
            for (var j = 0; j < currentPositions.length; j++) {
                var currentPosition = currentPositions[j];
                var flag = false;
                for (var i = 0; i < inputPositions.length; i++) {
                    var inputPosition = inputPositions[i];
                    if (currentPosition.stockCode == inputPosition.stockCode) {
                        flag = true;
                    }
                }
                if(!flag) {
                    var tradeType = "S";
                    var tradePrice = currentPosition.costAmount / currentPosition.stockNum;
                    addInputPositionTradeTr({stockCode: currentPosition.stockCode, stockName: currentPosition.stockName, num: currentPosition.stockNum, tradeType: tradeType, tradePrice: tradePrice});
                }
            }
        }

        // 获得录入的交易数据
        function getInputTradeTrade(){
            var trs = $("#inputTradeTradeTbody").find("tr");

            var trades = []
            for(var i = 0; i < trs.size(); i++) {
                var tr = trs.eq(i);
                var stockCode = tr.find("input[textboxname='stockCode']").textbox("getValue");
                var stockName = tr.find("input[textboxname='stockName']").textbox("getValue");
                var num = Number(tr.find("input[textboxname='num']").textbox("getValue"));
                var tradeType = tr.find("select[textboxname='tradeType']").textbox("getValue");
                var tradePrice = Number(tr.find("input[numberboxname='tradePrice']").numberbox("getValue"));

                if(stockCode == null || stockCode == '') continue;
                if(num <= 0) continue;

                trades.push({stockCode: stockCode, stockName: stockName, stockNum: num, tradeType: tradeType, tradePrice: tradePrice});
            }
            return trades;
        }

        // 获得录入的持仓
        function getInputPosition(){
            var trs = $("#inputPositionPositionTbody").find("tr");
            var inputPositions = []
            for(var j = 0; j < trs.size(); j++){
                var tr = trs.eq(j);
                var stockCode = tr.find("input[textboxname='stockCode']").textbox("getValue");
                var stockName = tr.find("input[textboxname='stockName']").textbox("getValue");
                var stockNum = Number(tr.find("input[textboxname='stockNum']").textbox("getValue"));
                var costAmount = Number(tr.find("input[numberboxname='costAmount']").numberbox("getValue"));

                if(stockCode == null || stockCode == '') continue;
                if(stockNum <= 0) continue;

                inputPositions.push({stockCode: stockCode, stockName: stockName, stockNum: stockNum, costAmount: costAmount});
            }
            return inputPositions;
        }

        // 获得当前的持仓
        function getCurrentPosition(){
            var cuTrs = $("#currentPositionTbody").find("tr");
            var currentPositions = []
            for(var j = 0; j < cuTrs.size(); j++){
                var cuTr = cuTrs.eq(j);
                var cuTd = cuTr.find("td");

                var stockCode = cuTd.eq(0).text();
                var stockNamee = cuTd.eq(1).text();
                var stockNum = Number(cuTd.eq(2).text());
                var costAmount = Number(cuTd.eq(3).text());

                currentPositions.push({stockCode: stockCode, stockName: stockNamee, stockNum: stockNum, costAmount: costAmount});
            }
            return currentPositions;
        }

        // 添加录入交易记录
        function addInputTradeTradeTr(target) {
            /*var curTr = target.parents("tr");
             if(curTr.next("tr").size() != 0){
             return;
             }*/
            var tr = $("" +
                    "<tr>" +
                    "<td><input type=\"text\" name=\"stockCode\" data-options=\"required:true,width:100\" /></td>" +
                    "<td><input class=\"easyui-textbox\" type=\"text\" name=\"stockName\" data-options=\"required:true,width:100\"/></td>" +
                    "<td><input class=\"easyui-numberbox\" type=\"text\" name=\"num\" data-options=\"required:true,width:100,formatter:function(value,row,index){return parseInt(value/100)*100;}\"/></td>" +
                    "<td>" +
                    "<select name=\"tradeType\" class=\"easyui-combobox\" data-options=\"editable:false,required:true,width:100\">" +
                    "<option value=\"B\">买入</option>" +
                    "<option value=\"S\">卖出</option>" +
                    "</select>" +
                    "</td>" +
                    "<td><input class=\"easyui-numberbox\" precision=\"2\" type=\"text\" name=\"tradePrice\" data-options=\"required:true,width:100\"/></td>" +
                    "<td><a href=\"#\" class=\"delBtn\">删除<a></td>" +
                    "</tr>");
            var tbody = target.parents("tbody").first();
            tbody.append(tr);
            // 重新渲染easyui组件
            $.parser.parse(tr);

            stockCodeLoadInit();
        }

        // 添加录入持仓记录
        function addInputPositionPositionTr(target) {
            /*var curTr = target.parents("tr");
             if(curTr.next("tr").size() != 0){
             return;
             }*/
            var tr = $("" +
                    "<tr> " +
                    "<td><input type=\"text\" name=\"stockCode\"  data-options=\"required:true,width:100\"/>" +
                    "</td>" +
                    "<td><input class=\"easyui-textbox\" type=\"text\" name=\"stockName\"  data-options=\"required:true,width:100\"/>" +
                    "</td>" +
                    "<td><input class=\"easyui-numberbox\" type=\"text\" name=\"stockNum\"  data-options=\"required:true,width:100,formatter:function(value,row,index){return parseInt(value/100)*100;}\"/>" +
                    "</td>" +
                    "<td><input class=\"easyui-numberbox\" precision=\"2\" type=\"text\" name=\"costAmount\"  data-options=\"required:true,width:100\"/>" +
                    "</td>" +
                    "<td><a href=\"#\" class=\"delBtn\">删除<a></td>" +
                    "</tr>");
            var tbody = target.parents("tbody").first();
            tbody.append(tr);
            // 重新渲染easyui组件
            $.parser.parse(tr);

            stockCodeLoadInit();
        }

        // 添加交易记录后生成的持仓记录
        function addInputTradePositionTr(obj) {
            var tbody = $("#inputTradePositionTbody");
            var tr = $("" +
                    "<tr>" +
                    "<td>"+obj.stockCode+"</td>" +
                    "<td>"+obj.stockName+"</td>" +
                    "<td>"+obj.stockNum+"</td>" +
                    "<td>"+obj.costAmount.toFixed(2)+"</td>" +
                    "</tr>");
            tbody.append(tr);
            // 重新渲染easyui组件
            $.parser.parse(tr);
        }

        // 添加持仓记录后生成的交易交易
        function addInputPositionTradeTr(obj) {
            var tbody = $("#inputPositionTradeTbody");
            var tr = $("" +
                    "<tr>" +
                    "<td>"+obj.stockCode+"<input type=\"hidden\" name=\"stockCode\" value=\""+obj.stockCode+"\"/></td>" +
                    "<td>"+obj.stockName+"<input type=\"hidden\" name=\"stockName\" value=\""+obj.stockName+"\"/></td>" +
                    "<td>"+obj.num+"<input type=\"hidden\" name=\"num\" value=\""+obj.num+"\"/></td>" +
                    "<td>"+(obj.tradeType == 'B' ? '买入' : '卖出')+"<input type=\"hidden\" name=\"tradeType\" value=\""+obj.tradeType+"\"/></td>" +
                    "<td>"+obj.tradePrice.toFixed(2)+"<input type=\"hidden\" name=\"tradePrice\" value=\""+obj.tradePrice.toFixed(2)+"\"/></td>" +
                    "</tr>");
            tbody.append(tr);
            // 重新渲染easyui组件
            $.parser.parse(tr);
        }

        function stockCodeLoadInit(){
            $("input:text[name='stockCode']").combogrid({
                panelWidth: 280,
                delay: 500,
                mode: 'remote',
                url: '${ctx }/stock/likeStock.json',
                idField: 'stockCode',
                textField: 'stockCode',
                required: true,
                method: 'post',
                width: 100,
                columns: [[
                    {
                        field: 'stockCode',
                        title: '股票代码',
                        width: 100,
                        sortable: true
                    }, {
                        field: 'stockName',
                        title: '股票名称',
                        width: 100,
                        sortable: true
                    }, {
                        field: 'zxz',
                        title: '最新价',
                        width: 50,
                        sortable: true
                    }
                ]],
                onShowPanel: function(){
                    $inputStockCodeObj = $(this);
                },
                onSelect: function (index, row) {
                    $inputStockCodeObj.parent().parent().find("input[textboxname='stockName']").textbox("setValue", row['stockName']);
                    $inputStockCodeObj.parent().parent().find("input[textboxname='tradePrice']").numberbox("setValue", row['zxz']);
                }
            });
        }
    </script>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    <div data-options="region:'center',split:true" title="组合" style="width:60%;">
    <div class="bg1">
        <div>
            <div>
                <label>用户姓名：</label><input name="userName" value="${user.userName }" disabled/>
                <label>组合名称：</label><input name="groupName" value="${userDynamicInfo.title}" disabled/>
            </div>
        </div>
        <div>
            <div style="text-align:center;padding:5px">
                <a href="#" class="easyui-linkbutton" id="tradeBtn" iconCls="icon-add">交易</a>
                <a href="#" class="easyui-linkbutton" id="positionBtn" iconCls="icon-edit">持仓</a>
                <a href="#" class="easyui-linkbutton" id="wasteBtn" iconCls="icon-remove">废图</a>

                <a href="#" class="easyui-linkbutton" id="saveOrderBtn" iconCls="icon-edit">保存</a>
            </div>
        </div>
        <!-- 录入交易界面 -->
        <div id="inputTradeView">
            <form id="inputTradeForm" method="post" action="${ctx }/dynamic/orderInput.json">
                <input type="hidden" name="dynamicId" value="${userDynamicInfo.dynamicId}" />
                <input type="hidden" name="userId" value="${userDynamicInfo.userId}" />
                <input type="hidden" name="parentGroupId" value="0" />

                <div class="easyui-panel" title="录入交易记录" style="padding:7px 10px; margin-bottom: 10px;">
                    <table>
                        <thead>
                        <tr>
                            <th>证券代码</th>
                            <th>证券名称</th>
                            <th>股票余数</th>
                            <th>当前操作</th>
                            <th>交易价</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="inputTradeTradeTbody">
                        <tr>
                            <td><input type="text" name="stockCode" data-options="required:true,width:100"/>
                            </td>
                            <td><input class="easyui-textbox" type="text" name="stockName" data-options="required:true,width:100"/>
                            </td>
                            <td><input class="easyui-numberbox" type="text" name="num" data-options="required:true,width:100,formatter:function(value,row,index){return parseInt(value/100)*100;}"/></td>
                            <td>
                                <select name="tradeType" class="easyui-combobox" data-options="editable:false,required:true,width:100">
                                    <option value="B">买入</option>
                                    <option value="S">卖出</option>
                                </select>
                            </td>
                            <td><input class="easyui-numberbox" precision="2" type="text" name="tradePrice" data-options="required:true,width:100"/>
                            </td>
                            <td><a href="#" class="addBtn">添加</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="easyui-panel" title="股票持仓" style="padding:7px 10px; margin-bottom: 10px;">
                    <table>
                        <tr>
                            <td style="vertical-align: top;">
                                <table>
                                    <thead>
                                    <tr>
                                        <th width="100">证券代码</th>
                                        <th width="100">证券名称</th>
                                        <th width="100">原持仓数量</th>
                                        <th width="100">成本</th>
                                    </tr>
                                    </thead>
                                    <tbody id="currentPositionTbody">
                                    <c:forEach var="p" items="${stockPositions}">
                                        <tr>
                                            <td>${p.stockCode}</td>
                                            <td>${p.stockName}</td>
                                            <td>${p.stockNum}</td>
                                            <td>${p.costAmount}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </td>
                            <td width="120">
                                <a href="#" class="easyui-linkbutton" id="inputTradeCalcBtn" iconCls="icon-edit">计算</a>
                            </td>
                            <td style="vertical-align: top;">
                                <table>
                                    <thead>
                                    <tr>
                                        <th width="100">证券代码</th>
                                        <th width="100">证券名称</th>
                                        <th width="100">新持仓数量</th>
                                        <th width="100">新成本</th>
                                    </tr>
                                    </thead>
                                    <tbody id="inputTradePositionTbody">
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

        <!-- 录入持仓界面 -->
        <div id="inputPositionView">
            <div class="easyui-panel" title="录入持仓" style="padding:7px 10px; margin-bottom: 10px;">
                <table>
                    <thead>
                    <tr>
                        <th width="100">证券代码</th>
                        <th width="100">证券名称</th>
                        <th width="100">原持仓数量</th>
                        <th width="100">原成本</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="p" items="${stockPositions}">
                        <tr>
                            <td>${p.stockCode}</td>
                            <td>${p.stockName}</td>
                            <td>${p.stockNum}</td>
                            <td>${p.costAmount}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div style="text-align: center;">
                    <a href="#" class="easyui-linkbutton" id="inputPositionCalcBtn" iconCls="icon-edit">计算</a>
                </div>
                <table>
                    <thead>
                    <tr>
                        <th>证券代码</th>
                        <th>证券名称</th>
                        <th>新持仓数量</th>
                        <th>成本</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody id="inputPositionPositionTbody">
                    <tr>
                        <td><input type="text" name="stockCode" data-options="required:true,width:100"/>
                        </td>
                        <td><input class="easyui-textbox" type="text" name="stockName"
                                   data-options="required:true,width:100"/>
                        </td>
                        <td><input class="easyui-numberbox" type="text" name="stockNum"
                                   data-options="required:true,width:100,formatter:function(value,row,index){return parseInt(value/100)*100;}"/>
                        </td>
                        <td><input class="easyui-numberbox" precision="2" type="text" name="costAmount"
                                   data-options="required:true,width:100"/>
                        </td>
                        <td><a href="#" class="addBtn">添加</a></td>
                    </tr>
                    </tbody>
                </table>
                </td>
            </div>

            <form id="inputPositionForm" method="post" action="${ctx }/dynamic/orderInput.json">
                <input type="hidden" name="dynamicId" value="${userDynamicInfo.dynamicId}" />
                <input type="hidden" name="userId" value="${userDynamicInfo.userId}" />
                <div class="easyui-panel" title="交易记录" style="padding:7px 10px; margin-bottom: 10px;">
                    <table>
                        <thead>
                        <tr>
                            <th width="100">证券代码</th>
                            <th width="100">证券名称</th>
                            <th width="100">股票余数</th>
                            <th width="100">当前操作</th>
                            <th width="100">交易价</th>
                        </tr>
                        </thead>
                        <tbody id="inputPositionTradeTbody">
                        <tr>
                            <td>${stockCode }<input type="hidden" name="stockCode" value=""/></td>
                            <td>${stockName }<input type="hidden" name="stockName" value=""/></td>
                            <td>${num }<input type="hidden" name="num" value=""/></td>
                            <td>${tradeType }<input type="hidden" name="tradeType" value=""/></td>
                            <td>${tradePrice }<input type="hidden" name="tradePrice" value=""/></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </form>
        </div>
    </div>
</div>
    <div data-options="region:'east',split:true" title="图片" style="width:40%;">
        <div style="padding: 5px 0;">
            <c:forEach items="${paths }" var="path">
                <img src="${sail_web_url}/dynamic/info/query/dynamicImg.json?path=${path }"/>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
