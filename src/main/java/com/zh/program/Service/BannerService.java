package com.zh.program.Service;

import com.zh.program.Entrty.Banner;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:37:14
 **/ 
public interface BannerService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int insert(Banner record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int insertSelective(Banner record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int updateByPrimaryKey(Banner record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int updateByPrimaryKeySelective(Banner record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    Banner selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    List<Banner> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    List<Banner> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:37:14
     **/ 
    int selectCount(Map<Object, Object> param);
}