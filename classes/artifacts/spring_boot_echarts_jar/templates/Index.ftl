<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>demo</title>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="/js/echarts.min.js"></script>
    <script type="text/css"></script>

    <!--设置背景色-->
    <style>
        body{
            background-image: url("images/background.jpg");
            background-size: cover;
            background-attachment: fixed;
            width: Auto;
            height: Auto;
        }
        #title{
            color: blue;margin: 0px Auto;
            color: white;
            font-family: 微软雅黑;
            font-size: 24px;
            text-align: center;
        }
        #one{
            width: 8%;
            height: 250px;
            position: relative;
            float: left;
            color: blue;margin: auto;
            color: white;
            font-family: 微软雅黑;
            font-size: 24px;
            text-align: center;
            top: 100px;
        }
        #scsk {
            display: inline-block;
            width: 22%;
            height: 250px;
        }
        #scmf {
            display: inline-block;
            width: 22%;
            height: 250px;
        }


    </style>
</head>
<body class="body">
    <div id="title">设备管理控界面</div>
    <div id="choosememu">
        <div id="bzmj">
            <a href="/bzmj" >
                <button>磨浮工段</button>
            </a>
        </div>
    </div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="one">生产数据 </div>
    <div id="scsk"></div>
    <div id="scmf"></div>
    <div id="scdy"></div>
    <div id="scjw"></div>
</body>
    <script  src="/js/ProductionSK.js" ></script>
    <script  src="/js/ProductionMF.js" ></script>
    <script  src="/js/ProductionJW.js" ></script>
    <script  src="/js/ProductionDY.js" ></script>

</html>