package com.zh.program.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.encrypt.BASE64;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.RedisUtil;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Common.utils.ValidateUtils;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Service.ArticleService;
import com.zh.program.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 发票管理
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private static final String VALIDATE_CODE = "validateCode";

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private RedisTemplate<String, String> redis;

    /**
     * 发票录入
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String insert(String data, HttpServletRequest request, String code, String time){
//        String validateCode = String.valueOf(request.getSession().getAttribute(VALIDATE_CODE));
        String validateCode = RedisUtil.searchString(redis, "kpyx:" + Constants.VALIDATE_CODE + time);
        if(!validateCode.equalsIgnoreCase(code)){
            return Result.toResult(ResultCode.SMS_CHECK_ERROR);
        }
        if(StrUtils.isBlank(data)){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = JSONArray.parseArray(BASE64.decoder(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String idCardNum = jsonObject.getString("id_card_num");
            String phone = jsonObject.getString("phone");
            //验证手机号
            if(!ValidateUtils.isPhone(phone)){
                return Result.toResult(ResultCode.PARAM_PHONE_ERROR);
            }
            //验证身份证号
            if(!ValidateUtils.isIdCard(idCardNum)){
                return Result.toResult(ResultCode.PARAM_IDCARD_ERROR);
            }
            //todo：验证发票编码
            Invoice invoice = new Invoice();
            invoice.setIdCardNum(idCardNum);
            invoice.setAmount(new BigDecimal(jsonObject.getString("amount")));
            invoice.setInvoiceCode(jsonObject.getString("invoice_code"));
            invoice.setInvoiceId(jsonObject.getString("invoice_id"));
            invoice.setPhone(phone);
            invoice.setState(Constants.STATE_ON);
            invoice.setCreateDate(DateUtils.getCurrentDateStr());
            invoiceService.insertSelective(invoice);
        }
        return Result.toResult(ResultCode.SUCCESS);
    }


}
