<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户数据统计</title>
    <%@ include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                title: '统计数据',
                align: 'center',
                url: '${ctx }/report/operationReportDetail.json',
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
                        width: 80
                    }, {

                        field: 'month',
                        title: '月',
                        align: 'center',
                        width: 60
                    }, {

                        field: 'loginNum',
                        title: '登陆',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'votoNum',
                        title: '跟买',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'orderNum',
                        title: '晒单',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'talkNum',
                        title: '说说',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'commentNum',
                        title: '评论',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'forwardNum',
                        title: '转发',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'rewardNum',
                        title: '打赏',
                        align: 'center',
                        width: 100
                    }, {

                        field: 'openAppNum',
                        title: '打开APP',
                        align: 'center',
                        width: 100
                    }
                ]]
            });
        });
    </script>
</head>
<body>
<table id="dg">
</table>
</body>
</html>
