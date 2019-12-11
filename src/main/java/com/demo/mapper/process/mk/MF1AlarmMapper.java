package com.demo.mapper.process.mk;

import com.demo.model.equip.SpotAlarm;
import com.demo.model.process.grindingFloat.MF1Alarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF1AlarmMapper {

    List<SpotAlarm> MF_1_ALARM_LIST();
}
