package com.demo.mapper.Cms.equip.gfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGfj2DetailedMapper {

    List<detailedData> SPOT_GFJ2_MK_LIST();
    List<detailedData> SPOT_GFJ2_DY_LIST();
    List<detailedData> SPOT_GFJ2_SC_LIST();
}
