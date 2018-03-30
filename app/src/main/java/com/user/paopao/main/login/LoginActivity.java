package com.user.paopao.main.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.user.paopao.Constant;
import com.user.paopao.MenuActivity;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;
import com.user.paopao.utils.NetLog;
import com.user.paopao.utils.RSAUtil;
import com.user.paopao.utils.ToastUtils;

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
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btLogin.setOnClickListener(this);
        btRegistered.setOnClickListener(this);
    }

    @Override
    public void loginSuccess(LoginEntity entity) {
        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
    }

    @Override
    public void loginfailed() {

    }

    @Override
    public void sendSuccess() {

    }

    @Override
    public void register() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                if (etPhone.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入手机号");
                    return;
                }
                if (etPassword.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入密码");
                    return;
                }
                String publicEncryptedetPhone = RSAUtil.encryptDataByPublicKey(etPhone.getText().toString().getBytes(), Constant.publicKey);
                String publicEncryptedetMail = RSAUtil.encryptDataByPublicKey(etPassword.getText().toString().getBytes(), Constant.publicKey);

                mPresenter.login(publicEncryptedetPhone, publicEncryptedetMail);


                break;
            case R.id.bt_registered:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}
