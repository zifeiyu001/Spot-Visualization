package com.demo.mapper.interlocking;

import com.demo.model.app.AppCycle;
import com.demo.model.app.AppDCS;
import com.demo.model.app.AppLoginUser;
import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.AppReport;
import com.demo.model.universal.ConfigUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
                                                 ,@Param("startPage") Integer startPage, @Param("numPerPage") Integer numPerPage);


    List<ConfigUser> search_config_alarm_liable_all();
    Integer Interlocking_get_result1_total(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                           @Param("devName") String devName, @Param("scPart") String scPart, @Param("scContent") String scContent,
                                           @Param("startTime") String startTime, @Param("endTime") String endTime,
                                           @Param("zcCheck") String zcCheck, @Param("bjCheck") String bjCheck, @Param("bjType1") String bjType1
                                            , @Param("bjType2") String bjType2, @Param("bjType3") String bjType3, @Param("wjCheck") String wjCheck );


    Integer Interlocking_changeAlarmType(@Param("resultId") String resultId,@Param("alarmType") String alarmType,
                                         @Param("userName") String userName,@Param("selectDepart") String selectDepart);
   Integer Interlocking_changeAlarmPersonLiable(@Param("resultId") String resultId,@Param("alarm_personLiable") String alarm_personLiable);

//查询id下的点检内容
    List<Interlocking> Interlocking_get_byId_result(@Param("resultId") String resultId);
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
                                            @Param("alarm_manage") String alarm_manage);
}
