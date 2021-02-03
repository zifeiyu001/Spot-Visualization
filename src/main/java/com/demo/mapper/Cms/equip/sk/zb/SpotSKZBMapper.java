package com.demo.mapper.Cms.equip.sk.zb;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKZBMapper {
    List<SpotStatistics> SPOT_SK_ZB_LIST();
//    List<IndexShow> SPOT_FX_GFJ2_LIST();
//    List<SpotStatistics> SPOT_FX_GFJ3_LIST();
}
