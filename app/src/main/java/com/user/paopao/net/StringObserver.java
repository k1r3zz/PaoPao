package com.user.paopao.net;


import com.user.paopao.MyApplication;
import com.user.paopao.utils.NetworkUtil;
import com.user.paopao.utils.ToastUtils;

import org.json.JSONObject;

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
public abstract class StringObserver implements Observer<String> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {
        try {
            JSONObject object = new JSONObject(s);
            int code = object.getInt("http_status");
            String status=object.getString("return_code");
            if(code!=200){
                ToastUtils.showMsg("网络出错");
                return;
            }
            if (status.equals("SUCCESS")) {
                onSuccess(s);
            } else {
                String message = object.getString("return_msg");
                ToastUtils.showMsg(message);
                onFaild(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showMsg(e.getMessage());
            onComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (!NetworkUtil.isNetworkAvailable(MyApplication.getInstance().getApplicationContext())) {
            ToastUtils.showMsg("当前暂无网络");
            onFaild("当前暂无网络");
        } else if (e instanceof SocketTimeoutException) {
            ToastUtils.showMsg("服务器响应超时");
            onFaild("服务器响应超时");
        } else if (e instanceof ConnectException) {
            ToastUtils.showMsg("服务器请求超时");
            onFaild("服务器请求超时");
        } else if (e instanceof HttpException) {
            ToastUtils.showMsg("服务器异常");
            onFaild("服务器异常");
        } else {
            ToastUtils.showMsg("未知异常：" + e.getMessage());
            onFaild("未知异常");

        }
        onComplete();
        e.printStackTrace();


    }

    protected abstract void onSuccess(String json) throws Exception;

    protected abstract void onFaild(String message);

}
