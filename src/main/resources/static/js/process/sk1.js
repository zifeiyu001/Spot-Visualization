


// 基于准备好的dom，初始化echarts实例
/*碎矿点检统计*/
var myChart2 = echarts.init(document.getElementById('djdata'));

// 指定图表的配置项和数据
myChart2.setOption({
    tooltip: {},
    // title: {
    //     text: '点检数据',
    //     left:'center',
    //     top:'5%',
    //     textStyle:{
    //         color:'#ffffff'
    //     }},
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
        url : "/spot/sk/spot",    //请求发送到TestServlet处
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
                for(var a=0;a<data.length;a++){
                    sections2.push(data[a].section);
                }
                for(var b=0;b<data.length;b++){
                    checkeds2.push(data[b].checked);
                }
                for(var c=0;c<data.length;c++){
                    uncheckeds2.push(data[c].unchecked);
                }
                for(var d=0;d<data.length;d++){
                    alarms2.push(data[d].alarm);
                }
                for(var e=0;e<data.length;e++){
                    dangers2.push(data[e].danger);
                }
                myChart2.hideLoading();    //隐藏加载动画
                myChart2.setOption({        //加载数据图表
                    xAxis: {
                        data: sections2
                    },
                    series: [{
                        name: '已检',
                        data:checkeds2,
                        itemStyle:{
                            normal:{
                                color:'#06ff26' } }
                    },
                        {
                            name: '未检',
                            data:uncheckeds2,
                            itemStyle:{
                                normal:{
                                    color:'#fffe0f' } }
                        },
                        {
                            name: '报警',
                            data:alarms2,
                            itemStyle:{
                                normal:{
                                    color:'#ff9308' } }
                        },
                        {
                            name: '危险',
                            data:dangers2,
                            itemStyle:{
                                normal:{
                                    color:'#ff321b' } }
                        }

                    ]
                });

                window.addEventListener("resize",function () {
                    myChart2.resize();
                })

            }
            }

            else {
                $("#djdata").text("当日无点检任务").css("margin","34%").css("color","#FFFFFF").css("font-size","16px")

            }
        },
        complete: function () {
            isLoaded2 = true;
        },
        error : function() {
            //请求失败时执行该函数
            alert("点检图表请求数据失败!");
            myChart2.hideLoading();
        }
    });
}
reqs2();
setInterval(function () {
    isLoaded2 && reqs2()
}, 1800000);

