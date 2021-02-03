package com.demo.mapper.Cms.process.fx;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface FX1AlarmMapper {

    List<SpotAlarm> FX_1_ALARM_LIST();
}
