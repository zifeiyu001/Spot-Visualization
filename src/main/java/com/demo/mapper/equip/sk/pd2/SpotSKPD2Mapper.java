package com.demo.mapper.equip.sk.pd2;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKPD2Mapper {
    List<SpotStatistics> SPOT_SK_PD2_LIST();
//    List<IndexShow> SPOT_FX_GFJ2_LIST();
//    List<SpotStatistics> SPOT_FX_GFJ3_LIST();
}