// 基于准备好的dom，初始化echarts实例
/*碎矿缺陷处理*/
var myChart3 = echarts.init(document.getElementById('qxcl'));
// 指定图表的配置项和数据
myChart3.setOption({

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
        url : "/spot/sk/defect_treatment",    //请求发送到TestServlet处
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
                for(var a=0;a<data.length;a++){
                    sections.push(data[a].section);
                }
                for(var b=0;b<data.length;b++){
                    totals.push(data[b].total);
                }
                for(var c=0;c<data.length;c++){
                    processeds.push(data[c].processed);
                }
                for(var d=0;d<data.length;d++){
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
                        itemStyle:{
                            normal:{
                                color:'#ff9308' } }
                    },
                        {
                            // 根据名字对应到相应的系列
                            name: '已处理',
                            data: processeds,
                            itemStyle:{
                                normal:{
                                    color:'#06ff26' } }
                        }
                        ,{
                            // 根据名字对应到相应的系列
                            name: '未处理',
                            data: untreateds,
                            itemStyle:{
                                normal:{
                                    color:'#ff321b' } }
                        }
                    ]
                });
                window.addEventListener("resize",function () {
                    myChart3.resize();
                })

            }
            }

            else {
                $("#qxcl").text("无缺陷内容").css("margin-top","30%").css("margin-left","39%").css("color","#FFFFFF").css("font-size","16px");
            }
        },
        complete: function () {
            isLoaded3 = true;
        },
        error : function() {
            //请求失败时执行该函数
            alert("缺陷处理图表请求数据失败!");
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
    $.ajax({
        url:"/spot/sk/alarm",
        data : {},
        type:"get",
        cache:false,
        async: false,
        // dataType:"json",
        beforeSend: function() {
            isLoaded4 = false;
        },
        success: function (result) {
            var json = result.data;
            $('#tab tr:gt(0)').remove();
            var s = '';
            if (json.length > 0) {

            for (var i = 0; i < json.length; i++) {
                s += '<tr><td>' +
                    json[i].equip + '</td><td>'
                    + json[i].part + '</td><td>'
                    + json[i].spot + '</td><td>'
                    + json[i].value + '</td><td>'
                    + json[i].level + '</td><td>'
                    + '<button style="cursor: pointer;color: #FFFFFF" style="cursor: pointer;color: #FFFFFF" onclick="dealWith(\'' + json[i].id + '\')">处理</button>'
                    + '</td></tr>'
                ;
            }
                $('#tab').append(s);
            }
            else {
            $(".alarmbody").css("background-image","url(/images/arrow/yes.png)")
                .css("background-position","center").css("background-repeat","no-repeat")
                .css("height","100%").css("background-size","25%");
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


//----------------------判断页面是否是全屏状态---------------------
function IsFull(){
    var a="";
    var b="";
    a= window.document.body.clientHeight;
    b=window.screen.height;
    if( a-b==0){
        tableHeight();
        tableAlarmColor();
    }else{
        tableHeight();
        tableAlarmColor();

    }
}
IsFull();
setInterval(function () {
    IsFull()
},1000);     //请求时间间隔

//--------------报警表格的高度设置------------------------
function tableHeight() {
    var s = document.getElementById("alarm1").scrollHeight;

    var s1 = document.getElementById("alarm2").scrollHeight;

    var s2 = document.getElementById("secondColumn").scrollHeight;

    var myDiv = document.getElementById("tablebody");

    var a= myDiv.style.height = (s - s1-s2)*0.84 + "px";


}


//------------报警表格等级设置背景色----------------------------
function tableAlarmColor(){
    var table = document.getElementById("tab");
    // var len = table.rows.length;
    var _row = table.rows;

    for(var i = 0;i < table.rows.length;i++){
        var _cell = _row[i].cells;
        var d=_cell[4].innerHTML;
        var a="一级";
        var b="二级";
        if(d==a){
            table.rows[i].cells.item(4).style.color = "#eef4e8";

        }
        if(d==b){
            table.rows[i].cells.item(4).style.color = "#FFC107";

        }
    }
}
function flashit(){
    var table = document.getElementById("tab");
    var _row = table.rows;
    for(var i = 0;i < table.rows.length;i++){
        var _cell = _row[i].cells;
        var d=_cell[4].innerHTML;


        if(d=="一级"){

            if (table.rows[i].style.backgroundColor  =="transparent"){
                table.rows[i].style.backgroundColor ="darkred";
            }
            else{
                table.rows[i].style.backgroundColor ="transparent";
            }

        }
    }
    return true;
}
setInterval("flashit()", 500);
//----------------------处理报警-------------------------
function dealWith(id,section) {
    //获取报警处理内用
    var remark = prompt("故障原因及处理结果"); //将输入的内容赋给变量 name ，

    //判断报警内容并操作
    if (remark.length<1){alert("故障原因及处理结果");dealWith(id,section)}
    else {

        $.ajax({
            url: "/spot/Universal/alarm/update",

            contentType: "application/json",
            data:JSON.stringify({
                "id":id,
                "remark":remark
            }),

            // data: id+"#=#"+remark,
            type: "post",
            cache: false,
            async: false,
            dataType: "json",
            success : function(result) {
                getAlarmData(section);
                alert("处理成功！");
            },
            error : function() {
                alert("处理失败，请重试！");
            }
        })}
}