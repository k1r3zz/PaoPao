package com.user.paopao.utils;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.user.paopao.R;

/**
 * Created by Administrator on 2016/7/13.
 */
public class LoginTimeCountUtil extends CountDownTimer {

    private AppCompatActivity appCompatActivity;
    private TextView btn;

    // 在这个构造方法里需要传入三个参数，一个是Activity，一个是总的时间millisInFuture，一个是countDownInterval，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了
    public LoginTimeCountUtil(AppCompatActivity appCompatActivity, long millisInFuture, long countDownInterval, TextView btn) {
        super(millisInFuture, countDownInterval);
        this.appCompatActivity = appCompatActivity;
        this.btn = btn;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (! appCompatActivity.isFinishing()) {

            btn.setClickable(false);//设置不能点击
//            btn.setTextColor(appCompatActivity.getResources().getColor(R.color.white));
            btn.setBackgroundColor(appCompatActivity.getResources().getColor(R.color.c_00000000));
            btn.setText(+ millisUntilFinished / 1000 + "s");//设置倒计时时间

        }
    }

    @Override
    public void onFinish() {
        if (! appCompatActivity.isFinishing()) {
            btn.setText("获取验证码");
//            btn.setTextColor(appCompatActivity.getResources().getColor((R.color.c_FF1F34)));
            btn.setBackgroundColor(appCompatActivity.getResources().getColor(R.color.c_00000000));
            btn.setClickable(true);
        }
    }

}


