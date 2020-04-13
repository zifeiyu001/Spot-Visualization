package com.demo.model.universal;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**

 */
public class ToolUtil {
    //    计算时间差
    public   String timeDifference(String startTime, String endTime ,String type,Integer num) {
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
    //计算多个时间的最大最小值
    public  HashMap<String ,String> MaxMinValuesOfMultipleData(String[] dateArray) {
        Map<String, Integer> dateMap = new TreeMap<String, Integer>();
        int i, arrayLen;
        arrayLen = dateArray.length;
        for (i = 0; i < arrayLen; i++) {
            String dateKey = dateArray[i];
            if (dateKey!=null&&dateKey!=""){
                if (dateMap.containsKey(dateKey)) {
                    int value = dateMap.get(dateKey) + 1;
                    dateMap.put(dateKey, value);
                } else {
                    dateMap.put(dateKey, 1);
                }
            }

        }
        Set<String> keySet = dateMap.keySet();
        String[] sorttedArray = new String[keySet.size()];
        Iterator<String> iter = keySet.iterator();
        int index = 0;
        while (iter.hasNext()) {
            String key = iter.next();
            sorttedArray[index++] = key;
        }
        int sorttedArrayLen = sorttedArray.length;
        HashMap stringHashMap = new HashMap<String,String>();
        stringHashMap.put("start",sorttedArray[0]);
        stringHashMap.put("end",sorttedArray[sorttedArrayLen - 1]);
        return stringHashMap;
    }
}
