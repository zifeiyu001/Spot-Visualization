package com.demo.mapper.equip.mk.bzmj;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotBzmjMapper {

    List<SpotStatistics> SPOT_BZMJ_LIST();
}
