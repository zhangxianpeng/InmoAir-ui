package com.inmo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.inmo.ui.R;

/**
 * 封装一个动画弹框
 * 确定按钮样式为渐变蓝色
 * 可以控制： 关闭按钮是否展示、标题显示、内容显示、是否展示标题、是否展示取消按钮等
 *
 * @author Administrator
 * @date 2021-11-02
 */
public class AnimConfirmCancelDialog extends Dialog {

    TextView tvCancel;
    TextView tvConfirm;

    String cancelString = "", confirmString = "";
    Boolean isHaveIcon = false;

    public AnimConfirmCancelDialog(@NonNull Context context) {
        super(context, R.style.ConfirmCancelDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_comfirm_cancel);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private ImageView mIvAppIcon;
    private TextView mTvAppDeleteTip;

    public void setBtnText(String cancelText, String confirmText) {
        this.cancelString = cancelText;
        this.confirmString = confirmText;
    }

    private void initView() {
        tvCancel = findViewById(R.id.tvCancel);
        tvConfirm = findViewById(R.id.tvDelete);
        mIvAppIcon = findViewById(R.id.ivAppIcon);
        mTvAppDeleteTip = findViewById(R.id.tvAppDeleteTip);
        if (!TextUtils.isEmpty(cancelString)) {
            tvCancel.setText(cancelString);
            tvConfirm.setText(confirmString);
        }

        MotionLayout mlDelete = findViewById(R.id.mlDelete);
        mlDelete.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                if (currentId == R.id.delete_cancel_end) {
                    tvCancel.setBackgroundResource(R.drawable.shape_cancel_whole_bg);
                    if (mOnScrollListener != null) mOnScrollListener.cancel();
                } else if (currentId == R.id.delete_confirm_end) {
                    tvConfirm.setBackgroundResource(R.drawable.shape_confirm_whole_bg);
                    if (mOnScrollListener != null) mOnScrollListener.ensure();
                } else if (currentId == R.id.delete_start) {
                    tvCancel.setBackgroundResource(R.drawable.shape_cancel_half_bg);
                    tvConfirm.setBackgroundResource(R.drawable.shape_confirm_half_bg);
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

            }
        });
    }

    public void setTitle(String name) {
        if (mTvAppDeleteTip != null) {
            mTvAppDeleteTip.setText(name);
        }
    }

    public void setIcon(int icon) {
        isHaveIcon = true;
        if (mIvAppIcon != null) {
            mIvAppIcon.setVisibility(View.VISIBLE);
            mIvAppIcon.setImageResource(icon);
        }
    }

    public void setTitleMarginTop() {
        MotionLayout.LayoutParams lp = new MotionLayout.LayoutParams(MotionLayout.LayoutParams.WRAP_CONTENT, MotionLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, isHaveIcon ? 116 : 52, 0, 0);
        if (mTvAppDeleteTip != null) {
            mTvAppDeleteTip.setLayoutParams(lp);
        }
    }

    private OnScrollListener mOnScrollListener;

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
    }

    public interface OnScrollListener {
        void ensure();

        void cancel();
    }

}
