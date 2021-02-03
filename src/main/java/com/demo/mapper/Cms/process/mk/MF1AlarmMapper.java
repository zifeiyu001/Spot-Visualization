package com.demo.mapper.Cms.process.mk;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface MF1AlarmMapper {

    List<SpotAlarm> MF_1_ALARM_LIST();
}
