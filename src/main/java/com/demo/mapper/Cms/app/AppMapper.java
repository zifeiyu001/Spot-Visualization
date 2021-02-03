package com.demo.mapper.Cms.app;

import com.demo.model.app.*;
import com.demo.model.equip.detailedData;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.AppReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface AppMapper {
//返回点检数据
    List<AppReport> App_Spot_Result(@Param("deptName") String deptName,@Param("job") String job,@Param("startTime") String startTime,@Param("endTime") String endTime);
//用户登录交接班页面
    List<AppLoginUser> app_user_login(@Param("userName") String userName, @Param("cycleContentDate") String cycleContentDate);

//    APP登录
    List<AppLoginUser> app_user_login1(@Param("userName") String userName, @Param("passWord") String passWord);

//    获取登录人员交接班开始周期、周期天数
    List<AppCycle> app_user_getCycle(@Param("userName") String userName);


//    获取登录人员交班id
    List<AppLoginUser> app_user_getjjbID(@Param("deptName") String deptName, @Param("job") String job);

//    磨矿岗dcs数据
    List<AppDCS> app_jjb_dcs_mk(@Param("mj") String mj,@Param("metaStartTime") String metaStartTime,@Param("metaEndTime") String metaEndTime);

//    ====================交接班数据填写===============================
    Integer app_jjb_write(@Param("dateTime") String dateTime, @Param("job") String job,
                                 @Param("jjbTagName") String jjbTagName, @Param("jjbValue") String jjbValue);

//=============================运行时间数据=======================================
//    获取交接班需填写数据(运行时间)
    List<AppDemandWriteData> app_jjb_getDemandWrite(@Param("job") String job,@Param("equip") String equip);
//    获取交接班填写数据（运行时间）
    List<AppDemandWriteData> app_jjb_getWrite(@Param("job") String job,@Param("equip") String equip);

//    ===========================巡检数据===================================

//    获取巡检数据
    List<AppDemandWriteData> app_jjb_getspotWrite(@Param("job") String job,@Param("equip") String equip,@Param("metaStartTime") String metaStartTime,@Param("metaEndTime") String metaEndTime,@Param("meta") Integer meta);
//    获取交接班巡检需填写数据
    List<AppDemandWriteData> app_jjb_getemandSpotWrite(@Param("job") String job,@Param("equip") String equip,@Param("meta") String meta);

//   查询字段是否存在
    List<AppDemandWriteData> app_jjb_getWriteData(@Param("field") String field,@Param("metaStartTime") String metaStartTime);
//   查询字段存在后更新
    Boolean app_jjb_updateWriteData(@Param("field") String field,@Param("value") String value,@Param("metaStartTime") String metaStartTime);

//    交班内容填写
    Integer app_shift_duty_handover(@Param("handoverTime") String dataTime, @Param("id") String id, @Param("deptName") String deptName, @Param("job") String job,
                                    @Param("handoverTeam") String handoverTeam, @Param("handoverDuty") String handoverDuty,
                                    @Param("handoverName") String handoverName, @Param("handoverContent") String handoverContent);
//    交班时获取下个班人员
    List<AppLoginUser> app_jjb_getNextUser(@Param("date") String date, @Param("job") String job, @Param("meta") String meta);

//   接班内容填写
    Integer app_shift_duty_succession(@Param("succeedTime") String dataTime, @Param("id") String id, @Param("succeedTeam") String succeedTeam,
                                      @Param("succeedDuty") String succeedDuty, @Param("succeedName") String succeedName, @Param("succeedContent") String succeedContent);

//    获取当前时间段的开关量数据
    List<AppDCS> app_jjb_getRunTime(@Param("field") String field,@Param("startTime") String startTime,@Param("endTime") String endTime);

//    获取当前时间段前的一个开关量
    List<AppDCS> app_jjb_getLastRunTime(@Param("field") String field,@Param("startTime") String startTime);

//    String app_jjb_getDifferenceHour(@Param("meta") String meta);

//    获取设备运行时间的字段
    List<AppDCS> app_jjb_getRunTimeField(@Param("equip") String equip);

//=============================维修=================================
    Integer app_set_maintenance(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                @Param("devName") String devName, @Param("description") String description, @Param("pic") String pic,
                                @Param("discoverer") String discoverer, @Param("phone") String phone);


//    ===========================================查询页面======================================

    List<detailedData> pc_jjb_getDCSData(@Param("job") String job,@Param("date") String date,@Param("duty") String duty);

    List<Interlocking> app_get_dxjSearchResult(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                               @Param("startTime") String startTime, @Param("endTime") String endTime);

//获取周期信息
    List<AppScheduling> app_get_team_scheduling();
    List<APPUserConfig> app_get_jjb_team_byUserId(@Param("userId") String userId);


//    获取岗位的路线
    List<AppReport> app_get_jjb_deptRoute(@Param("deptName") String deptName,@Param("job") String job);
}

