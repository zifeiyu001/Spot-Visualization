package com.demo.mapper.report.equip.sk;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBSKPDMapper {

    List<Report> REPORT_SB_SK_PD2_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_PD4_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
