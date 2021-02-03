


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
    // alert(username)
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
            if(data==''){

                alert("账户不存在，请重新登录...");
                window.location.href='http://172.16.5.4/bkzyCMS/login';
            }
        }
    });

}
function login(){
    $.ajax({
        url: "/spot/changeShifts/login",
        contentType: "application/json",
        type: "get",
        cache: false,
        async: false,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            var routes=result.routes;
            var user=result.user;
            var jurisdiction=result.jurisdiction;

            if (jurisdiction==='offDuty'){
                alert("非当班人员");
                // window.location.href = "about:blank";
            }else if (jurisdiction==='successionNo'){
                alert("上个班未进行交班内容的填写");
                getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                $(".shift").attr('readonly',true);
                $(".succession").attr('readonly',true);
                $("#shift").val(result.shifts);
                $("#date").val(result.date);
                $("#team").val(result.team);
                $(".button").attr('disabled',true);
                $(".shiftButton").attr('disabled',true);
                $(".successionButton").attr('disabled',true);
                // alert(result.deptName+"---"+result.routes+"---"+result.startTime+"---"+result.endTime);
            } else if(jurisdiction==='succession'){
                // alert(result.deptName+"---"+result.routes+"---"+result.startTime+"---"+result.endTime);
                alert("请进行接班");
                if (data.length>0){
                    alert("接班有数据");

                    showData(data);
                    $(".shift").attr('readonly',true);
                    $(".button").attr('disabled',true);
                    $(".shiftButton").attr('disabled',true);
                    $(".shiftRemark").attr('disabled',true);
                } else {
                    alert("接班无数据");
                    $(".shift").attr('readonly',true);
                    $(".succession").attr('readonly',true);
                    $("#shift").val(result.shifts);
                    $("#date").val(result.date);
                    $("#team").val(result.team);
                    $(".button").attr('disabled',true);
                    $(".shiftButton").attr('disabled',true);
                    // $(".successionButton").attr('disabled',true);
                }
                $("#successionname").val(user);

                getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
            }else if (jurisdiction==='shift'){
                alert("请填写交班内容1");
                // alert(result.deptName+"---"+result.routes+"---"+result.startTime+"---"+result.endTime);
                if (data.length>0){
                    alert("交班有数据");
                    if (data[0].shiftstate==='Y') {
                            alert("已完成交班");
                        // window.location.href = "about:blank";
                    }else {
                        getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                        showData(data);
                    }
                } else {
                    alert("交班无数据");
                    getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                    $("#shift").val(result.shifts);
                    $("#date").val(result.date);
                    $("#team").val(result.team);

                }
                $(".successionButton").attr('disabled',true);
                $("#shiftname").val(user);
                $(".succession").attr('readonly',true);

            }else if (jurisdiction==='unshift'){
                alert("请填写交班内容2");
                // alert(result.deptName+"---"+result.routes+"---"+result.startTime+"---"+result.endTime);
                if (data.length>0){
                    alert("交班有数据");
                    if (data[0].shiftstate==='Y') {
                        alert("已完成交班");
                        // window.location.href = "about:blank";
                    }else {
                        getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                        showData(data);
                    }
                } else {
                    alert("交班无数据");
                    getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                    $("#shift").val(result.shifts);
                    $("#date").val(result.date);
                    $("#team").val(result.team);

                }
                $(".successionButton").attr('disabled',true);
                $(".shiftButton").attr('disabled',true);
                $("#shiftname").val(user);
                $(".succession").attr('readonly',true);

            }else if(jurisdiction==='noshift'){
                if (data.length>0){
                    alert("交班有数据");
                    getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                    showData(data);
                } else {
                    alert("交班无数据");
                    getSpotData(result.deptName,result.routes,result.startTime,result.endTime);
                    $("#shift").val(result.shifts);
                    $("#date").val(result.date);
                    $("#team").val(result.team);


                }
                // $("#shiftname").val(user);
                $(".shift").attr('readonly',true);
                $(".succession").attr('readonly',true);
                $(".button").attr('disabled',true);
                $(".shiftButton").attr('disabled',true);
                $(".successionButton").attr('disabled',true);

            }
            else {
                alert("内容获取失败");
            }
            if (getTime()!==true){
                $(".shiftButton").attr('disabled',true);
                $(".successionButton").attr('disabled',true);
                $(".shiftRemark").attr('disabled',true);
            }
        }
    });

}


