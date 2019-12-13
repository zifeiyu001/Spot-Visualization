package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    public  Map<String, Object> getDeptName(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        List<Interlocking> interlockings = indexService.Interlocking_get_deptName();

        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取线路数据==================================
    @RequestMapping(value = "/interlocking/routeName", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getRouteName(){
//        String deptName = params.get("deptName");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_routeName();
        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取区域数据==================================
    @RequestMapping(value = "/interlocking/zoneName", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getZoneName(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_zoneName();
        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取设备数据==================================
    @RequestMapping(value = "/interlocking/devName", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getDevName(){

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_devName();
        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取点检部位数据==================================
    @RequestMapping(value = "/interlocking/partName", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getScPart(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_scPart();
        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取点检部位数据==================================
    @RequestMapping(value = "/interlocking/content", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getScContent(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = indexService.Interlocking_get_content();
        objectObjectHashMap.put("data",interlockings);
        return objectObjectHashMap;
    }
    // =========================获取点检结果数据==================================
    @RequestMapping(value = "/interlocking/getResult", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> getResult(@RequestBody Map<String, String> params) {
//        System.out.println("1====="+new Date());
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

        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();


        Integer integer = indexService.Interlocking_get_result_total(deptName, route, zone, equip, part, content, startTime, endTime, zcCheck, bjCheck, bjType1, bjType2, bjType3, wjCheck);

        if (startTime.equals("")) {
            Date now = new Date();
            Date startDate = DateUtils.addDays(now, -30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTime = sdf.format(startDate);// format  为格式化方法
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> spotResults = indexService.Interlocking_get_result(deptName, route, zone, equip, part, content, startTime, endTime, zcCheck, bjCheck, bjType1, bjType2, bjType3, wjCheck,
                startPage, numPerPage);
        objectObjectHashMap.put("total", integer);
        objectObjectHashMap.put("data", spotResults);
        return objectObjectHashMap;
    }
    //  修改报警类型
    @RequestMapping(value = "/interlocking/changeAlarmType", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> changeAlarmType(@RequestBody  Map<String, String> params){

        HashMap<String, Object> hashMap = new HashMap<>();
        String resultId = params.get("resultId");
        String alarmType = params.get("alarmType");
        String userName = params.get("name");
        String selectDepart = params.get("selectDepart");
        String part = params.get("part");
//        System.out.println(part);
//        System.out.println(part);
        List<ConfigUser> configUsers1 = indexService.search_config_alarm_manage_user(userName,part); //判断操作人是否有权限
        if (configUsers1.size()>0){
            Integer configUsers = indexService.Interlocking_changeAlarmType(resultId,alarmType,configUsers1.get(0).getUser(),selectDepart);
//            System.out.println(configUsers);
            if(configUsers>0){
                List<Interlocking> resultByResult=indexService.Interlocking_get_byId_result(resultId);//点检结果表数据
                String deptName = resultByResult.get(0).getDeptName();
                String routeName = resultByResult.get(0).getRouteName();
                String zoneName = resultByResult.get(0).getZoneName();
                String devName = resultByResult.get(0).getDevName();
                String scPart = resultByResult.get(0).getScPart();
                String scContent = resultByResult.get(0).getScContent();
                String altpid = resultByResult.get(0).getAltpid();
                String stdValue = resultByResult.get(0).getStdValue();
                List<Interlocking> result = indexService.Interlocking_get_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid);
                if (result.size()>0){//判断有数据
                    //update
                    Integer result1 = indexService.Interlocking_update_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid, alarmType, userName, selectDepart);
                }
                else {
                    //insert
                    Integer result2 = indexService.Interlocking_insert_temp_result(deptName, routeName, zoneName, devName, scPart, scContent, stdValue, altpid, alarmType, userName, selectDepart);
                }
                hashMap.put("data","操作成功");
                String user = changePersonLiable(resultId);  //根据条件获取报警处理责任人
                indexService.Interlocking_changeAlarmPersonLiable(resultId, user); //保存数据
            }else {  hashMap.put("data","操作失败");}

        }
        else {
            hashMap.put("data","无权限操作");
        }

        return hashMap;
    }

//
    private void alarmData(){
        /*
         * 找出当日已经点检，并且为报警的数据
         * 责任部门为空
         * 遍历数据，当报警临时表中的多个字段相同时，将报警类型修改人、报警类别、责任部门数据 更新到点检结果表中
         * 根据报警类别，责任部门，跟新责任人
         * */
        List<Interlocking> interlockings = indexService.Interlocking_get_all_alarm_byDay(); //当日所有报警数据
        List<Interlocking> allAlarmType = indexService.Interlocking_get_all_alarmType(); //所有报警类型
        for(Interlocking a:interlockings){ //遍历当日所有报警数据
            for(Interlocking b:allAlarmType){ //遍历所有报警类型
                if(a.getDeptName().equals(b.getDeptName()) && a.getRouteName().equals(b.getRouteName()) && a.getZoneName().equals(b.getZoneName())
                    && a.getDevName().equals(b.getDevName()) && a.getScPart().equals(b.getScPart())&& a.getScContent().equals(b.getScContent())
                        && a.getAltpid().equals(b.getAltpid())&& a.getStdValue().equals(b.getStdValue())) {//当报警类型相同时
                    Integer configUsers = indexService.Interlocking_changeAlarmType(a.getResultId(),b.getAbnormalHandleAdminType(),b.getAbnormalHandleUser(),b.getAbnormalHandleDealDepart());
                    if (configUsers>0){ //当报警级别修改完毕后
                        String user = changePersonLiable(a.getResultId());
                        Integer integer = indexService.Interlocking_changeAlarmPersonLiable(a.getResultId(), user); // 存储对应类别、部门的责任人
                        if (integer>0){
                            Integer integer1 = indexService.Interlocking_update_alarm_result(a.getDeptName(), a.getRouteName(), a.getZoneName(), a.getDevName(), a.getScPart(), a.getScContent(), user);
                        }
                    }
                }
            }
        }
    }
// 获取报警数据责任人
    private   String changePersonLiable(String resultId){
        Interlocking spotResult = indexService.Interlocking_get_byId_result(resultId).get(0);//点检结果表数据
        List<ConfigUser> configUsers = indexService.search_config_alarm_liable_all();
        StringBuilder s = new StringBuilder(); // 责任人拼接
        if (spotResult.getAltpid() != null && Integer.parseInt(spotResult.getAltpid()) > 0 && spotResult.getAbnormalHandleDealDepart() != null) { //报警数据 && 责任部门不为null
            String[] split = spotResult.getAbnormalHandleDealDepart().split(","); //切分责任部门
            for (String s1 : split) { //获取点检结果表责任部门下的每个部门
                for (ConfigUser liableUser : configUsers) { //获取责任人表数据
                    String[] split1 = liableUser.getDepartment().split(","); //切分责任人管理的部门
                    for (String s2 : split1) { //获取所有的责任部门
//                        System.out.println(s1+"======"+s2+"==="+spotResult.getAbnormalHandleAdminType()+"==="+liableUser.getAlarmType());
                        if (spotResult.getAbnormalHandleAdminType() != null && s1.equals(s2) && spotResult.getAbnormalHandleAdminType().equals(liableUser.getAlarmType())) { // 当责任部门和管理部门相同时，拼接用户
                            if (s1.indexOf("生产") > 0 && liableUser.getAlarmType().equals("1")) { //判断是否是生产部门需当班处理的
//                                System.out.println(spotResult.getTeam()+"====="+liableUser.getTeam());
                                if (spotResult.getTeam() != null && spotResult.getTeam().equals(liableUser.getTeam())) {

                                    s.append(liableUser.getUser()).append(",");
                                }
                            } else {
                                s.append(liableUser.getUser()).append(",");
                            }
                        }
                    }
                }
            }
        }
        return s.toString();
    }


//定时操作
    @Component
    public class ScheduledTask {
        @Scheduled(fixedRate = 50000) //每半小时执行一次
        public void reportCurrentTime() throws InterruptedException {
            alarmData();
        }
    }
    public  List<Interlocking> aa(List<Interlocking> spotResults,List<ConfigUser> configUsers){
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
                                    if (s1.indexOf("生产") > 0 && liableUser.getAlarmType().equals("1")) { //判断是否是生产部门需当班处理的
                                        if (spotResult.getTeam().equals(liableUser.getTeam())) {
                                            s.append(liableUser.getUser()).append(",");
                                        }
                                    } else {
                                        s.append(liableUser.getUser()).append(",");
                                    }
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



}