package com.zh.program.Service;

import com.zh.program.Entrty.Videos;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:44:36
 **/ 
public interface VideosService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int insert(Videos record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int insertSelective(Videos record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int updateByPrimaryKey(Videos record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int updateByPrimaryKeySelective(Videos record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    Videos selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    List<Videos> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    List<Videos> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:44:36
     **/ 
    int selectCount(Map<Object, Object> param);
}