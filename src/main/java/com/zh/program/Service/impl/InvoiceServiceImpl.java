package com.zh.program.Service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.encrypt.BASE64;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.RedisUtil;
import com.zh.program.Common.utils.ValidateUtils;
import com.zh.program.Dao.InvoiceMapper;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Service.InvoiceService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:41:37
 **/
@Transactional
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

    @Override
    public String insertData(String data) {
        JSONArray jsonArray = null;
        try {
            jsonArray = JSONArray.parseArray(BASE64.decoder(data));
        } catch (Exception e) {
            e.printStackTrace();
            Result.toResult(ResultCode.INTERFACE_DECRYPT_ERROR);
        }
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String idCardNum = jsonObject.getString("id_card_num");
            String phone = jsonObject.getString("phone");
            String invoiceCode = jsonObject.getString("invoice_code");
            String invoiceId = jsonObject.getString("invoice_id");
            //验证手机号
            if(!ValidateUtils.isPhone(phone)){
                return Result.toResult(ResultCode.PARAM_PHONE_ERROR);
            }
            //验证身份证号
            if(!ValidateUtils.isIdCard(idCardNum)){
                return Result.toResult(ResultCode.PARAM_IDCARD_ERROR);
            }
            //验证发票是否已存在
            Map<Object, Object> map = new HashMap<>();
            map.put("invoiceId", invoiceId);
            List<Invoice> list = invoiceMapper.selectAll(map);
            if(list.size() != 0){
                return Result.toResult(ResultCode.INVOICE_LIVE);
            }
            //保存
            Invoice invoice = new Invoice();
            invoice.setIdCardNum(idCardNum);
            invoice.setAmount(new BigDecimal(jsonObject.getString("amount")));
            invoice.setInvoiceCode(invoiceCode);
            invoice.setInvoiceId(invoiceId);
            invoice.setPhone(phone);
            invoice.setState(Constants.STATE_ON);
            invoice.setCreateDate(DateUtils.getCurrentDateStr());
            this.invoiceMapper.insertSelective(invoice);
        }
        return Result.toResult(ResultCode.SUCCESS, data);
    }
}