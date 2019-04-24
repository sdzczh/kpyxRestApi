package com.zh.program.Common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
	/**验证是否为手机号*/
    public static boolean isPhone(String userPhone){
    	if(StrUtils.isBlank(userPhone)) return true;
        String regexPhone = "^1\\d{10}$";
        Pattern p = Pattern.compile(regexPhone);
        Matcher m = p.matcher(userPhone);
        return m.matches();
    }

    /**验证是否为6-18位数字和字母的组合*/
    public static boolean isDigitalAndWord(String userInput){
        if (StrUtils.isBlank(userInput)){
            return false;
        }
        //用户代码必须为数字或字母，只能为6~18位
        String regexLoginPwd = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}$";
        return userInput.matches(regexLoginPwd);
    }

    /**验证是否为6位数字的交易密码*/
    public static boolean isTradePwd(String userPwd){
        if (StrUtils.isBlank(userPwd)){
            return false;
        }
        String regexTradePwd = "^\\d{6}$";
        return userPwd.matches(regexTradePwd);
    }
    /**验证是否为身份证号*/
    public static boolean isIdCard(String idCard){
        if (StrUtils.isBlank(idCard)){
            return false;
        }
        String regexTradePwd = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";
        return idCard.matches(regexTradePwd);
    }

    /**验证是否为6位数字的验证码*/
    public static boolean isVerificationCode(String verificationCode){
        if (StrUtils.isBlank(verificationCode)){
            return false;
        }
        String regexTradePwd = "^\\d{6}$";
        return verificationCode.matches(regexTradePwd);
    }
    /**验证是否为8位数字*/
    public static boolean is8Num(String verificationCode){
        if (StrUtils.isBlank(verificationCode)){
            return false;
        }
        String regexTradePwd = "^\\d{8}$";
        return verificationCode.matches(regexTradePwd);
    }

    /**验证是否为12位数字*/
    public static boolean is12Num(String verificationCode){
        if (StrUtils.isBlank(verificationCode)){
            return false;
        }
        String regexTradePwd = "^\\d{12}$";
        return verificationCode.matches(regexTradePwd);
    }

    
    public static String replacePwdOfLog(String str){
    	String pwdStr = replaceAll(str, "\"password\":\".+?\"", "\"password\":\"***\"");
    	return replaceAll(pwdStr, "\"oldPassword\":\".+?\"", "\"oldPassword\":\"***\"");
    }


    /**
     * 替换匹配到的字符串为目标字符串
     * @param str
     * @param pattern 正则表达式
     * @param replace 目标字符串
     * @return String
     * @date 2018-2-2
     * @author lina
     */
    public static String replaceAll(String str,String pattern,String replace){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        String dest = m.replaceAll(replace);
        return dest;
    }
}
