package com.demo.mapper.Cms.universal;


import com.demo.model.universal.ConfigUser;
import com.demo.model.universal.TreeCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigUserMapper {

    List<ConfigUser> get_dept_list();
    List<TreeCode> get_dept_test_list();
    List<ConfigUser> get_dept_user_list();
    List<ConfigUser> get_dept_user_ll_list(@Param("equipId") String equipId);
//    ======================责任人配置=====================
// 存储人员管理部门数据
    Integer set_config_partment_user(@Param("deptName") String deptName,@Param("deptId") String deptId,
                                     @Param("user") String user,@Param("userId") String userId
                                                        ,@Param("department") String department,@Param("alarmType") String alarmType,@Param("team") String team);

// 判断当前人员是否有管理部门
    List<ConfigUser> search_config_partment_user(@Param("userId") String userId ,@Param("alarmType") String alarmType,@Param("team") String team);

// 判断当前人员已有管理部门，对其更新

    Integer update_config_partment_user(@Param("deptName") String deptName,@Param("deptId") String deptId,
                                 @Param("user") String user,@Param("userId") String userId,@Param("department") String department,
                                        @Param("alarmType") String alarmType,@Param("team") String team);

// 获取当前部门下的责任人
    List<ConfigUser> search_config_liable_user(@Param("workshopId") String workshopId);
// 获取当前部门下的责任人
    Integer delete_liable_user(@Param("department") String department,@Param("userId") String userId,@Param("alarmType") String alarmType);
// ==========================管理人员配置===========================
    // 存储人员管理部门数据
    Integer set_config_alarm_manage(@Param("deptName") String deptName,@Param("deptId") String deptId,
                                     @Param("user") String user,@Param("userId") String userId,@Param("manageDepart") String manageDepart );

    // 判断当前人员是否有管理部门
    List<ConfigUser> search_config_alarm_manage(@Param("userId") String userId );

// 判断当前人员已有管理部门，对其更新

    Integer update_config_alarm_manage(@Param("deptName") String deptName,@Param("deptId") String deptId,
                                        @Param("user") String user,@Param("userId") String userId,@Param("manageDepart") String manageDepart);

    List<ConfigUser> search_config_alarm_manage_exist();
    List<ConfigUser> search_config_alarm_manage_user(@Param("userName") String userName,@Param("part") String part);

    Integer delete_user(@Param("userId") String userId);

}
