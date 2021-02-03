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
        #zcCheck,#bjCheck,.bjType,#wjCheck,#allChoose{margin-left: 5%;
            margin-right: 1%;}
        #choose input{margin: 0px 0 0 10px};
        .part{
            line-height: 10%  !important;
        }
        #modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
            /*opacity: 0.6;*/
        }
        #dealBC_modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
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
            border-radius: 1%;
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
        #modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
            /*opacity: 0.6;*/
        }
        #changeBC_modal{
            position: absolute;
            width: 500px;
            height: 200px;
            margin-top: 10%;
            left: 50%;
            margin-left: -200px;
            background: #fff;
            border:1px solid #ddd;
            border-radius: 1%;
        }
        #changeBC_modal_top{
            width: 498px;
            height: 19px;
            position: relative;
        }
        #changeBC_modal_content{
            position: relative;
            width: 498px;
            height: 380px;
        }
        #changeBC_modal_close{
            position: absolute;
            right: 0px;
            top: 6px;
            display: block;
            width:40px;
            height: 19px;
            cursor: pointer;
        }
        #changeBC_modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
            /*opacity: 0.6;*/
        }



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

        #deal_write_modal_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
            min-width: 800px;
        }
        #deal_write_modal{
            position: absolute;
            width: 70%;
            height: 80%;
            margin-top: 5%;
            min-width: 600px;
            min-height: 400px;
            border-radius: 1%;
            margin-left: 15%;
            background: #fff;
            border: 1px solid #ddd;
        }
        #deal_write_modal_top{
            width: 100%;
            /*line-height: 24px;*/
            /*margin-top: 1%;*/
            position: absolute;
            height: 13%;
            color: red;
            font-size: 20px;
        }
        .cell1{width:100px}
        .cell2{ width: 219px}
        .centerdiv{
            float:left;
            border-right: 2px dashed black;
            padding-bottom:100000px;  /*关键*/
            margin-bottom:-100000px;  /*关键*/
        }
        .c-deal{padding: 4px}
    </style>
</head>
<body id="cc">

<div class="htmleaf-container" id="aa">
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
                <nav class="navbar navbar-default" id="menuHeight">
                   <ul class="nav nav-tabs nav-justified">
                        <li id="li1" class="active" ><a style=" cursor: pointer;" onclick="chooseItem('dxj')">点巡检结果预处理</a></li>
                       <li  id="li2"><a style=" cursor: pointer;" onclick="chooseItem('alarmDeal')">报警月度清单</a></li>
                        <li  id="li3"><a style=" cursor: pointer;" onclick="chooseItem('service')">处理单查询</a></li>
                       <li  id="li5"><a style=" cursor: pointer;" onclick="chooseItem('BC')">BC类报警查询</a></li>
                       <li  id="li4"><a style=" cursor: pointer;" onclick="chooseItem('config')">配置</a></li>
                       <li><a href="javascript:choosePath()">返回上层</a></li>
                    </ul>
                </nav><!-- /导航区域 -->
                <hr/>
                <#----------------------------------------------点巡检系统查询----------------------------------------------------------------------->
                <div class="col-sm-12 form1">
                    <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    width: 75%; margin-left: 15%;">
                        <!-- <input type="text" class="form-control" id="dxj_name" name="dxj_name" style = "display:none" > -->

                        <div class="form-group" id="datet" style = "width:auto;margin-left:5%">
                            <label for="name" class="col-sm-2 control-label" style = "width:auto">计划起始时间</label>
                            <div class="col-md-4" style = "width:20%">
                                <input class="form-control dateStart" id="dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                            </div>
                            <label for="name" class="col-sm-2 control-label" style = "width:auto">计划结束时间</label>
                            <div class="col-md-4" style = "width:20%">
                                <input class="form-control dateEnd" id="dateEnd" name="dateEnd" type="text" placeholder="请选择" readonly style = "width:auto">
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
                            <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto">处理状态</label>
                                <div class="col-md-4" style = "width:12%">
                                    <select id="chooseDeal" class="form-control" >
                                        <option value="all" selected>全选</option>
                                        <option value="handled">已处理</option>
                                        <option value="unhandled">未处理</option>
                                    </select>
                                </div>
                            <button type="button" class="btn btn-primary" style = "width:7%" onclick="search('a')">查询</button>
                        </div>
                        <div class="form-group" id="choose" style = "width:auto;margin-left:5%;" >
                            <label id="zcCheck">正常<input type="checkbox" class="sd" checked> </label>
                            <label id="bjCheck">报警<input type="checkbox" class="sd" checked></label>
                            <label id="alarmType1" class="bjType">A类报警<input class="sd checkBj"type="checkbox"  ></label>
                            <label id="alarmType2" class="bjType">B类报警<input class="sd checkBj" type="checkbox"  ></label>
                            <label id="alarmType3" class="bjType">C类报警<input class="sd checkBj" type="checkbox"  ></label>
                            <label id="wjCheck">未检<input type="checkbox"  class="sd" checked></label>
                            <label id="allChoose">全选<input  id="test" class="ad" type="checkbox" ></label>
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
                                    <#--<td>修改报警类型</td>-->
                                    <td>报警类别（管理）</td>
                                    <td>报警处理部门</td>
                                    <#--<td>报警处理单</td>-->
                                    <td colspan="3">操作</td>
                                </tr>
                            </thead>
                            <tbody id="groupTable-tbody" align="center" class="tbody">

                            </tbody>
                        </table>
                    </div>
                </div>
