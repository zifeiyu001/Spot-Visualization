package com.demo.mapper.equip.ns.sgnm;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmNSSGNMMapper {

    List<SpotAlarm> NS_SGNM_ALARM_LIST();

}
