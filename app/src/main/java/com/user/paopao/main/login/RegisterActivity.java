package com.user.paopao.main.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.MenuActivity;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;
import com.user.paopao.utils.LoginTimeCountUtil;
import com.user.paopao.utils.NetLog;

public class RegisterActivity extends BaseActivity<LoginPresenter, LoginTask> implements LoginContract.View, View.OnClickListener {
    private LinearLayout llContext;
    private EditText etPhone;
    private ImageView deletPhone;
    private EditText etPassword;
    private ImageView deletPassword;
    private Button btLogin;
    private ImageView ivPhone;
    private ImageView ivMail;
    private EditText etMail;
    private TextView deletMail;
    private ImageView ivPassword;
    private ImageView ivYaoqingma;
    private EditText etYaoqingma;
    private ImageView deletYaoqingma;
    private TextView btRegistered;

    private LoginTimeCountUtil timeCountUtil;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_register);
        ActivityUtil.transplantStatus(RegisterActivity.this);
    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.llcontext);
        etPhone = (EditText) findViewById(R.id.et_phone);
        deletPhone = (ImageView) findViewById(R.id.delet_phone);
        etPassword = (EditText) findViewById(R.id.et_password);
        deletPassword = (ImageView) findViewById(R.id.delet_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        ivPhone = (ImageView) findViewById(R.id.iv_phone);
        ivMail = (ImageView) findViewById(R.id.iv_mail);
        etMail = (EditText) findViewById(R.id.et_mail);
        deletMail = (TextView) findViewById(R.id.delet_mail);
        ivPassword = (ImageView) findViewById(R.id.iv_password);
        ivYaoqingma = (ImageView) findViewById(R.id.iv_yaoqingma);
        etYaoqingma = (EditText) findViewById(R.id.et_yaoqingma);
        deletYaoqingma = (ImageView) findViewById(R.id.delet_yaoqingma);
        btRegistered = (TextView) findViewById(R.id.bt_registered);

        timeCountUtil = new LoginTimeCountUtil(this, 10000, 1000, deletMail);


        llContext.setPadding(0, ActivityUtil.getStatusBarHeight(RegisterActivity.this), 0, 0);

    }

    @Override
    protected void initDatas() {
        super.initDatas();

    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btLogin.setOnClickListener(this);
        deletMail.setOnClickListener(this);
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
                startActivity(new Intent(RegisterActivity.this, MenuActivity.class));
                break;
            case R.id.delet_mail:
                timeCountUtil.start();

                break;
        }
    }
}
