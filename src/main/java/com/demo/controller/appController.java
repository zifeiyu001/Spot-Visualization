package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.model.app.*;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.*;
import com.demo.service.IndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.formula.functions.Now;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static com.demo.model.universal.DCSAlarm.getAlarm;
import static com.demo.model.universal.base64StrImage.base64StrToImage;
import static com.fasterxml.jackson.databind.util.ISO8601Utils.format;

@RestController
public class appController {
    // 首页
    @Autowired
    private IndexService indexService;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


/*==================================================app用户登录======================================================== */


    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appLogina(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        String userName = params.get("userName"); // 用户名
        String passWord = params.get("passWord");// 获取明文密码

//       对明文密码进行加密
        String md5passWord = DESUtil.passwordEncrypt(passWord);
        System.out.println(userName + "+++++" + passWord + "==========" + md5passWord);
        //判断输入是否为空
        if (passWord.isEmpty() || userName.isEmpty()) {
            resultJson.setMsg("请填写用户名、密码");
            resultJson.setCode(StatusCode.PARAMS_ERROR.getCode());
            resultJson.setData(false);
        } else {
            List<AppLoginUser> appLoginUsers = indexService.app_user_login1(userName, md5passWord);
            if (appLoginUsers.size() > 0) {
                resultJson.setMsg("登录成功！！！");
                resultJson.setCode(StatusCode.SUCCESS.getCode());
                AppLoginUser appLoginUser = appLoginUsers.get(0);
//                System.out.println(appLoginUser.getUserName() + "" + appLoginUser.getDeptName());
                resultJson.setData(appLoginUsers);
            } else {
                resultJson.setMsg("用户不存在或密码错误！");
                resultJson.setCode(StatusCode.NOT_LOGIN.getCode());
            }
        }

        return resultJson;
    }
    /*============================================交接班进入================================================================== */
    @RequestMapping(value = "/app/accessjjb", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appLoginwa(@RequestBody Map<String, String> params) throws ParseException {
//        System.out.println("==============================");
        ResultJson resultJson = new ResultJson();
        String userId = params.get("userName");
        List<AppScheduling> appSchedulings = indexService.app_get_team_scheduling();   //获取多有的班次信息
        Date startDateP = dateTimeFormat.parse(dateTimeFormat.format(appSchedulings.get(0).getdTime())); //排班最开始时间
        String nowDateRealS = dateFormat.format(new Date()); // 当前日期
        Date nowDateRealD = dateFormat.parse(nowDateRealS);      //当前日期
        String nowDateTimeRealS = dateTimeFormat.format(new Date()); // 当前日期时间
        Date nowDateTimeRealD = dateTimeFormat.parse(nowDateTimeRealS);      //当前日期时间
        Date nowTime1 = timeFormat.parse(timeFormat.format(new Date())); //当前时间
        String nowTime11 = timeFormat.format(nowTime1);
        long lll=30*60*1000;  //半小时  long类型
//        long l1 = nowTime1.getTime() + lll;
        int l = (int)((nowDateTimeRealD.getTime()-startDateP.getTime())/(24*60*60*1000)%4); //周期差值

        Calendar   calendar = new GregorianCalendar();
        calendar.setTime(startDateP);
        calendar.add(calendar.DATE,l); //根据相差的天数，在排班时间上添加相应的天数
        Date time = calendar.getTime();
        String format = dateFormat.format(time); // 对照存储时间的日期
//        System.out.println(nowDateRealS+"===="+l+"==="+format);
//        String nowTimeReal = timeFormat.format(new Date()); //当前时间

        Date nowDateTime1=dateTimeFormat.parse(format+" "+nowTime11);// 当前日期时间
        Date nowDateTime2=dateTimeFormat.parse(format+" "+timeFormat.format(new Date(nowTime1.getTime() + lll))); // 当前日期时间后30分钟
        Date nowDateTime3=dateTimeFormat.parse(format+" "+timeFormat.format(new Date(nowTime1.getTime() - lll)));// 当前日期时间前30分钟
        String teamId=""; //班组id
        Calendar   calendar1 = new GregorianCalendar();
        String endTime="";
        String startTime="";
//        获取登录用户的信息
        List<APPUserConfig> appUserConfigs = indexService.app_get_jjb_team_byUserId(userId);

//        ================计算当前时间的班组==========
        for (int a=0;a<appSchedulings.size()-1;a++){
            Date date0 = appSchedulings.get(0).getdTime();//第一个时间
            Date date1 = appSchedulings.get(a).getdTime(); // 前一个时间
            Date date2 = appSchedulings.get(a+1).getdTime(); //后一个时间
            Date date3 = appSchedulings.get(appSchedulings.size() - 1).getdTime();//最后一个时间
//            当前时间前
            boolean before = nowDateTime2.after(date1);
            boolean after = nowDateTime2.before(date2);
            boolean before1 = nowDateTime3.after(date1);
            boolean after1 = nowDateTime3.before(date2);

            if ((before&&after)||(before1&&after1)){ //在排班表中满足前后30分钟登录
//               String teamName = appSchedulings.get(a + 1).getTeamName();
                teamId = appSchedulings.get(a+1).getTeamId();

//                System.out.println("teamId====="+teamId+"===--------=="+a);
                Date date = appSchedulings.get(a).getdTime(); //当班开始时间
                Date date4 = appSchedulings.get(a+1).getdTime(); //当班结束时间
                String format1 = dateFormat.format(date4); //结束
                String format2 = timeFormat.format(date); //开始
//                System.out.println(format1+"====="+dateFormat.format(time)+"====="+format2);
                startTime=nowDateRealS+" "+format2;
                if (!format.equals(dateFormat.format(date4))){
                    calendar1.setTime(nowDateRealD);
                    calendar1.add(calendar.DATE,1);
                    endTime=dateFormat.format(calendar1.getTime())+" "+timeFormat.format(date4);
                }
                else {
                    endTime=nowDateRealS+" "+timeFormat.format(date4);
                }
                break;  //当满足条件后，终止循环
            }
            else {
                teamId = appSchedulings.get(0).getTeamId();
                startTime=nowDateRealS+" "+timeFormat.format(date3);
                calendar1.setTime(nowDateRealD);
                calendar1.add(calendar.DATE,1);
                endTime=dateFormat.format(calendar1.getTime())+" "+timeFormat.format(date0);
            }

        }
//========判断用户的班组和当前的班组是否相同，相同允许登陆======
        if (appUserConfigs.size()>0){
            String team = appUserConfigs.get(0).getTeam();
            if (teamId.equals(team)){
//                System.out.println("teamId======="+teamId+"==="+team);
                APPUserConfig appUserConfig = appUserConfigs.get(0);
                appUserConfig.setStartTime(startTime);
                appUserConfig.setEndTime(endTime);

                List<AppLoginUser> appjjbID = indexService.app_user_getjjbID(appUserConfig.getDeptName(), appUserConfig.getJob());
                if (appjjbID.size() > 0) {
                    appUserConfigs.get(0).setJjb_id(appjjbID.get(0).getJjb_id());
                }
                resultJson.setData(appUserConfigs);
                resultJson.setCode(StatusCode.SUCCESS.getCode());
                resultJson.setMsg("进入成功！");
            }
            else {
                resultJson.setCode(StatusCode.UNKNOWN_PERMISSION.getCode());
                resultJson.setMsg("非当班人员，禁止进入！");
            }
        }
        else {
            resultJson.setCode(StatusCode.UNKNOWN_PERMISSION.getCode());
            resultJson.setMsg("非生产人员，禁止进入！");
        }
        return  resultJson;
    }


    /* // =========================================交接班用户登录=====================================================================================*/

    @RequestMapping(value = "/app/accessjjb/old", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appLogin(@RequestBody Map<String, String> params) throws ParseException {
        LocalDate cycleContentDate;
        String startDate;
        ResultJson resultJson = new ResultJson();
        String userName = params.get("userName"); // 用户名
        // 周期天数，开始时间
        List<AppCycle> loginUsersCycle = indexService.app_user_getCycle(userName);
        // 当前日期与周期开始日期的差值
        int cycleDays = Integer.parseInt(loginUsersCycle.get(0).getCycleDays());
//        System.out.println(cycleDays);
        // 判断是否为生产人员
        if (cycleDays == 4) {
            startDate = loginUsersCycle.get(0).getStartDate();
            //当前日期
            LocalDate to = LocalDate.now();
            String[] split = startDate.split("-");
            // 周期开启日期
            LocalDate of = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
//            System.out.println(of);
            int days = (int) ChronoUnit.DAYS.between(of, to);
            int cycleDate = days % cycleDays;
//            System.out.println(days + "=========" + cycleDays + "============" + cycleDate);
            //计算周期内日期
            cycleContentDate = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]) + cycleDate);
//            System.out.println("cycleContentDate：" + cycleContentDate);
            // 获取人员信息
            List<AppLoginUser> appLoginUsers = indexService.app_user_login(userName, cycleContentDate.toString());
//            System.out.println(appLoginUsers.get(0).getUserName());
//                System.out.println(appLoginUsers.get(0).getMeta());
            // 设定时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

            //判断用户是否存在
            if (appLoginUsers.size() > 0) {

                //获取人员值班的开始结束时间戳值
                long startTime = sdf.parse(appLoginUsers.get(0).getStartTime()).getTime();
                long endTime = sdf.parse(appLoginUsers.get(0).getEndTime()).getTime();
                String meta = appLoginUsers.get(0).getMeta();
//                    System.out.println(meta);

                long time = 30 * 60 * 1000;
                long currentTime = System.currentTimeMillis();

                // 对当前时间做前后30分钟
                long currentTime1 = sdf.parse(sdf.format(new Date(currentTime + time))).getTime();  //后30分钟时间戳
                long currentTime2 = sdf.parse(sdf.format(new Date(currentTime - time))).getTime();   //前30分钟时间戳
                long currentTime3 = sdf.parse(sdf.format(new Date(currentTime))).getTime();         //当前时间时间戳

                if (-28800000 <= currentTime3 && currentTime3 <= -25200000 && currentTime3 < endTime) {
                    as(appLoginUsers, resultJson);
                } else if (54000000 < currentTime3 && 57599000 > currentTime3 && currentTime3 > startTime) {
                    as(appLoginUsers, resultJson);
                }
//                    当当前时间在时间范围内时，可以登录
                else if (currentTime1 > startTime && currentTime2 < endTime) {
                    as(appLoginUsers, resultJson);
                } else {
                    resultJson.setMsg("非当班人员，禁止进入！！！");
                    resultJson.setCode(StatusCode.UNKNOWN_PERMISSION.getCode());
                    resultJson.setData("");
                }

            } else {
                resultJson.setMsg("非当班人员，禁止进入！！！");
                resultJson.setCode(StatusCode.UNKNOWN_PERMISSION.getCode());
                resultJson.setData("");
            }
        }
//            非生产人员
        else {
            resultJson.setMsg("非生产人员，禁止进入！");
            resultJson.setData(false);
            resultJson.setCode(StatusCode.NOT_LOGIN.getCode());
        }
//        }
        return resultJson;
    }

    public ResultJson as(List<AppLoginUser> appLoginUsers, ResultJson resultJson) throws ParseException {
        String job = appLoginUsers.get(0).getJob();  //岗位
        String deptName = appLoginUsers.get(0).getDeptName();//工段
        List<AppLoginUser> appjjbID = indexService.app_user_getjjbID(deptName, job);
        if (appjjbID.size() > 0) {
            appLoginUsers.get(0).setJjb_id(appjjbID.get(0).getJjb_id());
        }
        resultJson.setMsg("进入成功！！！");
        resultJson.setCode(StatusCode.SUCCESS.getCode());
        resultJson.setData(appLoginUsers);
        return resultJson;
    }

