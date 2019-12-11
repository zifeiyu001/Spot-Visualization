package com.demo.mapper.process.ns;

import com.demo.model.equip.SpotAlarm;
import com.demo.model.index.IndexFlowChartData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface NS1NDLLMapper {

    List<IndexFlowChartData> NS_1_NDLL_LIST();
}
