package com.demo.mapper.process.mk;

import com.demo.model.equip.SpotStatistics;
import com.demo.model.process.grindingFloat.MF1DefectStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface MF1BallStatisticsMapper {

    List<SpotStatistics> MK_1_BALL_STATISTICS_LIST();
}
