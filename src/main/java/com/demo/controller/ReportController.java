package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.model.report.Report;
import com.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    private IndexService indexService;


    // 报表
    @PostMapping("/report/day")
    @ResponseBody
    public Map<String,Object> report_mk_mj_Url(@RequestBody Map<String, String> params) throws UnsupportedEncodingException {

        //   获取参数
        String workshop = params.get("workshop");
        String team = params.get("team");
        String equip = params.get("equip");
        String time = params.get("time");
        String duty = params.get("duty_name");
//        System.out.println(workshop+"=="+team+"++"+equip+"++"+time+"=="+duty);
        List<Report>    spotData = indexService.REPORT_SB_SPOT_LIST(workshop,team, equip, time,duty);    // 点检统计数据
        List<Report>  dealData= indexService.REPORT_SB_DEAL_LIST(workshop,team, equip, time,duty);      //报警处理数据

        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");

    //判断工段、班组、设备、值次
// ========================非电仪工段======================================================
        if(!workshop.equals("电仪工段")){
// =================================工段设备====================================================
            if(team.equals("碎矿设备")||team.equals("磨浮设备")||team.equals("精尾设备")) {
                //=-==============================碎矿================================
                if (equip.equals("重板")) {
                    List<Report> equipRun1 = indexService.REPORT_SB_SK_ZB_RUN_LIST(team, equip, time);  //重板设备运行状况数据
                    List<Report> equipRun2 = indexService.REPORT_SB_SK_ZB_PD1_RUN_LIST(team, equip, time);  //1#皮带设备运行状况数据
                    equipRun1.addAll(equipRun2);
                    map.put("equipRun", equipRun1);
                } else if (equip.equals("颚破")) {
                    List<Report> equipRun1 = indexService.REPORT_SB_SK_EP_RUN_LIST(team, equip, time);  //颚破设备运行状况数据
                    List<Report> equipRun2 = indexService.REPORT_SB_SK_EP_CC_RUN_LIST(team, equip, time);  //除尘风机设备运行状况数据
                    equipRun1.addAll(equipRun2);
                    map.put("equipRun", equipRun1);
                } else if (equip.equals("2#皮带")) {
                    List<Report> equipRun1 = indexService.REPORT_SB_SK_PD2_RUN_LIST(team, equip, time);  //设备运行状况数据
                    map.put("equipRun", equipRun1);
                } else if (equip.equals("4#皮带")) {
                    List<Report> equipRun1 = indexService.REPORT_SB_SK_PD4_RUN_LIST(team, equip, time);  //设备运行状况数据

                    map.put("equipRun", equipRun1);
                } else if (equip.equals("石灰制乳输送")) {
                    List<Report> equipRun1 = indexService.REPORT_SB_SK_SH_LSLC_RUN_LIST(team, equip, time);  //立式料仓设备运行状况数据
                    List<Report> equipRun2 = indexService.REPORT_SB_SK_SH_GLJ_RUN_LIST(team, equip, time);  //给料机设备运行状况数据
                    List<Report> equipRun3 = indexService.REPORT_SB_SK_SH_3M_RUN_LIST(team, equip, time);  //3m搅拌桶设备运行状况数据
                    List<Report> equipRun4 = indexService.REPORT_SB_SK_SH_4M_RUN_LIST(team, equip, time);  //4m搅拌桶设备运行状况数据
                    List<Report> equipRun5 = indexService.REPORT_SB_SK_SH_ZJB_RUN_LIST(team, equip, time);  //渣浆泵设备运行状况数据
                    equipRun1.addAll(equipRun2);
                    equipRun1.addAll(equipRun3);
                    equipRun1.addAll(equipRun4);
                    equipRun1.addAll(equipRun5);
                    map.put("equipRun", equipRun1);
                }
                //  ================================磨浮=====================================
                else if (equip.equals("再磨机")) {
                    List<Report> equipRun = indexService.REPORT_SB_MK_ZMJ_RUN_LIST(team, equip, time);  //设备运行状况数据
                    List<Report> equipRun1 = indexService.REPORT_SB_MK_MJ_ZJB_RUN_LIST(team, equip, time);  //设备运行状况数据
                    List<Report> dcsData = indexService.REPORT_SB_MK_ZMJ_DCS_LIST(team, equip, time);       //DCS数据
                    equipRun.addAll(equipRun1);
                    equipRun.addAll(dcsData);
                    if (equipRun.size() < 1) {
                        map.put("equipRun", dcsData);
                    } else {
                        map.put("equipRun", equipRun);
                    }
                } else if (equip.equals("球磨机")) {
                    List<Report> equipRun = indexService.REPORT_SB_MK_QMJ_RUN_LIST(team, equip, time);  //设备运行状况数据
                    List<Report> dcsData = indexService.REPORT_SB_MK_QMJ_DCS_LIST(team, equip, time);       //DCS数据
                    equipRun.addAll(dcsData);
                    map.put("equipRun", equipRun);
                } else if (equip.equals("半自磨机")) {
                    List<Report> equipRun = indexService.REPORT_SB_MK_BZMJ_RUN_LIST(team, equip, time);  //设备运行状况数据
                    List<Report> equipRun1 = indexService.REPORT_SB_MK_MJ_ZJB_RUN_LIST(team, equip, time);  //设备运行状况数据
                    List<Report> dcsData = indexService.REPORT_SB_MK_BZMJ_DCS_LIST(team, equip, time);       //DCS数据
                    equipRun.addAll(equipRun1);
                    equipRun.addAll(dcsData);
                    map.put("equipRun", equipRun);
                } else if (equip.equals("中板皮带")) {
                    List<Report> equipRun = indexService.REPORT_SB_MK_ZBPD_RUN_LIST(team, equip, time);  //中板皮带设备运行状况数据
                    map.put("equipRun", equipRun);
                } else if (equip.equals("浮选机")) {
                    List<Report> equipRun = indexService.REPORT_SB_FX_JBT_RUN_LIST(team, equip, time);  //鼓风机设备运行状况数据
                    List<Report> equipRun1 = indexService.REPORT_SB_FX_FXJ_RUN_LIST(team, equip, time);  //鼓风机设备运行状况数据
                    equipRun.addAll(equipRun1);
                    map.put("equipRun", equipRun);
                } else if (equip.equals("鼓风机")) {
                    List<Report> equipRun = indexService.REPORT_SB_FX_GFJ_RUN_LIST(team, equip, time);  //浮选泵设备运行状况数据
                    List<Report> equipRun1 = indexService.REPORT_SB_FX_FXZ_RUN_LIST(team, equip, time);  //浮选柱设备运行状况数据
                    equipRun.addAll(equipRun1);
                    map.put("equipRun", equipRun);
                } else if (equip.equals("浮选泵")) {
                    List<Report> equipRun = indexService.REPORT_SB_FX_DCB_RUN_LIST(team, equip, time);  //浮选泵设备运行状况数据
                    map.put("equipRun", equipRun);
                }

                //  =============================设备精尾===================================
                else if(equip.equals("空压机")){
                    List<Report> equipRun = indexService.REPORT_SB_JW_KYJ_RUN_LIST(team,equip,time);  //空压机设备运行状况数据
                    map.put("equipRun",equipRun);
                }
                else if(equip.equals("尾砂泵")){

                    List<Report> equipRun = indexService.REPORT_SB_JW_WSB_RUN_LIST(team,equip,time);  //尾砂泵设备运行状况数据
                    map.put("equipRun",equipRun);
                }
                else if(equip.equals("厂前回水泵")){
                    List<Report> equipRun = indexService.REPORT_SB_JW_HS_RUN_LIST(team,equip,time);  //回水泵设备运行状况数据
                    map.put("equipRun",equipRun);
                }
                else if(equip.equals("压滤机")){
                    List<Report> equipRun = indexService.REPORT_SB_JW_YLJ_RUN_LIST(team,equip,time);  //回水泵设备运行状况数据
                    map.put("equipRun",equipRun);
                }
                else if(equip.equals("过滤机")){
                    List<Report> equipRun = indexService.REPORT_SB_JW_GLJ_RUN_LIST(team,equip,time);  //回水泵设备运行状况数据
                    map.put("equipRun",equipRun);
                }
                else if(equip.equals("浓密机")){
                    List<Report> equipRun = indexService.REPORT_SB_JW_NMJ_RUN_LIST(team,equip,time);  //浓密机设备运行状况数据
                    List<Report> equipRun1 = indexService.REPORT_SB_JW_NMJ_LXB_RUN_LIST(team,equip,time);  //浓密机设备运行状况数据
                    equipRun.addAll(equipRun1);
                    map.put("equipRun",equipRun);
                }
            }
            // ================================生产=====================================
            else {
                // =========================================磨浮生产================================
                if (team.equals("磨浮生产")) {
                    if (equip.equals("皮带岗")) {
                        List<Report> equipRun = indexService.REPORT_SC_MF_PDG_RUN_LIST(team, equip, time, duty);  //皮带岗运行状况数据
                        map.put("equipRun", equipRun);

                    }
                    else  if (equip.equals("浮选岗")) {
                        List<Report> equipRun = indexService.REPORT_SC_MF_FXG_1_RUN_LIST(team, equip, time, duty);  //浮选岗运行状况数据
                        List<Report> equipRun1 = indexService.REPORT_SC_MF_FXG_2_RUN_LIST(team, equip, time, duty);  //浮选岗运行状况数据
                        equipRun.addAll(equipRun1);
                        map.put("equipRun", equipRun);

                    }
                    else {
                        List<Report> equipRun1 = indexService.REPORT_SC_MF_MKG_2_RUN_LIST(team, equip, time, duty);//磨矿岗运行状况数据
                        map.put("equipRun", equipRun1);
                    }
                }
                //=========================================== 碎矿生产===============================
                else if(team.equals("碎矿生产")){
                    if(equip.equals("破碎岗")){
                        List<Report> equipRun = indexService.REPORT_SC_SK_PSG_RUN_LIST(team, equip, time, duty);//破碎岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else  if (equip.equals("皮带岗")){
                        List<Report> equipRun = indexService.REPORT_SC_SK_PDG_RUN_LIST(team, equip, time, duty);//皮带岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else {
                        List<Report> equipRun = indexService.REPORT_SC_SK_SHG_RUN_LIST(team, equip, time, duty);//石灰岗运行状况数据

                        map.put("equipRun", equipRun);
                    }
                }
                //==========================================精尾生产==================================
                else {
                    if(equip.equals("回水岗")){
                        List<Report> equipRun = indexService.REPORT_SC_JW_HSG_1_RUN_LIST(team, equip, time, duty);//回水岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else  if(equip.equals("压滤机岗")){
                        List<Report> equipRun = indexService.REPORT_SC_JW_YLJ_1_RUN_LIST(team, equip, time, duty);//压滤机岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else  if(equip.equals("过滤机岗")){
                        List<Report> equipRun = indexService.REPORT_SC_JW_GLJ_1_RUN_LIST(team, equip, time, duty);//过滤机岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else  if(equip.equals("中心气站岗")){
                        List<Report> equipRun = indexService.REPORT_SC_JW_KYJ_1_RUN_LIST(team, equip, time, duty);//中心气站岗运行状况数据
                        map.put("equipRun", equipRun);
                    }
                    else {
                        List<Report> equipRun = indexService.REPORT_SC_JW_WSB_1_RUN_LIST(team, equip, time, duty);//尾砂泵运行状况数据
                        map.put("equipRun", equipRun);
                    }
                }
            }
        }
        // ===========================电仪工段==============================================
        else {
            //====================================碎矿================================
            if(equip.equals("重板颚破")){
                List<Report> equipRun = indexService.REPORT_DY_SK_ZBEP_RUN_LIST(team,equip,time);  //重板颚破运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("2#4#皮带")){
                List<Report> equipRun = indexService.REPORT_DY_SK_24PD_RUN_LIST(team,equip,time);  //2#4#皮带运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("石灰输送")){
                List<Report> equipRun = indexService.REPORT_DY_SK_SHSS_RUN_LIST(team,equip,time);  //石灰输送运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("鼓风机")){
                List<Report> equipRun = indexService.REPORT_DY_MF_GFJ_RUN_LIST(team,equip,time);  //鼓风机运行状况数据
                map.put("equipRun",equipRun);
            }
            //======================================精尾====================================
            else if(equip.equals("浓密机")){
                List<Report> equipRun = indexService.REPORT_DY_JW_NMJ_RUN_LIST(team,equip,time);  //浓密机运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("压滤过滤")){
                List<Report> equipRun = indexService.REPORT_DY_JW_YLGL_RUN_LIST(team,equip,time);  //压滤过滤运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("空压机")){
                List<Report> equipRun = indexService.REPORT_DY_JW_KYJ_RUN_LIST(team,equip,time);  //空压机运行状况数据
                map.put("equipRun",equipRun);
            }
            //========================================磨浮========================================
            else if(equip.equals("皮带中板")){
                List<Report> equipRun = indexService.REPORT_DY_MF_PDZB_RUN_LIST(team,equip,time);  //皮带中板运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("3M石灰")){
                List<Report> equipRun = indexService.REPORT_DY_MF_3MSH_RUN_LIST(team,equip,time);  //3M石灰运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("浮选泵")){
                List<Report> equipRun = indexService.REPORT_DY_MF_FXB_RUN_LIST(team,equip,time);  //浮选泵运行状况数据
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("再磨机")){
                List<Report> equipRun = indexService.REPORT_DY_MF_ZMJ_RUN_LIST(team,equip,time); //再磨机运行状况数据
                List<Report> equipRun1 = indexService.REPORT_DY_MF_MJ_DCS_RUN_LIST(team,equip,time); //再磨机DCS数据

                if (equipRun1.size()>0){
                    equipRun.addAll(equipRun1);}
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("球磨机")){
                List<Report> equipRun = indexService.REPORT_DY_MF_QMJ_RUN_LIST(team,equip,time); //球磨机运行状况数据
                List<Report> equipRun1 = indexService.REPORT_DY_MF_MJ_DCS_RUN_LIST(team,equip,time); //球磨机DCS数据

                if (equipRun1.size()>0){
                    equipRun.addAll(equipRun1);}
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("半自磨机")){
                List<Report> equipRun = indexService.REPORT_DY_MF_BZMJ_RUN_LIST(team,equip,time); //半自磨机运行状况数据
                List<Report> equipRun1 = indexService.REPORT_DY_MF_MJ_DCS_RUN_LIST(team,equip,time); //半自磨机DCS数据

                if (equipRun1.size()>0){
                equipRun.addAll(equipRun1);}
                map.put("equipRun",equipRun);
            }
            else if(equip.equals("浮选机")){
                List<Report> equipRun = indexService.REPORT_DY_MF_FXJ_RUN_LIST(team,equip,time);  //浮选机运行状况数据
                map.put("equipRun",equipRun);
            }
        }
        map.put("spotData",spotData);
        map.put("dealData",dealData);
        return map;
    }


}