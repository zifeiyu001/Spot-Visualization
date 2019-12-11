
// 基于准备好的dom，初始化echarts实例
/*磨浮1生产数据*/
var myChart1 = echarts.init(document.getElementById('scdata'));
// 指定图表的配置项和数据
myChart1.setOption({
    tooltip: {},
    // title: {
    //     text: '生产数据',
    //     left:'center',
    //     top:'5%',
    //     textStyle:{
    //         color:'#ffffff'
    //     }
    // },
    legend: {
        textStyle:{
            color:'#ffffff'
        },
        bottom:'2%'
    },
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
    series: [{
        name: '产量',
        type: 'bar',
        data: []
    }]
});
myChart1.showLoading();
var isLoaded1 = false;
function reqs1() {
    var a1=[];    //类别数组（实际用来盛放X轴坐标值）
    var b1=[];    //销量数组（实际用来盛放Y坐标值）
    $.ajax({
        type : "get",
        async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/spot/test",    //请求发送到TestServlet处
        data : {},
        dataType : "json",   //返回数据形式为json
        beforeSend: function () {
            isLoaded1= false;
        },
        success : function(result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var data = result.data;
            if (data) {
                for(var a=0;a<data.length;a++){
                    a1.push(data[a].a);    //挨个取出类别并填入类别数组
                }
                for(var b=0;b<data.length;b++){
                    b1.push(data[b].b);    //挨个取出销量并填入销量数组
                }
                myChart1.hideLoading();    //隐藏加载动画
                myChart1.setOption({        //加载数据图表
                    // xAxis: {
                    //     data: names1
                    //
                    // },
                    series: [{
                        name: '产量(t)',
                        data: yields1
                    }
                    ]
                });
                window.addEventListener("resize",function () {
                    myChart1.resize();
                })
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


