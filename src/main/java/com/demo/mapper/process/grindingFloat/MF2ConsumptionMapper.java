package com.demo.mapper.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF2Consumption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF2ConsumptionMapper {

    List<MF2Consumption> MF_2_CONSUMPTION_LIST(@Param("param") String param   );
}
