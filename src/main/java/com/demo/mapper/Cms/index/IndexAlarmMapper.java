package com.demo.mapper.Cms.index;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */

//@Component(value = "indexAlarmMapper")
@Mapper
public interface IndexAlarmMapper {

    List<SpotAlarm> INDEX_ALARM_LIST(@Param("param") String param);
}
