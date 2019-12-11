<!DOCTYPE html>
<#--判断用户是否登录-->
<#--<#if !Session.username??>-->
<#--<script>-->
    <#--alert("账号未登陆，请登录...");-->
    <#--window.location.href='http://172.16.5.4/bkzyCMS/login';-->
<#--</script>-->
<#--</#if>-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a id="dlink"  style="display:none;"></a>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css"  media="all">
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/plugins/layer/layer.js" charset="utf-8"></script>
    <script src="/plugins/layui/layui.js" charset="utf-8"></script>
    <title>交接班结果查询</title>
    <style>

        body{width: auto;height: 100%;margin: 0;padding: 0;overflow: hidden}
        /* 设置滚动条的样式 ---纵向,横向*/
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px ;overflow-y: auto; overflow-x:hidden;}
        html{height: 100%;}
        /*返回*/
        .return{    margin: 0 auto auto 1%;}
        /*工段选择*/
        .select-all{width: 80%;height: 10%;   margin-left: 10%; }
        .select-all label{    margin-left: 9%;margin-right: 7%;}

        /*查询*/
        .queryButton{      width: 90%;height: 80%;border-radius: 6px;border: none;background-color: #337ab7;border-color: #2e6da4;    cursor: pointer; }

        #tables  td,#tables  th{padding:0.3%;min-height:10px}
        .resultShow {    width: 80%;color: #000000;font-size: 14px;word-wrap: break-word;padding: 11%;
            margin-top: 2%;margin-left: 10%;border: none;}
        .resultShow tr {height: 20%}
        .resultShow tr td,.resultShow tr th{width: 8% ;border:1px solid  #000000;}
        .resultShow tr th{    background-color: #cccccc; padding: 6px;font-size: 19px;}
        /*.tbody{text-align: center;overflow-y: scroll}*/
        .select-all th{width: 10%;text-align: center}
        .select-all td{width: 23%}
        .select-all label input{margin-left: 20px;    width: 18px;height: 18px;}
        .tbody{height: 370px;display: block;width: 101.5%;text-align: center;overflow-y: scroll}
        .resultShow thead{    display: table;width: 100%;}
        .resultShow tfoot td{ border: none !important}
        .layui-input{    margin-bottom: 3%;}
    </style>

</head>
<body>
    <div class="return"><a href="#" onClick="javascript :history.back(-1);">返回上一页</a> </div>
    <#--<div class="return"><a href="javascript:choosePath()">返回上一页</a> </div>-->
    <#--<a href = "javascript:choosePath()">返回数据中心</a>-->

    <table class="select-all"  id="table_wrapper">
        <tr>
            <th colspan="6" style="font-size: 20px;padding: 1%;">交接班结果查询</th>
        </tr>
        <tr>
            <th>选择工段：</th>
            <td><select id="workshop" class="layui-input" name="workshop_name" onclick="getRouteName()"></select></td>
            <th>选择岗位：</th>
            <td><select id="route" class="layui-input" name="route_name" onclick="getZoneName()"></select></td>
            <td colspan="2" rowspan="2" style="text-align: center"><button class="queryButton"  onclick="search()">查询</button></td>
        </tr>
        <#--<tr>-->
            <#--<th>选择设备：</th>-->
            <#--<td><select id="equip" class="layui-input" name="equip_name"  onclick="getPartName()"></select></td>-->
            <#--<th>选择部位：</th>-->
            <#--<td><select id="part" class="layui-input" name="part_name"  onclick="getContent()"></select></td>-->
            <#--<th>选择内容：</th>-->
            <#--<td><select id="content" class="layui-input" name="content_name"  ></select></td>-->
        <#--</tr>-->
        <tr>
            <th>选择值次：</th>
            <td><select id="zone" class="layui-input" name="zone_name"></select></td>
            <th>选择日期：</th>
            <td><input type="text" autocomplete="off" class="layui-input" id="test2" ></td>
            <#--<th>结束日期：</th>-->
            <#--<td><input type="text" autocomplete="off" class="layui-input" id="test2" ></td>-->

        </tr>
        <#--<tr>-->
            <#--<td colspan="4">-->
                <#--<label id="zcCheck">正常<input type="checkbox" checked> </label>-->
                <#--<label id="bjCheck">报警<input type="checkbox" checked></label>-->
                <#--<label id="wxCheck">危险<input type="checkbox" checked></label>-->
                <#--<label id="wjCheck">未检<input type="checkbox"  ></label>-->
            <#--</td>-->
        <#--</tr>-->
    </table>
    <table class="resultShow" id="resultShow">
        <thead class="aa">
            <tr>
                <th>序号</th>
                <th>检查内容</th>
                <th>1</th>
                <th>2</th>
                <th>3</th>
                <th>4</th>
                <th>5</th>
                <th>6</th>
                <th>7</th>
                <th>8</th>
                <th>9</th>
                <th>10</th>
                <th>11</th>
                <th>12</th>
            </tr>
        </thead>
        <tbody class="tbody"> </tbody>
        <#--<tfoot>-->
            <#--<tr>-->
                <#--<td colspan="11">注1：<span style="background-color: #ff3d1f">红色</span>底色为危险状态，<span style="background-color:#ffa315 ">橘色</span>底色为报警状态，-->
                    <#--无底色一般为正常状态，<span style="background-color:#ffdd1d ">黄色</span>底色为未检状态</td>-->
            <#--</tr>-->
            <#--<tr>-->
                <#--<td colspan="11">注2：报警状态消除后为无底色</td>-->
            <#--</tr>-->
        <#--</tfoot>-->
    </table>
    <script>
        var time="";
        var start='';
        var end='';
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //日期选择
            laydate.render({
                elem: '#test1'
                ,type: 'date'
                ,value: new Date(new Date()-2529000000)
                ,max : getNowFormatDate()
                ,isInitValue: true
                ,showBottom:true//是否允许填充初始值，默认为 true
                ,done: function(value, date, endDate){
                        start=value;


                }
            });
            laydate.render({
                elem: '#test2'
                ,type: 'date'
                ,value: new Date()
                ,max : getNowFormatDate()
                ,isInitValue: true
                ,showBottom:true//是否允许填充初始值，默认为 true
                ,done: function(value, date, endDate){
                    end=value;
                }
            });
            //日期范围选择
            laydate.render({
                elem: '#test6'
                ,range: true
                ,type: 'date'
                // ,max : getNowFormatDate()
                ,done: function(value, date, endDate){

                    start=value.split(" - ")[0];
                    end=value.split(" - ")[1];

                }
            });
            //点我触发时间选择，必须有
            laydate.render({
                elem: '#test25'
                ,eventElem: '#test25-1'
                ,trigger: 'click'
            });
        });
        //================时间选择，时间格式确定==========================
        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth()+1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month
                + seperator1 + strDate + " " + date.getHours() + seperator2
                + date.getMinutes() + seperator2 + date.getSeconds();
            return currentdate;
        }

        var routes = null;
        var zones=null;
        var depts=null;
        var parts=null;
        var scContents=null;
        var length=null;

        function search() {

            var deptName = $("#workshop option:selected").val();
            var route = $("#route option:selected").val();
            var zone = $("#zone option:selected").val();
            if(zone !="undefined" && zone !="" && zone !=null  ){
                $.ajax({
                    url: "/pc/jjb/getSuccession",
                    contentType: "application/json",
                    data:JSON.stringify({"deptName":deptName,"route":route,"zone":zone,"startTime":start}),
                    type: "post",
                    cache: true,
                    dataType: "json",
                    beforeSend: function() {
                        loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
                    },
                    success: function (result) {
                        var json = result.data;
                        length=json.length;
                        var str = "";
                        var table1 = document.getElementById("table_wrapper");
                            length=json.length;
                            for (var i = 0; i < json.length; i++){
                                    str +='<tr style="background-color: #ffa315"><td>' +
                                        (i+1)+ '</td><td>'
                                        +json[i].uploadResultTime+ '</td><td>'
                                        +json[i].deptName+ '</td><td>'
                                        + json[i].routeName + '</td><td>'
                                        + json[i].zoneName + '</td><td>'
                                        +json[i].devName+ '</td><td>'
                                        + json[i].scPart + '</td><td>'
                                        + json[i].scContent + '</td><td>'
                                        + json[i].result + '</td><td>'
                                        + json[i].stdValue + '</td><td>'
                                        + json[i].userName+ '</td><td>'
                                        + deal(json[i].alarmFlag) + '</td></tr>';
                                }
                            $('.resultShow').append(str);
                    },
                    complete: function() {
                        layer.close(loading);
                        if (length==0){
                            setTimeout('alert("无数据")','40')
                        }
                    }
                })
            }
            else {
                alert("请选择......");
            }
        }

        //线路数据添加
        function getRouteName() {
            $('#zone').empty().append('');
            var str='';
            var deptName = $("#workshop option:selected").text();
            if (deptName=='磨浮生产') {
                str += '<option value="' + "浮选岗" + '">' + "浮选岗"+ '</option>';
                str += '<option value="' + "磨矿岗" + '">' + "磨矿岗"+ '</option>';
                str += '<option value="' + "皮带岗" + '">' + "皮带岗"+ '</option>';
            }
            else {
                for (var i = 0; i < routes.length; i++) {
                    if (routes[i].deptName==deptName) {
                          str += '<option value="' + routes[i].routeName + '">' + routes[i].routeName + '</option>';
                    }
                }
            }
                $('#route').empty().append(str);
        }
        //区域数据添加
        function getZoneName() {
            var str='';
            str += '<option value="' + "白班" + '">' + "白班" + '</option>';
            str += '<option value="' + "夜班" + '">' + "夜班" + '</option>';
                $('#zone').empty().append(str);
        }

        $(function () {
            //=========================工段==================================
            $.ajax({
                url: "/interlocking/deptName",
                data:[],
                type: "get",
                cache: true,
                dataType: "json",
                success: function (result) {
                    var json = result.data;
                  var str = "";
                    for (var i=0; i < json.length; i++) {
                        if (json[i].deptName.indexOf("生产")>-1) {
                            str += "<option value='"+ json[i].deptName +"'>"+json[i].deptName+"</option>";
                        }
                    }
      
                    $('#workshop').empty().append(str);
                    $('#route').empty().append('');
                    $('#zone').empty().append('');
                }
            });
            //=========================线路================================
            $.ajax({
                url: "/interlocking/routeName",
                contentType: "application/json",
                type: "get",
                cache: true,
                dataType: "json",

                success: function (result) {
                    var json = result.data;
                    routes = result.data;
                }
            });
        });
        // ========================判断是否处理============================
        function deal(dealEstimate) {
            if(dealEstimate=='N'){
                return '未处理'
            }
            else {
                return '已处理'
            }

        }

    </script>
</body>
</html>