package com.demo.mapper.equip.ns.wnm;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSWNMDetailedMapper {

    List<detailedData> NS_WNM_SB_Detailed_LIST();
    List<detailedData> NS_WNM_DY_Detailed_LIST();
    List<detailedData> NS_WNM_SC_Detailed_LIST();
}
