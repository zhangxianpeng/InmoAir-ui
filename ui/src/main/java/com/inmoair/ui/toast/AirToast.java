package com.inmoair.ui.toast;

import static com.blankj.utilcode.util.ColorUtils.getColor;

import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;
import com.inmoair.ui.R;

/**
 * @author Administrator
 * Air组件-Toast提示
 */
public class AirToast {

    public static void showToast(String message) {
        ToastUtils.make().setBgResource(R.drawable.bg_toast)
                .setTextColor(getColor(R.color.white))
                .setTextSize(26)
                .setGravity(Gravity.TOP, 0, 4)
                .show(message);
    }
}
