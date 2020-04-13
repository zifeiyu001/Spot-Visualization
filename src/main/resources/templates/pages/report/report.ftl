<!DOCTYPE html>
<#--判断用户是否登录-->
<#if !Session.username??>
    <script>
        alert("账号未登陆，请登录...");
        window.location.href='http://172.16.5.4/bkzyCMS/login';
    </script>
</#if>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a id="dlink"  style="display:none;"></a>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css"  media="all">
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <#--<script src="https://cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js"></script>-->
    <script src="/plugins/layer/layer.js" charset="utf-8"></script>
    <script src="/plugins/layui/layui.js" charset="utf-8"></script>
    <#--<script src="/js/toExcel.js"></script>-->
    <title>报表</title>
    <style>

        body{width: auto;height: 100%;margin: 0;padding: 0;}
        /* 设置滚动条的样式 ---纵向,横向*/
        body::-webkit-scrollbar {    width: 0.01px; height: 0.01px ;overflow-y: auto; overflow-x:hidden;}
        html{height: 100%;}
        /*返回*/
        .return{    margin: 1% auto auto 1%;}
        /*工段选择*/
        .select-all{width: 80%;height: 10%;   margin-left: 12%;    margin-top: 1%;}
        #select,.select{margin-right: 3%;float: left;    margin-top: 14px;}
        .select-name{float: left;}

        /*日期选择*/
        .layui-form{float: left;margin-top: 6px}

        /*查询*/
        .query{float: left;margin-top:9px;margin-left:9px}
        .queryButton{width: 50px;height: 30px;border-radius: 5%;border: none;background-color: #52dada; }
        .query1{float: left;margin-top:9px}
        .queryButton1{width: 50px;height: 30px;border-radius: 5%;border: none;background-color: #52dada; }

        /*导出按钮*/
        .download{width: 70px;height: 30px;border-radius: 5%;border: none;margin-left: 10px;margin-top: 8px;background-color: #52dada;}

        /*选择框样式*/
        #select .sty1,select.sty1 {
            /*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
            border: solid 1px #000;
            height: 100%;
            border-radius: 5%;
            width: 90px;
            /*很关键：将默认的select选择框样式清除*/
            appearance:none;
            -moz-appearance:none;
            -webkit-appearance:none;

            /*在选择框的最右侧中间显示小箭头图片*/
            background: url("http://ourjs.github.io/static/2015/arrow.png") no-repeat scroll right center transparent;

            /*为下拉小箭头留出一点位置，避免被文字覆盖*/
            padding-right: 14px;
        }
        /*清除ie的默认选择框样式清除，隐藏下拉箭头*/
        #select .sty1,select.sty1::-ms-expand { display: none; }

        #tables  td,#tables  th{padding:0.3%;min-height:10px}

        #tables{height: 100%;width: 100%;    }

    </style>

</head>
<body>
    <div class="return"><a href="#" onClick="javascript :history.back(-1);">返回上一页</a> </div>
    <div class="select-all"  id="table_wrapper">
        <div class="select">
            <span class="select-name">工段：</span>
            <select id="workshop" class="sty1" name="workshop_name">
                <option value="">-请选择-</option><!--先创建三个下拉栏，分别对应 省 市 县-->
            </select>
        </div>
        <div class="select">
            <span class="select-name">班组：</span>
            <select id="team" class="sty1" name="team_name" onclick="chooseSC()">
                <option value="" >-请选择-</option>
            </select>
        </div>
        <div class="select">
            <span class="select-name">设备/岗位：</span>
            <select id="equip" class="sty1" name="equip_name" >
                <option value="" >-请选择-</option>
            </select>
        </div>
        <div id="select" style="display: none">
            <span class="select-name">班次：</span>
            <select id="duty" class="sty1" name="duty_name">
                <option value="" >-请选择-</option>
                <option value="" >白班</option>
                <option value="" >夜班</option>
            </select>
        </div>
        <#--&lt;#&ndash;时间选择&ndash;&gt;-->
        <div class="layui-form">
            <#--<div class="layui-form-item">-->
            <div class="layui-inline">
                <label class="layui-form-label">选择日期</label>
                <div class="layui-input-inline" style="z-index: 9999">
                    <input type="text" autocomplete="off" class="layui-input" id="test">
                </div>
                <#--</div>-->
            </div>
        </div>
        <div class="query">
            <button class="queryButton"  onclick="search()" >查询</button>
        </div>
        <input type="button" class="download" value="导出报表" onclick="method1('tables')" />
    </div>
    <div class="report" id="sbReport"  style="    margin-left: 10%;margin-right: 10%;" >

            <table class="table tableStyles" id="tables" style="  border: 2px solid !important;">

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
    <#---->
    <div style="height: 10%;min-height: 20px"></div>


<script src="/js/report/reportDownload.js"></script>
<script src="/js/report/chooseEquip.js"></script>
<script src="/js/report/getChooseData.js"></script>
<script src="/js/report/getReportData.js"></script>
</body>
</html>