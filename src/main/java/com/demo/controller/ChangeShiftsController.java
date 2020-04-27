package com.demo.controller;
import com.demo.model.changeShifts.ChangeShiftsConfig;
import com.demo.model.changeShifts.ChangeShiftsSpot;
import com.demo.model.changeShifts.jobs.CrushLime;
import com.demo.service.ChangeShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.demo.model.universal.DCSAlarm.getAlarm;
import static com.demo.model.universal.base64StrImage.base64StrToImage;

@RestController
public class ChangeShiftsController {
    // 首页
    @Autowired
    private ChangeShiftsService changeShiftsService;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String station="";

/*==================================================交接班内容======================================================== */

//获取当班点检内容
    @RequestMapping(value = "/spot/changeShifts/sk/sh", method = RequestMethod.GET)
    @ResponseBody
    public  HashMap<String,Object>  changeShifts( HttpServletRequest request) {
//        System.out.println("+============");
        //获取登录人员的信息
        HttpSession session   =   request.getSession();
        String user = session.getAttribute("user").toString();
        String userId = session.getAttribute("username").toString();
        //返回点检信息
        HashMap<String,Object> resultJson = new HashMap<String,Object>();
        HashMap<String, String> nowTeamInfo = getNowTeamInfo(userId);
        if (nowTeamInfo.size()>0){
            String routeNames = nowTeamInfo.get("routeNames");
            station = nowTeamInfo.get("station");
            String deptName = nowTeamInfo.get("deptName");
            String startTime = "2020-03-03 08:00:00";
            String endTime = "2020-03-03 20:00:00";
            //获取点检数据
            List<ChangeShiftsSpot> spot_statistics = changeShiftsService.get_spot_statistics(startTime,endTime,deptName,routeNames);
            resultJson.put("data",spot_statistics);
            resultJson.put("msg","");
            resultJson.put("code","200");
            resultJson.put("data1",nowTeamInfo);
        }else {
            resultJson.put("msg","非当班人员");
            resultJson.put("data","");
            resultJson.put("code","400");
        }


        return resultJson;

    }



    //获取当班点检内容
    @RequestMapping(value = "/spot/changeShifts/sk/sh/save", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,Object>  changeShifts( HttpServletRequest request, CrushLime crushLime) {
        /*
        * 需要判断数据库中是否当前岗位、班组、日期的数据
        * */
        crushLime.setParam1(station);
        Integer integer = changeShiftsService.crushLime(crushLime);
        System.out.println(integer);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        return stringObjectHashMap;
    }


    //    APP获取当前班组信息
    private HashMap<String, String> getNowTeamInfo(String userId){
        String startTime1="2019-07-28 20:00:00";//周期开始时间
        int days=4;//周期天数
        int teamhour=12;//每班小时数
        int paibanNum = getPaibanNum(startTime1, days, teamhour);
//        System.out.println(paibanNum);
        List<ChangeShiftsConfig> appUserConfigs = changeShiftsService.getNowTeamInfo(paibanNum);
        HashMap<String, String> stringObjectHashMap = new HashMap<>();
        StringBuilder stringBuffer = new StringBuilder();
        ;
        for (ChangeShiftsConfig appUserConfig:appUserConfigs){

            if (appUserConfig.getUserId().equals(userId)){
                stringObjectHashMap.put("station",appUserConfig.getStation().toString());
                stringObjectHashMap.put("team",getTeam(appUserConfig.getTeam().toString()));
                stringObjectHashMap.put("shifts",appUserConfig.getShifts().toString());
                stringObjectHashMap.put("deptName",appUserConfig.getDeptName().toString());
                stringBuffer.append(appUserConfig.getRouteName()).append(",");

            }
        }
        stringObjectHashMap.put("routeNames",stringBuffer.toString());
        return stringObjectHashMap;
    }

    //    获取当期时间的排班顺序数
    private int getPaibanNum(String startTime1, int days, int teamhour)  {
        int cyclehour=days*24;
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = null;
        try {
            startTime = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date now=simpleDateFormat.parse(endTime1);
        long h=1000*60*60;
        assert startTime != null;
        long totaltime=now.getTime()-startTime.getTime();
        //计算总计小时数，当有小数时，取整加一
        long l = totaltime%h == 0 ? (totaltime/h):(totaltime/h)+1;
        //计算周期后所剩余小时数
        long aaa=l%cyclehour;
        //所余小时数在第几位，即为周期内排班顺序（当有小数时，取整加一）
        long m=(int)aaa%teamhour == 0 ? (aaa/teamhour):(aaa/teamhour)+1;
        return  (int) m;
    }
    //获取开始结束时间
    public  HashMap<String, String> getStartEndTime() {

        SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH");
        HashMap<String, String> stringObjectHashMap = new HashMap<>();
        Date date1 = new Date();
        long l = date1.getTime() - 1000 * 60 * 60 * 24;
        long l1 = date1.getTime() + 1000 * 60 * 60 * 24;
        Date date2 = new Date(l);
        Date date3 = new Date(l1);
        String time1="08:00:00";
        String time2="20:00:00";
        String yesterday  = dateFormat.format(date2);
        String tomorrow = dateFormat.format(date3);
        String today = dateFormat.format(date1);
        String time = timeFormat.format(date1);
        int hours = Integer.parseInt(timeFormat1.format(new Date()));
        String startTime="";
        String endTime="";
        if (hours>19){
            startTime=today+" "+time2;
            endTime=tomorrow+" "+time1;
        }else if (hours<8){
            startTime=yesterday+" "+time2;
            endTime=today+" "+time1;
        }else {
            startTime=today+" "+time1;
            endTime=today+" "+time2;
        }
        stringObjectHashMap.put("startTime",startTime);
        stringObjectHashMap.put("endTime",endTime);
        return stringObjectHashMap;
    }
    public String getTeam(String team){
        String team1="";
        switch (team) {
            case "1":
                team1 = "一班";
                break;
            case "2":
                team1 = "二班";
                break;
            case "3":
                team1 = "三班";
                break;
            case "4":
                team1 = "四班";
                break;
            default:
                team1 = "无";
                break;
        }
        return team1;
    }
    //    定时操作 （报警类型）
    @Component
    public class ScheduledTask {
        @Scheduled(fixedRate = 1000) //每半小时执行一次
        public void reportCurrentTime() throws InterruptedException {
//            getNowTeamInfo();
        }
    }

}