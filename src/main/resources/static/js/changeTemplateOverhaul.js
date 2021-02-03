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
            $('#overhaulDeptNameadd').empty().append(str1);
            $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
            $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
            $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');


        }
    });
});

    //==============================设备=============================
    function getDevName(){
        var deptName = $("#workshop option:selected").val();
        $('#part').empty().append('<option value="test">' + '全部部位'+ '</option>');
        $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
        $.ajax({
            url: "/changeTemplateOverhaul/devName",
            contentType: "application/json",
            data:JSON.stringify({"deptName":deptName}),
            type: "post",
            cache: true,
            dataType: "json",
            success: function (result) {
                var data=result.data;
                $('#equip').empty().append('<option value="test">' + '全部设备'+ '</option>');
                for (var i = 0; i < data.length; i++) {
                        $('#equip').append('<option value="' + data[i].devName + '">' + data[i].devName+ '</option>');
                }

            }
        });
    }
    //==============================部位================================
    function getPartName(){
        var deptName = $("#workshop option:selected").val();
        var equip = $("#equip option:selected").val();
        $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
        $.ajax({
            url: "/changeTemplateOverhaul/partName",
            contentType: "application/json",
            data:JSON.stringify({"deptName":deptName,"devName":equip}),
            type: "post",
            cache: true,
            dataType: "json",

            success: function (result) {
                var data=result.data;
                $('#part').empty().append('<option value="test">' + '部位'+ '</option>');
                for (var i = 0; i < data.length; i++) {
                    $('#part').append('<option value="' + data[i].scPart + '">' + data[i].scPart+ '</option>');
                }
            }
        });
    }

    //=============================内容============================
    function getContent(){
        var deptName = $("#workshop option:selected").val();
        var equip = $("#equip option:selected").val();
        var part = $("#part option:selected").val();
        //
        $.ajax({
            url: "/changeTemplateOverhaul/content",
            contentType: "application/json",
            data:JSON.stringify({"deptName":deptName,"devName":equip,"scPart":part}),
            type: "post",
            cache: true,
            dataType: "json",
            success: function (result) {
                var data=result.data;
                $('#content').empty().append('<option value="test">' + '全部内容'+ '</option>');
                for (var i = 0; i < data.length; i++) {
                    $('#content').append('<option value="' + data[i].scContent + '">' + data[i].scContent+ '</option>');
                }
            }
        });

    }


/*-------------查询数据-------*/
function search() {
    var equip = $("#equip option:selected").val();
    var part = $("#part option:selected").val();
    var content = $("#content option:selected").val();
    var deptName = $("#workshop option:selected").val();
    var length=0;
    $.ajax({
        url: "/changeTemplateOverhaul/getResult",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"devName":equip,"scPart":part,"content":content}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            $('.tbody').empty();
            loading = layer.msg('正在加载···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var json = result.data;
            length=json.length;
            var str='';
            for (var i = 0; i < length; i++) {
                str += '<tr><td>'+(i + 1) + '</td><td>'
                    + json[i].deptName + '</td><td>'
                    + json[i].devName + '</td><td>'
                    + json[i].scPart + '</td><td>'
                    + json[i].scContent + '</td><td>'
                    + '<input type="button" class="btn btn-warning" value="修改" style="cursor: pointer;"' +
                        'onclick="openModule(\'' + json[i].resultId + '\',\''+json[i].deptName+'\',\''+json[i].devName+'\',\''+json[i].scPart+'\' ,\''+json[i].scContent+'\')">' + '</td><td>'
                    + '<input type="button" class="btn btn-warning" value="删除" style="cursor: pointer;"' +
                        'onclick="deleteData(\'' + json[i].resultId +'\')">' + '</td></tr>';
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
function deleteData(id) {
    var code=0;
    $.ajax({
        url: "/changeTemplateOverhaul/deleteData",
        contentType: "application/json",
        data:JSON.stringify({"id":id}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            loading = layer.msg('删除中···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            code = result.code;
            alert(result.msg);
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
var overhaulid;
/*-------------打开修改模板-------*/
function openModule(id,deptName,devName,scPart,scContent) {
    $("#module_cover").css('display','block');
    overhaulid=id;
    $("#overhaulDeptName").text(deptName);
    $("#overhaulDevName").val(devName);
    $("#overhaulPart").val(scPart);
    $("#overhaulContent").val(scContent);

}
function openModuleadd() {
    $("#module_cover_add").css('display','block');
}
/*-------------关闭修改模板-------*/
function closeModule() {
    $("#module_cover").css('display','none');
}
function closeModuleadd() {
    $("#module_cover_add").css('display','none');
}
/*-------------修改报警类型-------*/
function changeData() {
    var code=0;
    var overhaulDevName = $("#overhaulDevName").val();
    var overhaulPart = $("#overhaulPart").val();
    var overhaulContent = $("#overhaulContent").val();
    // alert(overhaulid+"---"+overhaulDevName+"---"+overhaulPart+"--"+overhaulContent);
    $.ajax({
        url: "/changeTemplateOverhaul/changeData",
        contentType: "application/json",
        data:JSON.stringify({"id":overhaulid,"devName":overhaulDevName,'scPart':overhaulPart,'scContent':overhaulContent}),
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
function addData() {
    var deptName = $("#overhaulDeptNameadd option:selected").val() ;
    var overhaulDevName = $("#overhaulDevNameadd").val();
    var overhaulPart = $("#overhaulPartadd").val();
    var overhaulContent = $("#overhaulContentadd").val();
    $.ajax({
        url: "/changeTemplateOverhaul/addData",
        contentType: "application/json",
        data:JSON.stringify({"deptName":deptName,"devName":overhaulDevName,'scPart':overhaulPart,'scContent':overhaulContent}),
        type: "post",
        cache: true,
        dataType: "json",
        beforeSend: function() {
            loading = layer.msg('添加中···', {icon: 16, shade: 0.3, time:0});
        },
        success: function (result) {
            var result2 = eval(result);
            code = result2.code;
            alert(result2.msg);
        },
        complete: function() {
            closeModuleadd();
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