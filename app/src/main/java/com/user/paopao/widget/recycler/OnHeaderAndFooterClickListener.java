package com.user.paopao.widget.recycler;

import android.view.View;

public interface OnHeaderAndFooterClickListener {

    void onHeaderClick(View v, int position);

    void onItemViewClick(View v, int position);

    void onLoadMore();

}
