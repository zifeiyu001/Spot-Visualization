
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
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].deptName +"'>"+json[i].deptName+"</option>";
            }
            $('#workshop').empty().append(str);
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
        return '报警'
    }
    else if(dealEstimate=='2'){
        return '危险'
    }
    else if(dealEstimate=='3'){
        return '-'
    }
    else {
        return '正常'
    }

}

// jeDate({
//     dateCell:"#dateStart",
//     format:"YYYY-MM-DD hh:mm:ss",
//     // format:"YYYY-MM-DD 00:00:00",
//     isinitVal:true,
//     isTime:true, //isClear:false,
//     initHour:-24,
//     minDate:"1900-01-01 00:00:00",
//     okfun:function(val){alert(val)}
// });
// jeDate({
//
//     dateCell:"#dateEnd",
//     // format:"YYYY-MM-DD 00:00:00",
//     format:"YYYY-MM-DD hh:mm:ss",
//     isinitVal:true,
//
//     isTime:true, //isClear:false,
//     minDate:"1900-01-01 00:00:00",
//     okfun:function(val){alert(val)}
// });


// $("#reduceNum").click(function (){
//     nowPage = $("#nowPage").val();
//     if (nowPage>1) {
//         $("#nowPage").val(nowPage-1);
//
//         search()
//     }
//
// });
// $("#andNum").click(function (){
//     nowPage = $("#nowPage").val();
//     if (nowPage<=total/numPerPage) {
//         $("#nowPage").val( Number($("#nowPage").val())+1);
//         search()
//     }
// });
// $("#nowPage1").click(function () {
//     $("#nowPage").val($("#nowPage1 option:selected").val())
//
// });
function search() {

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
    var wxCheck = $("#wxCheck input[type='checkbox']").is(':checked');
    var wjCheck = $("#wjCheck input[type='checkbox']").is(':checked');
    var totalData=$("#totalData").val();
    var nowPage=$("#nowPage").val(); // 当前页数
    numPerPage=$("#numPerPage option:selected").val(); // 每页条数
    if (nowPage==null){
        nowPage==1;
    }
    startPage = (nowPage-1)*numPerPage;
    $.ajax({
        url: "/interlocking/getResult",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"route":route,"zone":zone,"equip":equip,"part":part,"content":content,"startTime":start,"endTime":end,
            "zcCheck":zcCheck,"bjCheck":bjCheck,"wxCheck":wxCheck,"wjCheck":wjCheck,"startPage":startPage,"numPerPage":numPerPage}),
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
                    + (json[i].personLiable==null?"-":json[i].personLiable) + '</td><td>'
                    + (json[i].userName==null?"-":json[i].userName) + '</td><td>'
                    + json[i].result + '</td><td>'
                    + judgeAlarm(json[i].altpid) + '</td><td>'
                    + judgeRemark(json[i].remark) + '</td></tr>';
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








