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
    <title>球磨机</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
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
    /* 设置滚动条的样式 ---纵向,横向*/
        #body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
        html{height: 100%;}

    /*主界面*/
        .main{width:100%;height:70%;min-width: 1170px;min-height: 500px;margin: 0;}

    /*生产数据以及图例模块*/
        .echartsData{width: 18%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}

    /*生产数据图表*/
        .spotstatistics {width: 100%;height: 40%;min-height: 200px;min-width: 200px;margin: 2px;
            background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spotQmj{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 30%;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic1.png");background-size: 100% 100%;}
    /*磨浮图例*/
        #legend2{width: 98%;height: 11%;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic1.png");background-size: 100% 100%;}
    /*图例字体*/
        #legend1,#legend2 .myTable thead td{font-size: 12px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;background-size: 100% 100%;
            background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}

    /*主图片*/
        #pic{width: 96%;height: 90%;min-height: 300px;min-width: 400px;margin-top: 5%;margin-right: 1%;}

    /*图片图例位置样式*/
        /*.dy-num{float: left;position: relative;color: #00fff7;}*/
        /*#dy-num123 {left: -20%;bottom: 28%;}*/
        /*#dy-num45 {left: 45%;bottom: 27%;}*/
        /*.mf-num1{float: left;position: relative;color: #ff321b;font-size: 15px}*/
        /*#mf-num1234 {left: 1%;bottom: 40%;}*/
        /*#mf-num5678 {left: 8%;bottom: 40%;}*/
        /*#mf-num9 {left: 30%;bottom: 69%;}*/
        /*#mf-num10 {left: 22%;bottom: 14%;}*/
        /*.mf-num2{float: left;position: relative;font-size: 18px}*/
        /*#mf-num1-1234 {left: 8%;bottom: 40%;}*/
        /*#mf-num1-5678 {left: 13%;bottom: 40%;}*/
        /*#mf-num1-9 {left: 50%;bottom: 27%;}*/
        /*.sc-num{float: left;position: relative;color: #a8eeb3;}*/
        /*#sc-num12{left: 55%;bottom: 79%;}*/
        /*#sc-num34{left: 53%;bottom: 45%;}*/
        /*#sc-num5{left: 1%;bottom: 14%;}*/
        /*#sc-num6{left: -24%;bottom: 63%;}*/
        /*#sc-num78{left: 29%;bottom: 13%;}*/
    .dy-num{float: left;position: relative;}
    #dy-num123 {    left: -7%;bottom: 68%;}
    #dy-num45 {    left: 47%;bottom: 27%;}
    .mf-num1{float: left;position: relative;font-size: 15px}
    #mf-num1234 {    left: 12%;bottom: 64%;}
    #mf-num5678 {left: 20%;bottom: 69%;}
    #mf-num9 {    left: 39%;bottom: 66%;}
    #mf-num10 {    left: 40%;bottom: 26%;}
    .mf-num2{float: left;position: relative;font-size: 18px;}
    #mf-num1-1234 {left: 17%;bottom: 57%;}
    #mf-num1-5678 {left: 23%;bottom: 57%;}
    #mf-num1-9 {left: 56%;bottom: 31%;}
    .sc-num{float: left;position: relative;}
    #sc-num12{left: 26%;bottom: 69%;}
    #sc-num34{    left: 20%;bottom: 47%;}
    #sc-num5{left: 8%;bottom: 27%;}
    #sc-num6{    left: -6%;bottom: 75%;}
    #sc-num78{    left: 32%;bottom: 23%;}
    /*点检数据表格*/
        .CSSmf td {font-size: 11px !important;}
        .trCSS{font-size: 18px !important ;}

    .CSSmf td,.mf-num1,.mf-num2{color: #3bff8b ;}
    .CSSdy td,.dy-num{color: #ffeb3b ;}
    .CSSsc td,.sc-num{color: #a222ff ;}

    /*!*报警盒子*!*/
        /*#alarm{overflow-y: auto;width: 22%;height: 100%;min-width: 200px;min-height: 500px;float: left;text-align: center;border-radius: 1%;*/
            /*background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}*/
    /*!*滚动条整体样式*!*/
        /*#alarm::-webkit-scrollbar {width: 3%;;height: 4px;scrollbar-arrow-color:red;}*/

    /*!*滚动条里面小方块*!*/
        /*#alarm::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}*/

    /*!*高宽分别对应横竖滚动条的尺寸*!*/
        /*#alarm::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background:transparent;}*/

    /*!*报警表格字体*!*/
        /*#alarm .myTable tbody td{font-size: 12px}*/
        /*#alarm .myTable thead td{font-size: 12px}*/

    /*报警区域*/
    .main  .alarm{
        width: 22%;height: 99%;min-width: 200px;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}

    /*报警表格字体*/
   .alarm .myTable tbody td{font-size: 14px; padding: 1px;}
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
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:20%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px !important;    padding: 2px;}


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
        <h1 class="title">球磨机</h1>
    <#--当前时间-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    </div>
    <div class="main">
    <#--表格数据-->
        <div class="echartsData" id="alarm1" >
            <div class="spotstatistics">
                <h2 class="spotStatistics_title">点检统计</h2>
                <div class="statistics">
                    <div id="spotdata"></div>
                </div>
            </div>
            <#--<div id="spotQmj"></div>-->
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
                        <td>高低压稀油站</td>
                    </tr>
                    </tbody>
                </table>
            </div>
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSdy">
                        <td>油位</td>
                        <td>滑环</td>
                        <td>外观</td>
                        <td>振动</td>
                        <td>温度</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="legend2">
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
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
                <img id="pic" src="/images/equipment/mk/qmj2.png">
            <#--磨浮-->
                <span id="mf-num1234" class="mf-num1">①②<br>③④</span>
                <span id="mf-num5678" class="mf-num1">⑤⑥<br>⑦⑧</span>
                <span id="mf-num9" class="mf-num1">⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num1-1234" class="mf-num2">⑪⑫<br>⑬⑭</span>
                <span id="mf-num1-5678" class="mf-num2">⑮⑯<br>⑰⑱</span>
                <span id="mf-num1-9" class="mf-num2">⑲</span>
            <#--电仪-->
                <span id="dy-num123" class="dy-num">①②③</span>
                <span id="dy-num45" class="dy-num">④⑤</span>
            <#--生产-->
                <span id="sc-num12" class="sc-num">①②</span>
                <span id="sc-num34" class="sc-num">③④</span>
                <span id="sc-num5" class="sc-num">⑤</span>
                <span id="sc-num6" class="sc-num">⑥</span>
                <span id="sc-num78" class="sc-num">⑦⑧</span>
        </div>
        <div class="alarm">
            <div class="tabletitle"  id="alarm2">报警数据</div>
            <div class="alarmbody" >
                <table class="myTable" id="tab">
                    <thead>
                        <tr class="tablehead" id="alarm3">
                            <td onclick="kw.tabSort('tab',0)">设备</td>
                            <td onclick="kw.tabSort('tab',1)">部位</td>
                            <td onclick="kw.tabSort('tab',2)">内容</td>
                            <td onclick="kw.tabSort('tab',3)">结果</td>
                            <td onclick="kw.tabSort('tab',4)">级别</td>
                            <td>处理</td>
                        </tr>
                    </thead>
                    <tbody id="tablebody">
                        <#--<#if alarmQmjs??>-->
                            <#--<#list alarmQmjs as list>-->
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
                </tr>

            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
<script  src="/js/equipment/SpotMKQmj.js"></script>
<script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>
</body>
</html>