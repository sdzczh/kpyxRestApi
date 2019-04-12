package com.zh.program.Service;

import com.zh.program.Entrty.Selection;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:43:48
 **/ 
public interface SelectionService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int insert(Selection record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int insertSelective(Selection record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int updateByPrimaryKey(Selection record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int updateByPrimaryKeySelective(Selection record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    Selection selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/
    List<Selection> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    List<Selection> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:48
     **/ 
    int selectCount(Map<Object, Object> param);

    List<Map<String, Object>> selectList(Map<Object, Object> map);
}