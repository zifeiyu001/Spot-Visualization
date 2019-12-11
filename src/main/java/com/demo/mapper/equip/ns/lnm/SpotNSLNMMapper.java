package com.demo.mapper.equip.ns.lnm;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSLNMMapper {
    List<SpotStatistics> SPOT_NS_LNM_LIST();

}
