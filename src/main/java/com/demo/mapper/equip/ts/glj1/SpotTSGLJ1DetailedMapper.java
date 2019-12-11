package com.demo.mapper.equip.ts.glj1;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotTSGLJ1DetailedMapper {

    List<detailedData> TS_GLJ1_SB_Detailed_LIST();
    List<detailedData> TS_GLJ1_DY_Detailed_LIST();
    List<detailedData> TS_GLJ1_SC_Detailed_LIST();
}
