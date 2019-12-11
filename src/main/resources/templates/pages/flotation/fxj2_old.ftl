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
    <title>刮板浮选机</title>
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
        .echartsData{width: 18%;height: 100%;min-width: 200px;min-height: 400px;margin: 0;float: left;margin-left: 1.5%;}
        .spotstatistics {width: 100%;height: 40%;min-height: 200px;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}
        #spot{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 30%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 16%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}


    /*磨浮图例*/
    #legend3{width: 98%;height: 18%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
        background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1,#legend2 .myTable thead td{font-size: 12px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        #fxjImg{    width: 61%;height: 84%;min-height: 300px;min-width: 400px;float: left;margin-top: 8%;margin-left: 19%;}
    #chooseEquip{    position: absolute;
        margin-left: 43%;
        margin-top: 3%;}
    #xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;
        margin-left: 1%;
        float: left;}
    /*图片图例位置样式*/
        /*磨浮*/
        .mf-num1{float: left;position: absolute;font-size: 15px}
        #mf-num1 {    left: 44%;top: 27%;}
        #mf-num3 {    left: 44%;top: 30%;}
        #mf-num5 {left: 45%;top: 23%;}
        #mf-num6 {    left: 35%;top: 32%;}
        #mf-num7 {       left: 57%;top: 35%;}
        #mf-num8 {   left: 33%;top: 32%;}
        #mf-num9 {       left: 51%;top: 40%;}
        #mf-num10 {     left: 45%;top: 40%;}
        .mf-num2{float: left;position: absolute;font-size: 18px;}
        #mf-num11 { left: 38%;top: 40%;}
        #mf-num12 {   left: 33%;top: 41%;}
        #mf-num13 {     left: 38%;top: 36%;}
        #mf-num14 {   left: 41%;top: 31%;}
        #mf-num15 {   left: 41%;top: 28%;}
        #mf-num16 {  left: 57%;top: 43%;}
        #mf-num17{    left: 34%;top: 29%;}
        /*电仪*/
        .dy-num{float: left;position: absolute;color: #00fff7;}
        #dy-num1{    left: 56%;top: 24%;}
        #dy-num3 {left: 56%;top: 29%;}

        /*生产*/
        .sc-num{float: left;position: absolute;color: #a8eeb3;}
        #sc-num1{     left: 32%;top: 46%;}
        #sc-num2{  left: 37%;top: 41%;}
        #sc-num3{left: 59%;top: 34%;}
        #sc-num4{    left: 39%;top: 43%;}
        #sc-num5{       left: 33%;top: 29%;}



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

    #equipName{background-color: transparent;color: white;border: transparent; margin-right: 2%;margin-top: 5%;}
    #equipName option{    background-color: #4e5df8;color: #ffffff;border: transparent;}

    /*详细数据*/
        #detaileddata{margin: 1% 5% 0 1%;width:98%;height:18%;min-width: 1170px;min-height: 30px;
            background-image: url("/images/module/pic4.png");background-size: 100% 100%;}
        #detaileddata .myTable tbody td{font-size: 14px;    padding: 3px;}


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
        <h1 class="title">浮选机</h1>
    <#--当前时间-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    </div>
    <div class="main">
    <#--表格数据-->
        <div class="echartsData"  id="alarm1">
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

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>温度</td>
                        <td>润滑</td>
                        <td>温度</td>
                        <td>润滑</td>
                        <td>是否破损</td>
                        <td>风管无漏气</td>
                        <td>无松动</td>
                        <td>电流</td>
                        <td>刮板轴</td>

                    </tr>
                    </tbody>
                    <thead>
                    <tr >
                        <td>⑩</td>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                        <td class="trCSS">⑮</td>
                        <td class="trCSS">⑯</td>
                        <td class="trCSS">⑰</td>

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>夹板</td>
                        <td>U型垫</td>
                        <td>消泡水管</td>
                        <td>刮板轴润滑</td>
                        <td>主轴</td>
                        <td>定子</td>
                        <td>叶轮及盖板</td>
                        <td>其它</td>
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

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSdy">
                        <td>振动</td>
                        <td>温度</td>
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>运行</td>
                        <td>消泡水</td>
                        <td>泡沫</td>
                        <td>泡沫管、溜槽</td>
                        <td>其它</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="chooseEquip">
                <table>
                    <tr>
                        <td>
                            <span id="cc" style="color: #FFFFFF">设备选择:</span>
                        </td>
                        <td>
                            <select id="equipName" onclick="getAlarmData();echartsData();getDetailedData()">
                                <option value="25#浮选机">25#浮选机</option>
                                <option value="26#浮选机">26#浮选机</option>
                                <option value="27#浮选机">27#浮选机</option>
                                <option value="28#浮选机">28#浮选机</option>
                                <option value="29#浮选机">29#浮选机</option>
                                <option value="30#浮选机">30#浮选机</option>
                                <option value="31#浮选机">31#浮选机</option>
                                <option value="32#浮选机">32#浮选机</option>
                                <option value="33#浮选机">33#浮选机</option>
                                <option value="34#浮选机">34#浮选机</option>
                                <option value="35#浮选机">35#浮选机</option>
                                <option value="36#浮选机">36#浮选机</option>
                                <option value="37#浮选机">37#浮选机</option>
                                <option value="38#浮选机">38#浮选机</option>
                                <option value="39#浮选机">39#浮选机</option>
                                <option value="40#浮选机">40#浮选机</option>
                                <option value="41#浮选机">41#浮选机</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>

            <img id="fxjImg" src="/images/equipment/fx/fxj2.png">

            <#--设备-->
                <span id="mf-num1" class="mf-num1">①②</span>
                <span id="mf-num3" class="mf-num1">③④</span>
                <span id="mf-num5" class="mf-num1">⑤</span>
                <span id="mf-num6" class="mf-num1">⑥</span>
                <span id="mf-num7" class="mf-num1">⑦</span>
                <span id="mf-num8" class="mf-num1">⑧</span>
                <span id="mf-num9" class="mf-num1">⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num11" class="mf-num2">⑪</span>
                <span id="mf-num12" class="mf-num2">⑫</span>
                <span id="mf-num13" class="mf-num2">⑬</span>
                <span id="mf-num14" class="mf-num2">⑭</span>
                <span id="mf-num15" class="mf-num2">⑮</span>
                <span id="mf-num16" class="mf-num2">⑰</span>
                <span id="mf-num17" class="mf-num2">⑰</span>
            <#--电仪-->
                <span id="dy-num1" class="dy-num">①②</span>
                <span id="dy-num3" class="dy-num">③④</span>

            <#--生产-->
                <span id="sc-num1" class="sc-num">①</span>
                <span id="sc-num2" class="sc-num">②</span>
                <span id="sc-num3" class="sc-num">③</span>
                <span id="sc-num4" class="sc-num">④</span>
                <span id="sc-num5" class="sc-num">⑤</span>

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
                    <#--<td class="trCSS">⑱</td>-->
                    <#--<td class="trCSS">⑲</td>-->
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <script  src="/js/equipment/SpotFXFxj1.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>