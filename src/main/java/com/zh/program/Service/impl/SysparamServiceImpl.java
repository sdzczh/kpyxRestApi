package com.zh.program.Service.impl;

import com.zh.program.Dao.SysparamMapper;
import com.zh.program.Entrty.Sysparam;
import com.zh.program.Service.SysparamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-15 16:27:17
 **/ 
@Service("sysparamService")
public class SysparamServiceImpl implements SysparamService {
    @Resource
    private SysparamMapper sysparamMapper;

    private static final Logger logger = LoggerFactory.getLogger(SysparamServiceImpl.class);

    @Override
    public int insert(Sysparam record) {
        return this.sysparamMapper.insert(record);
    }

    @Override
    public int insertSelective(Sysparam record) {
        return this.sysparamMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sysparam record) {
        return this.sysparamMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Sysparam record) {
        return this.sysparamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.sysparamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Sysparam selectByPrimaryKey(Integer id) {
        return this.sysparamMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Sysparam> selectAll(Map<Object, Object> param) {
        return this.sysparamMapper.selectAll(param);
    }

    @Override
    public List<Sysparam> selectPaging(Map<Object, Object> param) {
        return this.sysparamMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.sysparamMapper.selectCount(param);
    }

    @Override
    public String queryByKey(String key) {
        Map<Object, Object> map = new HashMap<>();
        map.put("keyName", key);
        List<Sysparam> sysparamList = this.sysparamMapper.selectAll(map);
        if(sysparamList.size() != 0){
            return sysparamList.get(0).getKeyValue();
        }
        return null;
    }
}