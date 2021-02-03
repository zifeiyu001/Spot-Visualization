package com.demo.mapper.Cms.equip.ns.wnm;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmNSWNMMapper {

    List<SpotAlarm> NS_WNM_ALARM_LIST();

}