/*
* ============================================交班内容填写===================================================
* */
//  交接班数据获取
    @RequestMapping(value = "/app/handoverData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson handoverData(@RequestBody JSONArray params) {
//        System.out.println("开始交班");
        ResultJson resultJson = new ResultJson();
//        获取json第一条数据，交接班内容
        JSONObject jsonObj1 = params.getJSONObject(0);
        indexService.app_shift_duty_handover(getNowDateTime(),
                jsonObj1.getString("id"), //id
                jsonObj1.getString("deptName"), //工段
                jsonObj1.getString("job"), //岗位
                jsonObj1.getString("handoverTeam"),//班组
                jsonObj1.getString("handoverDuty"),// 值次
                jsonObj1.getString("handoverName"),// 交班人
                jsonObj1.getString("handoverContent"));//交班内容
//        交接班数据
        for (int i = 2; i < params.size(); i++) {
            JSONObject jsonObj = params.getJSONObject(i);

            String job = jsonObj.getString("job"); // 岗位

            String jjbTagName = jsonObj.getString("jjbTagName"); //字段名

            String jjbValue = jsonObj.getString("jjbValue"); //数值

            indexService.app_jjb_write(getNowDateTime(), job, jjbTagName, jjbValue);

        }
//        第二条数据 获取下个班人员信息
        JSONObject jsonObj2 = params.getJSONObject(1);
        List<AppLoginUser> appLoginUsers = indexService.app_jjb_getNextUser(
//                获取周期内时间后，截取日期
                jsonObj2.getString("dateTime").split(" ")[0],
//                获取岗位数据
                jsonObj2.getString("job"),
//                获取班次顺序的meta值
                String.valueOf(Integer.parseInt(jsonObj2.getString("meta")) + 1));
        resultJson.setMsg("提交成功!!!");
        resultJson.setCode(StatusCode.SUCCESS.getCode());
        resultJson.setData(appLoginUsers);
        return resultJson;
    }

