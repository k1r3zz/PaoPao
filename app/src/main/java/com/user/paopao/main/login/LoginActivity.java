package com.user.paopao.main.login;

import android.widget.LinearLayout;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;
import com.user.paopao.utils.NetLog;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginTask> implements LoginContract.View {
    private LinearLayout llContext;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_login);
        ActivityUtil.transplantStatus(LoginActivity.this);
    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.llcontext);


        llContext.setPadding(0, ActivityUtil.getStatusBarHeight(LoginActivity.this), 0, 0);

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
