package com.demo.mapper.equip.ns.sgnm;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSSGNMDetailedMapper {

    List<detailedData> NS_SGNM_SB_Detailed_LIST();
    List<detailedData> NS_SGNM_DY_Detailed_LIST();
    List<detailedData> NS_SGNM_SC_Detailed_LIST();
}
