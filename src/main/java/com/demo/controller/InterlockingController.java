package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.model.CfgUser;
import com.demo.model.app.AppCycle;
import com.demo.model.app.AppDCS;
import com.demo.model.app.AppLoginUser;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.*;
import com.demo.service.IndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.Tree;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.lang.Float.parseFloat;

@RestController
public class InterlockingController {
    // 首页
    @Autowired
    private IndexService indexService;

    // =========================获取工段数据==================================
    @RequestMapping(value = "/interlocking/deptName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDeptName() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        List<Interlocking> interlockings = indexService.Interlocking_get_deptName();

        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取线路数据==================================
    @RequestMapping(value = "/interlocking/routeName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRouteName() {
//        String deptName = params.get("deptName");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_routeName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取区域数据==================================
    @RequestMapping(value = "/interlocking/zoneName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getZoneName() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_zoneName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取设备数据==================================
    @RequestMapping(value = "/interlocking/devName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDevName() {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_devName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取点检部位数据==================================
    @RequestMapping(value = "/interlocking/partName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScPart() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_scPart();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取点检部位数据==================================
    @RequestMapping(value = "/interlocking/content", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScContent() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_content();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取点检结果数据==================================
    @RequestMapping(value = "/interlocking/getResult", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getResult(@RequestBody Map<String, String> params) {
        String deptName = params.get("deptName");
        String route = params.get("route");
        String zone = params.get("zone");
        String equip = params.get("equip");
        String part = params.get("part");
        String content = params.get("content");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        String zcCheck = params.get("zcCheck");
        String bjCheck = params.get("bjCheck");
        String bjType1 = params.get("bjType1");
        String bjType2 = params.get("bjType2");
        String bjType3 = params.get("bjType3");
        String wjCheck = params.get("wjCheck");
        String nowPage = params.get("nowPage");
        String numPerPage1 = params.get("numPerPage");
        Integer numPerPage = Integer.parseInt(params.get("numPerPage"));
        Integer startPage = Integer.parseInt(params.get("startPage"));
        String dealStatus = params.get("dealStatus");

//        String RDStatus = params.get("responsibleDepartmentStatus");

        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
        //查询结果数量
        Integer integer = indexService.Interlocking_get_result_total(deptName, route, zone, equip, part, content, startTime, endTime, zcCheck, bjCheck, bjType1, bjType2, bjType3, wjCheck,dealStatus);

        if (startTime.equals("")) {
            Date now = new Date();
            Date startDate = DateUtils.addDays(now, -30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTime = sdf.format(startDate);// format  为格式化方法
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> spotResults = indexService.Interlocking_get_result(deptName, route, zone, equip, part, content, startTime, endTime, zcCheck, bjCheck, bjType1, bjType2, bjType3, wjCheck,
                startPage, numPerPage,dealStatus);
        for (int a=0;a<spotResults.size();a++){
            List<AlarmDealData> alarm_deal_data = indexService.get_alarm_deal_data(spotResults.get(a).getResultId());
            if(alarm_deal_data.size()>0){

                spotResults.get(a).setDealData("1");
            }
            else {
                spotResults.get(a).setDealData("0");
            }

        }
        objectObjectHashMap.put("total", integer);
        objectObjectHashMap.put("data", spotResults);
        return objectObjectHashMap;
    }

//    // =========================获取点检结果数据==================================
//    @RequestMapping(value = "/interlocking/getResult1", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> getResult1(@RequestBody Map<String, String> params) {
//        String deptName = params.get("deptName");
//        String route = params.get("route");
//        String zone = params.get("zone");
//        String equip = params.get("equip");
//        String part = params.get("part");
//        String content = params.get("content");
//        String startTime = params.get("startTime");
//        String endTime = params.get("endTime");
//        String yjCheck = params.get("yjCheck");
//        String wjCheck = params.get("wjCheck");
//        String zcCheck = params.get("zcCheck");
//        String bjCheck = params.get("bjCheck");
//        String abjType1 = params.get("abjType1");
//        String abjType2 = params.get("abjType2");
//        String abjType3 = params.get("abjType3");
//        String sbjType1 = params.get("sbjType1");
//        String sbjType2 = params.get("sbjType2");
//        String sbjType3 = params.get("sbjType3");
//        String nowPage = params.get("nowPage");
//        String numPerPage1 = params.get("numPerPage");
//        Integer numPerPage = Integer.parseInt(params.get("numPerPage"));
//        Integer startPage = Integer.parseInt(params.get("startPage"));
//
//        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
//
//        //查询结果数量
//        Integer integer = indexService.Interlocking_get_result_total1(deptName, route, zone, equip, part, content, startTime, endTime, yjCheck,wjCheck,zcCheck, bjCheck, abjType1, abjType2, abjType3,sbjType1,sbjType2,sbjType3 );
//
//        if (startTime.equals("")) {
//            Date now = new Date();
//            Date startDate = DateUtils.addDays(now, -30);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            startTime = sdf.format(startDate);// format  为格式化方法
//        }
//        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
//        List<Interlocking> spotResults = indexService.Interlocking_get_result1(deptName, route, zone, equip, part, content, startTime, endTime, yjCheck,wjCheck,zcCheck, bjCheck, abjType1, abjType2, abjType3,sbjType1,sbjType2,sbjType3,
//                startPage, numPerPage);
//        for (int a=0;a<spotResults.size();a++){
//            List<AlarmDealData> alarm_deal_data = indexService.get_alarm_deal_data(spotResults.get(a).getResultId());
//            if(alarm_deal_data.size()>0){
//                spotResults.get(a).setDealData("1");
//            }
//            else {
//                spotResults.get(a).setDealData("0");
//            }
//
//        }
//        objectObjectHashMap.put("total", integer);
//        objectObjectHashMap.put("data", spotResults);
//        return objectObjectHashMap;
//    }
    /*===========================================报警处理单查询=============================*/
//  通过resultID查询报警处理单
    @RequestMapping(value = "/interlocking/getAlarmDealData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getAlarmDealData(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String resultId = params.get("resultId");
        List<AlarmDealData> alarm_deal_data = indexService.get_alarm_deal_data(resultId);
        hashMap.put("data",alarm_deal_data);
        return  hashMap;
    }

//根据条件查询报警处理数据
    @RequestMapping(value = "/interlocking/repair/list", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getRepairData(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String dateStart = params.get("dateStart");
        String dateEnd = params.get("dateEnd");
        String workShop = params.get("workShop");
        HashMap<String, String> dept = getSplitDepart(workShop);
        String depart=dept.get("depart");
        String technology=dept.get("technology");
        List<AlarmDealData> repair_data = indexService.get_repair_data(dateStart, dateEnd, depart,technology);
        hashMap.put("data",repair_data);
        return  hashMap;
    }

/*
* 将result表中存放的工段名称进行拆分判断，分为工段名称和专业
* */
    private HashMap<String,String> getSplitDepart(String workShop){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String depart="";
        String technology="";
        if (workShop.contains("生产")){
            depart=workShop.substring(0,2)+"工段";
            technology="生产";
        }
        else if (workShop.contains("设备")){
            depart=workShop.substring(0,2)+"工段";
            technology="机械";
        }
        else if(workShop.contains("test")){
            depart="test";
            technology="test";
        }
        else {
            depart="电仪工段";
            technology="电气";
        }
        stringStringHashMap.put("depart",depart);
        stringStringHashMap.put("technology",technology);
        return stringStringHashMap;
    }
//    补齐字符串长度
    private static String autoGenericCode(int code, int num) {
        String result = "";
        result = String.format("%0" + num + "d", code + 1);

        return result;
    }


//    获取填写报警处理单自动填写数据

    @RequestMapping(value = "/interlocking/repair/write/getWriteDefaultDealData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getWriteDefaultDealData(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String resultId = params.get("resultId");
        List<AlarmDealData> alarmDealDatas = indexService.getWriteDefaultDealData(resultId);
        for(AlarmDealData alarmDealData:alarmDealDatas){
//            合并报警内容
            alarmDealData.setAlarm_content("部位："+alarmDealData.getDev_part()+"    内容："+alarmDealData.getDev_content()+"    结果："+alarmDealData.getDev_result()+"     备注："+alarmDealData.getDev_remark());
            HashMap<String, String> splitDepart = getSplitDepart(alarmDealData.getDev_depart());
//            根据查询出的部门，计算部门及专业
            String depart=splitDepart.get("depart");
            String technology=splitDepart.get("technology");

            alarmDealData.setDev_dept(depart);
            alarmDealData.setDev_category(technology);
//            根据数字报警类型变为文字
            String alarm_type = alarmDealData.getAlarm_type();
            switch (alarm_type){
                case "1": alarmDealData.setAlarm_type("A类") ;break;
                case "2" :alarmDealData.setAlarm_type("B类") ;break;
                case "3" :alarmDealData.setAlarm_type("C类") ;break;
                default: break;
            }
        }
        hashMap.put("data",alarmDealDatas);
        return  hashMap;
    }

//    获取bc类报警数据
        @RequestMapping(value = "/interlocking/repair/write/bcAlarm", method = RequestMethod.POST)
        @ResponseBody
        public HashMap<String, Object> getbcAlarmData(@RequestBody Map<String, String> params, HttpServletRequest request) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String start_date = params.get("start_date");
            String end_date = params.get("end_date");
            String deptName = params.get("deptName");
            String alarm_type = params.get("alarm_type");
//            String deal_status = params.get("deal_status");
            List<Interlocking> alarmDealDatas = indexService.getbcAlarmData(start_date,end_date,deptName,alarm_type);
            hashMap.put("data",alarmDealDatas);
            return  hashMap;
        }

//    添加报警数据到月度清单
    @RequestMapping(value = "/interlocking/merge/addAlarmToMonthlyList", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> addAlarmToMonthlyList(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String mergeId = "("+params.get("mergeId")+")";
        String deptName = params.get("deptName");
        Integer alarmDealDatas = indexService.addAlarmToMonthlyList(mergeId);
        if (alarmDealDatas>0){
            hashMap.put("data","添加完成！");
            hashMap.put("msg","1");
        }else {
            hashMap.put("data","添加失败！");
            hashMap.put("msg","0");
        }

        return  hashMap;
    }

//    获取月度报警清单
    @RequestMapping(value = "/interlocking/repair/getMonthlyAlarmList", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getMonthlyAlarmList(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String deptName = params.get("deptName");
        List<Interlocking> alarmDealDatas = indexService.getbcMonthlyAlarmListData(deptName);
        hashMap.put("data",alarmDealDatas);
        return  hashMap;
    }

//    处理bc类报警数据
    @RequestMapping(value = "/interlocking/repair/deal/bcAlarm", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> dealBCAlarm(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
//        报警表需处理id
        String alarmId = params.get("alarmIds");
//        报警表需处理id
        String resultIds = params.get("resultIds");
        String deptNames = params.get("deptNames");
        String alarm_types = params.get("alarmTypes");
        String dealStatus = params.get("dealStatus");
        String dealRemark = params.get("dealRemark");
        String userId = (String) request.getSession().getAttribute("username");
        String user = (String) request.getSession().getAttribute("user");

        String alarmIds = "(" + alarmId + ")";
        Set hashSet = new HashSet();
        String[] deptName = deptNames.split(",");
        String[] alarm_type = alarm_types.split(",");
        int length = 0;
        for (int a=0;a<deptName.length;a++){
            String deptName1 = "%" + deptName[a] + "%";
            List<ConfigUser> alarmDealJurisdiction = indexService.getAlarmDealJurisdiction(deptName1, userId, alarm_type[a]);
            if (alarmDealJurisdiction.size()>0){
                length+=1;
            }
        }
//        判断每个部门是否都有权限
        if (length >0) {
            if (deptName.length == length) {
//                判断是立即处理
                if (dealStatus.equals("1")){
                    //              处理alarm表报警
                    Integer dealResult = indexService.dealBCAlarm(alarmIds,dealRemark,user);
//                处理result表报警
                    if (dealResult > 0) {
                            hashMap.put("data", "处理完成！");
                            hashMap.put("code","200");
                            indexService.dealBCAlarmInResult(resultIds, dealRemark, user);
                    } else {
                        hashMap.put("data", "处理失败！");
                        hashMap.put("code","400");
                    }
                }
//                延期处理
                else {
                    Integer dealResult = indexService.delayBCAlarm(alarmIds,dealRemark);
                    if (dealResult>0){
                        hashMap.put("data", "处理完成！");
                        hashMap.put("code","200");
                    }
                    else{
                        hashMap.put("data", "处理失败！");
                        hashMap.put("code","400");
                    }
                }

            }else {
                hashMap.put("data","请选择本部门的数据！");
                hashMap.put("code","400");}
        }else { hashMap.put("data","无权限!");
                hashMap.put("code","400");}
        return  hashMap;
    }
//修改bc类报警类型

    @RequestMapping(value = "/interlocking/repair/changeType/bcAlarm", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> changeTypeBCAlarm(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String alarmId = params.get("alarmId"); //选择数据的id
        String deptName = params.get("deptName"); //选择数据的部门
        String alarm_after_Type = params.get("alarm_after_Type");  //报警类型
        String responsibilityDeptName = params.get("responsibilityDeptName"); //责任部门
        String departs = "("; //拼接责任人部门
        List<Object> objects = new ArrayList<>();
        StringBuilder personLiable = new StringBuilder();//责任人
        int length=0;//管理部门的个数
//        拼接责任人
        String[] split = responsibilityDeptName.split(",");
        for (int a=0;a<split.length;a++){
            departs +=  "\""+split[a] + "\""+",";
            List<ConfigUser> personLiableByDepart = indexService.getPersonLiableByDepart(alarm_after_Type, split[a]);
            for (ConfigUser c:personLiableByDepart){
                personLiable.append(c.getUser()+",");
            }
        }
//        获取所处理的每个部门，是否都有权限
        HashMap<String, String> managementAuthority = getManagementAuthority(deptName, request);
        String authority = managementAuthority.get("authority");
        String noAuthorityDepart = managementAuthority.get("departs");
//        拼接责任部门的数据
        departs= departs.substring(0, departs.length() -1)+")";
        String resultIds="(";
//        有权限时
        if (authority.equals("true")){
//             获取alarm表中resultid
            String resultIds1="";//所有需修改的resultId
//            System.out.println(alarmId+"");
            for(int b=0;b<alarmId.split(",").length;b++){
                List<Interlocking> resultId_alarmid = indexService.get_resultId_alarmid(alarmId.split(",")[b]);
                resultIds1=resultIds1+resultId_alarmid.get(0).getResultId()+",";
            }
            Integer integer = indexService.changeBCAlarmType("("+alarmId+")",resultIds1, responsibilityDeptName, alarm_after_Type, personLiable.toString());
            if (integer>0){
                hashMap.put("data","修改完成！");
                hashMap.put("code","200");
            }else {hashMap.put("data","修改失败！");
                hashMap.put("code","400");}
        }else {
            hashMap.put("data","无权限修改   "+noAuthorityDepart+"    的数据！");
            hashMap.put("code","400");
        }

        return  hashMap;
    }
//查找所选部门是否有权限，判断是否有管理权限，无权限部门
    public HashMap<String,String> getManagementAuthority(String deptName, HttpServletRequest request){
        HashMap<String, String> stringHashMap = new HashMap<>();
        int length=0;
        List<Object> objects = new ArrayList<>();
        String userId = (String)request.getSession().getAttribute("username");
        int departsLength=deptName.split(",").length;
//        获取所处理的每个部分，是否都有权限
        for (int b=0;b<departsLength;b++){
            //        获取修改权限
            List<ConfigUser> configUsers1 = indexService.search_config_alarm_manage_user(userId, deptName.split(",")[b]); //判断操作人是否有权限
            if (configUsers1.size()>0){
                length=length+1;
            }
            else{
                objects.add(deptName.split(",")[b]); // 无权限的部门
            }
        }
        if (departsLength==length){
            stringHashMap.put("authority","true");
            stringHashMap.put("departs",objects.toString());
        }else {
            stringHashMap.put("authority","false");
            stringHashMap.put("departs",objects.toString());
        }
        return stringHashMap;
    }




//手动合并报警类型
    @RequestMapping(value = "/interlocking/merge/bcAlarm", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson mergeTypeBCAlarm(@RequestBody Map<String, String> params, HttpServletRequest request) {
        ToolUtil toolUtil = new ToolUtil();
        ResultJson resultJson = new ResultJson();
        String alarmId = params.get("alarmId");//主报警id
        String deptName = params.get("deptName");//所选择数据的部门
        String alarmType = params.get("alarmType");//报警类型
        String mergeId = params.get("mergeId");//拼接其余的报警id
        String resultId = params.get("resultId");//合并的其他resultid
        String resultIds=""; //拼接合并后其他的resultID
        int times=0; //统计合并其他向报警次数
        String userId = (String)request.getSession().getAttribute("username"); //登录用户id
//        获取合并权限
        List<ConfigUser> configUsers1 = indexService.search_config_alarm_manage_user(userId, deptName); //判断操作人是否有权限

//        获取保留alarmId的报警数据
        List<Interlocking> interlockings = indexService.getbcAlarmContent(alarmId);
        String startTime=interlockings.get(0).getUploadResultTime();
        String endTime=interlockings.get(0).getUploadResultTimeEnd();
        if (configUsers1.size()>0){
            String[] alarmIdLength = mergeId.split(",");//获取每个alarmId
            for(int a=0;a<alarmIdLength.length;a++){
                List<Interlocking> resultId_alarmid = indexService.get_resultId_alarmid(mergeId.split(",")[a]);
                if (resultId_alarmid.size()>0){
                    resultIds+=resultId_alarmid.get(0).getResultId()+",";  //拼接resultId
                    times=times+Integer.parseInt(resultId_alarmid.get(0).getAlarm_times()); //计算其他项报警次数和
                    String [] dates={resultId_alarmid.get(0).getUploadResultTime(),resultId_alarmid.get(0).getUploadResultTimeEnd(),startTime,endTime};
                    HashMap<String, String> stringStringHashMap = toolUtil.MaxMinValuesOfMultipleData(dates);//计算最大最小值
                    startTime= stringStringHashMap.get("start");
                    endTime= stringStringHashMap.get("end");
//            删除其他项
                    indexService.delete_alarm_result_by_alarmId(alarmIdLength[a]);
                }
            }

//            合并数据
            Integer integer = indexService.mergeBCAlarmData(alarmId, resultId+","+resultIds, times + "",startTime,endTime);

                if (integer>0){
                    resultJson.setMsg("合并完成！");
                    resultJson.setCode(StatusCode.SUCCESS.getCode());
                }else {
                    resultJson.setMsg("合并失败！");
                    resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
                }
        }else {
            resultJson.setMsg("无权限！");
            resultJson.setCode(StatusCode.UNKNOWN_PERMISSION.getCode());
        }
        return  resultJson;
    }


//    填写报警处理单数据

    @RequestMapping(value = "/interlocking/repair/write/writeDealData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> writeDealData(@RequestBody Map<String, String> params, HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String result_id = params.get("resultId");
        String service_id = "";  //处理单编号
        String dev_code = params.get("dev_code");
        String service_start_date = params.get("service_start_date");
        String service_end_date = params.get("service_end_date");
        ToolUtil toolUtil = new ToolUtil();
        String service_hours = toolUtil.timeDifference(service_start_date,service_end_date, "h",2); //计算维修时间
        String dev_name = params.get("dev_name");
        String dev_model = params.get("dev_model");
        String dev_dept = params.get("dev_dept");
        String dev_depart = params.get("dev_depart");//原始部门名称
        String userId=(String) request.getSession().getAttribute("username");
        String dev_category = params.get("dev_category");
        String service_unit_type = params.get("service_unit_type");
        String service_name="";
        String service_unit="";
//        判断是否有处理的权限
        List<ConfigUser> alarmDealJurisdiction = indexService.getAlarmDealJurisdiction(dev_depart, userId, "1");
        if (alarmDealJurisdiction.size()>0){
            //        通过修改类型判断内容填写是维修人、维修单位
            if (service_unit_type.equals("自修")){
                service_name =params.get("service_unit");
            } else { service_unit = params.get("service_unit");
            }
            String alarm_type = params.get("alarm_type");
            String alarm_name = params.get("alarm_name");
            String alarm_time = params.get("alarm_time");
            String alarm_content = params.get("alarm_content");
            String service_acceptor=(String) request.getSession().getAttribute("user");
            String service_content = params.get("service_content");
            String service_alarm_time = params.get("service_alarm_time");
            String service_remarks = params.get("service_remarks");
            Integer dealResult=0; //存储结果
//获取处理单中是否有此resultID
            List<AlarmDealData> alarmDealDatas = indexService.get_alarm_deal_data(result_id);
//      查询当天本工段的处理单的个数
            List<AlarmDealData> deptSameDayDealData = indexService.getDeptSameDayDealData(dev_dept);
            int size = deptSameDayDealData.size();
            String dealNum = autoGenericCode(size, 3);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String currentDate =  dateFormat.format( new Date() );
            String depart="";
            switch (dev_dept){
                case "碎矿工段" : depart="SK";break;
                case "磨浮工段" : depart="MF";break;
                case "精尾工段" : depart="JW";break;
                case "电仪工段" : depart="DY";break;
            }
            service_id=currentDate+depart+dealNum;
            if(alarmDealDatas.size()>0){
                dealResult = indexService.updateDealData(result_id, service_id, service_start_date,service_end_date, service_hours,
                        service_unit_type, service_unit, service_name, service_acceptor, service_content, service_alarm_time, service_remarks);
                if (dealResult>0){
                    indexService.updateResultDealData(result_id,"Y",service_remarks,service_acceptor,service_alarm_time);
//                Integer updateResultDealData(String result_id,String alarm_flag, String alarm_remark, String alarm_manage_name, String alarm_manage_time);
                    hashMap.put("data","修改成功！");
                    hashMap.put("type","true");
                } else {hashMap.put("data","修改失败！"); }
            }
            else {
                dealResult = indexService.writeDealData(result_id, service_id, dev_code, service_start_date,service_end_date,
                        service_hours, dev_name, dev_model, dev_dept, dev_category, service_unit_type,
                        service_unit, alarm_type, alarm_name, alarm_time, alarm_content,
                        service_name, service_acceptor, service_content, service_alarm_time, service_remarks);
                if (dealResult>0){
                    hashMap.put("data","提交成功！");hashMap.put("type","true");
                    indexService.updateResultDealData(result_id,"Y",service_remarks,service_acceptor,service_alarm_time);
                } else {hashMap.put("data","提交失败！");}
            }
        }
        else {
            hashMap.put("data","无权限！");
            hashMap.put("type","true");
        }
        return  hashMap;
    }



//  修改A类报警类型数据
    @RequestMapping(value = "/interlocking/changeAlarmAType", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> changeAlarmType(@RequestBody Map<String, String> params, HttpServletRequest request) {

        HashMap<String, Object> hashMap = new HashMap<>();
        String resultId = params.get("resultId");
        String alarmType = params.get("alarmType");
        String userName = request.getSession().getAttribute("username").toString();//用户id
        String operationName = request.getSession().getAttribute("user").toString();  //用户名
        String selectDepart = params.get("selectDepart");
        String part = params.get("part");
//        System.out.println("operationName====="+operationName+"===========resultId"+resultId);
//        String responsibleUser = changePersonLiable(resultId); //责任人
        String dealPersonLiable = getDealPersonLiable(selectDepart, alarmType);//责任人
//        System.out.println("责任人==="+dealPersonLiable);
//        判断是否选择报警处理部门
        if(selectDepart.isEmpty()){
            hashMap.put("data", "请至少选择一个部门");
            hashMap.put("msg", "error");
        }
        else {
            List<ConfigUser> configUsers1 = indexService.search_config_alarm_manage_user(userName, part); //判断操作人是否有权限
            if (configUsers1.size() > 0) {
    //            修改A类报警
                Integer configUsers = indexService.Interlocking_changeAlarmType(resultId, alarmType, userName, selectDepart,dealPersonLiable);
                if (configUsers > 0) {
                    List<Interlocking> resultByResult = indexService.Interlocking_get_byId_result(resultId);//点检结果表数据
                    String deptName = resultByResult.get(0).getDeptName(); //部门
                    String routeName = resultByResult.get(0).getRouteName();//线路
                    String zoneName = resultByResult.get(0).getZoneName();// 区域
                    String devName = resultByResult.get(0).getDevName();//设备
                    String scPart = resultByResult.get(0).getScPart(); //部门
                    String scContent = resultByResult.get(0).getScContent();//内容
                    String remark = resultByResult.get(0).getRemark(); //备注
                    String spotResult = resultByResult.get(0).getResult();//结果
                    String userName1 = resultByResult.get(0).getUserName();//点检人
                    String altpid = resultByResult.get(0).getAltpid();
                    String stdValue = resultByResult.get(0).getStdValue();
                    String uploadResultTime = resultByResult.get(0).getUploadResultTime(); //上传时间
    //是否为BC类报警
                    if (alarmType.equals("2") || alarmType.equals("3")) {
    //                    查询alarmResult表中是否有相同数据
                        List<Interlocking> rsu = indexService.searchAlarmResultDataByInfo(deptName, routeName, zoneName, devName, scPart, scContent, remark, alarmType);
                        if (rsu.size() > 0) {
                            List<Interlocking> interlockings = indexService.getbcAlarmContent(rsu.get(0).getAlarmId());
//                            System.out.println(rsu.get(0).getAlarmId());
                            String alarmResultId=interlockings.get(0).getResultId()+","+resultId+",";
    //                        获取数据中的最大、最小时间
                            String start = interlockings.get(0).getUploadResultTime();
                            String end = interlockings.get(0).getUploadResultTimeEnd();
                            ToolUtil toolUtil = new ToolUtil();
                            String[] c = {uploadResultTime, start, end};
                            HashMap<String, String> stringStringHashMap = toolUtil.MaxMinValuesOfMultipleData(c);
                            String startTime = stringStringHashMap.get("start");
                            String endTime = stringStringHashMap.get("end");
//
    //                        数据合并，增加次数(修改开始、结束时间，责任部门、责任人、报警类型)
                            Integer integer = indexService.updateAlarmResultTimes(rsu.get(0).getAlarmId(), rsu.get(0).getAlarm_times(), selectDepart,
                                    dealPersonLiable, alarmType,startTime, endTime, alarmResultId);
                            if (integer > 0) {
                                hashMap.put("data", "操作成功");
                                hashMap.put("msg", "true");
                            } else {
                                hashMap.put("data", "操作失败");
                                hashMap.put("msg", "error");
                            }
                        } else { //当alarmResult无数据
    //                        插入数据
                            Integer integer1 = indexService.insertBCAlarmDataToAlarmResult(resultId, deptName, routeName, zoneName, devName, scPart, scContent, remark,
                                    spotResult, userName1, uploadResultTime, selectDepart, alarmType, dealPersonLiable);
                            if (integer1 > 0) {
                                hashMap.put("data", "操作成功");
                                hashMap.put("msg", "true");
                            } else {
                                hashMap.put("data", "操作失败");
                                hashMap.put("msg", "error");
                            }
                        }

                    }
                    else {
                            hashMap.put("data", "操作成功");
                            hashMap.put("msg", "true");
                    }

                }
    //暂时停用
    //
    //                //  将修改的报警类型及责任人同步到报警表中
    //                indexService.Interlocking_update_alarm_result(deptName, routeName, zoneName, devName, scPart, scContent, user, alarmType);
    //
    //                List<Interlocking> result = indexService.Interlocking_get_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid);
    //                if (result.size() > 0) {//判断有数据
    //                    //update
    //                    Integer result1 = indexService.Interlocking_update_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid, alarmType, userName, selectDepart);
    //                } else {
    //                    //insert
    //                    Integer result2 = indexService.Interlocking_insert_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid, alarmType, userName, selectDepart);
    //                }
    //                hashMap.put("data", "操作成功");
    //                hashMap.put("msg", "true");
    //                indexService.Interlocking_changeAlarmPersonLiable(resultId, responsibleUser); //保存数据
    //            } else {
    //                hashMap.put("data", "操作失败");
    //                hashMap.put("msg", "error");
    //            }

            } else {
                hashMap.put("data", "无权限操作");
                hashMap.put("msg", "error");
            }
        }
        return hashMap;
    }
//
//    // 报警类型根据之前选择自动执行
//    private void alarmData() {
//        /*
//         * 找出当日已经点检，并且为报警的数据
//         * 责任部门为空
//         * 遍历数据，当报警临时表中的多个字段相同时，将报警类型修改人、报警类别、责任部门数据 更新到点检结果表中
//         * 根据报警类别，责任部门，跟新责任人
//         * */
//        List<Interlocking> interlockings = indexService.Interlocking_get_all_alarm_byDay(); //当日所有报警数据
//        List<Interlocking> allAlarmType = indexService.Interlocking_get_all_alarmType(); //所有报警类型
//        for (Interlocking a : interlockings) { //遍历当日所有报警数据
//            for (Interlocking b : allAlarmType) { //遍历所有报警类型
//                if (a.getDeptName().equals(b.getDeptName()) && a.getRouteName().equals(b.getRouteName()) && a.getZoneName().equals(b.getZoneName())
//                        && a.getDevName().equals(b.getDevName()) && a.getScPart().equals(b.getScPart()) && a.getScContent().equals(b.getScContent())
//                        && a.getAltpid().equals(b.getAltpid()) && a.getStdValue().equals(b.getStdValue())) {//当报警类型相同时
//                    Integer configUsers = indexService.Interlocking_changeAlarmType(a.getResultId(), b.getAbnormalHandleAdminType(), b.getAbnormalHandleUser(), b.getAbnormalHandleDealDepart());
//                    if (configUsers > 0) { //当报警级别修改完毕后
//                        String user = changePersonLiable(a.getResultId());
//                        Integer integer = indexService.Interlocking_changeAlarmPersonLiable(a.getResultId(), user); // 存储对应类别、部门的责任人
//                        if (integer > 0) {
//                            Integer integer1 = indexService.Interlocking_update_alarm_result(a.getDeptName(), a.getRouteName(), a.getZoneName(), a.getDevName(), a.getScPart(), a.getScContent(), user,a.getAbnormalHandleAdminType());
//                        }
//                    }
//                }
//            }
//        }
//    }

//    获取处理责任人
    private String getDealPersonLiable(String depart,String alarmType){
        StringBuilder personLiable = new StringBuilder(); // 责任人拼接
/*
* 切分责任部门，
* 分别查询每个部门，报警类型的责任人
* 拼接责任人
* */
//        System.out.println("alarmType===="+alarmType+"======depart===="+depart);
        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
        String[] split = depart.split(","); //切分责任部门
        for (String s1 : split) { //获取点检结果表责任部门下的每个部门
            for (ConfigUser liableUser : configUsers) { //获取责任人表数据
                String[] split1 = liableUser.getDepartment().split(","); //切分责任人管理的部门
                for (String s2 : split1) { //获取所有的责任部门
                    // 当责任部门和管理部门相同时，拼接用户
                    if (alarmType != null && s1.equals(s2) && alarmType.equals(liableUser.getAlarmType())) {
                        personLiable.append(liableUser.getUser()).append(",");
                    }
                }
            }
        }
        return  personLiable.toString();
    }


    // 获取报警数据责任人
    private String changePersonLiable(String resultId) {
        Interlocking spotResult = indexService.Interlocking_get_byId_result(resultId).get(0);//点检结果表数据
        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
        StringBuilder s = new StringBuilder(); // 责任人拼接
        if (spotResult.getAltpid() != null && Integer.parseInt(spotResult.getAltpid()) > 0 && spotResult.getAbnormalHandleDealDepart() != null) { //报警数据 && 责任部门不为null
            String[] split = spotResult.getAbnormalHandleDealDepart().split(","); //切分责任部门
            for (String s1 : split) { //获取点检结果表责任部门下的每个部门
                for (ConfigUser liableUser : configUsers) { //获取责任人表数据
                    String[] split1 = liableUser.getDepartment().split(","); //切分责任人管理的部门
                    for (String s2 : split1) { //获取所有的责任部门
                        // 当责任部门和管理部门相同时，拼接用户
                        if (spotResult.getAbnormalHandleAdminType() != null && s1.equals(s2) && spotResult.getAbnormalHandleAdminType().equals(liableUser.getAlarmType())) {
                            s.append(liableUser.getUser()).append(",");
                        }
                    }
                }
            }
        }
        return s.toString();
    }

    // 获取报警数据责任人
    private String getPersonLiable(String resultId) {
        Interlocking spotResult = indexService.Interlocking_get_byId_result(resultId).get(0);//点检结果表数据
        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
        StringBuilder s = new StringBuilder(); // 责任人拼接
        if (spotResult.getAltpid() != null && Integer.parseInt(spotResult.getAltpid()) > 0 && spotResult.getAbnormalHandleDealDepart() != null) { //报警数据 && 责任部门不为null
            String[] split = spotResult.getAbnormalHandleDealDepart().split(","); //切分责任部门
            for (String s1 : split) { //获取点检结果表责任部门下的每个部门
                for (ConfigUser liableUser : configUsers) { //获取责任人表数据
                    String[] split1 = liableUser.getDepartment().split(","); //切分责任人管理的部门
                    for (String s2 : split1) { //获取所有的责任部门
                        // 当责任部门和管理部门相同时，拼接用户
                        if (spotResult.getAbnormalHandleAdminType() != null && s1.equals(s2) && spotResult.getAbnormalHandleAdminType().equals(liableUser.getAlarmType())) {
                            s.append(liableUser.getUser()).append(",");
                        }
                    }
                }
            }
        }
        return s.toString();
    }

//    //定时操作 （报警类型）
//    @Component
//    public class ScheduledTask {
//        @Scheduled(fixedRate = 1800000) //每半小时执行一次
//        public void reportCurrentTime() throws InterruptedException {
//            alarmData();
//        }
//    }


    public List<Interlocking> aa(List<Interlocking> spotResults, List<ConfigUser> configUsers) {
        if (spotResults.size() > 0) {
            for (Interlocking spotResult : spotResults) { //所有的点检结果
                StringBuilder s = new StringBuilder(); // 责任人拼接
                if (spotResult.getAltpid() != null && Integer.parseInt(spotResult.getAltpid()) > 0 && spotResult.getAbnormalHandleDealDepart() != null) { //报警数据 && 责任部门不为null
                    String[] split = spotResult.getAbnormalHandleDealDepart().split(","); //切分责任部门
                    for (String s1 : split) { //获取点检结果表责任部门下的每个部门
                        for (ConfigUser liableUser : configUsers) { //获取责任人表数据
                            String[] split1 = liableUser.getDepartment().split(","); //切分责任人管理的部门
                            for (String s2 : split1) { //获取所有的责任部门
                                if (spotResult.getAbnormalHandleAdminType() != null && s1.equals(s2) && spotResult.getAbnormalHandleAdminType().equals(liableUser.getAlarmType())) { // 当责任部门和管理部门相同时，拼接用户
//                                    if (s1.indexOf("生产") > 0 && liableUser.getAlarmType().equals("1")) { //判断是否是生产部门需当班处理的
//                                        if (spotResult.getTeam().equals(liableUser.getTeam())) {
//                                            s.append(liableUser.getUser()).append(",");
//                                        }
//                                    } else {
                                    s.append(liableUser.getUser()).append(",");
//                                        spotResult.getResultId()
//                                    }
//                                    更新报警处理责任人
                                    indexService.Interlocking_update_alarm_liable(spotResult.getResultId(), s.toString());

                                }
                            }
                        }
                    }
                    spotResult.setDealPerson(s.toString());
                }
            }
        }


        return spotResults;
    }

    //根据用户id查询所在工段
    @RequestMapping(value = "/interlocking/dept/id", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getDeptById(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
        List<Interlocking> interlockings = indexService.search_dxj_dept_id(userId);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data",interlockings);
        return hashMap;
    }


}