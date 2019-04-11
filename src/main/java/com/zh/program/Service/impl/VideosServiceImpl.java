package com.zh.program.Service.impl;

import com.zh.program.Dao.VideosMapper;
import com.zh.program.Entrty.Videos;
import com.zh.program.Service.VideosService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:44:36
 **/ 
@Service("videosService")
public class VideosServiceImpl implements VideosService {
    @Resource
    private VideosMapper videosMapper;

    private static final Logger logger = LoggerFactory.getLogger(VideosServiceImpl.class);

    @Override
    public int insert(Videos record) {
        return this.videosMapper.insert(record);
    }

    @Override
    public int insertSelective(Videos record) {
        return this.videosMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Videos record) {
        return this.videosMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Videos record) {
        return this.videosMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.videosMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Videos selectByPrimaryKey(Integer id) {
        return this.videosMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Videos> selectAll(Map<Object, Object> param) {
        return this.videosMapper.selectAll(param);
    }

    @Override
    public List<Videos> selectPaging(Map<Object, Object> param) {
        return this.videosMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.videosMapper.selectCount(param);
    }
}