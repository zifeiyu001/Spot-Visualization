package com.demo.mapper.interlocking;

import com.demo.model.app.AppCycle;
import com.demo.model.app.AppDCS;
import com.demo.model.app.AppLoginUser;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.AlarmDealData;
import com.demo.model.universal.AppReport;
import com.demo.model.universal.Config;
import com.demo.model.universal.ConfigUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**

 */
@Mapper
public interface InterlockingMapper {

    List<Interlocking> Interlocking_get_deptName();
    List<Interlocking> Interlocking_get_routeName();
    List<Interlocking> Interlocking_get_zoneName();
    List<Interlocking> Interlocking_get_devName();
    List<Interlocking> Interlocking_get_scPart();
    List<Interlocking> Interlocking_get_content();

    List<Interlocking> Interlocking_get_result(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                               @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                               @Param("startTime") String startTime, @Param("endTime") String endTime,
                                               @Param("zcCheck") String zcCheck, @Param("bjCheck") String bjCheck,@Param("bjType1") String bjType1
                                                , @Param("bjType2") String bjType2, @Param("bjType3") String bjType3, @Param("wjCheck") String wjCheck
                                                 ,@Param("startPage") Integer startPage, @Param("numPerPage") Integer numPerPage,@Param("dealStatus") String dealStatus);
//获取点检结果 test
    List<Interlocking> Interlocking_get_result1(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                               @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                               @Param("startTime") String startTime, @Param("endTime") String endTime,
                                                @Param("yjCheck") String yjCheck, @Param("wjCheck") String wjCheck,
                                               @Param("zcCheck") String zcCheck, @Param("bjCheck") String bjCheck,
                                                @Param("abjType1") String abjType, @Param("abjType2") String abjType2, @Param("abjType3") String abjType3,
                                                @Param("sbjType1") String sbjType, @Param("sbjType2") String sbjType2, @Param("sbjType3") String sbjType3,
                                                @Param("startPage") Integer startPage, @Param("numPerPage") Integer numPerPage);
    List<ConfigUser> search_config_alarm_liable_all();
    Integer Interlocking_get_result1_total(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                           @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                           @Param("startTime") String startTime, @Param("endTime") String endTime,@Param("zcCheck") String zcCheck,
                                           @Param("bjCheck") String bjCheck, @Param("bjType1") String bjType1, @Param("bjType2") String bjType2,
                                           @Param("bjType3") String bjType3, @Param("wjCheck") String wjCheck ,@Param("dealStatus") String dealStatus);
//获取条数测试
    Integer Interlocking_get_result1_total1(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                           @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                           @Param("startTime") String startTime, @Param("endTime") String endTime,
                                            @Param("yjCheck") String yjCheck, @Param("wjCheck") String wjCheck,
                                            @Param("zcCheck") String zcCheck, @Param("bjCheck") String bjCheck,
                                            @Param("abjType1") String abjType, @Param("abjType2") String abjType2, @Param("abjType3") String abjType3,
                                            @Param("sbjType1") String sbjType, @Param("sbjType2") String sbjType2, @Param("sbjType3") String sbjType3
    );


    Integer Interlocking_changeAlarmType(@Param("resultId") String resultId,@Param("alarmType") String alarmType,
                                         @Param("operationName") String operationName,@Param("selectDepart") String selectDepart,@Param("responsibleUser") String responsibleUser);
   Integer Interlocking_changeAlarmPersonLiable(@Param("resultId") String resultId,@Param("alarm_personLiable") String alarm_personLiable);

//查询id下的点检内容
    List<Interlocking> Interlocking_get_byId_result(@Param("resultId") String resultId);

    //  查询alarmResult表中是否有相同数据
    List<Interlocking> searchAlarmResultDataByInfo(@Param("deptName") String deptName,@Param("routeName")String routeName,@Param("zoneName")String zoneName,
                                                   @Param("devName")String devName,@Param("scPart")String scPart,@Param("scContent")String scContent,
                                                   @Param("remark")String remark,@Param("alarmType")String alarmType);

    //  数据合并，增加次数
    Integer updateAlarmResultTimes(@Param("alarmId")String alarmId,@Param("alarmTimes")String alarmTimes,@Param("depart") String depart,
                                   @Param("user") String user,@Param("alarmType") String alarmType,@Param("startDate") String startDate,@Param("endDate") String endDate,
                                     @Param("resultIds")  String resultIds
    );


