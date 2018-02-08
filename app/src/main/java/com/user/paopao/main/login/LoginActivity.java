package com.user.paopao.main.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.user.paopao.MenuActivity;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;
import com.user.paopao.utils.NetLog;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginTask> implements LoginContract.View, View.OnClickListener {
    private LinearLayout llContext;
    private EditText etPhone;
    private ImageView deletPhone;
    private EditText etPassword;
    private ImageView deletPassword;
    private Button btLogin;
    private Button btRegistered;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_login);
        ActivityUtil.transplantStatus(LoginActivity.this);
    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.llcontext);
        etPhone = (EditText) findViewById(R.id.et_phone);
        deletPhone = (ImageView) findViewById(R.id.delet_phone);
        etPassword = (EditText) findViewById(R.id.et_password);
        deletPassword = (ImageView) findViewById(R.id.delet_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btRegistered = (Button) findViewById(R.id.bt_registered);

        llContext.setPadding(0, ActivityUtil.getStatusBarHeight(LoginActivity.this), 0, 0);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
       // mPresenter.login("15821086864", "123456");
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btLogin.setOnClickListener(this);
    }

    @Override
    public void loginSuccess(LoginEntity entity) {
        NetLog.d("opp", entity.getName());
    }

    @Override
    public void loginLogin() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                break;
        }
    }
}
