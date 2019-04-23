package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.authorization.annotation.Decrypt;
import com.zh.program.Common.authorization.annotation.Params;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Banner;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 管理员登录
     */
    @Decrypt
    @ResponseBody
    @PostMapping("/admin")
    public String getAll(@Params Object params, HttpServletRequest request){
        params = request.getAttribute(Constants.PARAM);
        JSONObject json = (JSONObject)params;
        return loginService.check(json);
    }
}
