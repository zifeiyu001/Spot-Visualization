package com.demo.service.Impl;
import com.demo.mapper.app.AppMapper;
import com.demo.mapper.equip.*;
import com.demo.mapper.equip.fxj.SpotFxFxjMapper;
import com.demo.mapper.equip.fxj.SpotFxJbtMapper;
import com.demo.mapper.equip.fxj.SpotFxXlqMapper;
import com.demo.mapper.equip.mk.bzmj.*;
import com.demo.mapper.equip.gfj.*;
import com.demo.mapper.equip.mk.gkfj.*;
import com.demo.mapper.equip.mk.gkfj.AlarmGkfjMapper;
import com.demo.mapper.equip.mk.pd.SpotGkfjDetailedPDMapper;
import com.demo.mapper.equip.mk.qmj.SpotQmjDetailedMapper;
import com.demo.mapper.equip.mk.zmj.SpotZmjDetailedMapper;
import com.demo.mapper.equip.ns.lnm.AlarmNSLNMMapper;
import com.demo.mapper.equip.ns.lnm.SpotNSLNMDetailedMapper;
import com.demo.mapper.equip.ns.lnm.SpotNSLNMMapper;
import com.demo.mapper.equip.ns.sgnm.AlarmNSSGNMMapper;
import com.demo.mapper.equip.ns.sgnm.SpotNSSGNMDetailedMapper;
import com.demo.mapper.equip.ns.sgnm.SpotNSSGNMMapper;
import com.demo.mapper.equip.ns.tnm.AlarmNSTNMMapper;
import com.demo.mapper.equip.ns.tnm.SpotNSTNMDetailedMapper;
import com.demo.mapper.equip.ns.tnm.SpotNSTNMMapper;
import com.demo.mapper.equip.ns.wnm.AlarmNSWNMMapper;
import com.demo.mapper.equip.ns.wnm.SpotNSWNMDetailedMapper;
import com.demo.mapper.equip.ns.wnm.SpotNSWNMMapper;
import com.demo.mapper.equip.sk.ep.AlarmSKEPMapper;
import com.demo.mapper.equip.sk.ep.SpotSKEPDetailedMapper;
import com.demo.mapper.equip.sk.ep.SpotSKEPMapper;
import com.demo.mapper.equip.sk.pd2.AlarmSKPD2Mapper;
import com.demo.mapper.equip.sk.pd2.SpotSKPD2DetailedMapper;
import com.demo.mapper.equip.sk.pd2.SpotSKPD2Mapper;
import com.demo.mapper.equip.sk.pd4.AlarmSKPD4Mapper;
import com.demo.mapper.equip.sk.pd4.SpotSKPD4DetailedMapper;
import com.demo.mapper.equip.sk.pd4.SpotSKPD4Mapper;
import com.demo.mapper.equip.sk.zb.AlarmSKZBMapper;
import com.demo.mapper.equip.sk.zb.SpotSKZBDetailedMapper;
import com.demo.mapper.equip.sk.zb.SpotSKZBMapper;
import com.demo.mapper.equip.ts.glj1.AlarmTSGLJ1Mapper;
import com.demo.mapper.equip.ts.glj1.SpotTSGLJ1DetailedMapper;
import com.demo.mapper.equip.ts.glj1.SpotTSGLJ1Mapper;
import com.demo.mapper.equip.ts.glj2.AlarmTSGLJ2Mapper;
import com.demo.mapper.equip.ts.glj2.SpotTSGLJ2DetailedMapper;
import com.demo.mapper.equip.ts.glj2.SpotTSGLJ2Mapper;
import com.demo.mapper.equip.ts.ylj3.AlarmTSYLJ3Mapper;
import com.demo.mapper.equip.ts.ylj3.SpotTSYLJ3DetailedMapper;
import com.demo.mapper.equip.ts.ylj3.SpotTSYLJ3Mapper;
import com.demo.mapper.index.*;
import com.demo.mapper.interlocking.InterlockingMapper;
import com.demo.mapper.interlocking.MaintenanceMapper;
import com.demo.mapper.process.fx.FX1AlarmMapper;
import com.demo.mapper.process.fx.FX1DefectTreatmentMapper;
import com.demo.mapper.process.fx.FX1SpotMapper;
import com.demo.mapper.process.fx.FX1PVMapper;
import com.demo.mapper.process.grindingFloat.*;
import com.demo.mapper.process.mk.MF1AlarmMapper;
import com.demo.mapper.process.mk.MF1BallStatisticsMapper;
import com.demo.mapper.equip.mk.qmj.AlarmQmjMapper;
import com.demo.mapper.equip.mk.qmj.SpotQmjMapper;
import com.demo.mapper.equip.mk.zmj.AlarmZmjMapper;
import com.demo.mapper.equip.mk.zmj.SpotZmjMapper;
import com.demo.mapper.process.mk.MF1DefectTreatmentMapper;
import com.demo.mapper.process.mk.MF1SpotMapper;
import com.demo.mapper.process.ns.NS1AlarmMapper;
import com.demo.mapper.process.ns.NS1DefectTreatmentMapper;
import com.demo.mapper.process.ns.NS1NDLLMapper;
import com.demo.mapper.process.ns.NS1SpotMapper;
import com.demo.mapper.process.sk.SK1AlarmMapper;
import com.demo.mapper.process.sk.SK1DefectTreatmentMapper;
import com.demo.mapper.process.sk.SK1SpotMapper;
import com.demo.mapper.process.ts.TS1AlarmMapper;
import com.demo.mapper.process.ts.TS1DefectTreatmentMapper;
import com.demo.mapper.process.ts.TS1SpotMapper;
import com.demo.mapper.report.equip.ReportMapper;
import com.demo.mapper.report.equip.dy.ReportDYSKMapper;
import com.demo.mapper.report.equip.jw.ReportSBJWKYJMapper;
import com.demo.mapper.report.equip.jw.ReportSBJWYLGLJMapper;
import com.demo.mapper.report.equip.jw.ReportSCJWMapper;
import com.demo.mapper.report.equip.mf.*;
import com.demo.mapper.report.equip.sk.*;
import com.demo.mapper.report.equip.week.ReportWeekMapper;
import com.demo.mapper.report.workShop.WorkShopReportMapper;
import com.demo.mapper.universal.AlarmUpdateMapper;
import com.demo.mapper.universal.ConfigUserMapper;
import com.demo.model.app.*;
import com.demo.model.equip.*;


import com.demo.model.index.IndexFlowChartData;
import com.demo.model.index.IndexShow;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.process.grindingFloat.*;
import com.demo.model.report.Report;
import com.demo.model.universal.*;
import com.demo.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
@Service
public class IndexServiceImpl implements IndexService {
    /*index主页*/
    @Resource
    private IndexSpotMapper indexSpotMapper;
    @Resource
    private IndexAlarmMapper indexAlarmMapper;
    @Resource
    private IndexShowMapper indexShowMapper;
    @Resource
    private IndexFlowChartDataMapper indexFlowChartDataMapper;
    @Resource
    private AlarmUpdateMapper alarmUpdateMapper;

    //首页

    /*磨浮工艺1*/
    @Resource
    private MF1AlarmMapper mf1AlarmMapper;
    @Resource
    private MF1ProductionMapper mf1ProductionMapper;
    @Resource
    private MF1SpotMapper mf1SpotMapper;
    @Resource
    private MF1BallStatisticsMapper mf1BallStatisticsMapper;
    @Resource
    private MF1DefectTreatmentMapper mf1DefectTreatmentMapper;

    /*浮选页面*/
    @Resource
    private FX1AlarmMapper fx1AlarmMapper;
    @Resource
    private FX1SpotMapper fx1SpotMapper;
    @Resource
    private FX1PVMapper fx1PVMapper;
    @Resource
    private FX1DefectTreatmentMapper fx1DefectTreatmentMapper;

    /*给矿分级*/
    @Resource
    private AlarmGkfjMapper alarmGkfjMapper;
    @Resource
    private SpotGkfjMFMapper spotGkfjMFMapper;
    @Resource
    private SpotGkfjMapper spotGkfjMapper;
    @Resource
    private SpotGkfjDYMapper spotGkfjDYMapper;

//    给矿分级详细数据
    @Resource
    private SpotGkfjDetailedPDMapper spotGkfjDetailedPDMapper;
    @Resource
    private SpotGkfjDetailedZBMapper spotGkfjDetailedZBMapper;
    @Resource
    private SpotGkfjDetailedXLQMapper spotGkfjDetailedXLQMapper;


