

// //---------------浮选页面生产数据图表-------------
var myChart1 = echarts.init(document.getElementById('scdata'));
// 指定图表的配置项和数据
myChart1.setOption({
    tooltip: {},
    legend: {
        textStyle:{
            color:'#ffffff'
        },
        bottom:'2%',
        orient: 'horizontal',
        top:'0%',
        itemWidth: 8,
        itemHeight: 8

    },
    grid: { top: '15%', left: '3%', right: '4%', bottom: '3%', containLabel: true},
    xAxis: {
        data: [],
        axisLabel:{
            rotate:15, //刻度旋转45度角
            textStyle:{
                color:"white",
                fontSize:10
            }
        }
    },
    yAxis: {
        axisLine:{
            lineStyle:{
                color:'white'
            }
        }
    },
    series: [       {
        name: '铜精矿硫(%)',
        type: 'bar',
        data: []
        },
        {
            name: '硫精矿铜(%)',
            type: 'bar',
            data: []},
        {
            name: '尾矿铜(%)',
            type: 'bar',
            data: []
        },
        {
            name: '铜精矿铜(%)',
            type: 'bar',
            data: []
        },
        {
            name: '硫精矿硫(%)',
            type: 'bar',
            data: []
        },


        {
            name: '尾矿硫(%)',
            type: 'bar',
            data: []}
    ]
});

myChart1.showLoading();
var isLoaded1 = false;
function reqs1() {

    var CuSs=[];
    var CuCus=[];
    var SSs=[];
    var SCus=[];
    var WSs=[];
    var WCus=[];
    $.ajax({
        type : "get",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/process/float/FX_1_PV_treatment",    //请求发送到TestServlet处
        data : {},
        dataType : "json",   //返回数据形式为json
        beforeSend: function () {
            isLoaded1= false;
        },
        success : function(result) {

                //请求成功时执行该函数内容，result即为服务器返回的json对象
                var data = result.data;
            if(data.length>0) {
                    for (var a = 0; a < data.length; a++) {
                        CuSs.push(data[a].cuS);    //挨个取出类别并填入类别数组
                    }
                    for (var b = 0; b < data.length; b++) {
                        CuCus.push(data[b].cuCu);    //挨个取出销量并填入销量数组
                    }
                    for (var c = 0; c < data.length; c++) {
                        SSs.push(data[c].ss);    //挨个取出类别并填入类别数组
                    }
                    for (var d = 0; d < data.length; d++) {
                        SCus.push(data[d].scu);    //挨个取出销量并填入销量数组
                    }
                    for (var e = 0; e < data.length; e++) {
                        WCus.push(data[e].wcu);    //挨个取出类别并填入类别数组
                    }
                    for (var f = 0; f < data.length; f++) {
                        WSs.push(data[f].ws);    //挨个取出类别并填入类别数组
                    }
                    myChart1.hideLoading();    //隐藏加载动画
                    myChart1.setOption({        //加载数据图表
                        //         // xAxis: {
                        //         //     data: names1
                        //         //
                        //         // },
                        series: [{
                            name: '铜精矿硫(%)',
                            data: CuSs
                        },
                            {
                                name: '铜精矿铜(%)',
                                data: CuCus
                            },
                            {
                                name: '硫精矿硫(%)',
                                data: SSs
                            },
                            {
                                name: '硫精矿铜(%)',
                                data: SCus
                            },
                            {
                                name: '尾矿铜(%)',
                                data: WCus
                            },
                            {
                                name: '尾矿硫(%)',
                                data: WSs
                            }
                        ]
                    });
                    window.addEventListener("resize", function () {
                            myChart1.resize();
                        }
                    )

            }
            else {
                $("#scdata").text("无品位数据").css("margin-top","25%").css("margin-left","35%").css("color","#FFFFFF").css("font-size","16px");
            }

        },
        complete: function () {
            isLoaded1 = true;
        },
        error : function() {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart1.hideLoading();
        }
    });
}
reqs1();
setInterval(function () {
    isLoaded1 && reqs1()
}, 1800000);    //请求时间间隔



