package com.user.paopao.net;

import com.user.paopao.MyApplication;
import com.user.paopao.entity.BaseBean;
import com.user.paopao.utils.NetworkUtil;
import com.user.paopao.utils.ToastUtils;


import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 请求结果处理类
 */
public abstract class BaseObserver implements Observer<BaseBean> {

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(BaseBean baseBean) {
//        Log.i("ly","onNext");
        try {
            if (baseBean != null && baseBean.getData() != null) {
                onSuccess(baseBean);
            } else {
                onFail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showMsg("发生错误，请重试!");
        }
    }

    @Override
    public void onError(Throwable e) {
//        Log.i("ly","onError");
        if (!NetworkUtil.isNetworkAvailable(MyApplication.getInstance().getApplicationContext())) {
            ToastUtils.showMsg("当前暂无网络");
        } else if (e instanceof SocketTimeoutException) {
            ToastUtils.showMsg("服务器响应超时");
        } else if (e instanceof ConnectException) {
            ToastUtils.showMsg("服务器请求超时");
        } else if (e instanceof HttpException) {
            ToastUtils.showMsg("服务器异常");
        } else {
            ToastUtils.showMsg("未知异常：" + e.getMessage());
        }
        onComplete();
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
//        Log.i("ly","onComplete");
    }

    public abstract void onSuccess(BaseBean baseBean);

    public abstract void onFail();

}
