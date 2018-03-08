package com.user.paopao.main.mine.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;

import java.util.List;

/**
 * author :kira
 * date: 2018/3/8.
 * description:
 */

public class PhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public PhotoAdapter(@Nullable List<String> data) {
        super(R.layout.item_photo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView image = helper.getView(R.id.image);
        ImageView image_delet = helper.getView(R.id.image_delet);
        if (item.equals("")) {
            image.setImageResource(R.drawable.bg_addphoto);
            image_delet.setVisibility(View.GONE);
        } else {
            image.setImageResource(R.drawable.image4);
            image_delet.setVisibility(View.VISIBLE);

        }

    }
}
