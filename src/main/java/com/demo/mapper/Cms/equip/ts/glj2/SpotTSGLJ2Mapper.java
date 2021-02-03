package com.demo.mapper.Cms.equip.ts.glj2;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotTSGLJ2Mapper {
    List<SpotStatistics> SPOT_TS_GLJ2_LIST();

}
