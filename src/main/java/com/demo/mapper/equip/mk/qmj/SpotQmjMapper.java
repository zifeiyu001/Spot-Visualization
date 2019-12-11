package com.demo.mapper.equip.mk.qmj;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotQmjMapper {
    List<SpotStatistics> SPOT_QMJ_LIST();
}
