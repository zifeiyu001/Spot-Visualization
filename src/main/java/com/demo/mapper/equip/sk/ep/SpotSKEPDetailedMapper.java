package com.demo.mapper.equip.sk.ep;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKEPDetailedMapper {

    List<detailedData> SK_EP_SB_Detailed_LIST();
    List<detailedData> SK_EP_DY_Detailed_LIST();
    List<detailedData> SK_EP_SC_Detailed_LIST();
}
