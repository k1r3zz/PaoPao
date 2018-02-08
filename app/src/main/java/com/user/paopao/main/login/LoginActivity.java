package com.user.paopao.main.login;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.NetLog;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginTask> implements LoginContract.View {

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        mPresenter.login("15821086864", "123456");
    }

    @Override
    public void loginSuccess(LoginEntity entity) {
        NetLog.d("opp", entity.getName());
    }

    @Override
    public void loginLogin() {

    }
}
