package com.demo.mapper.report.equip.mf;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBMFMJMapper {
// 泵
    List<Report> REPORT_SB_MK_MJ_ZJB_RUN_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);


//磨机
    List<Report> REPORT_SB_MK_ZMJ_RUN_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);
    List<Report> REPORT_SB_MK_QMJ_RUN_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);
    List<Report> REPORT_SB_MK_BZMJ_RUN_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);


//dcs
    List<Report> REPORT_SB_MK_ZMJ_DCS_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);
    List<Report> REPORT_SB_MK_BZMJ_DCS_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);
    List<Report> REPORT_SB_MK_QMJ_DCS_LIST(@Param("team") String team,@Param("equip") String equip,@Param("time") String time);
}
