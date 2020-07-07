package com.demo.service;

import com.demo.model.app.*;
import com.demo.model.equip.DefectTreatment;
import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.equip.detailedData;
import com.demo.model.index.IndexFlowChartData;
import com.demo.model.index.IndexShow;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.process.grindingFloat.*;
import com.demo.model.report.Report;
import com.demo.model.universal.*;

import java.util.List;

/**

 */

public interface IndexService {

/*=========================index页面======================*/
    List<SpotStatistics> INDEX_SC_LIST(String param);
    List<SpotStatistics> INDEX_DY_LIST(String param);
    List<SpotStatistics> INDEX_SB_LIST(String param);
    List<SpotStatistics> getMonthlysSotStatistics();

    List<IndexShow>  INDEX_SHOW_LIST();
    List<IndexShow>  INDEX_SHOW1_LIST();
    List<IndexFlowChartData> INDEX_FLOW_CHART_DATA_LIST();
    List<IndexFlowChartData>  INDEX_FLOW_CHART_DATA2_LIST();
    List<SpotAlarm>  INDEX_ALARM_LIST(String param);
    Integer CURRENCY_ALARM_UPDATE(String name,String id,String remark);

    /*报警处理*/
    LoginUser get_login_name(String name);
    List<WebDxjBj> search_alarm_id(String id);
//========================磨浮工艺=============================

    List<MF1Production> MF_1_PRODUCTION_LIST();
    List<SpotStatistics> MF_1_SPOT_LIST();
    List<SBMKDefectTreatment> MF_1_DEFECT_TREATMENT_LIST();
    List<SpotAlarm> MF_1_ALARM_LIST();
    List<SpotStatistics> MK_1_BALL_STATISTICS_LIST();


//========================浮选===================================
    /*浮选点检统计*/
    List<SpotStatistics> FX_1_SPOT_LIST();
    /*浮选缺陷统计*/
    List<DefectTreatment> FX_1_DefectTreatment_LIST();
    List<SpotAlarm> FX_1_ALARM_LIST();
    List<IndexFlowChartData> FX_1_PV_LIST();

 //====================鼓风机=========================
    List<SpotAlarm> FX_GFJ_1_ALARM_LIST();
    List<SpotAlarm> FX_GFJ_2_ALARM_LIST();
    List<SpotAlarm> FX_GFJ_3_ALARM_LIST();
    List<SpotStatistics> FX_GFJ1_SPOT_LIST();
    List<SpotStatistics> FX_GFJ2_SPOT_LIST();
    List<SpotStatistics> FX_GFJ3_SPOT_LIST();
    List<detailedData> SPOT_GFJ1_MK_LIST();
    List<detailedData> SPOT_GFJ1_DY_LIST();
    List<detailedData> SPOT_GFJ1_SC_LIST();
    List<detailedData> SPOT_GFJ2_MK_LIST();
    List<detailedData> SPOT_GFJ2_DY_LIST();
    List<detailedData> SPOT_GFJ2_SC_LIST();
    List<detailedData> SPOT_GFJ3_MK_LIST();
    List<detailedData> SPOT_GFJ3_DY_LIST();
    List<detailedData> SPOT_GFJ3_SC_LIST();
    //====================浮选机=========================
    List<SpotAlarm> ALARM_FX_FXJ_LIST(String equip);
    List<SpotStatistics> SPOT_FXJ_LIST(String equip);
    List<detailedData> SPOT_FX_FXJ_SB_LIST(String equip);
    List<detailedData> SPOT_FX_FXJ_SC_LIST(String equip);
    List<detailedData> SPOT_FX_FXJ_DY_LIST(String equip);
    List<detailedData> SPOT_FX_FXJ2_SB_LIST(String equip);

//========================脱泥旋流器=======================

    List<SpotAlarm> ALARM_FX_XLQ_LIST();
    List<SpotStatistics> SPOT_FX_XLQ_LIST();
    List<detailedData> SPOT_FX_XLQ_SB_LIST();
    List<detailedData> SPOT_FX_XLQ_SC_LIST();

