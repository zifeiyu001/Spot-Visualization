package com.demo.mapper.Cms.process.mk;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface MF1BallStatisticsMapper {

    List<SpotStatistics> MK_1_BALL_STATISTICS_LIST();
}
