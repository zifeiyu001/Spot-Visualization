package com.demo.mapper.Cms.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF2Defect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF2DefectMapper {

    List<MF2Defect> MF_2_DEFECT_LIST(@Param("param") String param);
}
