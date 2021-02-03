package com.demo.mapper.Cms.equip.mk.zmj;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotZmjMapper {

    List<SpotStatistics> SPOT_ZMJ_LIST();
}
