package com.user.paopao.main.login;

import com.user.paopao.entity.BaseBean;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.main.login.LoginContract;
import com.user.paopao.net.BaseObserver;
import com.user.paopao.net.StringObserver;
import com.user.paopao.utils.JsonUtil;
import com.user.paopao.utils.NetLog;

/**
 * author :kira
 * date: 2018/2/7.
 * description:
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    void login(String username, String passwod) {
        mView.showLoadding();
        mTask.login(username, passwod, new StringObserver() {
            @Override
            protected void onSuccess(String json) throws Exception {
                BaseBean<LoginEntity> bean = JsonUtil.fromJsonObject(json, LoginEntity.class);

                NetLog.d("opp", json);
                mView.loginSuccess(bean.getData());
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
