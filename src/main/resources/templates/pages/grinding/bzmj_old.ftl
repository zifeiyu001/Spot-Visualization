<!DOCTYPE html>
<#--判断用户是否登录-->
<#if !Session.username??>
    <script>
        alert("账号未登陆，请登录...");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    </script>
</#if>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>半自磨机</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />

    <script type="text/css"></script>
    <style>
    /*背景*/
        #body{
            background-image: url("/images/background.jpg");
            background-size: 100% 100%;
            background-attachment: fixed;
            width: auto;
            height: 100%;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
         html{height: 100%;}

    /* 设置滚动条的样式 ---纵向,横向*/
        #body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
        *{margin:0;padding:0}

    /*主界面*/
        .main{width:100%;height:67%;min-width: 1170px;min-height: 500px;margin: 0;}

    /*生产数据以及图例模块*/
        .echartsData{width: 18%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}

    /*生产数据图表*/
        .spotstatistics {width: 100%;height: 35%;min-width: 200px;margin: 2px;
            background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}

    /*图表标题*/
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}

        .statistics{width: 100%;height: 91%;}

        #spotBzmj{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 33%;min-height: 170px;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 11%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}
    /*生产图例*/
        #legend3{width: 98%;height: 18%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1,#legend2 .myTable thead td{font-size: 12px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图区域*/
        .show{
            width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}

    /*图片*/
        #pic{width: 100%;height: 100%;min-height: 300px;min-width: 400px;}

    /*图片图例*/
        #dy-num123 {    left: -12%;bottom: 64%;}
        #dy-num45 {left: -14%;bottom: 29%;}
        #dy-num67 {    left: 44%;bottom: 26%;}
        .dy-num{float: left;position: relative;color: #00fff7;}
        .sc-num{float: left;position: relative;color: #a8eeb3;}
        .mf-num1{float: left;position: relative;font-size: 15px}
        #mf-num1234 {    left: 12%;bottom: 72%;}
        #mf-num5678 {    left: 20%;bottom: 75%;}
        #mf-num9 {    left: 40%;bottom: 72%;}
        #mf-num10 {left: 40%;bottom: 31%;}
        .mf-num2{float: left;position: relative;font-size: 18px;}
        #mf-num1-1234 {    left: 16%;bottom: 71%;}
        #mf-num1-5678 {left: 19%;bottom: 56%;}
        #mf-num1-9 {    left: -2%;bottom: 25%;}
        #mf-num20{    left: 56%;bottom: 32%;}
        #sc-num12{left: 21%;bottom: 76%;}
        #sc-num34{    left: 16%;bottom: 48%;}
        #sc-num5{    left: 3%;bottom: 32%;}
        #sc-num6{    left: -13%;bottom: 81%;}
        #sc-num78{    left: -33%;bottom: 35%;}
        #sc-num91{    left: 25%;bottom: 23%;}

    /*报警区域*/
    .main  .alarm{
        width: 22%;height: 99%;min-width: 200px;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}

    /*报警表格字体*/
    .alarm .myTable tbody td{font-size: 12px}
    .myTable thead td{font-size: 12px}

    /*报警表格标题*/
    .tabletitle{z-index: -2;color: white;font-size: 14px;margin-top: 1%;text-align: center;}

    .alarm  .alarmbody .myTable tbody {display:block;overflow-y:scroll;position: relative;}
    /*.alarm #tablebody{height: 400px;}*/
    .alarm .alarmbody .myTable thead, .alarm .alarmbody .myTable tbody tr {display:table;width:100%;table-layout:fixed;}
    .alarm .alarmbody .myTable thead {width: calc( 100% - 0.6em )}

    /* 设置滚动条的样式 ---纵向,横向*/
    body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
    /*滚动条整体样式*/
    .alarmbody .myTable tbody::-webkit-scrollbar {width: 3%;height: 0;scrollbar-arrow-color:red;}
    /*滚动条里面小方块*/
    .alarmbody .myTable tbody::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
    /*滚动条里面轨道*/
    .alarmbody .myTable tbody::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background: #192683;}


    /*详细数据*/
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:17%;min-width: 1170px;min-height: 30px;background-image: url("/images/module/pic4.png");background-size: 100% 100%;}

    /*详细数据表格*/
        #detaileddata .myTable tbody td{font-size: 14px;padding: 3px;}

    /*点检数据表格*/
        .trCSS{font-size: 18px !important ;}
        .CSSmf td,.mf-num1,.mf-num2{color: #3bff8b ;}
        .CSSdy td,.dy-num{color: #ffeb3b ;}
        .CSSsc td,.sc-num{color: #a222ff ;}

    </style>
</head>
<body id="body">
<#--导航栏-->
    <div class="menu">
    <#--返回按钮-->
        <div class="menuLeft" >
            <a href="#" onClick="javascript :history.back(-1);">返回</a>
            <a href="/spot" style=" padding: -1px;" >返回首页</a>
            <a href = "javascript:choosePath()">返回数据中心</a>
        </div>
    <#--标题-->
        <h1 class="title">半自磨机</h1>
    <#--当前时间-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    </div>
    <div class="main" >
    <#--表格数据-->
        <div class="echartsData" id="alarm1" >
         <#--点检统计-->
            <div class="spotstatistics">
                <h2 class="spotStatistics_title">点检统计</h2>
                <div class="statistics">
                    <div id="spotdata"></div>
                </div>
            </div>
            <#--<h2 class="spotStatistics_title">点检统计</h2>-->
            <#--<div id="spotBzmj"></div>-->

        <#--磨浮点检图例-->
            <div id="legend1">
                <table class="myTable">
                    <caption>磨浮</caption>
                    <thead>
                    <tr class="CSSNum">
                        <td>①</td>
                        <td>②</td>
                        <td>③</td>
                        <td>④</td>
                        <td>⑤</td>
                        <td>⑥</td>
                        <td>⑦</td>
                        <td>⑧</td>
                        <td>⑨</td>
                        <td>⑩</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>轴向速度</td>
                        <td>水平速度</td>
                        <td>垂直速度</td>
                        <td>温度</td>
                        <td>轴向速度</td>
                        <td>水平速度</td>
                        <td>垂直速度</td>
                        <td>温度</td>
                        <td>结构</td>
                        <td>干油润滑站</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                        <td class="trCSS">⑮</td>
                        <td class="trCSS">⑯</td>
                        <td class="trCSS">⑰</td>
                        <td class="trCSS">⑱</td>
                        <td class="trCSS">⑲</td>
                        <td class="trCSS">⑳</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>轴向速度</td>
                        <td>水平速度</td>
                        <td>垂直速度</td>
                        <td>温度</td>
                        <td>轴向速度</td>
                        <td>水平速度</td>
                        <td>垂直速度</td>
                        <td>温度</td>
                        <td>高压稀油站</td>
                        <td>低压稀油站</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        <#--电仪点检图例-->
            <div id="legend2">
                <table class="myTable">
                    <caption>电仪</caption>
                    <thead>
                    <tr class="CSSNum">
                        <td>①</td>
                        <td>②</td>
                        <td>③</td>
                        <td>④</td>
                        <td>⑤</td>
                        <td>⑥</td>
                        <td>⑦</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSdy">
                        <td>油位</td>
                        <td>滑环</td>
                        <td>外观</td>
                        <td>温度</td>
                        <td>振动</td>
                        <td>温度</td>
                        <td>振动</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        <#--生产图例-->
            <div id="legend3">
                <table class="myTable">
                    <caption>生产</caption>
                    <thead>
                    <tr class="CSSNum">
                        <td>①</td>
                        <td>②</td>
                        <td>③</td>
                        <td>④</td>
                        <td>⑤</td>
                        <td>⑥</td>
                        <td>⑦</td>
                        <td>⑧</td>
                        <td>⑨</td>
                        <td>⑩</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>是否漏浆</td>
                        <td>水量</td>
                        <td>补加水阀</td>
                        <td>补加水管</td>
                        <td>甘油喷射系统</td>
                        <td>排矿浓度</td>
                        <td>油泵</td>
                        <td>冷却水</td>
                        <td>油泵</td>
                        <td>冷却水</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
                <#--<img id="pic" src="/images/equipment/mk/bzmjSystem.png">-->
            <img id="pic" src="/images/equipment/mk/bzmj2.png">
                <span id="mf-num1234" class="mf-num1">①②<br>③④</span>
                <span id="mf-num5678" class="mf-num1">⑤⑥<br>⑦⑧</span>
                <span id="mf-num9" class="mf-num1">⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num1-1234" class="mf-num2">⑪⑫<br>⑬⑭</span>
                <span id="mf-num1-5678" class="mf-num2">⑮⑯<br>⑰⑱</span>
                <span id="mf-num1-9" class="mf-num2">⑲</span>
                <span id="mf-num20" class="mf-num2">⑳</span>
                <span id="dy-num123" class="dy-num">①②③</span>
                <span id="dy-num45" class="dy-num">④⑤</span>
                <span id="dy-num67" class="dy-num">⑥⑦</span>
                <span id="sc-num12" class="sc-num">①②</span>
                <span id="sc-num34" class="sc-num">③④</span>
                <span id="sc-num5" class="sc-num">⑤</span>
                <span id="sc-num6" class="sc-num">⑥</span>
                <span id="sc-num78" class="sc-num">⑦⑧</span>
                <span id="sc-num91" class="sc-num">⑨⑩</span>
        </div>

    <#--报警表格-->
        <div class="alarm"  >
            <div class="tabletitle"  id="alarm2">报警数据</div>
            <div class="alarmbody" >
                <table class="myTable" id="tab">
                    <thead>
                        <tr class="tablehead" id="alarm3" >
                            <td onclick="kw.tabSort('tab',0)">设备</td>
                            <td onclick="kw.tabSort('tab',1)">部位</td>
                            <td onclick="kw.tabSort('tab',2)">内容</td>
                            <td onclick="kw.tabSort('tab',3)">结果</td>
                            <td onclick="kw.tabSort('tab',4)">级别</td>
                            <td>处理</td>
                        </tr>
                    </thead>
                    <tbody id="tablebody">
                        <#--<#if alarmBzmj??>-->
                            <#--<#list alarmBzmj as list>-->
                                <#--<tr>-->
                                    <#--<td>${list.equip!}</td>-->
                                    <#--<td>${list.part!}</td>-->
                                    <#--<td>${list.spot!}</td>-->
                                    <#--<td>${list.value!}</td>-->
                                    <#--<td>${list.standard!}</td>-->
                                    <#--<td>${list.level!}</td>-->
                                <#--</tr>-->
                            <#--</#list>-->
                        <#--</#if>-->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<#--详细数据-->
    <div id="detaileddata">
        <table class="myTable" id="table">
            <caption> 详细数据<Br></caption>
            <thead>
                <tr >
                    <td></td>
                    <td>①</td>
                    <td>②</td>
                    <td>③</td>
                    <td>④</td>
                    <td>⑤</td>
                    <td>⑥</td>
                    <td>⑦</td>
                    <td>⑧</td>
                    <td>⑨</td>
                    <td>⑩</td>
                    <td class="trCSS">⑪</td>
                    <td class="trCSS">⑫</td>
                    <td class="trCSS">⑬</td>
                    <td class="trCSS">⑭</td>
                    <td class="trCSS">⑮</td>
                    <td class="trCSS">⑯</td>
                    <td class="trCSS">⑰</td>
                    <td class="trCSS">⑱</td>
                    <td class="trCSS">⑲</td>
                    <td class="trCSS">⑳</td>
                </tr>
            </thead>
        <#--磨浮点检数据-->
            <tbody>
            </tbody>
        </table>
    </div>
    <script  src="/js/equipment/SpotMKBzmj.js"></script>
    <script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>
</body>
</html>