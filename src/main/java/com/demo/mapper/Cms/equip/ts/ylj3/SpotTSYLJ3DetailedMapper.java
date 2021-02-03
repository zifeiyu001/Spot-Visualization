package com.demo.mapper.Cms.equip.ts.ylj3;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotTSYLJ3DetailedMapper {

    List<detailedData> TS_YLJ3_SB_Detailed_LIST();
    List<detailedData> TS_YLJ3_DY_Detailed_LIST();
    List<detailedData> TS_YLJ3_SC_Detailed_LIST();
}
