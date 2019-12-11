package com.demo.mapper.equip.ns.wnm;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSWNMMapper {
    List<SpotStatistics> SPOT_NS_WNM_LIST();

}
