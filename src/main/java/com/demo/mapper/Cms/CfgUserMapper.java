package com.demo.mapper.Cms;

import com.demo.model.CfgUser;
import com.demo.model.CfgUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CfgUserMapper {
    int countByExample(CfgUserExample example);

    int deleteByExample(CfgUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgUser record);

    int insertSelective(CfgUser record);

    List<CfgUser> selectByExample(CfgUserExample example);

    CfgUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    int updateByExample(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    int updateByPrimaryKeySelective(CfgUser record);

    int updateByPrimaryKey(CfgUser record);
}