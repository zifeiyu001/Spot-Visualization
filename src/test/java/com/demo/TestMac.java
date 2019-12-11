package com.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class TestMac {

    public static void main(String[] args) {
        Map map = new HashMap();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("a", "b");
        map.put("msg", hashMap);//map里面装有yes
        map.put("msg1", "yes");//map里面装有yes
        map.put("msg2", "yes");//map里面装有yes
        Object o = JSONObject.toJSON(map);

        System.out.println("输出的结果是：" + o+"=="+hashMap);
        //3、将json对象转化为json字符串
//        String result = jsonObject.toString();?
        String s = o.toString();
        System.out.println(s);
    }

}