login();
function showData(data) {
    $("#team").val(data[0].team);
    $("#date").val(data[0].dete);
    $("#shift").val(data[0].shift);
    $("#pot1successionlevel").val(data[0].pot1successionlevel);
    $("#pot1shiftlevel").val(data[0].pot1shiftlevel);
    $("#cars1").val(data[0].cars1);
    $("#pot2successionlevel").val(data[0].pot2successionlevel);
    $("#pot2shiftlevel").val(data[0].pot2shiftlevel);
    $("#cars2").val(data[0].cars2);

    $("#feeder1start1").val(data[0].feeder1start1);
    $("#feeder1end1").val(data[0].feeder1end1);
    $("#feeder1speed1").val(data[0].feeder1speed1);
    $("#feeder1water1").val(data[0].feeder1water1);
    $("#feeder2start1").val(data[0].feeder2start1);
    $("#feeder2end1").val(data[0].feeder2end1);
    $("#feeder2speed1").val(data[0].feeder2speed1);
    $("#feeder2water1").val(data[0].feeder2water1);

    $("#feeder1start2").val(data[0].feeder1start2);
    $("#feeder1end2").val(data[0].feeder1end2);
    $("#feeder1speed2").val(data[0].feeder1speed2);
    $("#feeder1water2").val(data[0].feeder1water2);
    $("#feeder2start2").val(data[0].feeder2start2);
    $("#feeder2end2").val(data[0].feeder2end2);
    $("#feeder2speed2").val(data[0].feeder2speed2);
    $("#feeder2water2").val(data[0].feeder2water2);

    $("#feeder1start3").val(data[0].feeder1start3);
    $("#feeder1end3").val(data[0].feeder1end3);
    $("#feeder1speed3").val(data[0].feeder1speed3);
    $("#feeder1water3").val(data[0].feeder1water3);
    $("#feeder2start3").val(data[0].feeder2start3);
    $("#feeder2end3").val(data[0].feeder2end3);
    $("#feeder2speed3").val(data[0].feeder2speed3);
    $("#feeder2water3").val(data[0].feeder2water3);

    $("#feeder1start4").val(data[0].feeder1start4);
    $("#feeder1end4").val(data[0].feeder1end4);
    $("#feeder1speed4").val(data[0].feeder1speed4);
    $("#feeder1water4").val(data[0].feeder1water4);
    $("#feeder2start4").val(data[0].feeder2start4);
    $("#feeder2end4").val(data[0].feeder2end4);
    $("#feeder2speed4").val(data[0].feeder2speed4);
    $("#feeder2water4").val(data[0].feeder2water4);

    $("#tailingpondtime").val(data[0].tailingpondtime);
    $("#limepump1runtime").val(data[0].limepump1runtime);
    $("#limepump2runtime").val(data[0].limepump2runtime);
    $("#limepump3runtime").val(data[0].limepump3runtime);
    $("#sewageregulationtime").val(data[0].sewageregulationtime);
    $("#equipmentlubrication").val(data[0].equipmentlubrication);
    $("#machinesanitation").val(data[0].machinesanitation);


    $("#checktime1").val(data[0].checktime1);
    $("#materialtank1check1").val(data[0].materialtank1check1);
    $("#materialtank2check1").val(data[0].materialtank2check1);
    $("#screwfeedercheck1").val(data[0].screwfeedercheck1);
    $("#mixingdrum3mcheck1").val(data[0].mixingdrum3mcheck1);
    $("#mixingdrum4mcheck1").val(data[0].mixingdrum4mcheck1);
    $("#pumpcheck1").val(data[0].pumpcheck1);
    $("#electricmachinerycheck1").val(data[0].electricmachinerycheck1);

    $("#checktime2").val(data[0].checktime2);
    $("#materialtank1check2").val(data[0].materialtank1check2);
    $("#materialtank2check2").val(data[0].materialtank2check2);
    $("#screwfeedercheck2").val(data[0].screwfeedercheck2);
    $("#mixingdrum3mcheck2").val(data[0].mixingdrum3mcheck2);
    $("#mixingdrum4mcheck2").val(data[0].mixingdrum4mcheck2);
    $("#pumpcheck2").val(data[0].pumpcheck2);
    $("#electricmachinerycheck2").val(data[0].electricmachinerycheck2);

    $("#checktime3").val(data[0].checktime3);
    $("#materialtank1check3").val(data[0].materialtank1check3);
    $("#materialtank2check3").val(data[0].materialtank2check3);
    $("#screwfeedercheck3").val(data[0].screwfeedercheck3);
    $("#mixingdrum3mcheck3").val(data[0].mixingdrum3mcheck3);
    $("#mixingdrum4mcheck3").val(data[0].mixingdrum4mcheck3);
    $("#pumpcheck3").val(data[0].pumpcheck3);
    $("#electricmachinerycheck3").val(data[0].electricmachinerycheck3);

    $("#checktime4").val(data[0].checktime4);
    $("#materialtank1check4").val(data[0].materialtank1check4);
    $("#materialtank2check4").val(data[0].materialtank2check4);
    $("#screwfeedercheck4").val(data[0].screwfeedercheck4);
    $("#mixingdrum3mcheck4").val(data[0].mixingdrum3mcheck4);
    $("#mixingdrum4mcheck4").val(data[0].mixingdrum4mcheck4);
    $("#pumpcheck4").val(data[0].pumpcheck4);
    $("#electricmachinerycheck4").val(data[0].electricmachinerycheck4);

    $("#production").val(data[0].production);
    $("#equipmentoperation").val(data[0].equipmentoperation);
    $("#shiftremark").val(data[0].shiftremark);
    $("#successionremark").val(data[0].successionremark);
    $("#shiftname").val(data[0].shiftname);
    $("#successionname").val(data[0].successionname);
}

