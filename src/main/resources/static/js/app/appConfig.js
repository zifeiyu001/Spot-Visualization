
var deptLength='';
var str1='生产';
var alarmType='';
//----------------------------------配置页面公共----------------------------------
//   --选择目录- ->
function chooseItem(param){
    if (param==='duty'){

        $("#li1").attr("class","active");
        $("#li2").attr("class","");
        $(".form2").hide();
        $(".form1").show();
        getAllDept(param);
    }
    else {
        $("#li2").attr("class","active");
        $("#li1").attr("class","");
        $(".form1").hide();
        $(".form2").show();
        getAllDept(param);
    }
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
            var str = "<option value='test'>全部部门</option>";
            for (var i = 0; i < json.length; i++) {
                if (json[i].deptName.indexOf('生产')>0) {
                    str += "<option value='" + json[i].deptId + "'>" + json[i].deptName + "</option>";
                }
            }
            $('#workshopUser').empty().append(str);
            if (param === 'duty') {
                $('#workshopUser1').empty().append(str);
                $('#route1').empty().append('<option value="test">所有线路</option>');

            } else {
                $('#workshopUser2').empty().append(str);
                $('#job2').empty().append('<option value="test">全部岗位</option>');
                $('#user2').empty().append('<option value="test">全部用户</option>');
            }

        }
    });
}
var routes='';
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


//线路数据添加
function getRoute() {

    var str='';
    var deptName = $("#workshopUser1 option:selected").text();
    str='<option value="test">全部线路</option>';
    for (var i = 0; i < routes.length; i++) {
        if (routes[i].deptName===deptName) {
            str += '<option value="' + routes[i].routeName+ '">' + routes[i].routeName + '</option>';
        }
    }
    $('#route1').empty().append(str);
}
// ---查询
function search(){
    var str='';
    var deptName = $("#workshopUser1 option:selected").text();
    var route = $("#route1 option:selected").val();
    var job = $("#writeJob input[name='job']").val();
    // alert(deptName+"=="+route+"=="+job);
    $.ajax({
        url: "/app/config/station/select",
        data:JSON.stringify({"deptName":deptName,"routeName":route,"station":job}),
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
                    + data[a].station+  '</td><td>'
                    + data[a].routeName+  '</td><td>'
                    // + judgeAlarmType(data[a].alarmType)+  '</td><td>'
                    +'<input type="button" value="删除" style="cursor: pointer;" onclick="deleteJob(\''+data[a].deptName+'\',\''+data[a].station+'\',\''+data[a].routeName+'\')">'
                    +'</td></tr>';
            }

            $(".liabletbody").empty().append(str)
        }});
}

//删除岗位配置内容
function deleteJob(a,b,c) {
    // alert(a+"=="+b+"=="+c);
    $.ajax({
        url: "/app/config/station/delete",
        data:JSON.stringify({"deptName":a,"station":b,"routeName":c}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            if (data>0){alert("删除成功！")}
            else {alert("删除失败！")}
            search();
        }
    })

}
//============================================   人员配置   ==============================================
// //获取部门中的用户
function getUser() {
    var content = $("#workshopUser2 option:selected").val();
// alert(content)
//     $("#mana-team").empty();
    $.ajax({
        url: "/pc/getdeptUser",
        data:JSON.stringify({"equipId":content}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {

            var json = result.data;
            var str = "<option value='test'>"+"全部人员"+"</option>";
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].userId +"'>"+json[i].user+"</option>";
                // alert(json[i].user)
            }
            $('#user2').empty().append(str);
            getTeam();
        }
    });
}

