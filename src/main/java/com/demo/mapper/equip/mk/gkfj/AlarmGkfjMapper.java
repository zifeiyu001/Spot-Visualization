package com.demo.mapper.equip.mk.gkfj;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmGkfjMapper {

    List<SpotAlarm> MK_PD_ALARM_LIST();
    List<SpotAlarm> MK_ZB_ALARM_LIST();
    List<SpotAlarm> MK_XLQ_ALARM_LIST();
}
