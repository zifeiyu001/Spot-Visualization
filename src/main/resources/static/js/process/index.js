
//
// //==================判断session中是否保存用户=================
// if(username ==null || username ==undefined || username ==''|| username =='null') {
//     //获取来源用户名，并在系统中保存
//     function GetQueryString(name){
//         var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
//         var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
//         if(r!=null)return  unescape(r[2]); return null;
//     }
//     var name = GetQueryString("user");
//
//
//     if (name ==null || name ==undefined || name ==''|| name =='null') {
//         alert("请进行登录");
//         window.location.href='http://172.16.5.4/bkzyCMS/login';
//     }
//     else {
//         getUser(name);
//     }
//
// }
//==================判断登录用户=================
// 获取登录用户id
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    if(r!=null)return  unescape(r[2]); return null;
}
var name = GetQueryString("user");
//登录用户不为空，session不为空；判断存储的session和登录用户不同时更新session
if(username !=null && username !==undefined && username !==''&& username !=='null') {
    if (name !==null && name !==undefined && name !==''&& name !=='null') {
        if (username===name) {}
        else {getUser(name);}
    }
}
//session为空；登录用户为空，重新登录；登录用户不为空时，更新session
else {
    if (name ===null || name === undefined || name ===''|| name ==='null') {
        alert("请进行登录");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    } else {  getUser(name)}
}

// 将用户保存到后台，session
function getUser(name){

    $.ajax({
        url: "/spot/user",

        contentType: "application/json",
        data:JSON.stringify({
            "name":name
        }),
        type: "post",
        cache: false,
        async: false,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            if(data.user_name==''){

                alert("账户不存在，请重新登录...");
                window.location.href='http://172.16.5.4/bkzyCMS/login';
            }
        }
    });
}


//==================================饼图==================================
// 基于准备好的dom，初始化echarts实例
var myChart1 = echarts.init(document.getElementById('sc1'));
var myChart2 = echarts.init(document.getElementById('dy1'));
var myChart3 = echarts.init(document.getElementById('sb1'));

// 指定图表的配置项和数据
option={
    tooltip: {
        trigger: 'item',
        formatter: "{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'horizontal',
        top:'0%',
        itemWidth: 8,
        itemHeight: 6,
        data:['已检','正常','危险','报警','未检'],
        textStyle:{
            color:'#ffffff'
        }
    },
    series: [
        {
            type:'pie',
            selectedMode: 'single',
            radius: ['0%', '40%'],
            label: {
                normal: {
                    position: 'inner'
                }
            },
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },
                normal:{
                    color:function(params) {
                        //自定义颜色
                        var colorList = [
                            '#a8eeb3','#a6a59d'
                        ];
                        return colorList[params.dataIndex]
                    }
                }
            },
            data:[
                {
                    name: '已检未检',
                    data:[]
                }
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius: ['45%', '60%'],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },
                normal:{
                    color:function(params) {
                        //自定义颜色
                        var colorList = [
                            '#06ff26', '#ff9308','#ff1f3c','#a6a59d'
                        ];
                        return colorList[params.dataIndex]
                    },
                    labelLine:{
                        length:0.1
                    }
                }
            },

            data:[
                {
                    name: '占比',
                    data:[]
                }
            ]
        }
    ]
};
myChart1.setOption(option);
myChart1.showLoading();
myChart2.setOption(option);
myChart2.showLoading();
myChart3.setOption(option);
myChart3.showLoading();


