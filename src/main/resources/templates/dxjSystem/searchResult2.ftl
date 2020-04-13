<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<#-------------判断是否保存session---------------->
<#if Session.username??>
<script>
    var username="${Session.username}";
</script>
<#else >
<script>
    var username="";
</script>
</#if>
<head>

<link rel="stylesheet" href="/css/css/bootstrap.css">
    <title>点巡检系统</title>
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
    <script src="/js/bootstrap-treeview.js"></script>
    <style>
        /*#zcCheck,#bjCheck,.bjType,#wjCheck,#allChoose{margin-left: 5%;*/
            /*margin-right: 1%;}*/
        #choose input{margin: 0px 0 0 10px};
        .part{
            line-height: 10%  !important;
        }
        #modal_cover{
            display: none;
            width: 30%;
            height: 40%;
            position: fixed;
            left: 37%;
            top: 19%;
            /*background: #222;*/
            /*opacity: 0.6;*/
        }
        #modal{
            position: absolute;
            width: 500px;
            height: 200px;
            margin-top: 10%;
            left: 50%;
            margin-left: -200px;
            background: #fff;
            border:1px solid #ddd;
        }
        #modal_top{
            width: 498px;
            height: 19px;
            position: relative;
        }
        #modal_content{
            position: relative;
            width: 498px;
            height: 380px;
        }
        #modal_close{
            position: absolute;
            right: 0px;
            top: 6px;
            display: block;
            width:40px;
            height: 19px;
            cursor: pointer;
        }
        .cell1{border: 1px solid; font-size: 16px;width: 16.6%;font-weight:600;line-height: 35px}
        .cell2{border: 1px solid; font-size: 14px;width: 16.6%;line-height: 35px}
        #deal_modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
            min-width: 800px;
        }
        #deal_modal{
            position: absolute;
            width: 60%;
            height: 80%;
            margin-top: 5%;
            min-width: 800px;
            min-height: 600px;
            border-radius: 1%;
            margin-left: 20%;
            background: #fff;
            border: 1px solid #ddd;
        }
        #deal_modal_top{
            width: 50%;
            height: 0px;
            margin-top: 1%;
            margin-left: 49%;
            position: relative;
            color: red;
            font-size: 20px;
        }
        #deal_modal_content{
            position: relative;
            width: 498px;
            height: 380px;
        }
        #deal_modal_close{
            position: absolute;
            right: 0px;
            top: 6px;
            display: block;
            width:40px;
            height: 19px;
            cursor: pointer;
        }
        .typePosition{
            margin-right: 15%;
            margin-left: 2%;
            margin-top: 0.5%;
        }
        .runPosition{
            margin-left: 2%;
            margin-right: 14%;
            margin-top: 0.5%;
        }
        .checkPosition{
            margin-left: 4%;
            margin-right: 12%;
            margin-top: 0.5%;
        }
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
        <div class="col-sm-9" style="width: 100%;">
            <!-- 导航区域 -->
	        <nav class="navbar navbar-default">
               <ul class="nav nav-tabs nav-justified">
				    <li class="active"><a href="#" >点巡检统计</a></li>
                   <li ><a href="/spot/dxj_config">人员配置</a></li>
                   <li><a href="javascript:choosePath()">返回上层</a></li>
                </ul>
            </nav><!-- /导航区域 -->
			<hr/>
			<!-- 主空间 -->
			<div class="col-sm-12">
