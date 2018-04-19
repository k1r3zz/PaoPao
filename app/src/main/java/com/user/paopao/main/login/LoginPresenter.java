package com.user.paopao.main.login;

import android.util.Log;

import com.user.paopao.Constant;
import com.user.paopao.entity.BaseBean;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.main.login.LoginContract;
import com.user.paopao.net.BaseObserver;
import com.user.paopao.net.StringObserver;
import com.user.paopao.utils.JsonUtil;
import com.user.paopao.utils.NetLog;
import com.user.paopao.utils.RSAUtil;
import com.user.paopao.utils.SharePrefrencesUtil;

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
                BaseBean<LoginEntity> baseBean = JsonUtil.fromJsonObject(json, LoginEntity.class);

                SharePrefrencesUtil.getInstance().saveObject(Constant.KEY_LOGIN_ENTITY, baseBean.getData());
                LoginEntity loginEntity=baseBean.getData();
                Log.d("opp", "====:"+RSAUtil.decryptedToStrByPrivate(loginEntity.getUser(),Constant.priviteKey));
                Log.d("opp", "====:"+RSAUtil.decryptedToStrByPrivate(loginEntity.getToken(),Constant.priviteKey));

                mView.loginSuccess(baseBean.getData());
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

    @Override
    void sendCode(String mobile) {
        mView.showLoadding();
        mTask.sendCode(mobile, new StringObserver() {
            @Override
            protected void onSuccess(String json) throws Exception {


                NetLog.d("opp", json);
                mView.sendSuccess();
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

    @Override
    void register(String mobile, String code, String pwd, String ppaoid) {
        mView.showLoadding();
        mTask.register(mobile, code, pwd, ppaoid, new StringObserver() {
            @Override
            protected void onSuccess(String json) throws Exception {
                mView.register();
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
