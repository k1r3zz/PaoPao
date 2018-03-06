package com.user.paopao.main.home.toplist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.FindEntity;
import com.user.paopao.main.home.adapter.TopListAdapter;
import com.user.paopao.main.message.fans.FansActivity;
import com.user.paopao.main.mine.info.PersonalInfoActivity;
import com.user.paopao.widget.titleview.TitleView;

import java.util.ArrayList;
import java.util.List;

public class TopListActivity extends BaseActivity {
    private RecyclerView mRecycler;
    private TitleView mTitleview;
    private TopListAdapter topListAdapter;
    private List<FindEntity> list = new ArrayList<>();


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_top_list);

    }

    @Override
    protected void initViews() {
        mTitleview = (TitleView) findViewById(R.id.mTitleview);
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);

        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        mTitleview = (TitleView) findViewById(R.id.mTitleview);

        topListAdapter = new TopListAdapter(null);
        topListAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TopListActivity.this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(topListAdapter);
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

    @Override
    protected void initListeners() {
        super.initListeners();
        topListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(TopListActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
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
        topListAdapter.setNewData(list);
    }
}