<!----主空间显示区域----------------------------------------------------------------------------------------------------------------->			
<form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    width: 75%; margin-left: 15%;">
	<#--<input type="text" class="form-control" id="cj" name="cj" style = "display:none" value ="xk_dxj">-->
	<!-- <input type="text" class="form-control" id="dxj_name" name="dxj_name" style = "display:none" > -->

	<div class="form-group" id="datet" style = "width:auto;margin-left:5%">
		<label for="name" class="col-sm-2 control-label" style = "width:auto">计划起始时间</label>
		<div class="col-md-4" style = "width:20%">
			<input class="form-control" id="dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
		</div>
		<label for="name" class="col-sm-2 control-label" style = "width:auto">计划结束时间</label>
		<div class="col-md-4" style = "width:20%">
			<input class="form-control" id="dateEnd" name="dateEnd" type="text" placeholder="请选择" readonly style = "width:auto">
		</div>
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择点检工段</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="workshop" name="bm" style = "width:100%" onclick="getRouteName()">
			</select>
		</div>
	</div>
	<div class="form-group" style = "width:auto;margin-left:5%;">
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto"  >选择点检路线</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="route" name="lx" style = "width:100%" onclick="getZoneName()">
			</select>
		</div>
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择所属区域</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="zone" name="qy" style = "width:100%" onclick="getDevName()">
			</select>
		</div>
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择功能位置</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="equip" name="gnwz" style = "width:100%" onclick="getPartName()">
			</select>
		</div>
	</div>
	<div class="form-group" style = "width:auto;margin-left:5%;">
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >选择点检部位</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control" id="part" name="djbw" style = "width:100%" onclick="getContent()">
			</select>
		</div>
		<label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto">选择点检内容</label>
		<div class="col-md-4" style = "width:20%">
			<select class="form-control"  id="content" name="djnr"	 style = "width:100%">
			</select>
		</div>
		<label for="name" class="checkbox-inline"></label>
		<button type="button" class="btn btn-primary" style = "width:25%" onclick="search('a')">查询</button>
	</div>


    <div class="form-group" id="choose1" style = "width:auto;margin-left:5%;"  >
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >检查状态</label>
        <label  class="checkPosition" id="yjCheck">已检<input type="checkbox" class="check yjCheck" checked > </label>
        <label  class="checkPosition" id="wjCheck">未检<input type="checkbox" class="check wjCheck" checked> </label>
        <label  class="checkPosition">全选<input type="checkbox" class="allCheck"  checked> </label>
    </div>
    <div class="form-group " id="choose2" style = "width:auto;margin-left:5%;" >
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >检查结果状态</label>
        <label class="runPosition" id="zcCheck">正常<input type="checkbox" class="run zcCheck" > </label>
        <label class="runPosition" id="bjCheck">报警<input type="checkbox" class="run bjCheck" > </label>
        <label class="runPosition" >全选<input type="checkbox" class="allRun" > </label>
    </div>
    <div class="form-group type" id="choose3"  style = "width:auto;margin-left:5%;display: none" >
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >管理人员类型</label>
        <label class="typePosition">A类<input type="checkbox" class="alarmTypeSpot admin_a_type" > </label>
        <label class="typePosition">B类<input type="checkbox" class="alarmTypeSpot admin_b_type" > </label>
        <label class="typePosition">C类<input type="checkbox" class="alarmTypeSpot admin_c_type" > </label>
        <label class="typePosition">全选<input type="checkbox" class="adminAllType" > </label>
    </div>
    <div class="form-group type" id="choose4" style = "width:auto;margin-left:5%;display: none" >
        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto;" >报警人员类型</label>
        <label class="typePosition">A类<input type="checkbox" class="typeSpot spot_a_type" > </label>
        <label class="typePosition">B类<input type="checkbox" class="typeSpot spot_b_type"  > </label>
        <label class="typePosition">C类<input type="checkbox" class="typeSpot spot_c_type" > </label>
        <label class="typePosition">全选<input type="checkbox" class="allType" > </label>
    </div>

    <script type="text/javascript">
        <#--点击已检后执行-->
        $(".yjCheck").click(function () {
            afteryjAll();
        });
        <#--点击报警后执行-->
        $(".bjCheck").click(function () {
            afterbjAll();
        });
    </script>

        <#--复选框js-->
        <script type="text/javascript">


        //未全选时，全选不勾；全选时，全选自动勾选
            //已检、未检选择
            $(".check").click(function () {
                var all='.allCheck';
                var check="check";
                sigleChecktoAll(all,check);
            });
            //正常、报警选择
            $(".run").click(function () {
                var all='.allRun';
                var check="run";
                sigleChecktoAll(all,check);
            });
            //管理人员报警类型选择
            $(".alarmTypeSpot").click(function () {
                var all='.adminAllType';
                var check="alarmTypeSpot";
                sigleChecktoAll(all,check);
            });
            //点检员报警类型选择
            $(".typeSpot").click(function () {
                var all='.allType';
                var check="typeSpot";
                sigleChecktoAll(all,check);
            });
            //勾选公共
            function sigleChecktoAll(all,check){
                    // alert(check+"=="+all);
                    var a=0;
                    var b=0;
                    var box = document.getElementsByClassName(check);
                    // alert(box.length);
                    for ( var i = 0; i < box.length; i++) {
                        if (!box[i].checked) {
                            $(all).prop("checked", false);
                            b = b + 1;
                        } else {
                            a = a + 1;
                        }
                    }
                    if (a==box.length){
                        // alert("a======="+a+";box===="+(box.length-1));
                        $(all).prop("checked",true);
                    }
            }
        //    已检全选取消后
            function afteryjAll(){
                var sksb = $("#yjCheck input[type='checkbox']").is(':checked');
                if (sksb===true){$("#choose2").css('display','block');
                }else {$("#choose2").css('display','none');
                    $(".type").css('display','none');
                    $(".run").prop("checked", false);
                    $(".allRun").prop("checked", false);
                    $(".alarmTypeSpot").prop("checked", false);
                    $(".typeSpot").prop("checked", false);
                    $(".allType").prop("checked", false);
                    $(".adminAllType").prop("checked", false);
                }
            }
            //报警行全选取消后
            function afterbjAll(){
                var sksb = $("#bjCheck input[type='checkbox']").is(':checked');
                if (sksb===true){$(".type").css('display','block');
                }else {$(".type").css('display','none');
                    $(".alarmTypeSpot").prop("checked", false);
                    $(".typeSpot").prop("checked", false);
                    $(".allType").prop("checked", false);
                    $(".adminAllType").prop("checked", false);
                }
            }
        // ==========================全选================
            //已检、未检选择
            $(".allCheck").click(function(){
                var all='.allCheck';
                var check='.check';
                sameCheckedSet1($(this),all,check);
                afteryjAll();
            });
            //正常、报警选择
            $(".allRun").click(function(){
                var all='.allRun';
                var check='.run';
                sameCheckedSet1($(this),all,check);
                afterbjAll();
            });
            //管理人员报警类型选择
            $(".adminAllType").click(function(){
                var all='.adminAllType';
                var check='.alarmTypeSpot';
                sameCheckedSet1($(this),all,check);
            });
            //点检员报警类型选择
            $(".allType").click(function(){
                var all='.allType';
                var check='.typeSpot';
                sameCheckedSet1($(this),all,check);
            });
            //全选公共
            function sameCheckedSet1(eleInput,all,check){
                var checkAll = $(all);
                var checkItem = $(check);
                if(eleInput.is(all)){
                    if( !eleInput.is(':checked') ){
                        checkItem.prop("checked",false);
                    }else{
                        checkItem.prop("checked",true);
                    }
                }else if(eleInput.is(check)){
                    var count = 0;
                    checkItem.each(function(){
                        if( $(this).prop("checked")==false){
                            count++;
                        }
                    });
                    if(count==0){
                        checkAll.prop("checked",true);
                    }else{
                        checkAll.prop("checked",false);
                    }
                }
            }
        </script>
        <#--<script type="text/javascript">-->
            <#--var a=0;-->
            <#--$("#test").click(function () {-->
                <#--if (a===0){-->
                    <#--$("#choose input:checkbox").attr("checked" , false);-->
                    <#--a=1-->
                <#--}-->
                <#--else {-->
                    <#--$("#choose input:checkbox").attr("checked" , true);-->
                    <#--a=0-->
                <#--}-->
            <#--})-->
        <#--</script>-->

    <div class="form-group" id="datet" style = "width:auto;margin-left:5%">
        <label type="button" class="btn btn-primary" id="reduceNum" style="    margin-left: 3%;
    margin-right: 3%;">上一页</label>
        <label style="width: 20%;margin-right: -9% !important;">第<input value="1" class="form-control" id="nowPage" style="    margin-left: 3%;
    margin-right: 3%;display: inherit!important;width: 40% !important;" >页</label>
        <label type="button" class="btn btn-primary" id="andNum" style="    margin-left: 3%;
    margin-right: 3%;">下一页</label>
        <label style="width: 20%">选择第<select id="nowPage1"  class="form-control" style=" margin-left: 3%;
    margin-right: 3%;display: inherit!important;width: 40% !important;">
                <option value="1">1</option>
            </select>页</label>
        <label style="    margin-left: -2%;
    margin-right: -5%;">共<input id="totalData" readonly class="form-control" style=" margin-left: 3%;
    margin-right: 3%;display: inherit!important;width: 40% !important;">条</label>
        <label >
            <select id="numPerPage" class="form-control" >
                <option value="100" selected>100条/页</option>
                <option value="200">200条/页</option>
                <option value="500">500条/页</option>
            </select>
        </label>
        <label type="button" class="btn btn-primary" style = "width:5%;    margin-left: 3%;" onclick="search('b')">确定</label>
        <#--<label type="button" class="btn btn-primary" style = "width:5%;    margin-left: 5%;" onclick="">测试</label>-->
    </div>
