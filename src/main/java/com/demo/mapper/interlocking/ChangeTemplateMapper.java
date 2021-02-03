package com.demo.mapper.interlocking;


import com.demo.model.interlocking.Interlocking;
import com.demo.model.universal.Maintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface ChangeTemplateMapper {

    List<Interlocking> ChangeTemplate_get_deptName();
    List<Interlocking> ChangeTemplate_get_routeName();
    List<Interlocking> ChangeTemplate_get_zoneName();
    List<Interlocking> ChangeTemplate_get_devName();
    List<Interlocking> ChangeTemplate_get_scPart();
    List<Interlocking> ChangeTemplate_get_content();
    List<Interlocking> changeTemplate_get_result(@Param("deptName") String deptName, @Param("routeName") String routeName,
                                                 @Param("zoneName") String zoneName, @Param("devName") String devName,
                                                 @Param("scPart") String scPart, @Param("scContent") String scContent);

    Integer changeTemplate_deleteData(@Param("id") String id);
    Integer changeTemplate_changeType(@Param("id") String id,@Param("abnormalHandleAdminType") String abnormalHandleAdminType);

}
