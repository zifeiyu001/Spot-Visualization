package com.demo.controller;

import com.demo.model.report.Report;
import com.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WeekReportController {
    // 首页
    @Autowired
    private IndexService indexService;


    @PostMapping("/report/week")
    @ResponseBody
    public Map<String,Object> report_mk_mj_Url(@RequestBody Map<String, String> params) throws UnsupportedEncodingException {

        String workshop = params.get("workshop");
        String team = params.get("team");
        String equip = params.get("equip");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
//        System.out.println(workshop+"==="+team+"=="+equip+"==="+startTime+"==="+endTime);
        List<Report> spotData = indexService.REPORT_WEEK_SPOT_LIST(workshop, team, equip, startTime, endTime);    // 点检统计数据
        List<Report> dealData = indexService.REPORT_WEEK_DEAL_LIST(workshop, team, equip, startTime, endTime);      //报警处理数据
        List<Report> runData = indexService.REPORT_WEEK_SK_YS_RUN_LIST(workshop, team, equip, startTime, endTime);  //设备运行情况
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("equipRun",runData);
        map.put("spotData",spotData);
        map.put("dealData",dealData);
        return map;

    }
}