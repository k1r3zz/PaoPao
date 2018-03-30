package com.user.paopao;

import com.user.paopao.utils.RSAUtil;

import java.security.PublicKey;

public interface Constant {
    boolean LIVE = false;
    //String Base_Url = LIVE ? "http://192.168.3.248:8765/" : "http://192.168.3.248:8765/";
    String Base_Url = LIVE ? "http://47.94.81.138/api/v1/" : "http://47.94.81.138/api/v1/";

    String NETLOG_TAG = "netlog-";

    String KEY_LOGIN_REMEBER = "rememberPassword";
    String KEY_LOGIN_AUTO = "autoLogin";
    String KEY_LOGIN_ENTITY = "login_entity";

    public static String PUBLIC_KEY_STR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPT3P08yXz3YsXutCp1Woa0DIC0UJ5QS3WlqlqZrCMzv1GU9WLHNI32/XwgcMIEMvRHOPz1wq5iHMYQU/YT1trh4+jYBYCyYf/rz8Zs/onEmQFZzG48wsQSh4qy5q9ZAEfju2nX9JJeXs0X7JWMcd6qRJYi0juA9iZp59jt6IOywIDAQAB";
    public static PublicKey publicKey = RSAUtil.keyStrToPublicKey(Constant.PUBLIC_KEY_STR);


    public static final String SDCADE_PATH = "/sdcard/zhixuan/";// SD卡存放目录

}
