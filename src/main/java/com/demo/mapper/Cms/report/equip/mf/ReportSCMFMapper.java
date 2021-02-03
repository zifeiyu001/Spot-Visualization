package com.demo.mapper.Cms.report.equip.mf;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSCMFMapper {


//   皮带岗
    List<Report> REPORT_SC_MF_PDG_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//    浮选岗
    List<Report> REPORT_SC_MF_FXG_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

    List<Report> REPORT_SC_MF_FXG_2_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//    磨矿岗

    List<Report> REPORT_SC_MF_MKG_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

    List<Report> REPORT_SC_MF_MKG_2_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

}
