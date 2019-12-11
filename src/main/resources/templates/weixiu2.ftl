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
                   <li ><a href="weixiu">申请</a></li>
                   <li class="active"><a href="">查询</a></li>
                    <li><a href="javascript:choosePath()">返回上层</a></li>
                </ul>
            </nav><!-- /导航区域 -->
			<hr/>
			<!-- 主空间 -->
			<div class="col-sm-12">
<!----主空间显示区域----------------------------------------------------------------------------------------------------------------->			
<form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">

	<div class="form-group" id="datet" style = "width:auto;margin-left:5%">
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择工段</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="workshop" name="bm" style = "width:100%" onclick="getRouteName()">
			</select>
		</div>
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto"  >选择路线</label>
        <div class="col-md-4" style = "width:20%">
            <select class="form-control" id="route" name="lx" style = "width:100%" onclick="getZoneName()">
            </select>
        </div>
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择所属区域</label>
        <div class="col-md-4" style = "width:20%">
            <select class="form-control" id="zone" name="qy" style = "width:100%" onclick="getDevName()">
            </select>
        </div>
	</div>
	<div class="form-group" style = "width:auto;margin-left:5%;">

		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择设备</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="equip" name="gnwz" style = "width:100%" onclick="getPartName()">
			</select>
		</div>
        <label for="name" class="checkbox-inline"></label>

        <label for="name" class="col-sm-2 control-label" style = "width:auto;">开始时间</label>
        <div class="col-md-4" style = "width:20%">
            <input class="form-control" id="dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
        </div>
        <label for="name" class="col-sm-2 control-label" style = "width:auto">结束时间</label>
        <div class="col-md-4" style = "width:20%">
            <input class="form-control" id="dateEnd" name="dateEnd" type="text" placeholder="请选择" readonly style = "width:auto">
        </div>
	</div>
    <div class="form-group" style = "width:auto;margin-left:5%;">
        <label for="name" class="col-sm-2 control-label" style = "width:auto">是否处理</label>
        <div class="col-md-4" style = "width:20%;">
            <#--<input class="form-control" id="dateEnd" name="dateEnd" type="text" placeholder="请选择" readonly style = "width:auto">-->
            <select class="form-control" id="deal">
                <option value="YES">已处理</option>
                <option value="NO">未处理</option>
            </select>
        </div>
        <input type="button" class="btn btn-primary" style = "width:25%" onclick="searchMaintenance()" value="查询">
    </div>
<script type="text/javascript">
    jeDate({
        dateCell:"#dateStart",
        format:"YYYY-MM-DD",
        // format:"YYYY-MM-DD 00:00:00",
        isinitVal:true,
        isTime:true, //isClear:false,
        initHour:-24,
        minDate:"1900-01-01",
        okfun:function(val){alert(val)}
    });
    jeDate({
        dateCell:"#dateEnd",
        format:"YYYY-MM-DD",
        // format:"YYYY-MM-DD 00:00:00",
        isinitVal:true,
        isTime:true, //isClear:false,
        // initHour:-24,
        minDate:"1900-01-01",
        okfun:function(val){alert(val)}
    });
    function searchMaintenance() {
        var start=$("#dateStart").val();
        var end=$("#dateEnd").val();
        var deptName = $("#workshop option:selected").val();
        var route = $("#route option:selected").val();
        var zone = $("#zone option:selected").val();
        var equip = $("#equip option:selected").val();
        var dealResult = $("#deal option:selected").val();
        // alert(start+"==="+deptName+"==="+route+"==="+zone+"==="+equip+"=="+end+"===="+dealResult);
        $.ajax({
            url: "/pc/getMaintenance",
            contentType: "application/json",
            data:JSON.stringify({"deptName":deptName,"routeName":route,"zoneName":zone,"equip":equip,"startTime":start
                ,"endTime":end,"dealResult":dealResult}),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
                // $('.tbody').empty();
                // loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
            },
            success: function (result) {
                var json=result.data;
                var str='';

                for (var i = 0; i < json.length; i++) {
                    var pic=json[i].pic;

                    str += '<tr><td>'+(i + 1) + '</td><td>'
                        + json[i].dataTime+ '</td><td>'
                        + json[i].deptName + '</td><td>'
                        + json[i].routeName + '</td><td>'
                        + json[i].zoneName + '</td><td>'
                        + json[i].devName + '</td><td>'
                        + json[i].description + '</td><td > <img alt="" src='+pic+' ></td><td>'
                        + json[i].discoverer + '</td><td>'
                        + json[i].phone +'</td><td>'
                        + (json[i].dealUser == null ? "-" : json[i].dealUser)  + '</td><td>'
                        + (json[i].dealResult == null ? "-" : json[i].dealResult) + '</td><td>'
                        + (json[i].dealTime  == null ? "-" : json[i].dealResult)+ '</td><td>'
                        + json[i].dealTag + '</td><td> <input type="button" class="btn btn-primary"  onclick="searchMaintenance()" value="详情"></td></tr>';
                }
                $(".tbody").empty().append(str)
            }

        })
    }
</script>
</form>
        <#--<form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">-->

            <#--<div class="form-group" id="datet" style = "width:auto;margin-left:5%">-->
<div class="form-group" style="margin-top:1%;">
	<table id="groupTable" class="table table-striped table-bordered table-hover">
		<thead id="groupTable-thead" align="center">
			<tr>
                <td>序号</td>
                <td>时间</td>
                <td>工段</td>
                <td>路线</td>
                <td>区域</td>
                <td>设备</td>
                <td>内容</td>
                <td>图片</td>
                <td>发现人</td>
                <td>联系方式</td>
                <td>处理人</td>
                <td>处理结果</td>
                <td>处理时间</td>
                <td>处理情况</td>
                <td>详情</td>
			</tr>
		</thead>
		<tbody id="groupTable-tbody" align="center" class="tbody">


		</tbody>
	</table>

</div>

<!----/主空间显示区域----------------------------------------------------------------------------------------------------------------->			
			</div><!-- /主空间 -->
        </div><!----/右侧栏目主空间------------------------------------------------------------------------------------------------>    
	</div></div><!------/页面主体---------------------------------------------------------------------------------------------->
</div>
<script type="text/javascript" src="/js/searchEquip.js"></script>
<script type="text/javascript" src="/js/picShow.js"></script>

</body>
</html>