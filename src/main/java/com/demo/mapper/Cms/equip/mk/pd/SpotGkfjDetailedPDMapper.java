package com.demo.mapper.Cms.equip.mk.pd;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGkfjDetailedPDMapper {

    List<detailedData> SPOT_GKFJ_MK_DETAILED_PD_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_PD_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_PD_LIST();
}
