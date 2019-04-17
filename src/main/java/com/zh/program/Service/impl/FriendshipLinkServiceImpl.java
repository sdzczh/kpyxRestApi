package com.zh.program.Service.impl;

import com.zh.program.Dao.FriendshipLinkMapper;
import com.zh.program.Entrty.FriendshipLink;
import com.zh.program.Service.FriendshipLinkService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-17 10:36:00
 **/ 
@Service("friendshipLinkService")
public class FriendshipLinkServiceImpl implements FriendshipLinkService {
    @Resource
    private FriendshipLinkMapper friendshipLinkMapper;

    private static final Logger logger = LoggerFactory.getLogger(FriendshipLinkServiceImpl.class);

    @Override
    public int insert(FriendshipLink record) {
        return this.friendshipLinkMapper.insert(record);
    }

    @Override
    public int insertSelective(FriendshipLink record) {
        return this.friendshipLinkMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(FriendshipLink record) {
        return this.friendshipLinkMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(FriendshipLink record) {
        return this.friendshipLinkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.friendshipLinkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FriendshipLink selectByPrimaryKey(Integer id) {
        return this.friendshipLinkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FriendshipLink> selectAll(Map<Object, Object> param) {
        return this.friendshipLinkMapper.selectAll(param);
    }

    @Override
    public List<FriendshipLink> selectPaging(Map<Object, Object> param) {
        return this.friendshipLinkMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.friendshipLinkMapper.selectCount(param);
    }
}