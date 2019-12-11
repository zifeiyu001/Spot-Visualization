package com.demo;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class aa {
//    public static int getDiscrepantDays(Date dateStart, Date dateEnd) {
//        return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
//    }

    public static void main(String[] args) {
        System.out.println( java.util.UUID.randomUUID());
//当前日期
        LocalDate to = LocalDate.now();
        System.out.println(to);
// 周期开启日期
        LocalDate of = LocalDate.of(2019, 9, 7);
        System.out.println(of);
        int cycleNum=4;
// 当前日期与周期开始日期的差值
        int days = (int) ChronoUnit.DAYS.between(of, to);
        System.out.println(days);
        int cycleDate=days%cycleNum;
        System.out.println(cycleDate);
//计算周期内日期
        LocalDate of1 = LocalDate.of(2019, 9, 7 + cycleDate);
//        System.out.println(days%4);
//        System.out.println(days);
//        System.out.println(of);
        System.out.println(of1);
        Date date = aa("09:11:01");
        System.out.println(date.getTime());

    }
    //String类型转换成Date类型
    public static Date aa(String date_str) {
        try {
            Calendar zcal = Calendar.getInstance();//日期类
            Timestamp timestampnow = new Timestamp(zcal.getTimeInMillis());//转换成正常的日期格式
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//改为需要的东西
            ParsePosition pos = new ParsePosition(0);
            java.util.Date current = formatter.parse(date_str, pos);
            timestampnow = new Timestamp(current.getTime());
            return timestampnow;
        }
        catch (NullPointerException e) {
            return null;
        }
    }
}
