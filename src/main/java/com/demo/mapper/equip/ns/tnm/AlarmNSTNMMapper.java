package com.demo.mapper.equip.ns.tnm;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmNSTNMMapper {

    List<SpotAlarm> NS_TNM_ALARM_LIST();

}
