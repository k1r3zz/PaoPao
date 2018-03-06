package com.user.paopao.main.mine.cash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.widget.titleview.TitleView;

public class CashActivity extends BaseActivity {
    private EditText zhifubaozhanghao;
    private EditText zhifubaoxingming;
    private EditText shoujihao;
    private EditText tixianjine;
    private TextView cash1;
    private TextView cash2;
    private TextView cash3;
    private TextView cash4;
    private TextView paobi;
    private TextView paobibili;
    private TitleView mtitleView;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_cash);

    }

    @Override
    protected void initViews() {
        zhifubaozhanghao = (EditText) findViewById(R.id.zhifubaozhanghao);
        zhifubaoxingming = (EditText) findViewById(R.id.zhifubaoxingming);
        shoujihao = (EditText) findViewById(R.id.shoujihao);
        tixianjine = (EditText) findViewById(R.id.tixianjine);
        cash1 = (TextView) findViewById(R.id.cash1);
        cash2 = (TextView) findViewById(R.id.cash2);
        cash3 = (TextView) findViewById(R.id.cash3);
        cash4 = (TextView) findViewById(R.id.cash4);
        paobi = (TextView) findViewById(R.id.paobi);
        paobibili = (TextView) findViewById(R.id.paobibili);
        mtitleView = (TitleView) findViewById(R.id.mtitleView);

        mtitleView.setTitleText(getString(R.string.cash_title));


    }
}
