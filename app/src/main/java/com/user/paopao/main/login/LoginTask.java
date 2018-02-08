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
        params.put("loginName", username);
        params.put("password", passwod);
        RetrofitManager.getInstance().post(Url.LOGIN_URL, Url.LoginUrl, params, observer);
    }
}
