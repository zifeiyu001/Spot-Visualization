package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.equip.detailedData;
import com.demo.model.index.*;
import com.demo.model.universal.LoginUser;
import com.demo.model.universal.WebDxjBj;
import com.demo.service.IndexService;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.demo.model.universal.HttpUtil.sendJsonWithPost;

/**
 */

@Controller
public class IndexController {
    // 首页
    @Autowired
    private IndexService indexService;



/*======================index页面点检数据统计=========================*/
    //    生产数据
    @RequestMapping(value = "/spot/index_sc", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getINDEX_SC_LIST() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.INDEX_SC_LIST("model"));
        return map;
    }
    //    电仪数据
    @RequestMapping(value = "/spot/index_dy", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getINDEX_DY_LIST() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.INDEX_DY_LIST("model"));
        return map;
    }
    //    设备数据
    @RequestMapping(value = "/spot/index_sb", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getINDEX_SB_LIST() {
        List<SpotStatistics> model = indexService.INDEX_SB_LIST("model");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.INDEX_SB_LIST("model"));

        return map;
    }

    //    设备数据
    @RequestMapping(value = "/spot/index/monthlysSotStatistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getMonthlysSotStatistics() {
        List<SpotStatistics> moonthlysSotStatistics =indexService.getMonthlysSotStatistics();
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", moonthlysSotStatistics);

        return map;
    }
/*=========================index页面实时展示=============================*/

    @RequestMapping(value = "/index/indexShow", method = RequestMethod.GET)
    @ResponseBody
    public String index() throws JSONException {
        List<IndexShow> indexShows = indexService.INDEX_SHOW_LIST();
        List<IndexShow> indexShows1 = indexService.INDEX_SHOW1_LIST();
        int kw=0;
    //   ======判断获取的值是否为空
        if(indexShows1.get(0)==null){
            kw=0;
        }
        else {
            kw=indexShows1.get(0).getKw();
        }
        JSONArray jsonArray = new JSONArray();
        for(IndexShow indexShow: indexShows){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("total",indexShow.getTotal());
            jsonObject.put("danger",indexShow.getDanger());
            jsonObject.put("alarm",indexShow.getAlarm());
            jsonObject.put("kw",kw);
            jsonArray.add(jsonObject);
        }
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("msg","ok");
        jsonObject2.put("data",jsonArray);
        return jsonObject2.toString();
    }
/*===========================index页面流程图实时数据===============================*/
    @RequestMapping(value = "/index/indexChartData", method = RequestMethod.GET)
    @ResponseBody
    public String indexs() throws JSONException {
    //        获取流程数据
        List<IndexFlowChartData> indexFlowChartDatas  = indexService.INDEX_FLOW_CHART_DATA_LIST();
        List<IndexFlowChartData> indexFlowChartData2s = indexService.INDEX_FLOW_CHART_DATA2_LIST();
        indexFlowChartDatas.addAll(indexFlowChartData2s);
        JSONArray jsonArray = new JSONArray();

        for(IndexFlowChartData indexFlowChartData: indexFlowChartDatas){
            JSONObject jsonObject = new JSONObject();
            if (indexFlowChartData2s.get(0)!=null)
            {jsonObject.put("water",indexFlowChartData2s.get(0).getWater());}
            else jsonObject.put("water",0);

            if(indexFlowChartData!=null) {
                if (indexFlowChartData.getCu() != null)
                    jsonObject.put("Cu", indexFlowChartData.getCu());
                else jsonObject.put("Cu", 0);
                if (indexFlowChartData.getWCu() != null)
                    jsonObject.put("WCu", indexFlowChartData.getWCu());
                else jsonObject.put("WCu", 0);
                if (indexFlowChartData.getWS() != null)
                    jsonObject.put("WS", indexFlowChartData.getWS());
                else jsonObject.put("WS", 0);
                if (indexFlowChartData.getCuCu() != null)
                    jsonObject.put("CuCu", indexFlowChartData.getCuCu());
                else jsonObject.put("CuCu", 0);
                if (indexFlowChartData.getCLL() != null)
                    jsonObject.put("CLL", indexFlowChartData.getCLL());
                else jsonObject.put("CLL", 0);
                if (indexFlowChartData.getNDJ1ND() != null)
                    jsonObject.put("NDJ1ND", indexFlowChartData.getNDJ1ND());
                else jsonObject.put("NDJ1ND", 0);

            }
            jsonArray.add(jsonObject);
//            jsonArray.put(jsonObject);
        }
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("msg","");
        jsonObject2.put("data",jsonArray);
        return jsonObject2.toString();
    }





