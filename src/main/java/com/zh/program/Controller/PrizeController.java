package com.zh.program.Controller;

import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Banner;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    /**
     * 查询中奖信息
     * @param id_card 身份证号
     * @param phone 手机号
     * @param invoice_id 彩票编码
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryPrize")
    public String queryPrize(String id_card, String phone, String invoice_id){
        if(StrUtils.isBlank(id_card) && StrUtils.isBlank(phone) && StrUtils.isBlank(invoice_id)){
            Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("idCard", id_card);
        map.put("phone", phone);
        map.put("invoiceId", invoice_id);
        List<Prize> list = prizeService.queryByPhoneIdCardInvoiceId(map);
        if(list == null || list.size() == 0){
            return Result.toResult(ResultCode.RESULE_DATA_NONE);
        }else {
            return Result.toResult(ResultCode.SUCCESS, list);
        }
    }
}
