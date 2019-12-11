package com.demo.mapper.equip.mk.gkfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGkfjDetailedXLQMapper {

    List<detailedData> SPOT_GKFJ_MK_DETAILED_XLQ_LIST();
    List<detailedData> SPOT_GKFJ_DY_DETAILED_XLQ_LIST();
    List<detailedData> SPOT_GKFJ_SC_DETAILED_XLQ_LIST();
}