<#-------------------------B、C类报警处理------------------------------------->
                <div id="search_service" class="form2" style=" display: none">
                    <div class="col-sm-9" style="width:50%;">
                        <#--<h1 style="text-align: center ;font-size: 24px;font-weight: bold;">BC类未处理清单</h1>-->
                        <h1 style="text-align: center ;font-size: 24px;font-weight: bold;">C类未处理清单</h1>
                        <div class="col-sm-12" >
                            <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;  ">
                                <#--<div style="width: 300px;height: 400px;background-color: #00FFFF"></div>-->
                                <div class="form-group" style = "width:auto; ">
                                    <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >开始时间</label>
                                    <div class="col-md-4" style="width: 31%;" >
                                        <input class="form-control " id="search-bc-start-date"  type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>
                                    <label for="ass_role_id"  class="col-sm-2 control-label" style = "width:auto;    margin-left: 9%;" >结束时间</label>
                                    <div class="col-md-4" style="width: 18%;">
                                        <input class="form-control " id="search-bc-end-date"  type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>

                                </div>
                                <div class="form-group" style = "width:auto;" >
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">工段选择</label>
                                    <div class="col-md-4"  style="width: 20%;">
                                        <select class="form-control" id="workshop3" style = "width:100%" >
                                        </select>
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label"   style = "
                                    width:auto;margin-left: 7%;display: none">报警类型</label>
                                    <div class="col-md-4"  style="width: 20%;">
                                        <select class="form-control" id="alarm-type"  style = "width:100%;display: none" >
                                            <#--<option value="test">全部选择</option>-->
                                            <option value="2" >B类报警</option>
                                            <option value="3" selected>C类报警</option>
                                        </select>
                                    </div>
                                    <label type="button" class="btn btn-primary" style = "width:14%;    margin-left: 9%;" onclick="search_bc_alarm_data()">查询</label>
                                </div>
                                <#--<div class="form-group" style = "width:auto;" >-->
                                    <#--<label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto;">处理状态</label>-->
                                    <#--<div class="col-md-4"  style="width: 33%;">-->
                                        <#--<select class="form-control" id="alarm-deal"  style = "width:100%" >-->
                                            <#--<option value="test">全部选择</option>-->
                                            <#--<option value="dealed" >已处理</option>-->
                                            <#--<option value="undeal" selected>未处理</option>-->
                                        <#--</select>-->
                                    <#--</div>-->
                                 <#---->
                                <#--</div>-->
                            </form>
                            <div class="form-group col-sm-12" style="margin-top:1%;   width: 100%; " id="liable-details-div">
                                <table  class="table table-striped table-bordered table-hover">
                                    <thead  align="center">
                                    <tr>
                                        <td><input type="checkbox" class="mergeBCAlarmTypeAll" name="mergeBCAlarmTypeAll" style="cursor: pointer;"></td>
                                        <td>序号</td>
                                        <td>工段</td>
                                        <td>设备</td>
                                        <td>部位</td>
                                        <td>内容</td>
                                        <td>备注</td>
                                        <td>时间</td>
                                        <td>次数</td>
                                        <#--<td>月度清单</td>-->
                                        <td>延期</td>
                                        <td>延期备注</td>
                                        <td colspan="3">操作</td>
                                    </tr>
                                    </thead>
                                    <tbody id="bcAlarm-tbody" align="center" class="liabletbody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="centerdiv"></div>
                    <div class="col-sm-9" style="width:50%;">
                        <h1 style="text-align: center ;font-size: 24px;font-weight: bold;">待修清单</h1>
                        <div class="col-sm-12" >
                            <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;">
                                <div class="form-group" style = "width:auto;" >
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">工段选择</label>
                                    <div class="col-md-4"  style="width:35%;">
                                        <select class="form-control" id="workshop4" style = "width:100%" >
                                        </select>
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">处理状态</label>
                                    <div class="col-md-4"  style="width: 35%;">
                                        <select class="form-control" id="month-list-deal_status" style = "width:100%" >
                                            <option value="1">未处理</option>
                                            <option value="2">已处理</option>
                                            <option value="3">已延期</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group" style = "width:auto;" >
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">报警类型</label>
                                    <div class="col-md-4"  style="width: 35%;">
                                        <select class="form-control" id="month-list-alarm_type" style = "width:100%" >
                                            <option value="2">B类报警</option>
                                            <option value="3">C类报警</option>
                                            <option value="1">全部类型</option>
                                        </select>
                                    </div>
                                    <label type="button" class="btn btn-primary" style = "width:21%;    margin-left: 1%;" onclick="search_bc_monthly_alarm_list('default')">查询</label>
                                    <label type="button" class="btn btn-primary" style = "width:21%;    margin-left: 1%;" onclick="downloadBB()">下载</label>
                                </div>
                                <div class="form-group" style = "width:auto; display:none" id="month_list_time_choose">
                                    <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >开始时间</label>
                                    <div class="col-md-4" style="width: 31%;" >
                                        <input class="form-control " id="monthList-start-date"  type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>
                                    <label for="ass_role_id"  class="col-sm-2 control-label" style = "width:auto;    margin-left: 9%;" >结束时间</label>
                                    <div class="col-md-4" style="width: 18%;">
                                        <input class="form-control " id="monthList-end-date"  type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>

                                </div>
                            </form>
                            <div class="form-group col-sm-12" style="margin-top:1%;   width: 100%; " id="liable-details-div">
                                <table  class="table table-striped table-bordered table-hover">
                                    <thead  align="center">
                                        <tr>
                                            <td><input type="checkbox" class="mergeBCAlarmToListAll" name="mergeBCAlarmToListAll" style="cursor: pointer;"></td>
                                            <td>序号</td>
                                            <td>工段</td>
                                            <td>设备</td>
                                            <td>部位</td>
                                            <td>内容</td>
                                            <td>备注</td>
                                            <td>时间</td>
                                            <td>次数</td>
                                            <td>延期</td>
                                            <td>延期备注</td>
                                            <td colspan="3" id="hiddenMega">操作</td>
                                        </tr>
                                    </thead>
                                    <tbody id="monthly-alarm-list-tbody" align="center" class="liabletbody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
