package com.demo.mapper.Cms.equip.ts.glj2;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmTSGLJ2Mapper {

    List<SpotAlarm> TS_GLJ2_ALARM_LIST();

}
