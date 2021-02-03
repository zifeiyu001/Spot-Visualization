package com.demo.mapper.Cms.process.fx;

import com.demo.model.equip.DefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface FX1DefectTreatmentMapper {

    List<DefectTreatment> FX_1_DEFECT_TREATMENT_LIST();
}
