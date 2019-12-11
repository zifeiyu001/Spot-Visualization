package com.demo.mapper.equip.mk.zmj;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmZmjMapper {

    List<SpotAlarm> ALARM_ZMJ_LIST();
}
