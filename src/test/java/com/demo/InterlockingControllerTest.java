package com.demo;

import com.demo.model.app.AppLoginUser;
import com.demo.model.app.AppScheduling;
import com.demo.model.universal.DESUtil;
import com.demo.model.universal.ResultJson;
import com.demo.model.universal.StatusCode;
import com.demo.model.universal.TreeCode;
import com.demo.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.demo.model.universal.base64StrImage.base64StrToImage;
import static com.demo.model.universal.base64StrImage.imageToBase64Str;

@RestController
public class InterlockingControllerTest {
    // 首页
    @Autowired
    private IndexService indexService;
//    @RequestMapping(value = "/app/test", method = RequestMethod.GET)
//    @ResponseBody
//    public void appLoginwa() throws ParseException {
//        List<AppScheduling> appSchedulings = indexService.app_get_team_scheduling();
//        for (int a=0;a<appSchedulings.size();a++){
//            System.out.println(appSchedulings.get(a).getdTime());
//        }
//    }

    public static void main(String[] args) throws ParseException {
      DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date ago = dateTimeFormat.parse("2019-08-02 08:00:00");
        Date ago3 = dateTimeFormat.parse("2019-12-30 12:00:00");
        System.out.println((ago3.getTime()-ago.getTime())/(24*60*60*1000)%4);


        Date ago1 = dateFormat.parse("2019-08-02");
        Date ago2 = dateFormat.parse("2020-01-03");
        Date ago4 = dateFormat.parse("2018-07-29");
        System.out.println("cms:"+(ago2.getTime()-ago4.getTime())/(24*60*60*1000)%4+";========;dxj:"+(ago2.getTime()-ago1.getTime())/(24*60*60*1000)%4);



        long a=now.getTime()-ago.getTime();
//        String format1 = dateTimeFormat.format("");
//        Date date = new Date("");
        long day=a/(24*60*60*1000);
        String format = dateTimeFormat.format(now);
        String format1 = dateTimeFormat.format(ago);
        System.out.println(format+"======"+format1+"=="+a+"=="+day%4+"=="+day);
    }






}
