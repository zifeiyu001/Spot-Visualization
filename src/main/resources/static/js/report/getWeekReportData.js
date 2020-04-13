function zhouchaxun(workshop,team,equip,startTime,endTime){
 // var value=workshop+'='+team+"="+equip+"="+startTime+"="+endTime;
    var loading='';
    // value1=encodeURI(value);
    $.ajax({
        type : "post",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/report/week",    //请求发送到TestServlet处
        // data :value1,

        contentType: "application/json",
        data:JSON.stringify({
            "workshop":workshop,
            "team":team,
            "equip":equip,
            "startTime":startTime,
            "endTime":endTime
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
            var tableData='';
            var tableData1='';
            //=========================通用点检统计======================

            var zong = data1[0].zong;   //需点检的总数
            var wjian = data1[0].wjian;    //未检的数量
            var zchang = data1[0].zchang;   //正常的数量
            var bjing = data1[0].bjing;    //报警的数量
            var wxian = data1[0].wxian;    //危险的数量
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
            if(zong==0){alert("无数据...")}
            spots = '<tr style="text-align: center"><td colspan="2"  style="  border: 1px solid ;">' + zong + '</td><td  style="  border: 1px solid ;">'
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
            if(team=="碎矿设备"||team=="磨浮设备"||team=="精尾设备"){
                            title += '<th colspan="1"  style="background-color: lightcyan ;border: 1px solid ; min-width: 70px;">'
                                + "设备编码" + '</th><td colspan="2" id="bianhao" style="  border: 1px solid ;text-align: center">'
                                + '</td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">'
                                + "主机设备名称" + '</th><td colspan="2" id="zhushebei" style="  border: 1px solid ;text-align: center">'
                                 + '</td><th colspan="1"  style="background-color: lightcyan ;border: 1px solid ;">'
                                + "附属设备" + '</th> <td colspan="3" id="fuzhushebei" style="  border: 1px solid ;text-align: center">' + '</td>';

                            $('#biaoti').append(title);

                equipCode(workshop,team,equip);
            }
            for(var c=0;c<data.length;c++){
                    if((c+1)%9!=0 ){
                       tableData += '<td  style="background-color: lightcyan ;border: 1px solid; text-align: center;width: 10%;">'
                           + data[c].equipName + '</td>';
                        tableData1 += '<td  style="border: 1px solid; text-align: center;">'
                            + data[c].altpid + '</td>';
                        if(c==data.length-1){


                            var alarm_title= '<tr><td style="background-color: lightcyan ;border: 1px solid; text-align: center;">设备名称</td>'+tableData+'</tr>';
                            var alarm_content= '<tr><td style="background-color: lightcyan ;border: 1px solid; text-align: center;">报警次数</td>'+tableData1+'</tr>';
                            var alarm_run=alarm_title+alarm_content;
                            $('#run').append(alarm_run);
                            var tableData='';
                            var tableData1='';
                        }
                    }
                    else  {
                        tableData += '<td  style="background-color: lightcyan ;border: 1px solid; text-align: center;width: 10%;">'
                            + data[c].equipName + '</td>';
                        tableData1 += '<td  style="border: 1px solid; text-align: center;">'
                            + data[c].altpid + '</td>';
                        var alarm_title= '<tr><td style="background-color: lightcyan ;border: 1px solid; text-align: center;">设备名称</td>'+tableData+'</tr>';
                        var alarm_content= '<tr><td style="background-color: lightcyan ;border: 1px solid; text-align: center;">报警次数</td>'+tableData1+'</tr>';
                        var alarm_run=alarm_title+alarm_content;
                        $('#run').append(alarm_run);
                        var tableData='';
                        var tableData1='';
                    }

            }


 //=======================通用缺陷处理======================================

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
        }

    });
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
            if(devPart.indexOf("温") >=0||devPart.indexOf("减速机") >=0){
                return result+'℃';}
            if(devPart.indexOf("位移") >= 0 ||devPart.indexOf("速度") >= 0 ||devPart.indexOf("振动") >= 0){
                return result+'mm/s';}
            if(devPart.indexOf("时间") >= 0 ||devPart.indexOf("周期") >= 0 ){
                return result+'h';}

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

            return '危险'
        }
        else if(bjing>0){

            return '报警'
        }
        else if(wjian>0){
            return '未检'
        }
        else if(zchang>0 ){
            return '正常'
        }
        else
        {  return ''}
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

}
