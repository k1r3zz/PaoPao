package com.user.paopao.main.mine.invite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;

public class InviteActivity extends BaseActivity {
    private TextView titleviewTitle;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_invite);
        
    }

    @Override
    protected void initViews() {
        titleviewTitle = (TextView) findViewById(R.id.titleview_title);

        titleviewTitle.setText(getString(R.string.min_yaoqingzhuanqian));

    }
}
