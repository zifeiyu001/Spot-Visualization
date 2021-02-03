package com.demo.mapper.Cms.equip.mk.qmj;


import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmQmjMapper {

    List<SpotAlarm> ALARM_QMJ_LIST();
}
