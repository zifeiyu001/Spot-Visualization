package com.demo.controller;
import com.alibaba.fastjson.JSONArray;
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
    private SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
    private String station="";

/*==================================================交接班内容======================================================== */

//获取当班点检内容
    @RequestMapping(value = "/spot/changeShifts/sk/sh", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,Object>  changeShifts(@RequestBody Map<String, String> params, HttpServletRequest request) {
        String endTime = params.get("endTime");
        String startTime = params.get("startTime");
        String deptName = params.get("deptName");
        String routeNames = params.get("routeNames");


        //获取登录人员的信息
        HttpSession session   =   request.getSession();

//        获取登录人员工段、岗位

        //返回点检信息
        HashMap<String,Object> resultJson = new HashMap<String,Object>();

            List<ChangeShiftsSpot> spot_statistics = changeShiftsService.get_spot_statistics(startTime,endTime,deptName,routeNames);
            resultJson.put("data",spot_statistics);
            resultJson.put("msg","");
            resultJson.put("code","200");

        return resultJson;

    }



    //获取当班点检内容
    @RequestMapping(value = "/spot/changeShifts/sk/sh/save", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,Object>  saveShifts( HttpServletRequest request, CrushLime crushLime) {
        /*
        * 需要判断数据库中是否当前岗位、班组、日期的数据
        * */
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("username").toString();
        List<ChangeShiftsConfig> userInfo = changeShiftsService.getUserInfo(userId);
        crushLime.setParam2(userInfo.get(0).getStation());
        crushLime.setParam1(userInfo.get(0).getDeptName());
        System.out.println("查询信息========="+crushLime.getDete()+"-------"+userInfo.get(0).getStation()+"--------"+ userInfo.get(0).getDeptName()+"-------"+crushLime.getShift()+"--------");
        List<CrushLime> sksh_jjbData = changeShiftsService.get_sksh_jjbData(crushLime.getDete(),
                userInfo.get(0).getDeptName(), userInfo.get(0).getStation(), crushLime.getShift());
        if (sksh_jjbData.size()>0){
            Integer integer = changeShiftsService.updateByExample(crushLime);
            if (integer>0){
                stringObjectHashMap.put("msg","修改成功");
            }else {
                stringObjectHashMap.put("msg","修改失败");
            }
//            System.out.println("----------有数据--------"+integer);
        }else {

            Integer integer = changeShiftsService.crushLimeinsertSelective(crushLime);
            if (integer>0){
                stringObjectHashMap.put("msg","保存成功");
            }else {
                stringObjectHashMap.put("msg","保存失败");
            }
        }

        return stringObjectHashMap;
    }
//交班

    @RequestMapping(value = "/spot/changeShifts/sk/sh/shift", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,Object>  Shifts( HttpServletRequest request, CrushLime crushLime) {
        /*
         * 需要判断数据库中是否当前岗位、班组、日期的数据
         * */
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("username").toString();
        List<ChangeShiftsConfig> userInfo = changeShiftsService.getUserInfo(userId);
        crushLime.setParam2(userInfo.get(0).getStation());
        crushLime.setParam1(userInfo.get(0).getDeptName());
        crushLime.setShiftstate("Y");
        crushLime.setShifttime(dateTimeFormat.format(new Date()));

        List<CrushLime> sksh_jjbData = changeShiftsService.get_sksh_jjbData(crushLime.getDete(),
                userInfo.get(0).getDeptName(), userInfo.get(0).getStation(), crushLime.getShift());
        System.out.println("查询信息========="+crushLime.getDete()+"-------"+userInfo.get(0).getStation()+"--------"
                + userInfo.get(0).getDeptName()+"-------"+crushLime.getShift()+"--------"+sksh_jjbData.size());

        if (sksh_jjbData.size()>0){
            System.out.println("----------有数据--------");
            Integer integer = changeShiftsService.updateByExample(crushLime);
            System.out.println("----------有数据--------"+integer);
            if (integer>0){
                stringObjectHashMap.put("msg","交班成功");
                stringObjectHashMap.put("code","200");
            }else {
                stringObjectHashMap.put("msg","交班失败");
                stringObjectHashMap.put("code","400");
            }

        }else {
            System.out.println("----------无数据--------");
            Integer integer = changeShiftsService.crushLimeinsertSelective(crushLime);
            System.out.println("----------无数据--------"+integer);
            if (integer>0){
                stringObjectHashMap.put("msg","交班成功");
                stringObjectHashMap.put("code","200");
            }else {
                stringObjectHashMap.put("msg","交班失败");
                stringObjectHashMap.put("code","400");
            }

        }

        return stringObjectHashMap;
    }

    @RequestMapping(value = "/spot/changeShifts/sk/sh/succession", method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String,Object>  succession( HttpServletRequest request, CrushLime crushLime) {
        /*
         * 需要判断数据库中是否当前岗位、班组、日期的数据
         * */
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("username").toString();
        List<ChangeShiftsConfig> userInfo = changeShiftsService.getUserInfo(userId);
        crushLime.setParam2(userInfo.get(0).getStation());
        crushLime.setParam1(userInfo.get(0).getDeptName());
        crushLime.setSuccessionstate("Y");
        crushLime.setSuccessiontime(dateTimeFormat.format(new Date()));
        List<CrushLime> sksh_jjbData = changeShiftsService.get_sksh_jjbData(crushLime.getDete(),
                userInfo.get(0).getDeptName(), userInfo.get(0).getStation(), crushLime.getShift());
        System.out.println("查询信息========="+crushLime.getDete()+"-------"+userInfo.get(0).getStation()+"--------"
                + userInfo.get(0).getDeptName()+"-------"+crushLime.getShift()+"--------"+sksh_jjbData.size());

        if (sksh_jjbData.size()>0){
            System.out.println("----------有数据--------");
            Integer integer = changeShiftsService.updateByExample(crushLime);
            System.out.println("----------有数据--------"+integer);
            if (integer>0){
                stringObjectHashMap.put("msg","接班成功");
                stringObjectHashMap.put("code","200");
            }else {
                stringObjectHashMap.put("msg","接班失败");
                stringObjectHashMap.put("code","400");
            }

        }else {
            System.out.println("----------无数据--------");
            Integer integer = changeShiftsService.crushLimeinsertSelective(crushLime);
            System.out.println("----------无数据--------"+integer);
            if (integer>0){
                stringObjectHashMap.put("msg","接班成功");
                stringObjectHashMap.put("code","200");
            }else {
                stringObjectHashMap.put("msg","接班失败");
                stringObjectHashMap.put("code","400");
            }

        }

        return stringObjectHashMap;
    }

    //获取进入人员信息
    @RequestMapping(value = "/spot/changeShifts/login", method = RequestMethod.GET)
    @ResponseBody
    public  HashMap<String,Object>  changeShiftsLogin( HttpServletRequest request) throws ParseException {

        HashMap<String, Object> loginStatus = getLoginStatus1(request);
        HttpSession session = request.getSession();
        String userId = session.getAttribute("username").toString();
        String user = session.getAttribute("user").toString();
        List<ChangeShiftsConfig> nowTeamInfo = changeShiftsService.getStationRoutesInfo(userId);
        loginStatus.put("routes",nowTeamInfo.get(0).getRouteName());
        loginStatus.put("deptName",nowTeamInfo.get(0).getDeptName());
        loginStatus.put("user",user);
//        System.out.println(loginStatus.get("startTime"));
        return  loginStatus;
    }

    //    获取当期时间及指定时间范围内的排班顺序数
    private HashMap<String, Object> getLoginStatus1(HttpServletRequest request) throws ParseException {
        System.out.println("==============================================================================================");
        HttpSession session = request.getSession();
        String userId = session.getAttribute("username").toString();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        long l0 = 1000 * 60 * 30;//交接班在当班的开始结束时间的前后分钟数
        Date now = new Date(); //当期时间
        long nowL = now.getTime();
        long beforeNowL = now.getTime() - l0;
        long afterNowL = now.getTime() + l0;
        //半小时前的班组序号
        int beforeNowNum = getPaibanNum(beforeNowL);
        // 当期的班组序号
        int nowNum = getPaibanNum(nowL);
        //半小时后的班组序号
        int afterNowNum = getPaibanNum(afterNowL);
        String shifts = "";//班次
        String jjbdate = "";//日期
        String startTime = "";
        String endTime = "";

//        获取用户信息（工段、岗位、班组）
        List<ChangeShiftsConfig> changeShiftsServiceUserInfo = changeShiftsService.getUserInfo(userId);
        String deptName = changeShiftsServiceUserInfo.get(0).getDeptName();//工段
        String station = changeShiftsServiceUserInfo.get(0).getStation();//岗位
        String team = changeShiftsServiceUserInfo.get(0).getTeam();//班组
        HashMap<String, String> teamByNum2 = getTeamByNum(nowNum);
        HashMap<String, String> afterNowNum2 = getTeamByNum(afterNowNum);
        HashMap<String, String> beforeNowNum2 = getTeamByNum(beforeNowNum);
        String afterTeam = afterNowNum2.get("team");
        String nowTeam = teamByNum2.get("team");
        String beforeTeam = beforeNowNum2.get("team");
        System.out.println("班组序号为===" + beforeNowNum + "-----" + nowNum + "-----" + afterNowNum + "---------" + team + "===" + beforeTeam + "==" + nowTeam + "===" + afterTeam);
//        获取登录人员是属于当前班还是上个班组
        String thisTeamOrLastTeam = getThisTeamOrLastTeam(beforeNowNum, afterNowNum, team);
        CrushLime crushLime = new CrushLime();
        crushLime.setParam1(deptName);
        crushLime.setParam2(station);
        System.out.println(thisTeamOrLastTeam);
        if (thisTeamOrLastTeam.equals("shift")){
            String format = dateFormat.format(now);
            System.out.println("beforeNowNum---"+beforeNowNum);
            HashMap<String, String> teamByNum = getTeamByNum(beforeNowNum);
            String team2 = teamByNum.get("team");
            shifts = teamByNum.get("shifts");
            crushLime.setDete(format);
            crushLime.setShift(shifts);
            List<CrushLime> crushLimes = changeShiftsService.crushLimeSelectByExample(crushLime);
            System.out.println("------------------------交班人 ");

            System.out.println("shift------------"+startTime+"-------"+endTime);
//            System.out.println(afterNowNum2.get("team")+"==============================="+getTeam(team));
            if (afterNowNum2.get("team").equals(team)&&!beforeNowNum2.get("team").equals(team)){
                stringObjectHashMap.put("jurisdiction","shift");
                HashMap<String, String> startEndTime = getStartEndTime(afterNowL);
                startTime=startEndTime.get("startTime");
                endTime=startEndTime.get("endTime");
            }else if(!afterNowNum2.get("team").equals(team)&&beforeNowNum2.get("team").equals(team)){
                stringObjectHashMap.put("jurisdiction","shift");
                HashMap<String, String> startEndTime = getStartEndTime(afterNowL);
                startTime=startEndTime.get("startTime");
                endTime=startEndTime.get("endTime");
            }
            else {
                stringObjectHashMap.put("jurisdiction","unshift");
                HashMap<String, String> startEndTime = getStartEndTime(afterNowL);
                startTime=startEndTime.get("startTime");
                endTime=startEndTime.get("endTime");
            }
            System.out.println("shifts========="+shifts);

            stringObjectHashMap.put("data",crushLimes);
            stringObjectHashMap.put("shifts",shifts);
            stringObjectHashMap.put("date",dateFormat.format(dateFormat.parse(startTime)));
            stringObjectHashMap.put("team",getTeam(team));
        }else if (thisTeamOrLastTeam.equals("succession")){
            String format = dateFormat.format(now);
            HashMap<String, String> teamByNum = getTeamByNum(beforeNowNum);
            String team2 = teamByNum.get("team");
            shifts = teamByNum.get("shifts");
            HashMap<String, String> teamByNum1 = getTeamByNum(afterNowNum);
            String team3 = teamByNum.get("team");
            crushLime.setDete(format);
            crushLime.setShift(shifts);
            List<CrushLime> crushLimes = changeShiftsService.crushLimeSelectByExample(crushLime);
            if (crushLimes.size()>0){
                if (crushLimes.get(0).getShiftstate().equals("Y")){
                    if (crushLimes.get(0).getSuccessionstate().equals("Y")){
                        crushLime.setDete(format);
                        crushLime.setShift( teamByNum1.get("shifts"));
                        List<CrushLime> crushLimes1 = changeShiftsService.crushLimeSelectByExample(crushLime);
                        HashMap<String, String> startEndTime = getStartEndTime(afterNowL);
                        startTime=startEndTime.get("startTime");
                        endTime=startEndTime.get("endTime");
                        System.out.println(startTime+"-------"+endTime);
//                        后面的班组和登录班组相同，前面的班组和登录班组不同
                        if (afterNowNum2.get("team").equals(team)&&!beforeNowNum2.get("team").equals(team)){
                            stringObjectHashMap.put("jurisdiction","unshift");
                            stringObjectHashMap.put("team",getTeam(team));
                        }else {
                            stringObjectHashMap.put("jurisdiction","shift");
                            stringObjectHashMap.put("team",getTeam(team2));
                        }

                        stringObjectHashMap.put("data",crushLimes1);
                        stringObjectHashMap.put("shifts",teamByNum1.get("shifts"));
                        stringObjectHashMap.put("date",dateFormat.format(dateFormat.parse(endTime)));

                        System.out.println("显示下个班数据");
                    }else {
                        crushLime.setDete(format);
                        crushLime.setShift(shifts);
                        List<CrushLime> crushLimes1 = changeShiftsService.crushLimeSelectByExample(crushLime);
                        System.out.println("------------------------接班人 ");
                        HashMap<String, String> startEndTime = getStartEndTime(beforeNowL);
                        startTime=startEndTime.get("startTime");
                        endTime=startEndTime.get("endTime");
                        System.out.println(startTime+"-------"+endTime);
                        stringObjectHashMap.put("jurisdiction","succession");
                        stringObjectHashMap.put("data",crushLimes1);
                        stringObjectHashMap.put("shifts",shifts);
                        stringObjectHashMap.put("date",dateFormat.format(new Date()));
                        stringObjectHashMap.put("team",getTeam(team2));

                        System.out.println("显示上个班数据，进行接班");
                    }
                }else {
                    crushLime.setDete(format);
                    crushLime.setShift(shifts);
                    List<CrushLime> crushLimes1 = changeShiftsService.crushLimeSelectByExample(crushLime);
                    System.out.println("------------------------接班人 ");
                    HashMap<String, String> startEndTime = getStartEndTime(beforeNowL);
                    startTime=startEndTime.get("startTime");
                    endTime=startEndTime.get("endTime");
                    System.out.println(startTime+"-------"+endTime);
                    stringObjectHashMap.put("jurisdiction","noshift");
                    stringObjectHashMap.put("data",crushLimes1);
                    stringObjectHashMap.put("shifts",shifts);
                    stringObjectHashMap.put("date",dateFormat.format(new Date()));
                    stringObjectHashMap.put("team",getTeam(team));
                    System.out.println("未交班");
                }
            }else {
                stringObjectHashMap.put("jurisdiction","successionNo");
                stringObjectHashMap.put("shifts",shifts);
                stringObjectHashMap.put("date",dateFormat.format(new Date()));
                stringObjectHashMap.put("team",getTeam(team2));
                HashMap<String, String> startEndTime = getStartEndTime(beforeNowL);
                startTime=startEndTime.get("startTime");
                endTime=startEndTime.get("endTime");
                System.out.println("交班无数据");
            }
        }else {
            stringObjectHashMap.put("jurisdiction","offDuty");
        }

        stringObjectHashMap.put("startTime",startTime);
        stringObjectHashMap.put("endTime",endTime);

        return stringObjectHashMap;

    }












//获取人员班组是属于当班还是上个班
    private  String getThisTeamOrLastTeam(Integer beforeNowNum,Integer afterNowNum,String team){
        String userStatus="";
        System.out.println(beforeNowNum+"=="+afterNowNum+"=="+team);


        if (beforeNowNum.equals(afterNowNum)){
            if (getTeamByNum(beforeNowNum).get("team").equals(team)){
                userStatus="shift";
//                System.out.println("交班人员");
            }else {
                userStatus="none";
//                System.out.println("非当前用户登录的时间段");
            }
        }else {
            if (getTeamByNum(beforeNowNum).get("team").equals(team)){
                userStatus="shift";
//                System.out.println("交班人员");
            }else if(getTeamByNum(afterNowNum).get("team").equals(team)){
                userStatus="succession";
//                System.out.println("接班人员");
            }else {
                userStatus="none";
//                System.out.println("非当前用户登录的时间段");
            }
        }


        return userStatus;
    }
//long类型的时间进行计算得出此时间点的班组序号
    private  int getPaibanNum(Long nowL){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //时间格式
        String startTime1="2019-07-28 20:00:00";//周期开始时间
        int days=4;//周期天数
        int teamhour=12;//每班小时数
        int cyclehour=days*24;

        Date startTime = null;
        try {
            startTime = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long h=1000*60*60;
        assert startTime != null;
        long totaltime=nowL-startTime.getTime();

        //计算总计小时数，当有小数时，取整加一
        long l = totaltime%h == 0 ? (totaltime/h):(totaltime/h)+1;
        //计算周期后所剩余小时数
        long aaa=l%cyclehour;

        double l1 = (double)totaltime / h / cyclehour % teamhour;

//        System.out.println((double) (totaltime / h) +"======"+totaltime / h / cyclehour+"======="+ (double)(totaltime / h / cyclehour /teamhour));


        //所余小时数在第几位，即为周期内排班顺序（当有小数时，取整加一）
        long a=aaa/teamhour;
        System.out.println("totaltime-------"+totaltime+"   小时数为---"+l+"周期剩余小时数------"+aaa+"---------"+a);
//        long m=aaa%teamhour == 0? ((aaa%teamhour)==0?(a-1):a):a;
        long m=0;
        long b=aaa%teamhour;
        if (b==0){
//            m=(aaa/teamhour)==0?7:a;

            if (aaa==0){
                m=7;
            }else {
                m=aaa/teamhour-1;
            }
        }else {
            m=aaa/teamhour;
        }
//        if (a==0){
//            m=(aaa%teamhour)==0?7:a;;
//        }else {
//            m=(aaa%teamhour)==0?(a-1):a;;
//        }
        System.out.println(m);
        return new Long(m).intValue();

    }
//    获取小时数
    private int getHour(Date date){
        String format = hourFormat.format(date);
        return Integer.parseInt(format);
    }
//    获取昨天的日期
    private  String getTomorrow(Date date){
        long l=1000*24*60*60;
        long time = date.getTime()+l;
        Date date1 = new Date(time);
        return dateFormat.format(date1);
    }
//    获取班组
    private HashMap<String, String>  getTeamByNum(Integer teamNum){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        System.out.println(teamNum);
        String team = changeShiftsService.getTeamNumInfo(teamNum).get(0).getTeam();
        String shifts = changeShiftsService.getTeamNumInfo(teamNum).get(0).getShifts();
        stringStringHashMap.put("team",team);
        stringStringHashMap.put("shifts",shifts);
//        System.out.println("team------"+team);
        return  stringStringHashMap;
    }
private String getDate(){
    String format="";
    Date date = new Date();
    int i = Integer.parseInt(hourFormat.format(date));
    if (i>=20){
        Date date1 = new Date(date.getTime() + 1000 * 60 * 60 * 24);
        format = dateFormat.format(date1);
    }else {
        format = dateFormat.format(date);
    }
    return format;
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
private HashMap<String,String> getShifts(int hour){
    Date date = new Date();
    HashMap<String, String> stringStringHashMap = new HashMap<>();
    String shifts="";
    String jjbdate="";
    if (hour>=8&&hour<20){
        System.out.println("交接班的日期1为："+dateFormat.format(date));
        shifts="白班";
        jjbdate=dateFormat.format(date);
    }else if (hour>=0&&hour<8){
        System.out.println("交接班的日期2为："+dateFormat.format(date));
        shifts="夜班";
        jjbdate=dateFormat.format(date);
    }else {
        System.out.println("交接班的日期3为："+getTomorrow(date));

        shifts="夜班";
        jjbdate=getTomorrow(date);
    }
    stringStringHashMap.put("shifts",shifts);
    stringStringHashMap.put("jjbdate",jjbdate);
    return stringStringHashMap;
}

    //获取开始结束时间
    private   HashMap<String, String> getStartEndTime(long a) {

        SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH");
        HashMap<String, String> stringObjectHashMap = new HashMap<>();
        Date date = new Date(a);
        long l = date.getTime() - 1000 * 60 * 60 * 24;
        long l1 = date.getTime() + 1000 * 60 * 60 * 24;
        Date date2 = new Date(l);
        Date date3 = new Date(l1);
        String time1="08:00:00";
        String time2="20:00:00";
        String yesterday  = dateFormat.format(date2);
        String tomorrow = dateFormat.format(date3);
        String today = dateFormat.format(date);
        String time = timeFormat.format(date);
        int hours = Integer.parseInt(timeFormat1.format(new Date(a)));
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



    //    定时操作 （报警类型）
    @Component
    public class ScheduledTask {
        @Scheduled(fixedRate =2000) //每半小时执行一次
        public void reportCurrentTime() throws InterruptedException {

        }
    }
















}