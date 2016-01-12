<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户数据统计</title>
    <%@ include file="/common/header.jsp" %>
</head>
<body>
<div id="containerMonth" style="min-width: 200px; width: 800px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">

    function showMonth(categories, series){
        $('#containerMonth').highcharts({
            title: {
                text: '按月统计',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: ''
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '次'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: series,
            credits:{
                enabled:false // 禁用版权信息
            },
            exporting: {
                type: 'image/png',
                buttons: {
                    contextButton: {
                        menuItems: [{
                            text: '打印',
                            onclick: function () {
                                this.print()
                            },
                            separator: false
                        }, {
                            text: '',
                            separator: true
                        }, {
                            text: '导出PNG图片文件',
                            onclick: function () {
                                this.exportChart()
                            },
                            separator: false
                        }, {
                            text: '导出JPEG图片文件',
                            onclick: function () {
                                this.exportChart({
                                    type: 'image/jpeg'
                                })
                            },
                            separator: false
                        }, {
                            text: '导出SVG文件',
                            onclick: function () {
                                this.exportChart({
                                    type: 'image/svg+xml'
                                })
                            },
                            separator: false
                        }, {
                            text: '导出PDF文件',
                            onclick: function () {
                                this.exportChart({
                                    type: 'application/pdf'
                                })
                            },
                            separator: false
                        }, {
                            text: '',
                            separator: true
                        }, {
                            text: '查看明细',
                            onclick: function () {
                                window.location.href = "${ctx}/report/operationReportDetail.html";
                            },
                            separator: false
                        }]
                    }
                }
            }
        });
    }

    $(function () {
        $.post("${ctx }/report/operationReport.json", function(msg){
            showMonth(msg.data.categories, msg.data.series);
        }, "json");
    });
</script>
<script src="${ctx}/js/highcharts/highcharts.js"></script>
<script src="${ctx}/js/highcharts/modules/exporting.js"></script>
</body>
</html>
