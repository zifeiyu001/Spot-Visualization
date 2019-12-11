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
    <title>事故浓密机</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <script type="text/css"></script>
    <style>
    /*背景*/
      body{
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
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
    /*标题*/
        html{height: 100%;}
    /*主界面*/
        .main{width:100%;height:73%;min-width: 1170pxmargin: 0;}

    /*生产数据以及图例模块*/
        .echartsData{width: 25%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}
        .spotstatistics {width: 100%;height: 37%;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spot{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 41%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 19%;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic6.png");background-size: 100% 100%;}


    /*磨浮图例*/
        #legend3{width: 98%;height: 26%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1 .myTable thead td,#legend2 .myTable thead td,#legend3 .myTable thead td{font-size: 14px}
    #legend1 .myTable tbody td,#legend2 .myTable tbody td,#legend3 .myTable tbody td{font-size: 10px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:49%;height:100%;min-width: 400px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        /*.pic{width: 90%;height: 90%;min-height: 300px;min-width: 400px;*/
            /*float: left;   margin-top: 1%;margin-left: 6%;}*/
            .pic{width: 85%;height: 85%;float: left;position: relative;color: #FFFFFF;left: 6%;top: -5%}
            .picb{width: 23%;height: 23%;float: left;position: relative;color: #FFFFFF;left: 22%;top: -19%}
            .picb img,.pic img{width: 100%;height: 100%;}



    /*#xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;*/
        /*margin-left: 1%;*/
        /*float: left;}*/
    /*图片图例位置样式*/
        /*磨浮*/
        .sb-num1{float: left;position: relative;font-size: 15px}
        .sb-num2{float: left;position: relative;font-size: 18px;}
        #sb-num1 {        left: -10%;bottom: 56%;}
        #sb-num2 {    left: -5%;bottom: 56%;}
        #sb-num3 {   left: -21%;bottom: 56%;}
        #sb-num4 {        left: 23%;bottom: 22%;}
        #sb-num5 {        left: -14%;bottom: 61%;}
        #sb-num6 {    left: -22%;bottom: 13%;}
        #sb-num7 {        left: -22%;bottom: 17%;}
        #sb-num8 {        left: -33%;bottom: 9%;}
        #sb-num9 {       left: -27%;bottom: 11%;}
        #sb-num10 {    left: -41%;bottom: 1%;}
        #sb-num11 {        left: -14%;bottom: 16%;}
        #sb-num12 {    left: -20%;bottom: 8%;}
        #sb-num13 {        left: -14%;bottom: 13%;}
        #sb-num14 {left: -22%;bottom: 12%;}
        #sb-num15 {    left: -29%;bottom: 0%;}


        /*电仪*/
        .dy-num{float: left;position: relative;font-size: 15px;}
        .dy-numb{float: left;position: relative;font-size: 18px;}
        #dy-num1 {    left: -53%;bottom: 64%;}
        #dy-num2 {        left: -30%;bottom: 44%;}
        #dy-num3 {        left: -70%;bottom: 13%;}
        #dy-num4 {    left: -70%;bottom: 13%;}
        #dy-num5 {        left: -34%;bottom: 20%;}





    /*报警区域*/
    .main  .alarm{
        width: 22%;height: 99%;min-width: 200px;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}

    /*报警表格字体*/
    .alarm .myTable tbody td{font-size: 14px;padding: 2px;}
    .myTable thead td{font-size: 14px}

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
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:14%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px;    padding: 0;}


    /*点检数据表格*/
        .CSSsb td,.sb-num1, .sb-num2{color: #3bff8b !important;}
        .CSSdy td,.dy-num,.dy-numb{color: #ffeb3b ;}

        /*.CSSmf td {font-size: 11px !important;}*/
        .trCSS{font-size: 18px !important ;}

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
        <h1 class="title">事故浓密机</h1>
    <#--当前时间-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    </div>
    <div class="main">
    <#--表格数据-->
        <div class="echartsData"  id="alarm1">
            <#--<div id="spotZmj"></div>-->
            <div class="spotstatistics">
                <h2 class="spotStatistics_title">点检统计</h2>
                <div class="statistics">
                    <div id="spotdata"></div>
                </div>
            </div>
            <div id="legend1">
                <table class="myTable">
                    <caption>设备</caption>
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
                        <td class="trCSS">⑪</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsb">
                        <td>减速机液压泵是否正常</td>
                        <td>稀油站油温</td>
                        <td>稀油站油位</td>
                        <td>耙架提升油缸是否正常</td>
                        <td>行走轮及链条是否正常</td>
                        <#--<td>运行阻力</td>-->
                        <td>水封水是否正常</td>
                        <td>液力耦合器出口温度</td>
                        <td>液力耦合器进口温度</td>
                        <td>液力耦合器出口压力</td>
                        <td>盘根是否漏浆</td>
                        <td>轴承润滑</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr class="CSSNum">
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                        <td class="trCSS">⑮</td>
                        <td class="trCSS">⑯</td>
                        <td class="trCSS">⑰</td>
                        <td class="trCSS">⑱</td>
                        <td class="trCSS">⑲</td>
                        <td class="trCSS">⑳</td>
                        <td class="trCSS">㉑</td>
                        <#--<td class="trCSS">㉒</td>-->
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsb">

                        <td>进浆短接有无漏浆</td>
                        <td>出口短接是否完好</td>
                        <td>地脚是否松动</td>
                        <td>板式冷却器是否正常</td>
                        <td>盘根是否漏浆</td>
                        <td>轴承润滑</td>
                        <td>进浆短接有无漏浆</td>
                        <td>出口短接是否完好</td>
                        <td>水封水是否正常</td>
                        <td>地脚是否松动</td>

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
                        <td>⑥</td>
                        <td>⑦</td>
                        <td>⑧</td>

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSdy">
                        <td>振动</td>
                        <td>温度</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                        <td>振动</td>
                        <td>温度</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr class="CSSNum">
                        <td>⑨</td>
                        <td>⑩</td>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                        <td class="trCSS">⑮</td>
                        <td class="trCSS">⑯</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSdy">
                        <td>振动</td>
                        <td>温度</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                        <td>振动</td>
                        <td>温度</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/jw/sg.png"></div>
            <div id="pic2" class="picb"><img src="/images/equipment/jw/beng.png"></div>
            <div id="pic3" class="picb"><img src="/images/equipment/jw/beng.png"></div>
            <#--设备-->
                <span id="sb-num1" class="sb-num1">①</span>
                <span id="sb-num2" class="sb-num1">②③</span>
                <span id="sb-num3" class="sb-num1">④</span>
                <span id="sb-num4" class="sb-num1">⑤</span>
                <#--<span id="sb-num5" class="sb-num1"></span>-->


                <span id="sb-num6" class="sb-num1">⑥</span>
                <span id="sb-num7" class="sb-num1">⑦⑧⑨</span>
                <span id="sb-num8" class="sb-num2">⑩⑪</span>
                <span id="sb-num9" class="sb-num2">⑫<br>⑬</span>
                <span id="sb-num10" class="sb-num2">⑭</span>

                <span id="sb-num11" class="sb-num2">⑮</span>

                <span id="sb-num12" class="sb-num2">⑯⑰</span>
                <span id="sb-num13" class="sb-num2">⑱<br>⑲</span>
                <span id="sb-num14" class="sb-num2">⑳</span>
                <span id="sb-num15" class="sb-num1">㉑</span>


            <#--电仪-->
                <span id="dy-num1" class="dy-num">①②<br>③④</span>
                <span id="dy-num2" class="dy-num">⑤⑥<br>⑦⑧</span>
                <span id="dy-num3" class="dy-num">⑨⑩</span>
                <span id="dy-num4" class="dy-numb">⑪⑫</span>
                <span id="dy-num5" class="dy-numb">⑬⑭<br>⑮⑯</span>



        </div>
        <div class="alarm">
            <div class="tabletitle" id="alarm2">报警数据</div>
            <div class="alarmbody">
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
                    <td >㉑</td>
                    <#--<td >㉒</td>-->
                    <#--<td>㉓</td>-->
                    <#--<td>㉔</td>-->
                    <#--<td>㉕</td>-->
                    <#--<td>㉖</td>-->
                    <#--<td>㉗</td>-->
                    <#--<td>㉘</td>-->
                    <#--<td>㉙</td>-->
                    <#--<td>㉚</td>-->
                    <#--<td>㉛</td>-->
                    <#--<td>㉜</td>-->
                    <#--<td>㉝</td>-->
                    <#--<td>㉞</td>-->
                    <#--<td>㉟</td>-->
                    <#--<td>㊱</td>-->
                    <#--<td>㊲</td>-->
                    <#--<td>㊳</td>-->
                    <#--<td>㊴</td>-->
                    <#--<td>㊵</td>-->
                    <#--<td>㊶</td>-->
                    <#--<td>㊷</td>-->
                    <#--<td >㊸</td>-->
                    <#--<td >㊹</td>-->
                    <#--<td >㊺</td>-->
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <script  src="/js/equipment/SpotNSSGNM.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>