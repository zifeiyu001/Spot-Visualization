package com.demo.mapper.Cms.equip.sk.pd2;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKPD2DetailedMapper {

    List<detailedData> SK_PD2_SB_Detailed_LIST();
    List<detailedData> SK_PD2_DY_Detailed_LIST();
    List<detailedData> SK_PD2_SC_Detailed_LIST();
}
