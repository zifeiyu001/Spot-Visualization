package com.demo.mapper.Cms.equip.sk.ep;
import com.demo.model.equip.SpotStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotSKEPMapper {
    List<SpotStatistics> SPOT_SK_EP_LIST();

}
