package com.user.paopao.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author：lily
 * date：2017/12/29 10:30
 * description:
 */

public class VerificationUtils {
    /**
     * 验证手机号
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str){
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    //    /**
//     * 验证手机号
//     *
//     * @param str
//     * @return
//     */
//    public static boolean isPhoneNumber(String str) {
//        Pattern pattern = Pattern.compile("^((12[0-9])|(13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(16[0-9])|(19[0-9]))\\d{8}$");
//        Matcher matcher = pattern.matcher(str);
//        return matcher.matches();
//    }
}
