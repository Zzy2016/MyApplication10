package com.example.administrator.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import com.example.administrator.myapplication.R;

public class StatusBarColorUtils {

    private Context context;

    public static void changeStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT > 21) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(colorId));
        }
    }


}
