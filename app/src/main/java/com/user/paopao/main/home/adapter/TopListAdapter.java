package com.user.paopao.main.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.FindEntity;
import com.user.paopao.entity.MessageEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/9.
 * description:
 */

public class TopListAdapter extends BaseQuickAdapter<FindEntity, BaseViewHolder> {

    public TopListAdapter(@Nullable List<FindEntity> data) {
        super(R.layout.item_toplist, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, FindEntity item) {
        TextView item_no = helper.getView(R.id.item_no);
        ImageView item_im = helper.getView(R.id.item_im);
        if (helper.getPosition() == 0) {
            item_no.setVisibility(View.GONE);
            item_im.setVisibility(View.VISIBLE);
            item_im.setImageResource(R.drawable.bg_jinpai);
        } else if (helper.getPosition() == 1) {
            item_no.setVisibility(View.GONE);
            item_im.setVisibility(View.VISIBLE);
            item_im.setImageResource(R.drawable.bg_yingpai);
        } else if (helper.getPosition() == 2) {
            item_no.setVisibility(View.GONE);
            item_im.setVisibility(View.VISIBLE);
            item_im.setImageResource(R.drawable.bg_tongpai);
        } else {
            item_no.setVisibility(View.VISIBLE);
            item_im.setVisibility(View.GONE);
            item_no.setText(helper.getPosition() + "");
        }

        helper.setText(R.id.name, item.getName())
                .setText(R.id.meili, item.getMeili())
                .setText(R.id.tuhao, item.getTuhao())
                .setText(R.id.message, item.getMessage())
                .setText(R.id.city, item.getCity());

    }
}
