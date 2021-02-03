package com.demo.mapper.Cms.process.sk;

import com.demo.model.equip.DefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SK1DefectTreatmentMapper {

    List<DefectTreatment> SK_DEFECT_TREATMENT_LIST();
}
