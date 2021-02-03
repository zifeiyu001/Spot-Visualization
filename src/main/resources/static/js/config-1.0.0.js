
var deptLength='';
var str1='生产';
var alarmType='';
//----------------------------------配置页面公共----------------------------------
//   --选择目录- ->
function chooseItem(param){
    if (param==='duty'){

        $("#li1").attr("class","active");
        $("#li2").attr("class","");
        $("#li3").attr("class","");
        $("#li4").attr("class","");
        $("#li5").attr("class","");
        $(".form1").show();
        $(".form2").hide();
        $(".form3").hide();
        $(".form4").hide();
        $(".form5").hide();
        getAllDept(param);
    }
    else if(param==='manage'){

        $("#li1").attr("class","");
        $("#li2").attr("class","active");
        $("#li3").attr("class","");
        $("#li4").attr("class","");
        $("#li5").attr("class","");
        $(".form1").hide();
        $(".form2").show();
        $(".form3").hide();
        $(".form4").hide();
        $(".form5").hide();
        getAllDept(param);
    }
    else if(param==='template'){
        $("#li1").attr("class","");
        $("#li2").attr("class","");
        $("#li3").attr("class","");
        $("#li4").attr("class","active");
        $("#li5").attr("class","");
        $(".form1").hide();
        $(".form2").hide();
        $(".form3").hide();
        $(".form4").show();
        $(".form5").hide();
    }
    else if (param==='config') {
        $("#li1").attr("class","");
        $("#li2").attr("class","");
        $("#li3").attr("class","active");
        $("#li4").attr("class","");
        $("#li5").attr("class","");
        $(".form1").hide();
        $(".form2").hide();
        $(".form3").show();
        $(".form4").hide();
        $(".form5").hide();
        getConfigData();
    }else {
        $("#li1").attr("class","");
        $("#li2").attr("class","");
        $("#li3").attr("class","");
        $("#li4").attr("class","");
        $("#li5").attr("class","active");
        $(".form1").hide();
        $(".form2").hide();
        $(".form3").hide();
        $(".form4").hide();
        $(".form5").show();
    }
}
function updateConfigData() {

    var a=$("#alarmList_start").val();
    var b=$("#alarmList_end").val();
    var c=$("#alarm_c_deal_start").val();
    var d=$("#alarm_c_deal_end").val();
    var e=$("#alarm_tips_time").val();
    $.ajax({
        url: "/pc/config/setConfigData",
        contentType: "application/json",
        data: JSON.stringify({
            "alarm_list_start": a,
            "alarm_list_end":b,
            "alarm_c_deal_start": c,
            "alarm_c_deal_end":d,
            "alarm_tips_time": e

        }),
        cache: true,
        dataType: "json",
        type: "post",
        success: function (result) {
            var data=result.data;
            alert(data);
        }});


}
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
            $("#alarmList_start").val(data[0].alarm_list_start);
            $("#alarmList_end").val(data[0].alarm_list_end);
            $("#alarm_c_deal_start").val(data[0].alarm_c_deal_start);
            $("#alarm_c_deal_end").val(data[0].alarm_c_deal_end);
            $("#alarm_tips_time").val(data[0].alarm_tips_time);
        }});
}
//默认执行第一个目录
$(function () {
    $("#li1").attr("class","active");
    getAllDept('duty');
});
//获取所有的部门
function getAllDept(param) {
    $.ajax({
        url: "/pc/getdept",
        data: [],
        type: "get",
        cache: true,
        dataType: "json",
        success: function (result) {

            var json = result.data;
            var str = "<option value='test'>" + "部门选择" + "</option>";
            for (var i = 0; i < json.length; i++) {
                str += "<option value='" + json[i].deptId + "'>" + json[i].deptName + "</option>";
            }
            $('#workshopUser').empty().append(str);
            if (param === 'duty') {
                $('#workshopUser1').empty().append(str);
            } else {
                $('#workshopUser2').empty().append(str);
            }
        }
    });
}
var mm='1';
//获取部门中的用户
function getUser(param) {
    $("#liable-details-div").show();
    getLiable();
    mm='2';
    $("#liable-details").text("收起");
    var content='';
    if (param==='duty') {  content = $("#workshopUser1 option:selected").val();}
    else { content = $("#workshopUser2 option:selected").val();}
    // $("#mana-depart").empty();
    $("#mana-team").empty();
    // alert(content)
    $.ajax({
        url: "/pc/getdeptUser",
        data:JSON.stringify({"equipId":content}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {

            var json = result.data;
            var str = "<option value='test'>"+"人员选择"+"</option>";
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].userId +"'>"+json[i].user+"</option>";
            }
            if (param==='duty') {  $('#user1').empty().append(str);}
            else {  $('#user2').empty().append(str);}

        }
    });
}


