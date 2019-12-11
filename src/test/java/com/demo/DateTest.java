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
@Controller
public class DateTest {

    @Autowired
    private IndexService indexService;
    public  void getDeptName(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
/*
* 找出当日已经点检，并且为报警的数据
* 责任部门为空
* 遍历数据，当报警临时表中的多个字段相同时，将报警类型修改人、报警类别、责任部门数据 更新到点检结果表中
*
* */

        List<Interlocking> interlockings = indexService.Interlocking_get_all_alarm_byDay();
        List<Interlocking> interlockings1 = indexService.Interlocking_get_all_alarmType();
        for(Interlocking a:interlockings){
            System.out.println(a.getDeptName());
        }

    }

}