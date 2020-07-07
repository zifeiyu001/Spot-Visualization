function IsFull(){
    var a="";
    var b="";
    a= window.document.body.clientHeight;
    b=window.screen.height;
    if( a-b===0){
        tableHeight();
        tableAlarmColor();
    }else{
        tableHeight();
        tableAlarmColor();

    }
}
IsFull();
setInterval(function () {
    IsFull()
},1000);     //请求时间间隔

//--------------报警表格的高度设置------------------------
function tableHeight() {
    var s = document.getElementById("alarm1").scrollHeight;

    var s1 = document.getElementById("alarm2").scrollHeight;


    var s2 = document.getElementById("alarm3").scrollHeight;
    // alert(s+"==="+s1)
    var myDiv1 = document.getElementById("tablebody");
    var myDiv2 = document.getElementById("spotbody");
    // alert(s+"=="+s1+"=="+s2);
    myDiv1.style.height = (s1-s2)*0.83+ "px";
    myDiv2.style.height = (s*0.85) + "px";
}


// //------------报警表格等级设置背景色----------------------------
function tableAlarmColor(){
    var table = document.getElementById("tab");
    // var len = table.rows.length;
    var _row = table.rows;
    for(var i = 0;i < table.rows.length;i++){
        var _cell = _row[i].cells;
        var d=_cell[4].innerHTML;


        var a="一级";
        var b="二级";
        if(d===a){
            table.rows[i].cells.item(4).style.color = "#eef4e8";

        }
        if(d===b){
            table.rows[i].cells.item(4).style.color = "#FFC107";

        }
    }
}
//===========================报警表格一级报警闪烁=========================
function flashit(){
    var table = document.getElementById("tab");
    var _row = table.rows;
    for(var i = 0;i < table.rows.length;i++){
        var _cell = _row[i].cells;
        var d=_cell[4].innerHTML;
        var e=_cell[5].innerHTML;

        if(d=="一级"&&e=='未处理'){
            if (table.rows[i].style.backgroundColor  ==="transparent"){
                table.rows[i].style.backgroundColor ="darkred";
            }
            else{
                table.rows[i].style.backgroundColor ="transparent";
            }

        }
    }
    return true;
}
setInterval("flashit()", 500);
//----------------------处理报警-------------------------
// function dealWith(id,section) {
//     //获取报警处理内用
//     var remark = prompt("故障原因及处理结果"); //将输入的内容赋给变量 name ，
//     alert(id+"=="+section+"===========:::spotEquip");
//     //判断报警内容并操作
//     if (remark.length<1){alert("故障原因及处理结果");dealWith(id,section)}
//     else {
//
//         $.ajax({
//             url: "/spot/Universal/alarm/update",
//             contentType: "application/json",
//             data:JSON.stringify({
//                 "id":id,
//                 "remark":remark
//             }),
//             type: "post",
//             cache: false,
//             async: false,
//             dataType: "json",
//             success : function(result) {
//                 getAlarmData(section);
//                 alert("处理成功！");
//             },
//             error : function() {
//                 alert("处理失败，请重试！");
//             }
//         })}
// }
function dealWith(id,section) {
    //获取报警处理内用
    var remark = prompt("故障原因及处理结果"); //将输入的内容赋给变量 name ，
    //判断报警内容并操作
    if (remark.length<1){alert("故障原因及处理结果");dealWith(id,section)}
    else {

        $.ajax({
            url: "/spot/Universal/alarm/update",
            contentType: "application/json",
            data:JSON.stringify({
                "id":id,
                "remark":remark
            }),
            type: "post",
            cache: false,
            async: false,
            dataType: "json",
            success : function(result) {
                alert(result.data);
                if (result.flag==='succ') getAlarmData();
            },
            error : function() {
                alert("处理失败，请重试！");
            }
        })}



}