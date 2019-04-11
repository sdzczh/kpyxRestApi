package com.zh.program.Service.impl;

import com.zh.program.Dao.ReportMapper;
import com.zh.program.Entrty.Report;
import com.zh.program.Service.ReportService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:43:10
 **/ 
@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;

    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Override
    public int insert(Report record) {
        return this.reportMapper.insert(record);
    }

    @Override
    public int insertSelective(Report record) {
        return this.reportMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Report record) {
        return this.reportMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Report record) {
        return this.reportMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.reportMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Report selectByPrimaryKey(Integer id) {
        return this.reportMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Report> selectAll(Map<Object, Object> param) {
        return this.reportMapper.selectAll(param);
    }

    @Override
    public List<Report> selectPaging(Map<Object, Object> param) {
        return this.reportMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.reportMapper.selectCount(param);
    }
}