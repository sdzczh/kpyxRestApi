package com.zh.program.Dao;

import com.zh.program.Entrty.FriendshipLink;
import java.util.List;
import java.util.Map;

public interface FriendshipLinkMapper {
    int insert(FriendshipLink record);

    int insertSelective(FriendshipLink record);

    int updateByPrimaryKey(FriendshipLink record);

    int updateByPrimaryKeySelective(FriendshipLink record);

    int deleteByPrimaryKey(Integer id);

    FriendshipLink selectByPrimaryKey(Integer id);

    List<FriendshipLink> selectAll(Map<Object, Object> param);

    List<FriendshipLink> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);
}