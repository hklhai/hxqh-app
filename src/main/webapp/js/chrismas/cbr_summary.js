
$(function(){
    var legendData = ["w1Attempt","w2Attempt","w1Oglost","w2Oglost"];
    var xData = [];
    function init(){
        getData("asrsummaryData");
        var i = 0;
        setInterval(function(){
            i++;
            if(i==2){
                i=0;
            }
            if(i==0){
                getData("cbrsummaryData","years");
            }
            if(i==1){
                getData("asrsummaryData","weeks");
            }
        },10000)
    }
    init();

    function getData(urlName,showContent){
        var urls = _ctx+"/ano/"+urlName;
        $.ajax({
            url: urls,
            method: "get",
            dataType: "json",
            success: function (data) {
                var today = getDate();
                if(showContent=="years"){
                    xData = data.arsDto.weekday;
                    tit = "Call Block Ratio (%) Summary for Years 2016 & 2017        as of "+today;
                    dealData(data.arsDto,"years",data.vTotalMonthAsrs[0]);
                }else{
                    xData = data.weekday;
                    tit1 = "Call Block Ratio (%) Summary for Week 1 & Week 2        as of "+today;
                    $(".tit").text(tit1,"week");
                    // 每组数据
                    dealData(data);
                }

            },
            error: function () {
            }
        });
    }

    function dealData(datas,showContent,titData){
        var data = [];
        for(var i=0;i<legendData.length;i++){
            var tmpObj = {};
            tmpObj.name=legendData[i];
            if(legendData[i]=="w1Attempt"||legendData[i]=="w2Attempt"){
                tmpObj.type="bar";
            }else{
                tmpObj.type="line";
            }
            tmpObj.data=datas[legendData[i]];
            data.push(tmpObj);
        }
        if(showContent=="years"){
            $(".showcontent span:nth-child(1)").text(titData.upLost);
            $(".showcontent span:nth-child(2)").text(titData.tlost);
            $(".showcontent").show();
            $("table.perservice").hide();
        }else{
            var tmpHtml1 = "<tr><td width='3%'>Previous</td>";
            var tmpHtml2 = "<tr><td width='3%'>current</td>";
            var tmpHtml3 = "<tr><td width='3%'></td>";
            var w1Aser = datas.w1Block;
            var w2Aser = datas.w2Block;
            for(var m=0;m<w1Aser.length;m++){
                tmpHtml1+="<td>"+w1Aser[m]+"</td>";
                tmpHtml2+="<td>"+w2Aser[m]+"</td>";
                tmpHtml3+="<td>"+xData[m]+"</td>";
            }
            tmpHtml1 += "</tr>";
            tmpHtml2 += "</tr>";
            $("table.perservice thead").html(tmpHtml3);
            $("table.perservice tbody").html("");
            $("table.perservice tbody").html(tmpHtml1+tmpHtml2);
            $("table.perservice").show();
            $(".showcontent").hide();
        }
        initELine('echart1',data,legendData,xData);
    }

    function getDate(){
        var monthName = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
        var myDate = new Date();
        var month = myDate.getMonth();      //获取当前月份(0-11,0代表1月)
        var dates = myDate.getDate()+" "+monthName[month]+" "+myDate.getFullYear();
        return dates;
    }

    //调用此函数时，参数domId,data,legendData,xData
    function initELine(domId,data,legendData,xData) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor: '#0A0F25',
            color:['#4B92D1','#70AD47','#FFC300','#A3A3A3'],

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: legendData,
                x: 'center',
                y: 'bottom',
                textStyle: {
                    fontSize: 16,
                    fontFamily: "Arial",
                    color: '#CECECE'
                }
            },
            calculable: true,
            grid: {
                show: false,
                borderWidth: 1,
                borderColor: '#212538'
            },
            xAxis: [{
                show: true,
                type: 'category',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 28,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: '#212538',
                    }
                },
                data: xData
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 28,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#212538',
                    }
                },
            }],
            series : data
        };
        myChart.setOption(option);
    }
});
