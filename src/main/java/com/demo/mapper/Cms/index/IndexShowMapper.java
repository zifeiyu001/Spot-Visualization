package com.demo.mapper.Cms.index;

import com.demo.model.index.IndexShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

 */
@Mapper
public interface IndexShowMapper {

    List<IndexShow> INDEX_SHOW_LIST();
    List<IndexShow> INDEX_SHOW1_LIST();
}
