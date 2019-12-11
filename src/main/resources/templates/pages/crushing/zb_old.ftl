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
    <title>重型板式给料机</title>
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
        .echartsData{width: 24%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}
        .spotstatistics {width: 100%;height: 38%;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spotzb{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 30%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 12%;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic6.png");background-size: 100% 100%;}


    /*磨浮图例*/
        #legend3{width: 98%;height:15%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1 .myTable thead td,#legend2 .myTable thead td,#legend3 .myTable thead td{font-size: 14px}
        #legend1 .myTable tbody td,#legend2 .myTable tbody td,#legend3 .myTable tbody td{font-size: 10px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:50%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        /*.pic{width: 90%;height: 90%;min-height: 300px;min-width: 400px;*/
            /*float: left;   margin-top: 1%;margin-left: 6%;}*/
            .pic{width: 70%;height: 70%;float: left;position: relative;color: #FFFFFF;left: 15%;top: 18%}
            .pic img{width: 100%;height: 100%;}



    /*#xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;*/
        /*margin-left: 1%;*/
        /*float: left;}*/
    /*图片图例位置样式*/
        /*磨浮*/
        .sb-num1{float: left;position: relative;font-size: 15px}
        .sb-num2{float: left;position: relative;font-size: 18px;}
        #sb-num1 {      left: -29%;bottom: -72%;}
        #sb-num2 {      left: -21%;bottom: -69%;}
        #sb-num3 {      left: -4%;bottom: -49%;}
        #sb-num4 {      left: -4%;bottom: -67%;}
        #sb-num5 {     left: -38%;bottom: -64%;}
        #sb-num6 {     left: -29%;bottom: -66%;}
        #sb-num7 {     left: -44%;bottom: -27%;}
        #sb-num8 {     left: -64%;bottom: -45%;}
        #sb-num9 {     left: -43%;bottom: -48%;}
        #sb-num10 {    left: -68%;bottom: -49%;}
        #sb-num11 {    left: -17%;bottom: -35%;}
        #sb-num12 {    left: -17%;bottom: -32%;}
        #sb-num13 {    left: -48%;bottom: -23%;}

        /*电仪*/
        .dy-num{float: left;position: relative;}
        #dy-num1 {    left: -1%;bottom: -35%;}



        /*生产*/
        .sc-num{float: left;position: relative;}
        #sc-num1{       left: -44%;bottom: -77%;}
        #sc-num2{       left: -57%;bottom: -65%;}
        #sc-num3{       left: -49%;bottom: -54%;}
        #sc-num4{        left: -69%;bottom: -27%;}
        #sc-num5{       left: -58%;bottom: -21%;}
        #sc-num6{       left: -8%;bottom: -29%;}

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
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:18%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px;    padding: 3px;}


    /*点检数据表格*/
        .CSSsb td,.sb-num1, .sb-num2{color: #3bff8b ;}
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
        <h1 class="title">重型板式给料机</h1>
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
                        <td>有无磨损</td>
                        <td>有无滑动</td>
                        <td>有无松动</td>
                        <td>油位</td>
                        <td>温度</td>
                        <td>有无异响</td>
                        <td>有无异响</td>
                        <td>有无松动</td>
                        <td>有无断裂</td>
                        <td>是否灵活</td>
                        <td>有无破损</td>

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
                    <tr class="CSSsb">
                        <td>有无松动</td>
                        <td>有无断痕</td>
                        <td>有无跑偏</td>
                        <td>有无磨损</td>
                        <td>有无积矿</td>
                        <td>是否失效</td>
                        <td>有无磨损</td>
                        <td>有无异响</td>
                        <td>有无裂痕</td>
                        <td>是否松动</td>
                        <td>是否正常</td>
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
                        <#--<td>⑤</td>-->
                        <#--<td>⑥</td>-->
                        <#--<td>⑦</td>-->
                        <#--<td>⑧</td>-->
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>是否松动</td>
                        <td>有无漏矿</td>
                        <td>有无异响</td>
                        <td>是否正常</td>
                        <td>有无发热</td>
                        <td>有无漏油</td>
                        <td>有无跑偏</td>
                        <td>有无变形</td>
                        <td>是否正常</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/sk/zhongban2.png"></div>
            <#--设备-->
                <span id="sb-num1" class="sb-num1">①</span>
                <span id="sb-num2" class="sb-num1">②</span>
                <#--<span id="sb-num3" class="sb-num1"></span>-->
                <span id="sb-num4" class="sb-num1">③</span>
                <span id="sb-num5" class="sb-num1">④<br>⑤⑥</span>
                <span id="sb-num6" class="sb-num1">⑦⑧<br>⑨</span>
                <span id="sb-num7" class="sb-num2">⑩⑪<br>⑫</span>
                <span id="sb-num8" class="sb-num2">⑬⑭<br>⑮</span>
                <span id="sb-num9" class="sb-num2">⑯⑰</span>
                <span id="sb-num10" class="sb-num2">⑱</span>
                <#--<span id="sb-num11" class="sb-num2"></span>-->
                <span id="sb-num12" class="sb-num1">⑲⑳</span>
                <span id="sb-num13" class="sb-num1">㉑㉒</span>


            <#--电仪-->
                <span id="dy-num1" class="dy-num">①②<br>③④</span>
                <#--<span id="dy-num2" class="dy-num"></span>-->
                <#--<span id="dy-num3" class="dy-num"></span>-->

            <#--生产-->
                <span id="sc-num1" class="sc-num">①</span>
                <span id="sc-num2" class="sc-num">②</span>
                <span id="sc-num3" class="sc-num">③④<br>⑤⑥</span>
                <span id="sc-num4" class="sc-num">⑦</span>
                <span id="sc-num5" class="sc-num">⑧</span>
                <span id="sc-num6" class="sc-num">⑨</span>




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
                        <#--<#if alarmZmjs??>-->
                            <#--<#list alarmZmjs as list>-->
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
                    <td >㉑</td>
                    <td >㉒</td>

                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <script  src="/js/equipment/SpotSKZB.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>