    //    鼓风机
    @Resource
    private AlarmGfjMapper alarmGfjMapper;
    @Resource
    private SpotGfjMapper spotGfjMapper;
    @Resource
    private SpotGfj1DetailedMapper spotGfj1DetailedMapper;
    @Resource
    private SpotGfj2DetailedMapper spotGfj2DetailedMapper;
    @Resource
    private SpotGfj3DetailedMapper spotGfj3DetailedMapper;

    //   浮选机
    @Resource
    private SpotFxFxjMapper spotFxFxjMapper;
    //    脱泥旋流器
    @Resource
    private SpotFxXlqMapper spotFxXlqMapper;
    //    浮选搅拌桶
    @Resource
    private SpotFxJbtMapper spotFxJbtMapper;


// 半自磨机
    @Resource
    private AlarmBzmjMapper alarmBzmjMapper;
    @Resource
    private SpotBzmjMapper spotBzmjMapper;
    @Resource
    private SpotBzmjDetailedMapper spotBzmjDetailedMapper;
//球磨机
    @Resource
    private AlarmQmjMapper alarmQmjMapper;
    @Resource
    private SpotQmjMapper spotQmjMapper;
    @Resource
    private SpotQmjDetailedMapper spotQmjDetailedMapper;

//设备详细数据测试
    @Resource
    private SpotMkDetailedMapper spotMkDetailedMapper;
    @Resource
    private SpotFxDetailedMapper spotFxDetailedMapper;
    @Resource
    private SpotSkDetailedMapper  spotSkDetailedMapper;
    @Resource
    private SpotNsDetailedMapper spotNsDetailedMapper;
    @Resource
    private SpotTsDetailedMapper spotTsDetailedMapper;

//再磨机
    @Resource
    private AlarmZmjMapper alarmZmjMapper;
    @Resource
    private SpotZmjMapper spotZmjMapper;
    @Resource
    private SpotZmjDetailedMapper spotZmjDetailedMapper;


//碎矿
    @Resource
    private SK1AlarmMapper sk1AlarmMapper;

    @Resource
    private SK1SpotMapper sk1SpotMapper;

    @Resource
    private SK1DefectTreatmentMapper sk1DefectTreatmentMapper;
    // 重板
    @Resource
    private AlarmSKZBMapper alarmSKZBMapper;
    @Resource
    private SpotSKZBMapper spotSKZBMapper;
    @Resource
    private SpotSKZBDetailedMapper spotSKZBDetailedMapper;
    // 颚破
    @Resource
    private AlarmSKEPMapper alarmSKEPMapper;
    @Resource
    private SpotSKEPMapper spotSKEPMapper;
    @Resource
    private SpotSKEPDetailedMapper spotSKEPDetailedMapper;

    // 2#皮带
    @Resource
    private AlarmSKPD2Mapper alarmSKPD2Mapper;
    @Resource
    private SpotSKPD2Mapper spotSKPD2Mapper;
    @Resource
    private SpotSKPD2DetailedMapper spotSKPD2DetailedMapper;


    // 4#皮带
    @Resource
    private AlarmSKPD4Mapper alarmSKPD4Mapper;
    @Resource
    private SpotSKPD4Mapper spotSKPD4Mapper;
    @Resource
    private SpotSKPD4DetailedMapper spotSKPD4DetailedMapper;



//    浓缩
    @Resource
    private NS1AlarmMapper ns1AlarmMapper;
    @Resource
    private NS1DefectTreatmentMapper ns1DefectTreatmentMapper;
    @Resource
    private NS1SpotMapper ns1SpotMapper;
    @Resource
    private NS1NDLLMapper ns1NDLLMapper;

    //铜浓密
    @Resource
    private AlarmNSTNMMapper alarmNSTNMMapper;
    @Resource
    private SpotNSTNMMapper spotNSTNMMapper;
    @Resource
    private SpotNSTNMDetailedMapper spotNSTNMDetailedMapper;



    //铜浓密
    @Resource
    private AlarmNSWNMMapper alarmNSWNMMapper;
    @Resource
    private SpotNSWNMMapper spotNSWNMMapper;
    @Resource
    private SpotNSWNMDetailedMapper spotNSWNMDetailedMapper;

    //硫浓密
    @Resource
    private AlarmNSLNMMapper alarmNSLNMMapper;
    @Resource
    private SpotNSLNMMapper spotNSLNMMapper;
    @Resource
    private SpotNSLNMDetailedMapper spotNSLNMDetailedMapper;


    //事故浓密
    @Resource
    private AlarmNSSGNMMapper alarmNSSGNMMapper;
    @Resource
    private SpotNSSGNMMapper spotNSSGNMMapper;
    @Resource
    private SpotNSSGNMDetailedMapper spotNSSGNMDetailedMapper;

    //   脱水
    @Resource
    private TS1AlarmMapper ts1AlarmMapper;
    @Resource
    private TS1DefectTreatmentMapper ts1DefectTreatmentMapper;
    @Resource
    private TS1SpotMapper ts1SpotMapper;

    //3#压滤机
    @Resource
    private AlarmTSYLJ3Mapper alarmTSYLJ3Mapper;
    @Resource
    private SpotTSYLJ3Mapper spotTSYLJ3Mapper;
    @Resource
    private SpotTSYLJ3DetailedMapper spotTSYLJ3DetailedMapper;



    //1#过滤机
    @Resource
    private AlarmTSGLJ1Mapper alarmTSGLJ1Mapper;
    @Resource
    private SpotTSGLJ1Mapper spotTSGLJ1Mapper;
    @Resource
    private SpotTSGLJ1DetailedMapper spotTSGLJ1DetailedMapper;



    //2#过滤机
    @Resource
    private AlarmTSGLJ2Mapper alarmTSGLJ2Mapper;
    @Resource
    private SpotTSGLJ2Mapper spotTSGLJ2Mapper;
    @Resource
    private SpotTSGLJ2DetailedMapper spotTSGLJ2DetailedMapper;


    // 鼓风机报警数据
    @Override
    public List<SpotAlarm> FX_GFJ_1_ALARM_LIST() {
        return alarmGfjMapper.FX_GFJ_1_ALARM_LIST();
    }

    @Override
    public List<SpotAlarm> FX_GFJ_2_ALARM_LIST() { return alarmGfjMapper.FX_GFJ_2_ALARM_LIST(); }

    @Override
    public List<SpotAlarm> FX_GFJ_3_ALARM_LIST() { return alarmGfjMapper.FX_GFJ_3_ALARM_LIST(); }








/*index页面点检统计*/
    @Override
    public List<SpotStatistics> INDEX_SC_LIST(String param) { return indexSpotMapper.INDEX_SC_LIST(param); }
    @Override
    public List<SpotStatistics> INDEX_DY_LIST(String param) { return indexSpotMapper.INDEX_DY_LIST(param); }
    @Override
    public List<SpotStatistics> INDEX_SB_LIST(String param) { return indexSpotMapper.INDEX_SB_LIST(param); }
/*index实时数据*/
    @Override
    public List<IndexShow> INDEX_SHOW_LIST() {
        return indexShowMapper.INDEX_SHOW_LIST();
    }
    @Override
    public List<IndexShow> INDEX_SHOW1_LIST() {
        return indexShowMapper.INDEX_SHOW1_LIST();
    }
    @Override
    public List<IndexFlowChartData> INDEX_FLOW_CHART_DATA_LIST() {
        return indexFlowChartDataMapper.INDEX_FLOW_CHART_DATA_LIST();
    }
    @Override
    public List<IndexFlowChartData> INDEX_FLOW_CHART_DATA2_LIST() {
        return indexFlowChartDataMapper.INDEX_FLOW_CHART_DATA2_LIST();
    }

/*index报警*/
    @Override
    public List<SpotAlarm> INDEX_ALARM_LIST(String param) { return indexAlarmMapper.INDEX_ALARM_LIST(param); }


    @Override
    public  Integer   CURRENCY_ALARM_UPDATE(String name,String id,String remark){
        return  alarmUpdateMapper.CURRENCY_ALARM_UPDATE(name,id,remark); }
    //登录用户名
    @Override
    public LoginUser get_login_name(String name){
        return  alarmUpdateMapper.get_login_name(name); }

    @Override
    public List<WebDxjBj> search_alarm_id(String id) {
        return alarmUpdateMapper.search_alarm_id(id);
    }



    /*磨浮工艺1*/

    @Override
    public List<MF1Production> MF_1_PRODUCTION_LIST() {
        Map<String ,Object> map=new HashMap<>();
        map.put("tableName","dxj_spot_result");
        return mf1ProductionMapper.MF_1_PRODUCTION_LIST(map);
    }

    @Override
    public List<SpotStatistics> MF_1_SPOT_LIST() {
        return mf1SpotMapper.MF_1_SPOT_LIST();
    }

