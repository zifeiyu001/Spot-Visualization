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
    <title>颚式破碎机</title>
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <link href="/css/equipPage.css" rel="stylesheet" type="text/css" />
    <script type="text/css"></script>
    <style>
    #btn1{width: 8%;height: 14%;left: 30%;top: 69%;}
    #btn2{width: 24%;height: 34%;left: 29%;top: 35%;}
    #btn2-1{width: 15%;height: 14%;left: 38%;top: 69%;}
    #btn3{width: 6%;height: 12%;left: 55%;top: 48%;}
    #btn4{width: 2%;height: 12%;left: 61%;top: 48%;}
    #btn5{width: 2%;height: 12%;left: 63%;top: 48%;}
    #btn6{width: 13%;height: 16%;left: 54%;top: 60%;}
    /*设备图*/
    #pic1{width: 60%;height: 52%;left: 5%;}
    #pic2{width: 30%;height: 40%;left: 4%;top: 40%;}

    </style>
</head>
<body >
<#--点检数据弹窗-->
        <a id="btn1" class="spotButton" onclick="getDetailedData1('param1');"   ></a>
        <a id="btn2" class="spotButton" onclick="getDetailedData1('param2');"   ></a>
        <a id="btn2-1" class="spotButton" onclick="getDetailedData1('param2');"   ></a>
        <a id="btn3" class="spotButton" onclick="getDetailedData1('param3');"   ></a>
        <a id="btn4" class="spotButton" onclick="getDetailedData1('param4');"   ></a>
        <a id="btn5" class="spotButton" onclick="getDetailedData1('param5');"   ></a>
        <a id="btn6" class="spotButton" onclick="getDetailedData1('param6');"   ></a>

<#--导航栏-->
    <div class="menu">
    <#--返回按钮-->
        <div class="menuLeft" >
            <a href="#" onClick="javascript :history.back(-1);">返回</a>
            <a href="/spot" style=" padding: -1px;" >返回首页</a>
            <a href = "javascript:choosePath()">返回数据中心</a>
        </div>
    <#--标题-->
        <h1 class="title">颚式破碎机</h1>
    <#--当前时间-->
        <div class="menuRight">
            <script src="/js/utils/currentDateTime/currentDateTime2.js"> </script>
            <output class="currentTime"  id="current"></output>
        </div>
    </div>
    <div class="main" id="alarm1">
    <#--表格数据-->
        <div class="echartsData"  id="alarm2">
            <div class="spotstatistics" id="alarm3">
                <h2 class="spotStatistics_title">点检统计</h2>
                <div class="statistics" id="spotdata">
                </div>
            </div>
            <div class="alarm">
                <div class="tabletitle"  id="alarm2">报警数据</div>
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
 <#--主图-->
        <div class="show" >
            <div id="pic1" class="pic"><img src="/images/equipment/sk/ep.png"></div>
            <div id="pic2" class="pic"><img src="/images/equipment/sk/xyz.png"></div>
        </div>
        <div class="spot">
            <div class="tabletitle">点检详情</div>
            <div class="spotbody" >
                <table class="myTable">
                    <thead>
                    <tr class="tablehead">
                        <td style="width: 10%" onclick="kw.tabSort('tab',0)">专业</td>
                        <td style="width: 32%" onclick="kw.tabSort('tab',1)">部位</td>
                        <td style="width: 32%" onclick="kw.tabSort('tab',2)">内容</td>
                        <td style="width: 14%" onclick="kw.tabSort('tab',3)">结果</td>
                        <td style="width: 15%" onclick="kw.tabSort('tab',4)">报警</td>
                    </tr>
                    </thead>
                    <tbody id="spotbody">
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<script  src="/js/equipment/SpotSKEP.js"></script>
<script  src="/js/equipment/SpotEquip.js"></script>
<script src="/js/utils/choosePath.js"></script>


</body>
</html>