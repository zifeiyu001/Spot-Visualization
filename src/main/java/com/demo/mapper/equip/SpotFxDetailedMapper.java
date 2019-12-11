package com.demo.mapper.equip;
import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotFxDetailedMapper {

    List<SpotAlarm> SPOT_FX_GFJ1_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_FX_GFJ2_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_FX_GFJ3_DETAILED_LIST(@Param("param") String param);

    List<SpotAlarm> SPOT_FX_FXJ1_DETAILED_LIST(@Param("param") String param,@Param("equip") String equip);
    List<SpotAlarm> SPOT_FX_FXJ2_DETAILED_LIST(@Param("param") String param,@Param("equip") String equip);
    List<SpotAlarm> SPOT_FX_XLQ_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_FX_JBT_DETAILED_LIST(@Param("param") String param,@Param("equip") String equip);
}
