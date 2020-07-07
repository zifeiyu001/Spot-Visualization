package com.demo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class timebijiao {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      String startTime="2020/05/20 " +
              "8:00";
        Date parse = dateTimeFormat.parse(startTime);

        long  time2=60*1000*5;//5分钟
        long time = parse.getTime();//开始时间
        Date date = new Date(time + time2);
        String format = dateTimeFormat.format(date);
        System.out.println(format);
        String endData="";
//        for循环数据
//        for开始结束时间
        for (int a=0;a<145;a++){
            if (true){

            }
        }
        System.out.println(time);
    }
}
