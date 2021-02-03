package com.demo.mapper.Cms.process.ts;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface TS1AlarmMapper {

    List<SpotAlarm> TS_1_ALARM_LIST();
}
