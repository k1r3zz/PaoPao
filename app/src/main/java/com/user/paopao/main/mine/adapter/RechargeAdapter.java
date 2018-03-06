package com.user.paopao.main.mine.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.RechargeEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/3/6.
 * description:
 */

public class RechargeAdapter extends BaseQuickAdapter<RechargeEntity, BaseViewHolder> {


    public RechargeAdapter(@Nullable List<RechargeEntity> data) {
        super(R.layout.item_recharge, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RechargeEntity item) {
        helper.setText(R.id.item_rmb, mContext.getString(R.string.rech_yuan, item.getPrice()))
                .setText(R.id.item_paopao, mContext.getString(R.string.rech_paobi, item.getPaopaoprice()));

    }
}
