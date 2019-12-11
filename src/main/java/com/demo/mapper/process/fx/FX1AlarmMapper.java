package com.demo.mapper.process.fx;

import com.demo.model.equip.SpotAlarm;
import com.demo.model.equip.SpotStatistics;
import com.demo.model.process.grindingFloat.MF1Alarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface FX1AlarmMapper {

    List<SpotAlarm> FX_1_ALARM_LIST();
}
