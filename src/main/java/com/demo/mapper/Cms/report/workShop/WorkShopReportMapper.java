package com.demo.mapper.Cms.report.workShop;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface WorkShopReportMapper {
//设备点检
    List<Report> workShop_report_spot_zong_list(@Param("workshop") String workshop, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Report> workShop_report_spot_fen_list(@Param("workshop") String workshop, @Param("startTime") String startTime, @Param("endTime") String endTime);

//设备处理
    List<Report> workShop_report_deal_list(@Param("workshop") String workshop, @Param("startTime") String startTime, @Param("endTime") String endTime);



}
