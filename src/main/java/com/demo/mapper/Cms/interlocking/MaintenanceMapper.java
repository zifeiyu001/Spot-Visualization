package com.demo.mapper.Cms.interlocking;

import com.demo.model.universal.Maintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MaintenanceMapper {


    List<Maintenance> pc_get_MaintenanceResult(@Param("deptName") String deptName, @Param("routeName") String routeName, @Param("zoneName") String zoneName,
                                              @Param("devName") String devName,
                                              @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("dealResult") String dealResult);

}