// ======================通用报警处理=============================
    @PostMapping("/spot/Universal/alarm/update")
    @ResponseBody
    public JSONObject  getIndex(@RequestBody Map<String, String> params, HttpServletRequest request) throws UnsupportedEncodingException {
        String id = params.get("id");
        String remark = params.get("remark");
        List<WebDxjBj> webDxjBjs = indexService.search_alarm_id(id);//获取报警表中报警数据id

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String userId = (String)session.getAttribute("userId");

        WebDxjBj webDxjBj = webDxjBjs.get(0);
        webDxjBj.setAlarm_remark(remark);
        webDxjBj.setUser_id(userId);
        webDxjBj.setUser_name(username);
        webDxjBj.setCj("bj_xk_up");
        JSONObject parseObject = JSON.parseObject(JSON.toJSONString(webDxjBj));

        String str = sendJsonWithPost("http://localhost:8080/bkzyCMS/webservice/upDxjBj", parseObject, "utf-8");
        return JSON.parseObject(str);
    }





// =====================通用判断用户是否存在=================================
    @PostMapping("/spot/user")
    @ResponseBody
    public Map<String,Object>  getUser(@RequestBody Map<String, String> params, HttpServletRequest request) throws UnsupportedEncodingException {
        String name = params.get("name");
        LoginUser login_name = indexService.get_login_name(name);

        Map<String,Object> map = new HashMap<>();
        if (login_name!=null){
            //创建session对象
            HttpSession session = request.getSession();
            //把用户数据保存在session域对象中,用户账号
            session.setAttribute("username", name);//用户账号、ID
            session.setAttribute("user", login_name.getUsername());// 用户名
            session.setAttribute("userdept",login_name.getDeptName());//用户部门
            session.setMaxInactiveInterval(3600);
            map.put("msg", "ok");
            map.put("data", login_name.getUsername());
            map.put("deptdata", login_name.getDeptName());
        }
        else {
            map.put("data","");
        }
        return map;
    }

/*===============================磨矿工艺页面========================================*/

    /*磨矿缺陷数据*/
    @RequestMapping(value = "/process/grindingFloat/mf_1_defect_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSection_Defect_Stat_MF_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MF_1_DEFECT_TREATMENT_LIST());
        return map;
    }
    // 磨矿加球统计
    @RequestMapping(value = "/process/grinding/mk_1_ball_statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSection_Defect_Treat_MF_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MK_1_BALL_STATISTICS_LIST());
        return map;
    }

    /*磨矿报警数据*/
    @RequestMapping(value = "/spot/mk/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MK_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MF_1_ALARM_LIST());
        return map;
    }


    /* 磨浮生产数据*/
    @RequestMapping(value = "/process/grindingFloat/mf_1_production", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_prod_MF_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MF_1_PRODUCTION_LIST());
        return map;
    }
    /*磨浮点检数据*/
    @RequestMapping(value = "/process/grindingFloat/mf_1_spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MF_1_SPOT_LIST());
        return map;
    }



