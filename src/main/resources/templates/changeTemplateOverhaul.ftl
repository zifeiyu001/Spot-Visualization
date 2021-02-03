<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <title>配置页面</title>
    <link rel="stylesheet" href="/css/mycss/table.css">
    <link rel="stylesheet" href="/css/css/bootstrap.css">
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/bootstrap-treeview.js"></script>
    <script src="/plugins/layer/layer.js" charset="utf-8"></script>
    <style>
        /*.choosedept input{    margin: -1px 11px 0;}*/
        /*#choose input{margin: 0px 0 0 10px};*/
        #module_cover{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
        }
        #module{
            position: absolute;
            width: 500px;
            height: 300px;
            margin-top: 2%;
            left: 50%;
            margin-left: -200px;
            background: #fff;
            border:1px solid #ddd;
            border-radius: 1%;
        }
        #module_top{
            width: 498px;
            height: 25px;
            position: relative;
        }
        #module_content{
            position: relative;
            width: 498px;
            height: 380px;
        }
        #module_close{
            position: absolute;
            right: 0px;
            top: 6px;
            display: block;
            width:40px;
            height: 19px;
            cursor: pointer;
        }
        #module_content table tbody tr{
            border: 1px solid #000;
        }
        #module_content table tbody tr td{
            border:1px solid #000;
        }

        #module_cover_add{
            display: none;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: #2222226e;
        }
        #module_add{
            position: absolute;
            width: 500px;
            height: 300px;
            margin-top: 2%;
            left: 50%;
            margin-left: -200px;
            background: #fff;
            border:1px solid #ddd;
            border-radius: 1%;
        }
        #module_top_add{
            width: 498px;
            height: 25px;
            position: relative;
        }
        #module_content_add{
            position: relative;
            width: 498px;
            height: 380px;
        }
        #module_close_add{
            position: absolute;
            right: 0px;
            top: 6px;
            display: block;
            width:40px;
            height: 19px;
            cursor: pointer;
        }
        #module_content_add table tbody tr{
            border: 1px solid #000;
        }
        #module_content_add table tbody tr td{
            border:1px solid #000;
        }
        body {height: 100% !important;}
        html{height: 100% !important;}
    </style>
</head>
<body>
<div class="htmleaf-container" style="  height: 100%;  padding: 1em 20px 1em;letter-spacing: -1px;">
	<!------页面主体---------------------------------------------------------------------------------------------->

	<div class="row" style="height: 100%">
 <!-----------------------------------------------------线路配置---------------------------------------------------------------->
        <div class="col-sm-9" style="width:100%;height: 100%">
<#-- ----------------------------------------人员添加页面--------------------------------------------------->
            <div class="col-sm-12  form2"  >

                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 8%;">
                    <div class="form-group" style = "width:auto;margin-left:5%;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >工段</label>
                        <div class="col-md-4" style = "width:20%">
                            <select class="form-control" id="workshop" name="bm" style = "width:100%" onclick="getDevName()">
                            </select>
                        </div>

                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >设备</label>
                        <div class="col-md-4" style = "width:20%">
                            <select class="form-control" id="equip" name="gnwz" style = "width:100%" onclick="getPartName()">
                            </select>
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >部位</label>
                        <div class="col-md-4" style = "width:20%">
                            <select class="form-control" id="part" name="djbw" style = "width:100%" onclick="getContent()">
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style = "width:auto;margin-left:5%;">

                    <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto">内容</label>
                        <div class="col-md-4" style = "width:20%">
                            <select class="form-control"  id="content" name="djnr"	 style = "width:100%">
                            </select>
                        </div>
                        <button type="button" class="btn btn-primary" style = "width: 18%;margin-left: 5%;margin-right: 7%;" onclick="search()">查询</button>
                        <button type="button" class="btn btn-primary" style = "width:18%" onclick="openModuleadd()">添加</button>
                    </div>
                </form>

                <div class="form-group col-sm-12" style="margin-top:1%;width: 90%; margin-left: 5%;">
                    <table id="groupTable" class="table table-striped table-bordered table-hover">
                        <thead id="groupTable-thead" align="center">
                        <tr>
                            <td>序号</td>
                            <td>工段</td>
                            <td>设备</td>
                            <td>部位</td>
                            <td>内容</td>
                            <td colspan="2">操作</td>
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
<#--报警类型选择遮盖层-->
<div id="module_cover">
    <div id="module">
        <div id="module_top">
            <a id="module_close" onclick="closeModule()">关闭</a>
        </div>
        <div id ="module_content">
            <table style="width: 90%;margin-left:5%;text-align: center;  line-height: 300%;">
                <thead id="groupTable-thead" align="center">
                <tr>
                    <td colspan="2" style="font-size: 24px">修改检修内容</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>工段</td>
                    <td id="overhaulDeptName"></td>
                </tr>
                <tr>
                    <td>设备</td>
                    <td><input type="text"  id="overhaulDevName" class="form-control"  style="width:100%;text-align: center;"></td>
                </tr>
                <tr>
                    <td>部位</td>
                    <td><input type="text"  id="overhaulPart" class="form-control"  style="width:100%;text-align: center"></td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td><input type="text"  id="overhaulContent" class="form-control"  style="width:100%;text-align: center"></td>
                </tr>
                </tbody>
                <tfoot>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td colspan="3" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeModule()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="changeData()" value="修改">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>

<div id="module_cover_add">
    <div id="module_add">
        <div id="module_top_add">
            <a id="module_close_add" onclick="closeModuleadd()">关闭</a>
        </div>
        <div id ="module_content_add">
            <table style="width: 90%;margin-left:5%;text-align: center;  line-height: 300%;">
                <thead id="groupTable-thead" align="center">
                <tr>
                    <td colspan="2" style="font-size: 24px">添加检修内容</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>工段</td>
                    <td >
                        <select id="overhaulDeptNameadd" class="form-control" style="text-align-last:center;"></select>
                    </td>
                </tr>
                <tr>
                    <td>设备</td>
                    <td><input type="text"  id="overhaulDevNameadd" class="form-control"  style="width:100%;text-align: center;"></td>
                </tr>
                <tr>
                    <td>部位</td>
                    <td><input type="text"  id="overhaulPartadd" class="form-control"  style="width:100%;text-align: center"></td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td><input type="text"  id="overhaulContentadd" class="form-control"  style="width:100%;text-align: center"></td>
                </tr>
                </tbody>
                <tfoot>
                <tr class="form-group" style = "width:auto;margin-left:5%;">
                    <td colspan="3" >
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 0%;"  onclick="closeModuleadd()" value="取消">
                        <input type="button" class="btn btn-primary" style = "width:24%; margin-left: 28%;" onclick="addData()" value="添加">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/changeTemplateOverhaul.js"></script>
</body>
</html>