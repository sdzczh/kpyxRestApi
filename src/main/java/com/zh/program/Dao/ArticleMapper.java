package com.zh.program.Dao;

import com.zh.program.Entrty.Article;
import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);

    int updateByPrimaryKey(Article record);

    int updateByPrimaryKeySelective(Article record);

    int deleteByPrimaryKey(Integer id);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll(Map<Object, Object> param);

    List<Article> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    List<Article> selectByIndex(Map<Object, Object> map);

    List<Article> selectGroupByClink(Map<Object, Object> map);

    List<Article> selectDrawNotice(Map<Object, Object> map);

    Integer selectCountDrawNotice(Map<Object, Object> map);
}