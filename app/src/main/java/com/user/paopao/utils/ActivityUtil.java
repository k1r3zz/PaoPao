package com.user.paopao.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;
import java.util.Locale;

/**
 * author :kira
 * date: 2018/1/23.
 * description:
 */

public class ActivityUtil {

    @SuppressLint("InlinedApi")
    public static void transplantStatus(Activity activity) {
        // 透明状态栏
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else  // 5.0以上系统状态栏透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 是否安装了微信
     *
     * @param context
     * @return
     */
    public static boolean isWeiXinInstalled(Context context) {
        PackageManager pm = context.getPackageManager();
        if (pm == null) {
            return false;
        }

        List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
        for (PackageInfo info : packageInfos) {
            if ("com.tencent.mm".equals(TextUtils.valueOfNoNull(info.packageName.toLowerCase(Locale.getDefault())))) {
                return true;
            }
        }
        return false;
    }
}
