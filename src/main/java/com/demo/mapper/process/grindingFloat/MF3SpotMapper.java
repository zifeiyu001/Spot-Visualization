package com.demo.mapper.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF3Spot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF3SpotMapper {


    List<MF3Spot> MF_3_SPOT_LIST(@Param("param") String param);
}
