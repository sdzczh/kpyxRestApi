package com.zh.program.Dao;

import com.zh.program.Entrty.Report;
import java.util.List;
import java.util.Map;

public interface ReportMapper {
    int insert(Report record);

    int insertSelective(Report record);

    int updateByPrimaryKey(Report record);

    int updateByPrimaryKeySelective(Report record);

    int deleteByPrimaryKey(Integer id);

    Report selectByPrimaryKey(Integer id);

    List<Report> selectAll(Map<Object, Object> param);

    List<Report> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);
}