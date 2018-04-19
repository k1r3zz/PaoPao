package com.user.paopao.main.home;

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

public class HomeTask implements HomeContract.Task {

    @Override
    public void getData(String page, String column_num, String people_num, String order, String gender, Observer observer) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page", page);
        params.put("column_num", column_num);
        params.put("people_num", people_num);
        params.put("order", order);
        params.put("gender", gender);
        RetrofitManager.getInstance().get(Url.getIndex, params, observer);
    }
}
