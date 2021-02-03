package com.demo.mapper.Cms.equip.mk.bzmj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotBzmjDetailedMapper {

    List<detailedData> SPOT_MK_BZMJ_MF_LIST();
    List<detailedData> SPOT_MK_BZMJ_SC_LIST();
    List<detailedData> SPOT_MK_BZMJ_DY_LIST();
}
