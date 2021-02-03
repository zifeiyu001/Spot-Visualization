package com.demo.mapper.Cms.index;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface IndexSpotMapper {

    List<SpotStatistics> INDEX_DY_LIST(@Param("param") String param);
    List<SpotStatistics> INDEX_SB_LIST(@Param("param") String param);
    List<SpotStatistics> INDEX_SC_LIST(@Param("param") String param);
    List<SpotStatistics>   getMonthlysSotStatistics();
}
