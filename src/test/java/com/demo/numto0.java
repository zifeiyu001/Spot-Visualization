package com.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class numto0 {
    public static void main(String[] args) {
        String s = autoGenericCode(20, 3);
        System.out.println(s);
    }
//    public void test() {
//        this.printToConsole(autoGenericCode("10011"));
//        this.printToConsole(autoGenericCode("000",3));
//    }

    /**
     * 不够位数的在前面补0，保留code的长度位数字
     * @param code
     * @return
     */
    private String autoGenericCode(String code) {
        String result = "";
        // 保留code的位数
        result = String.format("%0" + code.length() + "d", Integer.parseInt(code) + 1);

        return result;
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    private static String autoGenericCode(int code, int num) {
        String result = "";
        result = String.format("%0" + num + "d", code + 1);

        return result;
    }
}