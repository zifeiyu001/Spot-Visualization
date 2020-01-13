<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#--<#if Session.username??>-->
<#--<script>-->
    <#--var username="${Session.username}";-->
<#--</script>-->
<#--<#else >-->
    <#--<script>-->
        <#--var username="";-->
    <#--</script>-->
<#--</#if>-->
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
<div class="htmleaf-container" style="    padding: 1em 20px 1em;letter-spacing: -1px;">
	<!------页面主体---------------------------------------------------------------------------------------------->

    <nav class="navbar navbar-default">
        <ul class="nav nav-tabs nav-justified">
            <li id="li1" style="cursor: pointer"><a onclick="chooseItem('duty')">岗位线路配置</a></li>
            <li id="li2" style="cursor: pointer"><a onclick="chooseItem('manage')">岗位人员配置</a></li>
            <li id="li3 "><a href="/spot/searchResult">返回上层</a></li>
        </ul>
    </nav><!-- /导航区域 -->
    <hr/>
	<div class="row">
 <!-----------------------------------------------------线路配置---------------------------------------------------------------->
        <div class="col-sm-9" style="width:100%;">
            <div class="col-sm-12  form1" >
                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 13%;">
                    <div class="form-group" style = "width:auto;margin-left:2%;">
                        <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >工段选择</label>
                        <div class="col-md-4" style="width: 15%;" >
                            <select class="form-control " id="workshopUser1" name="bm" style = "width:100%" onchange="getRoute()" >
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >岗位</label>
                        <div class="col-md-4" id="writeJob" style="width: 15%;">
                            <input name="job" class="form-control " style = "width:100%" placeholder="请输入岗位">
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">线路选择</label>
                        <div class="col-md-4"  style="width: 15%;">
                            <select class="form-control " id="route1" name="bm" style = "width:100%">
                            </select>
                        </div>

                        <label type="button" class="btn btn-primary" style = "width:7%;    margin-left: 2%;" onclick="save()">确定</label>
                        <label type="button" class="btn btn-primary" style = "width:7%;    margin-left: 2%;" onclick="search()">查询</label>
                    </div>
                    <div class="form-group" style = "width:auto;margin-left:13%;" >
                    </div>
                    <div class="form-group" id="save" style = "width:auto;margin-left:20%;"></div>
                    <div class="form-group col-sm-12" style="margin-top:1%;   width: 82%; margin-left: 2%;" id="liable-details-div">
                        <table id="groupTable" class="table table-striped table-bordered table-hover">
                            <thead id="groupTable-thead" align="center">
                            <tr>
                                <td>序号</td>
                                <td>所属部门</td>
                                <td>岗位</td>
                                <td>线路</td>
                                <td>删除</td>
                            </tr>
                            </thead>
                            <tbody id="groupTable-tbody" align="center" class="liabletbody">
                            </tbody>
                        </table>
                    </div>

                </form>
            </div>
<#-- ----------------------------------------人员添加页面--------------------------------------------------->
            <div class="col-sm-12  form2" style=" display: none">

                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 8%;">
                    <div class="form-group" style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >工段选择</label>
                        <div class="col-md-4" style="width: 20%;" >
                            <select class="form-control" id="workshopUser2" name="bm" style = "width:100%" onchange="getUser()">
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >岗位选择</label>
                        <div class="col-md-4" style="width: 20%;">
                            <select class="form-control" id="job2" name="bm" style = "width:100%">
                            </select>
                        </div>
                        <label type="button" class="btn btn-primary" style = "width:8%;    margin-left: 1%;" onclick="searchUser()">查询</label>
                    </div>
                    <div class="form-group" style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >班组选择</label>
                        <div class="col-md-4" style="width: 20%;">
                            <select class="form-control" id="team" name="bm" style = "width:100%">
                                <option value="test">全部班组</option>
                                <option value="1">一班</option>
                                <option value="2">二班</option>
                                <option value="3">三班</option>
                                <option value="4">四班</option>
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >人员选择</label>
                        <div class="col-md-4" style="width: 20%;">
                            <select class="form-control" id="user2" name="bm" style = "width:100%">
                            </select>
                        </div>

                        <label type="button" class="btn btn-primary" style = "width:8%;    margin-left: 1%;" onclick="addUser()">添加用户</label>

                    </div>
                </form>

                <div class="form-group col-sm-12" style="margin-top:1%;width: 60%; margin-left: 21%;">
                    <table id="groupTable" class="table table-striped table-bordered table-hover">
                        <thead id="groupTable-thead" align="center">
                        <tr>
                            <td>序号</td>
                            <td>工段</td>
                            <td>岗位</td>
                            <td>班组</td>
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
<script type="text/javascript" src="/js/app/appConfig.js"></script>
</body>
</html>