//---------------------------------责任人页面--------------------------------------------


$("#liable-details").click(function () {
    if (mm==='1'){$("#liable-details-div").show();getLiable(); mm='2';$("#liable-details").text("收起") }
    else {$("#liable-details-div").hide(); mm='1';$("#liable-details").text("详情") }
});
//点击选择 ，隐藏工段div
$(".hiddenDiv").click(function (){
    $("#mana-depart").hide();
    $("#mana-team").hide();
});
//------------显示所有工段及已经管理的工段
function getDeptName(){


    // $('#mana-depart').empty();
    var userId = $("#user1 option:selected").val();
    var alarmType=$("#alarmType option:selected").val();
    var team=$("#team option:selected").val();
    if(userId!=='test'&& typeof(userId) !=="undefined"){
        $("#mana-depart").show();
        $("#mana-team").show();
        $("#choosepart").show();
        $.ajax({
            url: "/pc/config/getDeptName",
            data:JSON.stringify({"userId":userId,"alarmType":alarmType,"team":team}),
            contentType: "application/json",
            type: "post",
            cache: true,
            dataType: "json",
            success: function (result) {
                var json = result.deptData;  //所有的工段
                var selected=result.userDeptDdata;//当前用户有的字段
                deptLength=json.length;
                //根据数据长度，对每个工段设置一个div，
                var arr = '';
                //当用户下已有工段时
                $('#all_depart').empty();
                if (selected.length>0) {
                    arr = selected[0].department.split(',');
                    //遍历所有的工段
                    for (var i=0; i < json.length; i++) {
                        var str = "";
                        //遍历已有的工段
                        for(var m=0;m<arr.length-1;m++){
                            //当已有时，将选择框改为选中状态
                            if (json[i].deptName===arr[m]) {
                                str =  '<label class="choosedept" id="dept'+i+'">'+json[i].deptName+'<input type="checkbox" name="check"  checked value="'+json[i].deptName+'"></label>';
                                break ;
                                //当没有时，将选择框改为未选状态
                            } else {
                                str =  '<label class="choosedept" id="dept'+i+'">'+json[i].deptName+'<input type="checkbox" name="check" value="'+json[i].deptName+'"></label>';
                            }
                        }
                        $('#all_depart').append(str);
                    }

                }else {// 用户下没有工段时 直接展示所有工段
                    var str='';
                    for (var s=0; s < json.length; s++) {
                        str +=  '<label class="choosedept"  id="dept'+s+'">'+json[s].deptName+'<input type="checkbox" name="check"   value="'+json[s].deptName+'"></label>';
                    }
                    $('#all_depart').empty().append(str);
                }
                $('#save').empty().append('<label type="button" class="btn btn-primary" style = "width:23%;margin-left: 15%;" onclick="save()">保存</label>')
            }
        });
    }else {alert("请选择人员")}
}


// ---获取所有的责任人
function getLiable(){
    var str='';
    var workshopId=$("#workshopUser1 option:selected").val();
    $.ajax({
        url: "/pc/config/liable_exist",
        data:JSON.stringify({"workshopId":workshopId}),
        contentType: "application/json",
        cache: true,
        dataType: "json",
        type: "post",
        success: function (result) {
            var data=result.data;

            for (var a=0;a<data.length;a++){
                str +=  '<tr><td>'+(a+1)+ '</td><td>'
                    + data[a].deptName+ '</td><td>'
                    // + (data[a].team==='null'?'-':data[a].team)+ '</td><td>'
                    + data[a].user+  '</td><td>'
                    + data[a].department+  '</td><td>'
                    + judgeAlarmType(data[a].alarmType)+  '</td><td>'
                    +'<input type="button" value="删除" style="cursor: pointer;" onclick="deleteLiableUser(\''+data[a].userId+'\',\''+data[a].department+'\',\''+data[a].alarmType+'\')">'
                    +'</td></tr>';
            }

            $(".liabletbody").empty().append(str)
        }});
}
function deleteLiableUser(a,b,c) {
    // alert(a+"=="+b+"=="+c);
    $.ajax({
        url: "/pc/config/deleteLiableUser",
        data:JSON.stringify({"userId":a,"department":b,"alarmType":c}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            alert(data);
            getLiable()
        }
    })

}
function judgeAlarmType(param){
    if (param==='1'){
        return 'A类报警/立即处理'
    }
    else   if (param==='2'){
        return 'B类报警/检修时处理'
    }
    else   if (param==='3'){
        return 'C类报警/继续观察'
    }
    else {return ""}
}

