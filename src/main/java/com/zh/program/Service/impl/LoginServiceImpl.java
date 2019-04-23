package com.zh.program.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.ShiroKit;
import com.zh.program.Dao.BannerMapper;
import com.zh.program.Dao.SysUserMapper;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Banner;
import com.zh.program.Entrty.SysUser;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:37:14
 **/ 
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserMapper sysUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


    @Override
    public String check(JSONObject json) {
        String account = json.getString("account");
        String password = json.getString("password");
        Map<Object, Object> map = new HashMap<>();
        map.put("account", account);
        List<SysUser> list = sysUserMapper.selectAll(map);
        if(list.size() == 0){
            return Result.toResult(ResultCode.USER_NOT_EXIST);
        }
        SysUser sysUser = list.get(0);
        password = ShiroKit.md5(password, sysUser.getSalt());
        if(password.equals(sysUser.getPassword())){
            if(!Constants.ADMIN_ROLE.equals(sysUser.getRoleid())){
                return Result.toResult(ResultCode.USER_NOT_ROLE);
            }
            return Result.toResult(ResultCode.SUCCESS);
        }else
            return Result.toResult(ResultCode.USER_LOGIN_ERROR);
    }
}