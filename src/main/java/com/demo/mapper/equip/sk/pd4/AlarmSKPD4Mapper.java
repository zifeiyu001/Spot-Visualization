package com.demo.mapper.equip.sk.pd4;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmSKPD4Mapper {

    List<SpotAlarm> SK_PD4_ALARM_LIST();

}
