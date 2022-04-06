package com.inmoair.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.inmoair.ui.R;

/**
 * 封装一个动画弹框
 * 确定按钮样式为渐变蓝色
 * 可以控制： 关闭按钮是否展示、标题显示、内容显示、是否展示标题、是否展示取消按钮等
 *
 * @author Administrator
 * @date 2021-11-02
 */
public class AnimConfirmCancelDialog extends Dialog {
    MotionLayout mlDelete;
    ImageView mIconImageView;
    TextView mLeftTextView;
    String leftString;
    TextView mRightTextView;
    String rightString;
    TextView mTitleTextView;
    TextView mMsgTextView;
    int layoutId = -1;

    public AnimConfirmCancelDialog(@NonNull Context context, int layoutId) {
        super(context, R.style.ConfirmCancelDialog);
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (layoutId) {
            case 0:
                setContentView(R.layout.layout_dialog_comfirm_cancel_no_icon);
                break;
            case 1:
                setContentView(R.layout.layout_dialog_comfirm_cancel_icon);
                break;
            case 2:
                setContentView(R.layout.layout_dialog_comfirm_cancel);
                break;
            default:
                break;
        }
        setCanceledOnTouchOutside(false);
        initView();
    }

    public void setIconResource(int resourceId) {
        if (mIconImageView != null) {
            mIconImageView.setVisibility(View.VISIBLE);
            mIconImageView.setImageResource(resourceId);
        }
    }

    public void setBtnText(String leftText, String rightText) {
        this.leftString = leftText;
        this.rightString = rightText;
    }

    public void setTitle(String titleMsg) {
        if (mTitleTextView != null && !TextUtils.isEmpty(titleMsg)) {
            mTitleTextView.setText(titleMsg);
        }
    }

    public void setMiddleMsg(String middleMsg) {
        if (mMsgTextView != null && !TextUtils.isEmpty(middleMsg)) {
            mMsgTextView.setText(middleMsg);
        }
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull MotionEvent ev) {
        if (mlDelete!=null){
            return mlDelete.onTouchEvent(ev);
        }
        return true;
    }

    private void initView() {
        mlDelete = findViewById(R.id.mlDelete);
        mLeftTextView = findViewById(R.id.tvCancel);
        mRightTextView = findViewById(R.id.tvDelete);
        mIconImageView = findViewById(R.id.ivAppIcon);
        mTitleTextView = findViewById(R.id.tvAppDeleteTip);
        if (!TextUtils.isEmpty(leftString)) {
            mLeftTextView.setText(leftString);
        }
        if (!TextUtils.isEmpty(rightString)) {
            mRightTextView.setText(rightString);
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
                    mLeftTextView.setBackgroundResource(R.drawable.shape_cancel_whole_bg);
                    if (mOnScrollListener != null) {
                        mOnScrollListener.cancel();
                    }
                } else if (currentId == R.id.delete_confirm_end) {
                    mRightTextView.setBackgroundResource(R.drawable.shape_confirm_whole_bg);
                    if (mOnScrollListener != null) {
                        mOnScrollListener.ensure();
                    }
                } else if (currentId == R.id.delete_start) {
                    mLeftTextView.setBackgroundResource(R.drawable.shape_cancel_half_bg);
                    mRightTextView.setBackgroundResource(R.drawable.shape_confirm_half_bg);
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

            }
        });
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