    //向alarm_result 添加数据(原无数据)
    Integer insertBCAlarmDataToAlarmResult(@Param("resultId")  String resultId,@Param("deptName")  String deptName,@Param("routeName")   String routeName,
                                           @Param("zoneName")  String zoneName, @Param("devName") String devName,@Param("scPart")  String scPart,
                                           @Param("scContent") String scContent,@Param("remark") String remark, @Param("spotResult") String spotResult,
                                           @Param("userName1")   String userName1, @Param("uploadResultTime") String uploadResultTime,
                                           @Param("selectDepart") String selectDepart, @Param("alarmType") String alarmType,@Param("user")  String user);
    //向alarm_result 添加数据(原有数据)
    Integer insertBCAlarmDataToAlarmResult1(@Param("resultId")  String resultId,@Param("deptName")  String deptName,@Param("routeName")   String routeName,
                                            @Param("zoneName")  String zoneName, @Param("devName") String devName,@Param("scPart")  String scPart,
                                            @Param("scContent") String scContent,@Param("remark") String remark, @Param("spotResult") String spotResult,
                                            @Param("userName1")   String userName1, @Param("uploadResultTime") String uploadResultTime,
                                            @Param("selectDepart") String selectDepart, @Param("alarmType") String alarmType,@Param("user")  String user,
                                            @Param("pid") String pid);
//    查询临时表是否有数据
    List<Interlocking> Interlocking_get_temp_result(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                               @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                                @Param("stdValue") String stdValue,@Param("altpid") String altpid);
//    更新临时表数据
    Integer Interlocking_update_temp_result(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                                    @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                                    @Param("altpid") String altpid, @Param("stdValue") String stdValue,
                                                       @Param("alarmType") String alarmType, @Param("userName") String userName, @Param("selectDepart") String selectDepart);
//    出入临时表数据
    Integer Interlocking_insert_temp_result(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                                       @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                                       @Param("altpid") String altpid, @Param("stdValue") String stdValue,
                                                       @Param("alarmType") String alarmType, @Param("userName") String userName, @Param("selectDepart") String selectDepart);

    List<Interlocking> Interlocking_get_all_alarm_byDay();
    List<Interlocking> Interlocking_get_all_alarmType();

    Integer Interlocking_update_alarm_result(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                            @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                            @Param("alarm_manage") String alarm_manage,@Param("alarm_type") String alarm_Type);

//    更新报警处理责任人
    Integer Interlocking_update_alarm_liable(@Param("resultId") String resultId,@Param("liable") String liable);

//    查询登录人员权限
    List<Interlocking> search_config_userChange_permission(@Param("userId") String userId);
//通过alarmid获取resultid
    List<Interlocking> get_resultId_alarmid(@Param("alarmId") String alarmId);
    //   删除alarmResult数据
    Integer delete_alarm_result_by_alarmId(@Param("alarmId") String alarmId);
//   根据用户id查询所在工段
    List<Interlocking> search_dxj_dept_id(@Param("userId") String userId);

//    根据resultID查询报警处理内容
    List<AlarmDealData> get_alarm_deal_data( @Param("result_id") String resultId);

    //    根据条件查询报警处理内容
    List<AlarmDealData> get_repair_data( @Param("dateStart") String dateStart,@Param("dateEnd") String dateEnd,@Param("depart") String depart,@Param("technology") String technology);
    //    根据条件查询报警处理内容
    List<AlarmDealData> getWriteDefaultDealData( @Param("resultID") String resultID);

    //    获取bc类报警数据
     List<Interlocking> getbcAlarmData( @Param("start_date") String start_date, @Param("end_date") String end_date,
                                        @Param("deptName") String deptName, @Param("alarm_type")String alarm_type);

    //    添加数据到月度报警清单
    Integer addAlarmToMonthlyList( @Param("mergeIds") String mergeId);

    //    获取月度报警清单
    List<Interlocking> getbcMonthlyAlarmListData(@Param("deptName") String deptName);
    //     处理BC类报警
    Integer dealBCAlarm( @Param("alarmId") String alarmId,@Param("dealRemark") String dealRemark,@Param("user") String user);

    //    延期bc类报警
    Integer delayBCAlarm( @Param("alarmIds") String alarmIds,@Param("dealRemark")  String dealRemark);

    //    修改bc类报警类型
//        alarm表
     Integer changeBCAlarmTypeAlarm(@Param("alarmIds")  String alarmIds,@Param("deptName")  String deptName,@Param("alarmType") String alarmType,@Param("personLiable") String personLiable);
//          result表
     Integer changeBCAlarmTypeResult(@Param("resultIds")  String resultIds,@Param("deptName")  String deptName,@Param("alarmType") String alarmType,@Param("personLiable") String personLiable);


