package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.encrypt.BASE64;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.RedisUtil;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Common.utils.ValidateUtils;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Report;
import com.zh.program.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 举报
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private RedisTemplate<String, String> redis;

    /**
     * 发票录入
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String insert(String data, String code, String time){
        String key = "kpyx:" + Constants.VALIDATE_CODE + time;
        String validateCode = RedisUtil.searchString(redis, key);
        //验证码错误
        if(StrUtils.isBlank(validateCode) || !validateCode.equalsIgnoreCase(code)){
            return Result.toResult(ResultCode.SMS_CHECK_ERROR);
        }
        RedisUtil.deleteString(redis, key);
        //数据为空
        if(StrUtils.isBlank(data)){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(BASE64.decoder(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(jsonObject == null){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        String be_reported_company_name = jsonObject.getString("be_reported_company_name");
        String be_reported_name = jsonObject.getString("be_reported_name");
        String be_reported_address = jsonObject.getString("be_reported_address");
        String economic_nature = jsonObject.getString("economic_nature");
        String prove_information = jsonObject.getString("prove_information");
        String content = jsonObject.getString("content");
        String imgUrl = jsonObject.getString("img_url");
        //验证手机号
        if(!ValidateUtils.isPhone(phone)){
            return Result.toResult(ResultCode.PARAM_PHONE_ERROR);
        }
        Report report = new Report();
        report.setBeReportedAddress(be_reported_address);
        report.setBeReportedCompanyName(be_reported_company_name);
        report.setBeReportedName(be_reported_name);
        report.setContent(content);
        report.setEconomicNature(economic_nature);
        report.setImgUrl(imgUrl);
        report.setName(name);
        report.setPhone(phone);
        report.setProveInformation(prove_information);
        reportService.insertSelective(report);
        return Result.toResult(ResultCode.SUCCESS);
    }


}
