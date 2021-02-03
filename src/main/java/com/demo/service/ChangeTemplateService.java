package com.demo.service;
import com.demo.model.interlocking.Interlocking;
import java.util.List;


public interface ChangeTemplateService {

    /*修改报警类型模板*/
    List<Interlocking> changeTemplate_get_deptName();
    List<Interlocking> changeTemplate_get_routeName();
    List<Interlocking> changeTemplate_get_zoneName();
    List<Interlocking> changeTemplate_get_devName();
    List<Interlocking> changeTemplate_get_scPart();
    List<Interlocking> changeTemplate_get_content();
    List<Interlocking> changeTemplate_get_result(String deptName, String routeName, String zoneName,String devName, String scPart,String scContent);
    Integer changeTemplate_deleteData(String id);
    Integer changeTemplate_changeType(String id,String abnormalHandleAdminType);

}