
/*=====================================判断登录用户=================================================*/

// 获取登录用户id
    function GetQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
        if(r!=null)return  unescape(r[2]); return null;
    }
    var name = GetQueryString("user");
    //登录用户不为空，session不为空；判断存储的session和登录用户不同时更新session
    if(username !=null && username !==undefined && username !==''&& username !=='null') {
        if (name !==null && name !==undefined && name !==''&& name !=='null') {
            if (username===name) {}
            else {getUser(name)}
        }
    }
    //session为空；登录用户为空，重新登录；登录用户不为空时，更新session
    else {
        if (name ===null || name === undefined || name ===''|| name ==='null') {
            alert("请进行登录");
            window.location.href='http://172.16.5.4/bkzyCMS/login';
        } else {  getUser(name)}
    }

// 将用户保存到后台，session
function getUser(name){

    $.ajax({
        url: "/spot/user",

        contentType: "application/json",
        data:JSON.stringify({
            "name":name
        }),
        type: "post",
        cache: false,
        async: false,
        dataType: "json",
        success: function (result) {
            var data=result.data;

            if(data===''){
                alert("账户不存在，请重新登录...");
                window.location.href='http://172.16.5.4/bkzyCMS/login';
            }
            else {
                // var dept=result.deptdata;
                // alert(dept)
                // search("c",dept);
            }
        }
    });
}
/*==========================================================时间控件============================================*/

