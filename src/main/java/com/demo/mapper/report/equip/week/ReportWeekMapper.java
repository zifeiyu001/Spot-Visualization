package com.demo.mapper.report.equip.week;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportWeekMapper {
//设备点检
    List<Report> REPORT_WEEK_SPOT_LIST(@Param("workshop") String workShop, @Param("team") String team, @Param("equip") String equip, @Param("startTime") String startTime, @Param("endTime") String endTime);

//运行

    List<Report> REPORT_WEEK_SK_YS_RUN_LIST(@Param("workshop") String workShop, @Param("team") String team, @Param("equip") String equip, @Param("startTime") String startTime, @Param("endTime") String endTime);


    //设备处理
    List<Report> REPORT_WEEK_DEAL_LIST(@Param("workshop") String workShop, @Param("team") String team, @Param("equip") String equip, @Param("startTime") String startTime, @Param("endTime") String endTime);



}
