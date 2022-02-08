package com.inmo.ui.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.inmo.ui.R;

/**
 * @author Administrator
 */
public class PopupToastUtil {
    private static Handler myHandler = new Handler(Looper.getMainLooper());

    public static void showToast(Context context, View rootView, String toastMsg) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_text_toast, null, false);
        TextView contentTextView = (TextView) view.findViewById(R.id.tv_content);
        contentTextView.setText(toastMsg);
        final PopupWindow popWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popWindow.showAsDropDown(rootView, 0, 4);
        myHandler.postDelayed(() -> popWindow.dismiss(), 2000);
    }
}