    //====================浮选搅拌桶=========================
    List<SpotAlarm> ALARM_FX_JBT_LIST(String equip);
    List<SpotStatistics> SPOT_JBT_LIST(String equip);
    List<detailedData> SPOT_FX_JBT_SB_LIST(String equip);
    List<detailedData> SPOT_FX_JBT_SC_LIST(String equip);
    List<detailedData> SPOT_FX_JBT_DY_LIST(String equip);



//===========================给矿分级============================
    List<SpotAlarm> MK_PD_ALARM_LIST();
    List<SpotAlarm> MK_ZB_ALARM_LIST();
    List<SpotAlarm> MK_XLQ_ALARM_LIST();
    List<SpotStatistics> SPOT_MK_PD_LIST();
    List<SpotStatistics> SPOT_MK_ZB_LIST();
    List<SpotStatistics> SPOT_MK_XLQ_LIST();
    List<detailedData> SPOT_GKFJ_MK_DETAILED_PD_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_PD_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_PD_LIST();
    List<detailedData> SPOT_GKFJ_MK_DETAILED_ZB_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_ZB_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_ZB_LIST();
    List<detailedData> SPOT_GKFJ_MK_DETAILED_XLQ_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_XLQ_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_XLQ_LIST();


/*=============================半自磨机=========================*/
    List<SpotStatistics> SPOT_BZMJ_LIST();
    List<detailedData> SPOT_MK_BZMJ_MF_LIST();
    List<detailedData> SPOT_MK_BZMJ_SC_LIST();
    List<detailedData> SPOT_MK_BZMJ_DY_LIST();
    List<SpotAlarm> ALARM_ZBMJ_LIST();


/*============================球磨机==============================*/
    List<SpotStatistics> SPOT_QMJ_LIST();
    List<detailedData> SPOT_MK_QMJ_MK_LIST();
    List<detailedData> SPOT_MK_QMJ_DY_LIST();
    List<detailedData> SPOT_MK_QMJ_SC_LIST();
    List<SpotAlarm> ALARM_QMJ_LIST();
// 磨矿设备点检数据详情
    List<SpotAlarm> SPOT_MK_QMJ_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_MK_ZMJ_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_MK_BZMJ_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_MK_ZB_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_MK_XLQ_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_MK_PD_DETAILED_LIST(String param);
// 浮选设备点检数据详情
    List<SpotAlarm> SPOT_FX_GFJ1_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_FX_GFJ2_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_FX_GFJ3_DETAILED_LIST(String param);

    List<SpotAlarm> SPOT_FX_FXJ1_DETAILED_LIST(String param ,String equip);
    List<SpotAlarm> SPOT_FX_FXJ2_DETAILED_LIST(String param ,String equip);
    List<SpotAlarm> SPOT_FX_XLQ_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_FX_JBT_DETAILED_LIST(String param ,String equip);

// 碎矿设备点检数据详情
    List<SpotAlarm> SPOT_SK_EP_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_SK_ZB_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_SK_PD2_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_SK_PD4_DETAILED_LIST(String param);
// 浓缩设备点检数据详情
    List<SpotAlarm> SPOT_NS_TNM_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_NS_LNM_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_NS_WNM_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_NS_SGNM_DETAILED_LIST(String param);
// 脱水设备点检数据详情
    List<SpotAlarm> SPOT_TS_GLJ1_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_TS_GLJ2_DETAILED_LIST(String param);
    List<SpotAlarm> SPOT_TS_YLJ3_DETAILED_LIST(String param);

/*=============================再磨机===========================*/
    List<SpotStatistics> SPOT_ZMJ_LIST();
    List<detailedData> SPOT_MK_ZMJ_MK_LIST();
    List<detailedData> SPOT_MK_ZMJ_SC_LIST();
    List<detailedData> SPOT_MK_ZMJ_DY_LIST();
    List<SpotAlarm> ALARM_ZMJ_LIST();


//===============碎矿===================================

