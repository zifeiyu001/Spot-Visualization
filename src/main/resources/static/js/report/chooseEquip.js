var workshop=document.getElementById("workshop");
var team=document.getElementById("team");
var equip=document.getElementById("equip");

var arr_workshop=["碎矿工段","磨浮工段","精尾工段","电仪工段"];<!--创建一个一维数组，存入省的值-->

var arr_team=[<!--创建一个二维数组，最外层每一个元素对应省-->
    ["碎矿设备","碎矿生产"],<!--数组中的第一个元素内又定义一个数组存的市的值-->
    ["磨浮设备","磨浮生产"],
    ["精尾设备","精尾生产"],
    ["碎矿电仪","磨浮电仪","精尾电仪"]
];

var arr_equip=[<!--创建一个三维数组，最外层每一个元素（对应省）-->
    [<!--数组中定义四个数组（对应市）-->
        ["颚破","重板","2#皮带","4#皮带","石灰制乳输送"],['破碎岗','皮带岗','石灰乳化岗']
    ],<!--数组中定义两个元素（对应县）-->
    [
        ["半自磨机","再磨机","球磨机","鼓风机","浮选机","中板皮带","浮选泵"],['磨矿岗','皮带岗','浮选岗']
    ],
    [
        ["过滤机","压滤机","浓密机","空压机","尾砂泵","厂前回水泵"],['回水岗','压滤机岗','过滤机岗','中心气站岗','尾砂泵岗']
    ],
    [
        ["重板颚破","2#4#皮带","石灰输送"],["皮带中板","3M石灰","再磨机","半自磨机","球磨机","浮选机","浮选泵","鼓风机"],["浓密机","压滤过滤","空压机"]
    ]

];

var  quanju_arr;//创建一个全局对象，用于存储一个中间数组

function input_arr(arr,event){//封装一个函数，用于向下拉栏中添加元素
    for(var i=0;i<arr.length;i++){//下拉栏内的元素来源于数组中的元素，遍历数组
        var option=new Option(arr[i],i);//创建Option对象（这个O要大写），存入值
        event.appendChild(option);//把option添加到event对象的末尾
    }
}

input_arr(arr_workshop,workshop);//调用,给省下拉栏添元素

workshop.onchange= function () {//给下拉栏绑定事件（当下拉栏元素改变时执行）
    team.options.length=1;//当省下拉栏改变时，清空市的下拉栏内元素
    equip.options.length=1;//当省下拉栏改变时，清空县的下拉栏内元素
    var index=this.value;//每一个option标签都有一个value值索引，获取索引，用于数组中元素的选择
    console.log(this,index);
    var arr_team_next=arr_team[index];//获取当前选择省的市元素并赋给一个数组
    quanju_arr=arr_equip[index];//获取当前选择省中市的县元素并赋给定义的中间数组
    input_arr(arr_team_next,team);//调用,给市下拉栏添元素
};

team.onchange= function () {
    equip.options.length=1;
    var index=this.value;
    var arr_equip_next=quanju_arr[index];
    input_arr(arr_equip_next,equip);//调用,给县下拉栏添元素
};