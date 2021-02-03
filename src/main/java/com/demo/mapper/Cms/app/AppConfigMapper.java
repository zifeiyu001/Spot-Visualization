package com.demo.mapper.Cms.app;

import com.demo.model.app.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface AppConfigMapper {

//    =======================配置页面=======================

    Integer  app_config_set_station(@Param("deptName") String deptName, @Param("station") String station, @Param("routeName") String routeName);
    Integer  app_config_update_station(@Param("deptName") String deptName, @Param("station") String station, @Param("routeName") String routeName);
    Integer  app_config_delete_station(@Param("deptName") String deptName, @Param("station") String station, @Param("routeName") String routeName);
    List<APPUserConfig>  app_config_select_station(@Param("deptName") String deptName, @Param("station") String station, @Param("routeName") String routeName);

    List<APPUserConfig>   app_config_getJob_user(@Param("deptName") String deptName);


    Integer  app_config_set_station_user(@Param("deptName") String deptName, @Param("station") String station,
                                         @Param("team") String team,@Param("userName") String userName,@Param("userId") String userId);
    Integer  app_config_update_station_user(@Param("deptName") String deptName, @Param("station") String station,
                                         @Param("team") String team,@Param("userName") String userName,@Param("userId") String userId);
    Integer  app_config_delete_station_user(@Param("deptName") String deptName, @Param("station") String station,
                                            @Param("team") String team,@Param("userId") String userId);

    List<APPUserConfig>  app_config_select_station_user(@Param("deptName") String deptName, @Param("station") String station,
                                            @Param("team") String team,@Param("userId") String userId);
}

