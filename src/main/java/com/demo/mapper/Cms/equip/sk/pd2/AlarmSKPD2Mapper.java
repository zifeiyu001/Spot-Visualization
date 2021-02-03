package com.demo.mapper.Cms.equip.sk.pd2;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmSKPD2Mapper {

    List<SpotAlarm> SK_PD2_ALARM_LIST();

}