    List<SpotAlarm> SK_1_ALARM_LIST();
    List<SpotStatistics> SK_1_SPOT_LIST();
    List<DefectTreatment> SK_DEFECT_TREATMENT_LIST();

//==========================重板========================
    List<SpotStatistics> SPOT_SK_ZB_LIST();
    List<SpotAlarm> SK_ZB_ALARM_LIST();
    List<detailedData> SK_ZB_SB_Detailed_LIST();
    List<detailedData> SK_ZB_DY_Detailed_LIST();
    List<detailedData> SK_ZB_SC_Detailed_LIST();
//===========================颚破=======================
    List<SpotStatistics> SPOT_SK_EP_LIST();
    List<SpotAlarm> SK_EP_ALARM_LIST();
    List<detailedData> SK_EP_SB_Detailed_LIST();
    List<detailedData> SK_EP_DY_Detailed_LIST();
    List<detailedData> SK_EP_SC_Detailed_LIST();

//==========================2#皮带=======================
    List<SpotStatistics> SPOT_SK_PD2_LIST();
    List<SpotAlarm> SK_PD2_ALARM_LIST();
    List<detailedData> SK_PD2_SB_Detailed_LIST();
    List<detailedData> SK_PD2_DY_Detailed_LIST();
    List<detailedData> SK_PD2_SC_Detailed_LIST();

//===========================4#皮带====================
    List<SpotStatistics> SPOT_SK_PD4_LIST();
    List<SpotAlarm> SK_PD4_ALARM_LIST();
    List<detailedData> SK_PD4_SB_Detailed_LIST();
    List<detailedData> SK_PD4_DY_Detailed_LIST();
    List<detailedData> SK_PD4_SC_Detailed_LIST();



//==================浓缩工艺=================================
    List<SpotAlarm> NS_1_ALARM_LIST();
    List<SpotStatistics> NS_1_SPOT_LIST();
    List<DefectTreatment> NS_DEFECT_TREATMENT_LIST();
    List<IndexFlowChartData> NS_1_NDLL_LIST();
// ============================铜浓密=======================
    List<SpotStatistics> SPOT_NS_TNM_LIST();
    List<SpotAlarm> NS_TNM_ALARM_LIST();
    List<detailedData> NS_TNM_SB_Detailed_LIST();
    List<detailedData> NS_TNM_DY_Detailed_LIST();
    List<detailedData> NS_TNM_SC_Detailed_LIST();
// ============================尾矿浓密====================
    List<SpotStatistics> SPOT_NS_WNM_LIST();
    List<SpotAlarm> NS_WNM_ALARM_LIST();
    List<detailedData> NS_WNM_SB_Detailed_LIST();
    List<detailedData> NS_WNM_DY_Detailed_LIST();
    List<detailedData> NS_WNM_SC_Detailed_LIST();
// =============================硫浓密============================
    List<SpotStatistics> SPOT_NS_LNM_LIST();
    List<SpotAlarm> NS_LNM_ALARM_LIST();
    List<detailedData> NS_LNM_SB_Detailed_LIST();
    List<detailedData> NS_LNM_DY_Detailed_LIST();
    List<detailedData> NS_LNM_SC_Detailed_LIST();
//==============================事故浓密=====================
    List<SpotStatistics> SPOT_NS_SGNM_LIST();
    List<SpotAlarm> NS_SGNM_ALARM_LIST();
    List<detailedData> NS_SGNM_SB_Detailed_LIST();
    List<detailedData> NS_SGNM_DY_Detailed_LIST();
    List<detailedData> NS_SGNM_SC_Detailed_LIST();



//===================脱水工艺======================================
    List<SpotAlarm> TS_1_ALARM_LIST();
    List<SpotStatistics> TS_1_SPOT_LIST();
    List<DefectTreatment> TS_DEFECT_TREATMENT_LIST();

//=================================3#压滤机=============================
    List<SpotStatistics> SPOT_TS_YLJ3_LIST();
    List<SpotAlarm> TS_YLJ3_ALARM_LIST();
    List<detailedData> TS_YLJ3_SB_Detailed_LIST();
    List<detailedData> TS_YLJ3_DY_Detailed_LIST();
    List<detailedData> TS_YLJ3_SC_Detailed_LIST();

// =============================1#过滤机===================================
    List<SpotStatistics> SPOT_TS_GLJ1_LIST();
    List<SpotAlarm> TS_GLJ1_ALARM_LIST();
    List<detailedData> TS_GLJ1_SB_Detailed_LIST();
    List<detailedData> TS_GLJ1_DY_Detailed_LIST();
    List<detailedData> TS_GLJ1_SC_Detailed_LIST();

//==================================2#过滤机=============================
    List<SpotStatistics> SPOT_TS_GLJ2_LIST();
    List<SpotAlarm> TS_GLJ2_ALARM_LIST();
    List<detailedData> TS_GLJ2_SB_Detailed_LIST();
    List<detailedData> TS_GLJ2_DY_Detailed_LIST();
    List<detailedData> TS_GLJ2_SC_Detailed_LIST();




/*=======================报表页面===============================================*/
    List<Report> REPORT_SB_SPOT_LIST(String workshop,String team,String equip,String time,String duty);
    List<Report> REPORT_SB_DEAL_LIST(String workshop,String team,String equip,String time,String duty);
    List<Report> REPORT_SC_SPOT_LIST(String workshop,String team,String duty,String equip,String time);
    List<Report> REPORT_SC_DEAL_LIST(String workshop,String team,String duty,String equip,String time);



//===============磨浮=================================

