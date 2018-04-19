package com.user.paopao.main.home;

import android.util.Log;

import com.user.paopao.Constant;
import com.user.paopao.entity.BaseBean;
import com.user.paopao.entity.HomeEntity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.main.login.LoginContract;
import com.user.paopao.net.StringObserver;
import com.user.paopao.utils.JsonUtil;
import com.user.paopao.utils.NetLog;
import com.user.paopao.utils.RSAUtil;
import com.user.paopao.utils.SharePrefrencesUtil;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/7.
 * description:
 */

public class HomePresenter extends HomeContract.Presenter {

    @Override
    void getData(String page, String column_num, String people_num, String order, String gender) {
        mView.showLoadding();
        mTask.getData(page, column_num, people_num, order, gender, new StringObserver() {
            @Override
            protected void onSuccess(String json) throws Exception {
                BaseBean<List<HomeEntity>> baseBean = JsonUtil.fromJsonArray(json, HomeEntity.class);

                mView.getData(baseBean.getData());
            }

            @Override
            protected void onFaild(String message) {

            }

            @Override
            public void onComplete() {
                mView.hiddenLoadding();
            }
        });
    }
}
