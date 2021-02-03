package com.demo.mapper.Cms.equip.mk.bzmj;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmBzmjMapper {

    List<SpotAlarm> ALARM_BZMJ_LIST();
}
