<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


<div class="layui-form">
    <div class="layui-form-item">
        <#--<div class="layui-inline">-->
            <#--<label class="layui-form-label">选择日期</label>-->
            <#--<div class="layui-input-inline">-->
                <#--<input type="text" class="layui-input" id="test1" >-->
            <#--</div>-->
        <#--</div>-->
        <div class="layui-inline">
            <label class="layui-form-label">选择日期</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="test2">
            </div>
        </div>
        <div class="layui-inline">
            <button  style="width: 50px;height: 30px;"  onclick="getTime1()" >查询</button>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">选择时间范围</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="test3">
            </div>
        </div>
        <div class="layui-inline">
            <button  style="width: 50px;height: 30px;"  onclick="getTime2()" >查询</button>
        </div>
    </div>

</div>

<script src="/plugins/layui/layui.js" charset="utf-8"></script>
<script>
    var start="";
    var end="";
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#test1'
            ,type: 'date'
            ,value: new Date()
            ,isInitValue: false //是否允许填充初始值，默认为 true
            ,done: function(value, date, endDate){
                start=value;
            }
        });
        laydate.render({
            elem: '#test2'
            ,type: 'date'
            ,value: new Date()
            ,isInitValue: false //是否允许填充初始值，默认为 true
            ,done: function(value, date, endDate){
                end=value;
            }
        });
        laydate.render({
            elem: '#test3'
            ,type: 'date'
            ,range: true
            ,value: new Date()
            ,isInitValue: false //是否允许填充初始值，默认为 true
            ,done: function(value, date, endDate){
                start=value;
                alert(endDate)
            }
        });

        //点我触发
        laydate.render({
            elem: '#test25'
            ,eventElem: '#test25-1'
            ,trigger: 'click'
        });
    });

    function getTime1(){
        if(end ==""){alert("请选择日期!")}
        else{alert(end)}
    }
    function getTime2(){
        if(start ==""){alert("请选择日期!")}
        else{alert(start)}
    }
</script>

</body>
</html>