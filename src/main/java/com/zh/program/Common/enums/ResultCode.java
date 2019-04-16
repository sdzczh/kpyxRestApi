package com.zh.program.Common.enums;


public enum ResultCode {
	/* 成功状态码 */
    SUCCESS(10000, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_PHONE_ERROR(10004, "手机号格式错误"),
    PARAM_IDCARD_ERROR(10005, "身份证号格式错误"),
    PARAM_IMG_BLANK(10006, "请上传图片"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被冻结"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_ACCOUNT_LOGOFF(20006, "账号已被注销"),
    USER_NOT_REALNAME(20007, "用户未实名"),

    /* 业务错误：30001-39999 */
    SMS_INTERFACE_ERROR(30001, "短信接口异常"),
    SMS_FREQUENT_SEND(30002, "手机号频繁限制"),
    SMS_CHECK_ERROR(30003, "验证码错误"),
    SMS_TIME_LIMIT_ERROR(30004, "验证码已过期"),
    SMS_COUNTS_LIMIT_ERROR(30005, "验证码使用超出次数限制"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统异常"),
    SYSTEM_PARAM_ERROR(40002, "系统参数未配置"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_ALREADY_EXISTED(50002, "数据已存在"),
    UPDATE_DATA_NOT_EXIST(50003, "数据无更新"),

    /* 接口错误：60001-69999 */
    INTERFACE_SIGN_ERROR(60001,"接口签名认证错误"),
    INTERFACE_DECRYPT_ERROR(60002,"接口解密失败"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),
    OKCOIN_INTERFACE_ERROR(61001, "OKCoin接口返回出错"),
    RONGCLOUD_INTERFACE_ERROR(62001, "融云接口返回出错"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "功能已关闭"),
    PERMISSION_REGISTER_NO_ACCESS(70002, "注册功能已关闭"),
    PERMISSION_NO_OPEN(70003, "功能暂未开放"),
    VCODE_FALSE(70004, "注册验证码错误");


    private Integer code;

    private String msg;
    
    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.msg;
    }
    
    public void setMessage(String msg){
    	this.msg = msg;
    }
    
    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.msg;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }
    


}