// 基于准备好的dom，初始化echarts实例
/*磨浮1点检统计*/
var myChart2 = echarts.init(document.getElementById('djdata'));

// 指定图表的配置项和数据
myChart2.setOption({
    tooltip: {},

    grid: { top: '20%', left: '3%', right: '4%', bottom: '5%', containLabel: true },
    legend: {
        data:['已检','未检','报警','危险'],
        // textStyle:{
        //     color:'#ffffff'
        // },
        // bottom:'5%'
        top:'0%',
        itemWidth: 10,
        itemHeight: 8,
        textStyle:{
            color:'#ffffff'
        }
    },
    xAxis: {
        data: [],
        axisLine:{
            lineStyle:{
                color:'white'
            }
        }
    },
    yAxis: {
        axisLine:{
            lineStyle:{
                color:'white'
            }
        }
    },
    series: [
        {
        name: '已检',
        type: 'bar',
        data: []
        },
        {
            name: '未检',
            type: 'bar',
            data: []
        },
        {
            name: '报警',
            type: 'bar',
            data: []
        },
        {
            name: '危险',
            type: 'bar',
            data: []
        }]
});
myChart2.showLoading();
var isLoaded2 = false;
function reqs2() {
    var checkeds2=[];
    var uncheckeds2=[];
    var alarms2=[];
    var dangers2=[];
    var sections2=[];
    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/process/grindingFloat/fx_1_spot",    //请求发送到TestServlet处
        data : {},
        dataType : "json", //返回数据形式为json
        beforeSend: function () {
            isLoaded2= false;
        },
        success : function(result) {

                //请求成功时执行该函数内容，result即为服务器返回的json对象
                var data = result.data;
            if(data.length>0) {
                if (data) {
                    for (var a = 0; a < data.length; a++) {
                        sections2.push(data[a].section);
                    }
                    for (var b = 0; b < data.length; b++) {
                        checkeds2.push(data[b].checked);
                    }
                    for (var c = 0; c < data.length; c++) {
                        uncheckeds2.push(data[c].unchecked);
                    }
                    for (var d = 0; d < data.length; d++) {
                        alarms2.push(data[d].alarm);
                    }
                    for (var e = 0; e < data.length; e++) {
                        dangers2.push(data[e].danger);
                    }
                    myChart2.hideLoading();    //隐藏加载动画
                    myChart2.setOption({        //加载数据图表
                        xAxis: {
                            data: sections2
                        },
                        series: [{
                            name: '已检',
                            data: checkeds2,
                            itemStyle: {
                                normal: {
                                    color: '#06ff26'
                                }
                            }
                        },
                            {
                                name: '未检',
                                data: uncheckeds2,
                                itemStyle: {
                                    normal: {
                                        color: '#fffe0f'
                                    }
                                }
                            },
                            {
                                name: '报警',
                                data: alarms2,
                                itemStyle: {
                                    normal: {
                                        color: '#ff9308'
                                    }
                                }
                            },
                            {
                                name: '危险',
                                data: dangers2,
                                itemStyle: {
                                    normal: {
                                        color: '#ff321b'
                                    }
                                }
                            }

                        ]
                    });

                    window.addEventListener("resize", function () {
                        myChart2.resize();
                    })

                }
            }
            else {
                $("#djdata").text("无点检数据").css("line-height","1500%").css("left","35%").css("color","#FFFFFF").css("font-size","16px");
            }
        },
        complete: function () {
            isLoaded2 = true;
        },
        error : function() {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart2.hideLoading();
        }
    });
}
reqs2();
setInterval(function () {
    isLoaded2 && reqs2()
}, 1800000);

