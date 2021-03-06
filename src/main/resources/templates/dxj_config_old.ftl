<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


    <title>配置页面</title>
    <link rel="stylesheet" href="/css/mycss/table.css">
    <link rel="stylesheet" href="/css/css/bootstrap.css">
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/plugins/jedate/jedate.js" charset="utf-8"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/bootstrap-treeview.js"></script>
    <style>
        .part{margin-right: 2%;}
        .choosedept input{    margin: -1px 11px 0;}
        #choose input{margin: 0px 0 0 10px};

    </style>
</head>
<body>
<div class="htmleaf-container">
	<!------页面主体---------------------------------------------------------------------------------------------->

    <nav class="navbar navbar-default">
        <ul class="nav nav-tabs nav-justified">
            <li id="li1"><a onclick="chooseItem('duty')">报警责任人配置</a></li>
            <li id="li2"><a onclick="chooseItem('manage')">报警分类管理人员配置</a></li>
            <li id="li3 "><a href="/spot">返回上层</a></li>
        </ul>
    </nav><!-- /导航区域 -->
    <hr/>
	<div class="row">
 <!-----------------------------------------------------责任人---------------------------------------------------------------->
        <div class="col-sm-9" style="width:100%;">
            <div class="col-sm-12  form1" >
                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 12%;">
                    <div class="form-group" style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >工段选择</label>
                        <div class="col-md-4" style="width: 20%;" >
                            <select class="form-control " id="workshopUser1" name="bm" style = "width:100%" onclick="getUser('duty')">
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >人员选择</label>
                        <div class="col-md-4" style="width: 20%;">
                            <select class="form-control " id="user1" name="bm" style = "width:100%">
                            </select>
                        </div>

                    </div>
                    <div class="form-group" style = "width:auto;margin-left:20%;" >

                        <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">班次选择</label>
                        <div class="col-md-4"  style="width: 20%;">
                            <select class="form-control " id="team">
                                <option value="null">无</option>
                                <option value="一班">一班</option>
                                <option value="二班">二班</option>
                                <option value="三班">三班</option>
                                <option value="四班">四班</option>
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">报警级别</label>
                        <div class="col-md-4"  style="width: 20%;">
                            <select class="form-control " id="alarmType">
                                <option value="1">A类/立即处理</option>
                                <option value="2">B类/检修时处理</option>
                                <option value="3">C类/继续观察</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" id="mana-depart" style = "width:auto;margin-left:20%;"  >
                        <label for="ass_role_id" id="choosepart" class="col-sm-2 control-label"  style = "width:auto;">选择部门</label>
                        <div class="col-md-4" id="all_depart" style="width: 49%;">
                            <label id="sksb1" class="part" >碎矿设备<input type="checkbox" name="gdxz1"  value="碎矿设备"></label>
                            <label id="mfsb1" class="part">磨浮设备<input type="checkbox"  name="gdxz1"  value="磨浮设备"></label>
                            <label id="jwsb1" class="part">精尾设备<input type="checkbox"  name="gdxz1"  value="精尾设备"></label>
                            <label id="dy1"   class="part">电仪工段<input type="checkbox"  name="gdxz1"  value="电仪工段"></label>
                            <br>
                            <label id="sksc1"  class="part">碎矿生产<input type="checkbox"  name="gdxz1"  value="碎矿生产"></label>
                            <label id="mfsc1"  class="part">磨浮生产<input type="checkbox"  name="gdxz1"  value="磨浮生产"></label>
                            <label id="jwsc1"  class="part">精尾生产<input type="checkbox"  name="gdxz1"  value="精尾生产"></label>
                            <#--<label type="button" class="btn btn-primary" style = "width:23%;    margin-left: 2%;" id="test">全选</label>-->

                            <br>
                        </div>
                    </div>
                    <div class="form-group" style = "width:auto;margin-left:20%;" >
                        <label type="button" class="btn btn-primary" style = "width:23%;    margin-left: 2%;" onclick="save()">确定</label>
                        <label type="button" id="liable-details" class="btn btn-primary" style = "width:23%;    margin-left: 6%;">详情</label>
                    </div>

                    <div class="form-group" id="save" style = "width:auto;margin-left:20%;"></div>
                    <div class="form-group col-sm-12" style="margin-top:1%;width: 60%; margin-left: 15%;display: none" id="liable-details-div">
                        <table id="groupTable" class="table table-striped table-bordered table-hover">
                            <thead id="groupTable-thead" align="center">
                            <tr>
                                <td>序号</td>
                                <td>所属部门</td>
                                <td>班次</td>
                                <td>报警类别</td>
                                <td>管理部门</td>
                                <td>报警类型</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody id="groupTable-tbody" align="center" class="liabletbody">
                            </tbody>
                        </table>
                    </div>

                </form>
            </div>
<#-- ----------------------------------------管理人员页面--------------------------------------------------->
            <div class="col-sm-12  form2" style=" display: none">

                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 8%;">
                    <div class="form-group" style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >工段选择</label>
                        <div class="col-md-4" style="width: 20%;" >
                            <select class="form-control" id="workshopUser2" name="bm" style = "width:100%" onclick="getUser('manage')">
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >人员选择</label>
                        <div class="col-md-4" style="width: 20%;">
                            <select class="form-control" id="user2" name="bm" style = "width:100%">
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >管理部门选择</label>
                        <div class="col-md-4" style="width: 35%;">
                            <label id="sksb" class="part" >碎矿设备<input type="checkbox" name="gdxz"  value="碎矿设备"></label>
                            <label id="mfsb" class="part">磨浮设备<input type="checkbox"  name="gdxz"  value="磨浮设备"></label>
                            <label id="jwsb" class="part">精尾设备<input type="checkbox"  name="gdxz"  value="精尾设备"></label>
                            <label id="dy"   class="part">电仪工段<input type="checkbox"  name="gdxz"  value="电仪工段"></label>
                            <label id="sksc"  class="part">碎矿生产<input type="checkbox"  name="gdxz"  value="碎矿生产"></label>
                            <label id="mfsc"  class="part">磨浮生产<input type="checkbox"  name="gdxz"  value="磨浮生产"></label>
                            <label id="jwsc"  class="part">精尾生产<input type="checkbox"  name="gdxz"  value="精尾生产"></label>
                        </div>
                        <label type="button" class="btn btn-primary" style = "width:8%;    margin-left: 1%;" onclick="addUser()">添加用户</label>
                    </div>

                </form>
                <div class="form-group col-sm-12" style="margin-top:1%;width: 60%; margin-left: 21%;">
                    <table id="groupTable" class="table table-striped table-bordered table-hover">
                        <thead id="groupTable-thead" align="center">
                        <tr>
                            <td>序号</td>
                            <td>所属部门</td>
                            <td>工号</td>
                            <td>用户</td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody id="groupTable-tbody" align="center" class="tbody">
                        </tbody>
                    </table>
                </div>
			</div>
        </div>
	</div>
</div>
<script type="text/javascript" src="/js/config.js"></script>
</body>
</html>