function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    if(r!=null)return  unescape(r[2]);return null;
}
var name = GetQueryString("user");
// alert(name);





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

//报警是否选择，执行
$("#bjCheck input").click(function () {
    var chooseAlarm=$("#bjCheck input[type='checkbox']").is(':checked');
    //当选择报警后，会显示出报警类别的选择
    if (chooseAlarm===true) {$(".bjType").css("display","")}
    //当不选择报警后，会隐藏出报警类别的选择
    else {$(".bjType").css("display","none")}
});


function search(c) {
    if (c==='a'){
        $("#nowPage1").empty().append("<option value="+1+">"+1+"</option>");
        $("#nowPage").empty().val(1)
    }

    var start=$("#dateStart").val();
    var end=$("#dateEnd").val();
    var deptName = $("#workshop option:selected").val();
    var route = $("#route option:selected").val();
    var zone = $("#zone option:selected").val();
    var equip = $("#equip option:selected").val();
    var part = $("#part option:selected").val();
    var content = $("#content option:selected").val();

    var zcCheck = $("#zcCheck input[type='checkbox']").is(':checked');
    var bjCheck = $("#bjCheck input[type='checkbox']").is(':checked');
    var bjType1 = $("#alarmType1 input[type='checkbox']").is(':checked');
    var bjType2 = $("#alarmType2 input[type='checkbox']").is(':checked');
    var bjType3 = $("#alarmType3 input[type='checkbox']").is(':checked');
    var wjCheck = $("#wjCheck input[type='checkbox']").is(':checked');
    var totalData=$("#totalData").val();
    var nowPage=$("#nowPage").val(); // 当前页数
    numPerPage=$("#numPerPage option:selected").val(); // 每页条数
    if (nowPage==null){
        nowPage==1;
    }
    startPage = (nowPage-1)*numPerPage;
    // alert("deptName==="+deptName+";route==="+route+";zone=="+zone+";equip=="+equip+";part=="+part+";content=="+content+";startTime=="+start+";endTime=="+end+
    //     ";zcCheck=="+zcCheck+";bjCheck=="+bjCheck+";bjType1=="+bjType1+";bjType2=="+bjType2+";bjType3=="+bjType3+";wjCheck=="+wjCheck+";startPage=="+startPage+";numPerPage=="+numPerPage)
    $.ajax({
        url: "/interlocking/getResult",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"route":route,"zone":zone,"equip":equip,"part":part,"content":content,"startTime":start,"endTime":end,
            "zcCheck":zcCheck,"bjCheck":bjCheck,"bjType1":bjType1,"bjType2":bjType2,"bjType3":bjType3,"wjCheck":wjCheck,"startPage":startPage,"numPerPage":numPerPage}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
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

                var alpid = json[i].altpid;
                var alarmFlag = json[i].alarmFlag;
                if (alpid == 1) {
                    str += '<tr style="background-color: #ffa315"><td>'
                } else if (alpid == 2) {
                    str += '<tr style="background-color: #ff3d1f"><td>'
                } else if (alpid == 0) {
                    str += '<tr><td>'
                } else {
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
                    + ((json[i].deal_remark==null||json[i].deal_remark=='')?'-':json[i].deal_remark)+ '</td><td>'
                    + (alpid<1?'-': '<input type="button" class="btn btn-warning" value="修改" style="cursor: pointer;"onclick="openModal(\''+json[i].resultId+'\'\,\''+json[i].deptName+'\')">')+'</td><td>'
                    + judgeAlarm(json[i].abnormalHandleAdminType)+ '</td><td>'
                    + (json[i].abnormalHandleDealDepart==null?'-':json[i].abnormalHandleDealDepart) + '</td><td>'
                    + (json[i].abnormalHandleUser==null?'-':json[i].abnormalHandleUser)+'</td></tr>';

            }

            $('#groupTable').append(str);
        },

        complete: function() {
            layer.close(loading);
            if (length==0){
                setTimeout('alert("无数据")','40')
            }
        }
    })

}


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


var spotId='';
var spotPart='';
function closeModal(){
    document.getElementById("modal_cover").style.display="none";
}
function openModal(param1,param2){
    spotId=param1;
    spotPart=param2;
    // alert(param1+"========="+param2);

    document.getElementById("modal_cover").style.display = "block";
}
//修改报警类型
function changeType() {
    var  alarmType=$("#selectType option:selected").val();
    var sksb = $("#sksb input[type='checkbox']").is(':checked');
    var sksc = $("#sksc input[type='checkbox']").is(':checked');
    var mfsb = $("#mfsb input[type='checkbox']").is(':checked');
    var mfsc = $("#mfsc input[type='checkbox']").is(':checked');
    var jwsb = $("#jwsb input[type='checkbox']").is(':checked');
    var jwsc = $("#jwsc input[type='checkbox']").is(':checked');
    var dy = $("#dy input[type='checkbox']").is(':checked');
    // alert(sksb);

    if(sksb===true||sksc===true||mfsb===true||mfsc===true||jwsb===true||jwsc===true||dy===true){

        var elementsByName = document.getElementsByName("gdxz");
        var chk_value =[];
        for(k in elementsByName){
            if (elementsByName[k].checked)
                chk_value.push(elementsByName[k].value);
        }
        // alert(chk_value.toString());
        $.ajax({
            url: "/interlocking/changeAlarmType",
            contentType: "application/json",
            data:JSON.stringify({"resultId":spotId,"part":spotPart,"alarmType":alarmType,"name":name,"selectDepart":chk_value.toString()}),
            type: "post",
            cache: true,
            dataType: "json",
            beforeSend: function() {
            },
            success: function (result) {
               var data= result.data;
                alert(data)
            }
        });

        closeModal();
    }
    else {
        alert("请至少选择一个部门")
    }



    // var selectDepart=$("#popupWindow-allDept option:selected").val();


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