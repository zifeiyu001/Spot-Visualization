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
    <title>浮选工序</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
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
        .sections{position: relative;height: 100%;background-image: url("/images/background.jpg");background-size: 100% 100%; ;}
     /*单个屏幕*/
        .section{
            /*必须，兼容，在浏览器不支持transform属性时，通过改变top/left完成滑动动画*/
            position: relative;
            /*必须，关系到单个page能否全屏显示*/
            height: 100%;

        }
       #main1,#main2,#main3 {height: 95%;width: 100%;min-height: 700px;min-width: 1260px;}
/***********************第一页******************************/
        .secondLine {width: 100%;height: 91%;min-height: 400px;min-width: 1170px;display: inline-block;margin-left: 1.5%;}
        /*第一列，缺陷处理、点巡检结果*/
        #firstColumn{width: 18%;height: 100%;min-width: 250px;min-height: 400px;display: inline-block;position: relative;float: left;}
        /*生产/点检数据*/
        #scdata ,#djdata,#qxcl{height: 98% !important;width: 98% !important;}
        .spotstatistics {width: 100%;height: 33%;min-height: 200px;min-width: 200px;margin: 2px;background-size: 100% 100%;
            background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 1%;height: 8%;font-size: 16px;}
        .statistics{width: 100%;height: 91%;}

        /*图形区*/
        #secondColumn{float: left;width:55%;height:100%;min-width: 400px;min-height: 500px;margin: 0 0.5%;
            background-size: 100% 100%;background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}

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

        /*指示箭头*/
        .arrow{background-size: 100% 100%;width: 4%;height: 4%;position: relative;min-width: 25px;min-height: 25px;float: left;}
        /*纵向箭头*/
        .arrow2{background-size: 100% 100%;width: 14%;height: 13%;position: relative;min-width: 25px;min-height: 25px;float: left;}
        .arrow3{background-size: 100% 100%;width: 6%;height: 9%;position: relative;min-width: 25px;min-height: 25px;float: left;}
        .arrow4{background-size: 100% 100%;width: 6%;height: 9%;position: relative;min-width: 25px;min-height: 25px;float: left;}
        /*设备图片*/
        .arrow_img{background-size: 100% 100%;width: 8%;height: 8%;position: relative;min-width: 25px;min-height: 25px;float: left;color: #FFFFFF;
            text-align: center;line-height: 1;font-size: 14px;background-color: transparent;border: none;}
        /*流程背景图*/
        .arrow  img,.arrow_img img{width: 100%;height: 100%;;}
        #arrow_img1{ left: 9%;top: 18%;}
        #arrow1{ left: 9%;top: 21%;}
        #arrow21{     left: 23%;top: 28%;}
        #arrow22{ left: 55%;top: 28%;}
        #arrow23{ left: 63%;top: 28%;}
        #arrow31{left: 21%;top: 35%;}
        #arrow32{left: 42%;top: 35%;}
        #arrow_img31{ left: 21%;top: 32%;}
        #arrow_img32{ left: 38%;top: 32%;}
        #arrow_img33{ left: 42%;top: 32%;}
        #arrow41{left: 23%;top: 47%;}
        #arrow42{    left: 42%;top: 47%;}
        #arrow43{     left: 60%;top: 47%;}
        #arrow_img41{     left: 8%;top: 57%;}
        #arrow_img42{     left: 24%;top: 57%;}
        #arrow_img43{ left: 38%;top: 57%;}
        .mj{
            width: 98%;
            height: 90%;
            margin-top: 5%;
        }
        .url{border: none;outline:none;background: transparent;cursor:pointer; }
#fx1{
    width: 18%;
    height: 34%;
    top: 21%;
    left: 21%;
    position: absolute;}
        #fx2{
            width: 17%;
            height: 38%;
            top: 21%;
            left: 49%;
            position: absolute;}
        #tnxlq{
            width: 5%;
            height: 10%;
            top: 23%;
            left: 66%;
            position: absolute;}
        #fx21{
            width: 5%;
            height: 10%;
            top: 47%;
            left: 66%;
            position: absolute;}
        #jbt{
            width: 5%;
            height: 33%;
            top: 21%;
            left: 39%;
            position: absolute;}
        #zmj{
            width: 8%;
            height: 12%;
            top: 73%;
            left: 27%;
            position: absolute;}
        #xlq{
            width: 8%;
            height: 12%;
            top: 73%;
            left: 36%;
            position: absolute;}
        #gfj1{
            width: 7%;
            height: 15%;
            top: 80%;
            left: 48%;
            position: absolute;}
        #gfj2{
            width: 7%;
            height: 15%;
            top: 80%;
            left: 57%;
            position: absolute;}
        #gfj3{
            width: 7%;
            height: 15%;
            top: 79%;
            left: 66%;
            position: absolute;}
    </style>
</head>
<body>

