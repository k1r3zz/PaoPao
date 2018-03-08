package com.user.paopao.main.mine.photo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.PhotoNumEntity;
import com.user.paopao.main.mine.adapter.PhotoAdapter;
import com.user.paopao.main.mine.adapter.PhotoNumAdapter;
import com.user.paopao.main.mine.adapter.RechargeAdapter;
import com.user.paopao.main.mine.recharge.RechargeActivity;
import com.user.paopao.widget.NoSrollerRecycler;
import com.user.paopao.widget.titleview.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MyPhotoActivity extends BaseActivity {
    private TitleView mtitleView;
    private NoSrollerRecycler mRecyclerPhoto;
    private NoSrollerRecycler mRecyclerNum;

    private PhotoAdapter photoAdapter;
    private PhotoNumAdapter photoNumAdapter;

    private List<String> list = new ArrayList<>();
    private List<PhotoNumEntity> listnum = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_my_photo);

    }

    @Override
    protected void initViews() {
        mtitleView = (TitleView) findViewById(R.id.mtitleView);
        mRecyclerPhoto = (NoSrollerRecycler) findViewById(R.id.mRecycler_photo);
        mRecyclerNum = (NoSrollerRecycler) findViewById(R.id.mRecycler_num);

        mtitleView.setTitleText(getString(R.string.photo_title));

        photoAdapter = new PhotoAdapter(null);
        photoAdapter.openLoadAnimation();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MyPhotoActivity.this, 3);
        mRecyclerPhoto.setLayoutManager(gridLayoutManager);
        mRecyclerPhoto.setAdapter(photoAdapter);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerPhoto.setItemAnimator(new DefaultItemAnimator());
        mRecyclerPhoto.setNestedScrollingEnabled(false);


        photoNumAdapter = new PhotoNumAdapter(null);
        photoNumAdapter.openLoadAnimation();
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(MyPhotoActivity.this, 7);
        mRecyclerNum.setLayoutManager(gridLayoutManager2);
        mRecyclerNum.setAdapter(photoNumAdapter);
        gridLayoutManager2.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerNum.setItemAnimator(new DefaultItemAnimator());
        mRecyclerNum.setNestedScrollingEnabled(false);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                list.add(i + "");
            } else {
                list.add("");

            }
        }
        photoAdapter.setNewData(list);

        listnum.clear();
        for (int i = 0; i < 17; i++) {
            PhotoNumEntity entity = new PhotoNumEntity();
            entity.setName(i + "");
            entity.setIsSelect(0);
            listnum.add(entity);

        }
        photoNumAdapter.setNewData(listnum);


    }
}
