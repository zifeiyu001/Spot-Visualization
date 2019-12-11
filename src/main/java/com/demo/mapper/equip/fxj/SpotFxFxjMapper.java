package com.demo.mapper.equip.fxj;
import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotFxFxjMapper {
    List<SpotAlarm> ALARM_FX_FXJ_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_FXJ_SB_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_FXJ_SC_LIST(@Param("equip") String equip );
    List<detailedData> SPOT_FX_FXJ_DY_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_FXJ2_SB_LIST(@Param("equip") String equip);
    List<SpotStatistics> SPOT_FXJ_LIST(@Param("equip") String equip);
}
