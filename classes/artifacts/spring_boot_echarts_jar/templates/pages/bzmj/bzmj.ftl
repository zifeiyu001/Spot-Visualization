<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>demo</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <script type="text/css"></script>


    <style>
/*背景*/
        #body{
            background-image: url("images/background.jpg");
            /*background-repeat: repeat-x;background-repeat: repeat-y;*/
            /*-moz-background-size:100% 100%;background-size:100% 100%;*/
            background-size: cover;
            background-attachment: fixed;
            width: Auto;
            height: Auto;
            /*background-color: #460bff;*/
            /*background-repeat: no-repeat;*/
        }
/*标题*/
        #title{
            margin: 0px Auto;
            color: white;
            font-family: 微软雅黑;
            font-size: 24px;
            text-align: center;
        }
/*首行界面*/
        #one{
            width:100%;height:550px;
            /*background: #9a1a07;*/
            box-shadow: 0px 0px 1px #2aff33;
            display: inline-block;

        }
/*报警盒子*/
        #alarm{
            width:24%;height:550px;
            /*background: #028a9a;*/
            box-shadow: 0px 0px 1px #2aff33;
            float:left;
            margin: 0px 1px;
            display: inline-block;
            z-index:1;
            position: relative;
        }
        /*表格边框*/
            table.com {
                width: auto;
                height: auto;
                font-size:14px;
                text-align: center;
                border-spacing: 0px;
                border-right:1px solid #aaa;
                border-bottom:1px solid #aaa;
                position: relative;
                margin: 10px auto;
            }
            /*单元格*/
            table.com td {
                border-left:1px solid #aaa;
                border-top:1px solid #aaa;
                padding:10px;
                color: #2aff33;
            }
            /*表格首行*/
            table.com thead tr {
                background: #339;
                color: #fff;
            }
            /*隔行颜色*/
            table.com tbody tr:nth-child(even) {
                background: #3bee29;
            }
            /*表格鼠标移动变色*/
            /*table.mt tbody tr:hover {*/
                /*background: #ccc;*/
                /*color: #fff;*/
            /*}*/

/*主图*/
        #show{
            display: inline-block;
            width:50%;height:550px;
            margin: 0px 1px;
            /*background: #028a9a;*/
            /*margin-left: 26%;*/
            box-shadow: 0px 0px 1px #2aff33;
            /*position: absolute;*/
            position: relative;
            z-index:2;
        }
            .pic{
            margin: 80px 10px;
        }
/*生产数据以及图例模块*/
        #productionanddemo{
            display: inline-block;
            width: 25%;
            height: 550px;
            float: right;
            margin: 0px 1px;
            /*background: #028a9a;*/
            box-shadow: 0px 0px 1px #2aff33;
            /*margin-left: 76px;*/
            position: relative;
            z-index: 3;
        }
        /*生产数据图表*/
        #scsk {
            width: 100%;
            height: 250px;
            margin: 2px;
        }
        /*图例*/
        #legend-mf{
            width: 98%;
            height: 150px;
            margin: 0px auto;
        }
        #legend-dy{
            width: 98%;
            height: 150px;
            margin: 0px auto;
            bu
        }
/*详细数据*/
        #detaileddata{
            margin: 10px 0px;
            width:100%;height:180px;
            /*background: #0abeff;*/
            box-shadow: 0px 0px 1px #2aff33;
                }
        #tabletitle{
            color: white;
            font-size: 20px;
            margin-top: 2px;

        }
        table.detailetable {
            width: 100%;
            height: auto;
            font-size:14px;
            text-align: center;
            border-spacing: 0px;
            border-right:1px solid #aaa;
            border-bottom:1px solid #aaa;
            position: relative;
            margin: 10px 0px;
        }
        /*单元格*/
        table.detailetable td {
            border-left:1px solid #aaa;
            border-top:1px solid #aaa;
            padding:10px;
            color: #fdff13;
        }
        /*表格首行*/
        table.detailetable thead tr {
            background: #339;
            color: #fff;
        }
        /*隔行颜色*/
        table.detailetable tbody tr:nth-child(even) {
            background: #3bee29;
        }

    </style>
</head>
<body id="body">
    <div id="title">半自磨机</div>
    <div id="one">
        <#--报警盒子-->
        <div id="alarm">
            <table class="com">
                <caption id="tabletitle">报警数据</caption>
                <thead>
                    <tr>
                        <td>序号</td>
                        <td>工段</td>
                        <td>名称</td>
                        <td>内容</td>
                        <td>级别</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <#--主图盒子-->
        <div id="show" >
            <div class="pic" >
                <img src="images/GrindingMachine.png" width="98%" height="100%" >
            </div>
        </div>
        <#--生产数据及图例盒子-->
        <div id="productionanddemo">
            <div id="scsk"></div>
            <div id="legend-mf">
                <table class="com">
                    <caption id="tabletitle">磨浮工段</caption>
                    <thead>
                        <tr>
                            <td>①</td>
                            <td>②</td>
                            <td>③</td>
                            <td>④</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>温度</td>
                            <td>温度</td>
                            <td>振动</td>
                            <td>筒体</td>
                            <td>进料端</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="legend-dy">
                <table class="com">
                    <caption id="tabletitle">电仪工段</caption>
                    <thead>
                    <tr>
                        <td>①</td>
                        <td>②</td>
                        <td>③</td>
                        <td>④</td>
                        <td>⑤</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>油位</td>
                        <td>滑环</td>
                        <td>外观</td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <#--详细数据-->
    <div id="detaileddata">
        <<table class="detailetable">
            <caption id="tabletitle">详细数据</caption>
            <thead>
            <tr>
                <td></td>
                <td>②</td>
                <td>③</td>
                <td>④</td>
                <td>⑤</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>磨浮工段</td>
                <td>2</td>
                <td>3</td>
                <td>1</td>
                <td>3</td>
            </tr>
            <tr>
                <td>电仪工段</td>
                <td>${productionMF!}</td>
                <td>正常</td>
                <td>正常</td>
                <td>正常</td>

            </tr>

            </tbody>
        </table>
    </div>
</body>
    <script  src="/js/ProductionSK.js"></script>
</html>