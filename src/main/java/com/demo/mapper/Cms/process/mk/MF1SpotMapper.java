package com.demo.mapper.Cms.process.mk;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface MF1SpotMapper {

    List<SpotStatistics> MF_1_SPOT_LIST();
}
