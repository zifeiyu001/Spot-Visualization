package com.demo.mapper.process.fx;

import com.demo.model.equip.SpotStatistics;
import com.demo.model.index.IndexFlowChartData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface FX1PVMapper {

    List<IndexFlowChartData> FX_1_PV_LIST();
}
