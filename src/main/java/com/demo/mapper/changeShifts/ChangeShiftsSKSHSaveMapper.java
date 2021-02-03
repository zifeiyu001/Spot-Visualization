package com.demo.mapper.changeShifts;

import java.util.List;

import com.demo.model.changeShifts.jobs.CrushLime;
import com.demo.model.changeShifts.jobs.CrushLimeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChangeShiftsSKSHSaveMapper {
    int countByExample(@Param("example") ChangeShiftsSKSHSaveMapper example);

    int deleteByExample(@Param("example") CrushLimeExample example);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("record") CrushLime record);

    int insertSelective(@Param("record") CrushLime record);

    List<CrushLime> selectByExample(@Param("example") CrushLimeExample example);

    CrushLime selectByPrimaryKey(@Param("id") Integer id);

    int updateByExampleSelective(@Param("record") CrushLime record, @Param("example") CrushLimeExample example);

    int updateByExample(@Param("record") CrushLime record, @Param("example") CrushLimeExample example);

    int updateByPrimaryKeySelective(@Param("record") CrushLime record);

    int updateByPrimaryKey(@Param("record") CrushLime record);
}