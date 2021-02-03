package com.demo.mapper.Cms.process.ns;

import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface NS1SpotMapper {

    List<SpotStatistics> NS_1_SPOT_LIST();
}
