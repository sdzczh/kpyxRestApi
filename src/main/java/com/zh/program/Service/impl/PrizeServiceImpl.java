package com.zh.program.Service.impl;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Dao.InvoiceMapper;
import com.zh.program.Dao.PrizeMapper;
import com.zh.program.Dao.SelectionMapper;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.InvoiceService;
import com.zh.program.Service.PrizeService;

import java.util.*;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:42:24
 **/ 
@Service("prizeService")
@Transactional
public class PrizeServiceImpl implements PrizeService {
    @Resource
    private PrizeMapper prizeMapper;
    @Resource
    private SelectionMapper selectionMapper;
    @Resource
    private InvoiceMapper invoiceMapper;

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

    @Override
    public String draw(Integer amount, Integer type, Integer number) {
        Map<Object, Object> map = new HashMap<>();
        map.put("state", Constants.STATE_ON);
        map.put("number", number);
        List<Selection> list = selectionMapper.selectAll(map);
        if(list.size() == 0){
            return Result.toResult(ResultCode.RESULE_DATA_NONE);
        }
        Integer start = list.get(list.size() - 1).getId();
        //中奖名单id
        Set<Integer> set = DrawUtils.draw(amount, list.size(), start);
        List<Map<String, Object>> data = new ArrayList<>();
        for(Integer index : set){
            Map<String, Object> result = new HashMap<>();
            Selection selection = selectionMapper.selectByPrimaryKey(index);
            Integer invoiceId = selection.getInvoiceId();
            //插入中奖信息
            Invoice invoice = invoiceMapper.selectByPrimaryKey(invoiceId);
            Prize prize = new Prize();
            prize.setType(type);
            prize.setInvoiceId(invoiceId);
            prize.setNumber(number);
            this.prizeMapper.insertSelective(prize);
            //修改Selection数据
            selection.setState(Constants.STATE_OFF);
            selectionMapper.updateByPrimaryKeySelective(selection);
            //返回中奖数据
            result.put("type", type);
            result.put("number", number);
            result.put("invoiceCode", invoice.getInvoiceCode());
            result.put("invoiceId", invoice.getInvoiceId());
            data.add(result);
        }
        return Result.toResult(ResultCode.SUCCESS, data);
    }
}