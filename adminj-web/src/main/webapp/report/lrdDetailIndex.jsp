<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户数据统计</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $('#totalDg').datagrid({
                title: '总数据',
                align: 'center',
                url: '${ctx }/report/lrdTotalDataReportDetail.json',
                singleSelect: true,
                pagination: true,
                pageSize: 15,
                pageList: [15, 20, 30, 50, 100, 200],
                rownumbers: true,
                striped: true,
                singleSelect: true,
                height: '260',
                width: 'auto',
                columns: [[
                    {
                        field: 'categorie',
                        title: '类型',
                        align: 'center',
                        width: 200
                    }, {

                        field: 'data',
                        title: '数据量',
                        align: 'center',
                        width: 200
                    }
                ]]
            });

            $('#monthDg').datagrid({
                title: '按月数据',
                align: 'center',
                url: '${ctx }/report/lrdMonthDataReportDetail.json',
                singleSelect: true,
                pagination: true,
                pageSize: 15,
                pageList: [15, 20, 30, 50, 100, 200],
                rownumbers: true,
                striped: true,
                singleSelect: true,
                height: '260',
                width: 'auto',
                columns: [[
                    {
                        field: 'year',
                        title: '年',
                        align: 'center',
                        width: 150
                    }, {

                        field: 'month',
                        title: '月',
                        align: 'center',
                        width: 80
                    }, {

                        field: 'registMonthNum',
                        title: '注册量',
                        align: 'center',
                        width: 200
                    }, {

                        field: 'loginMonthNum',
                        title: '登陆量',
                        align: 'center',
                        width: 200
                    }, {

                        field: 'firstOpenAppMonthNum',
                        title: '第一次打开app量',
                        align: 'center',
                        width: 200
                    }
                ]]
            });
        });
    </script>
</head>
<body>
    <table id="totalDg">
    </table>
    <table id="monthDg">
    </table>
</body>
</html>
