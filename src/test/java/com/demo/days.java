package com.demo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class days {
    public  HashMap<String, Object> getStartEndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
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
        int format = Integer.parseInt(timeFormat1.format(new Date()));
        String startTime="";
        String endTime="";
        if (format>19){
            startTime=today+" "+time2;
            endTime=tomorrow+" "+time1;
        }else if (format<8){
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
}
