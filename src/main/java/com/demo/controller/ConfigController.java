package com.demo.controller;

import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.Config;
import com.demo.model.universal.ConfigUser;
import com.demo.model.universal.Maintenance;
import com.demo.model.universal.TreeCode;
import com.demo.service.IndexService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ConfigController {
    // 首页
    @Autowired
    private IndexService indexService;

//=================测试==============================
    @RequestMapping(value = "/pc/getMaintenance", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,Object> getMaintenance(@RequestBody  Map<String, String> params){


        String deptName = params.get("deptName");
        String routeName = params.get("routeName");
        String zoneName = params.get("zoneName");
        String devName = params.get("equip");
        String dealResult = params.get("dealResult");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        List<Maintenance> maintenances = indexService.pc_get_MaintenanceResult(deptName, routeName, zoneName, devName, startTime, endTime, dealResult);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("data",maintenances);
        return objectObjectHashMap;
    }
//获取工段的清单
    @RequestMapping(value = "/pc/getConfigUser", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String,Object> getConfigUser(){
        List<ConfigUser> dept_list = indexService.get_dept_list();
        for (int a=0;a<dept_list.size();a++){
            dept_list.get(a).getLayerCode();
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        return objectObjectHashMap;
    }


// 获取所有的工段
    @RequestMapping(value = "/pc/getdept", method = RequestMethod.GET)
    @ResponseBody
    public    HashMap<String, Object> gettest(){

        List<ConfigUser> dept_list = indexService.get_dept_user_list();

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("data",dept_list);
        return objectObjectHashMap;
    }
//    获取所有的用户
    @RequestMapping(value = "/pc/getdeptUser", method = RequestMethod.POST)
    @ResponseBody
    public    HashMap<String, Object> gettestUdser(@RequestBody  Map<String, String> params){

        String equipId = params.get("equipId");
        List<ConfigUser> dept_list = indexService.get_dept_user_ll_list(equipId);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("data",dept_list);
        return objectObjectHashMap;
    }




//责任人的配置 修改、保存
    @RequestMapping(value = "/pc/config/chargePerson", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> configChargePerson(@RequestBody  Map<String, String> params , HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String deptName = params.get("deptName");
        String deptId = params.get("deptId");
        String user = params.get("user");
        String userId = params.get("userId");
        String department = params.get("department");
        String alarmType = params.get("alarmType");
        String team = params.get("team");
        List<ConfigUser> configUsers = indexService.search_config_partment_user(userId,alarmType,team);
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
    //判断是否存在需要的权限
        boolean xk_bj_type = judgeUserAuthority(request);

    //当满足条件时执行需要操作
        if(xk_bj_type==true||username.equals("cmstk")){
           if (configUsers.size()>0){
               Integer integer = indexService.update_config_partment_user(deptName, deptId, user, userId, department,alarmType,team);
               if (integer>=0){ hashMap.put("data","更新成功！");hashMap.put("data1","ok");
               } else { hashMap.put("data","更新失败！");hashMap.put("data1","no"); }
           }else {
               Integer integer = indexService.set_config_partment_user(deptName, deptId, user, userId, department,alarmType,team);
               if (integer>=0){ hashMap.put("data","保存成功！"); hashMap.put("data1","ok");}
               else { hashMap.put("data","保存失败！");hashMap.put("data1","no"); } }
       }
       else {
           hashMap.put("data","无权限！");hashMap.put("data1","no");
       }


            return hashMap;
    }


    //根据用户对数据进行修改、保存
    @RequestMapping(value = "/pc/config/liable_exist", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> liable_exist(@RequestBody  Map<String, String> params){
        HashMap<String, Object> hashMap = new HashMap<>();
        String workshopId = params.get("workshopId");
        List<ConfigUser> configUsers = indexService.search_config_liable_user(workshopId);
        hashMap.put("data",configUsers);
        return hashMap;

    }


    //根据用户对数据进行修改、保存
    @RequestMapping(value = "/pc/config/getDeptName", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> getDeptName(@RequestBody  Map<String, String> params){
        HashMap<String, Object> hashMap = new HashMap<>();
        String userId = params.get("userId");
        String alarmType = params.get("alarmType");
        String team = params.get("team");
        List<Interlocking> interlockings = indexService.Interlocking_get_deptName();// 所有的工段
        List<ConfigUser> configUsers = indexService.search_config_partment_user(userId,alarmType,team);
        hashMap.put("deptData",interlockings);
        hashMap.put("userDeptDdata",configUsers);
        return hashMap;

    }

//    管理员配置页面
    @RequestMapping(value = "/pc/config/manage", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> configManage(@RequestBody  Map<String, String> params , HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String deptName = params.get("deptName");
        String deptId = params.get("deptId");
        String user = params.get("user");
        String userId = params.get("userId");
        String manageDepart = params.get("manageDepart");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
    //判断是否存在需要的权限
        boolean xk_bj_type = judgeUserAuthority(request);

     //当满足条件时执行需要操作
        if(xk_bj_type==true||username.equals("cmstk")){
            List<ConfigUser> configUsers = indexService.search_config_alarm_manage(userId);
            if (configUsers.size()>0){
                Integer integer = indexService.update_config_alarm_manage(deptName, deptId, user, userId,manageDepart);
                if (integer>=0){ hashMap.put("data","更新成功！");hashMap.put("status","success");
                } else { hashMap.put("data","更新失败！");hashMap.put("status","failure"); }
            }else {
                Integer integer = indexService.set_config_alarm_manage(deptName, deptId, user, userId,manageDepart);
                if (integer>=0){ hashMap.put("data","保存成功！"); hashMap.put("status","success");}
                else { hashMap.put("data","保存失败！"); hashMap.put("status","failure");} }
        }
        else {
            hashMap.put("data","无权限！"); hashMap.put("status","failure");
        }

        return hashMap;
    }

    //    查询已经存在的管理员
    @RequestMapping(value = "/pc/config/manage_exist", method = RequestMethod.GET)
    @ResponseBody
    public  HashMap<String, Object> configManageExist(){
        HashMap<String, Object> hashMap = new HashMap<>();

        List<ConfigUser> configUsers = indexService.search_config_alarm_manage_exist();

        hashMap.put("data",configUsers);

        return hashMap;
    }

    //  删除用户
    @RequestMapping(value = "/pc/config/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> deleteUser(@RequestBody  Map<String, String> params , HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String userId = params.get("userId");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
     //判断是否存在需要的权限
        boolean xk_bj_type = judgeUserAuthority(request);
     //当满足条件时执行需要操作
        if(xk_bj_type==true||username.equals("cmstk")){
            Integer configUsers = indexService.delete_user(userId);
            if (configUsers>0){ hashMap.put("data","删除成功");}
            else {hashMap.put("data","删除失败");}
        }else { hashMap.put("data","无权限");}
        return hashMap;
    }

    //  删除责任人用户
    @RequestMapping(value = "/pc/config/deleteLiableUser", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> deleteLiableUser(@RequestBody  Map<String, String> params , HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String userId = params.get("userId");
        String department = params.get("department");
        String alarmType = params.get("alarmType");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
    //获取登录用户的权限
        boolean xk_bj_type = judgeUserAuthority(request);
    //当满足条件时执行需要操作
        if(xk_bj_type==true || username.equals("cmstk")){
            Integer configUsers = indexService.delete_liable_user(department,userId,alarmType);
            if (configUsers>0){ hashMap.put("data","删除成功");}
            else {hashMap.put("data","删除失败");}
        }else { hashMap.put("data","无权限");}
        return hashMap;
    }




    //  获取配置数据
    @RequestMapping(value = "/pc/config/getConfigData", method = RequestMethod.GET)
    @ResponseBody
    public  HashMap<String, Object> getConfigData(HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
            List<Config> configData = indexService.getConfigData();
            hashMap.put("data",configData);
        return hashMap;
    }

    //  获取配置数据
    @RequestMapping(value = "/pc/config/setConfigData", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, Object> setConfigData(@RequestBody  Map<String, String> params ,HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String alarm_list_start = params.get("alarm_list_start");
        String alarm_list_end = params.get("alarm_list_end");
        String alarm_c_deal_start = params.get("alarm_c_deal_start");
        String alarm_c_deal_end = params.get("alarm_c_deal_end");
        String alarm_tips_time = params.get("alarm_tips_time");

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println(alarm_list_start+"====="+alarm_list_end);
        //获取登录用户的权限
        boolean xk_bj_type = judgeUserAuthority(request);
        if(xk_bj_type==true || username.equals("cmstk")){
            Integer configData = indexService.setConfigData(alarm_list_start,alarm_list_end,alarm_c_deal_start,alarm_c_deal_end,alarm_tips_time);
            if (configData>0){ hashMap.put("data","修改成功！");}
            else {hashMap.put("data","修改失败！");}
        }else { hashMap.put("data","无权限");}
        return hashMap;
    }





//判断用户是否有权限
    private   boolean judgeUserAuthority(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        //获取登录用户的权限
        List<Interlocking> interlockings = indexService.search_config_userChange_permission(username);
//        System.out.println(interlockings);
//        for (int a=0;a<interlockings.size();a++){
//            System.out.println(interlockings.get(a).getPermission());
//        }
        boolean xk_bj_type =false;
        for (Interlocking x:interlockings){
            if (x.getPermission().contains("xk_bj_type")){
                xk_bj_type=true;
                break;
            }
        }
//        System.out.println("xk_bj_type======="+xk_bj_type);
        return xk_bj_type;
    }



}