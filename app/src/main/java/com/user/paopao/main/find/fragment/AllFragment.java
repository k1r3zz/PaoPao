package com.user.paopao.main.find.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.user.paopao.R;
import com.user.paopao.base.BaseFragment;
import com.user.paopao.entity.FindEntity;
import com.user.paopao.main.find.adapter.FindAdapter;
import com.user.paopao.main.home.adapter.HomeAdapter;
import com.user.paopao.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class AllFragment extends BaseFragment {

    private RecyclerView mRecycler;
    private FindAdapter findAdapter;
    private List<FindEntity> list = new ArrayList<>();

    @NonNull
    @Override
    protected View setConvertView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.fragment_all, null);
        return mView;
    }

    @Override
    protected void initViews() {
        mRecycler = (RecyclerView) mView.findViewById(R.id.mRecycler);

        findAdapter = new FindAdapter(null);
        findAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(findAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setNestedScrollingEnabled(false);

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
}
