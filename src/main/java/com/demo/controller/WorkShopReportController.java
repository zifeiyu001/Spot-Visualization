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
public class WorkShopReportController {
    // 首页
    @Autowired
    private IndexService indexService;


    @PostMapping("/workShopReport/day")
    @ResponseBody
    public Map<String,Object> report_mk_mj_Url(@RequestBody Map<String, String> params) throws UnsupportedEncodingException {
        System.out.println(params);
        String workshop = params.get("workshop");
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
//        System.out.println(workshop+"=="+startTime+"====="+endTime);
        List<Report> spotData = indexService.workShop_report_spot_zong_list(workshop, startTime,endTime);    // 点检统计数据（总数）
        List<Report> spotData1 = indexService.workShop_report_spot_fen_list(workshop, startTime,endTime);     // 点检统计数据  （各工段总数）
        spotData.addAll(spotData1);
        List<Report> dealData = indexService.workShop_report_deal_list(workshop,  startTime,endTime);      //报警处理数据
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");

        map.put("spotData",spotData);
        map.put("dealData",dealData);
        return map;

    }
}