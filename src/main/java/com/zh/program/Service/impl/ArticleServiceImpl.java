package com.zh.program.Service.impl;

import com.zh.program.Dao.ArticleMapper;
import com.zh.program.Entrty.Article;
import com.zh.program.Service.ArticleService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:36:13
 **/ 
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public int insert(Article record) {
        return this.articleMapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return this.articleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return this.articleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return this.articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return this.articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> selectAll(Map<Object, Object> param) {
        return this.articleMapper.selectAll(param);
    }

    @Override
    public List<Article> selectPaging(Map<Object, Object> param) {
        return this.articleMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.articleMapper.selectCount(param);
    }

    @Override
    public List<Article> selectByIndex(Map<Object, Object> map) {
        return this.articleMapper.selectByIndex(map);
    }

    @Override
    public List<Article> selectGroupByClink(Map<Object, Object> map) {
        return this.articleMapper.selectGroupByClink(map);
    }

    @Override
    public List<Article> selectDrawNotice(Map<Object, Object> map) {
        return this.articleMapper.selectDrawNotice(map);
    }
}