<#------------------------报警处理单查询------------------------------------->
                <div id="search_service" class="form3" style=" display: none">
                    <div class="col-sm-9" style="width:100%;">
                        <div class="col-sm-12" >
                            <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 20%;">
                                <#--<div style="width: 300px;height: 400px;background-color: #00FFFF"></div>-->
                                <div class="form-group" style = "width:auto;margin-left:10%;">
                                    <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >开始时间</label>
                                    <div class="col-md-4" style="width: 18%;" >
                                        <input class="form-control dateStart" id="dateStart2" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto;    margin-left: 4%;" >结束时间</label>
                                    <div class="col-md-4" style="width: 18%;">
                                        <input class="form-control dateEnd" id="dateEnd2" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>

                                </div>
                                <div class="form-group" style = "width:auto;margin-left:10%;" >
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">工段选择</label>
                                    <div class="col-md-4"  style="width: 18%;">
                                        <select class="form-control" id="workshop2" name="bm" style = "width:100%" >
                                        </select>
                                    </div>
                                    <label type="button" class="btn btn-primary" style = "width:23%;    margin-left: 7%;" onclick="search_service()">查询</label>
                                </div>
                            </form>
                            <div class="form-group col-sm-12" style="margin-top:1%;   width: 73%; margin-left: 14%;" id="liable-details-div">
                                <table id="groupTable" class="table table-striped table-bordered table-hover">
                                    <thead id="groupTable-thead" align="center">
                                    <tr>
                                        <td>序号</td>
                                        <td>处理单编号</td>
                                        <td>部门</td>
                                        <td>设备名称</td>
                                        <td>报警内容</td>
                                        <td>验收人</td>
                                        <td>填报时间</td>
                                        <td>详情</td>
                                    </tr>
                                    </thead>
                                    <tbody id="service-tbody" align="center" class="liabletbody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <#--BC类报警查询-->
                <div id="search_service" class="form5" style=" display: none">
                    <div class="col-sm-9" style="width:100%;">
                        <div class="col-sm-12" >
                            <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 16%;">
                                <#--<div style="width: 300px;height: 400px;background-color: #00FFFF"></div>-->
                                <div class="form-group" style = "width:auto;">
                                    <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >开始时间</label>
                                    <div class="col-md-4" style="width: 18%;" >
                                        <input class="form-control dateStart" id="form5dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto;    margin-left: 4%;" >结束时间</label>
                                    <div class="col-md-4" style="width: 18%;">
                                        <input class="form-control dateEnd" id="form5dateEnd" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto;    margin-left: 4%;">工段选择</label>
                                    <div class="col-md-4"  style="width: 18%;">
                                        <select class="form-control" id="form5workshop" name="bm" style = "width:100%" >
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group" style = "width:auto;" >

                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">报警类型</label>
                                    <div class="col-md-4"  style="width: 18%;">
                                        <select class="form-control" id="form5alarmType"  style = "width:100%" >
                                            <option value="0" selected>全部类型</option>
                                            <option value="2" >B类报警</option>
                                            <option value="3">C类报警</option>
                                        </select>
                                    </div>
                                    <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto;margin-left: 4%;">处理状态</label>
                                    <div class="col-md-4"  style="width: 18%;">
                                        <select class="form-control" id="form5dealState"  style = "width:100%" >
                                            <option value="0" selected>全选</option>
                                            <option value="1">已处理</option>
                                            <option value="2">未处理</option>
                                        </select>
                                    </div>

                                    <label type="button" class="btn btn-primary" style = "width:20%;    margin-left: 7%;" onclick="search_all_BC_data()">查询</label>
                                </div>
                                <#--<div class="form-group" style = "width:auto;margin-left:10%;" >-->
                                   <#---->
                                <#--</div>-->

                            </form>
                            <div class="form-group col-sm-12" style="margin-top:1%;   width: 73%; margin-left: 14%;" id="liable-details-div">
                                <table id="groupTable" class="table table-striped table-bordered table-hover">
                                    <thead id="groupTable-thead" align="center">
                                    <tr>
                                        <td>序号</td>
                                        <td>日期</td>
                                        <td>部门</td>
                                        <td>设备</td>
                                        <td>部位</td>
                                        <td>内容</td>
                                        <td>备注</td>
                                        <td>报警类型</td>
                                        <td id="dealState1">处理状态</td>
                                    </tr>
                                    </thead>
                                    <tbody id="form5-tbody" align="center" class="liabletbody">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <#--配置页面-->
                <div class="col-sm-12 form4" style=" display: none">
                    <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    width: 100%; height: 100%">
                        <iframe src="/spot/dxj_config" frameborder="0" width="100%"  height="100%"></iframe>
                    </form>
                </div>
            </div>
        </div>
    </div>

