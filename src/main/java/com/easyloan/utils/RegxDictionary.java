package com.easyloan.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDictionary {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证中文
     */
    public static final String REGEX_CHINESE = "^[\\u4e00-\\u9fa5]*$";
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    public static boolean validateRegx(String regx,String filed) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(filed);
        if(matcher.matches()) {
            return true;
        }
        return false;
    }


}
