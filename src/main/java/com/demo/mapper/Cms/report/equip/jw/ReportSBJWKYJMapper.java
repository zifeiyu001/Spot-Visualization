package com.demo.mapper.Cms.report.equip.jw;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBJWKYJMapper {

    List<Report> REPORT_SB_JW_KYJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_JW_WSB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_JW_HS_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_JW_NMJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_JW_NMJ_LXB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
