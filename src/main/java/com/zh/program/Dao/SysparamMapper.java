package com.zh.program.Dao;

import com.zh.program.Entrty.Sysparam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysparamMapper {
    int insert(Sysparam record);

    int insertSelective(Sysparam record);

    int updateByPrimaryKey(Sysparam record);

    int updateByPrimaryKeySelective(Sysparam record);

    int deleteByPrimaryKey(Integer id);

    Sysparam selectByPrimaryKey(Integer id);

    List<Sysparam> selectAll(Map<Object, Object> param);

    List<Sysparam> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    void updateByKey(@Param("keyName") String keyName, @Param("keyValue") String keyValue);
}