package com.demo.mapper.Cms.report.equip.mf;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBMFPDMapper {
    List<Report> REPORT_SB_MK_ZBPD_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
