package com.zh.program.Service.impl;

import com.zh.program.Common.utils.RedisUtil;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Dao.SysparamMapper;
import com.zh.program.Entrty.Sysparam;
import com.zh.program.Service.SysparamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String, String> redis;


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
        String redisKey = "kpyx:sysparam:" + key;
        String value = RedisUtil.searchString(redis, redisKey);
        if(StrUtils.isBlank(value)) {
            Map<Object, Object> map = new HashMap<>();
            map.put("keyName", key);
            List<Sysparam> sysparamList = this.sysparamMapper.selectAll(map);
            if (sysparamList.size() != 0) {
                Sysparam sysparam = sysparamList.get(0);
                RedisUtil.addString(redis, redisKey, sysparam.getKeyValue());
                return sysparam.getKeyValue();
            }
            return null;
        }else{
            return value;
        }
    }

    @Override
    public Sysparam selectByKey(String key) {
        String redisKey = "kpyx:sysparam:" + key;
        Sysparam sysparam = RedisUtil.searchStringObj(redis, redisKey, Sysparam.class);
        if(sysparam == null) {
            Map<Object, Object> map = new HashMap<>();
            map.put("keyName", key);
            List<Sysparam> sysparamList = this.sysparamMapper.selectAll(map);
            if (sysparamList.size() != 0) {
                sysparam = sysparamList.get(0);
                RedisUtil.addStringObj(redis, redisKey, sysparam);
                return sysparam;
            }
            return null;
        }else{
            return sysparam;
        }
    }

    @Override
    public void updateByKey(String key, String keyValue) {
        String redisKey = "kpyx:sysparam:" + key;
        RedisUtil.addString(redis, redisKey, keyValue);
        sysparamMapper.updateByKey(key, keyValue);
    }
}