package com.demo.mapper.equip.sk.zb;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmSKZBMapper {

    List<SpotAlarm> SK_ZB_ALARM_LIST();

}
