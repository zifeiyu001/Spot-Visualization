package com.demo.mapper.Cms.equip.ts.glj2;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotTSGLJ2DetailedMapper {

    List<detailedData> TS_GLJ2_SB_Detailed_LIST();
    List<detailedData> TS_GLJ2_DY_Detailed_LIST();
    List<detailedData> TS_GLJ2_SC_Detailed_LIST();
}
