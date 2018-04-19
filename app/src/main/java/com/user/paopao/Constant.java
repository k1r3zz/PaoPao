package com.user.paopao;

import com.user.paopao.utils.RSAUtil;

import java.security.PrivateKey;
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

    public static String PRIVITE_KEY_STR = "MIICXQIBAAKBgQDPT3P08yXz3YsXutCp1Woa0DIC0UJ5QS3WlqlqZrCMzv1GU9WLHNI32/XwgcMIEMvRHOPz1wq5iHMYQU/YT1trh4+jYBYCyYf/rz8Zs/onEmQFZzG48wsQSh4qy5q9ZAEfju2nX9JJeXs0X7JWMcd6qRJYi0juA9iZp59jt6IOywIDAQABAoGAPY6WG/HnHxZ1qsIqG4PnUbboYrXIS0DzX3i1LYb4fZco1a0nB3uzYCrMSHH/e3GhU6KEfW8pHBZMNrOOBejqd+Z6JO8+PyAfkJXqfOmdDUGshNV42N7yoPKEdpxiZWt9TnfMH78InuB4QsBc04pwJ7yoXOrBjummbEFYobLpZKECQQDyD8aRFQZVv+NgSFT/AV7G2KM0AKkHnbK4g0XLU4N2ZL1lJ/EfO1E+7z+AK8iglBsMuv2iBCLFKZNP81riqzdHAkEA2z9o62CRIJsBWN5rnl8lB5Z0HhGQbBdv6xgrcvptyZUYlbdMwj4Ra3FXNpDeMR6BzbK8lkDTTmZUl7Mmnwo2XQJBAOKKnyTzD127W7qll16dUq043OzzXT5yeWwz92MGgveP6q08R28aXbxPvxdeYsLeOb6dVniF9GCfu23M7JdM9EsCQQCUuEuMNkHbcymTxbQMho+QuQ7lApcLq05Ak3GNma/1KEy36dGIhR+92PEG03fUq9Py2wYviaOML7+780sEYKIFAkAGSkbNNrDEjwdfIi/5jRE3qJTxrQUVbLHqXGrbh7oRWCQciS9uBqHZVLwluKuuS76862ANGBmxUcWAuKrRXxg3";
    public static PrivateKey priviteKey = RSAUtil.keyStrToPrivate(Constant.PRIVITE_KEY_STR);


    public static final String SDCADE_PATH = "/sdcard/zhixuan/";// SD卡存放目录

}
