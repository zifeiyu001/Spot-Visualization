package com.demo.mapper.equip.ns.tnm;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSTNMMapper {
    List<SpotStatistics> SPOT_NS_TNM_LIST();

}
