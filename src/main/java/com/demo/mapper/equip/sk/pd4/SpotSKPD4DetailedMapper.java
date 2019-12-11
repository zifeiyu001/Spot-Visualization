package com.demo.mapper.equip.sk.pd4;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKPD4DetailedMapper {

    List<detailedData> SK_PD4_SB_Detailed_LIST();
    List<detailedData> SK_PD4_DY_Detailed_LIST();
    List<detailedData> SK_PD4_SC_Detailed_LIST();
}
