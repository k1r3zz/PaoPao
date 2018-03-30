package com.user.paopao.main.login;

import com.user.paopao.main.login.LoginContract;
import com.user.paopao.net.RetrofitManager;
import com.user.paopao.net.Url;

import java.util.HashMap;

import io.reactivex.Observer;

/**
 * author :kira
 * date: 2018/2/7.
 * description:
 */

public class LoginTask implements LoginContract.Task {
    @Override
    public void login(String username, String passwod, Observer observer) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", username);
        params.put("pwd", passwod);
        RetrofitManager.getInstance().post(Url.LOGIN_URL, Url.login, params, observer);
    }

    @Override
    public void sendCode(String mobile, Observer observer) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", mobile);
        RetrofitManager.getInstance().post(Url.LOGIN_URL, Url.LoginUrl, params, observer);
    }

    @Override
    public void register(String mobile, String code, String pwd, String ppaoid, Observer observer) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("code", code);
        params.put("pwd", pwd);
        params.put("ppaoid", ppaoid);

        RetrofitManager.getInstance().post(Url.LOGIN_URL, Url.RegisterUrl, params, observer);
    }
}