    // =========================磨浮设备中板皮带========================
    List<Report> REPORT_SB_MK_ZBPD_RUN_LIST(String team,String equip,String time);

    //======================== 磨浮设备磨机DCS===========================
    List<Report> REPORT_SB_MK_QMJ_DCS_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_MK_ZMJ_DCS_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_MK_BZMJ_DCS_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_MJ_DCS_RUN_LIST(String team,String equip,String time);
    // ===============================泵======================
    List<Report> REPORT_SB_MK_MJ_ZJB_RUN_LIST(String team,String equip,String time);

    //===============================磨机======================
    List<Report> REPORT_SB_MK_ZMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_MK_QMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_MK_BZMJ_RUN_LIST(String team,String equip,String time);

    //==========================磨浮浮选机、搅拌桶=================
    List<Report> REPORT_SB_FX_JBT_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_FX_FXJ_RUN_LIST(String team,String equip,String time);

    //==========================磨浮鼓风机、浮选柱====================
    List<Report> REPORT_SB_FX_FXZ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_FX_GFJ_RUN_LIST(String team,String equip,String time);

    //==========================磨浮浮选底层泵==========================
    List<Report> REPORT_SB_FX_DCB_RUN_LIST(String team,String equip,String time);


//================碎矿========================================
    // =========================碎矿设备重板=========================
    List<Report> REPORT_SB_SK_ZB_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_ZB_PD1_RUN_LIST(String team,String equip,String time);

    // ==========================碎矿设备颚破=========================
    List<Report> REPORT_SB_SK_EP_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_EP_CC_RUN_LIST(String team,String equip,String time);
    // ===========================碎矿设备皮带==========================
    List<Report> REPORT_SB_SK_PD2_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_PD4_RUN_LIST( String team,String equip,String time);
    //=========================== 碎矿设备石灰============================
    List<Report> REPORT_SB_SK_SH_LSLC_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_SH_GLJ_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_SH_3M_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_SH_4M_RUN_LIST( String team,String equip,String time);
    List<Report> REPORT_SB_SK_SH_ZJB_RUN_LIST( String team,String equip,String time);


//=================精尾=================================================

    //============================精尾设备空压机============================
    List<Report> REPORT_SB_JW_KYJ_RUN_LIST(String team,String equip,String time);

    //=============================精尾设备尾矿泵========================
    List<Report> REPORT_SB_JW_WSB_RUN_LIST(String team,String equip,String time);

    //=============================精尾设备尾矿泵========================
    List<Report> REPORT_SB_JW_HS_RUN_LIST(String team,String equip,String time);

    //==============================精尾设备浓密==========================
    List<Report> REPORT_SB_JW_NMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_SB_JW_NMJ_LXB_RUN_LIST(String team,String equip,String time);

    //===============================精尾设备压滤机=======================
    List<Report> REPORT_SB_JW_YLJ_RUN_LIST(String team,String equip,String time);

    //===============================精尾设备过滤机======================
    List<Report> REPORT_SB_JW_GLJ_RUN_LIST(String team,String equip,String time);


//==================电仪================================================


    // =================================碎矿===========================
    List<Report> REPORT_DY_SK_ZBEP_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_SK_24PD_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_SK_SHSS_RUN_LIST(String team,String equip,String time);
     // =================================磨浮==============================
    List<Report> REPORT_DY_MF_GFJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_PDZB_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_3MSH_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_FXB_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_QMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_ZMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_BZMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_MF_FXJ_RUN_LIST(String team,String equip,String time);
    // ===================================精尾=============================
    List<Report> REPORT_DY_JW_NMJ_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_JW_YLGL_RUN_LIST(String team,String equip,String time);
    List<Report> REPORT_DY_JW_KYJ_RUN_LIST(String team,String equip,String time);

//    =============生产报表=================================

