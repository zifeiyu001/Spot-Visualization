package com.demo.mapper.Cms.equip.gfj;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGfjMapper {
    List<SpotStatistics> SPOT_FX_GFJ1_LIST();
    List<SpotStatistics> SPOT_FX_GFJ2_LIST();
    List<SpotStatistics> SPOT_FX_GFJ3_LIST();
}
