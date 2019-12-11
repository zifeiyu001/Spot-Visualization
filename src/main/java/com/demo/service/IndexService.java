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
    List<Interlocking> Interlocking_get_result(String deptName, String routeName, String zoneName,
                                               String devName, String scPart,String scContent,
                                               String startTime, String endTime  ,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,String wjCheck,
                                               Integer startPage,Integer numPerPage);
    List<ConfigUser> search_config_alarm_liable_all();
//    根据条件查询点检结果数量
   Integer Interlocking_get_result_total(String deptName, String routeName, String zoneName,
                                               String devName, String scPart,String scContent,
                                               String startTime, String endTime  ,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,String wjCheck
   );


    List<Maintenance> pc_get_MaintenanceResult(String deptName, String routeName, String zoneName,
                                                      String devName,
                                                      String startTime, String endTime  , String dealResult);
//    改变报警类型
    Integer Interlocking_changeAlarmType(String resultId, String alarmType, String userName,String selectDepart );

    Integer Interlocking_changeAlarmPersonLiable(String resultId,String alarm_personLiable);
    List<Interlocking> Interlocking_get_byId_result( String resultId);
    List<Interlocking> Interlocking_get_temp_result(String deptName,  String routeName, String zoneName,
                                               String devName, String scPart,String scContent,
                                                    String stdValue,String altpid );
    Integer Interlocking_update_temp_result( String deptName, String routeName, String zoneName,
                                                       String devName, String scPart, String scContent,
                                                        String altpid,  String stdValue,
                                                        String alarmType,String userName,String selectDepart);
   Integer Interlocking_insert_temp_result( String deptName, String routeName, String zoneName,
                                                        String devName, String scPart, String scContent,
                                                        String altpid,  String stdValue,
                                                        String alarmType,String userName,String selectDepart);

    Integer Interlocking_update_alarm_result( String deptName, String routeName, String zoneName,
                                             String devName, String scPart, String scContent,
                                             String alarm_manage);
//===================app接口测试===================================
//   点检结果
    List<AppReport> App_Spot_Result(String deptName,String job,String dateTime);

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

//======================设备维修==========================

    Integer app_set_maintenance(String deptName, String routeName,String zoneName, String devName, String description, String pic, String discoverer,  String phone);



//    开关量数据获取
//    获取当前时间段的开关量数据
    List<AppDCS> app_jjb_getRunTime(String field, String startTime);

    //    获取当前时间段前的一个开关量
    List<AppDCS> app_jjb_getLastRunTime( String field, String startTime);
//    获取时间差值
//String app_jjb_getDifferenceHour( String meta);

//     获取设备运行时间的字段
List<AppDCS> app_jjb_getRunTimeField( String equip, String meta);

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
    Integer delete_liable_user(String department, String userId,String team);
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



}