    @Override
    public List<SpotStatistics> MK_1_BALL_STATISTICS_LIST() {
        return mf1BallStatisticsMapper.MK_1_BALL_STATISTICS_LIST();
    }

    @Override
    public List<SBMKDefectTreatment> MF_1_DEFECT_TREATMENT_LIST() {
        return mf1DefectTreatmentMapper.SBMK_DEFECT_TREATMENT_LIST();
    }
    @Override
    public List<SpotAlarm> MF_1_ALARM_LIST() {
        return mf1AlarmMapper.MF_1_ALARM_LIST();
    }



    //    浮选
    @Override
    public List<SpotStatistics> FX_1_SPOT_LIST() { return fx1SpotMapper.FX_1_SPOT_LIST(); }

    @Override
    public List<DefectTreatment> FX_1_DefectTreatment_LIST(){ return fx1DefectTreatmentMapper.FX_1_DEFECT_TREATMENT_LIST(); }

    @Override
    public List<SpotAlarm> FX_1_ALARM_LIST() { return fx1AlarmMapper.FX_1_ALARM_LIST(); }

    @Override
    public List<IndexFlowChartData> FX_1_PV_LIST() { return fx1PVMapper.FX_1_PV_LIST(); }

    //鼓风机点检统计
    @Override
    public List<SpotStatistics> FX_GFJ1_SPOT_LIST() {
        return spotGfjMapper.SPOT_FX_GFJ1_LIST();
    }

    @Override
    public List<SpotStatistics> FX_GFJ2_SPOT_LIST() {
        return spotGfjMapper.SPOT_FX_GFJ2_LIST();
    }

    @Override
    public List<SpotStatistics> FX_GFJ3_SPOT_LIST() {
        return spotGfjMapper.SPOT_FX_GFJ3_LIST();
    }

    //1#鼓风机详细数据
    @Override
    public List<detailedData> SPOT_GFJ1_MK_LIST() {
        return spotGfj1DetailedMapper.SPOT_GFJ1_MK_LIST();
    }

    @Override
    public List<detailedData> SPOT_GFJ1_DY_LIST() {
        return spotGfj1DetailedMapper.SPOT_GFJ1_DY_LIST();
    }

    @Override
    public List<detailedData> SPOT_GFJ1_SC_LIST() {
        return spotGfj1DetailedMapper.SPOT_GFJ1_SC_LIST();
    }


    //2#鼓风机详细数据
    @Override
    public List<detailedData> SPOT_GFJ2_MK_LIST() { return spotGfj2DetailedMapper.SPOT_GFJ2_MK_LIST(); }

    @Override
    public List<detailedData> SPOT_GFJ2_DY_LIST() {
        return spotGfj2DetailedMapper.SPOT_GFJ2_DY_LIST();
    }

    @Override
    public List<detailedData> SPOT_GFJ2_SC_LIST() {
        return spotGfj2DetailedMapper.SPOT_GFJ2_SC_LIST();
    }

    //3#鼓风机详细数据
    @Override
    public List<detailedData> SPOT_GFJ3_MK_LIST() {
        return spotGfj3DetailedMapper.SPOT_GFJ3_MK_LIST();
    }

    @Override
    public List<detailedData> SPOT_GFJ3_DY_LIST() {
        return spotGfj3DetailedMapper.SPOT_GFJ3_DY_LIST();
    }

    @Override
    public List<detailedData> SPOT_GFJ3_SC_LIST() {
        return spotGfj3DetailedMapper.SPOT_GFJ3_SC_LIST();
    }

    //浮选机
    @Override
    public List<SpotAlarm> ALARM_FX_FXJ_LIST(String equip) { return spotFxFxjMapper.ALARM_FX_FXJ_LIST(equip);}