     //    合并报警数据
     Integer mergeBCAlarmNum(@Param("alarmId") String alarmId,@Param("mergeIds")  String mergeIds);
    //    合并报警数据
    Integer mergeBCAlarmData(@Param("alarmId") String alarmId ,@Param("resultIds")  String resultIds,@Param("times")  String times,
                             @Param("startTime") String startTime,@Param("endTime") String endTime);
    //    删除合并报警其他数据
     Integer updateDeleteAlarmData(@Param("alarmId") String alarmId,@Param("mergeIds")  String mergeIds);
    //    更新合并报警后数据
     Integer updateAlarmData(@Param("alarmId") String alarmId,@Param("deleteAlarmNum")  String deleteAlarmNum);









     //    获取处理BC类报警内容
    List<Interlocking> getbcAlarmContent(@Param("alarmId") String alarmId);

    //     获取处理alarm表中id的resultId
     List<Interlocking> getbcAlarmDataResultId(@Param("alarmIds") String alarmIds);

    //    根据resultId处理result表中BC类报警
     Integer dealBCAlarmInResult(@Param("resultIds") String resultId ,@Param("dealRemark") String dealRemark,@Param("user") String user);

    //        获取报警处理责任人

    List<ConfigUser> getPersonLiableByDepart(@Param("alarm_after_Type") String alarm_after_Type,@Param("departs") String departs);

    //    修改bc类报警类型


    Integer updateResultChangeAlarmTypeByDetailed(@Param("deptName") String deptName,@Param("routeName") String routeName,@Param("zoneName") String zoneName,
                @Param("devName")  String devName,@Param("scPart") String scPart, @Param("scContent") String scContent,@Param("uploadResultTime") String uploadResultTime,
                                                             @Param("user") String user,@Param("departs") String departs,@Param("alarmType") String alarmType)
            ;


//处理bc报警类型result表中内容
  Integer updateResultDealDataByDetailed(@Param("deptName") String deptName,@Param("routeName") String routeName,@Param("zoneName") String zoneName,
                                         @Param("devName")  String devName,@Param("scPart") String scPart,
                                         @Param("scContent") String scContent,@Param("uploadResultTime") String uploadResultTime,@Param("user") String user);

    //   保存报警处理内容
    Integer writeDealData( @Param("result_id") String result_id,@Param("service_id") String service_id,@Param("dev_code") String dev_code,
                                       @Param("service_start_date") String service_start_date, @Param("service_end_date") String service_end_date,@Param("service_hours") String service_hours,
                                       @Param("dev_name") String dev_name, @Param("dev_model") String dev_model,@Param("dev_dept") String dev_dept,
                                       @Param("dev_category") String dev_category, @Param("service_unit_type") String service_unit_type, @Param("service_unit") String service_unit,
                                       @Param("alarm_type") String alarm_type, @Param("alarm_name") String alarm_name,@Param("alarm_time") String alarm_time,
                                       @Param("alarm_content") String alarm_content, @Param("service_name") String service_name,@Param("service_acceptor") String service_acceptor,
                                       @Param("service_content") String service_content,@Param("service_alarm_time") String service_alarm_time,
                                       @Param("service_remarks") String service_remarks);
    //   修改报警处理内容
    Integer updateDealData(@Param("result_id")  String result_id,@Param("service_id") String service_id,@Param("service_start_date") String service_start_date,
                           @Param("service_end_date") String service_end_date, @Param("service_hours") String service_hours,@Param("service_unit_type") String service_unit_type,
                           @Param("service_unit") String service_unit, @Param("service_name") String service_name, @Param("service_acceptor") String service_acceptor,
                           @Param("service_content") String service_content,@Param("service_alarm_time") String service_alarm_time,
                           @Param("service_remarks") String service_remarks);
//A类报警处理result表
    Integer updateResultDealData(@Param("result_id") String result_id,@Param("alarm_flag") String alarm_flag, @Param("alarm_remark")  String alarm_remark,
                                 @Param("alarm_manage_name")  String alarm_manage_name,@Param("alarm_manage_time") String alarm_manage_time);
//      获取报警处理单当天的数量
    List<AlarmDealData> getDeptSameDayDealData( @Param("dept_name") String dept_name);

//    获取是否有处理报警的权限
     List<ConfigUser> getAlarmDealJurisdiction(@Param("dev_depart") String dev_depart,@Param("userid") String userid,@Param("alarm_type") String alarm_type);


    //    获取配置参数

    List<Config> getConfigData();
//    修改配置参数
    Integer setConfigData(@Param("alarm_list_start") String alarm_list_start,@Param("alarm_list_end") String alarm_list_end
                         ,@Param("alarm_c_deal_start") String alarm_c_deal_start, @Param("alarm_c_deal_end") String alarm_c_deal_end
                         ,@Param("alarm_tips_time") String alarm_tips_time
    );

}
