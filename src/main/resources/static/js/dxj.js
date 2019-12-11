	// function GetQueryString(name){
	//      var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	//      var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
	//      if(r!=null)return  unescape(r[2]); return null;
	// }
	/*$(function(){
		var dxj = GetQueryString("dxj_page");
		if(dxj!=null&&dxj!=""){
			cherkpage(dxj);
		}else{
			cherkpage("xk_dxj_ss");
		}
	});
	function cherkpage(pagename){
		$("#xk_dxj_ss").attr("class", "");
		$("#xk_dxj_ls").attr("class", "");
		$("#"+pagename).attr("class", "active");
		$("#dxj_name").val(pagename);
		if(pagename=="xk_dxj_ls"){
			$("#datet").css("display", "");
		}else{
			$("#datet").css("display", "none");
		}
		//$("#cj").val("ah_"+pagename);//权限验证，需添加权限验证时放开
		getDxjLx();
	}*/
	// $(function(){
	// 	getDxjLx();
	// })
	var data1 = null;
	var data2 = null;
	var data3 = null;
	var data4 = null;
	var data5 = null;
	// function getDxjLx(){
	// 	$.ajax({
	// 		type: 'post',
	// 		url : '/bkzyCMS/xc/getDxjLx',
	// 		data: $("form").serialize(),
	// 		success : function(responseText) {
	// 			$("#bm").empty();
	// 			$("#bm").append("<option value='0'>全部工段</option>");
	// 			$("#lx").empty();
	// 			$("#lx").append("<option value='0'>全部路线</option>");
	// 			$("#qy").empty();
	// 			$("#qy").append("<option value='0'>全部区域</option>");
	// 			$("#gnwz").empty();
	// 			$("#gnwz").append("<option value='0'>全部功能位置</option>");
	// 			$("#djbw").empty();
	// 			$("#djbw").append("<option value='0'>全部部位</option>");
	// 			$("#djnr").empty();
	// 			$("#djnr").append("<option value='0'>全部内容</option>");
	// 			var result = eval("("+responseText+")");
	// 			if(result.flag=="succ"){
	// 				data1 = result.data_1;
	// 				data2 = result.data_2;
	// 				data3 = result.data_3;
	// 				data4 = result.data_4;
	// 				data5 = result.data_5;
	// 				$.each(result.data_0,function(name,value){
	//             		$("#bm").append("<option value='"+value.bm+"'>"+value.bm+"</option>");
	//             	})
	// 				$.each(result.data_1,function(name,value){
	//             		$("#lx").append("<option value='"+value.djlx+"'>"+value.djlx+"</option>");
	//             	})
	//             	$.each(data2,function(name,value){
	//             		$("#qy").append("<option value='"+value.ssqy+"'>"+value.ssqy+"</option>");
	//             	})
	//             	$.each(data3,function(name,value){
	//             		$("#gnwz").append("<option value='"+value.gnwzmc+"'>"+value.gnwzmc+"</option>");
	//             	})
	//             	$.each(data4,function(name,value){
	//             		$("#djbw").append("<option value='"+value.djbw+"'>"+value.djbw+"</option>");
	//             	})
	//             	$.each(data5,function(name,value){
	//             		$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
	//             	})
	// 			}
	//
	// 		},
	// 		complete : function() {
	// 			getDxjInfo();
	// 		},
	// 		error : function() {
	// 			//请求出错处理
	// 			//myalert("加载失败");
	// 		},
	// 		beforeSend:function(XMLHttpRequest){
	// 	    },
	// 	});
	// }
	$("#bm").change(function(){
		var bm= $("#bm").val();
		$("#lx").empty();
		$("#lx").append("<option value='0'>全部路线</option>");
		$("#qy").empty();
		$("#qy").append("<option value='0'>全部区域</option>");
		$("#gnwz").empty();
		$("#gnwz").append("<option value='0'>全部功能位置</option>");
		$("#djbw").empty();
		$("#djbw").append("<option value='0'>全部部位</option>");
		$("#djnr").empty();
		$("#djnr").append("<option value='0'>全部内容</option>");
		$.each(data1,function(name,value){
			if(bm==value.bm||bm=="0"){
				$("#lx").append("<option value='"+value.djlx+"'>"+value.djlx+"</option>");
			}
    	})
		$.each(data2,function(name,value){
			if(bm==value.bm||bm=="0"){
				$("#qy").append("<option value='"+value.ssqy+"'>"+value.ssqy+"</option>");
			}
    	})
    	$.each(data3,function(name,value){
    		if(bm==value.bm||bm=="0"){
    			$("#gnwz").append("<option value='"+value.gnwzmc+"'>"+value.gnwzmc+"</option>");
    		}
    	})
    	$.each(data4,function(name,value){
    		if(bm==value.bm||bm=="0"){
    			$("#djbw").append("<option value='"+value.djbw+"'>"+value.djbw+"</option>");
    		}
    	})
    	$.each(data5,function(name,value){
    		if(bm==value.bm||bm=="0"){
    			$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
    		}
    	})
	})
	$("#lx").change(function(){
			var bm= $("#bm").val();
			var lx= $("#lx").val();
			$("#qy").empty();
			$("#qy").append("<option value='0'>全部区域</option>");
			$("#gnwz").empty();
			$("#gnwz").append("<option value='0'>全部功能位置</option>");
			$("#djbw").empty();
			$("#djbw").append("<option value='0'>全部部位</option>");
			$("#djnr").empty();
			$("#djnr").append("<option value='0'>全部内容</option>");
			$.each(data2,function(name,value){
				if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")){
					$("#qy").append("<option value='"+value.ssqy+"'>"+value.ssqy+"</option>");
				}
        	})
        	$.each(data3,function(name,value){
        		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")){
        			$("#gnwz").append("<option value='"+value.gnwzmc+"'>"+value.gnwzmc+"</option>");
        		}
        	})
        	$.each(data4,function(name,value){
        		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")){
        			$("#djbw").append("<option value='"+value.djbw+"'>"+value.djbw+"</option>");
        		}
        	})
        	$.each(data5,function(name,value){
        		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")){
        			$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
        		}
        	})
	})
	$("#qy").change(function(){
		var bm= $("#bm").val();
		var lx= $("#lx").val();
		var qy= $("#qy").val();
		$("#gnwz").empty();
		$("#gnwz").append("<option value='0'>全部功能位置</option>");
		$("#djbw").empty();
		$("#djbw").append("<option value='0'>全部部位</option>");
		$("#djnr").empty();
		$("#djnr").append("<option value='0'>全部内容</option>");
		$.each(data3,function(name,value){
    		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")){
    			$("#gnwz").append("<option value='"+value.gnwzmc+"'>"+value.gnwzmc+"</option>");
    		}
    	})
    	$.each(data4,function(name,value){
    		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")){
    			$("#djbw").append("<option value='"+value.djbw+"'>"+value.djbw+"</option>");
    		}
    	})
    	$.each(data5,function(name,value){
    		if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")){
    			$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
    		}
    	})
	})
	$("#gnwz").change(function(){
		var bm= $("#bm").val();
		var lx= $("#lx").val();
		var qy= $("#qy").val();
		var gnwz= $("#gnwz").val();
		$("#djbw").empty();
		$("#djbw").append("<option value='0'>全部部位</option>");
		$("#djnr").empty();
		$("#djnr").append("<option value='0'>全部内容</option>");
		$.each(data4,function(name,value){
			if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")&&(gnwz==value.gnwzmc||gnwz=="0")){
				$("#djbw").append("<option value='"+value.djbw+"'>"+value.djbw+"</option>");
			}
		})
		$.each(data5,function(name,value){
			if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")&&(gnwz==value.gnwzmc||gnwz=="0")){
				$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
			}
		})
	})
	$("#djbw").change(function(){
		var bm= $("#bm").val();
		var lx= $("#lx").val();
		var qy= $("#qy").val();
		var gnwz= $("#gnwz").val();
		var djbw= $("#djbw").val();
		$("#djnr").empty();
		$("#djnr").append("<option value='0'>全部内容</option>");
		$.each(data5,function(name,value){
			if((bm==value.bm||bm=="0")&&(lx==value.djlx||lx=="0")&&(qy==value.ssqy||qy=="0")&&(gnwz==value.gnwzmc||gnwz=="0")&&(djbw==value.djbw||djbw=="0")){
				$("#djnr").append("<option value='"+value.djnr+"'>"+value.djnr+"</option>");
			}
		})
	})
	jeDate({
		dateCell:"#dateStart",
		format:"YYYY-MM-DD 0:00:00",
		isinitVal:true,
		isTime:true, //isClear:false,
		initHour:-24,
		minDate:"1900-01-01 00:00:00",
		okfun:function(val){alert(val)}
	})
	jeDate({
		dateCell:"#dateEnd",
		format:"YYYY-MM-DD 0:00:00",
		isinitVal:true,
		isTime:true, //isClear:false,
		minDate:"1900-01-01 00:00:00",
		okfun:function(val){alert(val)}
	})
	// function getDxjInfo(){
	// 	$.ajax({
	// 		type: 'post',
	// 		url : '/bkzyCMS/xc/getDxjInfo',
	// 		data: $("form").serialize(),
	// 		success : function(responseText) {
	// 			$("#groupTable-tbody").empty();
	// 			var result = eval("("+responseText+")");
	// 			if(result.flag=="succ"){
	// 				var j = 1;
	// 				var str = "";
	// 				$.each(result.data,function(name,value){
	// 					str = str + "<tr><td>"+j+"</td><td>"
	// 					if(value.uploadresulttime==null||value.uploadresulttime==""){
	// 						str = str + "-</td><td>"
	// 					}else{
	// 						str = str +value.uploadresulttime+ "</td><td>"
	// 					}
	// 					str = str +value.deptName+"</td><td>"+value.routeName+"</td><td>"+value.zoneName+"</td><td>"
	// 					+value.devname+"</td><td>"+value.scPart+"</td><td>"+value.scContent+"</td><td>";
	// 					if(value.username!=null&&value.username!=""){
	// 						str = str + value.username+"</td><td>";
	// 					}else{
	// 						str = str +"-</td><td>";
	// 					}
	//
	// 					str = str + value.result+"</td><td>";
	// 					if(value.altpid=="0"){
	// 						str = str +"正常</td><td>"
	// 					}else if(value.altpid=="1"){
	// 						str = str +"报警</td><td>"
	// 					}else if(value.altpid=="2"){
	// 						str = str +"危险</td><td>"
	// 					}else {
	// 						str = str +"-</td><td>"
	// 					}
	// 					if(value.remark!=null&&value.remark!=""){
	// 						str = str + value.remark + "</td></tr>"
	// 					}else{
	// 						str = str + "-</td></tr>"
	// 					}
	// 					j++;
	// 				})
	// 				$("#groupTable-tbody").append(
	// 						str
	// 				);
	// 			}else{
	// 				myalert(result.data)
	// 			}
	// 		},
	// 		complete : function() {
	//
	// 		},
	// 		error : function() {
	// 			//请求出错处理
	// 			//myalert("加载失败");
	// 		},
	// 		beforeSend:function(XMLHttpRequest){
	//
	// 		},
	// 	});
	// }