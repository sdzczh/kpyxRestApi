package com.zh.program.Service.impl;

import com.zh.program.Dao.SysUserMapper;
import com.zh.program.Entrty.SysUser;
import com.zh.program.Service.SysUserService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑实现类:管理员表 sys_user
 * 
 * @author: autogeneration
 * @date: 2019-04-23 10:33:13
 **/ 
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    public int insert(SysUser record) {
        return this.sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return this.sysUserMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return this.sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return this.sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> selectAll(Map<Object, Object> param) {
        return this.sysUserMapper.selectAll(param);
    }

    @Override
    public List<SysUser> selectPaging(Map<Object, Object> param) {
        return this.sysUserMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.sysUserMapper.selectCount(param);
    }
}