package com.user.paopao.main.mine.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.PhotoNumEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/3/8.
 * description:
 */

public class PhotoNumAdapter extends BaseQuickAdapter<PhotoNumEntity, BaseViewHolder> {


    public PhotoNumAdapter(@Nullable List<PhotoNumEntity> data) {
        super(R.layout.item_photo_num, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final PhotoNumEntity item) {
        final TextView tv = helper.getView(R.id.tv);
        RelativeLayout ll_rl = helper.getView(R.id.ll_rl);
        if (item.getIsSelect() == 0) {
            tv.setBackgroundResource(R.drawable.bt_photo_normal);
            tv.setTextColor(mContext.getResources().getColor(R.color.c_333333));
        } else {
            tv.setBackgroundResource(R.drawable.bt_photo_select);
            tv.setTextColor(mContext.getResources().getColor(R.color.c_fc508e));
        }

        ll_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getIsSelect() == 0) {
                    item.setIsSelect(1);
                    tv.setBackgroundResource(R.drawable.bt_photo_select);
                    tv.setTextColor(mContext.getResources().getColor(R.color.c_fc508e));
                    for (PhotoNumEntity entity : mData) {
                        if (!entity.getName().equals(item.getName())) {
                            entity.setIsSelect(0);
                        }
                    }
                    notifyDataSetChanged();
                } else {
                    item.setIsSelect(0);
                    tv.setBackgroundResource(R.drawable.bt_photo_normal);
                    tv.setTextColor(mContext.getResources().getColor(R.color.c_333333));
                }
            }
        });
    }
}
