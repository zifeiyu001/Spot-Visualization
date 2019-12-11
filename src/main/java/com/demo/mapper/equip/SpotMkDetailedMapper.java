package com.demo.mapper.equip;
import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotMkDetailedMapper {

    List<SpotAlarm> SPOT_MK_QMJ_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_MK_ZMJ_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_MK_BZMJ_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_MK_ZB_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_MK_XLQ_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_MK_PD_DETAILED_LIST(@Param("param") String param);
}
