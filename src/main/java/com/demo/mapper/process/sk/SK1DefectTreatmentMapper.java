package com.demo.mapper.process.sk;

import com.demo.model.equip.DefectTreatment;
import com.demo.model.process.grindingFloat.SBMKDefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SK1DefectTreatmentMapper {

    List<DefectTreatment> SK_DEFECT_TREATMENT_LIST();
}
