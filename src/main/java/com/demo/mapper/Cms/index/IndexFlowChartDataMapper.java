package com.demo.mapper.Cms.index;

import com.demo.model.index.IndexFlowChartData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface IndexFlowChartDataMapper {

    List<IndexFlowChartData> INDEX_FLOW_CHART_DATA_LIST();
    List<IndexFlowChartData> INDEX_FLOW_CHART_DATA2_LIST();
}
