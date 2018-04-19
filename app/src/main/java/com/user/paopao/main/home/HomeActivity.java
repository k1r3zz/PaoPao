package com.user.paopao.main.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.HomeEntity;
import com.user.paopao.main.home.adapter.HomeAdapter;
import com.user.paopao.main.home.toplist.TopListActivity;
import com.user.paopao.main.mine.info.PersonalInfoActivity;
import com.user.paopao.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BaseActivity<HomePresenter, HomeTask> implements HomeContract.View, View.OnClickListener {
    private LinearLayout llContext;
    private TextView btGirl;
    private TextView btBoy;
    private RecyclerView mRecycler;
    private RelativeLayout rl_meili;
    private RelativeLayout rl_fuhao;

    private HomeAdapter homeAdapter;
    private List<HomeEntity> list = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_home);

    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.ll_context);
        btGirl = (TextView) findViewById(R.id.bt_girl);
        btBoy = (TextView) findViewById(R.id.bt_boy);
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        rl_meili = (RelativeLayout) findViewById(R.id.rl_meili);
        rl_fuhao = (RelativeLayout) findViewById(R.id.rl_fuhao);

        btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
        btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));

        homeAdapter = new HomeAdapter(null);
        homeAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(homeAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
//        mRecycler.addItemDecoration(new SpacesItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        mRecycler.setNestedScrollingEnabled(false);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        mPresenter.getData("1", "4", "3", "f", "1");

//        list.clear();
//        for (int i = 0; i < 5; i++) {
//            HomeEntity entity = new HomeEntity();
//            switch (i) {
//                case 0:
//                    entity.setTitle("颜值女神");
//                    break;
//                case 1:
//                    entity.setTitle("特邀");
//                    break;
//                case 2:
//                    entity.setTitle("御姐");
//                    break;
//                case 3:
//                    entity.setTitle("萝莉");
//                    break;
//            }
//            list.add(entity);
//        }
//        homeAdapter.setNewData(list);

    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btGirl.setOnClickListener(this);
        btBoy.setOnClickListener(this);
        rl_meili.setOnClickListener(this);
        rl_fuhao.setOnClickListener(this);
        homeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                switch (view.getId()) {
                    case R.id.rl1:
                        intent.setClass(HomeActivity.this, PersonalInfoActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rl2:
                        intent.setClass(HomeActivity.this, PersonalInfoActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rl3:
                        intent.setClass(HomeActivity.this, PersonalInfoActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.bt_girl:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_normal);
                btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));
                btBoy.setTextColor(getResources().getColor(R.color.c_000000));
                mPresenter.getData("1", "4", "3", "f", "1");


                break;
            case R.id.bt_boy:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_normal);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_selected);
                btGirl.setTextColor(getResources().getColor(R.color.c_000000));
                btBoy.setTextColor(getResources().getColor(R.color.c_ffffff));
                mPresenter.getData("1", "4", "3", "f", "0");


                break;
            case R.id.rl_meili:
                intent.setClass(HomeActivity.this, TopListActivity.class);
                intent.putExtra("title", getString(R.string.ho_meilizhi));
                startActivity(intent);

                break;
            case R.id.rl_fuhao:
                intent.setClass(HomeActivity.this, TopListActivity.class);
                intent.putExtra("title", getString(R.string.ho_fuhao));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void getData(List<HomeEntity> mlist) {
        list.clear();
        list.addAll(mlist);
        homeAdapter.setNewData(list);
    }
}
