package com.demo.mapper.report.equip.sk;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSCSKMapper {


//   破碎岗
    List<Report> REPORT_SC_SK_PSG_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//    石灰制乳岗
    List<Report> REPORT_SC_SK_SHG_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);
//   皮带岗
    List<Report> REPORT_SC_SK_PDG_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);


}
