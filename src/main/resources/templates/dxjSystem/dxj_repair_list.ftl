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
        #choose input{margin: 0px 0 0 10px}
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

    </style>
</head>
<body>
<div class="htmleaf-container" style="    padding: 1em 20px 1em;letter-spacing: -1px;">
	<!------页面主体---------------------------------------------------------------------------------------------->

    <nav class="navbar navbar-default">
        <ul class="nav nav-tabs nav-justified">
            <li id="li1" style="cursor: pointer"><a onclick="chooseItem('duty')">报警责任人配置</a></li>
            <li id="li2" style="cursor: pointer"><a onclick="chooseItem('manage')">报警分类管理人员配置</a></li>
            <li id="li3 "><a href="/spot/searchResult">返回上层</a></li>
        </ul>
    </nav><!-- /导航区域 -->
    <hr/>
	<div class="row">
 <!-----------------------------------------------------责任人---------------------------------------------------------------->
        <div class="col-sm-9" style="width:100%;">
            <div class="col-sm-12  form1" >
                <form  id="myform" name="myform" class="form-horizontal" role="form" style="margin-top:10px;    margin-left: 20%;">
                    <div class="form-group" style = "width:auto;margin-left:10%;    margin-right: -20%;">
                        <label for="ass_role_id" class="col-sm-2 control-label " style = "width:auto" >开始时间</label>
                        <div class="col-md-4" style="width: 18%;" >
                            <input class="form-control" id="dateStart" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                        </div>
                        <label for="ass_role_id" class="col-sm-2 control-label" style = "width:auto" >结束时间</label>
                        <div class="col-md-4" style="width: 18%;">
                            <input class="form-control" id="dateEnd" name="dateStart" type="text" placeholder="请选择" readonly style = "width:auto">
                        </div>

                    </div>
                    <div class="form-group" style = "width:auto;margin-left:10%;" >
                        <label for="ass_role_id" class="col-sm-2 control-label"  style = "width:auto">工段选择</label>
                        <div class="col-md-4"  style="width: 18%;">
                            <select class="form-control" id="workshop" name="bm" style = "width:100%" >
                            </select>
                        </div>
                        <label type="button" class="btn btn-primary" style = "width:23%;    margin-left: 7%;" onclick="search()">查询</label>
                    </div>
<script type="text/javascript">
    jeDate({
        dateCell:"#dateStart",
        format:"YYYY-MM-DD hh:mm:ss",
        // format:"YYYY-MM-DD 00:00:00",
        isinitVal:true,
        isTime:true, //isClear:false,
        initHour:-24,
        minDate:"1900-01-01 00:00:00",
        okfun:function(val){alert(val)}
    });
    jeDate({

        dateCell:"#dateEnd",
        // format:"YYYY-MM-DD 00:00:00",
        format:"YYYY-MM-DD hh:mm:ss",
        isinitVal:true,
        isTime:true, //isClear:false,
        minDate:"1900-01-01 00:00:00",
        okfun:function(val){alert(val)}
    });
    $.ajax({
        url: "/interlocking/deptName",
        data:[],
        type: "get",
        cache: true,
        dataType: "json",
        success: function (result) {
            var json = result.data;
            var str = "<option value='test'>"+'全部工段'+"</option>";
            var str1='';
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].deptName +"'>"+json[i].deptName+"</option>";
            }
            $('#workshop').empty().append(str);
        }
    });
    function search() {
        $.ajax({
            url: "/interlocking/repair/list",
            contentType: "application/json",
            data: JSON.stringify({
                "dateStart": $("#dateStart").val(),
                "dateEnd":$("#dateEnd").val(),
                "workShop":$("#workshop").val()
            }),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
                // $('.tbody').empty();
                // loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
            },
            success: function (result) {
                var json=result.data;
                if(json.length>0){
                    var str='';
                    for (var i=0;i<json.length;i++) {
                        str += '<tr><td>'+(i + 1) + '</td><td>'
                            + json[i].service_id+'</td><td>'
                            + json[i].dev_dept + '</td><td>'
                            + json[i].dev_name + '</td><td>'
                            + json[i].alarm_content + '</td><td>'
                            + json[i].service_alarm_name + '</td><td>'
                            + (json[i].service_alarm_time==null||json[0].service_alarm_time==''?'-':dateFormat(json[i].service_alarm_time,'yyyy-MM-dd  HH:mm:ss'))+ '</td><td>'
                            +'<input type="button" value="详情" style="cursor: pointer;" onclick="opendeal_modal(\''+json[i].result_id+'\')">'
                            +'</td></tr>';

                    }
                    $("#groupTable-tbody").empty().append(str);
                }
                else {
                    alert("无数据！")
                }
            },
            complete: function() {
                // layer.close(loading);
                // if (length==0){
                //     setTimeout('alert("无数据")','40')
                // }
            }
        });
    }
