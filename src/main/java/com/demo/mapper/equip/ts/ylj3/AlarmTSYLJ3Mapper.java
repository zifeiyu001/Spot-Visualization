package com.demo.mapper.equip.ts.ylj3;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmTSYLJ3Mapper {

    List<SpotAlarm> TS_YLJ3_ALARM_LIST();

}
