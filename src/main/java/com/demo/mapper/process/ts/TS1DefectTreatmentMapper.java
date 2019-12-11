package com.demo.mapper.process.ts;

import com.demo.model.equip.DefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface TS1DefectTreatmentMapper {

    List<DefectTreatment> TS_DEFECT_TREATMENT_LIST();
}
