package com.user.paopao.main.find;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.main.find.fragment.AllFragment;
import com.user.paopao.main.find.fragment.MingPaoFragment;
import com.user.paopao.main.find.fragment.TongChengFragment;
import com.user.paopao.main.find.fragment.XinRenFragment;
import com.user.paopao.main.find.fragment.YuanFenFragment;
import com.user.paopao.utils.TabLayoutUtils;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_find);

    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titlebar = {"全部", "名泡", "缘分", "新人", "同城"};
    private List<Fragment> fragmentList;
    private FragmentPagerAdapter fragmentadapter;


    @Override
    protected void initViews() {
        tabLayout = (TabLayout) getView(R.id.tabLayout);
        viewPager = (ViewPager) getView(R.id.viewPager);


    }

    @Override
    protected void initDatas() {
        super.initDatas();
        fragmentList = new ArrayList<>();
        AllFragment allFragment = new AllFragment();
        MingPaoFragment mingPaoFragment = new MingPaoFragment();
        YuanFenFragment yuanFenFragment = new YuanFenFragment();
        XinRenFragment xinRenFragment = new XinRenFragment();
        TongChengFragment tongChengFragment = new TongChengFragment();

        fragmentList.add(allFragment);
        fragmentList.add(mingPaoFragment);
        fragmentList.add(yuanFenFragment);
        fragmentList.add(xinRenFragment);
        fragmentList.add(tongChengFragment);

        fragmentadapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList != null ? fragmentList.get(position) : null;
            }

            @Override
            public int getCount() {
                return fragmentList != null ? fragmentList.size() : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titlebar[position];
            }
        };
        viewPager.setAdapter(fragmentadapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < titlebar.length; i++) {
            tabLayout.getTabAt(i).setText(titlebar[i]);
        }
        fragmentList.get(0).onHiddenChanged(false);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentList.get(tab.getPosition()).onHiddenChanged(false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                TabLayoutUtils.setIndicator(tabLayout, 10, 10);
            }
        });

    }

    @Override
    protected void initListeners() {
        super.initListeners();
//        mIvAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.mIvAdd:
//                startActivity(new Intent(EnquiryActivity.this, AddEnquiryActivity.class));
//
//                break;
        }
    }
}
