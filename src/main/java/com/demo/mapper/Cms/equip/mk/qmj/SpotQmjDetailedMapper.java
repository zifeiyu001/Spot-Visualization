package com.demo.mapper.Cms.equip.mk.qmj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotQmjDetailedMapper {

    List<detailedData> SPOT_MK_QMJ_MK_LIST();
    List<detailedData> SPOT_MK_QMJ_DY_LIST();
    List<detailedData> SPOT_MK_QMJ_SC_LIST();
}
