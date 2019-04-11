package com.zh.program.Service;

import com.zh.program.Entrty.Article;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:36:13
 **/ 
public interface ArticleService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int insert(Article record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int insertSelective(Article record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int updateByPrimaryKey(Article record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int updateByPrimaryKeySelective(Article record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    Article selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    List<Article> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    List<Article> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:36:13
     **/ 
    int selectCount(Map<Object, Object> param);
}