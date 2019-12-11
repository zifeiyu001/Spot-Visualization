<!DOCTYPE html>
<#--判断用户是否登录-->
<#--<#if !Session.username??>-->
    <#--<script>-->
        <#--alert("账号未登陆，请登录...");-->
        <#--window.location.href='http://172.16.5.4/bkzyCMS/login';-->
    <#--</script>-->
<#--</#if>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>旋流器</title>
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
        #spotmkxlq{height: 98% !important;width: 98% !important;}

    /*电仪图例*/
        #legend1{width: 98%;height: 21%;;min-width: 200px;margin: 5px auto;border-radius: 1%;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*磨浮图例*/
        #legend2{width: 98%;height: 16%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
            background-image: url("/images/module/pic5.png");background-size: 100% 100%;}


    /*磨浮图例*/
    #legend3{width: 98%;height: 37%;min-height: 50px;min-width: 200px;margin-bottom: 1px;
        background-image: url("/images/module/pic5.png");background-size: 100% 100%;}

    /*图例字体*/
        #legend1,#legend2 .myTable thead td{font-size: 12px}

    /*序号字体*/
        .CSSNum{font-size: 16px}

    /*主图*/
        .show{width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5% ;float: left;text-align: center;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
    /*图片*/
        .pic{width: 30%;height: 40%;float: left;position: relative;color: #FFFFFF}
        .pic img{width: 100%;height: 100%;}
            #pic1{left: 3%;top: 21%}
            #pic2{left: 3%;top: 21%}
            #pic3{left: 3%;top: 21%}
    /*#xyz{width: 40%;height: 40%;min-height: 300px;min-width: 400px;margin-top: 13%;*/
        /*margin-left: 1%;*/
        /*float: left;}*/
    /*图片图例位置样式*/
        /*磨浮*/
        .mf-num1{float: left;position: relative;font-size: 15px}
        #mf-num1 {left: -81%;bottom: -55%;}
        #mf-num2 {left: -74%;bottom: -39%;}
        #mf-num34 {left: -73%;bottom: -39%;}
        #mf-num5 {left: -58%;bottom: -55%;}
        #mf-num6 {left: -42%;bottom: -34%;}
        #mf-num78 {left: -41%;bottom: -34%;}
        #mf-num9 {left: -26%;bottom: -52%;}
        #mf-num10 {left: -19%;bottom: -35%;}
        .mf-num2{float: left;position: relative;font-size: 18px;}
        #mf-num112 {left: -9%;bottom: -31%;}

        .sc-num1{float: left;position: relative;}
        .sc-num2{float: left;position: relative;font-size: 18px;}

        #sc-num1{left: -89%;bottom: -27%;}
        #sc-num4 {    left: -74%;bottom: -37%;}
        #sc-num6{    left: -78%;bottom: -9%;}
        #sc-num8 {left: -55%;bottom: -18%;}
        #sc-num11{left: -48%;bottom: -32%;}
        #sc-num13{left: -48%;bottom: 0%;}
        #sc-num15{left: -25%;bottom: -8%;}
        #sc-num18{left: -18%;bottom: -23%;}
        #sc-num20{    left: -18%;bottom: 9%;}



    /*报警区域*/
    .main  .alarm{
        width: 22%;height: 99%;min-width: 200px;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}

    /*报警表格字体*/
    .alarm .myTable tbody td{font-size: 14px;padding: 2px;}
    .myTable thead td{font-size: 16px}

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
        /*.CSSmf td,.mf-num1, .mf-num2{color: #3bff8b !important;}*/
        /*.CSSdy td{color: #00fff7 !important;}*/
        /*.CSSsc td{color: #d7ffc7 !important;}*/
        .trCSS{font-size: 18px !important ;}

    .CSSmf td,.mf-num1{color: #3bff8b ;}
    .CSSsc td,.sc-num1,.sc-num2{color: #a222ff ;}

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
        <h1 class="title">旋流器</h1>
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
                        <td class="trCSS">⑫</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSmf">
                        <td>是否松动</td>
                        <td>内衬磨损</td>
                        <td>是否磨损</td>
                        <td>是否泄漏</td>
                        <td>是否松动</td>
                        <td>内衬磨损</td>
                        <td>是否磨损</td>
                        <td>是否泄漏</td>
                        <td>是否松动</td>
                        <td>内衬磨损</td>
                        <td>是否磨损</td>
                        <td>是否泄漏</td>
                    </tr>
                    </tbody>
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>沉砂溢流是否堵塞</td>
                        <td>是否堵塞</td>
                        <td>是否正常运行</td>
                        <td>是否漏水</td>
                        <td>是否正常读数</td>
                        <td>水量</td>
                        <td>其它</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr class="CSSNum">
                        <td>⑧</td>
                        <td>⑨</td>
                        <td>⑩</td>
                        <td class="trCSS">⑪</td>
                        <td class="trCSS">⑫</td>
                        <td class="trCSS">⑬</td>
                        <td class="trCSS">⑭</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>沉砂溢流是否堵塞</td>
                        <td>是否堵塞</td>
                        <td>是否正常运行</td>
                        <td>是否漏水</td>
                        <td>是否正常读数</td>
                        <td>水量</td>
                        <td>其它</td>
                    </tr>
                    </tbody>
                    <thead>
                    <tr class="CSSNum">
                        <td class="trCSS">⑮</td>
                        <td class="trCSS">⑯</td>
                        <td class="trCSS">⑰</td>
                        <td class="trCSS">⑱</td>
                        <td class="trCSS">⑲</td>
                        <td class="trCSS">⑳</td>
                        <td class="trCSS">㉑</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="CSSsc">
                        <td>沉砂溢流是否堵塞</td>
                        <td>是否堵塞</td>
                        <td>是否正常运行</td>
                        <td>是否漏水</td>
                        <td>是否正常读数</td>
                        <td>水量</td>
                        <td>其它</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/geikuang-fenji/shuilixuanliuqi.png">FX-350GT旋流器</div>
            <div id="pic2" class="pic"><img src="/images/equipment/geikuang-fenji/shuilixuanliuqi.png">FX-660GT旋流器(A组)</div>
            <div id="pic3" class="pic"><img src="/images/equipment/geikuang-fenji/shuilixuanliuqi.png">FX-350GT旋流器(B组)</div>
            <#--<img id="pic" src="/images/equipment/geikuang-fenji/shuilixuanliuqi.png">-->
            <#--设备-->
                <span id="mf-num1" class="mf-num1">①</span>
                <span id="mf-num2" class="mf-num1">②</span>
                <span id="mf-num34" class="mf-num1">③④</span>
                <span id="mf-num5" class="mf-num1">⑤</span>
                <span id="mf-num6" class="mf-num1">⑥</span>
                <span id="mf-num78" class="mf-num1">⑦⑧</span>
                <span id="mf-num9" class="mf-num1">⑨</span>
                <span id="mf-num10" class="mf-num1">⑩</span>
                <span id="mf-num112" class="mf-num2">⑪⑫</span>
            <#--生产-->
                <span id="sc-num1" class="sc-num1">①②<br>④</span>
                <span id="sc-num4" class="sc-num1">③⑦</span>
                <span id="sc-num6" class="sc-num1">⑤⑥</span>


                <span id="sc-num8" class="sc-num1">⑧⑨<br>⑪</span>
                <span id="sc-num11" class="sc-num2">⑩⑭</span>
                <span id="sc-num13" class="sc-num2">⑫⑬</span>

                <span id="sc-num15" class="sc-num2">⑮⑯<br>⑱</span>
                <span id="sc-num18" class="sc-num2">⑰㉑</span>
                <span id="sc-num20" class="sc-num2">⑲⑳</span>

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
                    <td class="trCSS">㉑</td>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <script  src="/js/equipment/SpotMKXLQ.js"></script>
    <script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>


</body>
</html>