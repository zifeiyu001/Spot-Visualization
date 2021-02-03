package com.demo.mapper.Cms.index;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface IndexSpotStatisticsMapper {

    List<SpotStatistics> INDEX_SPOT_STATISTICS_LIST(@Param("param") String param);
}
