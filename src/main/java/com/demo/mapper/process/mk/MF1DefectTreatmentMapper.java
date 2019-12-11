package com.demo.mapper.process.mk;

import com.demo.model.equip.DefectTreatment;
import com.demo.model.process.grindingFloat.SBMKDefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface MF1DefectTreatmentMapper {

    List<SBMKDefectTreatment> SBMK_DEFECT_TREATMENT_LIST();
}
