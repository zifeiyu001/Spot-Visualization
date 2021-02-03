package com.demo.mapper.Cms.process.sk;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SK1AlarmMapper {

    List<SpotAlarm> SK_1_ALARM_LIST();
}
