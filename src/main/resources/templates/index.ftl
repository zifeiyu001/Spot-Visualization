<!DOCTYPE html>
<#-------------判断是否保存session---------------->
<#if Session.username??>
    <script>
        var username="${Session.username}";
    </script>
<#else >
    <script>
        var username="";
    </script>
</#if>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>点巡检可视化系统</title>
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/test.css" rel="stylesheet" type="text/css" />
    <link href="/images/micloud.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
     <style>
         /*!*背景*!*/
         *{padding: 0;margin: 0;}
         @media (min-width: 2000px){
             *{font-size: 80px !important}
         }
         body{background-image: url("/images/background.jpg");background-size: 100% 100%;background-attachment: fixed;
             width: auto;height: 100%; margin: 0;padding: 0;z-index: -100;overflow: hidden;}
         html{height: 100%;}

         /*标题-菜单栏*/
         .menu {height: 9%;width: 100%;display: inline-block;}
         .title{width: 33%;height: 100%;margin: 0;color: white;float: left;min-width: 200px;text-align: center;line-height: 200%;}

         /*主要数据展示界面*/
         .show{width:100%;height:91%;min-width: 1170px;min-height: 500px;margin: 0;}

         /*点检统计*/
         .show .spotStatistics{width: 18%;height: 98% !important;min-width: 200px;min-height: 500px;float: left;text-align: center;padding-left: 1.5%;}

         /*各个点检统计*/
         .show .spotStatistics .sc,.dy,.sb{
             width: 99%;min-width: 200px;height: 32.5%;font-size: 1%;min-height: 150px;background-size: 100% 100%;
             background-image: url("/images/module/aleftboxtbott.png");
             background-color: rgba(255, 255, 255, 0.0);border-color:rgba(255, 255, 255, 0.0);outline: none;}

         .show .spotStatistics button{z-index: 999 !important;}
         /*点检统计个模块的尺寸*/
         #sc1,#dy1,#sb1{height: 98% !important;width: 98% !important;}
         .show .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 12px;}
         .statistics{width: 100%;height: 100%;}

         /*流程图*/
         .show .main{
             float: left;width:55%;height:96%;min-width: 400px;min-height: 500px;margin: 0 0.5%;
             background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}
         /*总的数据统计*/
         .totalData{width: 100%;height: 15%;}
         .totalDataBackground{width: 19%;height: 100%;background-image: url("/images/module/amiddboxtop.png");
             background-size: 100% 100%;margin-left: 0.8%;float: left;}
         .totalDataValue{width: 100%;height: 20%;text-align: center;color: #FFFFFF;left: 1%;margin-top: 13%;}
         .totalDataValue output{margin: 1%;}
         .totalDataValue1 output{margin: 1%;}
         .totalDataKey{margin: 0 0 0 8%; color: white;}
         .unit{color:#FFFFFF; float: right; margin-right: 10%}
         /*流程图区域*/
         .flowChart{width: 100%;height: 50%;    margin-bottom: 14%;}

         /*设备图片*/
         .flowChart_img{background-size: 100% 100%;width: 12%;height: 24%;position: absolute;min-width: 25px;min-height: 25px;
             float: left;color: #FFFFFF;text-align: center;line-height: 1;font-size: 14px;}
         .flowChart_img img{width: 100%;height: 100%;;}
         /*左右箭头图片*/
         .flowChart_right_img{background-size: 100% 100%;width: 1%;height: 1%;position: absolute;min-width: 25px;min-height: 25px;float: left;}

         /*流程图实时数据表格*/
         .equipData output table tr td{cellspacing:0px ;border:1px solid ;font-size: 12px}
         .equipData output table{border-collapse:collapse;border:0px 1px 1px 1px  solid}


         /*流程设备图片的位置*/
         #direction1{    left: 45%;top: 28%;}
         #direction2{    left: 65%;top: 28%;}
         #direction3{left: 57%;top: 55%;}
         #direction4{left: 38%;top: 55%;}
         #img_ep{    left: 30%;top: 15%;}
         #img_mj{left: 50%;top: 16%;}
         #img_fx{    left: 60%;top: 42%;}
         #img_tnm{left: 43%;top: 42%;}
         #img_yl{left: 24%;top: 42%;}



         /*.processData{width: 100%;height: 15%;}*/

         /*报警区域*/
         .show  .alarm{
             width: 22%;height: 96%;min-width: 200px;min-height: 500px;float: left;overflow-y: hidden;
             border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}


         /* 设置滚动条的样式 ---纵向,横向*/
         body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
         /*!*滚动条整体样式*!*/
         .alarmbody .myTable tbody::-webkit-scrollbar {width: 3%;height: 0;scrollbar-arrow-color:red;}
         /*滚动条里面小方块*/
         .alarmbody .myTable tbody::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
         /*滚动条里面轨道*/
         .alarmbody .myTable tbody::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background: #192683;}

         /*报警表格字体*/
         .myTable tbody td{font-size: 14px}
         .myTable thead td{font-size: 12px}

         /*报警表格标题*/
         .tableTitle {z-index: 9998;color: white;font-size: 14px;margin-top: 4%;text-align: center;}

         .alarmbody .myTable tbody {display:block;overflow-y:scroll;position: relative;}
         #tablebody{height: 80%;}
         .alarmbody .myTable thead, tbody tr {display:table;width:100%;table-layout:fixed;}
         .alarmbody .myTable thead {width: calc( 100% - 0.6em )}
     </style>
</head>
<body>
<#--==================首行--菜单=============================-->
<div class="menu">
    <nav>
        <div class="top_left">
            <ul class="level">
                <#--<li><a href="/spot/searchResult">结果查询</a></li>-->
                <li><a href = "/spot/dxj_config">系统配置</a></li>
                    <#--<p>工序选择</p>-->
                    <#--<ul class="two">-->
                        <#--<li><a href="/spot/sk">碎矿</a> </li>-->
                        <#--<li><a href="/spot/mk">磨矿</a> </li>-->
                        <#--<li><a href="/spot/fx">浮选</a> </li>-->
                        <#--<li><a href="/spot/ns">浓缩</a> </li>-->
                        <#--<li><a href="/spot/ts">脱水</a> </li>-->
                    <#--</ul>-->

                <li>
                    <p>报表</p>
                    <ul class="two">
                        <li><a href="/spot/report">设备日/班报表</a></li>
                        <li><a href="/spot/weekReport">设备周期报表</a> </li>
                        <li><a href="/spot/workShopReport">工段报表</a> </li>
                    </ul>
                </li>
                <li>   <a href = "javascript:choosePath()">数据中心</a></li>
            </ul>
        </div>
    </nav>

    <h1 class="title" >选矿厂点巡检系统</h1>
    <#--<nav>-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    <#--</nav>-->
</div>
<#--===========================主展示区================================-->
<div class="show">
    <#--===================各工艺点检统计===================-->
    <div class="spotStatistics">
        <button class="sc"  onclick="getAlarmData('sb')">
            <h2 class="spotStatistics_title">设备点检数据</h2>
            <div  class="statistics" >
                <div id="sb1"></div>
            </div>
        </button>
        <button class="dy"  onclick="getAlarmData('dy')">
            <h2 class="spotStatistics_title">电仪点检数据</h2>
            <div class="statistics">
                <div id="dy1"></div>
            </div>
        </button>
        <button class="sb" onclick="getAlarmData('sc')">
            <h2 class="spotStatistics_title">生产点检数据</h2>
            <div  class="statistics">
                <div id="sc1"></div>
            </div>
        </button>
    </div>
    <#--=======================流程图区域============================-->
    <div class="main"  id="alarm1">
        <div class="flowChart">
            <#--颚式破碎机-->
                <div id="img_ep" class="flowChart_img"><a href="/spot/sk"><img src="/images/equipment/index/ep.png"></a>碎矿</div>
            <#--箭头-->
                <div id="direction1"  class="flowChart_right_img"  style="background-image: url('/images/arrow/right3.png');"></div>
            <#--磨机-->
                <div id="img_mj" class="flowChart_img"><a href="/spot/mk"><img src="/images/equipment/index/mj.png"></a>磨矿</div>
            <#--箭头-->
                <div id="direction2"  class="flowChart_right_img"  style="background-image: url('/images/arrow/rightdown3.png');"></div>
            <#--浮选-->
                <div id="img_fx" class="flowChart_img"><a href="/spot/fx"><img src="/images/equipment/index/fx.png"></a>浮选</div>
            <#--箭头-->
                <div id="direction3"  class="flowChart_right_img"  style="background-image: url('/images/arrow/left3.png');"></div>
            <#--压滤机-->
                <div id="img_yl" class="flowChart_img"><a href="/spot/ts"><img src="/images/equipment/index/ts.png"> </a> 脱水</div>
            <#--箭头-->
                <div id="direction4"  class="flowChart_right_img"  style="background-image: url('/images/arrow/left3.png');"></div>
            <#--铜精矿浓密机-->
                <div id="img_tnm" class="flowChart_img"><a href="/spot/ns"><img src="/images/equipment/index/nm.png"></a>浓缩</div>
        </div>
        <#--=================实时数据展示========-->
        <div class="totalData" >
            <div class="totalDataBackground">
                <span class="totalDataKey" >当月总功率</span>
                <div class="totalDataValue" >
                    <output  id="kw"></output>
                </div>
                <div class="unit">kW</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >当月点检总数</span>
                <div class="totalDataValue" >
                    <output  id="total"></output>
                </div>
                <div class="unit">个</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >当月危险总数</span>
                <div class="totalDataValue" >
                    <output  id="danger"></output>
                </div>
                <div class="unit">个</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >当月报警总数</span>
                <div class="totalDataValue" >
                    <output  id="alarm"></output>
                </div>
                <div class="unit">个</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey">台效</span>
                <div class="totalDataValue" >
                    <output  id="CLL"></output>
                </div>
                <div class="unit">t/h</div>
            </div>
        </div>

        <#--=================实时数据展示========-->
        <div class="processData" >
            <div class="totalDataBackground" style="background-image: url('/images/module/pic7.png')!important;">
                <span class="totalDataKey" >原矿铜品位</span>
                <div class="totalDataValue" >
                    <output  id="Cu"></output>
                </div>
                <div class="unit">%</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >铜精矿铜品位</span>
                <div class="totalDataValue" >
                    <output  id="CuCu"></output>
                </div>
                <div class="unit">%</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey">总尾矿铜品位</span>
                <div class="totalDataValue" >
                    <output  id="WCu"></output>
                </div>
                <div class="unit">%</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >总尾矿硫品位</span>
                <div class="totalDataValue" >
                    <output  id="WS"></output>
                </div>
                <div class="unit">%</div>
            </div>
            <div class="totalDataBackground">
                <span class="totalDataKey" >铜精浓密机浓度</span>
                <div class="totalDataValue" >
                    <output  id="NDJ1ND"></output>
                </div>
                <div class="unit">%</div>
            </div>
        </div>
    </div>
    <#--=======================报警区域====================-->
    <div class="alarm" >
        <div class="tableTitle" id="alarm2"><output id="tablename">报警数据</output></div>

        <div class="alarmbody" >
            <table class="myTable" id="tab" >
                <thead >
                <tr class="tablehead" id="alarm3" >
                    <td onclick="kw.tabSort('tab',0)">设备</td>
                    <td onclick="kw.tabSort('tab',1)">部位</td>
                    <td onclick="kw.tabSort('tab',2)">内容</td>
                    <td onclick="kw.tabSort('tab',3)">结果</td>
                    <td onclick="kw.tabSort('tab',4)">级别</td>
                    <td>处理</td>
                </tr>
                </thead>
                <tbody id="tablebody"></tbody>
            </table>
        </div>
    </div>
</div>
<script src="/js/process/index-1.0.1.js"></script>
<script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>
</body>

</html>