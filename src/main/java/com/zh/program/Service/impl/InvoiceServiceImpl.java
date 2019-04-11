package com.zh.program.Service.impl;

import com.zh.program.Dao.InvoiceMapper;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Service.InvoiceService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:41:37
 **/ 
@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Override
    public int insert(Invoice record) {
        return this.invoiceMapper.insert(record);
    }

    @Override
    public int insertSelective(Invoice record) {
        return this.invoiceMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Invoice record) {
        return this.invoiceMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Invoice record) {
        return this.invoiceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.invoiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Invoice selectByPrimaryKey(Integer id) {
        return this.invoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Invoice> selectAll(Map<Object, Object> param) {
        return this.invoiceMapper.selectAll(param);
    }

    @Override
    public List<Invoice> selectPaging(Map<Object, Object> param) {
        return this.invoiceMapper.selectPaging(param);
    }

    @Override
    public int selectCount(Map<Object, Object> param) {
        return this.invoiceMapper.selectCount(param);
    }
}