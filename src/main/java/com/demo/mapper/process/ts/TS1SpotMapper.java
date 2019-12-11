package com.demo.mapper.process.ts;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface TS1SpotMapper {

    List<SpotStatistics> TS_1_SPOT_LIST();
}
