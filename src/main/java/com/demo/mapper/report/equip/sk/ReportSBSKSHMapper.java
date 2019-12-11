package com.demo.mapper.report.equip.sk;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBSKSHMapper {

    List<Report> REPORT_SB_SK_SH_LSLC_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_SH_GLJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_SH_3M_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_SH_4M_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_SH_ZJB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

}
