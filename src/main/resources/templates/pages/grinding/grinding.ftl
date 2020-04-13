<!DOCTYPE html>
<#--判断用户是否登录-->
<#if !Session.username??>
    <script>
        alert("账号未登陆，请登录...");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    </script>
</#if>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>磨矿工序</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <script type="text/css"></script>
    <style media="screen">


    /*背景*/
        html,body{height: 100%;overflow: hidden;}
        *{margin: 0;padding: 0;}
   /* 设置滚动条的宽度-谷歌浏览器 */
        /*body::-webkit-scrollbar {  width: 0.01px;}*/
        #container,
    /*全屏滚动*/
        .sections{position: relative;height: 100%;background-image: url("/images/background.jpg");background-size: 100% 100%; ;}
     /*单个屏幕*/
        .section{
            /*必须，兼容，在浏览器不支持transform属性时，通过改变top/left完成滑动动画*/
            position: relative;
            /*必须，关系到单个page能否全屏显示*/
            height: 100%;
        }

       #main1,#main2,#main3
       {
            height: 95%;
            width: 100%;
        }
/***********************第一页******************************/
    /*主展示区*/
        .secondLine {width: 100%;height: 91%;min-height: 400px;min-width: 1170px;display: inline-block;margin-left: 1.5%;}

    /*数据统计*/
        .firstColumn{width: 18%;height: 100%;min-width: 250px;min-height: 400px;display: inline-block;position: relative;float: left;}

    /*生产/点检数据*/
        .echartsData{width: 100%;height: 33%;margin-left: 2px;
            background-image: url("/images/module/aleftboxtbott.png");background-size: 100% 100%; ;}
        #balldata,#djdata,#qxcl{
            height: 98% !important;
            width: 98% !important;
        }

    /*数据统计标题*/
      .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}

    /*数据统计区域尺寸*/
        .statistics{width: 100%;height: 91%;}

    /*图形区*/
        .secondColumn{
            float: left;
            width:55%;
            height:100%;
            min-width: 400px;
            min-height: 500px;
            margin: 0 0.5%;
            background-size: 100% 100%;
            background-repeat: no-repeat;
            border-radius: 1%;
            background-image: url("/images/module/amiddboxttop.png");
        }
    /*去各个设备的按钮*/
         .url {float: left;position: relative;border: none;outline:none;background: transparent;cursor:pointer; /*鼠标移动上时变为小手*/}
        #url-bzmj{    bottom: 40%;left: -74%;width: 16%;height: 20%;}
        #url-zmj{    left: 37%;bottom: 46%;width: 26%;height: 13%;}
        #url-qmj{    left: 23%;bottom: 62%;width: 36%;height: 21%;}
        #url-xlq1{    left: 49%;bottom: 81%;width: 24%;height: 16%;}
        #url-xlq2{    left: 40%;bottom: 57%;width: 14%;height: 11%;}
        #url-pd{    left: -48%;bottom: 50%;width: 12%;height: 12%;}
        #url-zb{    left: -12%;bottom: 57%;width: 24%;height: 5%;}
    /*系统图*/
        .mj{width: 99%;height: 90%;min-height: 300px;min-width: 400px;margin-top: 6%;}

    /*报警区域*/
    .thirdColumn{
        width: 22%;height: 100%;min-width: 200px;overflow-y: hidden;float: left;
        border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}


    /* 设置滚动条的样式 ---纵向,横向*/
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
    /*滚动条整体样式*/
    .alarmbody .myTable tbody::-webkit-scrollbar {width: 3%;height: 4px;scrollbar-arrow-color:red;}
    /*滚动条里面小方块*/
    .alarmbody .myTable tbody::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
    /*滚动条里面轨道*/
    .alarmbody .myTable tbody::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background: #192683;}

    /*报警表格字体*/
    .myTable tbody td{font-size: 14px}
    .myTable thead td{font-size: 16px}

    /*报警表格标题*/
    .tableTitle{z-index: -2;color: white;font-size: 14px;margin-top: 4%;text-align: center;}

    .alarmbody .myTable tbody {display:block;overflow-y:scroll;position: relative;}
    /*#tablebody{height: 80%;}*/
    .alarmbody .myTable thead, tbody tr {display:table;width:100%;table-layout:fixed;}
    .alarmbody .myTable thead {width: calc( 100% - 0.6em )}


    </style>
</head>
<#--<body >-->
<body>
<div id="container">
    <div class="sections">
        <#--第一页-->
        <div class="section"  >
            <div id="main1">
                <div class="menu">
                    <div class="menuLeft" >
                        <a href="#" onClick="javascript :history.back(-1);">返回</a>
                        <a href = "javascript:choosePath()">返回数据中心</a>
                    </div>
                    <h1 class="title">磨矿工序</h1>
                    <div class="menuRight">
                        <script src="/js/utils/currentDateTime/currentDateTime1.js"> </script>
                        <output class="currentTime"  id="current1"></output>
                    </div>
                </div>
                <div class="secondLine">

                    <#--工段的生产数据-->
                        <div class="firstColumn" id="alarm1">
                            <div  class="echartsData">
                                <h2 class="spotStatistics_title">加球统计</h2>
                                <div class="statistics">
                                    <div id="balldata"></div>
                                </div>
                            </div>
                            <div class ="echartsData">
                                <h2 class="spotStatistics_title">点检统计</h2>
                                <div class="statistics">
                                    <div id="djdata"></div>
                                </div>
                            </div>
                            <div class="echartsData">
                                <h2 class="spotStatistics_title">缺陷处理</h2>
                                <div class="statistics">
                                    <div id="qxcl"></div>
                                </div>
                            </div>
                        </div>
                    <#--工段的流程图-->
                        <div class="secondColumn">

                            <#--<img src="/images/equipment/mk/mkxt-min.png" class="mj">-->
                            <img src="/images/equipment/mk/mkxt6.png" class="mj">
                            <a href="/spot/mk/xlq" >
                                <button id="url-xlq1" class="url"></button>
                            </a>
                            <a href="/spot/mk/xlq" >
                                <button id="url-xlq2" class="url"></button>
                            </a>
                            <a href="/spot/mk/zb" >
                                <button id="url-zb" class="url"></button>
                            </a>
                            <a href="/spot/mk/pd" >
                                <button id="url-pd" class="url"></button>
                            </a>
                            <a href="/spot/mk/bzmj" >
                                <button id="url-bzmj" class="url"></button>
                            </a>
                            <a href="/spot/mk/qmj" >
                                <button id="url-qmj" class="url"></button>
                            </a>

                            <a href="/spot/mk/zmj" >
                                <button id="url-zmj"  class="url"></button>
                            </a>

                        </div>
                    <#--报警数据统计表格-->

                    <div class="thirdColumn" >
                        <div class="tableTitle"  id="alarm2">报警数据</div>
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
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            </div>

    </div>
</div>



<script src="/plugins/switch/jquery.js" charset="utf-8"></script>
<script src="/plugins/switch/XSwitch1.js" charset="utf-8"></script>
<script src="/js/echarts.min.js"></script>

<script>
    $('#container').XSwitch({
        direction: 'vertical'
    });
</script>
<script  src="/js/process/mk-1.0.0.js"></script>
<script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>
</body>
</html>
