<!DOCTYPE html>
<#--判断用户是否登录-->
<#--<#if !Session.username??>-->
    <#--<script>-->
        <#--alert("账号未登陆，请登录...");-->
        <#--window.location.href='http://172.16.5.4/bkzyCMS/login';-->
    <#--</script>-->
<#--</#if>-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a id="dlink"  style="display:none;"></a>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="/css/css/bootstrap.css">
    <link rel="stylesheet" href="/css/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/css/css/fdphoto.css">
    <link rel="stylesheet" href="/css/mycss/table.css">
    <link rel="stylesheet" href="/css/mycss/top.css">
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/plugins/jedate/jedate.js" charset="utf-8"></script>
    <#--<script src="https://cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js"></script>-->
    <script src="/plugins/layer/layer.js" charset="utf-8"></script>
    <#--<script src="/plugins/layui/layui.js" charset="utf-8"></script>-->
    <#--<script src="/js/toExcel.js"></script>-->
    <title>日报表</title>
    <style>

        body{width: auto;height: 100%;margin: 0;padding: 0;}
        /* 设置滚动条的样式 ---纵向,横向*/
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px ;overflow-y: auto; overflow-x:hidden;}
        html{height: 100%;}

        /*查询*/
        .query{float: left;margin-left: 4%;}

        #tables  td,#tables  th{padding:0.3%;min-height:10px}

        #tables{height: 100%;width: 100%;    }

    </style>

</head>
<body>
<div class="htmleaf-container" style="height: 100%;overflow: auto">
    <header class="htmleaf-header bgcolor-12">
        <!-- h1>城门山铜矿数据中心<span>Bootstrap Tree View</span></h1 -->
        <!-- 网页头部画面 -->
        <div id="header" class="container">
            <div id="logo" class="col-md-2">
                <img src = "/images/jxty.jpg" >
            </div>
            <div id="mytitle" class="col-md-8">
                城门山铜矿数据中心<br/>
            </div>
            <div id="blankarea" class="col-md-2">
                <br/>
            </div>
        </div>
    </header>
    <div class="mycontainer">
    <div class="row">
        <!----右侧栏目主空间------------------------------------------------------------------------------------------------>
        <div class="col-sm-9" style="margin-left:13%;">
            <!-- 导航区域 -->
            <nav class="navbar navbar-default">
                <ul class="nav nav-tabs nav-justified">
                    <li class="active"><a href="#" >日报表</a></li>
                    <#--<li><a href="/bkzyCMS/index">返回上层</a></li>-->
                    <li><a href="#" onClick="javascript :history.back(-1);">返回上层</a></li>
                </ul>
            </nav><!-- /导航区域 -->
            <hr/>

    <div class="col-sm-12">
        <form action="#" onsubmit="return false;" id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">
            <div class="form-group" id="datet" style = "width:auto;margin-left:5%">
                <label for="name" class="col-sm-2 control-label" style = "width:auto" >选择工段</label>
                    <div class="col-md-4" style = "width:20%">
                        <select class="form-control" id="workshop" name="workshop_name" style = "width:100%" ">
                        <option value="" >-请选择-</option>
                        </select>
                    </div>
                <label for="name" class="col-sm-2 control-label" style = "width:auto"  >选择班组</label>
                    <div class="col-md-4" style="width: 20%">
                        <select class="form-control" id="team"  name="team_name" ">
                            <option value="" >-请选择-</option>
                        </select>
                    </div>
                <label for="name" class="col-sm-2 control-label" style = "width:auto" >选择设备/岗位</label>
                <div class="col-md-4" style="width: 20%">
                    <select class="form-control" id="equip"  name="equip_name" ">
                        <option value="" >-请选择-</option>
                    </select>
                </div>

            </div>
            <div class="form-group" id="datet" style = "width:auto;margin-left:5%">
                <label for="name" class="col-sm-2 control-label" style = "width:auto">选择值次</label>
                <div class="col-md-4" style = "width:20%">
                <select class="form-control" id="duty" name="duty_name">
                    <option value="" >-请选择-</option>
                    <option value="" >白班</option>
                    <option value="" >夜班</option>
                </select>
                </div>
                <label for="name" class="col-sm-2 control-label" style = "width:auto">日期选择</label>
                <div class="col-md-4" style = "width:20%">
                    <input class="form-control" id="dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                </div>
                <div class="query">
                    <input type="button" class="btn btn-primary"  onclick="search()"  value="查询">
                </div>
                <input type="button" style="margin-left: 5%;" class="btn btn-primary" value="导出报表" onclick="method1('tables')" />
            </div>
        </form>
    </div>

    </div>
    </div>
    </div>
    <div class="form-group" id="sbReport"  style="    margin-left: 10%;margin-right: 10%;" >
        <table class="table tableStyles" id="tables" >

            <thead class="equipParam">
            <tr>
                <th colspan="10" id="titleName" style="font-size: 18px !important;border: 1px solid ;font-size: 16px">设备日报表</th>
            </tr>
            <tr id="biaoti">
            </tr>
            </thead>
            <tbody class="spot">
            <tr>
                <th colspan="10"  style="background-color: #3ab8ee;border: 1px solid ;font-size: 16px">点检统计</th>
            </tr>
            <tr>
                <th colspan="2" rowspan="2"  style="background-color: lightcyan ;border: 1px solid;width: 20%;">总计</th>
                <th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">未检</th>
                <th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">正常</th>
                <th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">报警</th>
                <th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">危险</th>
            </tr>
            <tr >
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">数量</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">比例（%）</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">数量</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">比例（%）</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">数量</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">比例（%）</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">数量</th>
                <th   style="background-color: lightcyan ;border: 1px solid ;width: 10%;">比例（%）</th>
            </tr>

            </tbody>
            <tbody id="run">
            <tr>
                <th colspan="10"  style="background-color: #3ab8ee;border: 1px solid ;font-size: 16px">设备运行情况</th>
            </tr>
            </tbody >
            <tbody  id="fault">
            <tr>
                <th colspan="10"  style="background-color: #3ab8ee;border: 1px solid ;font-size: 16px">设备故障处理</th>
            </tr>
            <tr >
                <th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">序号</th>
                <th colspan="3"  style="background-color: lightcyan ;border: 1px solid ;">故障内容</th>
                <th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">检查时间</th>
                <th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">是否处理</th>
                <th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">处理结果</th>
                <th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">处理人</th>
                <th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">处理时间</th>
            </tr>

            </tbody>

            <tfoot class="conclusion">
            <tr style="text-align: center" id="footTable">

            </tr>
            </tfoot>
        </table>
    </div>
</div>
<script src="/js/report/reportDownload.js"></script>
<script src="/js/report/chooseEquip.js"></script>
<script src="/js/report/getReportData1.js"></script>

</body>
</html>