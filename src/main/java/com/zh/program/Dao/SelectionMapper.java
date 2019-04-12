package com.zh.program.Dao;

import com.zh.program.Entrty.Selection;
import java.util.List;
import java.util.Map;

public interface SelectionMapper {
    int insert(Selection record);

    int insertSelective(Selection record);

    int updateByPrimaryKey(Selection record);

    int updateByPrimaryKeySelective(Selection record);

    int deleteByPrimaryKey(Integer id);

    Selection selectByPrimaryKey(Integer id);

    List<Selection> selectAll(Map<Object, Object> param);

    List<Selection> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    List<Map<String, Object>> selectList(Map<Object, Object> map);
}