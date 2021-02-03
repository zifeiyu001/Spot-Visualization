package com.demo.mapper.Cms.equip.fxj;
import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotFxJbtMapper {
    List<SpotAlarm> ALARM_FX_JBT_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_JBT_SB_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_JBT_SC_LIST(@Param("equip") String equip);
    List<detailedData> SPOT_FX_JBT_DY_LIST(@Param("equip") String equip);
    List<SpotStatistics> SPOT_JBT_LIST(@Param("equip") String equip);
}