//点检结果查询
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
//处理单查询
jeDate({
    dateCell:"#dateStart2",
    format:"YYYY-MM-DD hh:mm:ss",
    // format:"YYYY-MM-DD 00:00:00",
    isinitVal:true,
    isTime:true, //isClear:false,
    initHour:-24,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
jeDate({

    dateCell:"#dateEnd2",
    // format:"YYYY-MM-DD 00:00:00",
    format:"YYYY-MM-DD hh:mm:ss",
    isinitVal:true,
    isTime:true, //isClear:false,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
//维修单时间选择
jeDate({
    dateCell:"#repair-start-date1",
    format:"YYYY-MM-DD hh:mm:ss",
    // format:"YYYY-MM-DD 00:00:00",
    isinitVal:true,
    isTime:true, //isClear:false,
    initHour:-24,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
jeDate({
    dateCell:"#repair-end-date1",
    format:"YYYY-MM-DD hh:mm:ss",
    // format:"YYYY-MM-DD 00:00:00",
    isinitVal:true,
    isTime:true, //isClear:false,
    initHour:0,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
jeDate({

    dateCell:"#dateEnd2",
    // format:"YYYY-MM-DD 00:00:00",
    format:"YYYY-MM-DD hh:mm:ss",
    isinitVal:true,
    isTime:true, //isClear:false,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
//维修单时间选择
jeDate({
    dateCell:"#search-bc-start-date",
    format:"YYYY-MM-DD hh:mm:ss",
    // format:"YYYY-MM-DD 00:00:00",
    isinitVal:true,
    isTime:true, //isClear:false,
    initHour:-30*24,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
jeDate({
    dateCell:"#search-bc-end-date",
    format:"YYYY-MM-DD hh:mm:ss",
    // format:"YYYY-MM-DD 00:00:00",
    isinitVal:true,
    isTime:true, //isClear:false,
    initHour:0,
    minDate:"1900-01-01 00:00:00",
    okfun:function(val){alert(val)}
});
/*========================================公共内容==========================================*/

// 选择展示页面
function chooseItem(param){

    if (param==='dxj'){

        $("#li1").attr("class","active");
        $("#li2").attr("class","");
        $("#li3").attr("class","");
        $("#li4").attr("class","");
        $(".form1").show();
        $(".form2").hide();
        $(".form3").hide();
        $(".form4").hide();
    }
    else if (param==='alarmDeal') {
        $("#li1").attr("class","");
        $("#li2").attr("class","active");
        $("#li3").attr("class","");
        $("#li4").attr("class","");
        $(".form1").hide();
        $(".form2").show();
        $(".form3").hide();
        $(".form4").hide();


    }
    else if (param==='service') {
        $("#li1").attr("class","");
        $("#li2").attr("class","");
        $("#li3").attr("class","active");
        $("#li4").attr("class","");
        $(".form1").hide();
        $(".form2").hide();
        $(".form3").show();
        $(".form4").hide();
    }
    else {
        $("#li1").attr("class","");
        $("#li2").attr("class","");
        $("#li3").attr("class","");
        $("#li4").attr("class","active");
        $(".form1").hide();
        $(".form2").hide();
        $(".form3").hide();
        $(".form4").show();

        setTimeout(function(){
            var a=$('.htmleaf-header').outerHeight(true);
            var b=$('#menuHeight').outerHeight(true);
            var c=$(window).height();
            var d=c-a-b;
            $(".form4").height(d*0.85);
            // alert(d)
        },100);
    }

}
var alarm_list_start='';
var alarm_list_end='';
alarm_c_deal_start='';
alarm_c_deal_end='';
alarm_tips_time='';
//获取配置数据

function getConfigData() {
    $.ajax({
        url: "/pc/config/getConfigData",
        data:[],
        contentType: "application/json",
        cache: true,
        dataType: "json",
        type: "get",
        success: function (result) {
            var data=result.data;
            alarm_list_start=data[0].alarm_list_start;
            alarm_list_end=data[0].alarm_list_end;
            alarm_c_deal_start=data[0].alarm_c_deal_start;
            alarm_c_deal_end=data[0].alarm_c_deal_end;
            alarm_tips_time=data[0].alarm_tips_time;

        }});

}
//自动查询 点检条件

var routes = null;
var zones=null;
var depts=null;
var parts=null;
var scContents=null;
var total=null;
var nowPage=1;
var numPerPage=1;
var startPage=0;
var length=null;

$(function () {
    //=========================工段==================================
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
                str1 += "<option value='"+ json[i].deptName +"'>"+json[i].deptName+"</option>";
            }
            $('#workshop').empty().append(str);
            $('#workshop2').empty().append(str);
            $('#workshop3').empty().append(str);
            $('#workshop4').empty().append(str);
            $("#popupWindow-allDept").empty().append(str1);
            $('#route').empty().append('<option value="test">' + '全部线路' + '</option>');
            $('#zone').empty().append('<option value="test">' + '全部区域' + '</option>');
            $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
            $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
            $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');


        }
    });
    //=========================线路================================
    $.ajax({
        url: "/interlocking/routeName",
        contentType: "application/json",
        type: "get",
        cache: true,
        dataType: "json",

        success: function (result) {
            var json = result.data;
            routes = result.data;
        }
    });
    //============================区域============================
    $.ajax({
        url: "/interlocking/zoneName",
        contentType: "application/json",
        type: "get",
        cache: true,
        dataType: "json",

        success: function (result) {
            zones=result.data;
        }
    });
    //==============================设备=============================
    $.ajax({
        url: "/interlocking/devName",
        contentType: "application/json",
        type: "get",
        cache: true,
        dataType: "json",

        success: function (result) {
            depts = result.data;
        }
    });
    //==============================部位================================
    $.ajax({
        url: "/interlocking/partName",
        contentType: "application/json",
        type: "get",
        cache: true,
        dataType: "json",

        success: function (result) {
            parts = result.data;
        }
    });
    //=============================内容============================
    $.ajax({
        url: "/interlocking/content",
        contentType: "application/json",
        type: "get",
        cache: true,
        dataType: "json",

        success: function (result) {
            scContents = result.data;
        }
    });
});

//===============================根据上级筛选，显示下级=========================

//线路数据添加
function getRouteName() {

    $('#zone').empty().append('<option value="test">' + '全部区域' + '</option>');
    $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
    $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
    $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
    var str='<option value="test">' + '全部线路' + '</option>';
    var deptName = $("#workshop option:selected").text();
    for (var i = 0; i < routes.length; i++) {
        if (routes[i].deptName==deptName) {
            str += '<option value="' + routes[i].routeName+ '">' + routes[i].routeName + '</option>';
        }
    }
    $('#route').empty().append(str);

}
//区域数据添加
function getZoneName() {
    $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
    $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
    $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
    var str='<option value="test">' + '全部区域' + '</option>';
    var deptName = $("#workshop option:selected").text();
    var route = $("#route option:selected").text();
    for (var i = 0; i < zones.length; i++) {
        if (zones[i].deptName==deptName && zones[i].routeName== route) {
            str += '<option value="' + zones[i].zoneName + '">' + zones[i].zoneName + '</option>';
        }
    }
    $('#zone').empty().append(str);
}
//设备数据添加
function getDevName() {
    $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
    $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
    var str='<option value="test">' + '全部设备'+ '</option>';
    var deptName = $("#workshop option:selected").text();
    var route = $("#route option:selected").text();
    var zone = $("#zone option:selected").text();
    for (var i = 0; i < depts.length; i++) {
        if (depts[i].deptName==deptName && depts[i].routeName== route && depts[i].zoneName== zone) {
            str += '<option value="' + depts[i].devName + '">' + depts[i].devName + '</option>';
        }
    }
    $('#equip').empty().append(str);
}
//部位数据添加
function getPartName() {
    $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
    var deptName = $("#workshop option:selected").text();
    var route = $("#route option:selected").text();
    var zone = $("#zone option:selected").text();
    var equip = $("#equip option:selected").text();
    var str='<option value="test">' + '全部部位'+ '</option>';
    for (var i = 0; i < parts.length; i++) {
        if (parts[i].deptName==deptName && parts[i].routeName== route && parts[i].zoneName== zone  && parts[i].devName== equip ) {
            str += '<option value="' + parts[i].scPart + '">' + parts[i].scPart + '</option>';
        }
    }
    $('#part').empty().append(str);
}
//内容数据添加
function getContent() {
    var deptName = $("#workshop option:selected").text();
    var route = $("#route option:selected").text();
    var zone = $("#zone option:selected").text();
    var equip = $("#equip option:selected").text();
    var part = $("#part option:selected").text();
    var str='<option value="test">' + '全部内容'+ '</option>';
    for (var i = 0; i < scContents.length; i++) {
        if (scContents[i].deptName==deptName && scContents[i].routeName== route && scContents[i].zoneName== zone  && scContents[i].devName== equip  && scContents[i].scPart== part ) {
            str += '<option value="' + scContents[i].scContent + '">' + scContents[i].scContent + '</option>';
        }
    }
    $('#content').empty().append(str);
}

//获取需查询页码


$("#reduceNum").click(function (){
    nowPage = $("#nowPage").val();
    if (nowPage>1) {
        $("#nowPage").val(nowPage-1);
        search()
    }
});
$("#andNum").click(function (){
    nowPage = $("#nowPage").val();
    if (nowPage<=total/numPerPage) {
        $("#nowPage").val( Number($("#nowPage").val())+1);
        search()
    }
});
$("#nowPage1").click(function () {
    $("#nowPage").val($("#nowPage1 option:selected").val())

});

/*==================================点检结果查询====================================*/

//未全选时，全选不勾；全选时，全选自动勾选
$(".sd").click(function () {
    var a=0;
    var b=0;
    var box = document.getElementsByClassName('sd');
    for ( var i = 0; i < box.length; i++) {
        if (!box[i].checked) {
            $("#choose .ad").prop("checked", false);
            b = b + 1;
        } else {
            a = a + 1;
        }
    }
    if (a==box.length){
        $("#choose .ad").prop("checked",true);
    }
});

// 全选
$("#test").click(function(){
    sameCheckedSet1($(this));
});

function sameCheckedSet1(eleInput){
    var checkAll = $("#choose .ad");
    var checkItem = $("#choose .sd");
    if(eleInput.is(".ad")){
        if( !eleInput.is(':checked') ){
            checkItem.prop("checked",false);
        }else{
            checkItem.prop("checked",true);
        }
    }else if(eleInput.is(".sd")){
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
//查询点检结果
function search(c,b) {
    getConfigData();
    if (c==='a'){
        $("#nowPage1").empty().append("<option value="+1+">"+1+"</option>");
        $("#nowPage").empty().val(1);
    }
    var start=$("#dateStart").val();
    var end=$("#dateEnd").val();
    var route = $("#route option:selected").val();
    var zone = $("#zone option:selected").val();
    var equip = $("#equip option:selected").val();
    var part = $("#part option:selected").val();
    var content = $("#content option:selected").val();
    var deptName = $("#workshop option:selected").val();
    var zcCheck = $("#zcCheck input[type='checkbox']").is(':checked');
    var bjCheck = $("#bjCheck input[type='checkbox']").is(':checked');
    var bjType1 = $("#alarmType1 input[type='checkbox']").is(':checked');
    var bjType2 = $("#alarmType2 input[type='checkbox']").is(':checked');
    var bjType3 = $("#alarmType3 input[type='checkbox']").is(':checked');
    var wjCheck = $("#wjCheck input[type='checkbox']").is(':checked');
    var dealStatus=$("#chooseDeal option:selected").val();

    // var responsibleDepartmentStatus="yes";
    var totalData=$("#totalData").val();
    var nowPage=$("#nowPage").val(); // 当前页数
    numPerPage=$("#numPerPage option:selected").val(); // 每页条数
    if (nowPage==null){
        nowPage==1;
    }
    startPage = (nowPage-1)*numPerPage;
    if (c==='c'){
        var date = new Date();
        var time = date.toLocaleDateString().replace(/\//g, "-") + " " + date.toTimeString().split(/\s+/)[0];
        // console.log(time);

        start="2010-09-01 00:00:00";
        end =time;
        deptName=b;
        route="test";
        zone="test";
        equip ="test";
        part = "test";
        content ="test";
        zcCheck ="false";
        bjCheck ="true";
        bjType1 ="false";
        bjType2 ="false";
        bjType3 ="false";
        wjCheck ="false";
        // responsibleDepartmentStatus="yes";
    }

    // alert("deptName==="+deptName+";route==="+route+";zone=="+zone+";equip=="+equip+";part=="+part+";content=="+content+";startTime=="+start+";endTime=="+end+
    //     ";zcCheck=="+zcCheck+";bjCheck=="+bjCheck+";bjType1=="+bjType1+";bjType2=="+bjType2+";bjType3=="+bjType3+";wjCheck=="+wjCheck+";startPage=="+startPage+";numPerPage=="+numPerPage)
    $.ajax({
        url: "/interlocking/getResult",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"route":route,"zone":zone,"equip":equip,"part":part,"content":content,"startTime":start,"endTime":end,
            "zcCheck":zcCheck,"bjCheck":bjCheck,"bjType1":bjType1,"bjType2":bjType2,"bjType3":bjType3,"wjCheck":wjCheck,"startPage":startPage,"numPerPage":numPerPage,
            "dealStatus":dealStatus
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            getScrollHeight();
            $('.tbody').empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var result2 = eval(result);
            var json = result2.data;
            length=json.length;
            total=result.total;
            str1="";
            var numsize=(total/numPerPage)+1;
            for(n=1;n<=numsize;n++){
                if (n==nowPage) {
                    str1+="<option value="+n+" selected = 'selected' >"+n+"</option>"
                }else {
                    str1+="<option value="+n+">"+n+"</option>"
                }
            }
            $("#nowPage1").empty().append(str1);
            $("#totalData").val(total);
            var str='';
            for (var i = 0; i < length; i++) {
                // alert(json[i].abnormalHandleDealDepart);
                var alpid = json[i].altpid;
                var abnormalHandleType=json[i].abnormalHandleType;
                // alert(json[i].resultId);
                var alarmFlag = json[i].alarmFlag;
                if (abnormalHandleType == 0){
                    str += '<tr  style="background-color:rgba(0,162,44,0.57)"><td>'
                }else if (alarmFlag =="Y") {
                    str += '<tr  style="background-color:rgba(64,162,56,0.57)"><td>'
                }  else if(json[i].abnormalHandleAdminType == null && abnormalHandleType>0){
                    str += '<tr  style="background-color: #ffc2ff"><td>'
                } else if (json[i].abnormalHandleAdminType == 1 &&  alarmFlag ==="N") {
                    str += '<tr style="background-color: #ff2203"><td>'
                } else if (json[i].abnormalHandleAdminType == 2 && alarmFlag ==="N") {
                    str += '<tr style="background-color: #ff9d09"><td>'
                } else if (json[i].abnormalHandleAdminType == 3 && alarmFlag ==="N") {
                    str += '<tr style="background-color: #8b9bc8"><td>'
                }else {
                    str += '<tr  style="background-color: #ffdd1d"><td>'
                }
                str += +(i + 1) + '</td><td>'
                    + (json[i].uploadResultTime==null?"-":json[i].uploadResultTime )+ '</td><td>'
                    + json[i].deptName + '</td><td>'
                    + json[i].routeName + '</td><td>'
                    + json[i].zoneName + '</td><td>'
                    + json[i].devName + '</td><td>'
                    + json[i].scPart + '</td><td>'
                    + json[i].scContent + '</td><td>'
                    + (json[i].remark==null?"-":json[i].remark) + '</td><td>'
                    + json[i].result + '</td><td>'
                    + judgeAlarm(json[i].abnormalHandleType) + '</td><td>'
                    + (json[i].personLiable==null?"-":json[i].personLiable) + '</td><td>'
                    + (json[i].userName==null?"-":json[i].userName) + '</td><td>'
                    + json[i].taskStartTime + '</td><td>'
                    + json[i].taskEndTime + '</td><td>'
                    + (json[i].dealPerson==null?'-':json[i].dealPerson) + '</td><td>'
                    + (json[i].dealUser==null?'-':json[i].dealUser) + '</td><td>'
                    +((json[i].deal_remark==null||json[i].deal_remark=='')?'-':json[i].deal_remark)+ '</td>';

                if((json[i].abnormalHandleAdminType == null &&abnormalHandleType>0 &&alarmFlag=='N')&& getHour(json[i].uploadResultTime,getCurDate())>alarm_tips_time) {
                        str += '<td  class="light">'+ judgeAlarm(json[i].abnormalHandleAdminType)+'</td><td>';

                }
                else {
                    str += '<td>'+ judgeAlarm(json[i].abnormalHandleAdminType)+'</td><td>';
                }

                 str+= ((json[i].abnormalHandleDealDepart==null||json[i].abnormalHandleDealDepart=='')?'-':json[i].abnormalHandleDealDepart) + '</td><td>'

                    + ((abnormalHandleType<1||alarmFlag=='Y'||json[i].abnormalHandleAdminType>1)?'<input type="button" class="btn btn-warning" value="修改" disabled style="border-color: #bebbb7;' +
                        'background-color: #bebbb7;background-image: linear-gradient(to bottom, #bebbb7 0%, #bebbb7 100%); ">':
                        '<input type="button" class="btn btn-warning" value="修改" style="cursor: pointer;"onclick="openModal(\''+json[i].resultId+'\'\,\''+json[i].deptName+'\')">')+'</td><td>'


                    +((json[i].abnormalHandleAdminType!=1||alarmFlag=='Y')?'<input type="button" class="btn btn-warning" value="处理" disabled style="border-color: #bebbb7;' +
                        'background-color: #bebbb7;background-image: linear-gradient(to bottom, #bebbb7 0%, #bebbb7 100%); ">':
                        '<input type="button" class="btn btn-warning" value="处理" style="cursor: pointer;"onclick="openDealWriteData_modal(\''+json[i].resultId+'\')">')+'</td><td>'

                    +(json[i].dealData==0?'<input type="button" class="btn btn-warning" value="查看处理单" disabled style="border-color: #bebbb7;' +
                        'background-color: #bebbb7;background-image: linear-gradient(to bottom, #bebbb7 0%, #bebbb7 100%); ">':
                        '<input type="button" class="btn btn-warning" value="查看处理单" style="cursor: pointer;"onclick="openDealData_modal(\''+json[i].resultId+'\')">')+'</td></tr>';
            }

            $('#groupTable').append(str);
            setScrollHeight();
        },

        complete: function() {
            layer.close(loading);
            if (length==0){
                setTimeout('alert("无数据")','40');

            }


        }
    })

    // setTimeout(function(){
    //
    // },'1000');
}

var colorFlag = 0;
function changeColor() {
    $(".light").val();
    if (!colorFlag)
    {
        $(".light").css("background"," #ff2203");
        colorFlag = 1;
    }else{
        $(".light").css("background","#ff6f03");
        colorFlag = 0;
    }
}
setInterval('changeColor()',500);
/*==================================修改A类报警类型===========================================*/
var spotId='';
var spotPart='';
function closeModal(){
    document.getElementById("modal_cover").style.display="none";
}
function openModal(param1,param2){
    spotId=param1;
    spotPart=param2;

    document.getElementById("modal_cover").style.display = "block";
}
var scrollTop=0;
//修改报警类型
function changeAType() {
    var  alarmType=$("#selectType option:selected").val();
    var sksb = $("#sksb input[type='checkbox']").is(':checked');
    var sksc = $("#sksc input[type='checkbox']").is(':checked');
    var mfsb = $("#mfsb input[type='checkbox']").is(':checked');
    var mfsc = $("#mfsc input[type='checkbox']").is(':checked');
    var jwsb = $("#jwsb input[type='checkbox']").is(':checked');
    var jwsc = $("#jwsc input[type='checkbox']").is(':checked');
    var dy = $("#dy input[type='checkbox']").is(':checked');


    if(sksb===true||sksc===true||mfsb===true||mfsc===true||jwsb===true||jwsc===true||dy===true){

//jquery获取复选框值
        var chk_value =[];//定义一个数组
        $('input[name="gdxz"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数
            chk_value.push($(this).val());//将选中的值添加到数组chk_value中
            // alert(chk_value)
        });
        if (chk_value.toString()!=null) {

            $.ajax({
                url: "/interlocking/changeAlarmAType",
                contentType: "application/json",
                data: JSON.stringify({
                    "resultId": spotId,
                    "part": spotPart,
                    "alarmType": alarmType,
                    "name": name,
                    "selectDepart": chk_value.toString()
                }),
                type: "post",
                cache: true,
                dataType: "json",
                beforeSend: function () {

                },
                success: function (result) {
                    var data = result.data;
                    var msg=result.msg;
                    if (msg=='true'){
                        search('b');
                    }
                    alert(data)
                },
                complete: function() {

                }

            });

            closeModal();
        }
        else {
            alert("请至少选择一个部门")
        }
    }
    else {
        alert("请至少选择一个部门")
    }


}




function judgeRemark(remark) {
    if (remark!=''&&remark!=null) {
        return remark;
    }
    else {
        return '-'
    }

}
// ========================判断报警============================
function judgeAlarm(dealEstimate) {
    if(dealEstimate=='1'){
        return 'A类'
    }
    else if(dealEstimate=='2'){
        return 'B类'
    }
    else if(dealEstimate=='3'){
        return 'C类'
    }
    else {return '-'}

}


/*=============================获取详细的处理单数据===========================*/
function closeDealData_modal(){
    document.getElementById("deal_modal_cover").style.display="none";
}
function openDealData_modal(result_id){
    document.getElementById("deal_modal_cover").style.display = "block";
    getDealData(result_id);
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
            //     维修单编码
            $("#repair-id").text((data[0].service_id==null||data[0].service_id=='')?'-':data[0].service_id);
            //    维修开始时间
            $("#repair-start-date").text((data[0].service_start_date==null||data[0].service_start_date=='')?'-':dateFormat(data[0].service_start_date,'yyyy-MM-dd HH:mm:ss'));
            //  维修结束时间
            $("#repair-end-date").text((data[0].service_end_date==null||data[0].service_end_date=='')?'-':dateFormat(data[0].service_end_date,'yyyy-MM-dd HH:mm:ss'));
            //    维修用时
            $("#repair-time").text((data[0].service_hours==null||data[0].service_hours=='')?'-':data[0].service_hours+"h");
            //   设备名称
            $("#equip-name").text((data[0].dev_name==null||data[0].dev_name=='')?'-':data[0].dev_name);
            //    规格型号
            $("#equip-model").text((data[0].dev_model==null||data[0].dev_model=='')?'-':data[0].dev_model);
            //    所属工段
            $("#deptName").text((data[0].dev_dept==null||data[0].dev_dept=='')?'-':data[0].dev_dept);
            //    类别
            $("#technology").text((data[0].dev_category==null||data[0].dev_category=='')?'-':data[0].dev_category);
            //    维修类型
            $("#repair-depart1").text((data[0].service_unit_type==null||data[0].service_unit_type=='')?'-':data[0].service_unit_type);
            //    维修单位2
            $("#repair-depart2").text((data[0].service_unit_type=='自修')?data[0].service_name:data[0].service_unit);
            //     报警类别
            $("#repair-type").text((data[0].alarm_type==null||data[0].alarm_type=='')?'-':data[0].alarm_type);
            //    点检人
            $("#spot-name").text((data[0].alarm_name==null||data[0].alarm_name=='')?'-':data[0].alarm_name);
            //    点检时间
            $("#spot-time").text((data[0].alarm_time==null||data[0].alarm_time=='')?'-':dateFormat(data[0].alarm_time,'yyyy-MM-dd HH:mm:ss'));
            //  报警内容
            $("#alarm-content").text((data[0].alarm_content==null||data[0].alarm_content=='')?'-':data[0].alarm_content);
            // //    维修人员
            // $("#repair-name").text((data[0].service_name==null||data[0].service_name=='') ?'-':data[0].service_name);
            //    验收人员
            $("#acceptor-name").text((data[0].acceptor_name==null||data[0].acceptor_name=='') ?'-':data[0].acceptor_name);
            //    维修内容
            $("#repair-content").text((data[0].service_content==null||data[0].service_content=='')?'-':data[0].service_content);
            //  验收人
            $("#deal-name").text((data[0].service_acceptor==null||data[0].service_acceptor=='')?'-':data[0].service_acceptor);
            //    处理时间
            $("#deal-time").text((data[0].service_alarm_time==null||data[0].service_alarm_time==''?'-':dateFormat(data[0].service_alarm_time,'yyyy-MM-dd  HH:mm:ss')));
            //    材料、备件
            $("#material").text((data[0].service_spare_parts==null||data[0].service_spare_parts=='')?'-':data[0].service_spare_parts);
            //    备注
            $("#remark").text((data[0].service_remarks==null||data[0].service_remarks=='')?'-':data[0].service_remarks);
            if (data[0].service_unit_type=='自修'){
                $("#repair_unit").text("维修人员");
            }
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
/*===========================================查询处理单===========================*/
function search_service() {
    $.ajax({
        url: "/interlocking/repair/list",
        contentType: "application/json",
        data: JSON.stringify({
            "dateStart": $("#dateStart2").val(),
            "dateEnd":$("#dateEnd2").val(),
            "workShop":$("#workshop2").val()
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            $("#service-tbody").empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
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
                        + json[i].service_acceptor + '</td><td>'
                        + (json[i].service_alarm_time==null||json[0].service_alarm_time==''?'-':dateFormat(json[i].service_alarm_time,'yyyy-MM-dd  HH:mm:ss'))+ '</td><td>'
                        +'<input  type="button" class="btn btn-primary"  value="详情" style="cursor: pointer;" onclick="openDealData_modal(\''+json[i].result_id+'\')">'
                        +'</td></tr>';

                }
                $("#service-tbody").append(str);
            }
            else {
                alert("无数据！")
            }
        },
        complete: function() {
            layer.close(loading);
            if (length==0){
                setTimeout('alert("无数据")','40')
            }
        }
    });
}



/*=============================填写报警处理单数据===========================*/
function closeDealWriteData_modal(){
    document.getElementById("deal_write_modal_cover").style.display="none";
}
function openDealWriteData_modal(result_id){
    document.getElementById("deal_write_modal_cover").style.display = "block";
    var clientHeight = document.documentElement.clientHeight;
    var innerHeight = window.innerHeight;
    // alert(clientHeight+"==="+innerHeight);
    $("#deal_write_modal_cover").attr("height",clientHeight);
    // alert(result_id)
    getWriteDefaultDealData(result_id);
}


getUnitInfo();
function getUnitInfo(){
    var value = $('input:radio[name="serviceUnitType"]:checked').val();
    if (value!='自修') {
        $("#repair-unit1").text("维修单位");
    }
    else {
        $("#repair-unit1").text("维修人");
    }
}

//获取填写处理单表中自动生成的数据
var resultid=''; //点检id
var dev_name='';//设备名称
var dev_code='';//设备编码
var dev_model='';//设备型号
var dev_dept='';//工段
var dev_category='';//专业
var alarm_type='';//报警类型
var alarm_name='';//点检人
var alarm_time='';//点检时间
var alarm_content='';//报警内容
var dev_depart='';//部门
function getWriteDefaultDealData(result_id){
    $.ajax({
        url: "/interlocking/repair/write/getWriteDefaultDealData",
        contentType: "application/json",
        data: JSON.stringify({
            "resultId": result_id
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            $("#service-tbody").empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {

            var json=result.data;
            var data = result.data;
             resultid=data[0].result_id;
             dev_name=data[0].dev_name;
             dev_code=data[0].dev_code;
             dev_model=data[0].dev_model;
             dev_dept=data[0].dev_dept;
             dev_category=data[0].dev_category;
             alarm_type=data[0].alarm_type;
             alarm_name=data[0].alarm_name;
             alarm_time=data[0].alarm_time;
             alarm_content=data[0].alarm_content;
            dev_depart=data[0].dev_depart;
            //   设备名称
            $("#devName1").val((dev_name==null||dev_name=='')?'-':dev_name);
            //     设备编码
            $("#equip-code1").val((dev_code==null||dev_code=='')?'-':dev_code);
            //    规格型号
            $("#equip-model1").val((dev_model==null||dev_model=='')?'-':dev_model);
            //    所属工段
            $("#deptName1").val((dev_dept==null||dev_dept=='')?'-':dev_dept);
            //    类别
            $("#technology1").val((dev_category==null||dev_category=='')?'-':dev_category);
            //     报警类别
            $("#repair-type1").val((alarm_type==null||alarm_type=='')?'-':alarm_type);
            //    点检人
            $("#spot-name1").val((alarm_name==null||alarm_name=='')?'-':alarm_name);
            //    点检时间
            $("#spot-time1").val((alarm_time==null||alarm_time=='')?'-':dateFormat(alarm_time,'yyyy-MM-dd HH:mm:ss'));
            //  报警内容
            $("#alarm-content1").val((alarm_content==null||alarm_content=='')?'-':alarm_content);
        },
        complete: function() {
            layer.close(loading);
            if (length==0){
                setTimeout('alert("无数据")','40')
            }
        }
    });
}


//保存处理单数据
function upBjByName(){
    //维修类型
    var service_unit_type = $('input:radio[name="serviceUnitType"]:checked').val();
    //维修单位
    var service_unit = $('input:text[name="repair-name1"]').val();
    //维修内容
    var service_content = $("#serviceContent1").val();
    // var value4 = $("#devName1").val();
    //维修备注
    var service_remarks = $("#remark1").val();
    // alert(value+"==="+ value1+"=="+value2+"==="+value3+"=="+value4);
    var service_start_date=$("#repair-start-date1").val();
    var service_end_date=$("#repair-end-date1").val();
    var service_acceptor=$("#deal-name1").val();
    if (service_unit==null||service_unit==""||service_unit==undefined){
        alert("请填写 "+f(service_unit_type)+" ")
    }
    else if (service_content==null||service_content==""||service_content==undefined) {
        alert("请填写维修内容")
    }
    else {
        $.ajax({
            url: "/interlocking/repair/write/writeDealData",
            contentType: "application/json",
            data: JSON.stringify({
                "resultId": resultid, "dev_code": dev_code, "service_start_date":service_start_date, "service_end_date":service_end_date,
                "dev_name":dev_name, "dev_model":dev_model, "dev_dept":dev_dept, "dev_category":dev_category,"service_unit_type": service_unit_type,
                "service_unit":service_unit, "alarm_type":alarm_type, "alarm_name":alarm_name, "alarm_time":alarm_time, "alarm_content":alarm_content,
                "service_content":service_content, "service_remarks":service_remarks,"service_alarm_time" :getCurDate(),"dev_depart":dev_depart
            }),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
                $("#service-tbody").empty();
                loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
            },
            success: function (result) {
                var json=result.data;
                if (result.type==='true'){
                    closeDealWriteData_modal();
                    search("b")
                }
                alert(json);
            },
            complete: function() {
                layer.close(loading);

            }
        });
    }


}





function f(service_unit_type) {
    if (service_unit_type==='自修')
        return '维修人';
    else {
        return service_unit_type+"单位";
    }

}
//获取当前时间
getCurDate();
function getCurDate()
{
    var d = new Date();
    var years = d.getFullYear();
    var month = add_zero(d.getMonth()+1);
    var days = add_zero(d.getDate());
    var hours = add_zero(d.getHours());
    var minutes = add_zero(d.getMinutes());
    var seconds=add_zero(d.getSeconds());
    var ndate = years+"-"+month+"-"+days+"  "+hours+":"+minutes+":"+seconds;
    return ndate;
// alert(ndate);
}

function add_zero(temp)
{
    if(temp<10) return "0"+temp;
    else return temp;
}



/*=============================bc类报警============================================*/


/*==================获取bc报警列表=================*/

function search_bc_alarm_data(){
    getConfigData();
    var start_date=$("#search-bc-start-date").val();
    var end_date=$("#search-bc-end-date").val();
    var deptName = $("#workshop3 option:selected").val();
    var alarm_type = $("#alarm-type option:selected").val();
    // var deal_status = $("#alarm-deal option:selected").val();
    $.ajax({
        url: "/interlocking/repair/write/bcAlarm",
        contentType: "application/json",
        data: JSON.stringify({
            "start_date": start_date, "end_date": end_date, "deptName":deptName, "alarm_type":alarm_type
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            getScrollHeight();
            $("#bcAlarm-tbody").empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var json=result.data;
            if(json.length>0) {
                var str = '';
                for (var i = 0; i < json.length; i++) {
                    str +=((json[i].monthly_alarm_list=='Y'||json[i].alarm_merge=='Y')?
                        '<tr><td>'+'<input type="checkbox"  class="mergeBCAlarmType" name="mergeBCAlarmType" style="cursor: pointer;" disabled>'+'</td><td>':
                        '<tr><td>'+ '<input type="checkbox"  class="mergeBCAlarmType" name="mergeBCAlarmType" style="cursor: pointer;" ' +
                        'value='+json[i].alarmId+","+json[i].deptName+","+json[i].abnormalHandleAdminType+","+json[i].resultId+'>'+'</td><td>');
                    str+= (i + 1) + '</td><td>'
                        + json[i].deptName + '</td><td>'
                        + json[i].routeName + '</td><td>'
                        // + json[i].zoneName + '</td><td>'
                        // + json[i].devName + '</td><td>'
                        + json[i].scPart + '</td><td>'
                        + json[i].scContent + '</td><td>'
                        + json[i].remark + '</td><td>'
                        +((json[i].uploadResultTimeEnd!=null&&json[i].uploadResultTimeEnd!='')?(dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss')+"至"+
                            dateFormat(json[i].uploadResultTimeEnd,'yyyy-MM-dd HH:mm:ss')):dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss'))
                        + '</td><td>'
                        // + dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss') + '</td><td>'
                        + json[i].alarm_times + '</td><td>'
                        + (json[i].monthly_alarm_list=='Y'?'是':'否') + '</td><td>'
                        +(json[i].alarm_deal_delay=='Y'?'是':'否') + '</td><td>'
                        +((json[i].alarm_deal_delay_remark==null||json[i].alarm_deal_delay_remark=='')?'-':json[i].alarm_deal_delay_remark) + '</td><td>'
                        +((json[i].monthly_alarm_list=='Y'||json[i].alarm_merge=='Y')?
                            '<input type="button"  class="btn btn-primary " value="合并" disabled >' + '</td><td>':
                            '<input type="button"  class="btn btn-primary " value="合并"  onclick="mergeAlarm(\'' + json[i].alarmId + '\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+json[i].resultId+'\',\''+"alarmData"+'\')">' + '</td><td>');
                    if(alarm_type==2){
                        str+=((json[i].monthly_alarm_list=='Y'|| json[i].alarm_merge=='Y')?'<input type="button" class="btn btn-primary"  value="添加" disabled>'+ '</td><td>':
                            '<input type="button" class="btn btn-primary  " value="添加"  onclick="addAlarmToMonthlyList(\''+json[i].deptName+'\',\''+json[i].alarmId+'\')">' + '</td><td>');
                    }
                    else{
                        str+=((json[i].alarm_merge=='Y')?'<input type="button" class="btn btn-primary  operation"  disabled value="处理">' + '</td><td>':
                            '<input type="button" class="btn btn-primary  operation"   value="处理" disabled  onclick="openDealBCModal(\''+json[i].alarmId+'\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+json[i].resultId+'\',\''+"alarmData"+'\')">' + '</td><td>');
                    }
                    str+=((json[i].monthly_alarm_list=='Y'||json[i].alarm_merge=='Y')?
                        '<input type="button" class="btn btn-primary" value="修改" disabled>' + '</td></tr>':
                        '<input type="button" class="btn btn-primary  " value="修改"  onclick="openChangeBCModal(\'' + json[i].alarmId + '\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+"alarmData"+'\')">' +'</td></tr>');
                }

                $("#bcAlarm-tbody").append(str);
            }
            else {alert("无数据！")}
        },
        complete: function() {
            setScrollHeight();
            layer.close(loading);
            var days=differenceValue(alarm_c_deal_start,alarm_c_deal_end);
            var start=days[0];
            var end=days[1];
            if (start=='true'||end=='true'){
                $('.operation').attr('disabled', false);
            }

        }
    });
}


//添加报警到月度清单
function addAlarmToMonthlyList(deptName,alarmId) {
    var mergeIds=new Array();
    var deptNames=new Array();
    $("input[name=mergeBCAlarmType]:checked").each(function(){
       var values= $(this).val().split(',')[0];
        var values1= $(this).val().split(',')[1];
       if (values!='on'){
           mergeIds.push(values);
           deptNames.push(values1)
       }

    });
    mergeIds.push(alarmId);
    // alert(mergeId.toString());
    $.ajax({
        url: "/interlocking/merge/addAlarmToMonthlyList",
        contentType: "application/json",
        data: JSON.stringify({
            "mergeId": mergeIds.toString(),
            "deptName": deptNames.toString()
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function () {
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time: 0});
        },
        success: function (result) {
            var json = result.data;
            var resultMsg=result.msg;
            alert(json);
            if (resultMsg==1){

                $("#workshop4").val(deptName);
                search_bc_monthly_alarm_list(deptName);
                search_bc_alarm_data();
            }
        },
        complete: function () {

            layer.close(loading);

        }
    })
}
/*========================获取月度报警清单==================*/

function search_bc_monthly_alarm_list(param){
    getConfigData();
    var deptName='';
    if (param=='default'){
         deptName = $("#workshop4 option:selected").val();
    }
    else {
        deptName=param;
    }
    $.ajax({
        url: "/interlocking/repair/getMonthlyAlarmList",
        contentType: "application/json",
        data: JSON.stringify({
            "deptName":deptName
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            getScrollHeight();
            $("#monthly-alarm-list-tbody").empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var json=result.data;
            if(json.length>0) {
                var str = '';
                for (var i = 0; i < json.length; i++) {
                    str += '<tr><td>'+ '<input type="checkbox"  class="mergeBCAlarmToList" name="mergeBCAlarmToList" style="cursor: pointer;" ' +
                        'value='+json[i].alarmId+","+json[i].deptName+","+json[i].abnormalHandleAdminType+","+json[i].resultId+'>'+'</td><td>'
                        + (i + 1) + '</td><td>'
                        + json[i].deptName + '</td><td>'
                        // + json[i].routeName + '</td><td>'
                        // + json[i].zoneName + '</td><td>'
                        + json[i].devName + '</td><td>'
                        + json[i].scPart + '</td><td>'
                        + json[i].scContent + '</td><td>'
                        // + json[i].remark + '</td><td>'
                        +((json[i].uploadResultTimeEnd!=null&&json[i].uploadResultTimeEnd!='')?(dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss')+"至"+
                            dateFormat(json[i].uploadResultTimeEnd,'yyyy-MM-dd HH:mm:ss')):dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss'))
                        + '</td><td>'
                        // + dateFormat(json[i].uploadResultTime,'yyyy-MM-dd HH:mm:ss') + '</td><td>'
                        + json[i].alarm_times + '</td><td>'
                        +(json[i].alarm_deal_delay=='Y'?'是':'否') + '</td><td>'
                        +((json[i].alarm_deal_delay_remark==null||json[i].alarm_deal_delay_remark=='')?'-':json[i].alarm_deal_delay_remark) + '</td><td>'
                        + '<input type="button"  class="btn btn-primary  operation " value="合并"  onclick="mergeAlarm(\'' + json[i].alarmId + '\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+json[i].resultId+'\',\''+"monthlyList"+'\')">' + '</td><td>'
                        + '<input type="button" class="btn btn-primary  operation" disabled value="处理"  onclick="openDealBCModal(\''+json[i].alarmId+'\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+json[i].resultId+'\',\''+"monthlyList"+'\')">' + '</td><td>'
                        + '<input type="button" class="btn btn-primary  operation" value="修改"  onclick="openChangeBCModal(\'' + json[i].alarmId + '\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\',\''+"monthlyList"+'\')">' + '</td></tr>'
                }
                $("#monthly-alarm-list-tbody").append(str);
            }
            else {alert("无数据！")}
        },
        complete: function() {
            layer.close(loading);
            setScrollHeight();
            //判断是否在期限内
            var days=differenceValue(alarm_list_start,alarm_list_end);
            var start=days[0];
            var end=days[1];
            if (start=='true'||end=='true'){
                $('.operation').attr('disabled', false);
            }
        }
    });
}
//bc报警页面全选
$(".mergeBCAlarmTypeAll").click(function(){
    sameCheckedSet2($(this));
});

function sameCheckedSet2(eleInput){
    var checkAll = $(".mergeBCAlarmTypeAll");
    var checkItem = $(".mergeBCAlarmType");
    if(eleInput.is(".mergeBCAlarmTypeAll")){
        if( !eleInput.is(':checked') ){
            checkItem.prop("checked",false);
        }else{
            checkItem.prop("checked",true);
        }
    }else if(eleInput.is(".mergeBCAlarmType")){
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
//未全选时，全选不勾；全选时，全选自动勾选
$("#bcAlarm-tbody").on("click",".mergeBCAlarmType",function(){
    var a=0;
    var b=0;
    var box = document.getElementsByClassName('mergeBCAlarmType');

    for ( var i = 0; i < box.length; i++) {

        if (!box[i].checked) {
            $(".mergeBCAlarmTypeAll").prop("checked", false);
            b = b + 1;
        } else {
            a = a + 1;
        }
    }
    if (a==box.length){
        $(".mergeBCAlarmTypeAll").prop("checked",true);
    }

});

//报警清单页面全选
$(".mergeBCAlarmToListAll").click(function(){
    sameCheckedSet3($(this));
});

function sameCheckedSet3(eleInput){
    var checkAll = $(".mergeBCAlarmToListAll");
    var checkItem = $(".mergeBCAlarmToList");
    if(eleInput.is(".mergeBCAlarmToListAll")){
        if( !eleInput.is(':checked') ){
            checkItem.prop("checked",false);
        }else{
            checkItem.prop("checked",true);
        }
    }else if(eleInput.is(".mergeBCAlarmToList")){
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
//未全选时，全选不勾；全选时，全选自动勾选
$("#monthly-alarm-list-tbody").on("click",".mergeBCAlarmToList",function(){
    var a=0;
    var b=0;
    var box = document.getElementsByClassName('mergeBCAlarmToList');

    for ( var i = 0; i < box.length; i++) {

        if (!box[i].checked) {
            $(".mergeBCAlarmToListAll").prop("checked", false);
            b = b + 1;
        } else {
            a = a + 1;
        }
    }
    if (a==box.length){
        $(".mergeBCAlarmToListAll").prop("checked",true);
    }

});




/*==============合并bc报警数据=====================*/
function mergeAlarm(alarmId,deptName,alarmType,resultId,type) {
    var mergeIds=new Array();
    var resultIds=new Array();
    if (type=='monthlyList'){
        $("input[name=mergeBCAlarmToList]:checked").each(function(){
            var mergeId= $(this).val().split(',')[0];
            var resultId= $(this).val().split(',')[3];
            if (mergeId!='on'){
                mergeIds.push(mergeId);
                resultIds.push(resultId);
            }
        });
    } else {
        $("input[name=mergeBCAlarmType]:checked").each(function(){
            var mergeId= $(this).val().split(',')[0];
            var resultId= $(this).val().split(',')[3];
            if (mergeId!='on'){
                mergeIds.push(mergeId);
                resultIds.push(resultId);
            }

        });
    }
    // alert(mergeId.toString());
    //将合并项中的最后保留项删除
    var index = mergeIds.indexOf(alarmId);
    var index1 = resultIds.indexOf(resultId);
    if (index > -1) {
        mergeIds.splice(index, 1);
    }
    if (index1 > -1) {
        resultIds.splice(index1, 1);
    }
    if (mergeIds.toString().length>0) {
        $.ajax({
            url: "/interlocking/merge/bcAlarm",
            contentType: "application/json",
            data: JSON.stringify({
                "alarmId": alarmId,
                "mergeId": mergeIds.toString(),
                "deptName": deptName,
                "alarmType": alarmType,
                "resultId": resultIds.toString()
            }),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
                loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
            },
            success: function (result) {
                // var json=JSON.parse(result);
                var code=JSON.parse(result.code);
                var msg=JSON.parse(JSON.stringify(result.msg));
                if(code==200){
                    if (type=='monthlyList'){
                        search_bc_monthly_alarm_list($("#workshop4 option:selected").val());
                    } else {
                        search_bc_alarm_data();
                    }
                }
                alert(msg);
            },
            complete: function() {
                layer.close(loading);
            }
        });
    }else {
        alert("请选择需要合并的数据！");
    }

}
var dealBCAlarm_alarmId='';
var dealBCAlarm_deptName='';
var dealBCAlarm_alarmType='';
var dealBCAlarm_type='';
var dealBCAlarm_resultId='';
function closeDealBCModal(){
    document.getElementById("dealBC_modal_cover").style.display="none";
}
function openDealBCModal(param1,param2,param3,param5,param4){
     dealBCAlarm_alarmId=param1;
     dealBCAlarm_deptName=param2;
     dealBCAlarm_alarmType=param3;
     dealBCAlarm_type=param4;
     dealBCAlarm_resultId=param5;
    document.getElementById("dealBC_modal_cover").style.display = "block";
}
function changeBorder(){
    var dealStatus = $("#dealBCAlarmStatus option:selected").val();
    var dealRemark = $("#dealBCAlarmRemark").val();
    // alert(dealStatus);
    if (dealStatus == '2') {
        if (dealRemark != null && dealRemark != ""){
            // $("#dealBCAlarmRemark").css("border-color","1px solid #ccc");
            $("#dealBCAlarmRemark").attr("style", "border:1px solid #ccc");
            $("#dealBCAlarmRemark").attr('placeholder','');
        }else {
            // $("#dealBCAlarmRemark").css("border-color","2px solid #F44336");
            $("#dealBCAlarmRemark").attr("style", "border:1px solid #f44336");
            $("#dealBCAlarmRemark").attr('placeholder','请填写备注');
        }
    }else {
        // $("#dealBCAlarmRemark").css("border-color","1px solid #ccc");border: 1px solid #ccc;
        $("#dealBCAlarmRemark").attr("style", "border:1px solid #ccc");
        $("#dealBCAlarmRemark").attr('placeholder','');
    }

}

/*=================bc类报警处理===========*/
function dealAlarm() {
    var dealStatus = $("#dealBCAlarmStatus option:selected").val();
    var dealRemark = $("#dealBCAlarmRemark").val();

    if (dealStatus == '2') {
        if (dealRemark != null && dealRemark != ""){
            dealAlarm2(dealStatus,dealRemark);
        }
        else {alert("请填写备注！")}
    }
    else {
        dealAlarm2(dealStatus,dealRemark);
    }
}
function    dealAlarm2(dealStatus,dealRemark){

    var dealStatus = $("#dealBCAlarmStatus option:selected").val();
    var dealRemark = $("#dealBCAlarmRemark ").val();
    var alarmIds=new Array();
    var deptNames=new Array();
    var alarmTypes=new Array();
    var resultIds=new Array();
    if (dealBCAlarm_type=='monthlyList') {
        $("input[name=mergeBCAlarmToList]:checked").each(function(){
            var a= $(this).val().split(",");
            alarmIds.push(a[0]);
            deptNames.push(a[1]);
            alarmTypes.push(a[2]);
            resultIds.push(a[3]);

        });
    }else {
        $("input[name=mergeBCAlarmType]:checked").each(function(){
            var a= $(this).val().split(",");
            alarmIds.push(a[0]);
            deptNames.push(a[1]);
            alarmTypes.push(a[2]);
            resultIds.push(a[3]);

        });
    }
    // alert(alarmIds.concat(dealBCAlarm_alarmId).toString()+"==="+deptNames.concat(dealBCAlarm_deptName).toString()+"==="
    //     +alarmTypes.concat(dealBCAlarm_alarmType).toString()+"=============="+resultIds.concat(dealBCAlarm_resultId).toString());
    $.ajax({
        url: "/interlocking/repair/deal/bcAlarm",
        contentType: "application/json",
        data: JSON.stringify({
            "alarmIds": alarmIds.concat(dealBCAlarm_alarmId).toString(),
            "deptNames": deptNames.concat(dealBCAlarm_deptName).toString(),
            "alarmTypes": alarmTypes.concat(dealBCAlarm_alarmType).toString(),
            "resultIds": resultIds.concat(dealBCAlarm_resultId).toString(),
            "dealStatus": dealStatus,
            "dealRemark":dealRemark
        }),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var json=result.data;
            var code=result.code;
            if (code=='200'){
                if (dealBCAlarm_type=='monthlyList'){
                    search_bc_monthly_alarm_list($("#workshop4 option:selected").val());
                } else {
                    search_bc_alarm_data();
                }
            }
            alert(json);
        },
        complete: function() {
            layer.close(loading);
            closeDealBCModal();
        }
    });

}

//开启关闭bc类报警类型
var changeBCAlarmType_alarmId='';
var changeBCAlarmType_deptName='';
var changeBCAlarmType_alarm_type='';
var changeBCAlarmType_table_name='';
function closeChangeBCModal(){
    document.getElementById("changeBC_modal_cover").style.display="none";
}
function openChangeBCModal(alarmId,deptName,alarm_type,type){
     changeBCAlarmType_alarmId=alarmId;
     changeBCAlarmType_deptName=deptName;
     changeBCAlarmType_alarm_type=alarm_type;
     changeBCAlarmType_table_name=type;
    document.getElementById("changeBC_modal_cover").style.display = "block";

}
/*====================修改BC类报警类型===================*/
function changeBCAlarmType() {
    var  alarmType=$("#changeBCAlarmselectType option:selected").val(); //报警类型

    var name= new Array(); //责任部门
    $("input:checkbox[name='changeBCAlarmDepart']:checked").each(function () {
        name.push($(this).val());
    });

    var alarmIds=new Array();
    var deptNames=new Array();
    // alert(changeBCAlarmType_table_name);
    //判断为月度清单
    if (changeBCAlarmType_table_name=='monthlyList') {
        $("input[name=mergeBCAlarmToList]:checked").each(function(){
            var a= $(this).val().split(",");
            alarmIds.push(a[0]);
            deptNames.push(a[1]);
        });
    }else {  //判断为报警清单
        $("input[name=mergeBCAlarmType]:checked").each(function(){
            var a= $(this).val().split(",");
            alarmIds.push(a[0]);
            deptNames.push(a[1]);
        });
    }
    if (name.length>0){
        $.ajax({
            url: "/interlocking/repair/changeType/bcAlarm",
            contentType: "application/json",
            data: JSON.stringify({
                "alarmId": alarmIds.concat(changeBCAlarmType_alarmId).toString(),
                "deptName": deptNames.concat(changeBCAlarmType_deptName).toString(),
                "alarm_before_type": changeBCAlarmType_alarm_type,
                "alarm_after_Type":alarmType,
                "responsibilityDeptName":name.toString()
            }),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
                loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
            },
            success: function (result) {
                var json=result.data;
                var code=result.code;
                if (code=='200'){
                    if (changeBCAlarmType_table_name=='monthlyList'){
                        search_bc_monthly_alarm_list($("#workshop4 option:selected").val());
                    } else {
                        search_bc_alarm_data();
                    }
                }
                alert(json);
            },
            complete: function() {
                closeChangeBCModal();
                layer.close(loading);
            }
        });
    }else {alert("请至少选择一个部门");}

}

/*=======================工具方法=======================================*/
//计算两个时间测差值
function getHour(s1, s2) {
    var reDate = /\d{4}-\d{1,2}-\d{1,2} /;
    s1 = new Date((reDate.test(s1) ? s1 : '2017-1-1 ' + s1).replace(/-/g, '/'));
    s2 = new Date((reDate.test(s2) ? s2 : '2017-1-1 ' + s2).replace(/-/g, '/'));
    var ms = s2.getTime() - s1.getTime();
    if (ms < 0) return 0;
    return Math.floor(ms / 1000 / 60 /60);
}

//判断是否满足距月底第几天
function differenceValue(startDays,endDays){
    var array = new Array();
    var d = new Date();
//d.getMonth()+1代表下个月，月份索引从0开始，即当前月为6月时，getMonth()返回值为5，创建日期时同理
//此处构造的日期为下个月的第0天，天数索引从1开始，第0天即代表上个月的最后一天
    var curMonthDays = new Date(d.getFullYear(), (d.getMonth()+1), 0).getDate();
    var nowDay = d.getDate();
    var a='';
    var b='';
    var differenceValue=curMonthDays-nowDay;
    if (differenceValue<endDays) {a= 'true'}
    else {a= 'false'}
    if (nowDay<=startDays){
        b='true'
    } else {b='false'}

    array.push(a,b);
    return array;
}


//下载月度清单
function downloadBB(){

    var deptName = $("#workshop4 option:selected").val();
    var title='';
    if (deptName=='test'){
        title='选矿厂'
    }else {
        title=deptName;
    }
    var da=['部门','设备','运行时间','内容','时间','次数','责任人'].toString();
    location.href = "/downloadBB123?data="+da+"&title="+title+"月度报警清单";
}





function getAllDeptName2(){
    $.ajax({
        url: "/interlocking/deptName",
        data:[],
        type: "get",
        cache: true,
        dataType: "json",
        success: function (result) {
            var json = result.data;
            var str = '';
            var str1='';
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].deptName +"'>"+json[i].deptName+"</option>";
            }

            $('.allDepart1').empty().append(str);


        }
    });
}
getAllDeptName2();


//获取滚动条距顶高度
function getScrollHeight(){
    if(document.documentElement&&document.documentElement.scrollTop){
        scrollTop=document.documentElement.scrollTop;
    }else if(document.body){
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}
//设置滚动条距顶高度
function setScrollHeight() {
    $("html,body").animate({"scrollTop":scrollTop});
}
