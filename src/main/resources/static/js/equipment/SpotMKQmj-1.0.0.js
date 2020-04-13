// 基于准备好的dom，初始化echarts实例
var myChart1 = echarts.init(document.getElementById('spotdata'));

// 指定图表的配置项和数据
myChart1.setOption({
    tooltip: {},
    grid: { top: '20%', left: '3%', right: '4%', bottom: '5%', containLabel: true },
    legend: {
        data:['已检','未检','报警','危险'],
        backgroundcolor:'#1eff46',
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
    series: [{
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
        }
    ]
});

myChart1.showLoading();
var isLoaded1 = false;
//获取点检情况
function reqs()
{
    var sections=[];
    var checkeds=[];
    var uncheckeds=[];
    var alarms=[];
    var dangers=[];

    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/equipment/SpotQmj",    //请求发送到TestServlet处
        data : {},
        dataType : "json",   //返回数据形式为json
        beforeSend: function () {
            isLoaded1= false;
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
                        checkeds.push(data[b].checked);
                    }
                    for (var c = 0; c < data.length; c++) {
                        uncheckeds.push(data[c].unchecked);
                    }
                    for (var d = 0; d < data.length; d++) {
                        alarms.push(data[d].alarm);
                    }
                    for (var e = 0; e < data.length; e++) {
                        dangers.push(data[e].danger);
                    }
                    myChart1.hideLoading();    //隐藏加载动画
                    myChart1.setOption({        //加载数据图表
                        xAxis: {
                            data: sections
                        },
                        series: [{
                            name: '已检',
                            data: checkeds,
                            itemStyle: {
                                normal: {
                                    color: '#06ff26'
                                }
                            }
                        },
                            {
                                name: '未检',
                                data: uncheckeds,
                                itemStyle: {
                                    normal: {
                                        color: '#fffe0f'
                                    }
                                }
                            },
                            {
                                name: '报警',
                                data: alarms,
                                itemStyle: {
                                    normal: {
                                        color: '#ff9308'
                                    }
                                }
                            },
                            {
                                name: '危险',
                                data: dangers,
                                itemStyle: {
                                    normal: {
                                        color: '#ff321b'
                                    }
                                }
                            }

                        ]
                    });
                    window.addEventListener("resize", function () {
                        myChart1.resize();
                    })
                }
            }
            else {
                $("#spotdata").text("无点检数据").css("top","40%").css("text-align","center").css("color","#FFFFFF").css("font-size","16px");
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
    })
}
reqs();
setInterval(function () {
    isLoaded1 && reqs()
}, 1800000);    //请求时间间隔
//获取报警数据
var isLoaded2 = false;
function getAlarmData(param) {
    var data = {"value":param};
    $.ajax({
        url:"/spot/mk/qmj/alarm",
        data:{},
        type:"get",
        cache:false,
        async: false,
        dataType:"json",
        beforeSend: function() {
            isLoaded2= false;
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
                        +'<button style="cursor: pointer;color: #FFFFFF" onclick="dealWith(\''+json[i].id+'\')">处理</button>'
                        +'</td></tr>'
                ;}
                $('#tab').append(s);
            }
            else {
                $(".alarmbody").css("background-image","url(/images/arrow/yes.png)")
                    .css("background-position","center").css("background-repeat","no-repeat")
                    .css("height","100%").css("background-size","70%");
                $(".thirdColumn").css("overflow","hidden");
            }

        },
        complete: function() {
            isLoaded2 = true; }
    })
}
getAlarmData();
setInterval(function () {
    isLoaded2 && getAlarmData()
}, 1800000);    //请求时间间隔

//获取部位的点检情况
var isLoaded3 = false;
function getDetailedData(param) {
    $.ajax({
        url:"/spot/mk/qmj/detailed/test",
        type:"post",
        // cache:false,
        // async: false,
        contentType: "application/json",
        data:JSON.stringify({"param":param}),
        dataType:"json",
        beforeSend: function() {
            isLoaded3= false;
        },
        success: function (result) {
            var  json=result.data;
            $("#tbody").html("");
            var s='';
            for (var i = 0; i < json.length; i++){
                s +='<tr><td style="width: 10%">' +
                    json[i].section+ '</td><td style="width: 35%">'
                    + json[i].part + '</td><td style="width: 35%;">'
                    + json[i].content + '</td><td style="width: 20%">'
                    + json[i].result + '</td></tr>'
                ;}
            $('#informTable').append(s);
        },
        complete: function() {
            isLoaded3 = true; }
    })
}


function showInform(){
    document.getElementById("inform").style.display='block';


}
//隐藏悬浮层
function hiddenInform(event){
    var informDiv = document.getElementById('inform');
    var x=event.clientX;
    var y=event.clientY;
    var divx1 = informDiv.offsetLeft;
    var divy1 = informDiv.offsetTop;
    var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
    var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
    if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
        document.getElementById('inform').style.display='none';
    }

}
