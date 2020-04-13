package com.demo;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class timebijiao {
//    public static int getDiscrepantDays(Date dateStart, Date dateEnd) {
//        return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
//    }

    public static void main(String[] args) {
        String a="2019-11-02 11:11:11";
        String b="2019-11-05 11:11:11";
        String c="2013-11-02 11:11:11";
        String d="2012-11-05 11:11:11";
        testString2Date(a+","+b+","+c+","+d);


    }
    public static void testString2Date(String date) {

        String[] split = date.split(",");
        String s1 = split[0];
        String s2 = split[1];
        String s3 = split[2];
        String s4 = split[3];


        int endDay = 0;


    }
    public static void testString2Date1(String date) {
        int startDay = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateStart = format.parse(date);
            startDay = (int) (dateStart.getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(startDay);
    }
}