//==================================饼图==================================
// 基于准备好的dom，初始化echarts实例
var myChart1 = echarts.init(document.getElementById('spot'));
var station='';
// 指定图表的配置项和数据
option={
    tooltip: {
        trigger: 'item',
        formatter: "{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'horizontal',
        x : 'right',
        itemWidth: 18,
        itemHeight: 16,
        data:['已检','正常','报警','未检'],
        textStyle:{
            color:'#000000'
        }
    },
    grid:{

        top:"20%",

        left:"20%",

        right:"20%",

        x:"20%",
        y:"20%",

        backgroundColor: '#45fffa',

        width:"auto", //图例宽度

        height:"100%", //图例高度

    },
    series: [
        {
            type:'pie',
            selectedMode: 'single',
            radius: ['0%', '45%'],

            label: {
                normal: {
                    position: 'outer'
                }
            },
            itemStyle: {
                emphasis: {
                    shadowBlur: 100,
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
            radius: ['50%', '70%'],
            itemStyle: {
                emphasis: {
                    shadowBlur: 100,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },
                normal:{
                    color:function(params) {
                        //自定义颜色
                        var colorList = [
                            '#06ff26','#ff1f3c','#a6a59d'
                        ];
                        return colorList[params.dataIndex]
                    },
                    labelLine:{
                        length:0.5
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
    var complete1=[];
    var normal1=[];
    var alarm1=[];
    var incomplete1=[];
    var checked=0;
    var unchecked=0;
    var alarm=0;
    var normal=0;
    // 获取点检数据，并添加到饼图及报警表格中
function getSpotData(deptName,routeNames,startTime,endTime){
    $.ajax({
        type: "post",
        // async: false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/spot/changeShifts/sk/sh",    //请求发送到TestServlet处
        data:JSON.stringify({
            "deptName":deptName,
            "routeNames":routeNames,
            "startTime":startTime,
            "endTime":endTime
        }),
        contentType: "application/json",
        dataType: "json",
        beforeSend: function () {
        },
        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var data = result.data;
            if(result.code=='200'){
                var str="";
                var num=0;
                for(var a=0;a<data.length;a++){
                    if (data[a].altpid>0){
                        num=num+1;
                        alarm=alarm+1;
                        checked=checked+1;
                        str +=  '<tr><td>'+num+ '</td><td>'
                            + data[a].devName+ '</td><td>'
                            +data[a].sc_part+'</td><td>'
                            +data[a].sc_content+'</td><td>'
                            + data[a].result+ '</td></tr>';

                    }
                    else if(data[a].altpid==0){
                        normal=normal+1;
                        checked=checked+1;
                    }else {
                        unchecked=unchecked+1;
                    }

                }
                $("#spotData").empty().append(str);
                complete1.push(checked);
                normal1.push(normal);
                alarm1.push(alarm);
                incomplete1.push(unchecked);

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
                                {name: "报警", value: alarm1},
                                {name: "未检", value: incomplete1}
                            ]
                        }
                    ]
                });

                window.addEventListener("resize", function () {
                    myChart1.resize();

                });
            }else {
                alert("无数据")

            }

        },
        complete: function () {
        },
        error: function () {
            //请求失败时执行该函数
            alert("点检图表请求数据失败!");
            myChart1.hideLoading();
        }
    });
}


//保存数据
function save() {
    $.ajax({
        type: 'post',
        url : '/spot/changeShifts/sk/sh/save',
        data: $("form").serialize(),
        success : function(result) {
            alert(result.msg)
        },
        complete : function() {
            //请求完成的处理
        },
        error : function() {
            //请求出错处理
            //myalert("加载失败");
        },
        beforeSend:function(XMLHttpRequest){

        }
    });
    
}
//交班
function shiftData() {
    alert("交班");
    $.ajax({
        type: 'post',
        url : '/spot/changeShifts/sk/sh/shift',
        data: $("form").serialize(),
        success : function(result) {
            alert(result.msg);
            alert(result.code);
            if (result.code==200){
                alert("=====");
                // window.location.href = "about:blank";
            }
        },
        complete : function() {
            //请求完成的处理
        },
        error : function() {
            //请求出错处理
            //myalert("加载失败");
        },
        beforeSend:function(XMLHttpRequest){

        }
    });



}
//接班
function successionData(){
    alert("接班");

    $.ajax({
        type: 'post',
        url : '/spot/changeShifts/sk/sh/succession',
        data: $("form").serialize(),
        success : function(result) {
            alert(result.msg);
            if (result.code==='200'){
                window.location.reload();
            }
        },
        complete : function() {
            //请求完成的处理
            // var data=result.data;

        },
        error : function() {
            //请求出错处理
            //myalert("加载失败");
        },
        beforeSend:function(XMLHttpRequest){

        }
    });
}


function getTime() {
    var d = new Date();
    var h=d.getHours();
    var m=d.getMinutes();
    if (h===7) {
        if (m>=30) {
            return true;
        }
    }else if(h===8){
        if (m<=30) {
            return true;
        }
    }else if (h===19){
        if (m>=30) {
            return true;
        }
    } else if (h===20){
        if (m<=30) {
            return true;
        }
    }
}