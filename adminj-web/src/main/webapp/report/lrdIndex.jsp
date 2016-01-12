<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户数据统计</title>
    <%@ include file="/common/header.jsp" %>
</head>
<body>
<div id="container" style="min-width: 200px; width: 600px; height: 400px; margin: 0 auto"></div>
<div id="containerMonth" style="min-width: 200px; width: 600px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
    function showTotal(categories, data){
        $('#container').highcharts({
            chart: {
                type: 'column',
                margin: [50, 50, 100, 80]
            },
            title: {
                text: '总数据'
            },
            xAxis: {
                categories: categories,
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: ''
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: '截止到目前为止: <b>{point.y} 次</b>',
            },
            series: [{
                name: 'Population',
                data: data,
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
            }],
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
                                window.location.href = "${ctx}/report/lrdTotalDataReportDetail.html";
                            },
                            separator: false
                        }]
                    }
                }
            }
        });
    }

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
                                window.location.href = "${ctx}/report/lrdTotalDataReportDetail.html";
                            },
                            separator: false
                        }]
                    }
                }
            }
        });
    }

    $(function () {
        $.post("${ctx }/report/lrdTotalDataReport.json", function(msg){
            showTotal(msg.data.categories, msg.data.data);
        }, "json");

        $.post("${ctx }/report/lrdMonthDataReport.json", function(msg){
            showMonth(msg.data.categories, msg.data.series);
        }, "json");
    });
</script>
<script src="${ctx}/js/highcharts/highcharts.js"></script>
<script src="${ctx}/js/highcharts/modules/exporting.js"></script>
</body>
</html>
