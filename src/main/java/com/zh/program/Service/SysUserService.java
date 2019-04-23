package com.zh.program.Service;

import com.zh.program.Entrty.SysUser;
import java.util.List;
import java.util.Map;

/**
 * 业务逻辑接口:管理员表 sys_user
 * 
 * @author: autogeneration
 * @date: 2019-04-23 10:33:13
 **/ 
public interface SysUserService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int insert(SysUser record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int insertSelective(SysUser record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int updateByPrimaryKey(SysUser record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    List<SysUser> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    List<SysUser> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-23 10:33:13
     **/ 
    int selectCount(Map<Object, Object> param);
}