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
    <title>无刮板浮选机</title>
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/echarts.min.js"></script>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="/css/table.css" rel="stylesheet" type="text/css" />
    <link href="/css/equipPage.css" rel="stylesheet" type="text/css" />
    <script type="text/css"></script>
    <style>
    #btn1{width: 18%;height: 19%;left: 36%;top: 32%;}
    #btn2{width: 24%;height: 31%;left: 30%;top: 51%;}
    #btn2-1{width: 10%;height: 37%;left: 54%;top: 39%;}
    /*设备图*/
    #pic1{width: 80%;height: 60%;top: 24%;left: 10%;}
    /*设备选择框*/
    #chooseEquip{    margin-top: 8%;background-color: blue;color: white;border-radius: 3%;}
    </style>
</head>
<body >
<#--点检数据弹窗-->
        <a id="btn1" class="spotButton" onclick="getDetailedData1('param1');"   ></a>
        <a id="btn2" class="spotButton" onclick="getDetailedData1('param2');"   ></a>
        <a id="btn2-1" class="spotButton" onclick="getDetailedData1('param2');"   ></a>
<#--导航栏-->
    <div class="menu">
    <#--返回按钮-->
        <div class="menuLeft" >
            <a href="#" onClick="javascript :history.back(-1);">返回</a>
            <a href="/spot" style=" padding: -1px;" >返回首页</a>
            <a href = "javascript:choosePath()">返回数据中心</a>
        </div>
    <#--标题-->
        <h1 class="title">无刮板浮选机</h1>
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
            <div id="pic1" class="pic"><img src="/images/equipment/fx/fxj1.png"></div>
                <select id="chooseEquip" class="selectData" onclick="getAlarmData();echartsData();getDetailedData1('param1')">
                    <option value="1#">1#浮选机</option>
                    <option value="2#">2#浮选机</option>
                    <option value="3#">3#浮选机</option>
                    <option value="4#">4#浮选机</option>
                    <option value="5#">5#浮选机</option>
                    <option value="6#">6#浮选机</option>
                    <option value="7#">7#浮选机</option>
                    <option value="8#">8#浮选机</option>
                    <option value="9#">9#浮选机</option>
                    <option value="10#">10#浮选机</option>
                    <option value="11#">11#浮选机</option>
                    <option value="12#">12#浮选机</option>
                    <option value="13#">13#浮选机</option>
                    <option value="14#">14#浮选机</option>
                    <option value="15#">15#浮选机</option>
                    <option value="16#">16#浮选机</option>
                    <option value="17#">17#浮选机</option>
                    <option value="18#">18#浮选机</option>
                    <option value="19#">19#浮选机</option>
                    <option value="20#">20#浮选机</option>
                    <option value="21#">21#浮选机</option>
                    <option value="22#">22#浮选机</option>
                    <option value="23#">23#浮选机</option>
                    <option value="24#">24#浮选机</option>
                </select>
        </div>
        <div class="spot">
            <div class="tabletitle" >点检详情</div>
            <div class="spotbody" >
                <table class="myTable" >
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
<script>
    getDetailedData1('param1');


    function getDetailedData1(param) {
        var equip=$("#chooseEquip option:selected" ).val();
        $.ajax({
            url:"/spot/fx/fxj1/detailed/test",
            type:"post",
            // cache:false,
            // async: false,
            contentType: "application/json",
            data:JSON.stringify({"param":param,"equip":equip}),
            dataType:"json",
            beforeSend: function() {
                isLoaded3= false;
            },
            success: function (result) {
                var  json=result.data;
                $("#spotbody").html("");
                var s='';
                // alert(json.length)
                for (var i = 0; i < json.length; i++) {

                    s += '<tr><td style="width: 10%">' +
                        json[i].section + '</td><td style="width: 32%">'
                        + json[i].part + '</td><td style="width: 32%;">'
                        + json[i].content + '</td><td style="width: 14%">'
                        + json[i].result + '</td>';
                    if (json[i].level == "0") {
                        // alert("1=========="+i);
                        s += '<td style="width: 14%;">正常 </td></tr>';
                    } else if (json[i].level == "1") {
                        // alert("2========"+i);
                        s += '<td style="width: 14%">报警</td></tr>';
                    } else if (json[i].level == "2") {
                        // alert("3========="+i);
                        s += '<td style="width: 14%">危险</td></tr>';
                    } else {
                        // alert("4========="+i);
                        s += '<td style="width: 14%">-</td></tr>';
                    }
                }   $('#spotbody').append(s);
            },
            complete: function() {
                isLoaded3 = true; }
        })
    }
</script>
<script  src="/js/equipment/SpotFXFxj.js"></script>
<script  src="/js/equipment/SpotEquip.js"></script>
<script src="/js/utils/choosePath.js"></script>


</body>
</html>