/*==========================================交接需填写时间数据获取===============================================*/

    @RequestMapping(value = "/app/getDemandWriteData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson getDemandWriteData(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        String job = params.get("job");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        if (job.equals("磨矿岗")) {
            //获取每个磨机的dcs数据
            List<AppDemandWriteData> qmj = indexService.app_jjb_getDemandWrite(job, "qmj");
            List<AppDemandWriteData> bzmj = indexService.app_jjb_getDemandWrite(job, "bzmj");
            List<AppDemandWriteData> zmj = indexService.app_jjb_getDemandWrite(job, "zmj");
            //将dcs分别放到map中，后存放的json中
            objectObjectHashMap.put("球磨机", qmj);
            objectObjectHashMap.put("再磨机", zmj);
            objectObjectHashMap.put("半自磨机", bzmj);
            resultJson.setMsg("数据获取成功!!");
            resultJson.setData(objectObjectHashMap);
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        } else {
            resultJson.setMsg("该岗位无数据!!");
            resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
        }

        return resultJson;
    }

/*==============================================交接班填写巡检数据=================================================*/

    @RequestMapping(value = "/app/setDemandWriteData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson setDemandWriteData(@RequestBody JSONArray params) throws ParseException {

        ResultJson resultJson = new ResultJson();
        for (int a = 0; a < params.size(); a++) {
            JSONObject jsonObj1 = params.getJSONObject(a);
            String job = jsonObj1.getString("job"); // 岗位
            String jjbTagName = jsonObj1.getString("jjbTagName"); //字段名
            String jjbValue = jsonObj1.getString("jjbValue"); //数值
            String startTime = jsonObj1.getString("startTime");
            String endTime = jsonObj1.getString("endTime");

            Integer meta = Integer.parseInt(jsonObj1.getString("meta"));
//            String metaStartTime = getMetaStartTime(meta).get(0);
//            System.out.println("metaStartTime;;;;;;;"+metaStartTime);
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            if (job.equals("磨矿岗")) {
                //查询是否存在
                List<AppDemandWriteData> appDemandWriteData = indexService.app_jjb_getWriteData(jjbTagName, startTime);
//            当存在时，更新数据
                if (appDemandWriteData.size() > 0) {
                    Boolean appDemandWriteData1 = indexService.app_jjb_updateWriteData(jjbTagName, jjbValue, startTime);
                    if (appDemandWriteData1) {
                        resultJson.setMsg("数据更新成功!!");
                        resultJson.setCode(StatusCode.SUCCESS.getCode());
                    } else {
                        resultJson.setMsg("数据更新失败!!");
                        resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
                    }
                }
//            当不存在时插入数据
                else {
                    Integer integer = indexService.app_jjb_write(getNowDateTime(), job, jjbTagName, jjbValue);
                    if (integer > 0) {
                        resultJson.setMsg("数据存储成功!!");
                        resultJson.setCode(StatusCode.SUCCESS.getCode());
                    } else {
                        resultJson.setMsg("数据存储失败!!");
                        resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
                    }
                }
            } else {
                resultJson.setMsg("该岗位无数据!!");
                resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
            }
        }
        return resultJson;

    }