// //获取部门中的岗位
function getTeam() {
    var content = $("#workshopUser2 option:selected").text();
    $.ajax({
        url: "/app/config/getJob",
        data:JSON.stringify({"deptName":content}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {
            var json = result.data;
            var str = "<option value='test'>"+"全部岗位"+"</option>";
            for (var i=0; i < json.length; i++) {
                str += "<option value='"+ json[i].station +"'>"+json[i].station+"</option>";
            }
            $('#job2').empty().append(str);

        }
    });
}

var mm='1';
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
    var deptName = $("#workshopUser1 option:selected").text();
    var route = $("#route1 option:selected").text();
    var job = $("#writeJob input[name='job']").val();
    // alert(deptName+"=="+route+"=="+job);

    if (deptName!=='test'&&deptName!==''&&route!==''&& job.length>0) {// 判断数据不为空
            $.ajax({
                url: "/app/config/station/set",
                data:JSON.stringify({"deptName":deptName,"routeName":route,"station":job}),
                contentType: "application/json",
                cache: true,
                dataType: "json",
                type: "post",
                success: function (result) {
                    var data=result.data;
                    alert(data);
                    search();
                }
            });
    }
    else {
        alert("请将数据填写完整！")
    }

}


//-----------------------------管理人员页面-----------------------------------

// ---查询所有的管理人员
function searchUser(){
    var user=$("#user2 option:selected"); //用户
    var userId=user.val(); //用户id
    var username=user.text(); //用户名
    var job2=$("#job2 option:selected").val();  //岗位
    var workshop=$("#workshopUser2 option:selected").text(); //工段
    var team2=$("#team option:selected").val(); //班组

    // alert("userId:"+userId+"=============username:"+username+"=================job2:"+job2+"===================workshop:"+workshop+"============team2:"+team2);
    var str='';
    $.ajax({
        url: "/app/config/station/user/select",
        data:JSON.stringify({"deptName":workshop,"team":team2,"station":job2,"userId":userId}),
        contentType: "application/json",
        cache: true,
        dataType: "json",
        type: "post",
        success: function (result) {
            var data=result.data;

            for (var a=0;a<data.length;a++){

                // alert(data[a].deptName);
                // alert(data[a].userId);
                str +=  '<tr><td>'+(a+1)+ '</td><td>'
                    + data[a].deptName+ '</td><td>'
                    +data[a].station+'</td><td>'
                    +data[a].team+'</td><td>'
                    + data[a].userId+ '</td><td>'
                    + data[a].userName+  '</td><td>'
                    +'<input type="button" value="删除" style="cursor: pointer;" onclick="deleteUser(\''+data[a].userId+'\',\''+data[a].deptName+'\',\''+data[a].station+'\',\''+data[a].team+'\')">'
                    +'</td></tr>';
            }
            $(".tbody").empty().append(str)
        }});
}
// defaultShow();

// 用户添加
function addUser() {
    var user=$("#user2 option:selected"); //用户
    var userId=user.val(); //用户id
    var username=user.text(); //用户名
    var job2=$("#job2 option:selected").val();  //岗位
    var workshop=$("#workshopUser2 option:selected").text(); //工段
    var team2=$("#team option:selected").val(); //班组

    // alert("userId:"+userId+"=============username:"+username+"=================job2:"+job2+"===================workshop:"+workshop+"============team2:"+team2);

    if (userId ==='undefined' || workshop==='test'|| job2==='test' ||userId==='test'){
        alert("请填写完整数据")
    }
    else {

            $.ajax({
                url: "/app/config/station/user/set",
                data: JSON.stringify({ "deptName": workshop, "station": job2, "team": team2,"userName":username,"userId":userId}),
                contentType: "application/json",
                cache: true,
                dataType: "json",
                type: "post",
                success: function (result) {
                    alert(result.data);

                }
            });
    }
}

//删除用户管理人
function deleteUser(id,deptName,station,team) {
    $.ajax({
        url: "/app/config/station/user/delete",
        data:JSON.stringify({"userId":id,"deptName":deptName,"station":station,"team":team}),
        contentType: "application/json",
        type: "post",
        cache: true,
        dataType: "json",
        success: function (result) {
            var data=result.data;
            if(data>0){alert("删除成功！")}
            else {alert("删除失败！")}
            searchUser()
        }
    })
}
