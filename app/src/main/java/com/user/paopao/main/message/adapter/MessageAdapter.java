package com.user.paopao.main.message.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.MessageEntity;
import com.user.paopao.main.message.MessageActivity;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/9.
 * description:
 */

public class MessageAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {

    public MessageAdapter(@Nullable List<MessageEntity> data) {
        super(R.layout.item_message, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, MessageEntity item) {
        try {
            int num = Integer.parseInt(item.getNum());
            if (num > 99) {
                helper.setText(R.id.num, "99+");
            } else {
                helper.setText(R.id.num, item.getNum());

            }

        } catch (Exception e) {

        }
        helper.setText(R.id.name, item.getName())
                .setText(R.id.message, item.getMessage());
    }
}
