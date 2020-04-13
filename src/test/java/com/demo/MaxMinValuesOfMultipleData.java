package com.demo;

import java.util.*;

/**
 * Created by Administrator on 2016/1/15.
 */
public class MaxMinValuesOfMultipleData {
    public static void main(String[] arg0) {
        String [] dateArray = {"2013-04-08 00:02:00", "2013-04-08 00:20:00", "2013-04-08 00:30:00",
                "2013-04-08 00:00:00", "2013-05-08 10:00:01",};
//        String dateArray = "2013-04-08 00:02:00"+","+"2013-04-08 00:20:00"+","+ "2013-04-08 00:30:00",
//                "2013-04-08 00:00:00", "2013-05-08 10:00:01",;
        HashMap<String, String> stringStringHashMap = MaxMinValuesOfMultipleData(dateArray);
        String max = stringStringHashMap.get("max");
        String min = stringStringHashMap.get("min");
        System.out.println(max+"=========="+min);

    }
//计算多个时间的最大最小值
    private static HashMap<String ,String> MaxMinValuesOfMultipleData(String [] dateArray) {
        Map<String, Integer> dateMap = new TreeMap<String, Integer>();
        int i, arrayLen;
        arrayLen = dateArray.length;
        for (i = 0; i < arrayLen; i++) {
            String dateKey = dateArray[i];
            if (dateMap.containsKey(dateKey)) {
                int value = dateMap.get(dateKey) + 1;
                dateMap.put(dateKey, value);
            } else {
                dateMap.put(dateKey, 1);
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
        stringHashMap.put("max",sorttedArray[0]);
        stringHashMap.put("min",sorttedArray[sorttedArrayLen - 1]);
        return stringHashMap;
    }
}