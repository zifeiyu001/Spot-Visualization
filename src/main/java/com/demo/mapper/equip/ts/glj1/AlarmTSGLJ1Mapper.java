package com.demo.mapper.equip.ts.glj1;

import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface AlarmTSGLJ1Mapper {

    List<SpotAlarm> TS_GLJ1_ALARM_LIST();

}
