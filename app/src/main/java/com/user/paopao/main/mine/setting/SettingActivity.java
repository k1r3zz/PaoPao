package com.user.paopao.main.mine.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.widget.titleview.TitleView;

public class SettingActivity extends BaseActivity {
    private TitleView mtitleView;
    private RelativeLayout xiaoxituisong;
    private RelativeLayout yijianfankui;
    private RelativeLayout yonghubidu;
    private RelativeLayout zaixiankefu;
    private RelativeLayout qingchuhuancun;
    private RelativeLayout guanyupaopao;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_setting);

    }

    @Override
    protected void initViews() {
        mtitleView = (TitleView) findViewById(R.id.mtitleView);
        xiaoxituisong = (RelativeLayout) findViewById(R.id.xiaoxituisong);
        yijianfankui = (RelativeLayout) findViewById(R.id.yijianfankui);
        yonghubidu = (RelativeLayout) findViewById(R.id.yonghubidu);
        zaixiankefu = (RelativeLayout) findViewById(R.id.zaixiankefu);
        qingchuhuancun = (RelativeLayout) findViewById(R.id.qingchuhuancun);
        guanyupaopao = (RelativeLayout) findViewById(R.id.guanyupaopao);

        mtitleView.setTitleText(getString(R.string.setting_setting));
    }
}