    @Override
    public List<SpotStatistics> SPOT_FXJ_LIST(String equip) { return spotFxFxjMapper.SPOT_FXJ_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_FXJ_SB_LIST(String equip) { return spotFxFxjMapper.SPOT_FX_FXJ_SB_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_FXJ_SC_LIST(String equip) { return spotFxFxjMapper.SPOT_FX_FXJ_SC_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_FXJ_DY_LIST(String equip) { return spotFxFxjMapper.SPOT_FX_FXJ_DY_LIST(equip); }
        //刮板浮选机点检详细数据
    @Override
    public List<detailedData> SPOT_FX_FXJ2_SB_LIST(String equip) { return spotFxFxjMapper.SPOT_FX_FXJ2_SB_LIST(equip); }

//    脱泥旋流器
    @Override
    public List<SpotAlarm> ALARM_FX_XLQ_LIST() {
        return spotFxXlqMapper.ALARM_FX_XLQ_LIST();
    }

    @Override
    public List<SpotStatistics> SPOT_FX_XLQ_LIST() { return spotFxXlqMapper.SPOT_FX_XLQ_LIST(); }

    @Override
    public List<detailedData> SPOT_FX_XLQ_SB_LIST() {
        return spotFxXlqMapper.SPOT_FX_XLQ_SB_LIST();
    }

    @Override
    public List<detailedData> SPOT_FX_XLQ_SC_LIST() {
        return spotFxXlqMapper.SPOT_FX_XLQ_SC_LIST();
    }
//  浮选搅拌桶
    @Override
    public List<SpotAlarm> ALARM_FX_JBT_LIST(String equip) { return spotFxJbtMapper.ALARM_FX_JBT_LIST(equip); }

    @Override
    public List<SpotStatistics> SPOT_JBT_LIST(String equip) { return spotFxJbtMapper.SPOT_JBT_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_JBT_SB_LIST(String equip) { return spotFxJbtMapper.SPOT_FX_JBT_SB_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_JBT_SC_LIST(String equip) { return spotFxJbtMapper.SPOT_FX_JBT_SC_LIST(equip); }

    @Override
    public List<detailedData> SPOT_FX_JBT_DY_LIST(String equip) { return spotFxJbtMapper.SPOT_FX_JBT_DY_LIST(equip); }


    // 5#皮带详细数据
    @Override
    public List<SpotStatistics> SPOT_MK_PD_LIST() {
        return spotGkfjMapper.SPOT_MK_PD_LIST();
    }

    @Override
    public List<SpotAlarm> MK_PD_ALARM_LIST() { return alarmGkfjMapper.MK_PD_ALARM_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_MK_DETAILED_PD_LIST() { return spotGkfjDetailedPDMapper.SPOT_GKFJ_MK_DETAILED_PD_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_DY_DETAILED_PD_LIST() { return spotGkfjDetailedPDMapper.SPOT_GKFJ_DY_DETAILED_PD_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_SC_DETAILED_PD_LIST() { return spotGkfjDetailedPDMapper.SPOT_GKFJ_SC_DETAILED_PD_LIST(); }


//磨矿重板详细数据
    @Override
    public List<SpotStatistics> SPOT_MK_ZB_LIST() {
        return spotGkfjMapper.SPOT_MK_ZB_LIST();
    }

    @Override
    public List<SpotAlarm> MK_ZB_ALARM_LIST() { return alarmGkfjMapper.MK_ZB_ALARM_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_MK_DETAILED_ZB_LIST() { return spotGkfjDetailedZBMapper.SPOT_GKFJ_MK_DETAILED_ZB_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_DY_DETAILED_ZB_LIST() { return spotGkfjDetailedZBMapper.SPOT_GKFJ_DY_DETAILED_ZB_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_SC_DETAILED_ZB_LIST() { return spotGkfjDetailedZBMapper.SPOT_GKFJ_SC_DETAILED_ZB_LIST(); }

//磨矿旋流器
    @Override
    public List<SpotStatistics> SPOT_MK_XLQ_LIST() {
        return spotGkfjMapper.SPOT_MK_XLQ_LIST();
    }

    @Override
    public List<SpotAlarm> MK_XLQ_ALARM_LIST() { return alarmGkfjMapper.MK_XLQ_ALARM_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_MK_DETAILED_XLQ_LIST() { return spotGkfjDetailedXLQMapper.SPOT_GKFJ_MK_DETAILED_XLQ_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_DY_DETAILED_XLQ_LIST() { return spotGkfjDetailedXLQMapper.SPOT_GKFJ_DY_DETAILED_XLQ_LIST(); }

    @Override
    public List<detailedData> SPOT_GKFJ_SC_DETAILED_XLQ_LIST() { return spotGkfjDetailedXLQMapper.SPOT_GKFJ_SC_DETAILED_XLQ_LIST(); }


    /*
* 半自磨机
* */
    @Override
    public List<SpotStatistics> SPOT_BZMJ_LIST() { return spotBzmjMapper.SPOT_BZMJ_LIST(); }

    @Override
    public List<detailedData> SPOT_MK_BZMJ_MF_LIST() { return spotBzmjDetailedMapper.SPOT_MK_BZMJ_MF_LIST(); }

    @Override
    public List<detailedData> SPOT_MK_BZMJ_SC_LIST() { return spotBzmjDetailedMapper.SPOT_MK_BZMJ_SC_LIST(); }

    @Override
    public List<detailedData> SPOT_MK_BZMJ_DY_LIST() { return spotBzmjDetailedMapper.SPOT_MK_BZMJ_DY_LIST(); }

    @Override
    public List<SpotAlarm> ALARM_ZBMJ_LIST() {
        return alarmBzmjMapper.ALARM_BZMJ_LIST();
    }

    //球磨机
    @Override
    public List<SpotStatistics> SPOT_QMJ_LIST() {
        return spotQmjMapper.SPOT_QMJ_LIST();
    }

    @Override
    public List<detailedData> SPOT_MK_QMJ_MK_LIST() {
        return spotQmjDetailedMapper.SPOT_MK_QMJ_MK_LIST();
    }

    @Override
    public List<detailedData> SPOT_MK_QMJ_DY_LIST() {
        return spotQmjDetailedMapper.SPOT_MK_QMJ_DY_LIST();
    }

    @Override
    public List<detailedData> SPOT_MK_QMJ_SC_LIST() {
        return spotQmjDetailedMapper.SPOT_MK_QMJ_SC_LIST();
    }

    @Override
    public List<SpotAlarm> ALARM_QMJ_LIST() {
        return alarmQmjMapper.ALARM_QMJ_LIST();
    }
//球磨机详细数据测试用
    @Override
    public List<SpotAlarm> SPOT_MK_QMJ_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_QMJ_DETAILED_LIST(param); }
//再磨机详细数据测试用
    @Override
    public List<SpotAlarm> SPOT_MK_ZMJ_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_ZMJ_DETAILED_LIST(param); }
//半自磨机详细数据测试用
    @Override
    public List<SpotAlarm> SPOT_MK_BZMJ_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_BZMJ_DETAILED_LIST(param); }
//重板详细数据测试用
    @Override
    public List<SpotAlarm> SPOT_MK_ZB_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_ZB_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_MK_XLQ_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_XLQ_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_MK_PD_DETAILED_LIST(String param) { return spotMkDetailedMapper.SPOT_MK_PD_DETAILED_LIST(param); }
//浮选设备点检数据详情
    @Override
    public List<SpotAlarm> SPOT_FX_GFJ1_DETAILED_LIST(String param) { return spotFxDetailedMapper.SPOT_FX_GFJ1_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_FX_GFJ2_DETAILED_LIST(String param) { return spotFxDetailedMapper.SPOT_FX_GFJ2_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_FX_GFJ3_DETAILED_LIST(String param) { return spotFxDetailedMapper.SPOT_FX_GFJ3_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_FX_FXJ1_DETAILED_LIST(String param,String equip) { return spotFxDetailedMapper.SPOT_FX_FXJ1_DETAILED_LIST(param,equip); }

    @Override
    public List<SpotAlarm> SPOT_FX_FXJ2_DETAILED_LIST(String param,String equip) { return spotFxDetailedMapper.SPOT_FX_FXJ2_DETAILED_LIST(param,equip); }

    @Override
    public List<SpotAlarm> SPOT_FX_XLQ_DETAILED_LIST(String param) { return spotFxDetailedMapper.SPOT_FX_XLQ_DETAILED_LIST(param); }
    @Override
    public List<SpotAlarm> SPOT_FX_JBT_DETAILED_LIST(String param,String equip) { return spotFxDetailedMapper.SPOT_FX_JBT_DETAILED_LIST(param,equip); }

//碎矿设备点检数据详情
    @Override
    public List<SpotAlarm> SPOT_SK_EP_DETAILED_LIST(String param) { return   spotSkDetailedMapper.SPOT_SK_EP_DETAILED_LIST(param); }
    @Override
    public List<SpotAlarm> SPOT_SK_ZB_DETAILED_LIST(String param) { return   spotSkDetailedMapper.SPOT_SK_ZB_DETAILED_LIST(param); }
    @Override
    public List<SpotAlarm> SPOT_SK_PD2_DETAILED_LIST(String param) { return   spotSkDetailedMapper.SPOT_SK_PD2_DETAILED_LIST(param); }
    @Override
    public List<SpotAlarm> SPOT_SK_PD4_DETAILED_LIST(String param) { return   spotSkDetailedMapper.SPOT_SK_PD4_DETAILED_LIST(param); }

// 浓缩设备点检数据详情
    @Override
    public List<SpotAlarm> SPOT_NS_TNM_DETAILED_LIST(String param) { return spotNsDetailedMapper.SPOT_NS_TNM_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_NS_LNM_DETAILED_LIST(String param) { return spotNsDetailedMapper.SPOT_NS_LNM_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_NS_WNM_DETAILED_LIST(String param) { return spotNsDetailedMapper.SPOT_NS_WNM_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_NS_SGNM_DETAILED_LIST(String param) { return spotNsDetailedMapper.SPOT_NS_SGNM_DETAILED_LIST(param); }

// 脱水设备点检数据详情
    @Override
    public List<SpotAlarm> SPOT_TS_GLJ1_DETAILED_LIST(String param) { return spotTsDetailedMapper.SPOT_TS_GLJ1_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_TS_GLJ2_DETAILED_LIST(String param) { return spotTsDetailedMapper.SPOT_TS_GLJ2_DETAILED_LIST(param); }

    @Override
    public List<SpotAlarm> SPOT_TS_YLJ3_DETAILED_LIST(String param) { return spotTsDetailedMapper.SPOT_TS_YLJ3_DETAILED_LIST(param); }


    //    再磨机
    @Override
    public List<SpotStatistics> SPOT_ZMJ_LIST() { return spotZmjMapper.SPOT_ZMJ_LIST(); }

    @Override
    public List<detailedData> SPOT_MK_ZMJ_MK_LIST() {
        return spotZmjDetailedMapper.SPOT_MK_ZMJ_MK_LIST();
    }

    @Override
    public List<detailedData> SPOT_MK_ZMJ_SC_LIST() {
        return spotZmjDetailedMapper.SPOT_MK_ZMJ_SC_LIST();
    }

    @Override
    public List<detailedData> SPOT_MK_ZMJ_DY_LIST() {
        return spotZmjDetailedMapper.SPOT_MK_ZMJ_DY_LIST();
    }

    @Override
    public List<SpotAlarm> ALARM_ZMJ_LIST() {
        return alarmZmjMapper.ALARM_ZMJ_LIST();
    }


// 碎矿

    @Override
    public List<SpotAlarm> SK_1_ALARM_LIST() { return sk1AlarmMapper.SK_1_ALARM_LIST(); }

    @Override
    public List<SpotStatistics> SK_1_SPOT_LIST() { return sk1SpotMapper.SK_1_SPOT_LIST(); }

    @Override
    public List<DefectTreatment> SK_DEFECT_TREATMENT_LIST() { return sk1DefectTreatmentMapper.SK_DEFECT_TREATMENT_LIST(); }


    //    重板

    @Override
    public List<SpotStatistics> SPOT_SK_ZB_LIST() { return spotSKZBMapper.SPOT_SK_ZB_LIST(); }

    @Override
    public List<SpotAlarm> SK_ZB_ALARM_LIST() { return alarmSKZBMapper.SK_ZB_ALARM_LIST(); }

    @Override
    public List<detailedData> SK_ZB_SB_Detailed_LIST() { return spotSKZBDetailedMapper.SK_ZB_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_ZB_DY_Detailed_LIST() { return spotSKZBDetailedMapper.SK_ZB_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_ZB_SC_Detailed_LIST() { return spotSKZBDetailedMapper.SK_ZB_SC_Detailed_LIST(); }


    //    颚破
    @Override
    public List<SpotStatistics> SPOT_SK_EP_LIST() { return spotSKEPMapper.SPOT_SK_EP_LIST(); }

    @Override
    public List<SpotAlarm> SK_EP_ALARM_LIST() { return alarmSKEPMapper.SK_EP_ALARM_LIST(); }

    @Override
    public List<detailedData> SK_EP_SB_Detailed_LIST() { return spotSKEPDetailedMapper.SK_EP_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_EP_DY_Detailed_LIST() { return spotSKEPDetailedMapper.SK_EP_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_EP_SC_Detailed_LIST() { return spotSKEPDetailedMapper.SK_EP_SC_Detailed_LIST(); }

    // 2#皮带
    @Override
    public List<SpotStatistics> SPOT_SK_PD2_LIST() { return spotSKPD2Mapper.SPOT_SK_PD2_LIST(); }

    @Override
    public List<SpotAlarm> SK_PD2_ALARM_LIST() { return alarmSKPD2Mapper.SK_PD2_ALARM_LIST(); }

    @Override
    public List<detailedData> SK_PD2_SB_Detailed_LIST() { return spotSKPD2DetailedMapper.SK_PD2_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_PD2_DY_Detailed_LIST() { return spotSKPD2DetailedMapper.SK_PD2_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_PD2_SC_Detailed_LIST() { return spotSKPD2DetailedMapper.SK_PD2_SC_Detailed_LIST(); }

    //4#皮带
    @Override
    public List<SpotStatistics> SPOT_SK_PD4_LIST() { return spotSKPD4Mapper.SPOT_SK_PD4_LIST(); }

    @Override
    public List<SpotAlarm> SK_PD4_ALARM_LIST() { return alarmSKPD4Mapper.SK_PD4_ALARM_LIST(); }

    @Override
    public List<detailedData> SK_PD4_SB_Detailed_LIST() { return spotSKPD4DetailedMapper.SK_PD4_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_PD4_DY_Detailed_LIST() { return spotSKPD4DetailedMapper.SK_PD4_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> SK_PD4_SC_Detailed_LIST() { return spotSKPD4DetailedMapper.SK_PD4_SC_Detailed_LIST(); }


//    浓缩
    @Override
    public List<SpotAlarm> NS_1_ALARM_LIST() { return ns1AlarmMapper.NS_1_ALARM_LIST(); }

    @Override
    public List<SpotStatistics> NS_1_SPOT_LIST() { return ns1SpotMapper.NS_1_SPOT_LIST(); }

    @Override
    public List<DefectTreatment> NS_DEFECT_TREATMENT_LIST() { return ns1DefectTreatmentMapper.NS_DEFECT_TREATMENT_LIST(); }

    @Override
    public List<IndexFlowChartData> NS_1_NDLL_LIST() { return ns1NDLLMapper.NS_1_NDLL_LIST(); }


    //    铜浓密
    @Override
    public List<SpotStatistics> SPOT_NS_TNM_LIST() { return spotNSTNMMapper.SPOT_NS_TNM_LIST(); }

    @Override
    public List<SpotAlarm> NS_TNM_ALARM_LIST() { return alarmNSTNMMapper.NS_TNM_ALARM_LIST(); }

    @Override
    public List<detailedData> NS_TNM_SB_Detailed_LIST() { return spotNSTNMDetailedMapper.NS_TNM_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_TNM_DY_Detailed_LIST() { return spotNSTNMDetailedMapper.NS_TNM_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_TNM_SC_Detailed_LIST() { return spotNSTNMDetailedMapper.NS_TNM_SC_Detailed_LIST(); }


    //    尾矿浓密
    @Override
    public List<SpotStatistics> SPOT_NS_WNM_LIST() { return spotNSWNMMapper.SPOT_NS_WNM_LIST(); }

    @Override
    public List<SpotAlarm> NS_WNM_ALARM_LIST() { return alarmNSWNMMapper.NS_WNM_ALARM_LIST(); }

    @Override
    public List<detailedData> NS_WNM_SB_Detailed_LIST() { return spotNSWNMDetailedMapper.NS_WNM_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_WNM_DY_Detailed_LIST() { return spotNSWNMDetailedMapper.NS_WNM_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_WNM_SC_Detailed_LIST() { return spotNSWNMDetailedMapper.NS_WNM_SC_Detailed_LIST(); }


    //硫浓密

    @Override
    public List<SpotStatistics> SPOT_NS_LNM_LIST() { return spotNSLNMMapper.SPOT_NS_LNM_LIST(); }

    @Override
    public List<SpotAlarm> NS_LNM_ALARM_LIST() { return alarmNSLNMMapper.NS_LNM_ALARM_LIST(); }

    @Override
    public List<detailedData> NS_LNM_SB_Detailed_LIST() { return spotNSLNMDetailedMapper.NS_LNM_SB_Detailed_LIST();  }

    @Override
    public List<detailedData> NS_LNM_DY_Detailed_LIST() { return spotNSLNMDetailedMapper.NS_LNM_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_LNM_SC_Detailed_LIST() { return spotNSLNMDetailedMapper.NS_LNM_SC_Detailed_LIST(); }

    //    事故浓密机

    @Override
    public List<SpotStatistics> SPOT_NS_SGNM_LIST() { return spotNSSGNMMapper.SPOT_NS_SGNM_LIST(); }

    @Override
    public List<SpotAlarm> NS_SGNM_ALARM_LIST() { return alarmNSSGNMMapper.NS_SGNM_ALARM_LIST(); }

    @Override
    public List<detailedData> NS_SGNM_SB_Detailed_LIST() { return spotNSSGNMDetailedMapper.NS_SGNM_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_SGNM_DY_Detailed_LIST() { return spotNSSGNMDetailedMapper.NS_SGNM_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> NS_SGNM_SC_Detailed_LIST() { return spotNSSGNMDetailedMapper.NS_SGNM_SC_Detailed_LIST(); }


    //    脱水
    @Override
    public List<SpotAlarm> TS_1_ALARM_LIST() { return ts1AlarmMapper.TS_1_ALARM_LIST(); }

    @Override
    public List<SpotStatistics> TS_1_SPOT_LIST() { return ts1SpotMapper.TS_1_SPOT_LIST(); }

    @Override
    public List<DefectTreatment> TS_DEFECT_TREATMENT_LIST() { return ts1DefectTreatmentMapper.TS_DEFECT_TREATMENT_LIST(); }


//    3#压滤机
    @Override
    public List<SpotStatistics> SPOT_TS_YLJ3_LIST() { return spotTSYLJ3Mapper.SPOT_TS_YLJ3_LIST(); }

    @Override
    public List<SpotAlarm> TS_YLJ3_ALARM_LIST() { return alarmTSYLJ3Mapper.TS_YLJ3_ALARM_LIST(); }

    @Override
    public List<detailedData> TS_YLJ3_SB_Detailed_LIST() { return spotTSYLJ3DetailedMapper.TS_YLJ3_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_YLJ3_DY_Detailed_LIST() { return spotTSYLJ3DetailedMapper.TS_YLJ3_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_YLJ3_SC_Detailed_LIST() { return spotTSYLJ3DetailedMapper.TS_YLJ3_SC_Detailed_LIST(); }


    //    1#过滤机
    @Override
    public List<SpotStatistics> SPOT_TS_GLJ1_LIST() { return spotTSGLJ1Mapper.SPOT_TS_GLJ1_LIST(); }

    @Override
    public List<SpotAlarm> TS_GLJ1_ALARM_LIST() { return alarmTSGLJ1Mapper.TS_GLJ1_ALARM_LIST(); }

    @Override
    public List<detailedData> TS_GLJ1_SB_Detailed_LIST() { return spotTSGLJ1DetailedMapper.TS_GLJ1_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_GLJ1_DY_Detailed_LIST() { return spotTSGLJ1DetailedMapper.TS_GLJ1_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_GLJ1_SC_Detailed_LIST() { return spotTSGLJ1DetailedMapper.TS_GLJ1_SC_Detailed_LIST(); }


    //2#过滤机
    @Override
    public List<SpotStatistics> SPOT_TS_GLJ2_LIST() { return spotTSGLJ2Mapper.SPOT_TS_GLJ2_LIST(); }

    @Override
    public List<SpotAlarm> TS_GLJ2_ALARM_LIST() { return alarmTSGLJ2Mapper.TS_GLJ2_ALARM_LIST(); }

    @Override
    public List<detailedData> TS_GLJ2_SB_Detailed_LIST() { return spotTSGLJ2DetailedMapper.TS_GLJ2_SB_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_GLJ2_DY_Detailed_LIST() { return spotTSGLJ2DetailedMapper.TS_GLJ2_DY_Detailed_LIST(); }

    @Override
    public List<detailedData> TS_GLJ2_SC_Detailed_LIST() { return spotTSGLJ2DetailedMapper.TS_GLJ2_SC_Detailed_LIST(); }




//    报表
    @Resource
    private ReportMapper reportMapper;
//磨浮磨机
    @Resource
    private ReportSBMFMJMapper reportSBMFMJMapper;
//磨浮浮选
    @Resource
    private ReportSBMFGFJMapper reportSBMFGFJMapper;

//磨浮皮带中板
    @Resource
    private ReportSBMFPDMapper reportSBMFPDMapper;
//    浮选机、搅拌桶
    @Resource
    private ReportSBMFFXJMapper reportSBMFFXJMapper;
//碎矿重板
    @Resource
    private ReportSBSKZBMapper reportSBSKZBMapper;
//碎矿颚破
    @Resource
    private ReportSBSKEPMapper reportSBSKEPMapper;
//碎矿皮带
    @Resource
    private ReportSBSKPDMapper reportSBSKPDMapper;
//碎矿石灰
    @Resource
    private ReportSBSKSHMapper reportSBSKSHMapper;

//精尾设备
    @Resource
    private ReportSBJWKYJMapper reportSBJWKYJMapper;
    @Resource
    private ReportSBJWYLGLJMapper reportSBJWYLGLJMapper;

//    电仪碎矿
    @Resource
    private ReportDYSKMapper reportDYSKMapper;


//设备报表公共
    @Override
    public List<Report> REPORT_SB_SPOT_LIST(String workshop,String team,String equip,String time,String duty) {

        return reportMapper.REPORT_SB_SPOT_LIST(workshop,team,equip,time,duty);
    }
    @Override
    public List<Report> REPORT_SB_DEAL_LIST(String workshop,String team,String equip,String time,String duty) {
        return reportMapper.REPORT_SB_DEAL_LIST(workshop,team,equip,time,duty);
    }
    @Override
    public List<Report> REPORT_SC_SPOT_LIST(String workshop,String team,String equip,String time,String duty) {

        return reportMapper.REPORT_SC_SPOT_LIST(workshop,team,equip,time,duty);
    }
    @Override
    public List<Report> REPORT_SC_DEAL_LIST(String workshop,String team,String equip,String time,String duty) {
        return reportMapper.REPORT_SC_DEAL_LIST(workshop,team,equip,time,duty);
    }

//磨浮磨机DCS
    @Override
    public List<Report> REPORT_SB_MK_ZMJ_DCS_LIST(String team,String equip,String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_ZMJ_DCS_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_MK_BZMJ_DCS_LIST(String team,String equip,String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_BZMJ_DCS_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_MK_QMJ_DCS_LIST(String team,String equip,String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_QMJ_DCS_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_MJ_DCS_RUN_LIST(String team,String equip,String time) {
        return reportDYSKMapper.REPORT_DY_MF_MJ_DCS_RUN_LIST(team,equip,time);
    }
//磨浮再磨机渣浆泵
    @Override
    public List<Report> REPORT_SB_MK_MJ_ZJB_RUN_LIST(String team, String equip, String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_MJ_ZJB_RUN_LIST(team,equip,time);
    }
//磨机
    @Override
    public List<Report> REPORT_SB_MK_ZMJ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_ZMJ_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_MK_QMJ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_QMJ_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_MK_BZMJ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFMJMapper.REPORT_SB_MK_BZMJ_RUN_LIST(team,equip,time);
    }
//浮选机、搅拌桶
    @Override
    public List<Report> REPORT_SB_FX_JBT_RUN_LIST(String team, String equip, String time) {
        return reportSBMFFXJMapper.REPORT_SB_FX_JBT_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_FX_FXJ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFFXJMapper.REPORT_SB_FX_FXJ_RUN_LIST(team,equip,time);
    }

    //磨浮浮选柱、鼓风机
    @Override
    public List<Report> REPORT_SB_FX_FXZ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFGFJMapper.REPORT_SB_FX_FXZ_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_FX_GFJ_RUN_LIST(String team, String equip, String time) {
        return reportSBMFGFJMapper.REPORT_SB_FX_GFJ_RUN_LIST(team,equip,time);
    }

    //磨浮中板皮带
    @Override
    public List<Report> REPORT_SB_MK_ZBPD_RUN_LIST(String team,String equip,String time) {
        return reportSBMFPDMapper.REPORT_SB_MK_ZBPD_RUN_LIST(team,equip,time);
    }

    //磨浮浮选底层泵
    @Override
    public List<Report> REPORT_SB_FX_DCB_RUN_LIST(String team, String equip, String time) {
        return reportSBMFGFJMapper.REPORT_SB_FX_DCB_RUN_LIST(team,equip,time);
    }


//    碎矿设备重板
    @Override
    public List<Report> REPORT_SB_SK_ZB_RUN_LIST(String team,String equip,String time) {
        return reportSBSKZBMapper.REPORT_SB_SK_ZB_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_SK_ZB_PD1_RUN_LIST(String team,String equip,String time) {
        return reportSBSKZBMapper.REPORT_SB_SK_ZB_PD1_RUN_LIST(team,equip,time);
    }

    //    碎矿设备颚破
    @Override
    public List<Report> REPORT_SB_SK_EP_RUN_LIST(String team,String equip,String time) {
        return reportSBSKEPMapper.REPORT_SB_SK_EP_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_SK_EP_CC_RUN_LIST(String team,String equip,String time) {
        return reportSBSKEPMapper.REPORT_SB_SK_EP_CC_RUN_LIST(team,equip,time);
    }

    //    碎矿设备皮带
    @Override
    public List<Report> REPORT_SB_SK_PD2_RUN_LIST(String team,String equip,String time) {
        return reportSBSKPDMapper.REPORT_SB_SK_PD2_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_SK_PD4_RUN_LIST(String team,String equip,String time) {
        return reportSBSKPDMapper.REPORT_SB_SK_PD4_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_SK_SH_LSLC_RUN_LIST(String team, String equip, String time) {
        return reportSBSKSHMapper.REPORT_SB_SK_SH_LSLC_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_SK_SH_GLJ_RUN_LIST(String team, String equip, String time) {
        return reportSBSKSHMapper.REPORT_SB_SK_SH_GLJ_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_SK_SH_3M_RUN_LIST(String team, String equip, String time) {
        return reportSBSKSHMapper.REPORT_SB_SK_SH_3M_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_SK_SH_4M_RUN_LIST(String team, String equip, String time) {
        return reportSBSKSHMapper.REPORT_SB_SK_SH_4M_RUN_LIST(team,equip,time);
    }

    @Override
    public List<Report> REPORT_SB_SK_SH_ZJB_RUN_LIST(String team, String equip, String time) {
        return reportSBSKSHMapper.REPORT_SB_SK_SH_ZJB_RUN_LIST(team,equip,time);
    }
//精尾设备空压机
    @Override
    public List<Report> REPORT_SB_JW_KYJ_RUN_LIST(String team, String equip, String time) {
        return reportSBJWKYJMapper.REPORT_SB_JW_KYJ_RUN_LIST(team,equip,time);
    }

    //精尾设备尾矿泵
    @Override
    public List<Report> REPORT_SB_JW_WSB_RUN_LIST(String team, String equip, String time) {
        return reportSBJWKYJMapper.REPORT_SB_JW_WSB_RUN_LIST(team,equip,time);
    }
    //精尾设备回水
    @Override
    public List<Report> REPORT_SB_JW_HS_RUN_LIST(String team, String equip, String time) {
        return reportSBJWKYJMapper.REPORT_SB_JW_HS_RUN_LIST(team,equip,time);
    }
    //精尾设备浓密
    @Override
    public List<Report> REPORT_SB_JW_NMJ_RUN_LIST(String team, String equip, String time) {
        return reportSBJWKYJMapper.REPORT_SB_JW_NMJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_SB_JW_NMJ_LXB_RUN_LIST(String team, String equip, String time) {
        return reportSBJWKYJMapper.REPORT_SB_JW_NMJ_LXB_RUN_LIST(team,equip,time);
    }

    //精尾设备压滤机
    @Override
    public List<Report> REPORT_SB_JW_YLJ_RUN_LIST(String team, String equip, String time) {
        return reportSBJWYLGLJMapper.REPORT_SB_JW_YLJ_RUN_LIST(team,equip,time);
    }
    //精尾设备过滤机
    @Override
    public List<Report> REPORT_SB_JW_GLJ_RUN_LIST(String team, String equip, String time) {
        return reportSBJWYLGLJMapper.REPORT_SB_JW_GLJ_RUN_LIST(team,equip,time);
    }




//电仪碎矿
    @Override
    public List<Report> REPORT_DY_SK_ZBEP_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_SK_ZBEP_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_SK_24PD_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_SK_24PD_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_SK_SHSS_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_SK_SHSS_RUN_LIST(team,equip,time);
    }
 //    磨浮
    @Override
    public List<Report> REPORT_DY_MF_GFJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_GFJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_PDZB_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_PDZB_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_3MSH_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_3MSH_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_FXB_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_FXB_RUN_LIST(team,equip,time);
    }
    //    磨机
    @Override
    public List<Report> REPORT_DY_MF_ZMJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_ZMJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_QMJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_QMJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_BZMJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_BZMJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_MF_FXJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_MF_FXJ_RUN_LIST(team,equip,time);
    }
//    精尾
    @Override
    public List<Report> REPORT_DY_JW_NMJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_JW_NMJ_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_JW_YLGL_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_JW_YLGL_RUN_LIST(team,equip,time);
    }
    @Override
    public List<Report> REPORT_DY_JW_KYJ_RUN_LIST(String team, String equip, String time) {
        return reportDYSKMapper.REPORT_DY_JW_KYJ_RUN_LIST(team,equip,time);
    }

    @Resource
    private ReportSCMFMapper reportSCMFMapper;



//生产磨浮皮带岗
    @Override
    public List<Report> REPORT_SC_MF_PDG_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCMFMapper.REPORT_SC_MF_PDG_RUN_LIST(team,equip,time,duty);
    }

//生产磨浮浮选岗
    @Override
    public List<Report> REPORT_SC_MF_FXG_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCMFMapper.REPORT_SC_MF_FXG_1_RUN_LIST(team,equip,time,duty);
    }
    @Override
    public List<Report> REPORT_SC_MF_FXG_2_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCMFMapper.REPORT_SC_MF_FXG_2_RUN_LIST(team,equip,time,duty);
    }

    //生产磨浮磨矿岗
    @Override
    public List<Report> REPORT_SC_MF_MKG_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCMFMapper.REPORT_SC_MF_MKG_1_RUN_LIST(team,equip,time,duty);
    }
    @Override
    public List<Report> REPORT_SC_MF_MKG_2_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCMFMapper.REPORT_SC_MF_MKG_2_RUN_LIST(team,equip,time,duty);
    }


    @Resource
    private ReportSCSKMapper reportSCSKMapper;
//生产碎矿皮带岗
    @Override
    public List<Report> REPORT_SC_SK_PSG_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCSKMapper.REPORT_SC_SK_PSG_RUN_LIST(team,equip,time,duty);
    }

//生产碎矿石灰岗
    @Override
    public List<Report> REPORT_SC_SK_SHG_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCSKMapper.REPORT_SC_SK_SHG_1_RUN_LIST(team,equip,time,duty);
    }

//生产碎矿石灰岗
    @Override
    public List<Report> REPORT_SC_SK_PDG_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCSKMapper.REPORT_SC_SK_PDG_1_RUN_LIST(team,equip,time,duty);
    }
    @Resource
    private ReportSCJWMapper reportSCJWMapper;
//生产精尾回水
    @Override
    public List<Report> REPORT_SC_JW_HSG_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCJWMapper.REPORT_SC_JW_HSG_1_RUN_LIST(team,equip,time,duty);
    }
//生产精尾压滤机岗
    @Override
    public List<Report> REPORT_SC_JW_YLJ_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCJWMapper.REPORT_SC_JW_YLJ_1_RUN_LIST(team,equip,time,duty);
    }
//生产精尾过滤机岗
    @Override
    public List<Report> REPORT_SC_JW_GLJ_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCJWMapper.REPORT_SC_JW_GLJ_1_RUN_LIST(team,equip,time,duty);
    }
//生产精尾过滤机岗
    @Override
    public List<Report> REPORT_SC_JW_KYJ_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCJWMapper.REPORT_SC_JW_KYJ_1_RUN_LIST(team,equip,time,duty);
    }
//生产精尾尾砂泵岗
    @Override
    public List<Report> REPORT_SC_JW_WSB_1_RUN_LIST(String team, String equip, String time,String duty) {
        return reportSCJWMapper.REPORT_SC_JW_WSB_1_RUN_LIST(team,equip,time,duty);
    }

//    ======================设备周期报表=======================================
    @Resource
    private ReportWeekMapper reportWeekMapper;
    @Override
    public List<Report> REPORT_WEEK_SPOT_LIST(String workShop, String team, String equip, String startTime, String endTime) {
        return reportWeekMapper.REPORT_WEEK_SPOT_LIST(workShop, team, equip, startTime, endTime);
    }

    @Override
    public List<Report> REPORT_WEEK_SK_YS_RUN_LIST(String workShop, String team, String equip, String startTime, String endTime) {
        return reportWeekMapper.REPORT_WEEK_SK_YS_RUN_LIST(workShop, team, equip, startTime, endTime);
    }

    @Override
    public List<Report> REPORT_WEEK_DEAL_LIST(String workShop, String team, String equip, String startTime, String endTime) {
        return reportWeekMapper.REPORT_WEEK_DEAL_LIST(workShop, team, equip, startTime, endTime);
    }



//    ===============工段日报表===========================
    @Resource
    private WorkShopReportMapper workShopReportMapper;
    @Override
    public List<Report> workShop_report_spot_zong_list(String workshop, String startTime,String endTime) {
        return workShopReportMapper.workShop_report_spot_zong_list(workshop,startTime,endTime);
    }
    @Override
    public List<Report> workShop_report_spot_fen_list(String workshop, String startTime,String endTime) {
        return workShopReportMapper.workShop_report_spot_fen_list(workshop,startTime,endTime);
    }
    @Override
    public List<Report> workShop_report_deal_list(String workshop, String startTime,String endTime) {
        return workShopReportMapper.workShop_report_deal_list(workshop,startTime,endTime);
    }


    //============================查询点检结果，多级联锁==============================
    @Resource
    private InterlockingMapper interlockingMapper;
    @Override
    public List<Interlocking> Interlocking_get_deptName() {
        return interlockingMapper.Interlocking_get_deptName();
    }
    @Override
    public List<Interlocking> Interlocking_get_routeName() {
        return interlockingMapper.Interlocking_get_routeName();
    }
    @Override
    public List<Interlocking> Interlocking_get_zoneName() {
        return interlockingMapper.Interlocking_get_zoneName();
    }
    @Override
    public List<Interlocking> Interlocking_get_devName() {
        return interlockingMapper.Interlocking_get_devName();
    }
    @Override
    public List<Interlocking> Interlocking_get_scPart() {
        return interlockingMapper.Interlocking_get_scPart();
    }
    @Override
    public List<Interlocking> Interlocking_get_content() { return interlockingMapper.Interlocking_get_content(); }
//查询点检结果
    @Override
    public List<Interlocking> Interlocking_get_result(String deptName, String route, String zone, String equip, String part, String content, String startTime,
                                                      String endTime,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,String wjCheck,Integer startPage,Integer numPerPage) {
        return interlockingMapper.Interlocking_get_result(deptName,route,zone,equip,part,content,startTime,endTime ,zcCheck,bjCheck,bjType1, bjType2, bjType3,wjCheck,startPage, numPerPage);

    }

    @Override
    public List<ConfigUser> search_config_alarm_liable_all() {
        return interlockingMapper.search_config_alarm_liable_all();
    }

    //查询结果数量
    @Override
    public Integer Interlocking_get_result_total(String deptName, String route, String zone, String equip, String part, String content, String startTime,
                                                 String endTime,String zcCheck,String bjCheck,String bjType1,String bjType2,String bjType3,String wjCheck) {
        return interlockingMapper.Interlocking_get_result1_total(deptName,route,zone,equip,part,content,startTime,endTime ,zcCheck,bjCheck, bjType1, bjType2, bjType3,wjCheck);
    }


    @Resource
    private MaintenanceMapper maintenanceMapper;
    @Override
    public List<Maintenance> pc_get_MaintenanceResult(String deptName, String routeName, String zoneName, String devName, String startTime, String endTime, String dealResult) {

        return maintenanceMapper.pc_get_MaintenanceResult(deptName,routeName,zoneName,devName,startTime,endTime ,dealResult);
    }



    @Override
    public Integer Interlocking_changeAlarmPersonLiable(String resultId, String alarm_personLiable) {
        return  interlockingMapper.Interlocking_changeAlarmPersonLiable(resultId, alarm_personLiable);
    }

    @Override
    public Integer Interlocking_changeAlarmType(String resultId, String alarmType, String userName,String selectDepart) {
//        System.out.println(resultId+"=="+alarmType+"=="+userName+"=="+selectDepart);
        return interlockingMapper.Interlocking_changeAlarmType(resultId,alarmType,userName,selectDepart);
    }

    @Override
    public List<Interlocking> Interlocking_get_byId_result(String resultId) {
        return interlockingMapper.Interlocking_get_byId_result(resultId);
    }

    @Override
    public List<Interlocking> Interlocking_get_temp_result(String deptName, String routeName, String zoneName, String devName, String scPart, String scContent, String stdValue, String altpid) {
        return interlockingMapper.Interlocking_get_temp_result(deptName,routeName,zoneName,devName,scPart,scContent,stdValue,altpid);
    }

    @Override
    public Integer Interlocking_update_temp_result(String deptName, String routeName, String zoneName, String devName, String scPart, String scContent, String altpid, String stdValue, String alarmType, String userName, String selectDepart) {
        return interlockingMapper.Interlocking_update_temp_result(deptName,routeName,zoneName,devName,scPart,scContent,stdValue,altpid,alarmType,userName,selectDepart);
    }

    @Override
    public Integer Interlocking_insert_temp_result(String deptName, String routeName, String zoneName, String devName, String scPart, String scContent, String altpid, String stdValue, String alarmType, String userName, String selectDepart) {
        return interlockingMapper.Interlocking_insert_temp_result(deptName,routeName,zoneName,devName,scPart,scContent,stdValue,altpid,alarmType,userName,selectDepart);
    }

    @Override
    public Integer Interlocking_update_alarm_result(String deptName, String routeName, String zoneName, String devName, String scPart, String scContent, String alarm_manage) {
        return interlockingMapper.Interlocking_update_alarm_result(deptName,routeName,zoneName,devName,scPart,scContent,alarm_manage);
    }

    //    =======================app测试==================================
    @Resource
    private AppMapper appMapper;
//    点检结果获取
    @Override
    public List<AppReport> App_Spot_Result(String deptName,String job,String dateTime) { return appMapper.App_Spot_Result(deptName,job,dateTime); }

    @Override
    public List<Interlocking> app_get_dxjSearchResult(String deptName, String route, String zone, String startTime, String endTime) {
        return appMapper.app_get_dxjSearchResult(deptName, route, zone,  startTime, endTime );
    }

    //  登录
    @Override
    public List<AppLoginUser> app_user_login(String userName,  String cycleContentDate) { return appMapper.app_user_login(userName,cycleContentDate); }

    @Override
    public List<AppLoginUser> app_user_login1(String userName, String passWord) {
        return appMapper.app_user_login1(userName,passWord);
    }

    @Override
    public List<AppLoginUser> app_user_getjjbID(String deptName, String job) {
        return appMapper.app_user_getjjbID(deptName,job);
    }

    //获取交接班周期
    @Override
    public List<AppCycle> app_user_getCycle(String userName) { return appMapper.app_user_getCycle(userName); }

//磨矿岗dcs数据
    @Override
    public List<AppDCS> app_jjb_dcs_mk(String mj,String metaStartTime,String metaEndTime) { return appMapper.app_jjb_dcs_mk(mj,metaStartTime,metaEndTime); }
//交接班手动填写内容
    @Override
    public Integer app_jjb_write(String dateTime, String job, String jjbTagName, String jjbValue) { return appMapper.app_jjb_write(dateTime,job,jjbTagName,jjbValue); }

    @Override
    public List<AppDemandWriteData> app_jjb_getspotWrite(String job, String equip, String metaStartTime,String metaEndTime,Integer meta) {
        return appMapper.app_jjb_getspotWrite(job,equip, metaStartTime,metaEndTime,meta);
    }

    //交接班需添加数据
    @Override
    public List<AppDemandWriteData> app_jjb_getDemandWrite(String job,String equip) { return appMapper.app_jjb_getDemandWrite(job,equip); }
//   获取手动填写需检查的内容
    @Override
    public List<AppDemandWriteData> app_jjb_getemandSpotWrite(String job, String equip,String meta) { return appMapper.app_jjb_getemandSpotWrite(job,equip,meta); }

    @Override
    public List<AppDemandWriteData> app_jjb_getWriteData(String field, String metaStartTime) {
        return appMapper.app_jjb_getWriteData(field,metaStartTime);
    }

    @Override
    public Boolean app_jjb_updateWriteData(String field, String value, String metaStartTime) {
        return appMapper.app_jjb_updateWriteData(field,value,metaStartTime);
    }

    //获取交接班手动填写内容
    @Override
    public List<AppDemandWriteData> app_jjb_getWrite(String job,String equip) { return appMapper.app_jjb_getWrite(job,equip); }

// 交班内容填写
    @Override
    public Integer app_shift_duty_handover(String dataTime,String id,  String deptName, String job, String handoverTeam, String handoverDuty, String handoverName, String handoverContent) { return appMapper.app_shift_duty_handover(dataTime,id,deptName,job,handoverTeam,handoverDuty,handoverName,handoverContent); }
// 获取下个班人员信息
    @Override
    public List<AppLoginUser> app_jjb_getNextUser(String date, String job, String meta) { return appMapper.app_jjb_getNextUser(date,job,meta); }
// 接班数据填写
    @Override
    public Integer app_shift_duty_succession(String dataTime, String id,  String succeedTeam, String succeedDuty, String succeedName, String succeedContent) { return appMapper.app_shift_duty_succession(dataTime,id, succeedTeam, succeedDuty,succeedName,succeedContent); }

    @Override
    public Integer app_set_maintenance(String deptName, String routeName, String zoneName, String devName, String description, String pic, String discoverer, String phone) {
        return appMapper.app_set_maintenance(deptName,routeName,zoneName,devName,description,pic,discoverer,phone);
    }

    // 获取状态量的值
    @Override
    public List<AppDCS> app_jjb_getRunTime(String field, String startTime) { return appMapper.app_jjb_getRunTime(field,startTime); }

    @Override
    public List<AppDCS> app_jjb_getLastRunTime(String field, String startTime) { return appMapper.app_jjb_getLastRunTime(field,startTime); }

//    @Override
//    public String app_jjb_getDifferenceHour(String meta) {
//        return appMapper.app_jjb_getDifferenceHour(meta);
//    }
//     获取设备运行时间的字段
    @Override
    public List<AppDCS> app_jjb_getRunTimeField(String equip, String meta) { return appMapper.app_jjb_getRunTimeField(equip,meta); }


    @Resource
    private ConfigUserMapper configUserMapper;
    @Override
    public List<ConfigUser> get_dept_list() {
        return configUserMapper.get_dept_list();
    }

    @Override
    public List<TreeCode> get_dept_test_list() {
        return configUserMapper.get_dept_test_list();
    }
    @Override
    public List<ConfigUser> get_dept_user_list() {
        return configUserMapper.get_dept_user_list();
    }

    @Override
    public List<ConfigUser> get_dept_user_ll_list(String equipId) {
        return configUserMapper.get_dept_user_ll_list(equipId);
    }

    // 存储人员管理部门数据
    @Override
    public Integer set_config_partment_user(String deptName, String deptId, String user, String userId, String department,String alarmType,String team) {
        return configUserMapper.set_config_partment_user(deptName,deptId,user,userId,department,alarmType,team);
    }
    // 判断当前人员是否有管理部门
    @Override
    public List<ConfigUser> search_config_partment_user(String userId,String alarmType,String team) {
        return configUserMapper.search_config_partment_user(userId, alarmType,team);
    }
// 判断当前人员已有管理部门，对其更新
    @Override
    public Integer update_config_partment_user(String deptName, String deptId, String user, String userId, String department,String alarmType,String team) {
        return configUserMapper.update_config_partment_user(deptName,deptId,user,userId,department,alarmType,team);
    }
//获取当前部门下的责任人
    @Override
    public List<ConfigUser> search_config_liable_user(String workshopId) {
        return configUserMapper.search_config_liable_user(workshopId);
    }

    @Override
    public Integer delete_liable_user(String department, String userId,String team) {
        return configUserMapper.delete_liable_user(department,userId,team);

    }

    //=========================配置====管理人员配置========================
    @Override
    public List<ConfigUser> search_config_alarm_manage(String userId) { return configUserMapper.search_config_alarm_manage(userId); }

    @Override
    public Integer set_config_alarm_manage(String deptName, String deptId, String user, String userId,String manageDepart) { return configUserMapper.set_config_alarm_manage(deptName,deptId,user,userId,manageDepart); }

    @Override
    public Integer update_config_alarm_manage(String deptName, String deptId, String user, String userId,String manageDepart) { return configUserMapper.update_config_alarm_manage(deptName,deptId,user,userId,manageDepart); }

    @Override
    public List<ConfigUser> search_config_alarm_manage_exist() {
        return configUserMapper.search_config_alarm_manage_exist();
    }

    @Override
    public List<ConfigUser> search_config_alarm_manage_user(String userName ,String part) {
        return configUserMapper.search_config_alarm_manage_user(userName,part);
    }

    @Override
    public Integer delete_user(String userId) {
        return configUserMapper.delete_user(userId);
    }
//===================自动执行报警类型设定==================
    @Override
    public List<Interlocking> Interlocking_get_all_alarm_byDay() {
        return interlockingMapper.Interlocking_get_all_alarm_byDay();
    }

    @Override
    public List<Interlocking> Interlocking_get_all_alarmType() {
        return interlockingMapper.Interlocking_get_all_alarmType();
    }

}
