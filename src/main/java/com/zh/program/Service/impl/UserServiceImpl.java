package com.zh.program.Service.impl;

import com.zh.program.Dao.UserMapper;
import com.zh.program.Entrty.User;
import com.zh.program.Service.UserService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-01 14:20:13
 **/ 
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll(Map<Object, Object> param) {
        return this.userMapper.selectAll(param);
    }

    @Override
    public List<User> selectPaging(Map<Object, Object> param) {
        return this.userMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.userMapper.selectCount(param);
    }

}