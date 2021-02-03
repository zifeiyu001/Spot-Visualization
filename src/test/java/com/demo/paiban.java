package com.demo;

import com.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class paiban {
    public static void main(String[] args) throws ParseException {
        /*
        * 确定当前交接班数据是否有数据
        * */

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        boolean a=true;
        /*
        * 判断当前日期，班次，班组
        * */
        int paibanNum2 = (int) getPaibanNum2(1588160802594L);
    }
    private static int getPaibanNum2(Long nowL){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //时间格式
        String startTime1="2019-07-28 20:00:00";//周期开始时间
        int days=4;//周期天数
        int teamhour=12;//每班小时数
        int cyclehour=days*24;

        Date startTime = null;
        try {
            startTime = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long h=1000*60*60;
        assert startTime != null;
        long totaltime=nowL-startTime.getTime();

        //计算总计小时数，当有小数时，取整加一
        long l = totaltime%h == 0 ? (totaltime/h):(totaltime/h)+1;
        //计算周期后所剩余小时数
        long aaa=l%cyclehour;
        //所余小时数在第几位，即为周期内排班顺序（当有小数时，取整加一）
        long m=aaa%teamhour == 0 ? (aaa/teamhour):(aaa/teamhour)+1;
        System.out.println("getPaibanNum2===="+nowL+"---"+new Long(m).intValue());
        return new Long(m).intValue();

    }

}
