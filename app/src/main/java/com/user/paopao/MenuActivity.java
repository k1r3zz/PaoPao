package com.user.paopao;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.user.paopao.entity.LoginEntity;
import com.user.paopao.utils.ActivityUtil;

public class MenuActivity extends TabActivity {

    //资源文件
    private Class activitys[] = {LoginEntity.class, LoginEntity.class, LoginEntity.class, LoginEntity.class};//跳转的Activity
    private String title[] = {"拼团", "询价", "客户", "我的"};//设置菜单的标题
    private TabHost tabHost;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityUtil.transplantStatus(MenuActivity.this);
        setContentView(R.layout.activity_main);
        initView();
        initTabView();//初始化tab标签

    }
    private void initView() {
        tabHost = getTabHost();
        radioGroup = (RadioGroup) findViewById(R.id.mGroup);
    }

    private void initTabView() {
        //创建标签
        for (int i = 0; i < activitys.length; i++) {
            //设置跳转activity
            Intent intent = new Intent(this, activitys[i]);

            //载入view对象并设置跳转的activity
            TabHost.TabSpec spec = tabHost.newTabSpec(title[i]).setIndicator(title[i]).setContent(intent);

            //添加到选项卡
            tabHost.addTab(spec);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.mRbGroupbooking:
                        tabHost.setCurrentTabByTag(title[0]);
                        break;
                    case R.id.mRbEnquiry:
                        tabHost.setCurrentTabByTag(title[1]);
                        break;
                    case R.id.mRbCustomer:
                        tabHost.setCurrentTabByTag(title[2]);
                        break;
                    case R.id.mRbMine:
                        tabHost.setCurrentTabByTag(title[3]);
                        break;
                }
            }
        });
    }
}
