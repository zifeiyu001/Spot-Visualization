function chaxun(workshop,team,equip,time,duty_name){
    alert("============");
 var value=workshop+'='+team+"="+equip+"="+time+"="+duty_name;
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
             // loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
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

                        contentData += partLocation(data[a].part) + '&#12288;<u>' + isNumber(dept, data[a].part, data[a].result, data[a].altpid) + '</u>&#12288;'
                            + alarm(data[a].altpid) + "；" + '&#12288;';

                        if (a == data.length - 2) {
                            contentData += partLocation(data[a + 1].part) + '&nbsp;<u>' + isNumber(dept, data[a + 1].part, data[a + 1].result, data[a + 1].altpid) + '</u>&nbsp;'
                                + alarm(data[a + 1].altpid) + "；" + '&nbsp;';

                            if (team != '精尾设备') {

                                tableData += '<tr><td colspan="2" class="backgroundColor1" style="background-color: lightcyan ;border: 1px solid ;text-align: center; ">'
                                    + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                    + contentData +
                                    '</td></tr>';

                            } else {
                                tableData += '<tr ><td  class="backgroundColor1" style="background-color: lightcyan ;border: 1px solid text-align: center;width: 10%;">'
                                    + data[a].zoneName + '</td><td class="backgroundColor1"  style="  border: 1px solid ;text-align: center;">' + data[a].equipName
                                    + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                    + contentData +
                                    '</td></tr>';
                            }
                            $('#run').append(tableData);
                        }

                    } else {
                        contentData += partLocation(data[a].part) + '&nbsp;<u>' + isNumber(dept, data[a].part, data[a].result) + '</u>&nbsp;' + alarm(data[a].altpid) + "；" + '&nbsp;';

                        if (team != '精尾设备') {

                            tableData += '<tr><td colspan="2" class="backgroundColor1" style="background-color: lightcyan ;text-align: center;border: 1px solid;">'
                                + data[a].equipName + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
                                + contentData +
                                '</td></tr>';

                        } else {

                            tableData += '<tr ><td class="backgroundColor1" style="background-color: lightcyan ;text-align: center;border: 1px solid ;width: 10%;">'
                                + data[a].zoneName + '</td><td class="backgroundColor1"  style="  border: 1px solid ;text-align: center;">' + data[a].equipName
                                + '</td><td colspan="8"  id="runcontent"  style="  border: 1px solid ;">'
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

                if(team=='精尾生产'||(team=='碎矿生产' && equip=='皮带岗')){
                       alert(duty_name);
                    for (var m = 0; m < data.length; m++) {

                        sc_content += '<tr style="text-align: center;border: 1px solid ;"><td colspan="2" style="text-align: center;">'
                            + data[m].zoneName + '</td><td colspan="2" style="border: 1px solid ;text-align: center;"> '
                            + data[m].equipName + '</td><td colspan="3" style="border: 1px solid ;" >'
                            + judgeEquip(data[m].oneNum) + '</td><td colspan="3" style="border: 1px solid ;">'
                            + judgeEquip(data[m].twoNum) + '</td></tr>';
                        // +
                        //     '<td colspan="3" style="border: 1px solid ;">'
                        //     + judgeEquip(data[m].threeNum) + '</td></tr>';
                    }

                }
                else {
                       for (var m = 0; m < data.length; m++) {

                            sc_content += '<tr style="text-align: center;border: 1px solid ;"><td style="text-align: center;">'
                                + (m + 1) + '</td><td colspan="3" style="border: 1px solid ;text-align: center;"> '
                                + data[m].equipName + '</td><td colspan="3" style="border: 1px solid ;" >'
                                + judgeEquip(data[m].oneNum) + '</td><td colspan="3" style="border: 1px solid ;">'
                                + judgeEquip(data[m].twoNum) + '</td></tr>>';
                        }
                }
//======================生产点检时间选择=========================
                if(duty_name=='白班') {
                    sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                        + "时间" + '</td><td colspan="4" style="border: 1px solid ;text-align: center;"> '
                        + "08:00-13:59" + '</td><td colspan="4" style="border: 1px solid ;text-align: center;"> '
                        + "14:00-19:59" + '</td></tr>'+ sc_content;
                }
                else {
                    alert(sc_content+"======"+sc_content1);
                    sc_content1 += '<tr style="text-align: center; background-color: lightcyan ;border: 1px solid ;"><td colspan="4" style="text-align: center;">'
                        + "时间" + '</td><td colspan="4" style="border: 1px solid ;text-align: center;"> '
                        + "20:00-23:59" + '</td><td colspan="4" style="border: 1px solid ;text-align: center;"> '
                        + "00:00-07:59" + '</td></tr>'+ sc_content;
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
            // layer.close(loading);
            if(team=='精尾设备'||team=='精尾生产'||(team=='碎矿生产' && equip=='皮带岗')) {
                setTimeout(autoRowSpan(run, 0, 0),1000);
                // autoRowSpan(run, 0, 0);

            }
        }

    });

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