<#--  --------------------------------------------弹窗显示--------------------------------------------------------  -->
<#--报警类型选择遮盖层-->
<div id="modal_cover">
    <div id="modal">
        <div id="modal_top">
            <a id="modal_close" onclick="closeModal();">关闭</a>
        </div>
        <div id ="modal_content">
            <table style="width: 100%;text-align: center;  line-height: 300%;">
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
                            <label id="sksb" class="part" >碎矿设备<input type="checkbox" class="test" name="gdxz"  value="碎矿设备"></label>
                            <label id="mfsb" class="part">磨浮设备<input type="checkbox" class="test"  name="gdxz"  value="磨浮设备"></label>
                            <label id="jwsb" class="part">精尾设备<input type="checkbox" class="test"  name="gdxz"  value="精尾设备"></label>
                            <label id="dy"   class="part">电仪工段<input type="checkbox" class="test"  name="gdxz"  value="电仪工段"></label>
                        <br>
                            <label id="sksc"  class="part">碎矿生产<input type="checkbox" class="test"  name="gdxz"  value="碎矿生产"></label>
                            <label id="mfsc"  class="part">磨浮生产<input type="checkbox"  class="test" name="gdxz"  value="磨浮生产"></label>
                            <label id="jwsc"  class="part">精尾生产<input type="checkbox"  class="test" name="gdxz"  value="精尾生产"></label>
                        <br>
                    </td>
                </tr>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td colspan="3" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeModal()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="changeAType()" value="确定">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<#-- 修改BC类报警类型-->
