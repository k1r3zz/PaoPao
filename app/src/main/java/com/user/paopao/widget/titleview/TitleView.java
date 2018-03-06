package com.user.paopao.widget.titleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.user.paopao.R;


/**
 * author :kira
 * date: 2018/1/11.
 * description:标题栏
 */

public class TitleView extends RelativeLayout {
    private RelativeLayout view;
    private ImageView titleview_left;
    private TextView titleview_title;
    private TextView title_right_tv;
    private ImageView titleview_right;
    private RelativeLayout mRlTitleTop;

    public TitleView(Context context) {
        super(context);
        setView(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);

    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);

    }

    private void setView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = (RelativeLayout) inflater.inflate(R.layout.titleview_layout, this);
        mRlTitleTop = (RelativeLayout) view.findViewById(R.id.mRlTitleTop);
        titleview_left = (ImageView) view.findViewById(R.id.titleview_left);
        titleview_title = (TextView) view.findViewById(R.id.titleview_title);
        titleview_right = (ImageView) view.findViewById(R.id.titleview_right);
        title_right_tv = (TextView) view.findViewById(R.id.title_right_tv);
    }

    /**
     * 设置标题文字
     *
     * @param text
     */
    public void setTitleText(String text) {
        titleview_title.setText(text);
    }

    /**
     * 设置右边文字
     *
     * @param text
     */
    public void setRightText(String text) {
        title_right_tv.setText(text);
        title_right_tv.setVisibility(View.VISIBLE);
    }


    /**
     * 得到标题
     */
    public String getTitleText() {
        return titleview_title.getText().toString();
    }

//    /**
//     * 设置左边文字
//     *
//     * @param text
//     */
//    public void setLeftText(String text) {
//        titleview_left.setText(text);
//    }


    /**
     * 设置左右文字点击事件
     *
     * @param onClick
     */
    public void setOnLeftClick(OnClickListener onClick) {
        titleview_left.setOnClickListener(onClick);
    }

    /**
     * 设置右边文字点击事件
     *
     * @param onClick
     */
    public void setOnRightClick(OnClickListener onClick) {
        titleview_right.setOnClickListener(onClick);
    }

    /**
     * 设置背景色
     *
     * @param color
     */
    public void setBackgroundColor(int color) {
        mRlTitleTop.setBackgroundColor(color);
    }


    public void settitleviewTitleColor(int color) {
        titleview_title.setTextColor(color);
    }

}
