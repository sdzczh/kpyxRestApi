package com.zh.program.Service;

import com.zh.program.Entrty.Report;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:43:10
 **/ 
public interface ReportService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int insert(Report record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int insertSelective(Report record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int updateByPrimaryKey(Report record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int updateByPrimaryKeySelective(Report record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    Report selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    List<Report> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    List<Report> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:43:10
     **/ 
    int selectCount(Map<Object, Object> param);
}