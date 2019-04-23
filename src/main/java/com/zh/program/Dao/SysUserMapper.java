package com.zh.program.Dao;

import com.zh.program.Entrty.SysUser;
import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int updateByPrimaryKeySelective(SysUser record);

    int deleteByPrimaryKey(Integer id);

    SysUser selectByPrimaryKey(Integer id);

    List<SysUser> selectAll(Map<Object, Object> param);

    List<SysUser> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);
}