package com.demo.mapper.Cms.report.equip;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportMapper {
//设备点检
    List<Report> REPORT_SB_SPOT_LIST(@Param("workshop") String workshop,@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//设备处理
    List<Report> REPORT_SB_DEAL_LIST(@Param("workshop") String workshop,@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);


//生产点检
    List<Report> REPORT_SC_SPOT_LIST(@Param("workshop") String workshop,@Param("team") String team, @Param("equip") String equip, @Param("time") String time,@Param("duty") String duty);

//生产处理
    List<Report> REPORT_SC_DEAL_LIST(@Param("workshop") String workshop,@Param("team") String team, @Param("equip") String equip, @Param("time") String time,@Param("duty") String duty);

}