<div id="changeBC_modal_cover">
    <div id="modal">
        <div id="changeBC_modal_top">
            <a id="changeBC_modal_close" onclick="closeChangeBCModal();">关闭</a>
        </div>
        <div id ="changeBC_modal_content">
            <table style="width: 100%;text-align: center;  line-height: 300%;">
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择报警类型</td>
                    <td colspan="3">
                        <select class="form-control"  id="changeBCAlarmselectType"  style = "width:70%;margin-left: 15%">
                            <#--<option id="alarmType1" class="bjType" value="1">A类报警/立即处理</option>-->
                            <option  class="changeBCAlarmType" value="2">B类报警/检修时处理</option>
                            <option  class="changeBCAlarmType" value="3">C类报警/持续观察</option>
                        </select>
                    </td>
                </tr>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >选择责任部门</td>
                    <td colspan="4">
                        <#--<input type="checkbox" value="碎矿设备">-->
                        <label  class="part" >碎矿设备<input type="checkbox" class="test" name="changeBCAlarmDepart"  value="碎矿设备"></label>
                        <label  class="part">磨浮设备<input type="checkbox" class="test"  name="changeBCAlarmDepart"  value="磨浮设备"></label>
                        <label  class="part">精尾设备<input type="checkbox" class="test"  name="changeBCAlarmDepart"  value="精尾设备"></label>
                        <label   class="part">电仪工段<input type="checkbox" class="test"  name="changeBCAlarmDepart"  value="电仪工段"></label>
                        <br>
                        <label  class="part">碎矿生产<input type="checkbox" class="test"  name="changeBCAlarmDepart"  value="碎矿生产"></label>
                        <label   class="part">磨浮生产<input type="checkbox"  class="test" name="changeBCAlarmDepart"  value="磨浮生产"></label>
                        <label   class="part">精尾生产<input type="checkbox"  class="test" name="changeBCAlarmDepart"  value="精尾生产"></label>
                        <br>
                    </td>
                </tr>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td colspan="3" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeChangeBCModal()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="changeBCAlarmType()" value="确定">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
    <#-- 处理BC类报警类型-->
    <div id="dealBC_modal_cover" style="display: none">
        <div id="modal">
            <div id="changeBC_modal_top">
                <a id="changeBC_modal_close" onclick="closeDealBCModal();">关闭</a>
            </div>
            <div id ="changeBC_modal_content">
                <table style="width: 100%;text-align: center;  line-height: 400%;">
                    <tr class="form-group" style = "width:auto;margin-left:5%;">
                        <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >处理方式</td>
                        <td colspan="3">
                            <select class="form-control"  id="dealBCAlarmStatus"  style = "width:70%;margin-left: 15%" onchange="changeBorder()">
                                <option  class="dealBCAlarmStatus" value="1" selected="selected">立即处理</option>
                                <option  class="dealBCAlarmStatus" value="2">延期处理</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group" style = "width:auto;margin-left:5%;">
                        <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >
                            备注
                        </td>
                        <td for="ass_role_id" colspan="1" class="col-sm-2 control-label" style = "width:auto;margin-left: 37%;font-size: 18px;" >
                            <input type="text" id="dealBCAlarmRemark"  class="form-control"  style="width:100%;" onchange="changeBorder()">
                        </td>
                    </tr>
                    <tr class="form-group" style = "width:auto;margin-left:5%;">
                        <td colspan="3" >
                            <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeDealBCModal()" value="取消">
                            <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="dealAlarm()" value="确定">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
