/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/wifi/vWifiTrafficData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data.trafficTopList);
                /*initEchart("echart2",data.trafficBottomList);*/
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartData) {
        var legendData = [];
        var xAxisData = ['周一','周二','周三','周四','周五','周六','周日'];
        var seriesData = [];
        /*for(var i=0,len=echartData.length;i<len;i++){
            legendData = echartData[i].name;
        }*/
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Daily Traffic Distribution By Regions-Jun 2017",
                x: "left",
                backgroundColor:'#161C2F',
                textStyle:{
                    fontSize: '16px',
                    fontWeight: 'bold',
                    fontFamily: 'Arial, Verdana, sans-serif'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient:'vertical',
                x:'right',
                y:'top',
                textStyle:{
                    fontSize: 12,
                    color: '#666C7F',
                },
                data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    splitLine: {
                        show: false,
                    },
                    axisLabel:{
                                show: true,
                                textStyle: {
                                    color: '#666C7F',   //x轴字体颜色
                        }
                    },
                    data : xAxisData
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    splitLine: {
                        show: true,
                        lineStyle: {
                            type: 'dashed',
                        }
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#666C7F',   //y轴字体颜色
                        }
                    },
                }
            ],
            series : [
                {
                    name:'邮件营销',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'直接访问',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'搜索引擎',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());