function reqs() {
    var isLoaded1=false;
    var isLoaded2=false;
    var isLoaded3=false;
    var complete1=[];
    var normal1=[];
    var danger1=[];
    var alarm1=[];
    var incomplete1=[];
    var complete2=[];
    var normal2=[];
    var danger2=[];
    var alarm2=[];
    var incomplete2=[];
    var complete3=[];
    var normal3=[];
    var danger3=[];
    var alarm3=[];
    var incomplete3=[];
    $.ajax({
        type: "get",
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/spot/index_sc",    //请求发送到TestServlet处
        data: {},
        dataType: "json",
        beforeSend: function () {
            isLoaded1= false;
        },
        //返回数据形式为json
        success: function (result) {


            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var data = result.data;

            if (data.length>0) {
                for (var a = 0; a < data.length; a++) {
                    if (data[a].complete == 0) null;
                    else complete1.push(data[a].complete);
                }
                for (var b = 0; b < data.length; b++) {
                    if (data[b].normal == 0) null;
                    else normal1.push(data[b].normal);
                }
                for (var c = 0; c < data.length; c++) {
                    if (data[c].danger == 0) null;
                    else danger1.push(data[c].danger);
                }
                for (var d = 0; d < data.length; d++) {
                    if (data[d].alarm == 0) null;
                    else alarm1.push(data[d].alarm);
                }
                for (var e = 0; e < data.length; e++) {
                    if (data[e].incomplete == 0) null;
                    else incomplete1.push(data[e].incomplete);
                }

                myChart1.hideLoading();    //隐藏加载动画
                myChart1.setOption({        //加载数据图表
                    series: [
                        {
                            name: '已检未检',
                            data: [
                                {name: "已检", value: complete1},
                                {name: "未检", value: incomplete1}
                            ]

                        },
                        {
                            name: '占比',
                            data: [
                                {name: "正常", value: normal1},
                                {name: "危险", value: danger1},
                                {name: "报警", value: alarm1},
                                {name: "未检", value: incomplete1}
                            ]
                        }
                    ]
                });
                window.addEventListener("resize", function () {
                    myChart1.resize();
                })
            }
            else {
                $("#sc1").text("无点检数据").css("margin-top","30%").css("color","#FFFFFF").css("font-size","16px");
            }

        },
        complete: function () {
            isLoaded1 = true;
        },
        error: function () {
            //请求失败时执行该函数
            alert("生产点检图表请求数据失败!");
            myChart1.hideLoading();
        }
    });
    $.ajax({
        type: "get",
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/spot/index_dy",    //请求发送到TestServlet处
        data: {},
        dataType: "json",
        beforeSend: function () {
            isLoaded2 = false;
        },
        //返回数据形式为json
        success: function (result) {

            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var data = result.data;
            if (data.length>0) {
                for (var a = 0; a < data.length; a++) {
                    if(data[a].complete==0) null;
                    else complete2.push(data[a].complete);
                }
                for (var b = 0; b < data.length; b++) {
                    if(data[b].normal==0) null;
                    else normal2.push(data[b].normal);
                }
                for (var c = 0; c < data.length; c++) {
                    if(data[c].danger==0) null;
                    else danger2.push(data[c].danger);
                }
                for (var d = 0; d < data.length; d++) {
                    if(data[d].alarm==0) null;
                    else alarm2.push(data[d].alarm);
                }
                for (var e = 0; e < data.length; e++) {
                    if(data[e].incomplete==0) null;
                    else  incomplete2.push(data[e].incomplete);
                }

                myChart2.hideLoading();    //隐藏加载动画
                myChart2.setOption({        //加载数据图表
                    series: [
                        {
                            name: '已检未检',
                            data: [
                                {name: "已检", value: complete2},
                                {name: "未检", value: incomplete2}
                            ]

                        },
                        {
                            name: '占比',
                            data: [
                                {name: "正常", value: normal2},
                                {name: "危险", value: danger2},
                                {name: "报警", value: alarm2},
                                {name: "未检", value: incomplete2}
                            ]
                        }
                    ]
                });
                window.addEventListener("resize", function () {
                    myChart2.resize();
                })
            }
            else {
                $("#dy1").text("无点检数据").css("margin-top","30%").css("color","#FFFFFF").css("font-size","16px");
            }
        },
        complete: function () {
            isLoaded2 = true;
        },
        error: function () {
            //请求失败时执行该函数
            alert("电仪点检图表请求数据失败!");
            myChart2.hideLoading();
        }
    });
    $.ajax({
        type: "get",
        async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/spot/index_sb",    //请求发送到TestServlet处
        data: {},
        dataType: "json",
        beforeSend: function () {
            isLoaded3 = false;
        },
        //返回数据形式为json
        success: function (result) {

            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var data = result.data;
            if (data.length>0) {
                for (var a = 0; a < data.length; a++) {
                    if(data[a].complete==0) null;
                    else complete3.push(data[a].complete);
                }
                for (var b = 0; b < data.length; b++) {
                    if(data[b].normal==0) null;
                    else normal3.push(data[b].normal);
                }
                for (var c = 0; c < data.length; c++) {
                    if(data[c].danger==0) null;
                    else danger3.push(data[c].danger);
                }
                for (var d = 0; d < data.length; d++) {
                    if(data[d].alarm==0) null;
                    else alarm3.push(data[d].alarm);
                }
                for (var e = 0; e < data.length; e++) {
                    if(data[e].incomplete==0) null;
                    else incomplete3.push(data[e].incomplete);
                }
                myChart3.hideLoading();    //隐藏加载动画
                myChart3.setOption({        //加载数据图表
                    series: [
                        {
                            name: '已检未检',
                            data: [
                                {name: "已检", value: complete3},
                                {name: "未检", value: incomplete3}
                            ]
                        },
                        {
                            name: '占比',
                            data: [
                                {name: "正常", value: normal3},
                                {name: "危险", value: danger3},
                                {name: "报警", value: alarm3},
                                {name: "未检", value: incomplete3}
                            ]
                        }
                    ]
                });
                window.addEventListener("resize", function () {
                    myChart3.resize();
                })
            }
            else {
                $("#sb1").text("无点检数据").css("margin-top","30%").css("color","#FFFFFF").css("font-size","16px");
            }
        },
        complete: function () {
            isLoaded3 = true;
        },
        error: function () {
            //请求失败时执行该函数
            alert("设备点检图表请求数据失败!");
            myChart3.hideLoading();
        }
    });
}
reqs();
setInterval(function () {
    isLoaded1 && isLoaded2 && isLoaded3 && reqs()
}, 1800000);    //请求时间间隔


