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
                   <li ><a href="weixiu2">查询</a></li>
                    <li><a href="javascript:choosePath()">返回上层</a></li>
                </ul>
            </nav><!-- /导航区域 -->
			<hr/>
			<!-- 主空间 -->
			<div class="col-sm-12">
<!----主空间显示区域----------------------------------------------------------------------------------------------------------------->			
<#--<form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">-->

	<#--<div class="form-group" id="datet" style = "width:auto;margin-left:5%">-->
		<#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择点检工段</label>-->
		<#--<div class="col-md-4" style = "width:20%">-->
			<#--<select class="form-control" id="workshop" name="bm" style = "width:100%" onclick="getRouteName()">-->
			<#--</select>-->
		<#--</div>-->
        <#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto"  >选择点检路线</label>-->
        <#--<div class="col-md-4" style = "width:20%">-->
            <#--<select class="form-control" id="route" name="lx" style = "width:100%" onclick="getZoneName()">-->
            <#--</select>-->
        <#--</div>-->
        <#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择所属区域</label>-->
        <#--<div class="col-md-4" style = "width:20%">-->
            <#--<select class="form-control" id="zone" name="qy" style = "width:100%" onclick="getDevName()">-->
            <#--</select>-->
        <#--</div>-->
	<#--</div>-->
	<#--<div class="form-group" style = "width:auto;margin-left:5%;">-->

		<#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择功能位置</label>-->
		<#--<div class="col-md-4" style = "width:20%">-->
			<#--<select class="form-control" id="equip" name="gnwz" style = "width:100%" onclick="getPartName()">-->
			<#--</select>-->
		<#--</div>-->
	<#--</div>-->

	<#--<div class="form-group" style = "width:auto;margin-left:5%;">-->
		<#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择点检部位</label>-->
		<#--<div class="col-md-4" style = "width:20%">-->
			<#--<select class="form-control" id="part" name="djbw" style = "width:100%" onclick="getContent()">-->
			<#--</select>-->
		<#--</div>-->
		<#--<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto">选择点检内容</label>-->
		<#--<div class="col-md-4" style = "width:20%">-->
			<#--<select class="form-control" id="content" name="djnr"	 style = "width:100%">-->
			<#--</select>-->
		<#--</div>-->
		<#--<label for="name" class="checkbox-inline"></label>-->
		<#--<button type="button" class="btn btn-primary" style = "width:25%" onclick="search()">查询</button>-->
	<#--</div>-->
    <#--<div class="form-group" id="choose" style = "width:auto;margin-left:5%;" >-->
        <#--<label id="zcCheck">正常<input type="checkbox" checked> </label>-->
        <#--<label id="bjCheck">报警<input type="checkbox" checked></label>-->
        <#--<label id="wxCheck">危险<input type="checkbox" checked></label>-->
        <#--<label id="wjCheck">未检<input type="checkbox"  checked></label>-->
    <#--</div>-->
    <#--<div class="form-group" id="datet" style = "width:auto;margin-left:5%">-->
        <#--<label type="button" class="btn btn-primary" id="reduceNum" style="    margin-left: 3%;-->
    <#--margin-right: 3%;">上一页</label>-->
        <#--<label style="width: 20%;margin-right: -9% !important;">第<input value="1" class="form-control" id="nowPage" style="    margin-left: 3%;-->
    <#--margin-right: 3%;display: inherit!important;width: 40% !important;" >页</label>-->
        <#--<label type="button" class="btn btn-primary" id="andNum" style="    margin-left: 3%;-->
    <#--margin-right: 3%;">下一页</label>-->
        <#--<label style="width: 20%">选择第<select id="nowPage1"  class="form-control" style=" margin-left: 3%;-->
    <#--margin-right: 3%;display: inherit!important;width: 40% !important;">-->
                <#--<option value="1">1</option>-->
            <#--</select>页</label>-->


        <#--<label style="    margin-left: -2%;-->
    <#--margin-right: -5%;">共<input id="totalData" readonly class="form-control" style=" margin-left: 3%;-->
    <#--margin-right: 3%;display: inherit!important;width: 40% !important;">条</label>-->
        <#--<label >-->
            <#--<select id="numPerPage" class="form-control" >-->
                <#--<option value="100" selected>100条/页</option>-->
                <#--<option value="200">200条/页</option>-->
                <#--<option value="500">500条/页</option>-->
            <#--</select>-->
        <#--</label>-->
        <#--<label type="button" class="btn btn-primary" style = "width:5%;    margin-left: 3%;" onclick="search()">确定</label>-->
    <#--</div>-->
<#--</form>-->
        <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">

            <div class="form-group" id="datet" style = "width:auto;margin-left:5%">
<div class="form-group" style="margin-top:1%;">
	<table id="groupTable" class="table table-striped table-bordered table-hover">
		<#--<thead id="groupTable-thead" align="center">-->
			<#--<tr>-->
                <#--<td>序号</td>-->
                <#--<td>点检时间</td>-->
                <#--<td>点检工段</td>-->
                <#--<td>点检路线</td>-->
                <#--<td>所属区域</td>-->
                <#--<td>功能位置</td>-->
                <#--<td>点检部位</td>-->
                <#--<td>点检内容</td>-->
                <#--<td>责任人</td>-->
                <#--<td>点检人员</td>-->
                <#--<td>点检结果</td>-->
                <#--<td>报警状态</td>-->
                <#--<td>备注</td>-->
			<#--</tr>-->
		<#--</thead>-->
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