/*================================巡检=================获取交接巡检数据=====================================================*/
    @RequestMapping(value = "/app/getSpotData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson getJobSpotData(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        String job = params.get("job");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        String metaStartTime = params.get("startTime");
        String metaEndTime = params.get("endTime");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dateTimeFormat.parse(metaStartTime));
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int meta=0;
        if (hour==8){meta=2;}
        else {meta=1;}

        if (job.equals("磨矿岗")) {
            //获取每个磨机的巡检数据
            List<AppDemandWriteData> qmj = indexService.app_jjb_getspotWrite(job, "qmj", metaStartTime, metaEndTime, meta);
            List<AppDemandWriteData> bzmj = indexService.app_jjb_getspotWrite(job, "bzmj", metaStartTime, metaEndTime, meta);
            List<AppDemandWriteData> zmj = indexService.app_jjb_getspotWrite(job, "zmj", metaStartTime, metaEndTime, meta);
            //将dcs分别放到map中，后存放的json中
            if (qmj.size() > 0) {
                objectObjectHashMap.put("球磨机", qmj);
            }
            if (bzmj.size() > 0) {
                objectObjectHashMap.put("再磨机", zmj);
            }
            if (zmj.size() > 0) {
                objectObjectHashMap.put("半自磨机", bzmj);
            }
            resultJson.setMsg("数据获取成功!!");
            resultJson.setData(objectObjectHashMap);
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        } else {
            resultJson.setMsg("该岗位无数据!!");
            resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
        }

        return resultJson;
    }
/*==========================================获取DCS数据===================================================*/

//  交接班DCS数据获取
    @RequestMapping(value = "/app/DCSData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appGetDCSData(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();

        String jobs = params.get("jobs"); //岗位
//        int meta = Integer.parseInt(params.get("meta"));//meta值
        String metaStartTime = params.get("startTime");
        String metaEndTime = params.get("endTime");
//        String metaStartTime = getMetaStartTime(meta).get(0);
//        String metaEndTime = getMetaStartTime(meta).get(1);

        //根据岗位不同，返回不同的dcs数据
        if (jobs.equals("磨矿岗")) {
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            //获取每个磨机的dcs数据
            List<AppDCS> appDcsMjQmj = indexService.app_jjb_dcs_mk("qmj", metaStartTime, metaEndTime);
            List<AppDCS> appDcsMjZmj = indexService.app_jjb_dcs_mk("zmj", metaStartTime, metaEndTime);
            List<AppDCS> appDcsMjBzmj = indexService.app_jjb_dcs_mk("bzmj", metaStartTime, metaEndTime);


            //将dcs分别放到map中，后存放的json中
            objectObjectHashMap.put("球磨机", getAlarm(appDcsMjQmj));
            objectObjectHashMap.put("再磨机", getAlarm(appDcsMjZmj));
            objectObjectHashMap.put("半自磨机", getAlarm(appDcsMjBzmj));
            resultJson.setData(objectObjectHashMap);

            resultJson.setMsg("获取成功！！！");
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        } else {
            resultJson.setMsg("获取数据失败！！！");
            resultJson.setCode(StatusCode.PARAMS_ERROR.getCode());
        }

        return resultJson;
    }

