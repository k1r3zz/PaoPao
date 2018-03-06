package com.user.paopao.main.mine.contactway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.widget.titleview.TitleView;

public class ContactWayActivity extends BaseActivity {
    private TitleView mtitleView;
    private EditText paobiQq;
    private EditText paobiWeixin;
    private EditText paobiShouji;
    private Button queding;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_contact_way);
    }

    @Override
    protected void initViews() {
        mtitleView = (TitleView) findViewById(R.id.mtitleView);
        paobiQq = (EditText) findViewById(R.id.paobi_qq);
        paobiWeixin = (EditText) findViewById(R.id.paobi_weixin);
        paobiShouji = (EditText) findViewById(R.id.paobi_shouji);
        queding = (Button) findViewById(R.id.queding);

        mtitleView.setTitleText(getString(R.string.cont_title));
    }
}
