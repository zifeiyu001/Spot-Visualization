package com.demo.mapper.Cms.process.sk;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SK1SpotMapper {

    List<SpotStatistics> SK_1_SPOT_LIST();
}
