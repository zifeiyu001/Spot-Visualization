package com.demo.mapper.Cms.equip.sk.ep;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmSKEPMapper {

    List<SpotAlarm> SK_EP_ALARM_LIST();

}
