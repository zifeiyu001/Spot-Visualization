package com.demo.mapper.Cms.changeShifts;


import com.demo.model.changeShifts.ChangeShiftsConfig;
import com.demo.model.changeShifts.ChangeShiftsSpot;
import com.demo.model.changeShifts.jobs.CrushLime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ChangeShiftsMapper {

    //获取人员信息
    List<ChangeShiftsConfig> getUserInfo(@Param("userId") String  userId);
    //获取班组序号的班组
    List<ChangeShiftsConfig>  getTeamNumInfo(@Param("num") Integer num);
    //获取班组班次
    List<ChangeShiftsConfig> getStationRoutesInfo(@Param("userId") String userId);

    //获取点检统计
     List<ChangeShiftsSpot> get_spot_statistics(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("deptName") String deptName,@Param("routeNames") String routeNames);

    //查询是否有数据
    List<CrushLime> get_sksh_jjbData(@Param("date") String date, @Param("deptName") String deptName,
                                     @Param("station") String station, @Param("shift") String shift);

}

