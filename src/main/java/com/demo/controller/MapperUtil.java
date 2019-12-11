package com.demo.controller;

import com.demo.mapper.index.IndexAlarmMapper;
import com.demo.model.equip.SpotAlarm;
import com.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Controller
public class MapperUtil {
    @Autowired
    private IndexAlarmMapper indexAlarmMapper;
    private  static MapperUtil mapperUtil;
    private IndexService indexService;
    @PostConstruct
    public void init(){
        mapperUtil =this;
        mapperUtil.indexAlarmMapper=this.indexAlarmMapper;
    }

    @PostMapping("/spot/index/alarm")
    @ResponseBody
    public  Map<String,Object> getIndex(@RequestBody Map<String, String> params , Model model) {
        String value = params.get("value");
        List<SpotAlarm> indexAlarms = mapperUtil.indexAlarmMapper.INDEX_ALARM_LIST(value);
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexAlarms);
        return map;
    }

}
