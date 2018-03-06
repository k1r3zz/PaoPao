package com.user.paopao.main.message.fans;


import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.FindEntity;
import com.user.paopao.main.find.adapter.FindAdapter;
import com.user.paopao.main.mine.info.PersonalInfoActivity;
import com.user.paopao.widget.titleview.TitleView;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends BaseActivity {


    private RecyclerView mRecycler;
    private TitleView mTitleview;
    private FindAdapter findAdapter;
    private List<FindEntity> list = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_fans);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 7; i++) {
            FindEntity entity = new FindEntity();
            entity.setName("露露");
            entity.setCity("上海");
            entity.setMeili("125K");
            entity.setTuhao("203K");
            entity.setMessage("只有你想不到，没有我做不到");
            list.add(entity);
        }
        findAdapter.setNewData(list);

    }


    @Override
    protected void initListeners() {
        super.initListeners();
        findAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(FansActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initViews() {
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        mTitleview = (TitleView) findViewById(R.id.mTitleview);

        findAdapter = new FindAdapter(null);
        findAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FansActivity.this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(findAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setNestedScrollingEnabled(false);

        Intent intent = getIntent();
        try {
            String title = intent.getStringExtra("title");
            mTitleview.setTitleText(title);
        } catch (Exception e) {

        }
    }

}
