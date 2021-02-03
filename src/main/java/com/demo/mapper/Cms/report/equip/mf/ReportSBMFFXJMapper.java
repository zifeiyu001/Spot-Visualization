package com.demo.mapper.Cms.report.equip.mf;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBMFFXJMapper {


//    浮选机
    List<Report> REPORT_SB_FX_FXJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
//    浮选搅拌桶
    List<Report> REPORT_SB_FX_JBT_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
