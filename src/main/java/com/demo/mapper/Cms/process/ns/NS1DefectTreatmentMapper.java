package com.demo.mapper.Cms.process.ns;

import com.demo.model.equip.DefectTreatment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface NS1DefectTreatmentMapper {

    List<DefectTreatment> NS_DEFECT_TREATMENT_LIST();
}
