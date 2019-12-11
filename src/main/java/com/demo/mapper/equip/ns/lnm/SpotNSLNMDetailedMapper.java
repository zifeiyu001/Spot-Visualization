package com.demo.mapper.equip.ns.lnm;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSLNMDetailedMapper {

    List<detailedData> NS_LNM_SB_Detailed_LIST();
    List<detailedData> NS_LNM_DY_Detailed_LIST();
    List<detailedData> NS_LNM_SC_Detailed_LIST();
}