    //=================================磨浮生产皮带==============================
    List<Report> REPORT_SC_MF_PDG_RUN_LIST(String team,String equip,String time,String duty);
    //==================================磨浮生产浮选===============================
    List<Report> REPORT_SC_MF_FXG_1_RUN_LIST(String team,String equip,String time,String duty);
    List<Report> REPORT_SC_MF_FXG_2_RUN_LIST(String team,String equip,String time,String duty);
    //==================================磨浮生产磨矿==============================
    List<Report> REPORT_SC_MF_MKG_1_RUN_LIST(String team,String equip,String time,String duty);
    List<Report> REPORT_SC_MF_MKG_2_RUN_LIST(String team,String equip,String time,String duty);

    //==================================碎矿生产破碎===================================
    List<Report> REPORT_SC_SK_PSG_RUN_LIST(String team,String equip,String time,String duty);

    //==================================碎矿生产石灰===================================
    List<Report> REPORT_SC_SK_SHG_RUN_LIST(String team,String equip,String time,String duty);

    //==================================碎矿生产石灰===================================
    List<Report> REPORT_SC_SK_PDG_RUN_LIST(String team,String equip,String time,String duty);

    //==================================精尾生产回水======================================
    List<Report> REPORT_SC_JW_HSG_1_RUN_LIST(String team,String equip,String time,String duty);

    //==================================精尾生产压滤机====================================
    List<Report> REPORT_SC_JW_YLJ_1_RUN_LIST(String team,String equip,String time,String duty);

    //===================================精尾生产过滤机=======================================
    List<Report> REPORT_SC_JW_GLJ_1_RUN_LIST(String team,String equip,String time,String duty);

     //==================================精尾生产空压机========================================
    List<Report> REPORT_SC_JW_KYJ_1_RUN_LIST(String team,String equip,String time,String duty);

    //====================================精尾生产尾砂泵========================================
    List<Report> REPORT_SC_JW_WSB_1_RUN_LIST(String team,String equip,String time,String duty);


//===================周期报表===========================================
    List<Report> REPORT_WEEK_SPOT_LIST(String workShop,String team,String equip,String startTime,String endTime);
    List<Report> REPORT_WEEK_SK_YS_RUN_LIST(String workShop,String team,String equip,String startTime,String endTime);
    List<Report> REPORT_WEEK_DEAL_LIST(String workShop,String team,String equip,String startTime,String endTime);


    //设备点检
    List<Report> workShop_report_spot_zong_list(String workshop, String startTime,String endTime);
    List<Report> workShop_report_spot_fen_list(String workshop, String startTime,String endTime);
    //设备处理
    List<Report> workShop_report_deal_list(String workshop,String startTime,String endTime);

//============================查询点检结果，多级联锁==============================
    List<Interlocking> Interlocking_get_deptName();
    List<Interlocking> Interlocking_get_routeName();
    List<Interlocking> Interlocking_get_zoneName();
    List<Interlocking> Interlocking_get_devName();
    List<Interlocking> Interlocking_get_scPart();
    List<Interlocking> Interlocking_get_content();
//    根据条件查询点检结果
    List<Interlocking> Interlocking_get_result(String deptName, String routeName, String zoneName, String devName, String scPart,String scContent,
                                               String startTime, String endTime  ,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,
                                               String wjCheck, Integer startPage,Integer numPerPage,String dealStatus);
    //    根据条件查询点检结果test
    List<Interlocking> Interlocking_get_result1(String deptName, String routeName, String zoneName,
                                               String devName, String scPart,String scContent,
                                               String startTime, String endTime  ,String yjCheck,String wjCheck,String zcCheck,String bjCheck,
                                                String abjType1,String abjType2,String abjType3,String sbjType1,String sbjType2,String sbjType3,
                                               Integer startPage,Integer numPerPage);
    List<ConfigUser> search_config_alarm_liable_all();
//    根据条件查询点检结果数量
   Integer Interlocking_get_result_total(String deptName, String routeName, String zoneName,String devName, String scPart,String scContent,String startTime,
                                         String endTime ,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,String wjCheck,String dealStatus
   );
    //    根据条件查询点检结果数量test
    Integer Interlocking_get_result_total1(String deptName, String routeName, String zoneName,
                                          String devName, String scPart,String scContent,
                                          String startTime, String endTime ,String yjCheck,String wjCheck,String zcCheck,String bjCheck,
                                           String abjType1,String abjType2,String abjType3,String sbjType1,String sbjType2,String sbjType3
    );



