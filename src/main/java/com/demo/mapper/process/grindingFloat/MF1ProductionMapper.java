package com.demo.mapper.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF1Production;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**

 */
@Mapper
public interface MF1ProductionMapper {

    List<MF1Production> MF_1_PRODUCTION_LIST(Map<String ,Object> map);
}