getAlarmData('sb');
//=====================获取报警数据==========================
var isLoaded = false;
function getAlarmData(param) {
    var data = {"value":param};
    if (param=='sc')
    {
        $("#tablename").html('生产报警数据');
        }
    if (param=='dy')
    {
        $("#tablename").html('电仪报警数据');
        }
    if (param=='sb')
    {
        $("#tablename").html('设备报警数据');

    }
    $.ajax({
        url:"/spot/index/alarm",
        contentType: "application/json",
        data:JSON.stringify(data),
        type:"post",
        cache:false,
        async: false,
        dataType:"json",
        beforeSend: function() {
            isLoaded= false;
        },
        success: function (result) {
            var  json=result.data;
            $('#tab tr:gt(0)').remove();
            var s = '';
            if(json.length>0){
                for (var i = 0; i < json.length; i++){
                    s +='<tr><td>' +
                        json[i].devName + '</td><td>'
                        + json[i].spot + '</td><td>'
                        + json[i].content + '</td><td>'
                        + json[i].result + '</td><td>'
                        +json[i].level + '</td><td>'
                        +'<button style="cursor: pointer;color: #FFFFFF" onclick="dealWith(\''+json[i].id+'\',\''+param+'\')">处理</button>'
                        +'</td></tr>'
                    ;}
                $('#tab').append(s);
            }
            else {
                $(".alarmbody").css("background-image", "url(/images/arrow/yes.png)")
                    .css("background-position", "center").css("background-repeat", "no-repeat")
                    .css("height", "100%").css("background-size", "100%");
                $(".thirdColumn").css("overflow","hidden");
            }
        },
        complete: function() {
            isLoaded = true;
            // tableAlarmColor();
            f(param);},
        error: function () {
            //请求失败时执行该函数
            alert("报警数据请求失败!");
        }
    })
}
function f(param){
    setInterval(function () {
        isLoaded &&  getAlarmData(param)
    },1800000);     //请求时间间隔
}

var isLoaded1 = false;
var isLoaded2 = false;
function reqs1(opts){
    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/index/indexShow",    //请求发送到TestServlet处
        data : {},
        dataType : "json",
        beforeSend: function() {
            isLoaded1 = false;
        },
        success : function(result){
            var  data=result.data;
            if(data[0].total!=null) document.getElementById('total').innerHTML =data[0].total;
            else document.getElementById('total').innerHTML ='###';

            if(data[0].danger!=null) document.getElementById('danger').innerHTML =data[0].danger;
            else document.getElementById('danger').innerHTML ='###';

            if(data[0].alarm!=null) document.getElementById('alarm').innerHTML =data[0].alarm;
            else document.getElementById('alarm').innerHTML ='###';

            if(data[0].kw!=null) document.getElementById('kw').innerHTML =data[0].kw;
            else document.getElementById('kw').innerHTML ='###';
        },
        complete: function() {
            isLoaded1 = true; }
        // error : function() {
        //     //请求失败时执行该函数
        //     textId.val("重要数据显示请求失败");
        // }
    });}
    function reqs2(opts){
    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/index/indexChartData",    //请求发送到TestServlet处
        data : {},
        dataType : "json",
        beforeSend: function() {
            isLoaded2 = false;
        },
        success : function(result){
            var  data=result.data;
            if(data[0].Cu!=null) document.getElementById('Cu').innerHTML =data[0].Cu;
            else document.getElementById('Cu').innerHTML ='###';
            if(data[0].WCu!=null) document.getElementById('WCu').innerHTML =data[0].WCu;
            else document.getElementById('WCu').innerHTML ='###';
            if(data[0].WS!=null) document.getElementById('WS').innerHTML =data[0].WS;
            else document.getElementById('WS').innerHTML ='###';
            if(data[0].CuCu!=null) document.getElementById('CuCu').innerHTML =data[0].CuCu;
            else document.getElementById('CuCu').innerHTML ='###';
            if(data[0].CLL!=null) document.getElementById('CLL').innerHTML =data[0].CLL;
            else document.getElementById('CLL').innerHTML ='###';
            if(data[0].NDJ1ND!=null) document.getElementById('NDJ1ND').innerHTML =data[0].NDJ1ND;
            else document.getElementById('NDJ1ND').innerHTML ='###';

        },
        complete: function() {
            isLoaded2 = true; }
    })
}
reqs1({"init":1});
setInterval(function () {
    isLoaded1 &&  reqs1({"init":0})
},1800000);     //请求时间间隔
reqs2({"init":1});
setInterval(function () {
    isLoaded2 &&  reqs2({"init":0})
},1800000);     //请求时间间隔

function toggle(id){
    var tb=document.getElementById(id);
    if(tb.style.display=='none') tb.style.display='block';
    else tb.style.display='none';
}