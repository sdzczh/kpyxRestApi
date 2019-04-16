package com.zh.program.Common;

/**
 * Created by Administrator on 2018/7/16 0016.
 */
public class Constants {
    /**
     * 随机数
     */
    public static final String[] ROUND_NUM = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static final String TOKEN = "token";
    public static final String PARAM = "params";
    public static final String SIGN = "sign";
    public static final String SECRETKEY = "secret_key";
    public static final String CURRENT_USER = "user";

    //RSA密钥
    public static final String RSA_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKvGZp9DDKCO/9fwG0qYB0xCLROXk2RSIXX5uc7GfIfo9qjNbU9UwA0Zk0aQP176Dny5wcQlIbowdQHCGWCkeOxRrX66htT/NBCSZjQL6sQLSzEr7c5QX6FtrCgolfPGVZI7o/dPF273y3ebK4v0QSDyUikiGTcv52b3gz38IwKTAgMBAAECgYBYRiIQsDU6AaLKxrJPuCbv8oYVrmxpPqfBZ+8rqubuNTMk9kS5YvU7BiygM5rNZTWytQc1lFtrwmEu4R+HgZ4+A+vKUL+Dpw0BGypgkOjDByaOlWlVBpJu8RR+hE4mdV6MDEz2oqrdRobTwM4jvIuNpzCCHULekTytkrl0oYqdKQJBANh0lNonz/gOve/xjG0ESycaSpDz9XEiCAsWrT0gxfNQgIW9juvxu7ZYAvN+AgINH+1W1VhzWBMjg1cI9zOb9ncCQQDLKCimhRk2W/tNqyJqX6iDbmOEB1X+51Ra25ix8TGosFXwmpQ0CfqqbhhAEx3pucKnXUvqJKFKi5LQ0ianNa/FAkEApHgo5n6bymtBLUGHpwo9JHAYun10QMtP+0T2y1zMrG29ymFXaLZcIFhNncBgPDjGyqtRHo0+HgS89nQMiX13TwJARJTuBCjydfNfRrz7BUX9sUDWv39qfH7Db1iql4eA6B1/JZZJabfksxwve5H4iyp2l+Fa+1QaTvwHOA95lQD+sQJBAKrexoS2kePfP0F1bLSgTNcV8eZO+mDxWVxFwl9HeMvm3ybj9dlytO7X2rri1IoVeSOCOu2dnuFKiHSWUCodteo=";
    public static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrxmafQwygjv/X8BtKmAdMQi0Tl5NkUiF1+bnOxnyH6PaozW1PVMANGZNGkD9e+g58ucHEJSG6MHUBwhlgpHjsUa1+uobU/zQQkmY0C+rEC0sxK+3OUF+hbawoKJXzxlWSO6P3Txdu98t3myuL9EEg8lIpIhk3L+dm94M9/CMCkwIDAQAB";
    public static final int TIMEOUTINTERVAL = 10000000;

    //状态 有效
    public static final int STATE_ON = 1;
    //状态 无效
    public static final int STATE_OFF = 0;

    //Banner 顶部位置
    public static final int BANNER_TYPE_TOP = 0;
    public static final int BANNER_TYPE_MID = 1;

    //文章类型
    public static final int ARTICLE_KJGG = 0;
    public static final int ARTICLE_ZCFG = 1;
    public static final int ARTICLE_XWZX = 2;
    public static final int ARTICLE_CJWT = 3;
    public static final int ARTICLE_TZGG = 4;

    //中奖人数
    public static final int DRAW_PERSON_NUMBER = 200;

    public static final int DRAW_SELECTION = 0;

    public static final String VALIDATE_CODE = "validateCode:";


}