    List<Maintenance> pc_get_MaintenanceResult(String deptName, String routeName, String zoneName,
                                                      String devName,
                                                      String startTime, String endTime  , String dealResult);
//    改变报警类型
    Integer Interlocking_changeAlarmType(String resultId, String alarmType, String operationName,String selectDepart ,String responsibleUser);

    Integer Interlocking_changeAlarmPersonLiable(String resultId,String alarm_personLiable);
    List<Interlocking> Interlocking_get_byId_result( String resultId);//获取resultid下的内容

//  查询alarmResult表中是否有相同数据
    List<Interlocking> searchAlarmResultDataByInfo(String deptName,String routeName,String zoneName,String devName,String scPart,String scContent,String remark,String alarmType);

//  数据合并，增加次数
    Integer updateAlarmResultTimes(String alarmId,String alarmTimes,String depart,String user,String alarmType,String startDate,String endDate,String resultIds);

//向alarm_result 添加数据(原无数据)
    Integer insertBCAlarmDataToAlarmResult(String resultId,String deptName,String routeName,String zoneName,String devName,String scPart,String scContent,String remark,
                                           String spotResult,String userName1,String uploadResultTime,String selectDepart,String alarmType,String user);
//向alarm_result 添加数据(原有数据)
    Integer insertBCAlarmDataToAlarmResult1(String resultId,String deptName,String routeName,String zoneName,String devName,String scPart,String scContent,String remark,
                                            String spotResult,String userName1,String uploadResultTime,String selectDepart,String alarmType,String user,String pid);

    List<Interlocking> Interlocking_get_temp_result(String deptName,  String routeName, String zoneName,
                                               String devName, String scPart,String scContent, String altpid );
    Integer Interlocking_update_temp_result( String deptName, String routeName, String zoneName,
                                                       String devName, String scPart, String scContent,
                                                        String altpid,
                                                        String alarmType,String dealPersonLiable,String selectDepart);
   Integer Interlocking_insert_temp_result( String deptName, String routeName, String zoneName,
                                                        String devName, String scPart, String scContent,
                                                        String altpid,
                                                        String alarmType,String dealPersonLiable,String selectDepart);

    Integer Interlocking_update_alarm_result( String deptName, String routeName, String zoneName,
                                             String devName, String scPart, String scContent,
                                             String alarm_manage,String alarm_type);

    Integer Interlocking_update_alarm_liable(String resultId,String liable);

    //   根据用户id查询所在工段
    List<Interlocking> search_dxj_dept_id(String userId);

//    根据resultID查询报警处理内容
    List<AlarmDealData> get_alarm_deal_data(String resultId);
//    根据条件查询报警处理内容
    List<AlarmDealData> get_repair_data(String dateStart,String dateEnd,String depart,String technology);

//    根据resultID查询报警处理单自动填写内容
    List<AlarmDealData> getWriteDefaultDealData(String resultID);
//    获取bc类报警数据
    List<Interlocking> getbcAlarmData(String start_date,String end_date,String deptName,String alarm_type);
//    添加数据到月度报警清单
   Integer addAlarmToMonthlyList(String mergeId);
//    获取月度报警清单
    List<Interlocking> getbcMonthlyAlarmListData(String deptName);
//    处理BC类报警
    Integer dealBCAlarm(String alarmId,String dealRemark,String user);
//    延期bc类报警
    Integer delayBCAlarm(String alarmIds,String dealRemark);
//    修改bc报警类型
    Integer changeBCAlarmType(String alarmIds,String resultIds, String deptName,String alarmType,String personLiable);


