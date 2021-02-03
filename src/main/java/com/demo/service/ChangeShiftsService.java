package com.demo.service;
import com.demo.model.changeShifts.ChangeShiftsConfig;
import com.demo.model.changeShifts.ChangeShiftsSpot;
import com.demo.model.changeShifts.jobs.CrushLime;
import com.demo.model.changeShifts.jobs.CrushLimeExample;

import java.util.List;


public interface ChangeShiftsService {

    //获取人员信息
    List<ChangeShiftsConfig>  getUserInfo(String userId);
    //获取班组序号的班组
    List<ChangeShiftsConfig>  getTeamNumInfo(Integer num);

    //获取班组班次
    List<ChangeShiftsConfig>  getStationRoutesInfo(String userId);

    //获取点检统计
    List<ChangeShiftsSpot> get_spot_statistics(String startTime,String endTime,String deptName,String routeNames);
//查询是否有数据
    List<CrushLime> get_sksh_jjbData(String date,String deptName,String station,String shift);


    //碎矿石灰
//    插入数据
    Integer crushLimeinsertSelective(CrushLime crushLime);
//    查询数据
    List<CrushLime> crushLimeSelectByExample(CrushLime crushLime);
//    更新数据
    Integer updateByExample(CrushLime crushLime);

}