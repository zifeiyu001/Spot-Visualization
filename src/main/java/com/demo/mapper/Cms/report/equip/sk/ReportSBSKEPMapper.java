package com.demo.mapper.Cms.report.equip.sk;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSBSKEPMapper {

    List<Report> REPORT_SB_SK_EP_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_SB_SK_EP_CC_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
