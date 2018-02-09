package com.user.paopao.main.find.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.FindEntity;
import com.user.paopao.entity.HomeEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/8.
 * description:
 */

public class FindAdapter extends BaseQuickAdapter<FindEntity, BaseViewHolder> {

    public FindAdapter(@Nullable List<FindEntity> data) {
        super(R.layout.item_find, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindEntity item) {
        helper.setText(R.id.name, item.getName())
                .setText(R.id.meili, item.getMeili())
                .setText(R.id.tuhao, item.getTuhao())
                .setText(R.id.message, item.getMessage())
                .setText(R.id.city, item.getCity());

    }
}
