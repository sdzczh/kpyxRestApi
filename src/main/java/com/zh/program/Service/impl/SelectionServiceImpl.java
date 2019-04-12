package com.zh.program.Service.impl;

import com.zh.program.Dao.SelectionMapper;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.SelectionService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:43:48
 **/ 
@Service("selectionService")
public class SelectionServiceImpl implements SelectionService {
    @Resource
    private SelectionMapper selectionMapper;

    private static final Logger logger = LoggerFactory.getLogger(SelectionServiceImpl.class);

    @Override
    public int insert(Selection record) {
        return this.selectionMapper.insert(record);
    }

    @Override
    public int insertSelective(Selection record) {
        return this.selectionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Selection record) {
        return this.selectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Selection record) {
        return this.selectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.selectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Selection selectByPrimaryKey(Integer id) {
        return this.selectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Selection> selectAll(Map<Object, Object> param) {
        return this.selectionMapper.selectAll(param);
    }

    @Override
    public List<Selection> selectPaging(Map<Object, Object> param) {
        return this.selectionMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.selectionMapper.selectCount(param);
    }

    @Override
    public List<Map<String, Object>> selectList(Map<Object, Object> map) {
        return this.selectionMapper.selectList(map);
    }
}