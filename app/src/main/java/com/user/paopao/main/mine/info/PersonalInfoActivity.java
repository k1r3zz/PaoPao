package com.user.paopao.main.mine.info;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.main.home.adapter.HomeAdapter;
import com.user.paopao.widget.circleImageView.CircleImageView;

public class PersonalInfoActivity extends BaseActivity {
    private ImageView finsh;
    private TextView jubao;
    private CircleImageView head;
    private LinearLayout llRideo;
    private TextView name;
    private TextView meili;
    private TextView tuhao;
    private TextView fensi;
    private TextView guanzhu;
    private TextView dianzan;
    private TextView meilizhi;
    private TextView gerenziliao;
    private TextView zhucedizhi;
    private TextView dizhi;
    private TextView nianling;
    private TextView shengao;
    private TextView paopao;
    private TextView qqhao;
    private TextView shoujihao;
    private TextView weixinhao;
    private ImageView siliaoButton;
    private ImageView liwuButtom;
    private ImageView guanzhuButton;
    private ImageView dianzanButton;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_personal_info);

    }

    @Override
    protected void initViews() {
        finsh = (ImageView) findViewById(R.id.finsh);
        jubao = (TextView) findViewById(R.id.jubao);
        head = (CircleImageView) findViewById(R.id.head);
        llRideo = (LinearLayout) findViewById(R.id.ll_rideo);
        name = (TextView) findViewById(R.id.name);
        meili = (TextView) findViewById(R.id.meili);
        tuhao = (TextView) findViewById(R.id.tuhao);
        fensi = (TextView) findViewById(R.id.fensi);
        guanzhu = (TextView) findViewById(R.id.guanzhu);
        dianzan = (TextView) findViewById(R.id.dianzan);
        meilizhi = (TextView) findViewById(R.id.meilizhi);
        gerenziliao = (TextView) findViewById(R.id.gerenziliao);
        zhucedizhi = (TextView) findViewById(R.id.zhucedizhi);
        dizhi = (TextView) findViewById(R.id.dizhi);
        nianling = (TextView) findViewById(R.id.nianling);
        shengao = (TextView) findViewById(R.id.shengao);
        paopao = (TextView) findViewById(R.id.paopao);
        qqhao = (TextView) findViewById(R.id.qqhao);
        shoujihao = (TextView) findViewById(R.id.shoujihao);
        weixinhao = (TextView) findViewById(R.id.weixinhao);
        siliaoButton = (ImageView) findViewById(R.id.siliao_button);
        liwuButtom = (ImageView) findViewById(R.id.liwu_buttom);
        guanzhuButton = (ImageView) findViewById(R.id.guanzhu_button);
        dianzanButton = (ImageView) findViewById(R.id.dianzan_button);


    }
}
