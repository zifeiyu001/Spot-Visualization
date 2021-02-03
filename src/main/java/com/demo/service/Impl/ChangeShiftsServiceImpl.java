package com.demo.service.Impl;


import com.demo.mapper.changeShifts.ChangeShiftsMapper;
import com.demo.mapper.changeShifts.ChangeShiftsSKSHSaveMapper;
import com.demo.model.changeShifts.ChangeShiftsConfig;
import com.demo.model.changeShifts.ChangeShiftsSpot;
import com.demo.model.changeShifts.jobs.CrushLime;
import com.demo.model.changeShifts.jobs.CrushLimeExample;
import com.demo.service.ChangeShiftsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**

 */
@Service
public class ChangeShiftsServiceImpl implements ChangeShiftsService {
    @Resource
    private ChangeShiftsMapper changeShiftsMapper;
    @Resource
    private ChangeShiftsSKSHSaveMapper changeShiftsSKSHSaveMapper;
    //获取用户信息
    @Override
    public List<ChangeShiftsConfig> getUserInfo(String userId) {
        return changeShiftsMapper.getUserInfo(userId);
    }
    //获取班组序号的班组
    @Override
    public  List<ChangeShiftsConfig>  getTeamNumInfo(Integer num){

        return changeShiftsMapper.getTeamNumInfo(num);

    }


    //获取岗位线路
    @Override
    public List<ChangeShiftsConfig> getStationRoutesInfo(String userId){
        return changeShiftsMapper.getStationRoutesInfo(userId);
    };

    //获取点检统计
    @Override
    public List<ChangeShiftsSpot> get_spot_statistics(String startTime,String endTime,String deptName,String routeNames){
        return changeShiftsMapper.get_spot_statistics( startTime, endTime, deptName, routeNames);
    };
    //查询是否有数据
    @Override
    public List<CrushLime> get_sksh_jjbData(String date,String deptName,String station,String shift){
        return changeShiftsMapper.get_sksh_jjbData( date, deptName, station, shift);
    };


    //碎矿石灰的mapper
    @Override
    public Integer crushLimeinsertSelective(CrushLime crushLime){
        return changeShiftsSKSHSaveMapper.insertSelective(crushLime);
    };
    @Override
    public  List<CrushLime> crushLimeSelectByExample(CrushLime crushLime){
        CrushLimeExample crushLimeExample =new CrushLimeExample();
        crushLimeExample.setDistinct(false);
        CrushLimeExample.Criteria criteria = crushLimeExample.createCriteria();

        criteria.andParam1EqualTo(crushLime.getParam1()).andParam2EqualTo(crushLime.getParam2())
        .andDeteEqualTo(crushLime.getDete()).andShiftEqualTo(crushLime.getShift());


        return changeShiftsSKSHSaveMapper.selectByExample(crushLimeExample);

    };
    @Override
    public Integer  updateByExample(CrushLime crushLime){
        CrushLimeExample crushLimeExample =new CrushLimeExample();
        crushLimeExample.isDistinct();
        CrushLimeExample.Criteria criteria = crushLimeExample.createCriteria();

        criteria.andParam1EqualTo(crushLime.getParam1()).andParam2EqualTo(crushLime.getParam2())
                .andDeteEqualTo(crushLime.getDete()).andShiftEqualTo(crushLime.getShift());
        System.out.println("impl----"+crushLime.getParam1()+"---"+crushLime.getParam2()+"---"+crushLime.getDete()+"--"+crushLime.getShift());
        return  changeShiftsSKSHSaveMapper.updateByExampleSelective(crushLime,crushLimeExample);
    };


}
