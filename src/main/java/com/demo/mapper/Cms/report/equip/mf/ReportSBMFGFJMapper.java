package com.demo.mapper.Cms.report.equip.mf;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBMFGFJMapper {



//浮选柱
    List<Report> REPORT_SB_FX_FXZ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
// 鼓风机
    List<Report> REPORT_SB_FX_GFJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
//底层泵
    List<Report> REPORT_SB_FX_DCB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
