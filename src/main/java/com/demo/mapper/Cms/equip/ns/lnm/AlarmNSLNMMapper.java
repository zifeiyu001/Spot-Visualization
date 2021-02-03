package com.demo.mapper.Cms.equip.ns.lnm;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmNSLNMMapper {

    List<SpotAlarm> NS_LNM_ALARM_LIST();

}
