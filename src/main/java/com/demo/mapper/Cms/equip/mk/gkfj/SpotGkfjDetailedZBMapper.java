package com.demo.mapper.Cms.equip.mk.gkfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGkfjDetailedZBMapper {

    List<detailedData> SPOT_GKFJ_MK_DETAILED_ZB_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_ZB_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_ZB_LIST();
}