//===============================半自磨机页面========================================
    /*半自磨机点巡检数据*/
    @RequestMapping(value = "/equipment/SpotBzmj", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_Bzmj_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_BZMJ_LIST());
        return map;
    }


    /*半自磨机报警数据*/
    @RequestMapping(value = "/spot/mk/bzmj/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Bzmj_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_ZBMJ_LIST());
        return map;
    }

    /*半自磨机点检详细数据*/
    @RequestMapping(value = "/spot/mk/bzmj/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Bzmj_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_MK_BZMJ_MF_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_MK_BZMJ_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_MK_BZMJ_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


//====================================再磨机页面=====================================
    //再磨机点巡检数据
    @RequestMapping(value = "/equipment/SpotZmj", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_Zmj_Url() {
        Map<String,Object> map = new HashMap<>();
        List<SpotStatistics> spotStatistics = indexService.SPOT_ZMJ_LIST();
        System.out.println(spotStatistics.get(0).getSection());
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_ZMJ_LIST());
        return map;
    }

    /*再磨机报警数据*/
    @RequestMapping(value = "/spot/mk/zmj/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Zmj_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_ZMJ_LIST());
        return map;
    }

    /*再磨机点检详细数据*/
    @RequestMapping(value = "/spot/mk/zmj/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Zmj_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_MK_ZMJ_MK_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_MK_ZMJ_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_MK_ZMJ_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

//===========================球磨机页面==================================
    //球磨机点巡检数据
    @RequestMapping(value = "/equipment/SpotQmj", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_Qmj_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_QMJ_LIST());
        return map;
    }
    /*球磨机报警数据*/
    @RequestMapping(value = "/spot/mk/qmj/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Qmj_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_QMJ_LIST());
        return map;
    }
    //球磨机详细数据
    @RequestMapping(value = "/spot/mk/qmj/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Qmj_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_MK_QMJ_MK_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_MK_QMJ_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_MK_QMJ_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


//========================5#皮带页面===============================================
    /*皮带报警数据*/
    @RequestMapping(value = "/spot/mk/pd/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_PD_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MK_PD_ALARM_LIST());
        return map;
    }
    //    点检统计
    @RequestMapping(value = "/spot/mk/pd/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_PD_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_PD_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/mk/gkfj/pd/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Gkfj_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GKFJ_MK_DETAILED_PD_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_GKFJ_DY_DETAILED_PD_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GKFJ_SC_DETAILED_PD_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }



//================================磨浮中板页面================================
    /*重板报警数据*/
    @RequestMapping(value = "/spot/mk/zb/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MK_ZB_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MK_ZB_ALARM_LIST());
        return map;
    }
    //    点检统计
    @RequestMapping(value = "/spot/mk/zb/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MK_ZB_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_ZB_LIST());
        return map;
    }
    //    详细数据
    @RequestMapping(value = "/spot/mk/gkfj/zb/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Gkfj_ZB_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GKFJ_MK_DETAILED_ZB_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_GKFJ_DY_DETAILED_ZB_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GKFJ_SC_DETAILED_ZB_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

//==================================水力旋流器页面======================================
    /*旋流器报警数据*/
    @RequestMapping(value = "/spot/mk/xlq/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_XLQ_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.MK_XLQ_ALARM_LIST());
        return map;
    }
    //    点检统计
    @RequestMapping(value = "/spot/mk/xlq/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MK_XLQ_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_XLQ_LIST());
        return map;
    }
    //    详细数据
    @RequestMapping(value = "/spot/mk/gkfj/xlq/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_MF_Gkfj_XLQ_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GKFJ_MK_DETAILED_XLQ_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GKFJ_SC_DETAILED_XLQ_LIST();
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);

    }


    /*================浮选工艺============================================*/
    /*点检统计*/
    @RequestMapping(value = "/process/grindingFloat/fx_1_spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_1_SPOT_LIST());
        return map;
    }
    /*缺陷处理*/
    @RequestMapping(value = "/process/float/FX_1_defect_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX1_Defects_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_1_DefectTreatment_LIST());
        return map;
    }
    /*工艺数据*/
    @RequestMapping(value = "/process/float/FX_1_PV_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX1_xxx_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_1_PV_LIST());
        return map;
    }
    //    报警数据
    @RequestMapping(value = "/spot/fx/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAlarm_fx_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_1_ALARM_LIST());
        return map;
    }


    /*================================1#鼓风机=================================*/
    //点检统计
    @RequestMapping(value = "/equipment/SpotGfj1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_fx_gfj1_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ1_SPOT_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/spot/fx/gfj1/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj1_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ_1_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/gfj1/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj1_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GFJ1_MK_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_GFJ1_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GFJ1_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


    /*================================2#鼓风机================================*/
    //点检统计
    @RequestMapping(value = "/equipment/SpotGfj2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_fx_gfj2_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ2_SPOT_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/spot/fx/gfj2/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj2_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ_2_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/gfj2/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj2_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GFJ2_MK_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_GFJ2_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GFJ2_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

    /*==================================3#鼓风机==================================*/

    //点检统计
    @RequestMapping(value = "/equipment/SpotGfj3", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_fx_gfj3_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ3_SPOT_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/spot/fx/gfj3/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj3_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.FX_GFJ_3_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/gfj3/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_Gfj3_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SPOT_GFJ3_MK_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_GFJ3_DY_LIST();
        List<detailedData> detailedData3 = indexService.SPOT_GFJ3_SC_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

    /*==================================浮选机==================================*/

    //点检统计
    @PostMapping(value = "/equipment/fx/fxj")
    @ResponseBody
    public Map<String,Object> getSpot_fx_fxj_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FXJ_LIST(equip));
        return map;
    }
    //报警数据
    @PostMapping(value = "/spot/fx/fxj/alarm")
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_fxj_Alarm_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");

        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_FX_FXJ_LIST(equip));
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/fxj/detailed", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_fxj_detailedData_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");
        int a= Integer.parseInt(equip.split("#")[0]);
        List<detailedData> detailedData1;
        List<detailedData> detailedData2 = indexService.SPOT_FX_FXJ_DY_LIST(equip);
        List<detailedData> detailedData3 = indexService.SPOT_FX_FXJ_SC_LIST(equip);
        if(a<25){
            detailedData1 = indexService.SPOT_FX_FXJ_SB_LIST(equip);

        }
        else {
            detailedData1 = indexService.SPOT_FX_FXJ2_SB_LIST(equip);

        }

        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }
    /*==================================脱泥旋流器==================================*/

    //点检统计
    @GetMapping(value = "/equipment/fx/tnxlq")
    @ResponseBody
    public Map<String,Object> getSpot_fx_tnxlq_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_XLQ_LIST());
        return map;
    }
    //报警数据
    @GetMapping(value = "/spot/fx/tnxlq/alarm")
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_tnxlq_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_FX_XLQ_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/tnxlq/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_tnxlq_detailedData_Url() {

        List<detailedData> detailedData1 = indexService.SPOT_FX_XLQ_SB_LIST();
        List<detailedData> detailedData2 = indexService.SPOT_FX_XLQ_SC_LIST();
        detailedData1.addAll(detailedData2);
        return detailedData(detailedData1);
    }

    /*==================================浮选搅拌桶==================================*/

    //点检统计
    @PostMapping(value = "/equipment/fx/jbt")
    @ResponseBody
    public Map<String,Object> getSpot_fx_jbt_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_JBT_LIST(equip));
        return map;
    }
    //报警数据
    @PostMapping(value = "/spot/fx/jbt/alarm")
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_jbt_Alarm_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");

        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.ALARM_FX_JBT_LIST(equip));
        return map;
    }
    //详细数据
    @RequestMapping(value = "/spot/fx/jbt/detailed", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getsection_Spot_FX_jbt_detailedData_Url(@RequestBody Map<String, String> params) {
        String equip = params.get("equipName");
        List<detailedData> detailedData1 = indexService.SPOT_FX_JBT_SB_LIST(equip);
        List<detailedData> detailedData2 = indexService.SPOT_FX_JBT_DY_LIST(equip);
        detailedData1.addAll(detailedData2);
        System.out.println(equip);
        if (!equip.equals("1#选硫搅拌桶")){
            List<detailedData> detailedData3 = indexService.SPOT_FX_JBT_SC_LIST(equip);
            detailedData1.addAll(detailedData3);
        }




        return detailedData(detailedData1);
    }

// ================================碎矿工艺==========================================
    //报警统计
    @RequestMapping(value = "/spot/sk/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_1_ALARM_LIST());
        return map;
    }
    /*点检统计*/
    @RequestMapping(value = "/spot/sk/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_1_SPOT_LIST());
        return map;
    }

    /*碎矿缺陷数据*/
    @RequestMapping(value = "/spot/sk/defect_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSection_Defect_Stat_sk_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_DEFECT_TREATMENT_LIST());
        return map;
    }

    // =============================重板========================================
    //点检统计
    @RequestMapping(value = "/equipment/sk/zb/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_sk_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_ZB_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/sk/zb/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_zb_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_ZB_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/sk/zb/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_SK_zb_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SK_ZB_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.SK_ZB_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.SK_ZB_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

//==========================================颚破=================================
    //点检统计
    @RequestMapping(value = "/equipment/sk/ep/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_sk_ep_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_EP_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/sk/ep/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_ep_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_EP_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/sk/ep/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_SK_ep_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SK_EP_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.SK_EP_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.SK_EP_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

//======================================2#皮带==================================
    //点检统计
    @RequestMapping(value = "/equipment/sk/pd2/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_sk_pd2_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_PD2_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/sk/pd2/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_pd2_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_PD2_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/sk/pd2/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_SK_pd2_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SK_PD2_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.SK_PD2_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.SK_PD2_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


//==================================4#皮带=============================
    //点检统计
    @RequestMapping(value = "/equipment/sk/pd4/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_sk_pd4_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_PD4_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/sk/pd4/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_sk_pd4_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SK_PD4_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/sk/pd4/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_SK_pd4_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.SK_PD4_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.SK_PD4_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.SK_PD4_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }

// ==================================浓缩工艺====================================
    //  浓度
    @RequestMapping(value = "/spot/ns/ndll", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_ndll_Url() {
        Map<String,Object> map = new HashMap<>();
        List<IndexFlowChartData> indexFlowChartData = indexService.NS_1_NDLL_LIST();
        map.put("msg", "ok");
        map.put("data", indexService.NS_1_NDLL_LIST());
        return map;
    }
    //    报警
    @RequestMapping(value = "/spot/ns/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_1_ALARM_LIST());
        return map;
    }
    /*点检统计*/
    @RequestMapping(value = "/spot/ns/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_1_SPOT_LIST());
        return map;
    }

    /*缺陷数据*/
    @RequestMapping(value = "/spot/ns/defect_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSection_Defect_Stat_ns_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_DEFECT_TREATMENT_LIST());
        return map;
    }

    //============================铜浓密机===============================
    //点检统计
    @RequestMapping(value = "/equipment/ns/tnm/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ns_tnm_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_TNM_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ns/tnm/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_tnm_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_TNM_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ns/tnm/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_tnm_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.NS_TNM_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.NS_TNM_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.NS_TNM_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


    //==============================尾矿浓密机=========================================
    //点检统计
    @RequestMapping(value = "/equipment/ns/wnm/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ns_wnm_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_WNM_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ns/wnm/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_wnm_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_WNM_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ns/wnm/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_wnm_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.NS_WNM_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.NS_WNM_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.NS_WNM_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }



    //======================================硫浓密机==================================
    //点检统计
    @RequestMapping(value = "/equipment/ns/lnm/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ns_lnm_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_LNM_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ns/lnm/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_lnm_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_LNM_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ns/lnm/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_lnm_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.NS_LNM_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.NS_LNM_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.NS_LNM_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }



    //=====================================事故浓密机===================================
    //点检统计
    @RequestMapping(value = "/equipment/ns/sgnm/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ns_sgnm_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_SGNM_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ns/sgnm/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_sgnm_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.NS_SGNM_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ns/sgnm/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ns_sgnm_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.NS_SGNM_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.NS_SGNM_DY_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        return detailedData(detailedData1);
    }


//=================================== 脱水工艺============================================
    // 报警
    @RequestMapping(value = "/spot/ts/alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_1_ALARM_LIST());
        return map;
    }
    /*点检统计*/
    @RequestMapping(value = "/spot/ts/spot", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_1_SPOT_LIST());
        return map;
    }


    /*缺陷数据*/
    @RequestMapping(value = "/spot/ts/defect_treatment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSection_Defect_Stat_ts_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_DEFECT_TREATMENT_LIST());
        return map;
    }


    //======================================3#压滤机=================================
    //点检统计
    @RequestMapping(value = "/equipment/ts/ylj3/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ts_ylj3_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_YLJ3_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ts/ylj3/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_ylj3_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_YLJ3_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ts/ylj3/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_ylj3_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.TS_YLJ3_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.TS_YLJ3_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.TS_YLJ3_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }



    //======================================1#过滤机=================================
    //点检统计
    @RequestMapping(value = "/equipment/ts/glj1/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ts_glj1_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_GLJ1_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ts/glj1/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_glj1_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_GLJ1_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ts/glj1/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_glj1_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.TS_GLJ1_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.TS_GLJ1_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.TS_GLJ1_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


    //=================================2#过滤机=================================
    //点检统计
    @RequestMapping(value = "/equipment/ts/glj2/spot/Statistics", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSpot_ts_glj2_statistics_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_GLJ2_LIST());
        return map;
    }
    //报警数据
    @RequestMapping(value = "/equipment/ts/glj2/spot/Alarm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_glj2_Alarm_Url() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.TS_GLJ2_ALARM_LIST());
        return map;
    }
    //详细数据
    @RequestMapping(value = "/equipment/ts/glj2/spot/detailed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getsection_Spot_ts_glj2_detailedData_Url() {
        List<detailedData> detailedData1 = indexService.TS_GLJ2_SB_Detailed_LIST();
        List<detailedData> detailedData2 = indexService.TS_GLJ2_DY_Detailed_LIST();
        List<detailedData> detailedData3 = indexService.TS_GLJ2_SC_Detailed_LIST();
        detailedData1.addAll(detailedData2);
        detailedData1.addAll(detailedData3);
        return detailedData(detailedData1);
    }


    //======================================详细数据通用===================================
    public Map<String,Object> detailedData( List<detailedData> detailedData1){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data",detailedData1);
        return map;
    }



//==================================url映射===============================
    /*点巡检index页面*/
    @GetMapping("/spot")
    public String toIndex1(String name){ return "/index"; }

    //磨矿工序
    @GetMapping("/spot/mk")
    public String toSBMK(Model model){
        return "/pages/grinding/grinding";
    }
    //磨机
    @GetMapping("/spot/mk/bzmj")
    public String tobzmj(Model model){
        return "/pages/grinding/bzmj";
    }
    @GetMapping("/spot/mk/zmj")
    public String tozmj(Model model){
        return "/pages/grinding/zmj";
    }
    @GetMapping("/spot/mk/qmj")
    public String toqmj(Model model){ return "/pages/grinding/qmj"; }
    @GetMapping("/spot/mk/gkfj")
    public String toMKGK(Model model){ return "/pages/grinding/gkfj"; }
    @GetMapping("/spot/mk/pd")
    public String tomkpd(){ return "/pages/grinding/pd";}
    @GetMapping("/spot/mk/zb")
    public String tomkzb2(){ return "/pages/grinding/zb";}
    @GetMapping("/spot/mk/xlq")
    public String tomkxlq(){ return "/pages/grinding/xlq";}
    //   磨矿旧版
    @GetMapping("/spot/mk/bzmj2")
    public String tobzmj2(Model model){
        return "/pages/grinding/bzmj2_old";
    }
    @GetMapping("/spot/mk/zmj2")
    public String tozmj1(Model model){
        return "/pages/grinding/zmj_old";
    }
    @GetMapping("/spot/mk/qmj2")
    public String toqmj2(Model model){ return "/pages/grinding/qmj_old"; }
    @GetMapping("/spot/mk/pd2")
    public String tomkpd2(){ return "/pages/grinding/pd_old";}
    @GetMapping("/spot/mk/zb2")
    public String tomkzb(){ return "/pages/grinding/zb_old";}
    @GetMapping("/spot/mk/xlq2")
    public String tomkxlq2(){ return "/pages/grinding/xlq_old";}

    //    浮选
    @GetMapping("/spot/fx")
    public String toSBFX(Model model){ return "/pages/flotation/flotation"; }
    @GetMapping("/spot/fx/gfj1")
    public String toGfj1(Model model){ return "/pages/flotation/gfj1" ;}
    @GetMapping("/spot/fx/gfj2")
    public String toGfj2(Model model){ return "/pages/flotation/gfj2" ;}
    @GetMapping("/spot/fx/gfj3")
    public String toGfj3(Model model){ return "/pages/flotation/gfj3" ;}

    @GetMapping("/spot/fx/fxj1")
    public String toFxj1(Model model){ return "/pages/flotation/fxj1" ;}
    @GetMapping("/spot/fx/fxj2")
    public String toFxj2(Model model){ return "/pages/flotation/fxj2" ;}
    @GetMapping("/spot/fx/jbt")
    public String toFxjbt(Model model){ return "/pages/flotation/jbt" ;}
    @GetMapping("/spot/fx/xlq")
    public String toFxXlq(Model model){ return "/pages/flotation/xlq" ;}



    //浮选旧版
    @GetMapping("/spot/fx/gfj12")
    public String toGfj12(Model model){ return "/pages/flotation/gfj1_old" ;}
    @GetMapping("/spot/fx/gfj22")
    public String toGfj22(Model model){ return "/pages/flotation/gfj2_old" ;}
    @GetMapping("/spot/fx/gfj32")
    public String toGfj32(Model model){ return "/pages/flotation/gfj3_old" ;}

    @GetMapping("/spot/fx/fxj12")
    public String toFxj12(Model model){ return "/pages/flotation/fxj12" ;}
    @GetMapping("/spot/fx/fxj22")
    public String toFxj22(Model model){ return "/pages/flotation/fxj22" ;}
    @GetMapping("/spot/fx/jbt2")
    public String toFxjbt2(Model model){ return "/pages/flotation/jbt2" ;}
    @GetMapping("/spot/fx/xlq2")
    public String toFxXlq2(Model model){ return "/pages/flotation/xlq2" ;}

    //碎矿
    @GetMapping("/spot/sk")
    public String tosk(){ return "/pages/crushing/sk";  }
    @GetMapping("/spot/sk/zb")
    public String toskzb(){ return "/pages/crushing/zb";  }
    @GetMapping("/spot/sk/ep")
    public String toskep(){ return "/pages/crushing/ep";  }
    @GetMapping("/spot/sk/pd2")
    public String toskpd2(){ return "/pages/crushing/pd2";  }
    @GetMapping("/spot/sk/pd4")
    public String toskpd4(){ return "/pages/crushing/pd4";  }
    //    碎矿旧版
    @GetMapping("/spot/sk/ep2")
    public String toskep2(){ return "/pages/crushing/e_old";  }
    @GetMapping("/spot/sk/zb2")
    public String toskzb2(){ return "/pages/crushing/zb_old";  }
    @GetMapping("/spot/sk/pd22")
    public String toskep22(){ return "/pages/crushing/pd2_old";  }
    @GetMapping("/spot/sk/pd42")
    public String toskzb42(){ return "/pages/crushing/pd4_old";  }
    //浓缩
    @GetMapping("/spot/ns")
    public String tons(){ return "/pages/ns/ns";}

    @GetMapping("/spot/ns/tnm")
    public String totnm(){ return "/pages/ns/tnm";}
    @GetMapping("/spot/ns/lnm")
    public String tolnm(){ return "/pages/ns/lnm";}
    @GetMapping("/spot/ns/wnm")
    public String townm(){ return "/pages/ns/wnm";}
    @GetMapping("/spot/ns/sgnm")
    public String tosgnm(){ return "/pages/ns/sgnm";}

    //    浓缩旧版
    @GetMapping("/spot/ns/tnm2")
    public String totnm2(){ return "/pages/ns/tnm_old";}
    @GetMapping("/spot/ns/lnm2")
    public String tolnm2(){ return "/pages/ns/lnm_old";}
    @GetMapping("/spot/ns/wnm2")
    public String townm2(){ return "/pages/ns/wnm_old";}
    @GetMapping("/spot/ns/sgnm2")
    public String tosgnm2(){ return "/pages/ns/sgnm_old";}

    // 脱水
    @GetMapping("/spot/ts")
    public String tots(){ return "/pages/ts/ts";  }
    @GetMapping("/spot/ts/ylj3")
    public String toylj3(){ return "/pages/ts/ylj3";  }
    @GetMapping("/spot/ts/glj1")
    public String toygj1(){ return "/pages/ts/glj1";  }
    @GetMapping("/spot/ts/glj2")
    public String toygj2(){ return "/pages/ts/glj2";  }

    // 脱水旧版
    @GetMapping("/spot/ts/ylj32")
    public String toylj32(){ return "/pages/ts/ylj3_old";  }
    @GetMapping("/spot/ts/glj12")
    public String toygj12(){ return "/pages/ts/glj1_old";  }
    @GetMapping("/spot/ts/glj22")
    public String toygj22(){ return "/pages/ts/glj2_old";  }

    //报表
    @GetMapping("/spot/report1")
    public String toreport(){ return "/pages/report/report";  }

    @GetMapping("/spot/report")
    public String toreport1(){ return "/pages/report/report_old1";  }

    //报表
    @GetMapping("/spot/weekReport1")
    public String toweekreport(){ return "/pages/report/weekReport";  }

    @GetMapping("/spot/weekReport")
    public String toweekreport1(){ return "/pages/report/weekReport_old";  }

    @GetMapping("/spot/workShopReport1")
    public String toworkShopReport(){ return "/pages/report/workShopReport";  }

    @GetMapping("/spot/workShopReport")
    public String toworkShopReport1(){ return "/pages/report/workShopReport_old";  }



    @GetMapping("/spot/dxj_config")
    public String toConfig(){ return "/dxjSystem/dxj_config";  }

    @GetMapping("/spot/index1")
    public String toConfig1(){ return "/index1";  }
//   维修单查询
    @GetMapping("/spot/changeShifts/write")
    public String changeShifts(){ return "/changeShifts";  }

    @GetMapping("/spot/dxj_repair_list")
    public String todxj_repair_list(){ return "/dxjSystem/dxj_repair_list";  }
//    APP
    @GetMapping("/spot/app")
    public String toAppConfig(Model model){ return "/dxj_app_config";  }
/*测试使用*/
    @GetMapping("/first")
    public String tofirst(){ return "/first";  }
    @GetMapping("/test")
    public String totest(){ return "/test";  }
    @GetMapping("/test2")
    public String totest2(){ return "/test2";  }
    @GetMapping("/test3")
    public String totest3(){ return "/test3";  }

    @GetMapping("/test5")
    public String totest5(){ return "/test5";  }

    @GetMapping("/weixiu")
    public String toweixiu(){ return "/weixiu";  }
    @GetMapping("/weixiu1")
    public String toweixiu1(){ return "/weixiu1";  }
    @GetMapping("/weixiu2")
    public String toweixiu2(){ return "/weixiu2";  }

    @GetMapping("/dateChoose")
    public String todateChoose(){ return "/dateChoose";  }
    @GetMapping("/spot/searchResult1")
    public String searchResult1(){ return "/dxjSystem/searchResult1";  }


    @GetMapping("/dxj")
    public String tocChoose1(){ return "/dxj";  }

//点检结果查询
    @GetMapping("/spot/searchResult")
    public String searchResult(){ return "/dxjSystem/searchResult";  }
//    交接班查询
    @GetMapping("/spot/searchSuccession")
    public String searchSuccession(){ return "/searchSuccession";  }


    //球磨机点巡检数据
    @RequestMapping(value = "/spot/mk/qmj/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deQMJ_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_QMJ_DETAILED_LIST(param));
        return map;
    }
    //再磨机点巡检数据
    @RequestMapping(value = "/spot/mk/zmj/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deZMJ_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_ZMJ_DETAILED_LIST(param));
        return map;
    }
    //再磨机点巡检数据
    @RequestMapping(value = "/spot/mk/bzmj/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deBZMJ_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_BZMJ_DETAILED_LIST(param));
        return map;
    }

    //中板点巡检数据
    @RequestMapping(value = "/spot/mk/zb/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deZB_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_ZB_DETAILED_LIST(param));
        return map;
    }

    //旋流器点巡检数据
    @RequestMapping(value = "/spot/mk/xlq/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deXLQ_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_XLQ_DETAILED_LIST(param));
        return map;
    }

    //旋流器点巡检数据
    @RequestMapping(value = "/spot/mk/pd/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_dePD_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_MK_PD_DETAILED_LIST(param));
        return map;
    }
    //1#鼓风机点巡检数据
    @RequestMapping(value = "/spot/fx/gfj1/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxGfj1_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_GFJ1_DETAILED_LIST(param));
        return map;
    }
    //2#鼓风机点巡检数据
    @RequestMapping(value = "/spot/fx/gfj2/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxGfj2_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_GFJ2_DETAILED_LIST(param));
        return map;
    }
    //3#鼓风机点巡检数据
    @RequestMapping(value = "/spot/fx/gfj3/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxGfj3_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_GFJ3_DETAILED_LIST(param));
        return map;
    }
    //颚破点巡检数据
    @RequestMapping(value = "/spot/sk/ep/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deSkEp_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_EP_DETAILED_LIST(param));
        return map;
    }
    //颚破点巡检数据
    @RequestMapping(value = "/spot/sk/zb/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deSkZb_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_ZB_DETAILED_LIST(param));
        return map;
    }
    //2#皮带点巡检数据
    @RequestMapping(value = "/spot/sk/pd2/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deSkPd2_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_PD2_DETAILED_LIST(param));
        return map;
    }
    //4#皮带点巡检数据
    @RequestMapping(value = "/spot/sk/pd4/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deSkPd4_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_SK_PD4_DETAILED_LIST(param));
        return map;
    }
    //硫浓密机点巡检数据
    @RequestMapping(value = "/spot/ns/lnm/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deNsLnm_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_LNM_DETAILED_LIST(param));
        return map;
    }
    //铜浓密机点巡检数据
    @RequestMapping(value = "/spot/ns/tnm/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deNsTnm_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_TNM_DETAILED_LIST(param));
        return map;
    }
    //硫浓密机点巡检数据
    @RequestMapping(value = "/spot/ns/wnm/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deNsWnm_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_WNM_DETAILED_LIST(param));
        return map;
    }
    //事故浓密机点巡检数据
    @RequestMapping(value = "/spot/ns/sgnm/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deNsSgnm_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_NS_SGNM_DETAILED_LIST(param));
        return map;
    }
    //1#过滤机点巡检数据
    @RequestMapping(value = "/spot/ts/glj1/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deTsGlj1_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_GLJ1_DETAILED_LIST(param));
        return map;
    }
    //2#过滤机点巡检数据
    @RequestMapping(value = "/spot/ts/glj2/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deTsGlj2_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_GLJ2_DETAILED_LIST(param));
        return map;
    }
    //3#压滤机点巡检数据
    @RequestMapping(value = "/spot/ts/ylj3/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deTsYlj3_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");

        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_TS_YLJ3_DETAILED_LIST(param));
        return map;
    }
    //无刮板浮选机
    @RequestMapping(value = "/spot/fx/fxj1/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxFxj1_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        String equip = params.get("equip");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_FXJ1_DETAILED_LIST(param,equip));
        return map;
    }
    @RequestMapping(value = "/spot/fx/fxj2/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxFxj2_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        String equip = params.get("equip");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_FXJ2_DETAILED_LIST(param,equip));
        return map;
    }
    @RequestMapping(value = "/spot/fx/xlq/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxXlq_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_XLQ_DETAILED_LIST(param));
        return map;
    }
    @RequestMapping(value = "/spot/fx/jbt/detailed/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getSpot_deFxJbt_Url(@RequestBody Map<String, String> params) {
        String param = params.get("param");
        String equip = params.get("equip");
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.SPOT_FX_JBT_DETAILED_LIST(param,equip));
        return map;
    }

    @Value("${version}")
    private String version;
}