<#--查看报警处理单遮盖层-->
<div id="deal_modal_cover">
    <div id="deal_modal">
        <div id="deal_modal_top">
            <a style="margin-left: 90%;cursor:pointer"  onclick="closeDealData_modal();">关闭</a>
        </div>

        <table cellpadding="0" cellspacing="0"   style="width: 90%; line-height: 20px;    margin-left: 5%;
                    margin-top: 5%; ;text-align: center"
               class="table table-striped table-bordered table-hover">
            <caption style="font-size: 25px;line-height: 40px !important;font-weight: 600;text-align: center">故障处理单</caption>
            <tbody>
            <tr>
                <td  class="cell1">设备名称</td>
                <td  class="cell2" id="equip-name"></td>
                <td  class="cell1">设备编码</td>
                <td  class="cell2" id="equip-cod"></td>
                <td  class="cell1">处理单编号</td>
                <td  class="cell2" id="repair-id"></td>
            </tr>
            <tr>
                <td  class="cell1">所属工段</td>
                <td  class="cell2" id="deptName"></td>
                <td  class="cell1">规格型号</td>
                <td  class="cell2" id="equip-model"></td>
                <td  class="cell1">类别</td>
                <td  class="cell2" id="technology"></td>
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
                <td  class="cell1">维修开始日期</td>
                <td  class="cell2" id="repair-start-date" ></td>
                <td  class="cell1">维修结束日期</td>
                <td  class="cell2" id="repair-end-date" ></td>
                <td  class="cell1">维修时间</td>
                <td  class="cell2" id="repair-time"></td>
            </tr>
            <tr>
                <td  class="cell1">维修类型</td>
                <td  class="cell2" id="repair-depart1" ></td>
                <td  class="cell1" id="repair_unit">维修单位</td>
                <td  class="cell2" colspan="5" id="repair-depart2"></td>
            </tr>
            <tr  >
                <td  class="cell1" >维修内容</td>
                <td  class="cell2"  colspan="5" id="repair-content" style="line-height: 30px"></td>
            </tr>
            <tr>
                <td  class="cell1" >验收人</td>
                <td  class="cell2" colspan="2" id="deal-name"></td>
                <td  class="cell1">填报时间</td>
                <td  class="cell2" colspan="2" id="deal-time"></td>
            </tr>
            <tr>
                <td  class="cell1">备注</td>
                <td  class="cell2" colspan="5" id="remark"></td>
            </tr>
            </tbody>

        </table>
    </div>
