$(function(){
	init();
	var i=0;
	var echartData = [];
	var nameList = [];
	function init(){
		$.ajax({
			url: _ctx+"/ano/voiceData",
			method: "get",
			dataType: "json",
			success: function (data) {
				var lengData = ['BD1S','BM1S','JK1S','JK2S','MD1S','MK1S','PG1S','SM1S'];
				nameList = data.nList;
				var dataLine = data.answM;  //折线
				var dataBar = data.seizM;
				for(var name in dataLine){
					var tmpObj = {};
					tmpObj.name = name;
					tmpObj.tmpLine = dataLine[name];
					tmpObj.tmpBar = dataBar[name];
					echartData.push(tmpObj);
				}
				initEchart("echart1",'Node:8',nameList,echartData[0].tmpLine,echartData[0].tmpBar);
				scroll(5);
			},
			error: function () {

			}
		});
	}
	function scroll(count){
		setInterval(function(){
           i++;
           if(i>=count){
              i=0;
           }else{
           	  initEchart("echart1",'Node:'+i,nameList,echartData[i].tmpLine,echartData[i].tmpBar);
           }
		},5000);
	}
	function initEchart(domId,tit,xData,lineData,barData) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			   backgroundColor:'#0A0F25',
			   color:['#ef8a92','#2c2a4e'],
			   title: {
			        text: tit,
			        x:'right',
			        y:'top',
			        textStyle: {
			            fontSize: 24,
			            fontFamily: 'Arial',
			            color: '#E3E3DF'
			        }
			    },
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    calculable : true,
			    grid:{
			        borderWidth: 1,
			        color:'#494868'
			    },
			    xAxis : [
			        {
			            type : 'category',
						data: xData,
			            axisLabel:{
			               show: true,
			               textStyle:{
			                   color:'#9FA0A1',
			               }
			            },
			            axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			          splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#23283B',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			             axisLabel:{
			                 show: true,
			                 textStyle:{
			                     color:'#9FA0A1',
			                 }
			             },
			            axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			            splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#494868',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			          splitArea:{
			               show: false
			          }
			        }
			    ],
			    series :[{
			            name: 'answM',
			            type: 'line',
			            smooth:true,
			            symbol:'none',
			            data: lineData
			        },
			        {
			            name: 'seizM',
			            type: 'bar',
			            barWidth:'20',
			            itemStyle:{
			                 normal:{
			                      color: '#4B476A',
			                      barBorderColor: '#4B476A',
			                      barBorderWidth: 6,
			                      barBorderRadius:0
			                 }
			            },
			            data: barData
			        }
			    ]
			};               
        myChart.setOption(option);
    }
});