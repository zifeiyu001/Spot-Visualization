<!DOCTYPE html>
<#----------------判断用户是否登录------------------>
<#if !Session.username??>
    <script>
        alert("账号未登陆，请登录...");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    </script>
</#if>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>脱水工序</title>
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <script type="text/css"></script>
    <style media="screen">

        *{margin: 0;padding: 0;}
    /*背景*/
        html,body{height: 100%;overflow: hidden;}
   /* 设置滚动条的宽度-谷歌浏览器 */
        body::-webkit-scrollbar {  width: 0.01px;}
        #container,
    /*全屏滚动*/
        .sections{
            position: relative;
            height: 100%;
            background-image: url("/images/background.jpg");
            background-size: 100% 100%; ;
        }
     /*单个屏幕*/
        .section{
            /*必须，兼容，在浏览器不支持transform属性时，通过改变top/left完成滑动动画*/
            position: relative;
            /*必须，关系到单个page能否全屏显示*/
            height: 100%;
        }
       #main1{height: 95%;width: 100%;min-height: 700px;min-width: 1260px;}
/***********************第一页******************************/
        .secondLine {width: 100%;height: 91%;min-height: 400px;min-width: 1170px;display: inline-block;margin-left: 1.5%;}
        /*第一列，缺陷处理、点巡检结果*/
        #firstColumn{width: 18%;height: 100%;min-width: 250px;min-height: 400px;display: inline-block;position: relative;float: left;}
        /*生产/点检数据*/
        #djdata,#qxcl{height: 98% !important;width: 98% !important;}
        .spotstatistics {width: 100%;height: 50%;min-height: 200px;min-width: 200px;margin: 2px;
            background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}

        /*图形区*/
        .secondColumn{float: left;width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5%;background-size: 100% 100%;
            background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}

        .chartPic{background-size: 100% 100%;width: 28%;height: 28%;position: relative;min-width: 25px;min-height: 25px;
            float: left;color: #FFFFFF;text-align: center;line-height: 1;font-size: 14px;}
        .chartPic1{background-size: 100% 100%;width: 20%;height: 24%;position: relative;min-width: 25px;min-height: 25px;
            color: #FFFFFF;text-align: center;line-height: 1;font-size: 14px;}
        #arrow1 img, #arrow2 img,.chartPic img,.chartPic1 img{width: 100%;height: 100%;;}
        .chartarrow{background-size: 100% 100%;width: 41%;height: 12%;position: relative;min-width: 25px;min-height: 25px;
            color: #FFFFFF;text-align: center;line-height: 1;font-size: 14px;}

            #tjbt{    left: 20%;top: 15%;}
            #ljbt{    left: 60%;top: -9%;}
            #arrow1{left: 9%;}
            #arrow2{   left: 42%;top: -12%;}
            #glj1,#glj2{    left: 2%;top: -10%;}
            #ylj3{        left: 10%;top: -11%;}

     /*报警区*/
        .thirdColumn{width: 22%;height: 100%;min-height: 400px;min-width: 250px;display: inline-block;z-index:3;position: relative;float: left;
            overflow-y: auto;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}
        /*报警表格字体*/
        .myTable tbody td{font-size: 14px}
        .myTable thead td{font-size: 14px;    width: 12%;}

        /*滚动条样式，谷歌浏览器*/
        .thirdColumn::-webkit-scrollbar {/*滚动条整体样式*/width: 3%;;     /*高宽分别对应横竖滚动条的尺寸*/height: 4px;scrollbar-arrow-color:red;}
        .thirdColumn::-webkit-scrollbar-thumb {/*滚动条里面小方块*/border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
        .thirdColumn::-webkit-scrollbar-track {/*滚动条里面轨道*/-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background:transparent;}
        /*报警表格标题*/
        .tableTitle{z-index: -2;color: white;font-size: 14px;margin-top: 4%;text-align: center;}
        /*滚动条整体样式*/
        .alarmbody .myTable tbody::-webkit-scrollbar {width: 3%;height: 0;scrollbar-arrow-color:red;}
        /*滚动条里面小方块*/
        .alarmbody .myTable tbody::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
        /*滚动条里面轨道*/
        .alarmbody .myTable tbody::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background: #192683;}
        .alarmbody .myTable tbody {display:block;overflow-y:scroll;position: relative;}
        #tablebody{height: 80%;}
        .alarmbody .myTable thead, tbody tr {display:table;width:100%;table-layout:fixed;}
        .alarmbody .myTable thead {width: calc( 100% - 0.6em )}

    </style>
</head>
<body>

<div id="container">
    <div class="sections">
        <#--第一页-->
        <div class="section" >
            <div id="main1">
                <div class="menu">
                    <div class="menuLeft" >
                        <a href="#" onClick="javascript :history.back(-1);">返回</a>
                        <a href = "javascript:choosePath()">返回数据中心</a>
                    </div>
                    <h1 class="title">脱水工序</h1>
                    <div class="menuRight">
                        <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
                        <output class="currentTime"  id="current"></output>
                    </div>
                </div>
                <div class="secondLine" id="alarm1">
                    <#--工段的生产数据-->
                        <div id="firstColumn">
                            <div class="spotstatistics">
                                <h2 class="spotStatistics_title">点检统计</h2>
                                <div class="statistics">
                                    <div id="djdata"></div>
                                </div>
                            </div>
                            <div class="spotstatistics">
                                <h2 class="spotStatistics_title">缺陷统计</h2>
                                <div class="statistics">
                                    <div id="qxcl"></div>
                                </div>
                            </div>
                        </div>
                    <#--工段的流程图-->
                        <div class="secondColumn">
                            <div id="tjbt" class="chartPic1"><img src="/images/equipment/jw/jbt.png">硫搅拌桶</div>
                            <div id="ljbt" class="chartPic1"><img src="/images/equipment/jw/jbt.png">铜搅拌桶</div>
                            <div id="arrow1" class="chartarrow"><img src="/images/arrow/doubledown.png"></div>
                            <div id="arrow2" class="chartarrow"><img src="/images/arrow/downright.png"></div>

                            <div id="glj1" class="chartPic"><a href="/spot/ts/glj1"><img src="/images/equipment/jw/tc1.png"></a>1#过滤机</div>

                            <div id="glj2" class="chartPic"><a href="/spot/ts/glj2"><img src="/images/equipment/jw/tc1.png"></a>2#过滤机</div>

                            <div id="ylj3" class="chartPic"><a href="/spot/ts/ylj3"><img src="/images/equipment/jw/ylj.png"></a>3#压滤机</div>

                            <#--<div id="pidai4" class="chartPic"><a href="/spot/sk/pd4"><img src="/images/equipment/sk/pidai.png"></a>4#皮带</div>-->
                        </div>
                    <#--报警数据统计表格-->
                    <div class="thirdColumn">
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
                                <tbody  id="tablebody">
                            </tbody>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</div>





<script  src="/js/process/ts1.js"></script>
<script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>
</body>
</html>
