package com.demo.mapper.equip.sk.zb;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKZBDetailedMapper {

    List<detailedData> SK_ZB_SB_Detailed_LIST();
    List<detailedData> SK_ZB_DY_Detailed_LIST();
    List<detailedData> SK_ZB_SC_Detailed_LIST();
}
