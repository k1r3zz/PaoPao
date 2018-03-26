package com.user.paopao.main.mine.myincome;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.main.mine.adapter.MyInComeLiwuAdapter;
import com.user.paopao.main.mine.adapter.MyInComehaoyouAdapter;
import com.user.paopao.main.mine.adapter.PhotoAdapter;
import com.user.paopao.main.mine.adapter.PhotoNumAdapter;
import com.user.paopao.main.mine.photo.MyPhotoActivity;
import com.user.paopao.widget.NoSrollerRecycler;
import com.user.paopao.widget.titleview.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MyInComeActivity extends BaseActivity {

    private TitleView mtitleView;
    private RelativeLayout mrl;
    private TextView tvButtom0;
    private TextView tvButtom;
    private Button butTixian;
    private TextView tvLiwupaobi;
    private NoSrollerRecycler mRecycler1;
    private TextView tvXiangcepaobi;
    private TextView tvLianxifangshipaobi;
    private TextView tvWeixin;
    private TextView tvShouji;
    private TextView tvQq;
    private TextView tvYaoqinghaoyoupaobi;
    private TextView tvYaoqingshouru;
    private TextView tvYaoqingticheng;
    private NoSrollerRecycler mRecycler2;

    private MyInComeLiwuAdapter myInComeLiwuAdapter;
    private MyInComehaoyouAdapter myInComehaoyouAdapter;

    private List<String> list = new ArrayList<>();


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_my_in_come);

    }

    @Override
    protected void initViews() {
        mtitleView = (TitleView) findViewById(R.id.mtitleView);
        mrl = (RelativeLayout) findViewById(R.id.mrl);
        tvButtom0 = (TextView) findViewById(R.id.tv_buttom0);
        tvButtom = (TextView) findViewById(R.id.tv_buttom);
        butTixian = (Button) findViewById(R.id.but_tixian);
        tvLiwupaobi = (TextView) findViewById(R.id.tv_liwupaobi);
        mRecycler1 = (NoSrollerRecycler) findViewById(R.id.mRecycler1);
        tvXiangcepaobi = (TextView) findViewById(R.id.tv_xiangcepaobi);
        tvLianxifangshipaobi = (TextView) findViewById(R.id.tv_lianxifangshipaobi);
        tvWeixin = (TextView) findViewById(R.id.tv_weixin);
        tvShouji = (TextView) findViewById(R.id.tv_shouji);
        tvQq = (TextView) findViewById(R.id.tv_qq);
        tvYaoqinghaoyoupaobi = (TextView) findViewById(R.id.tv_yaoqinghaoyoupaobi);
        tvYaoqingshouru = (TextView) findViewById(R.id.tv_yaoqingshouru);
        tvYaoqingticheng = (TextView) findViewById(R.id.tv_yaoqingticheng);
        mRecycler2 = (NoSrollerRecycler) findViewById(R.id.mRecycler2);

        mtitleView.setTitleText(getString(R.string.min_wodeshouru));

        myInComeLiwuAdapter = new MyInComeLiwuAdapter(null);
        myInComeLiwuAdapter.openLoadAnimation();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MyInComeActivity.this, 4);
        mRecycler1.setLayoutManager(gridLayoutManager);
        mRecycler1.setAdapter(myInComeLiwuAdapter);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler1.setItemAnimator(new DefaultItemAnimator());
        mRecycler1.setNestedScrollingEnabled(false);


        myInComehaoyouAdapter = new MyInComehaoyouAdapter(null);
        myInComehaoyouAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyInComeActivity.this);
        mRecycler2.setLayoutManager(linearLayoutManager);
        mRecycler2.setAdapter(myInComehaoyouAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler2.setItemAnimator(new DefaultItemAnimator());
        mRecycler2.setNestedScrollingEnabled(false);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 8; i++) {
            list.add("" + i);

        }
        myInComeLiwuAdapter.setNewData(list);
        myInComehaoyouAdapter.setNewData(list);

    }
}