</script>
                    <div class="form-group col-sm-12" style="margin-top:1%;   width: 73%; margin-left: 2%;" id="liable-details-div">
                        <table id="groupTable" class="table table-striped table-bordered table-hover">
                            <thead id="groupTable-thead" align="center">
                            <tr>
                                <td>序号</td>
                                <td>处理单编号</td>
                                <td>部门</td>
                                <td>设备名称</td>
                                <td>报警内容</td>
                                <td>填报人</td>
                                <td>填报时间</td>
                                <td>详情</td>
                            </tr>
                            </thead>
                            <tbody id="groupTable-tbody" align="center" class="liabletbody">
                            </tbody>
                        </table>
                    </div>

                </form>
            </div>
            <div id="deal_modal_cover">
                <div id="deal_modal">
                    <div id="deal_modal_top">
                        <a style="margin-left: 90%;cursor:pointer"  onclick="closedeal_modal();">关闭</a>

                    </div>
                    <table cellpadding="0" cellspacing="0"   style="width: 90%; line-height: 20px; border: 2px solid ;    margin-left: 5%;
                    margin-top: 5%; ;text-align: center"
                           class="table table-striped table-bordered table-hover">
                        <caption style="font-size: 25px;line-height: 40px !important;font-weight: 600;text-align: center">故障处理单</caption>
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
                    <div class="form-group" id="choosePart2"  style = "width:auto;margin-left:20%;">
                        <label for="ass_role_id" id="" class="col-sm-2 control-label" style = "width:auto" >管理部门选择</label>
                        <div class="col-md-4" style="width: 35%;">
                            <label id="sksb" class="part" >碎矿设备<input type="checkbox" class="gdxz"  value="碎矿设备"></label>
                            <label id="mfsb" class="part">磨浮设备<input type="checkbox"  class="gdxz"  value="磨浮设备"></label>
                            <label id="jwsb" class="part">精尾设备<input type="checkbox"  class="gdxz"  value="精尾设备"></label>
                            <label id="dy"   class="part">电仪工段<input type="checkbox"  class="gdxz"  value="电仪工段"></label>
                            <label id="sksc"  class="part">碎矿生产<input type="checkbox"  class="gdxz"  value="碎矿生产"></label>
                            <label id="mfsc"  class="part">磨浮生产<input type="checkbox"  class="gdxz"  value="磨浮生产"></label>
                            <label id="jwsc"  class="part">精尾生产<input type="checkbox"  class="gdxz"  value="精尾生产"></label>
                            <label  class="part" style="white-space: pre">全       选<input type="checkbox"  class="allChoose2"  value="精尾生产"></label>
                        </div>
                        <label type="button" class="btn btn-primary" style = "width:8%;    margin-left: 1%;" onclick="addUser()">添加用户</label>
                    </div>
                    <script type="text/javascript">
                        $(".allChoose2").click(function(){
                            sameCheckedSet2($(this));
                        });
                        function sameCheckedSet2(eleInput){
                            var checkAll = $("#choosePart2 .allChoose2");
                            var checkItem = $("#choosePart2 .gdxz");
                            if(eleInput.is(".allChoose2")){
                                if( !eleInput.is(':checked') ){
                                    checkItem.prop("checked",false);
                                }else{
                                    checkItem.prop("checked",true);
                                }
                            }else if(eleInput.is(".gdxz")){
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
                </form>

                <div class="form-group col-sm-12" style="margin-top:1%;width: 60%; margin-left: 21%;">
                    <table id="groupTable" class="table table-striped table-bordered table-hover">
                        <thead id="groupTable-thead" align="center">
                        <tr>
                            <td>序号</td>
                            <td>所属部门</td>
                            <td>工号</td>
                            <td>用户</td>
                            <td>管理部门</td>
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
<script type="text/javascript" >
    function closedeal_modal(){
        document.getElementById("deal_modal_cover").style.display="none";
    }
    function opendeal_modal(data){
        document.getElementById("deal_modal_cover").style.display = "block";
        getDealData(data);
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
</body>
</html>