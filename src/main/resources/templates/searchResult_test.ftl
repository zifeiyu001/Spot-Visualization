<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
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
        #zcCheck,#bjCheck,.bjType,#wjCheck,#allChoose{margin-left: 5%;
            margin-right: 1%;}
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
            width: 700px;
            height:300px;
            margin-top: 10%;
            left: 50%;
            margin-left: -200px;
            background: #fff;
            border:1px solid #ddd;
        }
        #modal_top{
            width: 700px;
            height: 19px;
            position: relative;
        }
        #modal_content{
            position: relative;
            width: 650px;
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
            /* left: 10%; */
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
    <div class="form-group" id="choose" style = "width:auto;margin-left:5%;" >
        <label id="zcCheck">正常<input type="checkbox" > </label>
        <label id="bjCheck">报警<input type="checkbox"  checked></label>
        <label id="alarmType1" class="bjType">A类报警<input type="checkbox" ></label>
        <label id="alarmType2" class="bjType">B类报警<input type="checkbox" ></label>
        <label id="alarmType3" class="bjType">C类报警<input type="checkbox" ></label>
        <label id="wjCheck">未检<input type="checkbox"  ></label>
        <label id="allChoose">全选<input  id="allChoose1" type="checkbox" checked></label>
        <#--<label type="button" class="btn btn-primary" style = "width:23%;    margin-left: 2%;" id="test">全选</label>-->

        <script type="text/javascript">
            var a=0;
            $("#allChoose1").click(function () {
                if (a===0){
                    $("#choose input:checkbox").attr("checked" , false);
                    a=1
                }
                else {
                    $("#choose input:checkbox").attr("checked" , true);
                    a=0
                }
            })
        </script>
    </div>
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
                <td>报警类型确定人</td>
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
                <tbody>
                    <tr class="form-group" style = "width:auto;margin-left:5%;">
                        <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择报警类型</td>
                        <td colspan="5">
                            <select class="form-control"  id="selectType" name="djnr"	 style = "width:70%;margin-left: 15%">
                                <option id="alarmType1" class="bjType" value="1">A类报警/立即处理</option>
                                <option id="alarmType1" class="bjType" value="2">B类报警/检修时处理</option>
                                <option id="alarmType1" class="bjType" value="3">C类报警/持续观察</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group append-mode" style = "width:auto;margin-left:5%;">
                        <td for="ass_role_id" colspan="1"  class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择责任部门</td>

                        <td colspan="2" id="demo">
                            <select class="form-control allDepart1"  id="chooseDepart1" name="djnr"	 style = "width:120px;margin-left: 15%">
                            </select>
                        </td>
                        <td for="ass_role_id" colspan="1"  class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择班组</td>
                        <td colspan="2">
                            <select class="form-control"  id="chooseTeam1" name="djnr"	 style = "width:100px;margin-left: 15%">
                            </select>
                        </td>
                        <td><input type="button" value="+" class="appendDepart" style="border: none;background-color: white;font-size: 25px;"></td>
                    </tr>
                </tbody>
                <tfoot>
                <tr class="form-group" style = "width:auto;margin-left:5%;">

                    <td colspan="6" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeModal()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="changeType()" value="确定">
                    </td>
                </tr>
                </tfoot>
            </table>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(".appendDepart").click(function () {
var



 var st=   '<tr class="form-group append-mode" style = "width:auto;margin-left:5%;">'
           +' <td for="ass_role_id" colspan="1"  class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择责任部门</td>'
            +'<td colspan="2" id="'+demo+'">'
            +'<select class="form-control allDepart1"  id="'+'chooseDepart'+1+'+'" name="djnr"	 style = "width:120px;margin-left: 15%">'
           +' </select>'
           +' </td>'
            +'<td for="ass_role_id" colspan="1"  class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择班组</td>'
            +'<td colspan="2">'
            +'<select class="form-control"  id="'+chooseTeam2+'" name="djnr"	 style = "width:100px;margin-left: 15%">'
            +'</select>'
            +'</td>'
            // +'<td><input type="button" value="+" class="appendDepart" style="border: none;background-color: white;font-size: 25px;"></td>'
            +'</tr>';


alert(st);


        $("#modal_content table tbody").append(st);

        getAllDeptName2();


    });

    var  s1='<option>'+'钳工班'+'</option>' +  //设备班组
        '<option>'+'维保班'+'</option>';
    var  s2='<option>'+'一班'+'</option>' +  //生产班组
        '<option>'+'二班'+'</option>'+
        '<option>'+'三班'+'</option>'+
        '<option>'+'四班'+'</option>';
    var  s3='<option>'+'一班'+'</option>' +  //生产班组
        '<option>'+'二班'+'</option>'+
        '<option>'+'三班'+'</option>'+
        '<option>'+'四班'+'</option>'+
        '<option>'+'深度水处理班'+'</option>';
    var   s4='<option>'+'电工班'+'</option>' +  //电仪班组
        '<option>'+'仪表班'+'</option>';
    var  s5='<option>'+'当班'+'</option>';
        $("#demo").click(function () {
            var depart = $("#chooseDepart1 option:selected").text();
            var alarmType=$("#selectType option:selected").val();


                    if (depart.indexOf("工段")!==-1) {
                        $("#chooseTeam1").empty().append(s4);
                    }
                    else if (depart.indexOf("生产")!==-1) {
                        if (alarmType==='1') $("#chooseTeam1").empty().append(s5);
                        else{
                            if(depart.indexOf("精尾")!==-1){
                                $("#chooseTeam1").empty().append(s3);
                            }
                            else {
                                $("#chooseTeam1").empty().append(s2);
                            }
                        }
                    }
                    else {
                        $("#chooseTeam1").empty().append(s1);
                    }
                    //生产选择4个班之一、设备选择钳工班/维保班、电仪选择电工班/仪表班
                });
       
</script>
<script type="text/javascript" src="/js/searchResult.js"></script>

</body>
</html>