package com.demo.mapper.Cms.report.equip.jw;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportSCJWMapper {


//  回水岗
    List<Report> REPORT_SC_JW_HSG_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//   压滤机岗
    List<Report> REPORT_SC_JW_YLJ_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//   过滤机岗
    List<Report> REPORT_SC_JW_GLJ_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//   空压机岗
    List<Report> REPORT_SC_JW_KYJ_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

//   尾砂泵岗
    List<Report> REPORT_SC_JW_WSB_1_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time, @Param("duty") String duty);

}
