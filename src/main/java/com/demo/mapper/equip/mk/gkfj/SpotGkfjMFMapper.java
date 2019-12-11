package com.demo.mapper.equip.mk.gkfj;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotGkfjMFMapper {

    List<detailedData> SPOT_GKFJ_MF_LIST();
}
