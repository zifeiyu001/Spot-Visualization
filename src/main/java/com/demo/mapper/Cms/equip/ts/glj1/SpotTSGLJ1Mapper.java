package com.demo.mapper.Cms.equip.ts.glj1;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotTSGLJ1Mapper {
    List<SpotStatistics> SPOT_TS_GLJ1_LIST();

}
