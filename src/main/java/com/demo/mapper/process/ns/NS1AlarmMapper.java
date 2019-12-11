package com.demo.mapper.process.ns;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface NS1AlarmMapper {

    List<SpotAlarm> NS_1_ALARM_LIST();
}
