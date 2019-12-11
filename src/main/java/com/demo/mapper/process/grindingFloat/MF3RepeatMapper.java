package com.demo.mapper.process.grindingFloat;

import com.demo.model.process.grindingFloat.MF3Repeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */
@Mapper
public interface MF3RepeatMapper {

    List<MF3Repeat> MF_3_REPEAT_LIST(@Param("param") String param);
}
