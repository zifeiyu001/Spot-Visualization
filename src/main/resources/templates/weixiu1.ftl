<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="/css/css/bootstrap.css">
    <link rel="stylesheet" href="/css/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/css/css/fdphoto.css">
    <link rel="stylesheet" href="/css/mycss/table.css">
    <link rel="stylesheet" href="/css/mycss/top.css">
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/plugins/jedate/jedate.js" charset="utf-8"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/plugins/layer/layer.js" charset="utf-8"></script>
    <script src="/plugins/layui/layui.js" charset="utf-8"></script>
    <script src="/js/bootstrap.js"></script>
    <style>
        #zcCheck,#bjCheck,#wxCheck,#wjCheck{margin-left: 8%;
            margin-right: 2%;}
        #choose input{margin: 0px 0 0 10px};
        .tdWith{width: 16.6% !important}
    </style>
</head>
<body>
<div class="htmleaf-container">
	<!------页面头部---------------------------------------------------------------------------------------------->
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
	<!------页面主体---------------------------------------------------------------------------------------------->
	<div class="mycontainer"> 
	<div class="row">
	    <!----右侧栏目主空间------------------------------------------------------------------------------------------------>
        <div class="col-sm-9" style="margin-left:13%;">
            <!-- 导航区域 -->
	        <nav class="navbar navbar-default">
               <ul class="nav nav-tabs nav-justified">
                   <li class="active"><a href="">申请</a></li>
                   <li ><a href="">接收</a></li>
                   <li ><a href="">查询</a></li>
                    <li><a href="javascript:choosePath()">返回上层</a></li>
                </ul>
            </nav><!-- /导航区域 -->
			<hr/>
			<!-- 主空间 -->
			<div class="col-sm-12">-->
<div class="form-group" style="margin-top:1%;">
	<table id="groupTable" class="table table-striped table-bordered table-hover">
		<tbody id="groupTable-tbody" align="center" class="tbody">
			    <tr>

                    <td style="width: 16.6%" ">工段</td>
                    <td style="width: 16.6%"><select class="form-control" id="workshop" name="bm" style = "width:100%" onclick="getRouteName()">
                        </select> </td>
                    <td style="width: 16.6%">线路</td>
                    <td style="width: 16.6%"> <select class="form-control" id="route" name="lx" style = "width:100%" onclick="getZoneName()">
                        </select></td>
                    <td style="width: 16.6%">区域</td>
                    <td style="width: 17%"> <select class="form-control" id="zone" name="lx" style = "width:100%" onclick="getDevName()">
                        </select></td>
                </tr>
                <tr>
                    <td>设备</td>
                    <td> <select class="form-control" id="equip" name="lx" style = "width:100%" >
                        </select></td>
                    <td>发现人</td>
                    <td><input class="form-control"></td>
                    <td>联系方式</td>
                    <td >
                        <input class="form-control" type="text" name="case2007" id="case2007"/>
                    </td>

                </tr>

                <tr>
                    <td colspan="3" style="text-align: left">故障内容<textarea rows="15" cols="80" style="resize: none;"></textarea></td>
                    <td colspan="2" rowspan="8">
                        <div class="col-sm-9 big-photo"  style="width: 90%;">

                            <div id="preview" >
                                <img id="imghead"   src="/images/module/addPic.png" border="0" width="90" height="90" onclick="$('#previewImg').click();">
                            </div>
                            <input type="file" onchange="previewImage(this)" accept=" image/jpeg, image/png" style="display: none;" id="previewImg">
                        </div>
                    </td>
                    <td><input  type="button"  class="btn btn-primary"  value="上传"> </td>

                </tr>

		</tbody>
	</table>
</div>
<script type="text/javascript">
    function ccc(){

        var value = document.getElementById('picPath').value;
        $('#picShow').css("background-image", "url("+value+")");
        alert(value)
    }

</script>

<!----/主空间显示区域----------------------------------------------------------------------------------------------------------------->			
			</div><!-- /主空间 -->
        </div><!----/右侧栏目主空间------------------------------------------------------------------------------------------------>    
	</div></div><!------/页面主体---------------------------------------------------------------------------------------------->
</div>
<script type="text/javascript" src="/js/searchEquip.js"></script>
<script type="text/javascript" src="/js/picShow.js"></script>

</body>
</html>