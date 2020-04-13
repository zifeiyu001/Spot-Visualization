package com.demo;

import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.ResultJson;
import com.demo.service.IndexService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.*;
import java.time.LocalDate;
import java.util.*;

public class DateTest {

    public static void main(String[] args) throws ParseException {

            String a="2020-03-26 16:41:34";
            String b="2020-03-26 17:51:34";
        String h = timeDifference(a, b, "h",3);
        System.out.println(h);

    }

    public static String timeDifference(String startTime, String endTime, String type,Integer num) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = 0;
        double a=0;
        String format="";
        try {
            l = dateTimeFormat.parse(endTime).getTime() - dateTimeFormat.parse(startTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (type.equals("h")){
            a= (double) l/1000/60/60;
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(num);
             format = nf.format(a);
        }
        return format;
    }

}