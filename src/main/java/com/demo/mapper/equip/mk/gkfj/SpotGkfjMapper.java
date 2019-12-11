package com.demo.mapper.equip.mk.gkfj;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGkfjMapper {
    List<SpotStatistics> SPOT_MK_PD_LIST();
    List<SpotStatistics> SPOT_MK_ZB_LIST();
    List<SpotStatistics> SPOT_MK_XLQ_LIST();
}
