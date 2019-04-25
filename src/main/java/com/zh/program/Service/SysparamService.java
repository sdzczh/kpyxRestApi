package com.zh.program.Service;

import com.zh.program.Entrty.Sysparam;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-15 16:27:17
 **/ 
public interface SysparamService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int insert(Sysparam record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int insertSelective(Sysparam record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int updateByPrimaryKey(Sysparam record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int updateByPrimaryKeySelective(Sysparam record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    Sysparam selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    List<Sysparam> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    List<Sysparam> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-15 16:27:17
     **/ 
    int selectCount(Map<Object, Object> param);

    /**
     * 根据key查value
     * @param key
     * @return
     */
    String queryByKey(String key);

    Sysparam selectByKey(String key);

    void updateByKey(String key, String keyValue);
}