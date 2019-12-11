
var time="";
var start='';
var end='';
layui.use('laydate', function(){
    var laydate = layui.laydate;
    //日期选择
    laydate.render({
        elem: '#test'
        ,type: 'date'
        ,value: new Date()
        ,max : getNowFormatDate()
        ,isInitValue: false
        ,showBottom:false//是否允许填充初始值，默认为 true
        ,done: function(value, date, endDate){
            time=value;
        }
    });
    //日期范围选择
    laydate.render({
        elem: '#test6'
        ,range: true
        ,type: 'date'
        ,max : getNowFormatDate()
        ,done: function(value, date, endDate){

            start=value.split(" - ")[0];
            end=value.split(" - ")[1];

        }
    });
    //点我触发时间选择，必须有
    laydate.render({
        elem: '#test25'
        ,eventElem: '#test25-1'
        ,trigger: 'click'
    });
});
jeDate({
    dateCell:"#dateStart",
    // format:"YYYY-MM-DD hh:mm:ss",
    format:"YYYY-MM-DD",
    isinitVal:true,
    isTime:true, //isClear:false,
    // initHour:-24,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){
        // alert("111111111:::::"+$("#dateStart").val());
        //
        // alert(val)
    }
});
//================时间选择，时间格式确定==========================
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month
        + seperator1 + strDate + " " + date.getHours() + seperator2
        + date.getMinutes() + seperator2 + date.getSeconds();
    return currentdate;
}

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
    // time=$("#dateStart").val();
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

    if(time ==''&&start ==''&&end ==''){

        alert("请选择日期！");
        return;
    }
    else {

        //==============清空表格内容=====================
        $("#tables").load(location.href + " #tables");
        if (start ==''){
            // alert("========"+val1+";;"+val2+";;"+val3+";;"+time+";;"+duty_name);
            chaxun(val1,val2,val3,time,duty_name);
        }
        else {
            zhouchaxun(val1,val2,val3,start,end);
        }

    }
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