    /*手动合并报警数据*/
//    获取合并项中报警数量
    Integer mergeBCAlarmNum(String alarmId, String mergeIds);
//    合并报警数据
     Integer mergeBCAlarmData(String alarmId,String resultIds,String times,String startTime,String endTime);
//    删除合并报警其他数据
    Integer updateDeleteAlarmData(String alarmId, String mergeIds);
//    更新合并报警后数据
    Integer updateAlarmData(String alarmId, String deleteAlarmNum);

//    获取处理BC类报警内容
        List<Interlocking> getbcAlarmContent(String alarmId);
//     获取处理alarm表中id的resultId
    List<Interlocking> getbcAlarmDataResultId(String alarmIds);
//    根据resultId处理result表中BC类报警
     Integer dealBCAlarmInResult(String resultId,String dealRemark,String user);
//        获取报警处理责任人
        List<ConfigUser> getPersonLiableByDepart(String alarm_after_Type,String departs);
//        修改BC类报警类型
        Integer updateResultChangeAlarmTypeByDetailed(String deptName,String routeName,String zoneName,String devName,
                                                             String scPart,String scContent,String uploadResultTime,String user,String departs,String alarmType);
//      处理result表中BC报警
    Integer updateResultDealDataByDetailed(String deptName,String routeName,String zoneName,String devName,String scPart,String scContent,String uploadResultTime,String user);
//    报警处理单填写内容
        Integer writeDealData(String result_id,String service_id,String dev_code,String service_start_date,String service_end_date,
        String service_hours,String dev_name,String dev_model,String dev_dept,String dev_category,String service_unit_type,
        String service_unit,String alarm_type,String alarm_name,String alarm_time,String alarm_content,
        String service_name,String service_acceptor,String service_content,String service_alarm_time,String service_remarks);
//       修改报警处理单内容

    Integer updateDealData(String result_id,String service_id,String service_start_date,String service_end_date,
                           String service_hours,String service_unit_type, String service_unit,
                           String service_name,String service_acceptor,String service_content,String service_alarm_time,String service_remarks);

//根据resultID报警处理result表
    Integer updateResultDealData(String result_id,String alarm_flag, String alarm_remark, String alarm_manage_name, String alarm_manage_time);

////根据工段、、、、设备、部位等 报警处理result表
//    Integer updateResultDealDataByDetailed(String result_id,String alarm_flag, String alarm_remark, String alarm_manage_name, String alarm_manage_time);

//     获取报警处理单当天的数量
    List<AlarmDealData> getDeptSameDayDealData(String dev_name);

//    获取是否有处理报警的权限
    List<ConfigUser> getAlarmDealJurisdiction(String dev_depart,String userid,String alarm_type);

//获取BC类报警的所有数据
    List<Interlocking> getBCData(String start,String end,String deptName,String alarmType,String state);
    List<Interlocking> getBCMergeData(String start,String end,String deptName,String alarmType,String state);

//===================app接口测试===================================
//   点检结果
    List<AppReport> App_Spot_Result(String deptName,String job,String startTime,String endTime);

//   点检结果
    List<Interlocking> app_get_dxjSearchResult(String deptName,String route,String zone,String startTime,String endTime );
//    登录
    List<AppLoginUser> app_user_login(String userName,String cycleContentDate);
//    app登录
    List<AppLoginUser> app_user_login1(String userName, String passWord);
    List<AppLoginUser> app_user_getjjbID(String deptName, String job);
//    获取交接班周期
    List<AppCycle>  app_user_getCycle(String userName);
//    获取磨矿岗dcs数据
    List<AppDCS> app_jjb_dcs_mk(String mj,String metaStartTime,String metaEndTime);
//    交接班数据填写
    Integer app_jjb_write(String dateTime, String job, String jjbTagName, String jjbValue);
//    获取巡检数据
    List<AppDemandWriteData> app_jjb_getspotWrite(String job,String equip, String metaStartTime,String metaEndTime,Integer meta);
//    获取交接班需填写数据
    List<AppDemandWriteData> app_jjb_getDemandWrite(String job,String equip);
//    获取手动填写需检查的内容
    List<AppDemandWriteData> app_jjb_getemandSpotWrite(String job,String equip,String meta);

//   查询字段是否存在
    List<AppDemandWriteData> app_jjb_getWriteData(String field,String metaStartTime);
//   查询字段存在后更新
    Boolean app_jjb_updateWriteData( String field,String value, String metaStartTime);

//    获取交接班数据填写
    List<AppDemandWriteData> app_jjb_getWrite(String job,String equip);
//    交班内容填写
    Integer app_shift_duty_handover(String dataTime,String id, String deptName, String job, String handoverTeam, String handoverDuty, String handoverName, String handoverContent);
//    获取下个班人员信息
    List<AppLoginUser> app_jjb_getNextUser(String date, String job, String meta);
//   接班内容填写
    Integer app_shift_duty_succession(String dataTime, String id, String succeedTeam, String succeedDuty, String succeedName, String succeedContent);
//获取岗位路线
    List<AppReport> app_get_jjb_deptRoute(String deptName, String job);














