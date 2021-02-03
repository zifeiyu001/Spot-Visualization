package com.demo.mapper.Cms.process.fx;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface FX1SpotMapper {

    List<SpotStatistics> FX_1_SPOT_LIST();
}
