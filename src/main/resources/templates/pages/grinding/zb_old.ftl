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
    <title>中重型板式给料机</title>
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
    /*标题*/
        html{height: 100%;}
    /*主界面*/
        .main{width:100%;height:70%;min-width: 1170px;min-height: 500px;margin: 0;}

    /*生产数据以及图例模块*/
        .echartsData{width: 25%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}
        .spotstatistics {width: 100%;height: 32%;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spot{height: 98% !important;width: 98% !important;}

    /*设备图例*/
        #legend1{width: 98%;height: 27%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*电仪图例*/
        #legend2{width: 98%;height: 11%;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}


    /*生产图例*/
        #legend3{width: 98%;height: 26%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1 .myTable thead td,#legend2 .myTable thead td,#legend3 .myTable thead td{font-size: 14px}
    #legend1 .myTable tbody td,#legend2 .myTable tbody td,#legend3 .myTable tbody td{font-size: 10px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:49%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        /*.pic{width: 90%;height: 90%;min-height: 300px;min-width: 400px;*/
            /*float: left;   margin-top: 1%;margin-left: 6%;}*/
            .pic{width: 40%;height: 40%;float: left;position: relative;color: #FFFFFF}
            .pic img{width: 100%;height: 100%;}
            #pic1{left: 7%;top: 30%}
            #pic2{left:10%;top: 30%}

    /*#xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;*/
        /*margin-left: 1%;*/
        /*float: left;}*/
    /*图片图例位置样式*/
        /*磨浮*/
        .mf-num1{float: left;position: relative;font-size: 15px}
        #mf-num1 {    left: -61%;
            bottom: -51%;}
        #mf-num4 {    left: -74%;
            bottom: -50%;}
        #mf-num6 {left: -67%;
            bottom: -41%;}
        #mf-num7 {    left: -79%;
            bottom: -39%;}
        #mf-num8 {    left: -70%;
            bottom: -35%;
        }
        #mf-num10 {    left: -85%;
            bottom: -44%;}
        .mf-num2{float: left;position: relative;font-size: 18px;}
        #mf-num11 {    left: -72%;bottom: -65%;}
        #mf-num12 {left: -23%;bottom: -47%;}
        #mf-num15 {left: -34%;bottom: -45%;}
        #mf-num17 {    left: -28%;bottom: -35%;}
        #mf-num18 {    left: -40%;bottom: -35%;}
        #mf-num19 {    left: -23%;bottom: -25%;}
        #mf-num21 {left: -39%;bottom: -36%;}
        #mf-num22 {    left: -25%;bottom: -56%;}
        /*电仪*/
        .dy-num{float: left;position: relative;}
        #dy-num12 {    left: -55%;bottom: -33%;}
        #dy-num3 {    left: -58%;bottom: -36%;}
        #dy-num4 {    left: -40%;bottom: -37%;}
        #dy-num56 {    left: -3%;bottom: -29%;}
        #dy-num7 {    left: -6%;bottom: -32%;}
        #dy-num8 {    left: -5%;bottom: -38%;}
        /*生产*/
        .sc-num{float: left;position: relative;}
        .sc-num2{float: left;position: relative;font-size: 18px}
        #sc-num1{    left: -65%;bottom: -10%;}
        #sc-num2{    left: -79%;bottom: -23%;}
        #sc-num3{left: -79%;bottom: -26%;}
        #sc-num4{    left: -73%;bottom: -25%;}
        #sc-num6{    left: -69%;bottom: -38%;}
        #sc-num7{    left: -68%;bottom: -38%;}
        #sc-num9{    left: -49%;bottom: -30%;}
        #sc-num11{    left: -25%;bottom: -6%;}
        #sc-num12{    left: -39%;bottom: -18%;}
        #sc-num13{    left: -21%;bottom: -16%;}
        #sc-num14{    left: -33%;bottom: -21%;}
        #sc-num16{    left: -28%;bottom: -34%;}
        #sc-num17{    left: -27%;bottom: -34%;}
        #sc-num19{left: -7%;bottom: -25%;}



    /*报警区域*/
    .main  .alarm{
        width: 22%;height: 99%;min-width: 200px;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}

    /*报警表格字体*/
    .alarm .myTable tbody td{font-size: 14px;padding: 2px;}
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
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:18%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px;    padding: 3px;}


    /*点检数据表格*/
        .CSSmf td,.mf-num1, .mf-num2{color: #3bff8b ;}
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
        <h1 class="title">中重型板式给料机</h1>
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
                        <td class="trCSS">⑪</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>轴承温度</td>
                        <td>油质</td>
                        <td>油位</td>
                        <td>首尾轮润滑</td>
                        <td>首尾轮链条</td>
                        <td>联接套</td>
                        <td>下矿仓护板</td>
                        <td>槽板</td>
                        <td>拖轮润滑</td>
                        <td>链条运行</td>
                        <td>紧固螺栓是否松动</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr >
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
                        <td >㉒</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>轴承温度</td>
                        <td>油质</td>
                        <td>油位</td>
                        <td>首尾轮润滑</td>
                        <td>首尾轮链条</td>
                        <td>联接套</td>
                        <td>下矿仓护板</td>
                        <td>槽板</td>
                        <td>拖轮润滑</td>
                        <td>链条运行</td>
                        <td>紧固螺栓是否松动</td>
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
                        <#--<td>⑨</td>-->
                        <#--<td>⑩</td>-->
                        <#--<td class="trCSS">⑪</td>-->
                        <#--<td class="trCSS">⑫</td>-->
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
                        <td>是否结拱</td>
                        <td>下矿口缓冲杠是否磨损</td>
                        <td>护板是否磨损</td>
                        <td>链条是否磨损</td>
                        <td>链条是否跑偏</td>
                        <td>润滑</td>
                        <td>油位</td>
                        <td>异响</td>
                        <td>振动</td>
                        <td>油温</td>
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
                        <td>是否结拱</td>
                        <td>下矿口缓冲杠是否磨损</td>
                        <td>护板是否磨损</td>
                        <td>链条是否磨损</td>
                        <td>链条是否跑偏</td>
                        <td>润滑</td>
                        <td>油位</td>
                        <td>异响</td>
                        <td>振动</td>
                        <td>油温</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/geikuang-fenji/zhongban2.png">1#中重型板式给料机</div>
            <div id="pic2" class="pic"><img src="/images/equipment/geikuang-fenji/zhongban2.png">2#中重型板式给料机</div>
            <#--设备-->
                <span id="mf-num1" class="mf-num1">①②<br>③</span>
                <span id="mf-num4" class="mf-num1">④⑤</span>
                <span id="mf-num6" class="mf-num1">⑥</span>
                <span id="mf-num7" class="mf-num1">⑦</span>
                <span id="mf-num8" class="mf-num1">⑧⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num11" class="mf-num2">⑪</span>
                <span id="mf-num12" class="mf-num2">⑫⑬<br>⑭</span>
                <span id="mf-num15" class="mf-num2">⑮⑯</span>
                <span id="mf-num17" class="mf-num2">⑰</span>
                <span id="mf-num18" class="mf-num2">⑱</span>
                <span id="mf-num19" class="mf-num2">⑲⑳</span>
                <span id="mf-num21" class="mf-num1">㉑</span>
                <span id="mf-num22" class="mf-num1">㉒</span>
            <#--电仪-->
                <span id="dy-num12" class="dy-num">①②</span>
                <span id="dy-num3" class="dy-num">③</span>
                <span id="dy-num4" class="dy-num">④</span>
                <span id="dy-num56" class="dy-num">⑤⑥</span>
                <span id="dy-num7" class="dy-num">⑦</span>
                <span id="dy-num8" class="dy-num">⑧</span>
            <#--生产-->
                <span id="sc-num1" class="sc-num">①</span>
                <span id="sc-num2" class="sc-num">②</span>
                <span id="sc-num3" class="sc-num">③</span>
                <span id="sc-num4" class="sc-num">④⑤</span>
                <span id="sc-num6" class="sc-num">⑥</span>
                <span id="sc-num7" class="sc-num">⑦⑧</span>
                <span id="sc-num9" class="sc-num">⑨⑩</span>
                <span id="sc-num11" class="sc-num2">⑪</span>
                <span id="sc-num12" class="sc-num2">⑫</span>
                <span id="sc-num13" class="sc-num2">⑬</span>
                <span id="sc-num14" class="sc-num2">⑭⑮</span>
                <span id="sc-num16" class="sc-num2">⑯</span>
                <span id="sc-num17" class="sc-num2">⑰⑱</span>
                <span id="sc-num19" class="sc-num2">⑲⑳</span>


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
                    <td >㉒</td>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <script  src="/js/equipment/SpotMKZB.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>