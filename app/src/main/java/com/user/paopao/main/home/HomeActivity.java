package com.user.paopao.main.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.main.login.LoginActivity;
import com.user.paopao.utils.ActivityUtil;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout llContext;
    private TextView btGirl;
    private TextView btBoy;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_home);

    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.ll_context);
        btGirl = (TextView) findViewById(R.id.bt_girl);
        btBoy = (TextView) findViewById(R.id.bt_boy);

        btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
        btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btGirl.setOnClickListener(this);
        btBoy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_girl:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_normal);
                btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));
                btBoy.setTextColor(getResources().getColor(R.color.c_000000));


                break;
            case R.id.bt_boy:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_normal);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_selected);
                btGirl.setTextColor(getResources().getColor(R.color.c_000000));
                btBoy.setTextColor(getResources().getColor(R.color.c_ffffff));

                break;
        }
    }
}
