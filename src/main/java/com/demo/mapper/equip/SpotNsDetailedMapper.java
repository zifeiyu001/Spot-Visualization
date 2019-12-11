package com.demo.mapper.equip;
import com.demo.model.equip.SpotAlarm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface SpotNsDetailedMapper {

    List<SpotAlarm> SPOT_NS_TNM_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_NS_LNM_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_NS_WNM_DETAILED_LIST(@Param("param") String param);
    List<SpotAlarm> SPOT_NS_SGNM_DETAILED_LIST(@Param("param") String param);
}
