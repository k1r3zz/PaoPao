package com.user.paopao.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * author :kira
 * date: 2018/1/15.
 * description:不滚动显示完全的recycler
 */

public class NoSrollerRecycler extends RecyclerView {
    public NoSrollerRecycler(Context context) {
        super(context);
    }

    public NoSrollerRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoSrollerRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