// 基于准备好的dom，初始化echarts实例
/*磨浮1缺陷处理*/
var myChart3 = echarts.init(document.getElementById('qxcl'));
// 指定图表的配置项和数据
myChart3.setOption({
    tooltip: {},

    grid: { top: '20%', left: '3%', right: '4%', bottom: '5%', containLabel: true },
    legend: {
        data:['异常总数','已处理','未处理'],
        // textStyle:{
        //     color:'#ffffff'
        // },
        // bottom:'3%'
        top:'0%',
        itemWidth: 10,
        itemHeight: 8,
        textStyle:{
            color:'#ffffff'
        }
    },
    xAxis: {
        data: [],
        axisLine:{
            lineStyle:{
                color:'white'
            }
        }
    },
    yAxis: {
        axisLine:{
            lineStyle:{
                color:'white'
            }
        }
    },
    series: [
        {
            name: '异常总数',
            type: 'bar',
            data: []
        },
        {
            name: '已处理',
            type: 'bar',
            data: []
        },
        {
            name: '未处理',
            type: 'bar',
            data: []
        }]
});
myChart3.showLoading();
var isLoaded3 = false;
function reqs3(){
    var sections=[];
    var totals=[];
    var processeds=[];
    var untreateds=[];
    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/process/float/FX_1_defect_treatment",    //请求发送到TestServlet处
        data : {},
        dataType : "json", //返回数据形式为json
        beforeSend: function () {
            isLoaded3= false;
        },
        success : function(result) {

                //请求成功时执行该函数内容，result即为服务器返回的json对象
                var data = result.data;
            if(data.length>0) {
                if (data) {
                    for (var a = 0; a < data.length; a++) {
                        sections.push(data[a].section);
                    }
                    for (var b = 0; b < data.length; b++) {
                        totals.push(data[b].total);
                    }
                    for (var c = 0; c < data.length; c++) {
                        processeds.push(data[c].processed);
                    }
                    for (var d = 0; d < data.length; d++) {
                        untreateds.push(data[d].untreated);
                    }
                    myChart3.hideLoading();    //隐藏加载动画
                    myChart3.setOption({        //加载数据图表
                        xAxis: {
                            data: sections
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '异常总数',
                            data: totals,
                            itemStyle: {
                                normal: {
                                    color: '#ff9308'
                                }
                            }
                        },
                            {
                                // 根据名字对应到相应的系列
                                name: '已处理',
                                data: processeds,
                                itemStyle: {
                                    normal: {
                                        color: '#06ff26'
                                    }
                                }
                            }
                            , {
                                // 根据名字对应到相应的系列
                                name: '未处理',
                                data: untreateds,
                                itemStyle: {
                                    normal: {
                                        color: '#ff321b'
                                    }
                                }
                            }
                        ]
                    });
                    window.addEventListener("resize", function () {
                        myChart3.resize();
                    })

                }
            }
            else {
                $("#qxcl").text("无缺陷数据").css("line-height","1500%").css("left","35%").css("color","#FFFFFF").css("font-size","16px");
            }
        },
        complete: function () {
            isLoaded3 = true;
        },
        error : function() {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart3.hideLoading();
        }
    })
}
reqs3();
setInterval(function () {
    isLoaded3 && reqs3()
}, 1800000);    //请求时间间隔

var isLoaded4 = false;
function getAlarmData(param) {
    // var data = {"value":param};
    $.ajax({
        url:"/spot/fx/alarm",
        data : {},
        type:"get",
        cache:false,
        async: false,
        // dataType:"json",
        beforeSend: function() {
            isLoaded4 = false;
        },
        success: function (result) {
            var  json=result.data;
            $('#tab tr:gt(0)').remove();
            var s = '';
            if(json.length>0){
                for (var i = 0; i < json.length; i++){
                    s +='<tr><td>' +
                        json[i].equip + '</td><td>'
                        + json[i].part + '</td><td>'
                        + json[i].spot + '</td><td>'
                        + json[i].value + '</td><td>'
                        +json[i].level +'</td><td>'
                        +json[i].flag +'</td></tr>'
                    ;}
                $('#tab').append(s);
            }
            else {

                $(".alarmbody").css("background-image","url(/images/arrow/yes.png)")
                    .css("background-position","center").css("background-repeat","no-repeat")
                    .css("height","100%").css("background-size","100%");
                $(".thirdColumn").css("overflow","hidden");

            }
        },
        complete: function() {
            isLoaded4 = true;
          },
        error: function () {
            //请求失败时执行该函数
            alert("报警数据请求失败!");
        }

    });

}
getAlarmData();
setInterval(function () {
    isLoaded4 && getAlarmData()
}, 1800000);    //请求时间间隔


