jeDate({
    dateCell:"#dateStart",
    // format:"YYYY-MM-DD hh:mm:ss",
    format:"YYYY-MM-DD",
    isinitVal:true,
    isTime:true,
    isClear:false,
    initHour:-24,
    minDate:"1900-01-01"
});



//================判断班组是否为生产，显示选项班次========================
function chooseSC() {
    var workshop_name = $("select[name='workshop_name']");
    var team_name = $("select[name='team_name']");
    val1 =arr_team[workshop_name.val()][team_name.val()];

    if(val1=="碎矿生产"||val1=="磨浮生产"||val1=="精尾生产"){

        document.getElementById("select").style.display='';
    }
    else {
        document.getElementById("select").style.display='none';
    }
}
function search(){
    // alert(end);
    var time=$("#dateStart").val();
    // var start=$("#startDate").val();
    // var end=$("#endDate").val();
    //=============工段选择==========================
    var workshop_name = $("select[name='workshop_name']");
    if(workshop_name.val()!='')
    {
        var val1 = arr_workshop[workshop_name.val()];
    }
    else {
        alert("请选择工段！");
        return;
    }
    //============班组选择=============================
    var team_name = $("select[name='team_name']");

    if(team_name.val()!=''){
        // alert(team_name.val());
        var val2 = arr_team[workshop_name.val()][team_name.val()];
    }
    else {
        alert("请选择班组！");
        return;
    }

    //==============设备选择内容============================
    var equip_name = $("select[name='equip_name']");
    if(equip_name.val()!=''){
        var val3 = arr_equip[workshop_name.val()][team_name.val()][equip_name.val()];
        //判断是否是生产并判断是否选择
        if(val2=="碎矿生产"||val2=="磨浮生产"||val2=="精尾生产"){
            var duty_name = $('#duty option:selected').text();
            if(duty_name==''){
                alert("请选择班次！");
                return;
            }
        }
    }
    else {
        alert("请选择设备/岗位！");
        return;
    }

    if(time ==''){

        alert("请选择日期！");
        return;
    }
    else {

        //==============清空表格内容=====================
        $("#tables").load(location.href + " #tables");

            chaxun(val1,val2,val3,time,duty_name);

    }
}

