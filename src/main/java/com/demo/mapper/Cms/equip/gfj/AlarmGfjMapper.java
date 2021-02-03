package com.demo.mapper.Cms.equip.gfj;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmGfjMapper {

    List<SpotAlarm> FX_GFJ_1_ALARM_LIST();
    List<SpotAlarm> FX_GFJ_2_ALARM_LIST();
    List<SpotAlarm> FX_GFJ_3_ALARM_LIST();
}