/*====================================获取点检结果============================================*/

    @RequestMapping(value = "/app/djResult", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson result(HttpServletResponse response, @RequestBody Map<String, String> params) {

        int status = response.getStatus();
        String dateTime = "";
        String msg = "";
        ResultJson resultJson = new ResultJson();
        List<AppReport> appReports = null;
        String deptName = params.get("deptName");// 工段
        String job = params.get("job");//岗位
        String metaStartTime = params.get("startTime");
        String metaEndTime = params.get("endTime");
//        int meta = Integer.parseInt(params.get("meta"));//meta值
//        System.out.println(deptName + "==" + job + "==" + metaStartTime + "=="+metaEndTime);
        // 获取当前的 时
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        // 将小时变为int类型，并和交接周期比较
//        int i = Integer.parseInt(simpleDateFormat.format(date));
//        获取岗位的所有路线
        List<AppReport> jobRoute = getJobRoute(deptName, job);
        for (int a=0;a<jobRoute.size();a++){
            String route_name = jobRoute.get(a).getROUTE_NAME();
//            System.out.println(route_name);
            appReports=indexService.App_Spot_Result(deptName,route_name,metaStartTime,metaEndTime);
        }
        resultJson.setMsg("正常！！！");
        resultJson.setCode(StatusCode.SUCCESS.getCode());
        resultJson.setData(appReports);
        return resultJson;
    }
    public   List<AppReport> getJobRoute(String dept,String job){
        List<AppReport> appReports = indexService.app_get_jjb_deptRoute(dept, job);
        return appReports;
    }
/*===========================================交接需填写巡检数据获取===========================================*/
    @RequestMapping(value = "/app/getDemandSpotData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson getJobSpotWriteData(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        String job = params.get("job");
//        String meta = params.get("meta");
        String metaStartTime = params.get("startTime");
        String metaEndTime = params.get("endTime");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dateTimeFormat.parse(metaStartTime));
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        String meta="";
        if (hour==8){meta="2";}
        else {meta="1";}
//        System.out.println(job + "====" + meta);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        if (job.equals("磨矿岗")) {
            //获取每个磨机的dcs数据
            List<AppDemandWriteData> qmj = indexService.app_jjb_getemandSpotWrite(job, "qmj", meta);
            List<AppDemandWriteData> bzmj = indexService.app_jjb_getemandSpotWrite(job, "bzmj", meta);
            List<AppDemandWriteData> zmj = indexService.app_jjb_getemandSpotWrite(job, "zmj", meta);
            //将dcs分别放到map中，后存放的json中
            objectObjectHashMap.put("球磨机", qmj);
            objectObjectHashMap.put("再磨机", zmj);
            objectObjectHashMap.put("半自磨机", bzmj);
            resultJson.setMsg("数据获取成功!!");
            resultJson.setData(objectObjectHashMap);
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        } else {
            List<AppDemandWriteData> jobSpot = indexService.app_jjb_getemandSpotWrite(job, "", meta);
            resultJson.setMsg("数据获取成功!!");
            resultJson.setData(jobSpot);
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        }

        return resultJson;
    }

