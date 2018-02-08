package com.user.paopao.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.user.paopao.utils.NetLog;
import com.user.paopao.utils.TUtil;
import com.user.paopao.widget.dialog.LoaddingDialog;


public abstract class BaseActivity<P extends BasePresenter, T extends BaseTask> extends AppCompatActivity implements BaseView {

    protected LoaddingDialog mProgressDialog;
    protected P mPresenter;
    protected Context mContext;
    protected T mTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
        mTask = TUtil.getT(this, 1);
        if (mPresenter != null && mTask != null) {

            if (this instanceof BaseView) mPresenter.setVM(this, mTask);

        }

        NetLog.d("", this.getClass().getSimpleName());
        mContext = this;
        mProgressDialog = new LoaddingDialog();
        setContentView();
        initViews();
        initDatas();
        initListeners();
    }


    @SuppressLint("InlinedApi")
    public void transplantStatus() {
        // 透明状态栏
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else  // 5.0以上系统状态栏透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
    }

    /**
     * 设置布局文件
     */
    protected abstract void setContentView();

//    /**
//     * 初始化数据
//     */
//    protected abstract void initDatas();

    /**
     * 加载view
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected void initDatas() {
    }

    /**
     * 绑定监听
     */
    protected void initListeners() {
    }

    protected <T extends View> T getView(int id) {
        return ((T) findViewById(id));
    }

    @Override
    public void showLoadding() {
        if (mProgressDialog != null && getSupportFragmentManager().findFragmentByTag(mProgressDialog.getClass().getSimpleName()) == null) {
            mProgressDialog.show(getSupportFragmentManager(), mProgressDialog.getClass().getSimpleName());
        }
    }

    @Override
    public void hiddenLoadding() {
        if (mProgressDialog != null && getSupportFragmentManager().findFragmentByTag(mProgressDialog.getClass().getSimpleName()) != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
    }
}
