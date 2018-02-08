package com.user.paopao.widget.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * author：lily
 * date：2017/12/15 09:55
 * description: 公用加载框
 */
public class LoaddingDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AppCompatDialog dialog = new AppCompatDialog(getContext());
        LinearLayout root = new LinearLayout(getContext());
        root.setGravity(Gravity.CENTER);
        root.setPadding(40,25,40,25);
        root.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#66000000")));
        root.setOrientation(LinearLayout.VERTICAL);
        ProgressBar progressBar = new ProgressBar(getContext());
        TextView textView = new TextView(getContext());
        textView.setText("载入中...");
        textView.setTextSize(15);
        root.setGravity(Gravity.CENTER);
        root.addView(progressBar);
        root.addView(textView);
        dialog.setContentView(root);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    return true;
                }
                return false;
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
    }
}
