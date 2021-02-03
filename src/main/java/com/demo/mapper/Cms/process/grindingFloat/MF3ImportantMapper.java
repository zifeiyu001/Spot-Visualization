package com.demo.mapper.Cms.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF3Spot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF3ImportantMapper {
    List<MF3Spot> MF_3_IMPORTANT_LIST(@Param("param") String param);
}
