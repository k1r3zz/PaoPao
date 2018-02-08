package com.user.paopao.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.user.paopao.utils.TUtil;
import com.user.paopao.widget.dialog.LoaddingDialog;

public abstract class BaseFragment<P extends BasePresenter, T extends BaseTask> extends Fragment implements BaseView {

    public static final String KEY_HIDDEN = "isHidden";
    public boolean isFirst = true;
    protected View mView;
    protected Activity mActivity;
    protected P mPresenter;
    protected T mTask;
    protected LoaddingDialog mProgressDialog;
    protected boolean loaddingEnable = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
        mTask = TUtil.getT(this, 1);
        if (mPresenter != null && mTask != null) {

            if (this instanceof BaseView) mPresenter.setVM(this, mTask);

        }
        if (savedInstanceState != null) {
            boolean isHidden = savedInstanceState.getBoolean(KEY_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mView == null) {
            mProgressDialog = new LoaddingDialog();
            mView = setConvertView(inflater, container);
        } else {
            if (mView.getParent() != null) {
                ViewParent parent = mView.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup vp = (ViewGroup) parent;
                    vp.removeView(mView);
                }
            }
        }
        return mView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initDatas();
        initListeners();
    }


    protected void initDatas() {
    }

    /**
     * 加载view
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected void initListeners() {
    }

    protected <T extends View> T getViewById(View view, int id) {
        return ((T) view.findViewById(id));
    }

    /**
     * 初始化view
     *
     * @param inflater
     * @param container
     * @return
     */
    @NonNull
    protected abstract View setConvertView(LayoutInflater inflater, ViewGroup container);


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isFirst) {
            isFirst = false;
            lzyLoadData();
        }
    }

    /**
     * 懒加载数据
     */
    protected void lzyLoadData() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(KEY_HIDDEN, isHidden());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showLoadding() {
        if (loaddingEnable && mProgressDialog != null && getChildFragmentManager().findFragmentByTag(mProgressDialog.getClass().getSimpleName()) == null) {
            mProgressDialog.show(getChildFragmentManager(), mProgressDialog.getClass().getSimpleName());
        }
    }

    @Override
    public void hiddenLoadding() {
        if (loaddingEnable && mProgressDialog != null && getChildFragmentManager().findFragmentByTag(mProgressDialog.getClass().getSimpleName()) != null) {
            mProgressDialog.dismiss();
        }
    }
}
