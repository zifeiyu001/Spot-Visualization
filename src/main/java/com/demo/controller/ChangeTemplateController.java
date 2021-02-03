package com.demo.controller;

import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.*;
import com.demo.service.ChangeTemplateService;
import com.demo.service.IndexService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

@RestController
public class ChangeTemplateController {
    // 首页
    @Autowired
    private ChangeTemplateService changeTemplateService;
    @Autowired
    private IndexService indexService;
    // =========================获取工段数据==================================
    @RequestMapping(value = "/changeTemplate/deptName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDeptName() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_deptName();

        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取线路数据==================================
    @RequestMapping(value = "/changeTemplate/routeName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRouteName() {
//        String deptName = params.get("deptName");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_routeName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取区域数据==================================
    @RequestMapping(value = "/changeTemplate/zoneName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getZoneName() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_zoneName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取设备数据==================================
    @RequestMapping(value = "/changeTemplate/devName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDevName() {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_devName();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取点检部位数据==================================
    @RequestMapping(value = "/changeTemplate/partName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScPart() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_scPart();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }

    // =========================获取点检内容数据==================================
    @RequestMapping(value = "/changeTemplate/content", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScContent() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_content();
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }
    // =========================获取结果数据==================================
    @RequestMapping(value = "/changeTemplate/getResult", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getResult(@RequestBody Map<String, String> params) {
        String deptName = params.get("deptName");
        String route = params.get("route");
        String zone = params.get("zone");
        String equip = params.get("equip");
        String part = params.get("part");
        String content = params.get("content");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<Interlocking> interlockings = changeTemplateService.changeTemplate_get_result(deptName,route,zone,equip,part,content);
//        System.out.println(interlockings.size());
        objectObjectHashMap.put("data", interlockings);
        return objectObjectHashMap;
    }
    // =========================删除数据==================================
    @RequestMapping(value = "/changeTemplate/deleteData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteData(@RequestBody Map<String, String> params, HttpServletRequest request) {
        String id = params.get("id");
        String deptName = params.get("deptName");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        String userName = request.getSession().getAttribute("username").toString();//用户id
        List<ConfigUser> configUsers = indexService.search_config_alarm_manage_user(userName, deptName);
        if (configUsers.size()>0){
            Integer interlockings = changeTemplateService.changeTemplate_deleteData(id);
//            int interlockings = 200;
            if (interlockings>0){
                objectObjectHashMap.put("msg","删除成功");
                objectObjectHashMap.put("code",StatusCode.SUCCESS.getCode());
            }else {
                objectObjectHashMap.put("msg","删除失败");
                objectObjectHashMap.put("code",StatusCode.EXCEPTION.getCode());
            }
        }else {
            objectObjectHashMap.put("msg","无权限");
            objectObjectHashMap.put("code",StatusCode.UNKNOWN_PERMISSION.getCode());
        }
        return objectObjectHashMap;
    }
    // =========================修改数据==================================
    @RequestMapping(value = "/changeTemplate/changeType", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changeType(@RequestBody Map<String, String> params, HttpServletRequest request) {
        String id = params.get("id");
        String deptName = params.get("deptName");
        String abnormalHandleAdminType = params.get("abnormalHandleAdminType");
        String userName = request.getSession().getAttribute("username").toString();//用户id
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<ConfigUser> configUsers = indexService.search_config_alarm_manage_user(userName, deptName);
        if (configUsers.size()>0){
            Integer interlockings = changeTemplateService.changeTemplate_changeType(id,abnormalHandleAdminType);
//            int interlockings = 200;
            if (interlockings>0){
                objectObjectHashMap.put("msg","修改成功");
                objectObjectHashMap.put("code",StatusCode.SUCCESS.getCode());
            }else {
                objectObjectHashMap.put("msg","修改失败");
                objectObjectHashMap.put("code",StatusCode.EXCEPTION.getCode());
            }
        }else {
            objectObjectHashMap.put("msg","无权限");
            objectObjectHashMap.put("code",StatusCode.UNKNOWN_PERMISSION.getCode());
        }
        return objectObjectHashMap;
    }


}