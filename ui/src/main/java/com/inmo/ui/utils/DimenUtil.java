package com.inmo.ui.utils;

import android.content.Context;

/**
 * @author Admininstrator
 * @date 2021-11-01
 */
public class DimenUtil {
    /**
     * 单位转换: dp -> px
     *
     * @param dp
     * @return
     */
    public static int dp2px(Context context, int dp) {
        return (int) (getDensity(context) * dp + 0.5);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}
