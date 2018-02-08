package com.user.paopao.utils;

import android.app.Application;
import android.widget.TextView;

@SuppressWarnings("unused")
public final class TextUtils {
    private static Application mContext;

    public static String getString(final int sqlResId) {
        return mContext.getString(sqlResId);
    }

    public static String getString(final int resId, final Object... formatArgs) {
        return mContext.getString(resId, formatArgs);
    }

    public static String[] getStringArray(final int resId) {
        return mContext.getResources().getStringArray(resId);
    }

    /**
     * 一般在自定义Application中的onCreate里初始化<br/>
     * 【不能在Application的构造函数里调用！】<br/>
     * 因为此时应用的String资源尚未初始化完毕，会报Null异常！
     */
    public static synchronized void init(final Application app) {
        //避免重复初始化
        if (mContext != null)
            return;
        mContext = app;
    }

    public static boolean isEmpty(final CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmptyOrOnlyWhiteSpace(final CharSequence value) {
        return null == value//
                || value.length() == 0//
                || android.text.TextUtils.getTrimmedLength(value) == 0
                || String.valueOf(value).trim().length() == 0;
    }

    public static boolean isEmptyOrOnlyWhiteSpace(final TextView value) {
        return null == value//
                || value.length() == 0//
                || android.text.TextUtils.getTrimmedLength(value.getText()) == 0
                || String.valueOf(value.getText()).trim().length() == 0;
    }

    /**
     * 填充左边多少个英文字符，中文会自动减半
     *
     * @param padLength 需要填充的英文字符长度
     */
    public static String padLeft(String txt, int padLength, char padChar) {
        int count = txt.length();

        //最终填充到指定长度
        //如：7，填充为10
        StringBuilder tmp = new StringBuilder(txt);
        while (count < padLength) {
            tmp.insert(0, padChar);
            count++;
        }
        return tmp.toString();
    }

    /**
     * 填充右边多少个英文字符，中文会自动减半
     *
     * @param padLength 需要填充的英文字符长度
     */
    public static String padRight(String txt, int padLength, char padChar) {
        int count = txt.length();

        //最终填充到指定长度
        //如：7，填充为10
        StringBuilder tmp = new StringBuilder(txt);
        while (count < padLength) {
            tmp.append(padChar);
            count++;
        }
        return tmp.toString();
    }

    /**
     * 和 String.valueOf(Object) 区别就是value为Null时，返回字符串""，而不是"null"!
     */
    public static String valueOfNoNull(final Object value) {
        return value != null ? value.toString() : "";
    }
}
