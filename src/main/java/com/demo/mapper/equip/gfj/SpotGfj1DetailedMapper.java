package com.demo.mapper.equip.gfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGfj1DetailedMapper {

    List<detailedData> SPOT_GFJ1_MK_LIST();
    List<detailedData> SPOT_GFJ1_DY_LIST();
    List<detailedData> SPOT_GFJ1_SC_LIST();
}
