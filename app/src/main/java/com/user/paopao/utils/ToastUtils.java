package com.user.paopao.utils;

import android.widget.Toast;

import com.user.paopao.MyApplication;


/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 吐司工具类
 */
public class ToastUtils {

    public static Toast mToast;

    public static void showMsg(String text) {

        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance().getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }
}
