package com.example.administrator.myapplication.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import com.example.administrator.myapplication.R;

public class StatusBarColorUtils {

    /*
     * 修改状态栏颜色
     * 修改状态栏颜色需要先设置activity 透明状态栏
     * getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置字体黑色
     * getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//设置状态栏字体白色
     *
     * */

    public static void changeStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT > 21) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(colorId));

            if (colorId == R.color.colortran) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
        }
    }


}