/*====================================获取交班人员填写数据===================================*/

    @RequestMapping(value = "/app/getJjbWrite", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson getJjbWrite(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        String job = params.get("job");
// 岗位判断
        if (job.equals("磨矿岗")) {
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//            数据获取
            List<AppDemandWriteData> zmj = indexService.app_jjb_getWrite(job, "zmj");
            List<AppDemandWriteData> qmj = indexService.app_jjb_getWrite(job, "qmj");
            List<AppDemandWriteData> bzmj = indexService.app_jjb_getWrite(job, "bzmj");
            objectObjectHashMap.put("球磨机", qmj);
            objectObjectHashMap.put("再磨机", zmj);
            objectObjectHashMap.put("半自磨机", bzmj);
            if (zmj.size() > 0 && qmj.size() > 0 && bzmj.size() > 0) {
                resultJson.setMsg("获取成功!!!");
                resultJson.setCode(StatusCode.SUCCESS.getCode());
                resultJson.setData(objectObjectHashMap);
            } else {
                resultJson.setMsg("获取失败!!!");
                resultJson.setCode(StatusCode.EXCEPTION.getCode());
            }
        }
//        岗位信息未匹配
        else {
            resultJson.setMsg("该岗位暂无数据!!");
            resultJson.setCode(StatusCode.UNKNOWN_ERROR.getCode());
        }

        return resultJson;
    }
/*====================================设备运行时长获取===================================*/

    @RequestMapping(value = "/app/getRunTime", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson getRunTime(@RequestBody Map<String, String> params) throws ParseException {
        ResultJson resultJson = new ResultJson();
        HashMap<Object, Object> hashMap = new HashMap<>();
        List<HashMap<Object, Object>> mMenuData1 = new ArrayList<>();
        List<HashMap<Object, Object>> mMenuData2 = new ArrayList<>();
        List<HashMap<Object, Object>> mMenuData3 = new ArrayList<>();
        String job = params.get("job");
//        String meta = params.get("meta");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        if (job.equals("磨矿岗")) {
            List<AppDCS> bzmj = indexService.app_jjb_getRunTimeField("bzmj");
//            for (int a = 0; a < bzmj.size(); a++) {
//                HashMap<Object, Object> hashMap1 = new HashMap<>();
//                Double equipRunTime = getEquipRunTime(bzmj.get(a).getVariable(), startTime,endTime);
//                hashMap1.put("description", bzmj.get(a).getDescription());
//                hashMap1.put("value", equipRunTime);
//                hashMap1.put("unit", "h");
//                mMenuData1.add(hashMap1);
//            }
            for(AppDCS a:bzmj){
                HashMap<Object, Object> hashMap2 = new HashMap<>();
                Double equipRunTime1 = getEquipRunTime(a.getVariable(), startTime,endTime);
                hashMap2.put("description",a.getDescription());
                hashMap2.put("value", equipRunTime1);
                hashMap2.put("unit", "h");
                mMenuData2.add(hashMap2);
            }
            List<AppDCS> zmj = indexService.app_jjb_getRunTimeField("zmj");
//            for (int b = 0; b < zmj.size(); b++) {
//                HashMap<Object, Object> hashMap2 = new HashMap<>();
//                Double equipRunTime1 = getEquipRunTime(zmj.get(b).getVariable(), startTime,endTime);
//                hashMap2.put("description", zmj.get(b).getDescription());
//                hashMap2.put("value", equipRunTime1);
//                hashMap2.put("unit", "h");
//                mMenuData2.add(hashMap2);
//            }
            for (AppDCS b:zmj){
                HashMap<Object, Object> hashMap2 = new HashMap<>();
                Double equipRunTime1 = getEquipRunTime(b.getVariable(), startTime,endTime);
                hashMap2.put("description", b.getDescription());
                hashMap2.put("value", equipRunTime1);
                hashMap2.put("unit", "h");
                mMenuData2.add(hashMap2);
            }
            List<AppDCS> qmj = indexService.app_jjb_getRunTimeField("qmj");
//            for (int c = 0; c < qmj.size(); c++) {
//                HashMap<Object, Object> hashMap3 = new HashMap<>();
//                Double equipRunTime2 = getEquipRunTime(qmj.get(c).getVariable(),startTime,endTime);
//                hashMap3.put("description", qmj.get(c).getDescription());
//                hashMap3.put("value", equipRunTime2);
//                hashMap3.put("unit", "h");
//                mMenuData3.add(hashMap3);
//            }
            for (AppDCS c:qmj){
                HashMap<Object, Object> hashMap3 = new HashMap<>();
                Double equipRunTime2 = getEquipRunTime(c.getVariable(),startTime,endTime);
                hashMap3.put("description", c.getDescription());
                hashMap3.put("value", equipRunTime2);
                hashMap3.put("unit", "h");
                mMenuData3.add(hashMap3);
            }
            hashMap.put("半自磨机", mMenuData1);
            hashMap.put("再磨机", mMenuData2);
            hashMap.put("球磨机", mMenuData3);
        }

        resultJson.setData(hashMap);
        return resultJson;
    }
/* // =============================接班内容===============================*/


//  交接班数据获取
    @RequestMapping(value = "/app/successionData", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson successionData(@RequestBody JSONArray params) {
        Integer integer = 0;
        ResultJson resultJson = new ResultJson();
//        获取接班的数据
        for (int i = 0; i < params.size(); i++) {
            JSONObject jsonObj = params.getJSONObject(i);
            integer = indexService.app_shift_duty_succession(getNowDateTime(), jsonObj.getString("id")
                    , jsonObj.getString("succeedTeam"), jsonObj.getString("succeedDuty"), jsonObj.getString("succeedName"), jsonObj.getString("succeedContent"));
        }

        if (integer >= 0) {
            resultJson.setMsg("提交成功!!!");
            resultJson.setCode(StatusCode.SUCCESS.getCode());
        } else {
            resultJson.setMsg("提交失败!!");
            resultJson.setCode(StatusCode.PARAMS_ERROR.getCode());
        }

        return resultJson;
    }
/*//========================================点检结果统计=======================================*/

    @RequestMapping(value = "/app/getResult", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getResult(@RequestBody Map<String, String> params) {
        String deptName = params.get("deptName");
        String route = params.get("route");
        String zone = params.get("zone");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        if (startTime.equals("")) {
            Date now = new Date();
            Date startDate = DateUtils.addDays(now, -30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTime = sdf.format(startDate);// format  为格式化方法
        }

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
//        System.out.println("1-1====="+new Date());
        List<Interlocking> interlockings = indexService.app_get_dxjSearchResult(deptName, route, zone, startTime, endTime);

        objectObjectHashMap.put("data", interlockings);

        return objectObjectHashMap;
    }

/*
* //==================================工具方法====================================================
* */


//    public List<String> getMetaStartTime(int meta) {
//        String startTime = "";
//        String endTime = "";
//        ArrayList<String> strings = new ArrayList<>();
//        if (meta == 1) {
//            startTime = dateFormat.format(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24)) + " 20:00:00";
//            endTime = dateFormat.format(new Date()) + " 08:00:00";
//        } else if (meta == 2) {
//            startTime = dateFormat.format(new Date()) + " 08:00:00";
//            endTime = dateFormat.format(new Date()) + " 20:00:00";
//        } else {
//            startTime = dateFormat.format(new Date()) + " 20:00:00";
//            endTime = dateFormat.format(new Date()) + " 23:59:59";
//        }
//        strings.add(startTime);
//        strings.add(endTime);
//        System.out.println(strings);
//        return strings;
//    }

//    //String类型转换成Date类型
//    public static Date toDate(String date_str) {
//        try {
//            Calendar zcal = Calendar.getInstance();//日期类
//            Timestamp timestampnow = new Timestamp(zcal.getTimeInMillis());//转换成正常的日期格式
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//改为需要的东西
//            ParsePosition pos = new ParsePosition(0);
//            java.util.Date current = formatter.parse(date_str, pos);
//            return current;
//        } catch (NullPointerException e) {
//            return null;
//        }
//    }
//
//    //Date类型转换成String类型
//    public static String toJson(Object obj) {
//        String reuqest = null;
//        //对象映射
//        ObjectMapper mapper = new ObjectMapper();
//        //设置时间格式
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//        mapper.setDateFormat(dateFormat);
//        try {
//            reuqest = mapper.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return reuqest;
//    }

    //
    public String getNowDateTime() {
        Date date = new Date();     //获取一个Date对象
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
        String dataTime = simpleDateFormat.format(date);   //格式化后的时间
        return dataTime;
    }

    // 获取设备的运行时长
    double hour = 0.0;
    public Double getEquipRunTime(String tagname, String startTime,String endTime) throws ParseException {
        String s = "";
        double lastValue = 0.0;
        HashMap<Object, Object> hashMap1 = new HashMap<>();
        ArrayList<Object> objects1 = new ArrayList<>();
//        System.out.println(startTime);
//      查询当前时间段的前一个值
        List<AppDCS> appDCS = indexService.app_jjb_getLastRunTime(tagname, startTime);
//        System.out.println("appDCS.size==========="+appDCS.size());
        if (appDCS.size() > 0) {
            lastValue = appDCS.get(0).getDocValue();
        }
//        System.out.println(lastValue);
//      数据当前时间段的值
        List<AppDCS> nowData = indexService.app_jjb_getRunTime(tagname, startTime,endTime);
//        List<AppDCS> collect = nowData.stream().distinct().collect(Collectors.toList());
        int initialValue = 0;

//      当前时间段数据个数为1
        if (nowData.size() == 1) {

            double startValue = nowData.get(0).getDocValue();  // 区间内的开始值
//            开始数值为1
            if (startValue == 1.0) {
                if (lastValue == 1.0) {  //区间开始值、区间外结束值 都为1时，计算 区间开始值到当前的时间
                    hour = getTimeDifference(startTime, dateTimeFormat.format(new Date()));
                } else {                //区间开始值 1.0 、区间外结束值 0.0，计算 区间开始到当前的时间
                    String dataTime = nowData.get(0).getDataTime();
                    hour = getTimeDifference(dataTime, dateTimeFormat.format(new Date()));
                }
            }
//            开始数据为0
            else {
                if (lastValue == 0) {
                    hour = 0.0;
                } //区间开始值 0.0 、区间外结束值 0.0，运行时长为0.0
                else {                      //区间开始值 0.0 、区间外结束值 1.0，计算 区间开始到当前的时间
                    String dataTime = nowData.get(0).getDataTime();
                    hour = getTimeDifference(startTime, dataTime);
                }

            }
        } else if (nowData.size() > 1) {
            hour += getRunTime1(initialValue, nowData, startTime, lastValue);
        }
//       当期时间段没有数据，查找前一个数据
        else {
            if (lastValue == 0.0) {
                hour = 0.0;
            } else {
                hour = getTimeDifference(startTime, endTime);
            }
        }
        return (double) Math.round(hour * 10) / 10;
    }

    public Double getRunTime1(Integer initialValue, List<AppDCS> nowData, String startTime, Double lastValue) throws ParseException {
        String a = null;
        String b = null;
        int g = 0;
        int h = 0;
        double cc = 0.0;
        ArrayList<Object> objects = new ArrayList<>();
        double docValue = nowData.get(0).getDocValue();
        double appDCS = nowData.get(nowData.size() - 1).getDocValue();
        //      开始为1.0，结尾为0.0
        if (docValue == 1.0 && appDCS == 0.0) {
            if (lastValue == 1.0) {
                hour += getTimeDifference(startTime, nowData.get(0).getDataTime());
            }
            for (h = initialValue; h < nowData.size(); h++) {
                if (nowData.get(h).getDocValue() == 1.0) {
                    a = nowData.get(h).getDataTime();
                    for (g = h + 1; g < nowData.size(); g++) {
                        if (nowData.get(g).getDocValue() == 0.0) {
                            b = nowData.get(g).getDataTime();
                            h = g;
                            hour += getTimeDifference(a, b);
                            break;
                        }
                    }
                }
            }
        }
        //      开始为1.0，结尾为1.0
        else if (docValue == 1.0 && appDCS == 1.0) {
            if (lastValue == 1.0) {
                hour += getTimeDifference(startTime, nowData.get(0).getDataTime());
            }
            for (h = initialValue; h < nowData.size() - 1; h++) {
                if (nowData.get(h).getDocValue() == 1.0) {
                    a = nowData.get(h).getDataTime();
                    for (g = h + 1; g < nowData.size(); g++) {
                        if (nowData.get(g).getDocValue() == 0.0) {
                            b = nowData.get(g).getDataTime();
                            h = g;
                            hour += getTimeDifference(a, b);
                            break;
                        }
                    }
                }
            }
            for (int s = nowData.size() - 1; s >= 0; s--) {
                if (nowData.get(s).getDocValue() == 0.0) {
                    hour += getTimeDifference(nowData.get(s + 1).getDataTime(), dateTimeFormat.format(new Date()));
                    break;
                }
            }
        }
//        开始为0.0，结束为0.0
        else if (docValue == 0.0 && appDCS == 0.0) {
            if (lastValue == 1.0) {
                hour += getTimeDifference(startTime, nowData.get(0).getDataTime());
            }
            for (h = initialValue; h < nowData.size(); h++) {
                if (nowData.get(h).getDocValue() == 1.0) {
                    a = nowData.get(h).getDataTime();
                    for (g = h + 1; g < nowData.size(); g++) {
                        if (nowData.get(g).getDocValue() == 0.0) {
                            b = nowData.get(g).getDataTime();
                            h = g;
                            hour += getTimeDifference(a, b);
                            break;
                        }
                    }
                }
            }
        } else {
            if (lastValue == 1.0) {
                hour += getTimeDifference(startTime, nowData.get(0).getDataTime());
            }
            for (h = initialValue; h < nowData.size() - 1; h++) {
                if (nowData.get(h).getDocValue() == 1.0) {
                    a = nowData.get(h).getDataTime();
                    for (g = h + 1; g < nowData.size(); g++) {
                        if (nowData.get(g).getDocValue() == 0.0) {
                            b = nowData.get(g).getDataTime();
                            h = g;
                            hour += getTimeDifference(a, b);
                            break;
                        }
                    }
                }
            }
            for (int s = nowData.size() - 1; s >= 0; s--) {
                if (nowData.get(s).getDocValue() == 0.0) {
                    hour += getTimeDifference(nowData.get(s + 1).getDataTime(), dateTimeFormat.format(new Date()));
                    break;
                }
            }
        }
        return hour;
    }

    //连个字符串时间的差值
    public double getTimeDifference(String startTime, String endTime) throws ParseException {
        Date parse = dateTimeFormat.parse(startTime);
        Date parse1 = dateTimeFormat.parse(endTime);
        double l = parse1.getTime() - parse.getTime();
        // 将字符型转换成日期型
        return l / 3600000;
    }

    /*
    * 交接班APP配置页面
    * */

    /*================app配置=============交接班APP 岗位配置=======添加、修改=============*/
    @RequestMapping(value = "/app/config/station/set", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigStationSet(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String routeName = params.get("routeName");// 线路
        List<APPUserConfig> appUserConfigs = indexService.app_config_select_station(deptName, station, routeName);
        if (appUserConfigs.size()>0){
            resultJson.setData("更新成功！");
        }
        else {
            Integer integer = indexService.app_config_set_station(deptName, station, routeName);
            if (integer>0){resultJson.setData("添加成功！");}
            else {resultJson.setData("添加失败！");}
        }
        return resultJson;
    }

    /*================app配置=============交接班APP 岗位配置=======删除============*/

    @RequestMapping(value = "/app/config/station/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigStationDelete(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String routeName = params.get("routeName");// 线路
        Integer integer = indexService.app_config_delete_station(deptName, station, routeName);
        resultJson.setData(integer);
        return resultJson;
    }
    /*================app配置=============交接班APP 岗位配置=======查找============*/
    @RequestMapping(value = "/app/config/station/select", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigstationSelect(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String routeName = params.get("routeName");// 线路
        List<APPUserConfig> appUserConfigs = indexService.app_config_select_station(deptName, station, routeName);
        resultJson.setData(appUserConfigs);
        return resultJson;
    }
    /*================app配置=============获取岗位============*/
    @RequestMapping(value = "/app/config/getJob", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigGetTeam(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
//        System.out.println(deptName);
        List<APPUserConfig> appUserConfigs = indexService.app_config_getJob_user(deptName);
        resultJson.setData(appUserConfigs);
        return resultJson;
    }
    /*================app配置=============交接班APP 班组用户=======添加、修改============*/
    @RequestMapping(value = "/app/config/station/user/set", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigStationUserSet(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String team = params.get("team");// 班组
        String userName = params.get("userName");// 岗位
        String userId = params.get("userId");// 班组
        List<APPUserConfig> appUserConfigs = indexService.app_config_select_station_user(deptName, station,team,userId);
        if (appUserConfigs.size()>0){
                resultJson.setData("修改成功！");
        }
        else {
            Integer integer = indexService.app_config_set_station_user(deptName, station, team,userName,userId);
            if (integer>0){ resultJson.setData("添加成功！");}
            else {resultJson.setData("添加失败！");}
        }


        return resultJson;
    }
    /*================app配置=============交接班APP 班组用户=======删除============*/
    @RequestMapping(value = "/app/config/station/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigStationUserDelete(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String team = params.get("team");// 班组
        String userId = params.get("userId");// 班组
        Integer integer = indexService.app_config_delete_station_user(deptName, station, team,userId);
        resultJson.setData(integer);
        return resultJson;
    }
    /*================app配置=============交接班APP 班组用户=======查找============*/
    @RequestMapping(value = "/app/config/station/user/select", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson appConfigStationUserSelect(@RequestBody Map<String, String> params) {
        ResultJson resultJson = new ResultJson();
        String deptName = params.get("deptName"); // 工段名称
        String station = params.get("station");// 岗位
        String team = params.get("team");// 班组
//        String userName = params.get("userName");// 岗位
        String userId = params.get("userId");// 班组
        List<APPUserConfig> appUserConfigs = indexService.app_config_select_station_user(deptName, station,team,userId);
        resultJson.setData(appUserConfigs);
        return resultJson;
    }

/*=================================测试内容==============================================*/

    @RequestMapping(value = "/app/weixiu", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson setWeixiu(@RequestBody Map<String, String> params) {
        String deptName = params.get("deptName");
        String routeName = params.get("routeName");
        String zoneName = params.get("zoneName");
        String devName = params.get("devName");
        String description = params.get("description");
        String pic = params.get("pic");
        String discoverer = params.get("discoverer");
        String phone = params.get("phone");
        long time = (new Date()).getTime();

        String path = "C:/Users/guijun/Desktop/" + time + ".jpg";
        boolean b = base64StrToImage(pic, path);
        ResultJson resultJson = new ResultJson();
        if (b == true) {
            Integer integer1 = indexService.app_set_maintenance(deptName, routeName, zoneName, devName, description, path, discoverer, phone);
            if (integer1 >= 0) {
                resultJson.setMsg("提交成功");
                resultJson.setCode(StatusCode.SUCCESS.getCode());
            } else {
                resultJson.setMsg("提交失败");
                resultJson.setCode(StatusCode.SYS_ERROR.getCode());
            }

        } else {
            resultJson.setMsg("提交失败");
            resultJson.setCode(StatusCode.SYS_ERROR.getCode());
        }


        return resultJson;
    }

}