package com.demo.mapper.equip.gfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGfj3DetailedMapper {

    List<detailedData> SPOT_GFJ3_MK_LIST();
    List<detailedData> SPOT_GFJ3_DY_LIST();
    List<detailedData> SPOT_GFJ3_SC_LIST();
}
