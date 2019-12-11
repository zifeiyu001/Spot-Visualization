// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('scmf'));

// 指定图表的配置项和数据
myChart.setOption({
    tooltip: {},
    legend: {
        data:['销量'],
        backgroundcolor:'#1eff46',
        textStyle:{
            color:'#ffffff',

        },
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
        name: '销量',
        type: 'bar',
        data: []
    },]
});
myChart.showLoading();
var names=[];    //类别数组（实际用来盛放X轴坐标值）
var nums=[];    //销量数组（实际用来盛放Y坐标值）
$.ajax({
    type : "get",
    async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
    url : "list2",    //请求发送到TestServlet处
    data : {},
    dataType : "json",
    //返回数据形式为json
    success : function(result) {
        //请求成功时执行该函数内容，result即为服务器返回的json对象
        var data = result.data;
        if (data) {
            for(var i=0;i<data.length;i++){
                names.push(data[i].name);    //挨个取出类别并填入类别数组
            }
            for(var i=0;i<data.length;i++){
                nums.push(data[i].num);    //挨个取出销量并填入销量数组
            }
            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({        //加载数据图表
                xAxis: {
                    data: names
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '销量',
                    data: nums
                }]
            });
        }
    },
    error : function() {
        //请求失败时执行该函数
        alert("图表请求数据失败!");
        myChart.hideLoading();
    }
})