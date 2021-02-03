// /*=====================================判断登录用户=================================================*/
//
// // 获取登录用户id
// function GetQueryString(name){
//     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
//     var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
//     if(r!=null){
//         return  unescape(r[2]);
//     }
//     else {
//         return null;
//     }
//
// }
// var name = GetQueryString("user");
// alert(username+"-----"+name)
// //登录用户不为空，session不为空；判断存储的session和登录用户不同时更新session
// if(username !=null && username !==undefined && username !==''&& username !=='null') {
//     if (name !==null && name !==undefined && name !==''&& name !=='null') {
//         if (username===name) {}
//         else {getUser(name)}
//     }
// }
// //session为空；登录用户为空，重新登录；登录用户不为空时，更新session
// else {
//     if (name ===null || name === undefined || name ===''|| name ==='null') {
//         alert("请进行登录");
//         window.location.href='http://172.16.5.4/bkzyCMS/login';
//     } else {  getUser(name)}
// }
//
// // 将用户保存到后台，session
// function getUser(name){
//
//     $.ajax({
//         url: "/spot/user",
//
//         contentType: "application/json",
//         data:JSON.stringify({
//             "name":name
//         }),
//         type: "post",
//         cache: false,
//         async: false,
//         dataType: "json",
//         success: function (result) {
//             var data=result.data;
//
//             if(data===''){
//                 alert("账户不存在，请重新登录...");
//                 window.location.href='http://172.16.5.4/bkzyCMS/login';
//             }
//             else {
//                 // var dept=result.deptdata;
//                 // alert(dept)
//                 // search("c",dept);
//             }
//         }
//     });
// }


$(function () {
    //=========================工段==================================
    $.ajax({
        url: "/changeTemplate/deptName",
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
            $('#route').empty().append('<option value="test">' + '全部线路' + '</option>');
            $('#zone').empty().append('<option value="test">' + '全部区域' + '</option>');
            $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
            $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
            $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');


        }
    });
    //=========================线路================================
    $.ajax({
        url: "/changeTemplate/routeName",
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
        url: "/changeTemplate/zoneName",
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
        url: "/changeTemplate/devName",
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
        url: "/changeTemplate/partName",
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
        url: "/changeTemplate/content",
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
/*-------------查询数据-------*/
function search() {
    var route = $("#route option:selected").val();
    var zone = $("#zone option:selected").val();
    var equip = $("#equip option:selected").val();
    var part = $("#part option:selected").val();
    var content = $("#content option:selected").val();
    var deptName = $("#workshop option:selected").val();
    var length=0;
    $.ajax({
        url: "/changeTemplate/getResult",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"route":route,"zone":zone,
            "equip":equip,"part":part,"content":content}),
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
            var str='';
            for (var i = 0; i < length; i++) {
                str += '<tr><td>'+(i + 1) + '</td><td>'
                    + json[i].deptName + '</td><td>'
                    + json[i].routeName + '</td><td>'
                    + json[i].zoneName + '</td><td>'
                    + json[i].devName + '</td><td>'
                    + json[i].scPart + '</td><td>'
                    + json[i].scContent + '</td><td>'
                    + f(json[i].abnormalHandleType) + '</td><td>'
                    + f(json[i].abnormalHandleAdminType) + '</td><td>'
                    + '<input type="button" class="btn btn-warning" value="修改" style="cursor: pointer;"' +
                        'onclick="openModule(\'' + json[i].resultId + '\',\''+json[i].deptName+'\',\''+json[i].abnormalHandleAdminType+'\')">' + '</td><td>'
                    + '<input type="button" class="btn btn-warning" value="删除" style="cursor: pointer;"' +
                        'onclick="deleteData(\'' + json[i].resultId + '\',\''+json[i].deptName+'\')">' + '</td></tr>';
            }
            $('#groupTable-tbody').append(str);
        },

        complete: function() {
            layer.close(loading);
            if (length==0){
                setTimeout('alert("无数据")','40');

            }
        }
    })
}

/*-------------删除报警模板-------*/
function deleteData(id,deptName) {
    var code=0;
    $.ajax({
        url: "/changeTemplate/deleteData",
        contentType: "application/json",
        data:JSON.stringify({"id":id,"deptName":deptName}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            loading = layer.msg('删除中···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var result2 = eval(result);
            code = result2.code;
            alert(result2.msg);
        },

        complete: function() {
            layer.close(loading);
            if (code==200){
                setTimeout(search(),'400');
            }
        }
    })
}
var deptName;
var id;
/*-------------打开修改模板-------*/
function openModule(id1,deptName1,alarmType) {
    $("#module_cover").css('display','block');
    $("#beforeType").text(f(alarmType));
    deptName=deptName1;
    id=id1;
}
/*-------------关闭修改模板-------*/
function closeModule() {
    $("#module_cover").css('display','none');
}
/*-------------修改报警类型-------*/
function changeType() {
    var code=0;
    var abnormalHandleAdminType = $("#choose option:selected").val();
    // alert(deptName+"---"+abnormalHandleAdminType+"--"+id);
    $.ajax({
        url: "/changeTemplate/changeType",
        contentType: "application/json",
        data:JSON.stringify({"id":id,"deptName":deptName,'abnormalHandleAdminType':abnormalHandleAdminType}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            loading = layer.msg('修改中···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var result2 = eval(result);
            code = result2.code;
            alert(result2.msg);
        },
        complete: function() {
            closeModule();
            layer.close(loading);
            if (code==200){
                setTimeout(search(),'400');
            }
        }
    })
}
/*-------------数字转换为字母-------*/
function f(dealEstimate) {
    if(dealEstimate=='1'){
        return 'A类'
    }
    else if(dealEstimate=='2'){
        return 'B类'
    }
    else if(dealEstimate=='3'){
        return 'C类'
    }else {return '-'}

}