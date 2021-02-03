package com.demo.mapper.Cms.equip.fxj;
import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotFxXlqMapper {
    List<SpotAlarm> ALARM_FX_XLQ_LIST();
    List<detailedData> SPOT_FX_XLQ_SB_LIST();
    List<detailedData> SPOT_FX_XLQ_SC_LIST();
    List<SpotStatistics> SPOT_FX_XLQ_LIST();
}