<div id="container">
    <div class="sections">
        <#--第一页-->
        <div class="section">
            <div id="main1">
                <div class="menu">
                    <div class="menuLeft" >
                        <a href="#" onClick="javascript :history.back(-1);">返回</a>
                        <a href = "javascript:choosePath()">返回数据中心</a>
                    </div>
                    <h1 class="title">浮选工序</h1>
                    <div class="menuRight">
                        <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
                        <output class="currentTime"  id="current"></output>
                    </div>
                </div>
                <div class="secondLine" id="alarm1">
                    <#--工段的生产数据-->
                        <div id="firstColumn">
                            <div class="spotstatistics">
                                <h2 class="spotStatistics_title">品位统计</h2>
                                <div class="statistics">
                                    <div id="scdata"></div>
                                </div>
                            </div>
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
                        <div id="secondColumn">

                                <img src="/images/equipment/fx/fxxt.png" class="mj">
                            <a href="/spot/fx/fxj1"><button id="fx1" class="url"></button></a>
                            <a href="/spot/fx/jbt"><button id="jbt" class="url">  </button></a>
                            <a href="/spot/fx/fxj2"><button id="fx2" class="url">  </button></a>
                            <a href="/spot/fx/fxj2"><button id="fx21" class="url">  </button></a>
                            <a href="/spot/fx/xlq"><button id="tnxlq" class="url">  </button></a>
                            <a href="/spot/mk/zmj"><button id="zmj" class="url"></button></a>
                            <a href="/spot/mk/xlq"><button id="xlq" class="url">  </button></a>

                            <a href="/spot/fx/gfj1"><button id="gfj1" class="url">  </button></a>
                            <a href="/spot/fx/gfj2"><button id="gfj2" class="url">  </button></a>
                            <a href="/spot/fx/gfj3"><button id="gfj3" class="url">  </button></a>

                            <#--&lt;#&ndash;搅拌桶&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/jiaobantong.png">粗选搅拌桶</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;粗选&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/fx.png">粗选</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;精扫&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/fx.png">精扫</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;扫选&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/fx.png">扫选</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;  &lt;#&ndash;clear:both;&ndash;&gt;-->
                                 <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;脱泥旋流器&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/shuilixuanliuqi.png">脱泥旋流器</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;硫粗&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img"><img src="/images/equipment/fx/fx.png">硫粗</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow1"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;扫选&ndash;&gt;-->
                                <#--<div id="arrow_img1" class="arrow_img" ><img src="/images/equipment/fx/fuxuanji2.png" >硫精</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow21"  class="arrow"  style="background-image: url('/images/arrow/down1.png') ;clear:both;"></div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow22"  class="arrow"  style="background-image: url('/images/arrow/down1.png');"></div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow23"  class="arrow"  style="background-image: url('/images/arrow/down1.png');"></div>-->
                            <#--&lt;#&ndash;浮选柱&ndash;&gt;-->
                                <#--<div id="arrow_img31" class="arrow_img" style="clear:both;"><img src="/images/equipment/fx/fuxuanji2.png" >浮选柱</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow31"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;铜精矿&ndash;&gt;-->
                                <#--<div id="arrow_img31" class="arrow_img" ><img src="/images/equipment/fx/fuxuanji2.png" >铜精矿</div>-->
                            <#--&lt;#&ndash;尾矿&ndash;&gt;-->
                                <#--<div id="arrow_img32" class="arrow_img" ><img src="/images/equipment/fx/fuxuanji2.png" >尾矿</div>-->
                            <#--&lt;#&ndash;硫扫&ndash;&gt;-->
                                <#--<div id="arrow_img33" class="arrow_img" ><img src="/images/equipment/fx/fuxuanji2.png" >硫扫选</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow32"  class="arrow"  style="background-image: url('/images/arrow/right1.png');"></div>-->
                            <#--&lt;#&ndash;硫尾&ndash;&gt;-->
                                <#--<div id="arrow_img33" class="arrow_img" ><img src="/images/equipment/fx/fuxuanji2.png" >硫尾矿</div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow41"  class="arrow"  style="background-image: url('/images/arrow/up1.png') ;clear:both;"></div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow42"  class="arrow"  style="background-image: url('/images/arrow/up1.png');"></div>-->
                            <#--&lt;#&ndash;箭头&ndash;&gt;-->
                                <#--<div id="arrow43"  class="arrow"  style="background-image: url('/images/arrow/up1.png');"></div>-->
                            <#--&lt;#&ndash;1#鼓风机&ndash;&gt;-->
                                <#--<button id="arrow_img41" class="arrow_img" ><a href="/spot/fx/gfj1"><img src="/images/equipment/fx/gfj.png" ></a> 1#鼓风机</button>-->
                            <#--&lt;#&ndash;2#鼓风机&ndash;&gt;-->
                                <#--<button id="arrow_img42" class="arrow_img" ><a href="/spot/fx/gfj2"><img src="/images/equipment/fx/gfj.png" ></a>2#鼓风机</button>-->
                            <#--&lt;#&ndash;3#鼓风机&ndash;&gt;-->
                                <#--<button id="arrow_img43" class="arrow_img" ><a href="/spot/fx/gfj3"><img src="/images/equipment/fx/gfj.png" ></a>3#鼓风机</button>-->
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
                            <tbody  id="tablebody">
                                <#--<#if spotAlarms??>-->
                                    <#--<#list spotAlarms as home>-->
                                        <#--<tr>-->
                                            <#--<td>${home.section!}</td>-->
                                            <#--<td>${(home.time?datetime)!}</td>-->
                                            <#--<td>${home.equip!}</td>-->
                                            <#--<td>${home.part!}</td>-->
                                            <#--<td>${home.spot!}</td>-->
                                            <#--<td>${home.value!}</td>-->
                                            <#--<td>${home.standard!}</td>-->
                                            <#--<td>${home.level!}</td>-->
                                        <#--</tr>-->
                                    <#--</#list>-->
                                <#--</#if>-->
                            </tbody>
                        </table>

                        <#--<script type="text/javascript">-->
                            <#--$(document).ready(function(){-->
                                <#--$("tr:gt(0) td:last-child").each(function(i,j){-->
                                    <#--if(new Date($(this).text())<new Date('2019-05-29 12:06:55')){-->
                                        <#--$(this).parent().css('color','red');-->
                                    <#--}-->
                                <#--});-->
                            <#--});-->
                        <#--</script>-->
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
<script  src="/js/process/fx1.js"></script>
<script src="/js/utils/choosePath.js"></script>
<script src="/js/utils/alarmTable.js"></script>

</body>
</html>
