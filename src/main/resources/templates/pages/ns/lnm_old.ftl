<!DOCTYPE html>
<#--判断用户是否登录-->
<#if !Session.username??>
    <script>
        alert("账号未登陆，请登录...");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    </script>
</#if>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>硫浓密机</title>
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
        .main{width:100%;height:70%;min-width: 1170pxmargin: 0;}

    /*生产数据以及图例模块*/
        .echartsData{width: 24%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}
        .spotstatistics {width: 100%;height: 39%;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spot{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 18%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 12%;min-width: 200px;margin-bottom: 1px;
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
        .show{width:50%;height:100%;min-width: 400px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        /*.pic{width: 90%;height: 90%;min-height: 300px;min-width: 400px;*/
            /*float: left;   margin-top: 1%;margin-left: 6%;}*/
            .pic{width: 97%;height: 74%;float: left;position: relative;color: #FFFFFF;top: 17%}
            .pic img{width: 100%;height: 100%;}

    /*图片图例位置样式*/
        /*设备*/
        .sb-num1{float: left;position: relative;font-size: 15px}
        #sb-num1 {        left: 74%;bottom: 23%;}
        #sb-num2 {        left: 74%;bottom: 38%;}
        #sb-num3 {        left: 74%;bottom: 13%;}
        /*电仪*/
        .dy-num{float: left;position: relative;}
        #dy-num1 {        left: 68%;bottom: 23%;}
        #dy-num2 {        left: 69%;bottom: 38%;}

        /*生产*/
        .sc-num{float: left;position: relative;}
        .sc-num2{float: left;position: relative;font-size: 18px}
        #sc-num1{        left: 64%;bottom: 23%;}
        #sc-num2{        left: 66%;bottom: 38%;}
        #sc-num3{    left: 52%;bottom: 50%;}
        #sc-num4{      left: 18%;bottom: 59%;}
        #sc-num5{        left: 34%;bottom: 16%;}
        #sc-num6{        left: 46%;bottom: 13%;}
        #sc-num7{       left: 24%;bottom: 44%;}



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
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:17%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px;    padding: 0;}


    /*点检数据表格*/
        .CSSsb td,.sb-num1{color: #3bff8b !important;}
        .CSSdy td,.dy-num{color: #ffeb3b ;}
        .CSSsc td,.sc-num2,.sc-num{color: #a222ff ;}
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
        <h1 class="title">硫浓密机</h1>
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsb">
                        <td>减速机液压泵油位</td>
                        <td>减速机液压泵是否振动</td>
                        <td>减速机液压泵油位</td>
                        <td>加油泵是否正常</td>
                        <td>耙架提升油缸是否正常</td>
                        <td>消泡泵是否正常</td>
                        <td>行走轮及链条是否正常</td>
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
                        <td>温度</td>
                        <td>振动</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                        <td>温度</td>
                        <td>振动</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                    </tr>
                    </tbody>
                </table>
            </div>
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
                        <td>是否振动</td>
                        <td>螺栓是否紧固</td>
                        <td>润滑是否正常</td>
                        <td>是否振动</td>
                        <td>螺栓是否紧固</td>
                        <td>油位</td>
                        <td>是否正常</td>
                        <td>有无振动</td>
                        <td>螺栓是否紧固</td>
                        <td>润滑是否正常</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr >
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
                        <#--<td class="trCSS">㉑</td>-->
                        <#--<td class="trCSS">㉒</td>-->
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>是否振动</td>
                        <td>螺栓是否紧固</td>
                        <td>润滑是否正常</td>
                        <td>是否振动</td>
                        <td>连接是否紧固</td>
                        <td>是否松动</td>
                        <td>轮胎是否正常</td>
                        <td>润滑是否正常</td>
                        <td>是否松动</td>
                        <td>压力</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/jw/nm1.png"></div>
            <#--设备-->
                <span id="sb-num1" class="sb-num1">①②<br>③</span>
                <span id="sb-num2" class="sb-num1">④⑤</br>⑥</span>
                <span id="sb-num3" class="sb-num1">⑦</span>

            <#--电仪-->
                <span id="dy-num1" class="dy-num">①②<br>③④</span>
                <span id="dy-num2" class="dy-num">⑤⑥<br>⑦⑧</span>

            <#--生产-->
                <span id="sc-num1" class="sc-num">①②<br>③</span>
                <span id="sc-num2" class="sc-num">④⑤<br>⑥</span>
                <span id="sc-num3" class="sc-num">⑦⑧<br>⑨⑩</span>
                <span id="sc-num4" class="sc-num2">⑪⑫⑬</span>
                <span id="sc-num5" class="sc-num2">⑭⑮<br>⑯⑰</span>
                <span id="sc-num6" class="sc-num2">⑱⑲</span>
                <span id="sc-num7" class="sc-num2">⑳</span>


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
                    <#--<td >㉑</td>-->
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
    <script  src="/js/equipment/SpotNSLNM.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>