package com.user.paopao;

public interface Constant {
    boolean LIVE = false;
    //String Base_Url = LIVE ? "http://192.168.3.248:8765/" : "http://192.168.3.248:8765/";
    String Base_Url = LIVE ? "http://zxapi.weyoo-inc.com:8090/" : "http://192.168.1.77:8765/";

    String NETLOG_TAG = "netlog-";

    String KEY_LOGIN_REMEBER = "rememberPassword";
    String KEY_LOGIN_AUTO = "autoLogin";
    String KEY_LOGIN_ENTITY = "login_entity";


    public static final String SDCADE_PATH = "/sdcard/zhixuan/";// SD卡存放目录

}
