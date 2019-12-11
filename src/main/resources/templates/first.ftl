<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <style>
        body{
            height: 100%;
            width: 100%;
            /*background-color: #00F7DE;*/
        }
        #table{
            width: 800px;
            height: 300px;
            overflow: scroll;
        }
        #show{
            height: 100px;
            width:100px;
            background-color: #aaaaaa;
        }
        .zh-loading{
            height: 100%;
            width: 49%;
            /*min-width: 400px;*/
            /*min-height: 400px;*/
            background-color: #ff321b;
            background-size: 100% 100%;
            background-attachment: fixed;
            /*position: absolute;*/
            float: left;
            /*left: 30px;*/
        }
        .output{
            height: 100%;
            width: 49%;
            background-color: #a8eeb3;
            background-size: 100% 100%;
            background-attachment: fixed;
            float: left;
            /*position: absolute;*/
            /*float: left;*/
            /*left: 30px;*/
        }
        #aaa{
            width: 100px;
            height: 30px;
        }
        .layui-hide{
            width: 100%;
            height: 100%;
        }

    </style>
</head>
<body>
    <#--<div id="table">-->
        <#--<table class="layui-hide" id="test"></table>-->
    <#--</div>-->
    <div id="aa">
        <input id="aaa" >
        <#--<div class="zh-loading">时间</div>-->
        <#--<div id="show">-->
        <#--<output class="output" id="a"></output>-->
        <#--<a href="/spot?user=bkzy"></a>-->
    </div>
<#--前端显示到div中-->
    <script>
        var isLoaded = false;
        var dateTime='';
        function reqs(opts){

            $.ajax({
                type : "get",
                async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "/testApp",    //请求发送到TestServlet处
                data : {},
                dataType : "json",
                beforeSend: function() {
                    // if(opts.init === 1) {
                    //     $('.zh-loading').show();
                    // }
                    isLoaded = false;
                 },
                success : function(result){
                    var  data=result.data;
                    alert(data[0].devName);
                    var textId=$("#a");//根据文本框的id找到这个文本框，并将其变成jquery对象
                    // dateTime=data[0].dateTime;
                    // if(a!=null) textId.val(dateTime);
                     textId.val(data);
                },
                complete: function() {
                    // if(opts.init === 1) {
                    //     $('.zh-loading').hide();
                    // }
                    isLoaded = true; },
                error : function() {
                    //请求失败时执行该函数
                    textId.val("请求失败");
                }
                });
        }
        reqs({"init":1});
        setInterval(function () {
            isLoaded && reqs({"init":0})
        },300000);     //请求时间间隔

    </script>
<#--表格显示数据-->
    <script src="/plugins/layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#test',
                url:'/homePage/first',
                page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']//自定义分页布局
                    ,limits:[10,20]
                    ,limit:10
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                 }
                ,cols: [[
                    {field:'dateTime', width:80, title: '时间', sort: true}
                    ,{field:'section', width:80, title: '工段'}
                    ,{field:'devName', width:80, title: '设备', sort: true}
                    ,{field:'spot', width:80, title: '部位'}
                    ,{field:'content', title: '内容'}
                    ,{field:'result', width:80, title: '结果', sort: true}
                    ,{field:'standard', width:80, title: '标准'}
                    // ,{field:'content', title: '内容', minWidth: 150}
                    // ,{field:'result', width:80, title: '结果', sort: true}
                ]]
                // ,page: true
            });
        });
    </script>
</body>
</html>