</form>
<div class="form-group" style="margin-top:1%;">
	<table id="groupTable" class="table table-striped table-bordered table-hover">
		<thead id="groupTable-thead" align="center">
			<tr>
                <td>序号</td>
                <td>点检时间</td>
                <td>点检工段</td>
                <td>点检路线</td>
                <td>所属区域</td>
                <td>功能位置</td>
                <td>点检部位</td>
                <td>点检内容</td>
                <td>点检备注</td>
                <td>点检结果</td>
                <td>报警类别</td>
                <td>点检责任人</td>
                <td>点检人员</td>
                <td>任务开始时间</td>
                <td>任务结束时间</td>
                <td>处理责任人</td>
                <td>处理人</td>
                <td>处理备注</td>
                <td>修改报警类型</td>
                <td>报警类别（管理）</td>
                <td>报警处理部门</td>
                <td>报警处理单</td>
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


<div id="modal_cover"><!--遮盖层-->
    <div id="modal">
        <div id="modal_top">
            <a id="modal_close" onclick="closeModal();">关闭</a>
        </div>
        <div id ="modal_content">
            <table style="width: 100%;text-align: center;  line-height: 300%;">
                <#--<tr class="form-group" style = "width:auto;margin-left:5%;">-->
                    <#--<td for="ass_role_id" colspan="3" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择报警类型</td>-->
                <#--</tr>-->

                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择报警类型</td>
                    <td colspan="3">
                        <select class="form-control"  id="selectType" name="djnr"	 style = "width:70%;margin-left: 15%">
                            <option id="alarmType1" class="bjType" value="1">A类报警/立即处理</option>
                            <option id="alarmType1" class="bjType" value="2">B类报警/检修时处理</option>
                            <option id="alarmType1" class="bjType" value="3">C类报警/持续观察</option>
                        </select>
                    </td>
                </tr>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择责任部门</td>
                    <td colspan="4">
                        <#--<input type="checkbox" value="碎矿设备">-->
                            <label id="sksb" class="part" >碎矿设备<input type="checkbox" name="gdxz"  value="碎矿设备"></label>
                            <label id="mfsb" class="part">磨浮设备<input type="checkbox"  name="gdxz"  value="磨浮设备"></label>
                            <label id="jwsb" class="part">精尾设备<input type="checkbox"  name="gdxz"  value="精尾设备"></label>
                            <label id="dy"   class="part">电仪工段<input type="checkbox"  name="gdxz"  value="电仪工段"></label>
                        <br>
                            <label id="sksc"  class="part">碎矿生产<input type="checkbox"  name="gdxz"  value="碎矿生产"></label>
                            <label id="mfsc"  class="part">磨浮生产<input type="checkbox"  name="gdxz"  value="磨浮生产"></label>
                            <label id="jwsc"  class="part">精尾生产<input type="checkbox"  name="gdxz"  value="精尾生产"></label>
                        <br>
                    </td>
                </tr>

                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td colspan="3" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeModal()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="changeType()" value="确定">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div id="deal_modal_cover" >
    <div id="deal_modal">
        <div id="deal_modal_top">
            <a style="    margin-left: 90%;" onclick="closedeal_modal();">关闭</a>

        </div>
        <table cellpadding="0" cellspacing="0"   style="width: 90%; line-height: 20px; border: 2px solid ;    margin-left: 5%;
                    margin-top: 5%; ;text-align: center"
               class="table table-striped table-bordered table-hover">
            <!--<thead>-->
            <!--<tr>-->
            <!--<td colspan="6" style="font-size: 25px;line-height: 40px !important;font-weight: 600" onclick="data()">点巡检系统故障报警处理单</td>-->
            <!--</tr>-->
            <!--</thead>-->
            <caption style="font-size: 25px;line-height: 40px !important;font-weight: 600;text-align: center" onclick="getDealData('2019090200e06debb9-8c90-460b-8f27-9ffd505db301')">故障处理单</caption>
            <tbody>
            <tr>
                <td  class="cell1">设备编码</td>
                <td  class="cell2" id="equip-cod"></td>
                <td  class="cell1">维修日期</td>
                <td  class="cell2" id="repair-day" ></td>
                <td  class="cell1">维修时间</td>
                <td  class="cell2" id="repair-time"></td>
            </tr>
            <tr>
                <td  class="cell1">设备名称</td>
                <td  class="cell2" id="equip-name"></td>
                <td  class="cell1">规格型号</td>
                <td  class="cell2" id="equip-model"></td>
                <td  class="cell1">所属工段</td>
                <td  class="cell2" id="deptName"></td>
            </tr>
            <tr>
                <td  class="cell1">类别</td>
                <td  class="cell2" id="technology"></td>
                <td  class="cell1">维修单位</td>
                <td  class="cell2" id="repair-depart1" ></td>
                <td  class="cell2" colspan="2" id="repair-depart2"></td>
            </tr>
            <tr>
                <td  class="cell1">报警类别</td>
                <td  class="cell2" id="repair-type"></td>
                <td  class="cell1">点检人</td>
                <td  class="cell2" id="spot-name"></td>
                <td  class="cell1">点检时间</td>
                <td  class="cell2" id="spot-time"></td>
            </tr>
            <tr>
                <td  class="cell1">报警内容</td>
                <td  class="cell2" colspan="5" id="alarm-content"></td>
            </tr>
            <tr>
                <td  class="cell1">维修人员</td>
                <td  class="cell2" colspan="5" id="repair-name"></td>
            </tr>
            <tr  >
                <td  class="cell1" >维修内容</td>
                <td  class="cell2"  colspan="5" id="repair-content" style="line-height: 30px"></td>
            </tr>
            <tr>
                <td  class="cell1" >处理人</td>
                <td  class="cell2" colspan="2" id="deal-name"></td>
                <td  class="cell1">处理时间</td>
                <td  class="cell2" colspan="2" id="deal-time"></td>
            </tr>
            <tr>
                <td  class="cell1">材料、备件</td>
                <td  class="cell2" colspan="5" id="material"></td>
            </tr>
            <tr>
                <td  class="cell1">备注</td>
                <td  class="cell2" colspan="5" id="remark"></td>
            </tr>
            </tbody>

        </table>
    </div>
