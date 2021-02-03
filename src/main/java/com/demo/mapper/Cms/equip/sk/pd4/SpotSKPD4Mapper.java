package com.demo.mapper.Cms.equip.sk.pd4;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKPD4Mapper {
    List<SpotStatistics> SPOT_SK_PD4_LIST();
}
