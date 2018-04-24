package com.user.paopao.main.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.HomeEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/8.
 * description:
 */

public class HomeAdapter extends BaseQuickAdapter<HomeEntity, BaseViewHolder> {

    public HomeAdapter(@Nullable List<HomeEntity> data) {
        super(R.layout.item_home, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeEntity item) {
        RelativeLayout rl1 = helper.getView(R.id.rl1);
        RelativeLayout rl2 = helper.getView(R.id.rl2);
        RelativeLayout rl3 = helper.getView(R.id.rl3);
        LinearLayout ll_l1 = helper.getView(R.id.ll_l1);

        helper.setText(R.id.text, item.getTitle());
//        if (item.getUsers().size() == 0) {
//            rl1.setVisibility(View.INVISIBLE);
//            rl2.setVisibility(View.INVISIBLE);
//            rl3.setVisibility(View.INVISIBLE);
//            ll_l1.setVisibility(View.GONE);
//        }
//        if (item.getUsers().size() == 1) {
//            rl1.setVisibility(View.VISIBLE);
//            rl2.setVisibility(View.INVISIBLE);
//            rl3.setVisibility(View.INVISIBLE);
//            HomeEntity.UsersBean bean1 = item.getUsers().get(0);
//            helper.setText(R.id.text1, bean1.getInfo().getNickname());
//            ll_l1.setVisibility(View.VISIBLE);
//
//        }
//        if (item.getUsers().size() == 2) {
//            rl1.setVisibility(View.VISIBLE);
//            rl2.setVisibility(View.VISIBLE);
//            rl3.setVisibility(View.INVISIBLE);
//            HomeEntity.UsersBean bean1 = item.getUsers().get(0);
//            helper.setText(R.id.text1, bean1.getInfo().getNickname());
//            HomeEntity.UsersBean bean2 = item.getUsers().get(1);
//            helper.setText(R.id.text2, bean2.getInfo().getNickname());
//            ll_l1.setVisibility(View.VISIBLE);
//        }
//        if (item.getUsers().size() == 3) {
//            rl1.setVisibility(View.VISIBLE);
//            rl2.setVisibility(View.VISIBLE);
//            rl3.setVisibility(View.VISIBLE);
//            HomeEntity.UsersBean bean1 = item.getUsers().get(0);
//            helper.setText(R.id.text1, bean1.getInfo().getNickname());
//            HomeEntity.UsersBean bean2 = item.getUsers().get(1);
//            helper.setText(R.id.text2, bean2.getInfo().getNickname());
//            HomeEntity.UsersBean bean3 = item.getUsers().get(2);
//            helper.setText(R.id.text3, bean3.getInfo().getNickname());
//            ll_l1.setVisibility(View.VISIBLE);
//
//        }


        helper.addOnClickListener(R.id.rl1).addOnClickListener(R.id.rl2).addOnClickListener(R.id.rl3);

    }
}
