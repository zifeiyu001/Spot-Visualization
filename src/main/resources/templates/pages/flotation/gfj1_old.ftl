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
    <title>1#鼓风机</title>
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
        #spotGfj1{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 26%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 16%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}


    /*磨浮图例*/
    #legend3{width: 98%;height: 13%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
        background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1,#legend2 .myTable thead td{font-size: 12px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        #gfj{width: 40%;height: 40%;min-height: 300px;min-width: 400px;
            float: left;    margin-top: 13%;margin-left: 4%;}
    #xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;
        margin-left: 1%;
        float: left;}
    /*图片图例位置样式*/
        /*磨浮*/
        .mf-num1{float: left;position: relative;font-size: 15px}
        #mf-num1 {left: 7%;bottom: 20%;}
        #mf-num2 {left: 14%;bottom: 34%;}
        #mf-num3 {left: 11%;bottom: 60%;}
        #mf-num4 {left: 20%;bottom: 58%;}
        #mf-num5 {left: 32%;bottom: 40%;}
        #mf-num6 {left: 58%;bottom: 48%;}
        #mf-num78 {left: 62%;bottom: 27%;}
        #mf-num9 {left: 58%;bottom: 56%;}
        #mf-num10 {left: 56%;bottom: 50%;}
        .mf-num2{float: left;position: relative;font-size: 18px;}
        #mf-num11 {left: 54%;bottom: 39%;}
        #mf-num12 {left: 43%;bottom: 43%;}
        #mf-num13 {left: 45%;bottom: 27%;}
        #mf-num14 {left: 56%;bottom: 57%;}
        #mf-num15 {left: 59%;bottom: 57%;}
        /*电仪*/
        .dy-num{float: left;position: relative;color: #00fff7;}
        #dy-num1234 {left: 11%;bottom: 37%;}
        #dy-num5678 {left: 47%;bottom: 49%;}
        #dy-num9112 {left: 49%;bottom: 49%;}
        /*生产*/
        .sc-num{float: left;position: relative;color: #a8eeb3;}
        #sc-num1{    left: -11%;bottom: 62%;}
        #sc-num2{left: 35%;bottom: 56%;}



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
        <h1 class="title">1#鼓风机</h1>
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
                    <div id="spotGfj1"></div>
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>螺栓是否松动</td>
                        <td>是否有异响</td>
                        <td>是否正常开启</td>
                        <td>是否漏气</td>
                        <td>轴向窜动</td>
                        <td>是否漏油</td>
                        <td>油位</td>
                        <td>油质</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr >
                        <td>⑨</td>
                        <td>⑩</td>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                        <td class="trCSS">⑮</td>
                        <#--<td class="trCSS">⑯</td>-->
                        <#--<td class="trCSS">⑰</td>-->
                        <#--<td class="trCSS">⑱</td>-->
                        <#--<td class="trCSS">⑲</td>-->
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>运行</td>
                        <td>压力</td>
                        <td>压力</td>
                        <td>供油温度</td>
                        <td>油箱温度</td>
                        <td>冷却器</td>
                        <td>滤网有无堵塞</td>
                        <#--<td>水平速度</td>-->
                        <#--<td>垂直速度</td>-->
                        <#--<td>温度</td>-->
                        <#--<td>高低压稀油站</td>-->
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
                        <td>⑨</td>
                        <td>⑩</td>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
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

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>控制柜参数是否正常</td>
                        <td>冷却水是否正常</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <img id="gfj" src="/images/equipment/fx/gfj.png">
            <img id="xyz" src="/images/equipment/fx/xyz.png">
            <#--设备-->
                <span id="mf-num1" class="mf-num1">①</span>
                <span id="mf-num2" class="mf-num1">②</span>
                <span id="mf-num3" class="mf-num1">③</span>
                <span id="mf-num4" class="mf-num1">④</span>
                <span id="mf-num5" class="mf-num1">⑤</span>
                <span id="mf-num6" class="mf-num1">⑥</span>
                <span id="mf-num78" class="mf-num1">⑦⑧</span>
                <span id="mf-num9" class="mf-num1">⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num11" class="mf-num2">⑪</span>
                <span id="mf-num12" class="mf-num2">⑫</span>
                <span id="mf-num13" class="mf-num2">⑬</span>
                <span id="mf-num14" class="mf-num2">⑭</span>
                <span id="mf-num15" class="mf-num2">⑮</span>
            <#--电仪-->
                <span id="dy-num1234" class="dy-num">①②<br>③④</span>
                <span id="dy-num5678" class="dy-num">⑤⑥<br>⑦⑧</span>
                <span id="dy-num9112" class="dy-num">⑨⑩<br>⑪⑫</span>
            <#--生产-->
                <span id="sc-num1" class="sc-num">①</span>
                <span id="sc-num2" class="sc-num">②</span>

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
                    <#--<td class="trCSS">⑯</td>-->
                    <#--<td class="trCSS">⑰</td>-->
                    <#--<td class="trCSS">⑱</td>-->
                    <#--<td class="trCSS">⑲</td>-->
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <script  src="/js/equipment/SpotFXGfj1.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/utils/alarmTable.js"></script>
</body>
</html>