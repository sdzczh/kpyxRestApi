package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.authorization.annotation.Decrypt;
import com.zh.program.Common.authorization.annotation.Params;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Banner;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.PrizeService;
import com.zh.program.Service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 中奖名单
 */
@Controller
@RequestMapping("/prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;
    @Autowired
    private SelectionService selectionService;

    /**
     * 查询中奖信息
     * @param id_card 身份证号
     * @param phone 手机号
     * @param invoice_id 彩票编码
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryPrize")
    public String queryPrize(String id_card, String phone, String invoice_id, String invoice_code){
        if(StrUtils.isBlank(id_card) && StrUtils.isBlank(phone) && StrUtils.isBlank(invoice_id) && StrUtils.isBlank(invoice_code)){
            Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        if((!StrUtils.isBlank(invoice_id) && StrUtils.isBlank(invoice_code)) || StrUtils.isBlank(invoice_id) && !StrUtils.isBlank(invoice_code)){
            Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("idCard", id_card);
        map.put("phone", phone);
        map.put("invoiceId", invoice_id);
        map.put("invoiceCode", invoice_code);
        List<Map<String, Object>> list = prizeService.queryByPhoneIdCardInvoiceId(map);
        if(list == null || list.size() == 0){
            return Result.toResult(ResultCode.RESULE_DATA_NONE);
        }else {
            return Result.toResult(ResultCode.SUCCESS, list);
        }
    }

    /**
     * 获取中奖列表
     * number 期数
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public String getAll(Integer number){
        if(number == null){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("number", number);
        List<Map<String, Object>> list = prizeService.selectList(map);
        return Result.toResult(ResultCode.SUCCESS, list);
    }

    /**
     * 获取期数
     * @return
     */
    @ResponseBody
    @RequestMapping("/getNumber")
    public String getNumber(){
        Map<Object, Object> map = new HashMap<>();
        List<Map<String, Object>> list = prizeService.getNumberList(map);
        Integer number;
        if(list.size() != 0){
            number = (Integer) list.get(list.size() - 1).get("number");
        }else{
            number = 1;
        }
        Map<Object, Object> data = new HashMap<>();
        data.put("number", number);
        return Result.toResult(ResultCode.SUCCESS, data);
    }

    /**
     * 自定义抽奖
     * @return
     */
    @Decrypt
    @ResponseBody
    @PostMapping("/draw")
    public String draw(@Params Object params, HttpServletRequest request){
        try {
            params = request.getAttribute(Constants.PARAM);
            JSONObject json = (JSONObject)params;

            Integer amount = json.getInteger("amount");
            Integer type = json.getInteger("type");
            Integer number = json.getInteger("number");
            /*参数校验*/
            if(amount == null || number == null || type == null){
                return Result.toResult(ResultCode.PARAM_IS_BLANK);
            }
            return prizeService.draw(amount, type, number);
        } catch (Exception e) {
            return Result.toResult(ResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
