package com.user.paopao.main.mine.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;

import java.util.List;

/**
 * author :kira
 * date: 2018/3/8.
 * description:
 */

public class MyInComehaoyouAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public MyInComehaoyouAdapter(@Nullable List<String> data) {
        super(R.layout.item_myincomehaoyou, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }
}