//保存或者更新报警责任人数据
function save(){

    var alarmType=$("#alarmType option:selected").val();
    var str='';
    var str1='';

    var deptId = $("#workshopUser1 option:selected").val();
    var deptName= $("#workshopUser1").find("option:selected").text();
    var userId = $("#user1 option:selected").val();
    var user= $("#user1").find("option:selected").text();
    var team=$("#team option:selected").val();
    var sksb = $("#sksb1 input[type='checkbox']").is(':checked');
    var sksc = $("#sksc1 input[type='checkbox']").is(':checked');
    var mfsb = $("#mfsb1 input[type='checkbox']").is(':checked');
    var mfsc = $("#mfsc1 input[type='checkbox']").is(':checked');
    var jwsb = $("#jwsb1 input[type='checkbox']").is(':checked');
    var jwsc = $("#jwsc1 input[type='checkbox']").is(':checked');
    var dy =   $("#dy1 input[type='checkbox']").is(':checked');
    var elementsByName = document.getElementsByName("gdxz1");
    var elementsByClassName = document.getElementsByClassName('gdxz1');
    var chk_value = [];
    for (k in elementsByClassName) {
        if (elementsByClassName[k].checked)
            chk_value.push(elementsByClassName[k].value);
    }
     str=chk_value.toString();

    if (deptId!=='test'&&userId!=='test'&& str.length>0) {// 判断数据不为空

            $.ajax({
                url: "/pc/config/chargePerson",
                data:JSON.stringify({"deptId":deptId,"deptName":deptName,"user":user,"userId":userId,"department":str,"alarmType":alarmType,"team":team}),
                contentType: "application/json",
                cache: true,
                dataType: "json",
                type: "post",
                success: function (result) {
                    var data=result.data;
                    if (result.data1==='ok'){getLiable()}
                    alert(data);
                }
            });
    }
    else {
        alert("请将数据填写完整！")
    }

}


//-----------------------------管理人员页面-----------------------------------

// ---默认显示所有的管理人员
function defaultShow(){
    var str='';
    $.ajax({
        url: "/pc/config/manage_exist",
        data:[],
        contentType: "application/json",
        cache: true,
        dataType: "json",
        type: "get",
        success: function (result) {
            var data=result.data;

            for (var a=0;a<data.length;a++){
                str +=  '<tr><td>'+(a+1)+ '</td><td>'
                    + data[a].deptName+ '</td><td>'
                    + data[a].userId+ '</td><td>'
                    + data[a].user+  '</td><td>'
                    +data[a].manageDepart+'</td><td>'
                    +'<input type="button" value="删除" style="cursor: pointer;" onclick="deleteUser(\''+data[a].userId+'\')">'
                    +'</td></tr>';
            }

            $(".tbody").empty().append(str)
        }});
}
defaultShow();

// 管理---配置管理人
function addUser() {
    var user2=$("#user2 option:selected");
    var userId=user2.val();
    var user=user2.text();
    var workshop=$("#workshopUser2 option:selected");
    var deptId=workshop.val();
    var deptName=workshop.text();
    var sksb = $("#sksb input[type='checkbox']").is(':checked');
    var sksc = $("#sksc input[type='checkbox']").is(':checked');
    var mfsb = $("#mfsb input[type='checkbox']").is(':checked');
    var mfsc = $("#mfsc input[type='checkbox']").is(':checked');
    var jwsb = $("#jwsb input[type='checkbox']").is(':checked');
    var jwsc = $("#jwsc input[type='checkbox']").is(':checked');
    var dy =   $("#dy input[type='checkbox']").is(':checked');

    if (userId ==='test' || deptId==='test' ){
        if (deptId==='test'){alert("请选择部门")}
        else {alert("请选择用户")}
    }
    else {
        if(sksb===true||sksc===true||mfsb===true||mfsc===true||jwsb===true||jwsc===true||dy===true) {

            // var elementsByName = document.getElementsByName("gdxz");
            var elementsByName = document.getElementsByClassName("gdxz");
            var chk_value = [];
            for (k in elementsByName) {
                if (elementsByName[k].checked)
                    chk_value.push(elementsByName[k].value);
            }
            $.ajax({
                url: "/pc/config/manage",
                data: JSON.stringify({"deptId": deptId, "deptName": deptName, "user": user, "userId": userId,"manageDepart":chk_value.toString()}),
                contentType: "application/json",
                cache: true,
                dataType: "json",
                type: "post",
                success: function (result) {
                    alert(result.data);
                    if (result.status === 'success') {
                        defaultShow();
                    }
                }
            });
        }
        else { alert("请至少选择一个部门")}
    }
}

//删除用户管理人
function deleteUser(id) {
    $.ajax({
        url: "/pc/config/deleteUser",
        data:JSON.stringify({"userId":id}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            alert(data);
            defaultShow();
        }
    })
}