</div>

    <#--填写报警处理单遮盖层-->
        <div id="deal_write_modal_cover">
            <div id="deal_write_modal">
                <div id="deal_write_modal_top">
                    <a style="margin-left: 90%;cursor:pointer"  onclick="closeDealWriteData_modal();">关闭</a>
                    <div style="    font-size: 30px; text-align: center; color: black;line-height: 100%;">故障处理单</div>
                </div>
                <div style="width: 100%;min-height: 300px;height: 74%;overflow-y: scroll; margin-top: 75px;">
                    <table cellpadding="0" cellspacing="0"   style="width: 90%; line-height: 20px;  margin-left: 5%;table-layout:fixed; ;text-align: center"
                           class="table table-striped table-bordered table-hover">
                        <tbody>
                        <tr>
                            <td  class="cell1">设备名称</td>
                            <td  class="cell2" ><input type="text" id="devName1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">设备编码</td>
                            <td  class="cell2" ><input type="text" id="equip-code1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">处理单编号</td>
                            <td  class="cell2" ><input type="text" id="repair-id" placeholder="自动生成" readonly class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">所属工段</td>
                            <td  class="cell2" ><input type="text" id="deptName1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">规格型号</td>
                            <td  class="cell2" <#--id="equip-model"-->><input type="text" id="equip-model1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">类别</td>
                            <td  class="cell2" ><input type="text" id="technology1" readonly class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">报警类别</td>
                            <td  class="cell2" ><input type="text" id="repair-type1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">点检人</td>
                            <td  class="cell2" ><input type="text" id="spot-name1" readonly class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">点检时间</td>
                            <td  class="cell2" ><input type="text" id="spot-time1" readonly class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">报警内容</td>
                            <td  class="cell2" colspan="5" ><input type="text" id="alarm-content1" readonly class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">维修开始时间</td>
                            <td  class="cell2"><input class="form-control" id="repair-start-date1" type="text" placeholder="请选择" readonly style = "width:auto"></td>
                            <td  class="cell1">维修结束日期</td>
                            <td  class="cell2" ><input class="form-control"  id="repair-end-date1" type="text" placeholder="请选择" readonly style = "width:auto"></td>
                            <td  class="cell1">维修时间</td>
                            <td  class="cell2" ><input type="text" id="repair-time1" readonly class="form-control" placeholder="自动计算" style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">维修类型</td>
                            <td  class="cell2" id="repair-type1" >
                                <input type="radio" id="serviceUnitType1" name="serviceUnitType" onchange="getUnitInfo()" checked="checked" value="自修">自修
                                <input type="radio" id="serviceUnitType2" name="serviceUnitType" onchange="getUnitInfo()" value="维保">维保
                                <input type="radio" id="serviceUnitType3" name="serviceUnitType" onchange="getUnitInfo()" value="委外">委外
                            </td>
                            <td  class="cell1" id="repair-unit1">维修人</td>
                            <td  class="cell2" colspan="3" ><input type="text" id="repair-name1" name="repair-name1"  class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr  >
                            <td  class="cell1" >维修内容</td>
                            <td  class="cell2"  colspan="5"  style="line-height: 30px">
                                <textarea type="text" rows="1" id="serviceContent1" name="serviceContent1" class="form-control" style="width:100%;"></textarea></td>
                        </tr>
                        <tr>
                            <td  class="cell1" >验收人</td>
                            <td  class="cell2" colspan="2" ><input type="text" id="deal-name1" readonly placeholder="自动生成" class="form-control"  style="width:100%;"></td>
                            <td  class="cell1">填报时间</td>
                            <td  class="cell2" colspan="2" ><input type="text" id="deal-time1" readonly placeholder="自动生成" class="form-control"  style="width:100%;"></td>
                        </tr>
                        <tr>
                            <td  class="cell1">备注</td>
                            <td  class="cell2" colspan="5" >
                                <textarea type="text" rows="1" id="remark1" name="remark1" class="form-control" style="width:100%;"></textarea>
                            </td>
                        </tr>
                        </tbody>

                    </table>
                </div>
                <div class="modal-footer" style="padding: 15px; text-align: right; bottom: 0;position: absolute; right: 0;height: 13%;">
                    <button type="button" class="btn btn-default"  onclick="closeDealWriteData_modal();">取消</button>
                    <button type="button" class="btn btn-primary" id="alarmbutt" <#--disabled="disabled"--> onclick="upBjByName()">提交</button>
                </div>
            </div>
        </div>

<script type="text/javascript" src="/js/searchResult-1.1.5.js?"></script>

</body>
</html>