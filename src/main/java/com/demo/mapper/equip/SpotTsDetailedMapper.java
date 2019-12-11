package com.demo.mapper.equip;
import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotTsDetailedMapper {

    List<SpotAlarm> SPOT_TS_GLJ1_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_TS_GLJ2_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_TS_YLJ3_DETAILED_LIST(@Param("param") String param);

}
