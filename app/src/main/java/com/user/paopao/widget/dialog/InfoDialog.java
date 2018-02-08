package com.user.paopao.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.user.paopao.R;


public class InfoDialog extends Dialog implements View.OnClickListener {

    int     layoutRes;// 布局文件
    Context context;
    /**
     * 确定按钮
     **/
    private Button    confirmBtn;
    /**
     * 取消按钮
     **/
    private Button    cancelBtn;
    //图片
    private ImageView lblImageview;
    //标题
    private TextView  lblTitle1;
    //提示内容
    private TextView  lblContent;
    /**
     * 对话框消息标题
     **/
    private String title             = "";
    /**
     * 对话框消息内容
     **/
    private String content           = "";
    /**
     * 确定按钮文本
     **/
    private String confirmButtonText = "";
    /**
     * 取消按钮文本
     **/
    private String cancelButtonText  = "";

    private boolean isCancelGone = false;

    private boolean cancelViible = true;

    private boolean imageViible = false;

    private boolean titleViible = true;

    public boolean AllowBack = true;

    public int contentColor = 0;
    private OnClickListener cancelButtonClickListener;
    private OnClickListener confirmButtonClickListener;

    public InfoDialog(Context context) {
        super(context);
        this.context = context;
    }

    /**
     * 自定义布局的构造方法
     *
     * @param context
     * @param resLayout
     */
    public InfoDialog(Context context, int resLayout) {
        super(context);
        this.context = context;
        this.layoutRes = resLayout;
    }

    /**
     * 自定义主题及布局的构造方法
     *
     * @param context
     * @param theme
     * @param resLayout
     */
    public InfoDialog(Context context, int theme, int resLayout) {
        super(context, theme);
        this.context = context;
        this.layoutRes = resLayout;
    }

    public InfoDialog(Context context, String title, String content) {
        super(context, R.style.dialogStyle);
        this.context = context;
        this.layoutRes = R.layout.layout_dialog;
        this.title = title;
        this.content = content;
    }

    public void setCancelButtonClickListener(OnClickListener listener) {
        this.cancelButtonClickListener = listener;
    }

    public void setConfirmButtonClickListener(OnClickListener listener) {
        this.confirmButtonClickListener = listener;
    }

    public void setTitle(String text) {
        title = text;
    }

    public void setContent(String text) {
        content = text;
    }

    public void setConfirmButtonText(String text) {
        confirmButtonText = text;
    }

    public void setCancelButtonText(String text) {
        cancelButtonText = text;
    }

    public void setCancelButtonVisible(boolean value) {
        cancelViible = value;
    }

    public void setImageviewVisible(boolean value) {
        imageViible = value;
    }

    public void setTitleViible(boolean value) {
        titleViible = value;
    }

    public void setContentColor(int textColor) {

        contentColor = textColor;
    }

    @SuppressWarnings ("unused")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layoutRes);

        Window win = this.getWindow();

        // 根据id在布局中找到控件对象
        confirmBtn = (Button) findViewById(R.id.confirm_btn);
        cancelBtn = (Button) findViewById(R.id.cancel_btn);
        if (layoutRes == R.layout.layout_dialog) {
            lblImageview = (ImageView) findViewById(R.id.lblImageview);
            lblTitle1 = (TextView) findViewById(R.id.lblTitle1);
            lblImageview.setVisibility(imageViible ? View.VISIBLE : View.GONE);
            lblTitle1.setVisibility(titleViible ? View.VISIBLE : View.GONE);
            if (! this.title.equals("")) {

                lblTitle1.setText(this.title);
            }

        }
//        if (layoutRes == R.layout.layout_update_ver) {
//            lblTitle1 = (TextView) findViewById(R.id.lblTitle1);
//            if (! this.title.equals("")) {
//
//                lblTitle1.setText(this.title);
//            }
//        }
        lblContent = (TextView) findViewById(R.id.lblContent);
        confirmBtn.setText(this.confirmButtonText);
        cancelBtn.setText(this.cancelButtonText);

        cancelBtn.setVisibility(cancelViible ? View.VISIBLE : View.GONE);

        // 为按钮绑定点击事件监听器
        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        if (contentColor != 0) {

            lblContent.setTextColor(context.getResources().getColor(contentColor));
        }

        if (! this.content.equals("")) {

            lblContent.setText(this.content);
        }

        if (isCancelGone) {
            if (findViewById(R.id.mVLine) != null) {
                findViewById(R.id.mVLine).setVisibility(View.GONE);
            }
            cancelBtn.setVisibility(View.GONE);
        }
    }

    /**
     * 设置取消按钮隐藏
     */
    public void setCancelGone(boolean isGone) {
        this.isCancelGone = isGone;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.confirm_btn:
                this.confirmButtonClickListener.onClick(this, DialogInterface.BUTTON_POSITIVE);
                break;
            case R.id.cancel_btn:
                this.cancelButtonClickListener.onClick(this, DialogInterface.BUTTON_POSITIVE);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (! AllowBack) {
                return true;
            }

        }

        return false;

    }
}