</div>
<script type="text/javascript">
    function closedeal_modal(){
        document.getElementById("deal_modal_cover").style.display="none";
    }
    function opendeal_modal(result_id){
        document.getElementById("deal_modal_cover").style.display = "block";
        getDealData(result_id);
    }
    function getDealData(result_id){
        $.ajax({
            url: "/interlocking/getAlarmDealData",
            contentType: "application/json",
            data: JSON.stringify({
                "resultId": result_id}),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function () {
            },
            success: function (result) {
                var data = result.data;
                //     设备编码
                $("#equip-cod").text((data[0].dev_code==null||data[0].dev_code=='')?'-':data[0].dev_code);
                //    维修日期
                $("#repair-day").text((data[0].service_date==null||data[0].service_date=='')?'-':dateFormat(data[0].service_date,'yyyy-MM-dd'));
                //    维修时间
                $("#repair-time").text((data[0].service_hours==null||data[0].service_hours=='')?'-':data[0].service_hours);
                //   设备名称
                $("#equip-name").text((data[0].dev_name==null||data[0].dev_name=='')?'-':data[0].dev_name);
                //    规格型号
                $("#equip-model").text((data[0].dev_model==null||data[0].dev_model=='')?'-':data[0].dev_model);
                //    所属工段
                $("#deptName").text((data[0].dev_dept==null||data[0].dev_dept=='')?'-':data[0].dev_dept);
                //    类别
                $("#technology").text((data[0].dev_category==null||data[0].dev_category=='')?'-':data[0].dev_category);
                //    维修单位1
                $("#repair-depart1").text((data[0].service_unit_type==null||data[0].service_unit_type=='')?'-':data[0].service_unit_type);
                //    维修单位2
                $("#repair-depart2").text((data[0].service_unit==null||data[0].service_unit=='')?'-':data[0].service_unit);
                //     报警类别
                $("#repair-type").text((data[0].alarm_type==null||data[0].alarm_type=='')?'-':data[0].alarm_type);
                //    点检人
                $("#spot-name").text((data[0].alarm_name==null||data[0].alarm_name=='')?'-':data[0].alarm_name);
                //    点检时间
                $("#spot-time").text((data[0].alarm_time==null||data[0].alarm_time=='')?'-':dateFormat(data[0].alarm_time,'yyyy-MM-dd  HH:mm:ss'));
                //  报警内容
                $("#alarm-content").text((data[0].alarm_content==null||data[0].alarm_content=='')?'-':data[0].alarm_content);
                //    维修人员
                $("#repair-name").text((data[0].service_name==null||data[0].service_name=='') ?'-':data[0].service_name);
                //    维修内容
                $("#repair-content").text((data[0].service_content==null||data[0].service_content=='')?'-':data[0].service_content);
                //  处理人
                $("#deal-name").text((data[0].service_alarm_name==null||data[0].service_alarm_name=='')?'-':data[0].service_alarm_name);
                //    处理时间
                $("#deal-time").text((data[0].service_alarm_time==null||data[0].service_alarm_time==''?'-':dateFormat(data[0].service_alarm_time,'yyyy-MM-dd  HH:mm:ss')));
                //    材料、备件
                $("#material").text((data[0].service_spare_parts==null||data[0].service_spare_parts=='')?'-':data[0].service_spare_parts);
                //    备注
                $("#remark").text((data[0].service_remarks==null||data[0].service_remarks=='')?'-':data[0].service_remarks);
            }
        });



    }
    function dateFormat(time, format) {
        var t = new Date(time);
        var tf = function (i) {
            return (i < 10 ? '0' : '') + i
        };
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
            switch (a) {
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })
    }
</script>
<script type="text/javascript" src="/js/searchResult1.js"></script>

</body>
</html>