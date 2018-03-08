package com.user.paopao.main.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.main.mine.cash.CashActivity;
import com.user.paopao.main.mine.contactway.ContactWayActivity;
import com.user.paopao.main.mine.photo.MyPhotoActivity;
import com.user.paopao.main.mine.recharge.RechargeActivity;
import com.user.paopao.main.mine.setting.SettingActivity;
import com.user.paopao.widget.circleImageView.CircleImageView;

public class MineActivity extends BaseActivity implements View.OnClickListener {
    private ImageView setting;
    private CircleImageView head;
    private TextView name;
    private TextView ID;
    private TextView message;
    private TextView fensi;
    private TextView guanzhu;
    private TextView dianzan;
    private TextView paobi;
    private TextView meilizhi;
    private RelativeLayout chongzhipaobi;
    private ImageView llImg1;
    private RelativeLayout woyaotixian;
    private ImageView llImg2;
    private RelativeLayout wodexiangce;
    private ImageView llImg3;
    private RelativeLayout wodeshouru;
    private ImageView llImg4;
    private RelativeLayout lianxifangshi;
    private ImageView llImg6;
    private RelativeLayout yaoqingzhuanqian;
    private ImageView llImg5;
    private RelativeLayout pinlunzhuanqian;
    private ImageView llImg7;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_mine);

    }

    @Override
    protected void initViews() {
        setting = (ImageView) findViewById(R.id.setting);
        head = (CircleImageView) findViewById(R.id.head);
        name = (TextView) findViewById(R.id.name);
        ID = (TextView) findViewById(R.id.ID);
        message = (TextView) findViewById(R.id.message);
        fensi = (TextView) findViewById(R.id.fensi);
        guanzhu = (TextView) findViewById(R.id.guanzhu);
        dianzan = (TextView) findViewById(R.id.dianzan);
        paobi = (TextView) findViewById(R.id.paobi);
        meilizhi = (TextView) findViewById(R.id.meilizhi);
        chongzhipaobi = (RelativeLayout) findViewById(R.id.chongzhipaobi);
        llImg1 = (ImageView) findViewById(R.id.ll_img1);
        woyaotixian = (RelativeLayout) findViewById(R.id.woyaotixian);
        llImg2 = (ImageView) findViewById(R.id.ll_img2);
        wodexiangce = (RelativeLayout) findViewById(R.id.wodexiangce);
        llImg3 = (ImageView) findViewById(R.id.ll_img3);
        wodeshouru = (RelativeLayout) findViewById(R.id.wodeshouru);
        llImg4 = (ImageView) findViewById(R.id.ll_img4);
        lianxifangshi = (RelativeLayout) findViewById(R.id.lianxifangshi);
        llImg6 = (ImageView) findViewById(R.id.ll_img6);
        yaoqingzhuanqian = (RelativeLayout) findViewById(R.id.yaoqingzhuanqian);
        llImg5 = (ImageView) findViewById(R.id.ll_img5);
        pinlunzhuanqian = (RelativeLayout) findViewById(R.id.pinlunzhuanqian);
        llImg7 = (ImageView) findViewById(R.id.ll_img7);
    }


    @Override
    protected void initListeners() {
        super.initListeners();
        setting.setOnClickListener(this);
        chongzhipaobi.setOnClickListener(this);
        woyaotixian.setOnClickListener(this);
        lianxifangshi.setOnClickListener(this);
        wodexiangce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.setting:
                intent.setClass(MineActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.chongzhipaobi:
                intent.setClass(MineActivity.this, RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.woyaotixian:
                intent.setClass(MineActivity.this, CashActivity.class);
                startActivity(intent);
                break;
            case R.id.lianxifangshi:
                intent.setClass(MineActivity.this, ContactWayActivity.class);
                startActivity(intent);
                break;
            case R.id.wodexiangce:
                intent.setClass(MineActivity.this, MyPhotoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
