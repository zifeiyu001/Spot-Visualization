<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#if Session.username??>
<script>
    var username="${Session.username}";
</script>
<#else >
    <script>
        var username="";
    </script>
</#if>
<html>
<head>
    <title>交接班</title>
    <link rel="stylesheet" href="/css/mycss/table.css">
    <link rel="stylesheet" href="/css/css/bootstrap.css">
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <script src="/plugins/jedate/jedate.js" charset="utf-8"></script>
    <script src="/js/utils/choosePath.js"></script>
    <script src="/js/echarts.min.js"></script>
    <script src="/js/bootstrap-treeview.js"></script>
    <style>
        .choosedept input{    margin: -1px 11px 0;}
        #choose input{margin: 0px 0 0 10px};
        .col-sm-12{width: 80% !important;margin-left: 20% !important;}
        #spotData tr{
            width: 100%;
            display: table;
        }
        #spotAlarm thead tr td,#spotAlarm tbody tr td{
            width: 20%;
        }
    </style>
</head>
<body>

<div style="font-size: 30px;text-align: center;    font-weight: 900;">石灰乳化岗</div>

<div class="htmleaf-container" style=" padding: 1em 20px 1em;letter-spacing: -1px;">

	<!------页面主体---------------------------------------------------------------------------------------------->
	<div class="row">
        <div class="col-sm-9" style="  width: 100%; " >
            <div class="col-sm-12  form1" style="width: 100% ;">
                <form   name="myform" class="form-horizontal" role="form" style="margin-top:10px; " action="">
                    <#--<div class="" style="margin-top:1%;">-->
                        <div style="height: 300px;display: inline-block;width: 30%"><div id="spot" style="height: 300px !important;width: 300px !important;"></div></div>
                        <div style="display: inline-block;width: 69%;height: 300px;">
                            <table id="spotAlarm" class="table table-striped table-bordered table-hover" style="    display: table; width: 100%;">

                                <thead id="groupTable-tbody" align="center" style="display: table; width:calc( 100% - 1.1em );">
                                <tr>
                                    <#--<td colspan="1" width="300px" >点检统计</td>-->
                                    <td colspan="5" >报警数据</td>
                                </tr>
                                <tr>
                                    <td>序号</td>
                                    <td>设备名称</td>
                                    <td>部位</td>
                                    <td>内容</td>
                                    <td>结果</td>
                                </tr>
                                </thead>
                                <tbody id="spotData" style="    display: block;overflow: scroll; height: 200px; width: 100%;">

                                </tbody>

                            </table>
                        </div>

                    <div class="form-group"  style = "width:auto;display: inline-block;">
                        <label for="name" class="col-sm-2 control-label" style = "width:auto">班组</label>
                        <div class="col-md-4" style = "width:20%">
                            <input class="form-control" id="team" name="team" readonly type="text"   style = "width:auto">
                        </div>
                    </div>
                    <div class="form-group"  style = "width:auto;float:right;display: inline-block;">
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >日期</label>
                        <div class="col-md-4" style = "width:20%">
                            <input class="form-control" id="date" name="dete" readonly type="text"   style = "width:auto">
                        </div>
                        <label for="name" class="col-sm-2 control-label" style = "width:auto;margin-left: 19%">班次</label>
                        <div class="col-md-4" style = "width:20%">
                            <input class="form-control " id="shift" name="shift" readonly type="text"   style = "width:auto">
                        </div>
                    </div>
                    <div class="" style="margin-top:1%;">

                        <table id="groupTable" class="table table-striped table-bordered table-hover">

                            <tbody id="groupTable-tbody" align="center" class="liabletbody">
                                <tr>
                                    <td colspan="4">1#料罐 </td>
                                    <td colspan="4">2#料罐 </td>
                                </tr>
                                <tr>
                                    <td rowspan="2">料罐料位 </td>
                                    <td >接班（m） </td>
                                    <td >交班（m） </td>
                                    <td >送料车数（车）</td>
                                    <td rowspan="2">料罐料位 </td>
                                    <td >接班（m） </td>
                                    <td >交班（m） </td>
                                    <td >送料车数（车）</td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="pot1successionlevel" name="pot1successionlevel"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pot1shiftlevel" name="pot1shiftlevel"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="cars1"  name="cars1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pot2successionlevel" name="pot2successionlevel"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pot2shiftlevel"  name="pot2shiftlevel"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="cars2" name="cars2"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td colspan="4">1#螺旋给料机运行情况</td>
                                    <td colspan="4">2#螺旋给料机运行情况</td>
                                </tr>
                                <tr>
                                    <td >开机时间 </td>
                                    <td >停机时间</td>
                                    <td >螺旋转速（Hz） </td>
                                    <td >给水量（m³）</td>
                                    <td >开机时间 </td>
                                    <td >停机时间</td>
                                    <td >螺旋转速（Hz） </td>
                                    <td >给水量（m³）</td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="feeder1start1" name="feeder1start1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1end1" name="feeder1end1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1speed1" name="feeder1speed1"  class="form-control shift "  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1water1" name="feeder1water1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2start1" name="feeder2start1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2end1" name="feeder2end1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2speed1" name="feeder2speed1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2water1" name="feeder2water1"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="feeder1start2" name="feeder1start2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1end2"   name="feeder1end2"    class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1speed2" name="feeder1speed2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1water2" name="feeder1water2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2start2" name="feeder2start2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2end2"   name="feeder2end2"    class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2speed2" name="feeder2speed2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2water2" name="feeder2water2"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="feeder1start3" name="feeder1start3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1end3"   name="feeder1end3"    class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1speed3" name="feeder1speed3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1water3" name="feeder1water3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2start3" name="feeder2start3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2end3"   name="feeder2end3"    class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2speed3" name="feeder2speed3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2water3" name="feeder2water3"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="feeder1start4"  name="feeder1start4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1end4"    name="feeder1end4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1speed4"  name="feeder1speed4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder1water4"  name="feeder1water4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2start4"  name="feeder2start4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2end4"    name="feeder2end4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2speed4"  name="feeder2speed4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="feeder2water4"  name="feeder2water4"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td rowspan="2">石灰泵运行时间</td>
                                    <td >1#泵（h） </td>
                                    <td >2#泵（h） </td>
                                    <td >3#泵（h） </td>
                                    <td >送尾矿库时间（h）</td>
                                    <td colspan="3"><input type="text" id="tailingpondtime " name="tailingpondtime "  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="limepump1runtime" name="limepump1runtime"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="limepump2runtime" name="limepump2runtime"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="limepump3runtime" name="limepump3runtime"  class="form-control shift"  style="width:100%;"></td>
                                    <td >送污水调节时间（h）</td>
                                    <td colspan="3"><input type="text" id="sewageregulationtime" name="sewageregulationtime"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td >设备润滑点检情况</td>
                                    <td colspan="3"><textarea  id="equipmentlubrication" name="equipmentlubrication"  class="form-control shift"  style="width:100%;"></textarea></td>
                                    <td >机台卫生情况</td>
                                    <td colspan="3"><textarea  id="machinesanitation" name="machinesanitation"  class="form-control shift"  style="width:100%;"></textarea></td>
                                </tr>
                                <tr>
                                    <td >检查时间 </td>
                                    <td >1#料罐</td>
                                    <td >2#料罐 </td>
                                    <td >螺旋给料机</td>
                                    <td >3m搅拌器 </td>
                                    <td >4m搅拌器 </td>
                                    <td >渣浆泵</td>
                                    <td >电机</td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="checktime1" name="checktime1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank1check1" name="materialtank1check1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank2check1"  name="materialtank2check1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="screwfeedercheck1" name="screwfeedercheck1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum3mcheck1" name="mixingdrum3mcheck1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum4mcheck1"  name="mixingdrum4mcheck1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pumpcheck1" name="pumpcheck1"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="electricmachinerycheck1" name="electricmachinerycheck1"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="checktime2" name="checktime2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank1check2" name="materialtank1check2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank2check2" name="materialtank2check2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="screwfeedercheck2" name="screwfeedercheck2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum3mcheck2" name="mixingdrum3mcheck2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum4mcheck2" name="mixingdrum4mcheck2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pumpcheck2" name="pumpcheck2"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="electricmachinerycheck2" name="electricmachinerycheck2"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="checktime3" name="checktime3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank1check3"  name="materialtank1check3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank2check3" name="materialtank2check3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="screwfeedercheck3" name="screwfeedercheck3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum3mcheck3" name="mixingdrum3mcheck3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum4mcheck3"  name="mixingdrum4mcheck3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pumpcheck3" name="pumpcheck3"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="electricmachinerycheck3" name="electricmachinerycheck3"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td ><input type="text" id="checktime4" name="checktime4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank1check4" name="materialtank1check4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="materialtank2check4"  name="materialtank2check4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="screwfeedercheck4" name="screwfeedercheck4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum3mcheck4" name="mixingdrum3mcheck4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="mixingdrum4mcheck4" name="mixingdrum4mcheck4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="pumpcheck4" name="pumpcheck4"  class="form-control shift"  style="width:100%;"></td>
                                    <td ><input type="text" id="electricmachinerycheck4"  name="electricmachinerycheck4"  class="form-control shift"  style="width:100%;"></td>
                                </tr>
                                <tr>
                                    <td colspan="4">生产情况及其他</td>
                                    <td colspan="4">设备运转情况</td>
                                </tr>
                                <tr>
                                    <td colspan="4"><textarea  id="production" name="production"  class="form-control shift"  style="width:100%;"></textarea></td>
                                    <td colspan="4"><textarea  id="equipmentoperation" name="equipmentoperation"  class="form-control shift"  style="width:100%;"></textarea></td>
                                </tr>
                                <tr>
                                    <td colspan="4">交班记录</td>
                                    <td colspan="4">接班记录</td>
                                </tr>
                                <tr>
                                    <td colspan="4"><textarea  id="shiftremark" name="shiftremark"  class="form-control  shift"  style="width:100%;"></textarea></td>
                                    <td colspan="4"><textarea  id="successionremark" name="successionremark"  class="form-control  succession"  style="width:100%;"></textarea></td>
                                </tr>
                                <tr>
                                    <td >交班人</td>
                                    <td colspan="3"><input type="text" id="shiftname" name="shiftname" readonly class="form-control  shift"  style="width:100%;"></td>
                                    <td >接班人</td>
                                    <td colspan="3"><input type="text" id="successionname" name="successionname" readonly class="form-control succession"  style="width:100%;"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </form>
                <div class="modal-footer" style="padding: 15px; text-align: right; bottom: 0;right: 0;margin-right: 3%;margin-bottom: -1%;">
                    <button type="button" class="btn btn-primary button"  onclick="save()">确定</button>
                    <button type="button" class="btn btn-primary shiftButton"  onclick="shiftData()">交班</button>
                    <button type="button" class="btn btn-primary successionButton"   onclick="successionData()">接班</button>
                </div>
            </div>
        </div>
	</div>
</div>
<script type="text/javascript" src="/js/changeShifts/sk-sh-1.0.0.js"></script>
<script type="text/javascript">

</script>
</body>
</html>