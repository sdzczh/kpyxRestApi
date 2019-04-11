package com.zh.program.Dao;

import com.zh.program.Entrty.Videos;
import java.util.List;
import java.util.Map;

public interface VideosMapper {
    int insert(Videos record);

    int insertSelective(Videos record);

    int updateByPrimaryKey(Videos record);

    int updateByPrimaryKeySelective(Videos record);

    int deleteByPrimaryKey(Integer id);

    Videos selectByPrimaryKey(Integer id);

    List<Videos> selectAll(Map<Object, Object> param);

    List<Videos> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);
}