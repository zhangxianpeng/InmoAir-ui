package com.inmoair.ui.toast;

import static com.blankj.utilcode.util.ColorUtils.getColor;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static void showIconToast(Context context, String message, int resourceId) {
        View root = LayoutInflater.from(context).inflate(R.layout.layout_image_text_toast, null);
        ImageView imageView = root.findViewById(R.id.imageView);
        TextView content = root.findViewById(R.id.tv_content);
        imageView.setImageResource(resourceId);
        content.setText(message);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.TOP, 0, 4);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(root);
        toast.show();
    }
}
