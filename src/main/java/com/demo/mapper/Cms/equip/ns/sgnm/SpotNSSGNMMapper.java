package com.demo.mapper.Cms.equip.ns.sgnm;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSSGNMMapper {
    List<SpotStatistics> SPOT_NS_SGNM_LIST();

}
