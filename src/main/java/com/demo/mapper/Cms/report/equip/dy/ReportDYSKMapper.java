package com.demo.mapper.Cms.report.equip.dy;

import com.demo.model.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ReportDYSKMapper {
//碎矿
    List<Report> REPORT_DY_SK_ZBEP_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_SK_24PD_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_SK_SHSS_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

//磨浮
    List<Report> REPORT_DY_MF_GFJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_PDZB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_3MSH_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_FXB_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_ZMJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_QMJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_BZMJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_FXJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_MF_MJ_DCS_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);


//精尾
    List<Report> REPORT_DY_JW_NMJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_JW_YLGL_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);

    List<Report> REPORT_DY_JW_KYJ_RUN_LIST(@Param("team") String team, @Param("equip") String equip, @Param("time") String time);
}
