package com.zh.program.Service.impl;

import com.zh.program.Dao.PrizeMapper;
import com.zh.program.Entrty.Prize;
import com.zh.program.Service.PrizeService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:42:24
 **/ 
@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {
    @Resource
    private PrizeMapper prizeMapper;

    private static final Logger logger = LoggerFactory.getLogger(PrizeServiceImpl.class);

    @Override
    public int insert(Prize record) {
        return this.prizeMapper.insert(record);
    }

    @Override
    public int insertSelective(Prize record) {
        return this.prizeMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Prize record) {
        return this.prizeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Prize record) {
        return this.prizeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.prizeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Prize selectByPrimaryKey(Integer id) {
        return this.prizeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Prize> selectAll(Map<Object, Object> param) {
        return this.prizeMapper.selectAll(param);
    }

    @Override
    public List<Prize> selectPaging(Map<Object, Object> param) {
        return this.prizeMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.prizeMapper.selectCount(param);
    }

    @Override
    public List<Map<String, Object>> queryByPhoneIdCardInvoiceId(Map<Object, Object> map) {
        return this.prizeMapper.queryByPhoneIdCardInvoiceId(map);
    }

    @Override
    public List<Map<String, Object>> selectList(Map<Object, Object> map) {
        return this.prizeMapper.selectList(map);
    }
}