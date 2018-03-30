package com.user.paopao.main.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.Constant;
import com.user.paopao.MenuActivity;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;
import com.user.paopao.utils.LoginTimeCountUtil;
import com.user.paopao.utils.NetLog;
import com.user.paopao.utils.RSAUtil;
import com.user.paopao.utils.ToastUtils;

import java.security.PublicKey;

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
    public void loginfailed() {

    }

    @Override
    public void sendSuccess() {
        ToastUtils.showMsg("发送验证码成功");

    }

    @Override
    public void register() {
        ToastUtils.showMsg("注册成功");
        finish();
    }

    @Override
    public void onClick(View v) {
        //获取公钥
        switch (v.getId()) {
            case R.id.bt_login:
                if (etPhone.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入手机号");
                    return;
                }
                if (etMail.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入验证码");
                    return;
                }
                if (etPassword.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入密码");
                    return;
                }


                String phone = etPhone.getText().toString();
                String Mail = etMail.getText().toString();
                String Password = etPassword.getText().toString();
                String EtYaoqingma = etYaoqingma.getText().toString();


                String publicEncryptedetPhone = RSAUtil.encryptDataByPublicKey(phone.getBytes(), Constant.publicKey);
                String publicEncryptedetMail = RSAUtil.encryptDataByPublicKey(Mail.getBytes(), Constant.publicKey);
                String publicEncryptedetPassword = RSAUtil.encryptDataByPublicKey(Password.getBytes(), Constant.publicKey);
                String publicEncryptedetetYaoqingma;
                if (!"".equals(EtYaoqingma)) {
                    publicEncryptedetetYaoqingma = RSAUtil.encryptDataByPublicKey(etYaoqingma.getText().toString().getBytes(), Constant.publicKey);
                } else {
                    publicEncryptedetetYaoqingma = "";

                }

                Log.d("opp", "----------" + phone + "、" + Mail + "、" + EtYaoqingma + "=" + Password);

                mPresenter.register(publicEncryptedetPhone, publicEncryptedetMail, publicEncryptedetPassword, publicEncryptedetetYaoqingma);
                break;
            case R.id.delet_mail:
                if (etPhone.getText().toString().equals("")) {
                    ToastUtils.showMsg("请输入手机号");
                    return;
                }
                String phone2 = etPhone.getText().toString();
                Log.d("opp", "----------" + phone2);
                String publicEncryptedResult = RSAUtil.encryptDataByPublicKey(phone2.getBytes(), Constant.publicKey);
                mPresenter.sendCode(publicEncryptedResult);
                timeCountUtil.start();

                break;
        }
    }
}
