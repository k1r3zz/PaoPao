package com.user.paopao.main.mine.recharge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.widget.Button;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.RechargeEntity;
import com.user.paopao.main.find.adapter.FindAdapter;
import com.user.paopao.main.message.fans.FansActivity;
import com.user.paopao.main.mine.adapter.RechargeAdapter;
import com.user.paopao.widget.NoSrollerRecycler;
import com.user.paopao.widget.titleview.TitleView;

import java.util.ArrayList;
import java.util.List;

public class RechargeActivity extends BaseActivity {
    private TitleView mtitleView;
    private NoSrollerRecycler mRecycler;
    private Button lianxikefu;

    private RechargeAdapter rechargeAdapter;
    private List<RechargeEntity> list = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_recharge);
    }

    @Override
    protected void initViews() {
        mtitleView = (TitleView) findViewById(R.id.mtitleView);
        mRecycler = (NoSrollerRecycler) findViewById(R.id.mRecycler);
        lianxikefu = (Button) findViewById(R.id.lianxikefu);

        rechargeAdapter = new RechargeAdapter(null);
        rechargeAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RechargeActivity.this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(rechargeAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setNestedScrollingEnabled(false);

        mtitleView.setTitleText(getString(R.string.rech_title));
    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 5; i++) {
            RechargeEntity entity = new RechargeEntity();
            entity.setPrice("30");
            entity.setPaopaoprice("100");
            list.add(entity);
        }

        rechargeAdapter.setNewData(list);
    }
}
