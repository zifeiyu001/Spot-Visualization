package com.demo;

import com.alibaba.fastjson.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestMac {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        long a=1000*60*30;
        long l = now.getTime() - a;
        long l1 = now.getTime() + a;
        // 2.Long类型转成Date类型
        Date date = new Date(l);
        aa(date);
        Date date1 = new Date(l1);
        aa(date1);

        aa(now);

    }

    public static void aa(Date now){
        int days=4;
        String startTime1="2019-07-28 20:00:00";
        int teamhour=12;
        int cyclehour=days*24;

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
        System.out.println(m);
    }
}