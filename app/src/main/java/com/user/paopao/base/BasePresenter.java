package com.user.paopao.base;

import android.content.Context;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @param <T> Task的泛型
 * @param <V> View的泛型
 * @author kira
 */
public abstract class BasePresenter<V,T> {
    public Context context;
    private Reference<V> mViewRef;
   // public  M            mModel;
    public  V         mView;
    public T mTask;

    /**
     * 绑定view和model
     *
     * @param v
     * @param t
     */
    public void setVM(V v,T t) {
        mViewRef = new WeakReference<>(v);
        this.mView = mViewRef.get();
        this.mTask = t;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