    //        -------------------APP 人员配置---------------
//    岗位线路配置的增、删、改、查
    Integer  app_config_set_station(String deptName,  String station, String routeName);
    Integer  app_config_update_station(String deptName,  String station, String routeName);
    Integer  app_config_delete_station(String deptName,  String station, String routeName);
    List<APPUserConfig>  app_config_select_station(String deptName,  String station, String routeName);
    List<APPUserConfig>   app_config_getJob_user(String deptName);
//  岗位人员的增、删、改、查
    Integer  app_config_set_station_user(String deptName,  String station, String team,String userName,String userId);
    Integer  app_config_update_station_user(String deptName,  String station, String team,String userName,String userId);
    Integer  app_config_delete_station_user(String deptName,  String station, String team,String userId);
    List<APPUserConfig>  app_config_select_station_user(String deptName,  String station, String team,String userId);
//    排班时间班组获取
    List<AppScheduling> app_get_team_scheduling();
//    获取进入人员的班组等信息
    List<APPUserConfig> app_get_jjb_team_byUserId(String userId);



//======================设备维修==========================

    Integer app_set_maintenance(String deptName, String routeName,String zoneName, String devName, String description, String pic, String discoverer,  String phone);



//    开关量数据获取
//    获取当前时间段的开关量数据
    List<AppDCS> app_jjb_getRunTime(String field, String startTime,String endTime);

    //    获取当前时间段前的一个开关量
    List<AppDCS> app_jjb_getLastRunTime( String field, String startTime);
//    获取时间差值
//String app_jjb_getDifferenceHour( String meta);

//     获取设备运行时间的字段
List<AppDCS> app_jjb_getRunTimeField( String equip);

    List<ConfigUser> get_dept_list();
    List<TreeCode> get_dept_test_list();


//======配置页面=======================================
//获取
    List<ConfigUser> get_dept_user_list();
    List<ConfigUser> get_dept_user_ll_list(String equipId);

//    责任人配置
    // 存储人员管理部门数据
    Integer set_config_partment_user(String deptName, String deptId,String user,String userId, String department,String alarmType,String team);
    // 判断当前人员是否有管理部门
    List<ConfigUser> search_config_partment_user( String userId,String alarmType,String team);
    // 判断当前人员已有管理部门，对其更新
    Integer update_config_partment_user(String deptName,String deptId, String user,String userId,String department,String alarmType,String team);
    List<ConfigUser> search_config_liable_user( String workshopId);
//    删除管理的报警类型
    Integer delete_liable_user(String department, String userId,String alarmType);
//  管理人员配置
    // 判断是否存在
    List<ConfigUser> search_config_alarm_manage( String userId);
    // 不存在 保存
    Integer set_config_alarm_manage(String deptName, String deptId,String user,String userId,String manageDepart);
    // 存在 更新
    Integer update_config_alarm_manage(String deptName,String deptId, String user,String userId,String manageDepart);
    //查询所有
    List<ConfigUser> search_config_alarm_manage_exist();
//    查找人员是否是管理员
    List<ConfigUser> search_config_alarm_manage_user( String userName,String part);
    Integer delete_user(String userId);

//    ==================自动执行报警类型设定
    List<Interlocking> Interlocking_get_all_alarm_byDay();
    List<Interlocking> Interlocking_get_all_alarmType();


//    查询登录人员权限
    List<Interlocking> search_config_userChange_permission(String userId);
//通过alarmid获取resultid
    List<Interlocking> get_resultId_alarmid(String alarmId);
//   删除alarmResult数据
    Integer delete_alarm_result_by_alarmId(String alarmId);



//    获取配置参数
    List<Config> getConfigData();

    Integer setConfigData(String alarm_list_start,String alarm_list_end,String alarm_c_deal_start,String alarm_c_deal_end,String alarm_tips_time);


}