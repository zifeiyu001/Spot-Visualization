package com.demo.mapper.equip.mk.zmj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotZmjDetailedMapper {

    List<detailedData> SPOT_MK_ZMJ_MK_LIST();
    List<detailedData> SPOT_MK_ZMJ_SC_LIST();
    List<detailedData> SPOT_MK_ZMJ_DY_LIST();
}
