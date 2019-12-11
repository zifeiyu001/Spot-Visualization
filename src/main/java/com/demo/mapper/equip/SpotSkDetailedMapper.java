package com.demo.mapper.equip;
import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotSkDetailedMapper {

    List<SpotAlarm> SPOT_SK_ZB_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_SK_EP_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_SK_PD2_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_SK_PD4_DETAILED_LIST(@Param("param") String param);
}
