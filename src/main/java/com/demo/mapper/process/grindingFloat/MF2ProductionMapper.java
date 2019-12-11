package com.demo.mapper.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF2Production;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF2ProductionMapper {

    List<MF2Production> MF_2_PRODUCTION_LIST(@Param("param") String param);
}
