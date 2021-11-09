package com.inmo.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 吐司工具，减少代码复用
 *
 * @author Administrator
 * @date 2021-11-09
 */
public class ToastUtil {
    private static Toast toast;

    private static ToastUtil instance = null;

    public static synchronized ToastUtil getInstance() {
        if (instance == null)
            instance = new ToastUtil();
        return instance;
    }

    /**
     * 短时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToast(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 短时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastCenter(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 短时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showShortToastTop(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast【居下】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToast(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastCenter(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast【居上】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showLongToastTop(Context applicationContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
