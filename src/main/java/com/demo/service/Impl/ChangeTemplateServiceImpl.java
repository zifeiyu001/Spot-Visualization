package com.demo.service.Impl;


import com.demo.mapper.changeShifts.ChangeShiftsMapper;
import com.demo.mapper.changeShifts.ChangeShiftsSKSHSaveMapper;
import com.demo.mapper.interlocking.ChangeTemplateMapper;
import com.demo.model.changeShifts.ChangeShiftsConfig;
import com.demo.model.changeShifts.ChangeShiftsSpot;
import com.demo.model.changeShifts.jobs.CrushLime;
import com.demo.model.changeShifts.jobs.CrushLimeExample;
import com.demo.model.interlocking.Interlocking;
import com.demo.service.ChangeShiftsService;
import com.demo.service.ChangeTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**

 */
@Service
public class ChangeTemplateServiceImpl implements ChangeTemplateService {
    @Resource
    private ChangeTemplateMapper changeTemplateMapper;

    @Override
    public List<Interlocking> changeTemplate_get_deptName() {
        return changeTemplateMapper.ChangeTemplate_get_deptName();
    }

    @Override
    public List<Interlocking> changeTemplate_get_routeName() {
        return changeTemplateMapper.ChangeTemplate_get_routeName();
    }

    @Override
    public List<Interlocking> changeTemplate_get_zoneName() {
        return changeTemplateMapper.ChangeTemplate_get_zoneName();
    }

    @Override
    public List<Interlocking> changeTemplate_get_devName() {
        return changeTemplateMapper.ChangeTemplate_get_devName();
    }

    @Override
    public List<Interlocking> changeTemplate_get_scPart() {
        return changeTemplateMapper.ChangeTemplate_get_scPart();
    }

    @Override
    public List<Interlocking> changeTemplate_get_content() {
        return changeTemplateMapper.ChangeTemplate_get_content();
    }
    @Override
    public List<Interlocking> changeTemplate_get_result(String deptName, String routeName, String zoneName,String devName, String scPart,String scContent) {
//        System.out.println(deptName+"=="+routeName+"=="+zoneName+"=="+devName+"=="+scPart+"=="+scContent);
        return changeTemplateMapper.changeTemplate_get_result( deptName,  routeName,  zoneName, devName,  scPart, scContent);
    }
    @Override
    public Integer changeTemplate_deleteData(String id) {
        return changeTemplateMapper.changeTemplate_deleteData(id);
    }
    @Override
    public Integer changeTemplate_changeType(String id,String abnormalHandleAdminType) {
        return changeTemplateMapper.changeTemplate_changeType(id,abnormalHandleAdminType);
    }

}
