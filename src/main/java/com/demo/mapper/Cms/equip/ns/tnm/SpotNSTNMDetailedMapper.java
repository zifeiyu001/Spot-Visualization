package com.demo.mapper.Cms.equip.ns.tnm;
import com.demo.model.equip.detailedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface SpotNSTNMDetailedMapper {

    List<detailedData> NS_TNM_SB_Detailed_LIST();
    List<detailedData> NS_TNM_DY_Detailed_LIST();
    List<detailedData> NS_TNM_SC_Detailed_LIST();
}
