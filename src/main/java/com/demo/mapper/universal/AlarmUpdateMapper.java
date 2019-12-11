package com.demo.mapper.universal;


import com.demo.model.universal.LoginUser;
import com.demo.model.universal.WebDxjBj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

 */

//@Component(value = "indexAlarmMapper")
@Mapper
public interface AlarmUpdateMapper {

    Integer CURRENCY_ALARM_UPDATE(@Param("name") String name, @Param("id") String id, @Param("remark") String remark);

    LoginUser get_login_name(@Param("name") String name);

    List<WebDxjBj> search_alarm_id(@Param("id") String id); //报警id



}
