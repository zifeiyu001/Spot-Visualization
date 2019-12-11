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
    <title>碎矿工序</title>
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
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
        #firstColumn{width: 24%;height: 100%;min-width: 250px;min-height: 400px;display: inline-block;position: relative;float: left;}
        /*生产/点检数据*/
        #scdata ,#djdata,#qxcl{height: 98% !important;width: 98% !important;}
        .spotstatistics {width: 100%;height: 50%;min-height: 200px;min-width: 200px;margin: 2px;background-size: 100% 100%;background-image: url("/images/module/aleftboxtbott.png");}
        .spotStatistics_title{text-align: center ;color: #FFFFFF;padding-top: 3%;height: 8%;font-size: 12px;}
        .statistics{width: 100%;height: 91%;}

        /*图形区*/
        #secondColumn{float: left;width:72%;height:40%;min-width: 400px;margin: 0 0.5%;background-size: 100% 100%;
            background-repeat: no-repeat;border-radius: 1%;background-image: url("/images/module/amiddboxttop.png");}

        /*报警区域*/
        .thirdColumn{
            width: 73%;height: 61%;min-width: 200px;overflow-y: hidden;float: left;
            border-radius: 1%;background-image: url("/images/module/arightboxtop.png");background-size: 100% 100%;}


        /* 设置滚动条的样式 ---纵向,横向*/
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px}
        /*滚动条整体样式*/
        .alarmbody .myTable tbody::-webkit-scrollbar {width: 1%;height: 4px;scrollbar-arrow-color:red;}
        /*滚动条里面小方块*/
        .alarmbody .myTable tbody::-webkit-scrollbar-thumb {border-radius: 5px;-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);background: rgba(46, 21, 255, 0.87);scrollbar-arrow-color:red;}
        /*滚动条里面轨道*/
        .alarmbody .myTable tbody::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);border-radius: 0;background: #192683;}

        /*报警表格字体*/
        .myTable tbody td{font-size: 14px}
        .myTable thead td{font-size: 16px}

        /*报警表格标题*/
        .tableTitle{z-index: -2;color: white;font-size: 14px;text-align: center;}

        .alarmbody .myTable tbody {display:block;overflow-y:scroll;position: relative;}
        /*#tablebody{height: 80%;}*/
        .alarmbody .myTable thead, tbody tr {display:table;width:100%;table-layout:fixed;}
        .alarmbody .myTable thead {width: calc( 100% - 0.6em )}
        .alarmbody .myTable thead td{ background: #dfdee600;font-size: 14px;}

        /*设备图片*/
        .chartPic{background-size: 100% 100%;width: 14%;height: 42%;position: relative;min-width: 25px;min-height: 25px;
            float: left;color: #FFFFFF;text-align: center;line-height: 1;font-size: 14px;}
        .chartPic img{width: 100%;height: 100%;;}

        .direction{width: 4%;height: 8%;margin-left: 4%;margin-right: 4%;float: left;position: relative;background-size: 100% 100%;color: #FFFFFF;}
        #zhongban,#epo,#pidai2,#pidai4{left: 3%;top: 24%;}
        #right{left:3%;top: 42%;}

        .myTable{
            width: 96%;
            /*height: 94%;*/
            height: auto;
            font-size:14px;
            text-align: center;
            color: #FFFFFF;
            border-spacing: 0;
            /*border-right:1px solid #aaa;*/
            /*border-bottom:1px solid #aaa;*/
            position: relative;
            margin: 1% 0 0 2%;
        }
        .myTable tbody td {
            border-left:1px solid #aaa;
            /*border-top:1px solid #aaa;*/
            border-right:1px solid #aaa;
            border-bottom:2px solid #aaa;
            /*color: #fdff13;*/
            padding:0.3%;
            font-size: 14px;
        }
        .myTable thead td {
            border-left:1px solid #aaa;
            border-top:1px solid #aaa;
            border-right:1px solid #aaa;
            border-bottom:1px solid #aaa;
            /*color: #fdff13;*/
            padding: 0;
            font-size: 12px;
        }
        /*表格首行*/
        .myTable thead tr {
            /*background: #339;*/
            color: #fff;
        }
        .myTable .caption{color: white;font-size: 16px;margin: 1%;overflow: hidden;}
        .myTable button{    background-color: #33bd45;border-radius: 21%;width: 29%;box-shadow: 2px 2px 2px 2px #00bcd491;}
        .alarm3 td{width: 14% !important;}

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
                    <h1 class="title">碎矿工序</h1>
                    <div class="menuRight">
                        <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
                        <output class="currentTime"  id="current"></output>
                    </div>
                </div>
                <div class="secondLine" id="alarm1">
                    <#--工段的生产数据-->
                        <div id="firstColumn">
                            <#--<div class="spotstatistics">-->
                                <#--<h2 class="spotStatistics_title">数据统计</h2>-->
                                <#--<div class="statistics">-->
                                    <#--<div id="scdata"></div>-->
                                <#--</div>-->
                            <#--</div>-->
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
                                </tbody>
                            </table>
                        </div>
                    </div>
                        <div id="secondColumn">
                            <div id="zhongban" class="chartPic"><a href="/spot/sk/zb"><img src="/images/equipment/sk/zhongban2.png"></a>重板</div>
                            <div id="right" class="direction" style="background-image: url('/images/arrow/jt.png')"></div>
                            <div id="epo" class="chartPic"><a href="/spot/sk/ep"><img src="/images/equipment/sk/espsj.png"></a>颚式破碎机</div>
                            <div id="right" class="direction" style="background-image: url('/images/arrow/jt.png')"></div>
                            <div id="pidai2" class="chartPic"><a href="/spot/sk/pd2"><img src="/images/equipment/sk/pidai.png"></a>2#皮带</div>
                            <div id="right" class="direction" style="background-image: url('/images/arrow/jt.png')"></div>
                            <div id="pidai4" class="chartPic"><a href="/spot/sk/pd4"><img src="/images/equipment/sk/pidai.png"></a>4#皮带</div>
                        </div>

                </div>
            </div>
            </div>
    </div>
</div>


<script  src="/js/process/sk1.js"></script>
<script src="/js/utils/choosePath.js"></script>

</body>
</html>
