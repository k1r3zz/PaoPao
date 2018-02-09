package com.user.paopao.main.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.MessageEntity;
import com.user.paopao.main.home.adapter.HomeAdapter;
import com.user.paopao.main.message.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements View.OnClickListener {
    private TextView btMessage;
    private TextView btFriend;
    private LinearLayout paoyou;
    private RecyclerView mRecycler;

    private MessageAdapter messageAdapter;
    private List<MessageEntity> list = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_message);
    }

    @Override
    protected void initViews() {
        btMessage = (TextView) findViewById(R.id.bt_message);
        btFriend = (TextView) findViewById(R.id.bt_friend);
        paoyou = (LinearLayout) findViewById(R.id.paoyou);
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);

        btMessage.setBackgroundResource(R.drawable.bt_home_top_selected);
        btMessage.setTextColor(getResources().getColor(R.color.c_ffffff));
        paoyou.setVisibility(View.GONE);

        messageAdapter = new MessageAdapter(null);
        messageAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(messageAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setNestedScrollingEnabled(false);
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btFriend.setOnClickListener(this);
        btMessage.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 10; i++) {
            MessageEntity entity = new MessageEntity();
            entity.setName("露露");
            entity.setMessage("在么，方便加下微信么？");
            if (i % 2 == 0) {
                entity.setNum("16");
            } else {
                entity.setNum("122");

            }
            list.add(entity);
        }
        messageAdapter.setNewData(list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_message:
                btMessage.setBackgroundResource(R.drawable.bt_home_top_selected);
                btFriend.setBackgroundResource(R.drawable.bt_home_top_normal);
                btMessage.setTextColor(getResources().getColor(R.color.c_ffffff));
                btFriend.setTextColor(getResources().getColor(R.color.c_000000));
                paoyou.setVisibility(View.GONE);
                mRecycler.setVisibility(View.VISIBLE);


                break;
            case R.id.bt_friend:
                btMessage.setBackgroundResource(R.drawable.bt_home_top_normal);
                btFriend.setBackgroundResource(R.drawable.bt_home_top_selected);
                btMessage.setTextColor(getResources().getColor(R.color.c_000000));
                btFriend.setTextColor(getResources().getColor(R.color.c_ffffff));
                paoyou.setVisibility(View.VISIBLE);
                mRecycler.setVisibility(View.GONE);

                break;
        }
    }
}