function chaxun(workshop,team,equip,time,duty_name){
    var loading='';
    $.ajax({
        type : "post",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/report/day",    //请求发送到TestServlet处
        contentType: "application/json",
        data:JSON.stringify({
            "workshop":workshop,
            "team":team,
            "equip":equip,
            "time":time,
            "duty_name":duty_name
        }),
        dataType : "json",
        layerIndex: -1,
        beforeSend: function() {
             loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success : function(result) {
            var spots = '';
            var data = result.equipRun;       //设备运行
            var data1 = result.spotData;    //点检统计
            var data2 = result.dealData;   //缺陷处理

            var sc_content = '';
            var title = '';
            var rootTableData = '';
            var sc_content1='';


            //=========================通用点检统计======================

            var zong = data1[0].zong;   //需点检的总数
            var wjian = data1[0].wjian;    //未检的数量
            var zchang = data1[0].zchang;   //正常的数量
            var bjing = data1[0].bjing;    //报警的数量
            var wxian = data1[0].wxian;    //危险的数量
            if ( zong==0){
                alert("当日无点检内容，无数据...");
            }
            var wjbili = ((wjian / zong) * 100).toFixed(2);   //危险的比例
            if (wjbili == 'NaN') {
                wjbili = 0;
            }
            var zcbili = ((zchang / zong) * 100).toFixed(2);    //正常的比例
            if (zcbili == 'NaN') {
                zcbili = 0;
            }
            var bjbili = ((bjing / zong) * 100).toFixed(2);   //报警的比例
            if (bjbili == 'NaN') {
                bjbili = 0;
            }
            var wxbili = ((wxian / zong) * 100).toFixed(2);   //危险的比例
            if (wxbili == 'NaN') {
                wxbili = 0;
            }
            spots = '<tr style="text-align: center"><td colspan="2"  style="  border: 1px solid ;width: 20%;">' + zong + '</td><td  style="  border: 1px solid ;">'
                + wjian + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + wjbili + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + zchang + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + zcbili + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + bjing + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + bjbili + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + wxian + '</td><td  style="  border: 1px solid ;width: 10%;">'
                + wxbili
                + '</td></tr>';

            $('.spot').append(spots);

//=======================设备报表内容===================
            if (team == "碎矿设备" || team == "磨浮设备" || team == "精尾设备" || team == "碎矿电仪" || team == "磨浮电仪" || team == "精尾电仪") {
                $("#titleName").html(team+" "+ equip+" "+"日报表");

                title += '<th colspan="2"  style="background-color: lightcyan ;border: 1px solid ; min-width: 70px;">'
                    + "设备编码" + '</th><td colspan="2" id="bianhao" style="  border: 1px solid ;text-align: center">'
                    + '</td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">'
                    + "主机设备名称" + '</th><td colspan="2" id="zhushebei" style="  border: 1px solid ;text-align: center">'
                     + '</td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">'
                    + "附属设备" + '</th> <td colspan="2" id="fuzhushebei" style="  border: 1px solid ;text-align: center">' + '</td>';

                $('#biaoti').append(title);



                //设备运行状态
                var contentData = '';
                var tableData = '';
                for (var a = 0; a < data.length - 1; a++) {
                    // var bw=data[a].result.;
                    var dept = data[a].equipName; //当前的设备名称
                    var dept1 = data[a + 1].equipName; //下一个的设备名称

                    if (dept == dept1) {

                        contentData += partLocation(data[a].part) + '&#12288;<u>' + isNumber(dept, data[a].part, data[a].result, data[a].altpid) + '</u>&#12288;' + alarm(data[a].altpid) + "；" + '&#12288;';

                        if (a == data.length - 2) {
                            contentData += partLocation(data[a + 1].part) + '&nbsp;<u>' + isNumber(dept, data[a + 1].part, data[a + 1].result, data[a + 1].altpid) + '</u>&nbsp;' + alarm(data[a + 1].altpid) + "；" + '&nbsp;';

                            if (team != '精尾设备') {

                                tableData += '<tr><td colspan="2" class="backgroundColor1" style="background-color: lightcyan ;border: 1px solid ;text-align: center; ">' + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                    + contentData +
                                    '</td></tr>';

                            } else {
                                tableData += '<tr ><td  class="backgroundColor1" style="background-color: lightcyan ;border: 1px solid text-align: center;width: 10%;">' + data[a].zoneName + '</td><td class="backgroundColor1"  style="  border: 1px solid ;text-align: center;">' + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                    + contentData +
                                    '</td></tr>';
                            }
                            $('#run').append(tableData);
                        }

                    } else {
                        contentData += partLocation(data[a].part) + '&nbsp;<u>' + isNumber(dept, data[a].part, data[a].result) + '</u>&nbsp;' + alarm(data[a].altpid) + "；" + '&nbsp;';

                        if (team != '精尾设备') {

                            tableData += '<tr><td colspan="2" class="backgroundColor1" style="background-color: lightcyan ;text-align: center;border: 1px solid;">' + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                + contentData +
                                '</td></tr>';

                        } else {

                            tableData += '<tr ><td class="backgroundColor1" style="background-color: lightcyan ;text-align: center;border: 1px solid ;width: 10%;">' + data[a].zoneName + '</td><td class="backgroundColor1"  style="  border: 1px solid ;text-align: center;">' + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                + contentData +
                                '</td></tr>';
                        }
                        $('#run').append(tableData);
                        contentData = '';
                        tableData = '';
                    }
                }
                rootTableData += '<th colspan="2"  style="background-color: lightcyan ;border: 1px solid ;">'
                    + "设备评价" + '</th><td colspan="4" id="equip_appraise" style="  border: 1px solid !important;"></td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">'
                    + "点检人" + '</th><td colspan="1" id="spot_name" style="  border: 1px solid !important;"></td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid;">'
                    + "时间" + '</th><td colspan="1" id="time" style="  border: 1px solid ;"></td>';
                $('#footTable').append(rootTableData);
                $("#equip_appraise").html(appraise(zchang, wxian, bjing, wjian));
                $("#spot_name").html(data1[0].name);
                $("#time").html(time);
                rootTableData = '';
            }


            //===========================生产报表内容====================
            else {
                title += '<th colspan="1"  style="background-color: lightcyan ;border: 1px solid ; min-width: 70px;">'
                    + "班别" + '</th><td colspan="2" id="banzu" style="  border: 1px solid ;text-align: center">'
                    + '</td><th colspan="1"   style="background-color: lightcyan ;border: 1px solid ;">'
                    + "日期" + '</th><td colspan="2" id="time" style="  border: 1px solid ;text-align: center">'
                    + '</td><td colspan="1"  id="zhici" style=";border: 1px solid ;text-align: center">'
                    + '</td><th colspan="2"    style="background-color: lightcyan ;border: 1px solid ;">'
                    + "点检人" + '</td><td colspan="1"  id="spot_name"  style="border: 1px solid ;text-align: center">'
                    + '</td>';
                $('#biaoti').append(title);
                $("#banzu").html(data1[0].teamName);
                $("#spot_name").html(data1[0].name);
                $("#time").html(time);
                $("#zhici").html(duty_name);

                //标题
                $("#titleName").html(team+" "+ equip+" "+duty_name+"报表");

                if((team=='碎矿生产' && equip=='皮带岗')){

                    for (var m = 0; m < data.length; m++) {

                        sc_content += '<tr style="text-align: center;border: 1px solid ;"><td colspan="2" style="text-align: center;">'
                            + data[m].zoneName + '</td><td colspan="2" style="border: 1px solid ;text-align: center;"> '
                            + data[m].equipName + '</td><td colspan="3" style="border: 1px solid ;" >'
                            + judgeEquip(data[m].oneNum) + '</td><td colspan="3" style="border: 1px solid ;">'
                            + judgeEquip(data[m].twoNum) + '</td></tr>';
                    }

                }
                else if(team=='精尾生产'){
                    for (var m = 0; m < data.length; m++) {

                        sc_content += '<tr style="text-align: center;border: 1px solid ;"><td colspan="2" style="text-align: center;">'
                            + data[m].zoneName + '</td><td colspan="2" style="border: 1px solid ;text-align: center;"> '
                            + data[m].equipName + '</td><td colspan="6" style="border: 1px solid ;" >'
                            + judgeEquip(data[m].oneNum) + '</td></tr>';
                    }
                }
                else {
                       for (var m = 0; m < data.length; m++) {

                            sc_content += '<tr style="text-align: center;border: 1px solid ;"><td style="text-align: center;border: 1px solid ;">'
                                + (m + 1) + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                                + data[m].equipName + '</td><td colspan="3" style="border: 1px solid ;" >'
                                + judgeEquip(data[m].oneNum) + '</td><td colspan="3" style="border: 1px solid ;">'
                                + judgeEquip(data[m].twoNum) + '</td></tr>';
                        }
                }
//======================生产点检时间选择=========================
                if(duty_name=='白班') {
                    if (team=='精尾生产'){
                        sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                            + "时间" + '</td><td colspan="6" style="border: 1px solid ;text-align: center;"> '
                            + "08:00-19:59" + '</td></tr>' + sc_content;
                    } else {
                        sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                            + "时间" + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                            + "08:00-13:59" + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                            + "14:00-19:59" + '</td></tr>' + sc_content;
                    }

                }
                else {
                    if (team=='精尾生产'){
                        sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                            + "时间" + '</td><td colspan="6" style="border: 1px solid ;text-align: center;"> '
                            + "20:00-07:59" + '</td></tr>' + sc_content;
                    } else {
                        sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                            + "时间" + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                            + "20:00-23:59" + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                            + "00:00-07:59" + '</td></tr>' + sc_content;
                    }

                }

                $('#run').append(sc_content1);
                sc_content = '';
            }


 //=======================通用缺陷处理======================================
            equipCode(workshop,team,equip);
            var deal_Content = '';
            if (data2.length != 0) {

                for (var b = 0; b < data2.length; b++) {

                    deal_Content += '<tr><td style="text-align: center;border: 1px solid ;">' + (b + 1) + '</td><td colspan="3" style="border: 1px solid ;text-align: center;">'
                        + data2[b].content + '</td><td colspan="1" style="border: 1px solid ;text-align: center;">'
                        + data2[b].uploadTime.split(".")[0] + '</td><td style="border: 1px solid ;text-align: center;">'
                        + deal(data2[b].deal) + '</td><td colspan="2" style="border: 1px solid ;text-align: center;">'
                        + dealResult(data2[b].dealResult) + '</td><td style="border: 1px solid ;text-align: center;">'
                        + dealResult(data2[b].dealName) + '</td><td style="border: 1px solid ;text-align: center;">'
                        + dealResultTime(data2[b].dealTime) + '</td></tr>';
                }
                $('#fault').append(deal_Content);
            } else {


                deal_Content += '<tr style="text-align: center;border: 1px solid ;"><td style="text-align: center;">' + 1 + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> ' + '无'
                    + '</td><td colspan="1" style="border: 1px solid ;" >'
                    + '</td><td style="border: 1px solid ;">'
                    + '</td><td colspan="2" style="border: 1px solid ;">'
                    + '</td><td style="border: 1px solid ;">'
                    + '</td><td style="border: 1px solid ;">'
                    + '</td></tr>';

                $('#fault').append(deal_Content);
            }
        },



        complete: function() {

            layer.close(loading);
            if(team=='精尾设备'||team=='精尾生产'||(team=='碎矿生产' && equip=='皮带岗')) {
                setTimeout(autoRowSpan(run, 0, 0),1000);
                // autoRowSpan(run, 0, 0);

            }
        }

    });

}
//=============设备报表设备参数=================
function equipCode(val1,val2,val3){

    if ((val1 != '电仪工段')) {
        if (val3 == '再磨机') {
            $("#zhushebei").html("MQY2745再磨机");
            $("#bianhao").html("MK-203-01<br> FJ-203");
            $("#fuzhushebei").html(" FX350-GT旋流器");
        }
        else if (val3 == '半自磨机') {
            $("#zhushebei").html("MZS6433半自磨机");
            $("#bianhao").html("MK-201-01<br>FJ-202-01<br>FJ-202-02");
            $("#fuzhushebei").html("1#离心式渣浆泵(粗砂泵)&nbsp;&nbsp;&nbsp;&nbsp;2#离心式渣浆泵(粗砂泵)");
        }
        else if (val3 == '球磨机') {
            $("#zhushebei").html("MQY4870球磨机");
            $("#bianhao").html("MK-202-01");
            $("#fuzhushebei").html(" FX660-GT旋流器");
        }
        else if (val3 == '中板皮带') {
            $("#zhushebei").html("5#皮带运输机");
            $("#bianhao").html("GK-202-01<br>GK-201-01<br>GK-201-02");
            $("#fuzhushebei").html("1#中重型板式给料机&nbsp;&nbsp;&nbsp;&nbsp;2#中重型板式给料机");
        }
        else if (val3 == '鼓风机') {
            $("#zhushebei").html("1#离心式鼓风机");
            $("#bianhao").html("FX-212-01<br>FX-212-02<br> FX-212-03");
            $("#fuzhushebei").html("2#离心式鼓风机&nbsp;&nbsp;&nbsp;&nbsp;3#离心式鼓风机");
        }
        else if (val3 == '浮选机') {
            $("#zhushebei").html("浮选机");
            $("#bianhao").html("FX-201<br>FX-216<br>FX-215-01<br> FX-215-02");
            $("#fuzhushebei").html("脱泥旋流器&nbsp;&nbsp;&nbsp;&nbsp;1#脱泥泵&nbsp;&nbsp;&nbsp;&nbsp;2#脱泥泵");
        }
        // else if (val3 == '浮选泵') {
        //     $("#zhushebei").html("1#离心式鼓风机");
        //     $("#bianhao").html("FX-212-01<br>FX-212-02<br> FX-212-03");
        //     $("#fuzhushebei").html("2#离心式鼓风机&nbsp;&nbsp;&nbsp;&nbsp;3#离心式鼓风机");
        // }
        //精尾设备
        else if (val3 == '过滤机') {
            $("#zhushebei").html("1#TT-80陶瓷过滤机");
            $("#bianhao").html("TS-204-01<br>TS-204-02");
            $("#fuzhushebei").html(" 2#TT-80陶瓷过滤机");
        }
        else if (val3 == '压滤机') {
            $("#zhushebei").html("1#高效节能快速压滤机");
            $("#bianhao").html("TS-201-01<br> TS-202-01<br> TS-203-01");
            $("#fuzhushebei").html(" 2#程控隔膜压滤机&nbsp;&nbsp;&nbsp;&nbsp;3#APN型压滤机");
        }

        else if (val3 == '尾砂泵') {
            $("#zhushebei").html("1#尾砂泵<br>2#尾砂泵&nbsp;&nbsp;3#尾砂泵");
            $("#bianhao").html("TS-201-01<br> TS-201-02&nbsp;TS-201-03");
            // $("#fuzhushebei").html("2#尾砂泵&nbsp;&nbsp;&nbsp;&nbsp;3#尾砂泵");
        }
        else if (val3 == '空压机') {
            $("#zhushebei").html("1#螺杆式空气压缩机<br>2#螺杆式空气压缩机&nbsp;&nbsp;&nbsp;&nbsp;3#螺杆式空气压缩机<br>4#螺杆式空气压缩机&nbsp;&nbsp;&nbsp;&nbsp;5#螺杆式空气压缩机");
            $("#bianhao").html("KQ-001-01<br>KQ-001-02&nbsp;&nbsp; KQ-001-03<br>KQ-001-23&nbsp;&nbsp;KQ-001-25");

            // $("#fuzhushebei").html("2#螺杆式空气压缩机&nbsp;&nbsp;&nbsp;&nbsp;3#螺杆式空气压缩机<br>4#螺杆式空气压缩机&nbsp;&nbsp;&nbsp;&nbsp;5#螺杆式空气压缩机");
        }
        else if (val3 == '浓密机') {
            $("#zhushebei").html("铜浓密机");
            $("#bianhao").html("NS-201-01&nbsp;&nbsp NS-202-01<br>NS-203-01&nbsp;&nbspNS-204-01");

            $("#fuzhushebei").html("硫浓密机 &nbsp;&nbsp;&nbsp;&nbsp;尾矿浓密机&nbsp;&nbsp;&nbsp;&nbsp;事故浓密机");
        }
        else if (val3 == '厂前回水泵') {
            $("#zhushebei").html("1#卧式中开双吸泵");
            $("#bianhao").html("HS-201-04&nbsp;&nbspHS-201-05<br>HS-201-06&nbsp;&nbspHS-201-03");
            $("#fuzhushebei").html("2#卧式中开双吸泵<br>3#卧式中开双吸泵&nbsp;&nbsp;&nbsp;&nbsp;冷却水收集离心泵");
        }
        //碎矿设备
        else if (val3 == '重板') {
            $("#zhushebei").html("B1800*10000mm重型板式给料机");
            $("#bianhao").html("WK-201-01<br>WK-201-02<br>WK-201-03");
            $("#fuzhushebei").html(" TD75-500带式输送机(1#)");
        }

        else if (val3 == '颚破') {
            $("#zhushebei").html("PEJ1200*1500简摆颚式破碎机");
            $("#bianhao").html("PS-001-01<br>PS-001-02");
            $("#fuzhushebei").html(" SX-16型湿式三效除尘器");
        }
        else if (val3 == '2#皮带') {
            $("#zhushebei").html("DT75-1200带式输送机（2#）");
            $("#bianhao").html("GK-002-01");

        }
        else if (val3 == '4#皮带') {
            $("#zhushebei").html("DT75-1200带式输送机（4#）");
            $("#bianhao").html("GK-003-01");

        }
        else if (val3 == '石灰制乳输送') {
            $("#zhushebei").html("精石灰制乳系统");
            // $("#bianhao").html("GK-003-01");
        }
    }
    else {
        if (val3 == '皮带中板') {
            $("#zhushebei").html("5#皮带运输机电机");
            $("#bianhao").html("GK-202-01<br>GK-201-01<br>GK-201-02");
            $("#fuzhushebei").html("1#中重型板式给料机电机&nbsp;&nbsp;&nbsp;&nbsp;2#中重型板式给料机电机");
        }
        else if (val3 == '3M石灰') {
            $("#zhushebei").html("石灰浆搅拌桶电机");
            $("#bianhao").html("SH-003-01<br>SH-003-02<br>SH-003-03");
            $("#fuzhushebei").html("1#石灰搅拌桶加压电机&nbsp;&nbsp;&nbsp;&nbsp;2#石灰搅拌桶加压电机");
        }
        else if (val3 == '浮选机') {
            $("#zhushebei").html("浮选机电机");
            $("#bianhao").html("FX-201");
            // $("#fuzhushebei").html("1#石灰搅拌桶加压电机&nbsp;&nbsp;&nbsp;&nbsp;2#石灰搅拌桶加压电机");
        }
        else if (val3 == '浮选泵') {
            $("#zhushebei").html("浮选底层电机");
            // $("#bianhao").html("FX-201");
            $("#fuzhushebei").html("浮选柱电机&nbsp;&nbsp;&nbsp;&nbsp;再磨砂泵电机");
        }
        else if (val3 == '球磨机') {
            $("#zhushebei").html("MQY4870球磨机电机");
            $("#bianhao").html("MK-202-01-01");
            // $("#fuzhushebei").html("浮选柱电机&nbsp;&nbsp;&nbsp;&nbsp;再磨砂泵电机");
        }
        else if (val3 == '再磨机') {
            $("#zhushebei").html("MQY2745再磨机电机");
            $("#bianhao").html("MK-203-01-01");
            // $("#fuzhushebei").html("浮选柱电机&nbsp;&nbsp;&nbsp;&nbsp;再磨砂泵电机");
        }
        else if (val3 == '半自磨机') {
            $("#zhushebei").html("MZS6433半自磨机电机");
            $("#bianhao").html("MK-201-01<br>FJ-202-01<br>FJ-202-02");
            $("#fuzhushebei").html("1#离心式渣浆泵电机(粗砂)&nbsp;&nbsp;&nbsp;&nbsp;2#离心式渣浆泵电机(粗砂)");
        }
        else if (val3 == '重板颚破') {
            $("#zhushebei").html("简摆颚式破碎机电机");
            $("#bianhao").html("PS-001-01<br>PS-001-02<br>GK-001-01");
            $("#fuzhushebei").html("湿式除尘风机电机&nbsp;&nbsp;&nbsp;&nbsp;重型板式给料机电机");
        }
        else if (val3 == '2#4#皮带') {
            $("#zhushebei").html("2#皮带运输机电机");
            $("#bianhao").html("GK-002-01<br>GK-002-02");
            $("#fuzhushebei").html("4#皮带运输机电机");
        }

        else if (val3 == '鼓风机') {
            $("#zhushebei").html("1#离心式鼓风机电机");
            $("#bianhao").html("FX-212-01<br>FX-212-02<br> FX-212-03");
            $("#fuzhushebei").html("2#离心式鼓风机电机&nbsp;&nbsp;&nbsp;&nbsp;3#离心式鼓风机电机");
        }

        else if (val3 == '石灰输送') {
            $("#zhushebei").html("石灰乳化电机");
            $("#bianhao").html("SH-001<br>SH-002");
            $("#fuzhushebei").html("石灰制乳搅拌桶电机&nbsp;&nbsp;&nbsp;&nbsp;石灰输送搅拌桶电机");
        }
        else if (val3 == '浓密机') {
            $("#zhushebei").html("浓密机电机");
            $("#bianhao").html("NS-201<br>NS-202<br>NS-203<br>NS-204");
            $("#fuzhushebei").html("铜浓密机NJ30B电机&nbsp;&nbsp;&nbsp;&nbsp;硫浓密机NJ45S电机<br>尾矿浓密机NXZ-45D电机&nbsp;&nbsp;&nbsp;&nbsp;事故浓密机NJG-18电机");
        }
        else if (val3 == '压滤过滤') {
            $("#zhushebei").html("压滤机电机");
            $("#bianhao").html("TS-203-01<br>TS-204-01<br>TS-204-02");
            $("#fuzhushebei").html("1#TT-80陶瓷过滤机&nbsp;&nbsp;&nbsp;&nbsp;2#TT-80陶瓷过滤机");
        }
        else if (val3 == '空压机') {
            $("#zhushebei").html("1#螺杆式空气压缩机电机");
            $("#bianhao").html("KQ-001-01<br>KQ-001-02<br>KQ-001-03<br>KQ-001-23<br>KQ-001-25");
            $("#fuzhushebei").html("2#螺杆式空气压缩机电机&nbsp;&nbsp;&nbsp;&nbsp;3#螺杆式空气压缩机电机<br>4#螺杆式空气压缩机电机&nbsp;&nbsp;&nbsp;&nbsp;5#螺杆式空气压缩机电机");
        }
    }

}



//合并单元格
function autoRowSpan(run,row,col)
{
    var lastValue="";
    var value="";
    var pos=1;
    for(var i=row;i<run.rows.length;i++){

        value = run.rows[i].cells[col].innerText;
        if(lastValue == value){
            run.rows[i].deleteCell(col);
            run.rows[i-pos].cells[col].rowSpan = run.rows[i-pos].cells[col].rowSpan+1;
            pos++;
        }else{
            lastValue = value;
            pos=1;
        }
    }

}
//设备状态指示
function alarm(alarmNumber) {
    if (alarmNumber==0){
        return   '<b style="color:#13ff12 " >'+'正'+'</b>'
        // '<span class="green">'+'√'+'</span>'
    }
    else if(alarmNumber==1 ){
        return  '<b style="color: #ff8a18">'+'警'+'</b>'
    }
    else  if( alarmNumber==2){
        return  '<b style="color: #ff004c">'+'危'+'</b>'
    }
    else if (alarmNumber=='dcs') {
        return  ''
    }
    else {
        return  '<b style="color: #0e88ff; ">'+'未'+'</b>'
    }
}

//判断部位
function partLocation(partLocation){
    if(partLocation == '进料端小齿轮轴承轴向速度'||partLocation == '出料端小齿轮轴承轴向速度'
        ||partLocation == '出料端轴承轴向速度'||partLocation == '进料端小齿轮轴承垂直速度'||partLocation == '出料端小齿轮轴承垂直速度'){
        return '<br>'+partLocation;
    }

    else {
        return partLocation;
    }
}
//判断是否为数字
function isNumber(equipName,devPart,result,alarm) {
    var patrn = /^[-,+]{0,1}[0-9]{0,}[.]{0,1}[0-9]{0,}$/;

    if (!patrn.exec(result)){
        return '';}
    else {
        if(devPart.indexOf("压") >= 0){
            return result+'MPa';}
        else if(devPart.indexOf("温") >=0||devPart.indexOf("减速机") >=0){
            return result+'℃';}
        else  if(devPart.indexOf("位移") >= 0 ||devPart.indexOf("速度") >= 0 ||devPart.indexOf("振动") >= 0){
            return result+'mm/s';}
        else  if(devPart.indexOf("时间") >= 0 ||devPart.indexOf("周期") >= 0 ){
            return result+'h';}
        else  if(devPart.indexOf("频率") >= 0  ){
            return result+'Hz';}
        else  if(devPart.indexOf("电流") >= 0  ){
            return result+'A';}
    }
}

function judgeEquip(judgeNum) {

    if(judgeNum==0){
        return   '<b style="color:#13ff12 " >'+'正常'+'</b>'

    }
    else if(judgeNum==1){
        return  '<b style="color: #ff8a18">'+'报警'+'</b>'
    }
    else if (judgeNum==2){
        return  '<b style="color: #ff004c">'+'危险'+'</b>'
    }
    else {
        return  '<b style="color: #0e88ff; ">'+'未检'+'</b>'
    }
}


//设备评定
var appraise1='';
function appraise(zchang,wxian,bjing,wjian) {

    if(wxian>0){

        return '危险';
    }
    else if(bjing>0){

        return '报警';
    }

    else if(zchang>0 ){
        return '正常';
    }
    else{
        return '无';
    }
}

//     判断是否处理
function deal(dealEstimate) {
    if(dealEstimate=='N'){
        return '未处理'
    }
    else {
        return '已处理'
    }

}
//     判断处理结果
function dealResult(param) {
    if(param==null){
        return '';
    }
    else {
        return param;
    }
}
function dealResultTime(param) {
    if(param==null){
        return '';
    }
    else {
        return param.split(".")[0];
    }
}
