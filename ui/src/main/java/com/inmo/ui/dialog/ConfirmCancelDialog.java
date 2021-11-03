package com.inmo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.inmo.ui.R;

/**
 * 封装一个弹框
 * 确定按钮样式为渐变蓝色
 * 可以控制： 关闭按钮是否展示、标题显示、内容显示、是否展示标题、是否展示取消按钮等
 * 效果查看：com.inmo.component.MainActivity
 *
 * @author Administrator
 * @date 2021-11-02
 */
public class ConfirmCancelDialog {
    private Builder mBuilder;

    public ConfirmCancelDialog(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public void show() {
        mBuilder.showDialog();
    }

    public void disMiss() {
        mBuilder.dismiss();
    }

    public static class Builder extends Dialog implements View.OnClickListener {

        /**
         * 是否展示关闭按钮
         */
        private boolean isShowCloseIcon;
        /**
         * 是否展示标题栏
         */
        private boolean isShowTitle;
        /**
         * 是否展示取消按钮
         */
        private boolean isShowCancel;
        private String titleMsg;
        private String contentMsg;
        private String cancelMsg;
        private String sureMsg;

        private DialogListener mDialogListener;

        public interface DialogListener {
            /**
             * 确定
             */
            void sure();

            /**
             * 取消
             */
            void cancel();
        }

        void showDialog() {
            show();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_confirm_cancel);
            initUi();
            initEvent();
            initViewStatus();
        }

        private ImageView closeIv;
        private TextView titleTv;
        private TextView infoTv;
        private TextView cancelTv;
        private TextView ensureTv;
        private View diver;

        private void initUi() {
            closeIv = findViewById(R.id.iv_close);
            titleTv = findViewById(R.id.tv_title);
            infoTv = findViewById(R.id.txt_msg);
            cancelTv = findViewById(R.id.txt_cancel);
            ensureTv = findViewById(R.id.txt_ensure);
            diver = findViewById(R.id.view_diver);
        }

        private void initViewStatus() {
            closeIv.setVisibility(isShowCloseIcon ? View.VISIBLE : View.GONE);
            titleTv.setVisibility(isShowTitle ? View.VISIBLE : View.GONE);
            cancelTv.setVisibility(isShowCancel ? View.VISIBLE : View.GONE);
            diver.setVisibility(isShowCancel ? View.VISIBLE : View.GONE);
            titleTv.setText(TextUtils.isEmpty(titleMsg) ? "" : titleMsg);
            infoTv.setText(TextUtils.isEmpty(contentMsg) ? "" : contentMsg);
            cancelTv.setText(TextUtils.isEmpty(cancelMsg) ? "取消" : cancelMsg);
            ensureTv.setText(TextUtils.isEmpty(sureMsg) ? "确定" : sureMsg);
        }

        private void initEvent() {
            closeIv.setOnClickListener(this);
            cancelTv.setOnClickListener(this);
            ensureTv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.txt_cancel) {
                if (mDialogListener != null) {
                    dismiss();
                    mDialogListener.cancel();
                }
            } else if (viewId == R.id.txt_ensure) {
                if (mDialogListener != null) {
                    dismiss();
                    mDialogListener.sure();
                }
            } else if (viewId == R.id.iv_close) {
                dismiss();
            }
        }

        public Builder(@NonNull Context context) {
            super(context, R.style.ConfirmDialog);
            setCanceledOnTouchOutside(false);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams wl = getWindow().getAttributes();
            wl.gravity = Gravity.CENTER;
            getWindow().setAttributes(wl);
        }

        /**
         * 按钮事件监听
         *
         * @param listener
         * @return
         */
        public Builder setListener(DialogListener listener) {
            this.mDialogListener = listener;
            return this;
        }

        /**
         * 控制关闭图标是否显示
         *
         * @param mIsShowCloseIcon
         * @return
         */
        public Builder setCloseIconVisible(boolean mIsShowCloseIcon) {
            this.isShowCloseIcon = mIsShowCloseIcon;
            return this;
        }

        /**
         * 控制标题栏是否显示
         *
         * @param mIsShowTitle
         * @return
         */
        public Builder setTitleVisible(boolean mIsShowTitle) {
            this.isShowTitle = mIsShowTitle;
            return this;
        }

        public Builder setCancelBtnVisible(boolean mIsShowCancelBtn) {
            this.isShowCancel = mIsShowCancelBtn;
            return this;
        }

        /**
         * 设置标题
         *
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.titleMsg = title;
            return this;
        }

        /**
         * 设置内容
         *
         * @param content
         * @return
         */
        public Builder setContent(String content) {
            this.contentMsg = content;
            return this;
        }

        /**
         * 设置左边按钮显示文字
         *
         * @param cancelTitle
         * @return
         */
        public Builder setCancelTitle(String cancelTitle) {
            this.cancelMsg = cancelTitle;
            return this;
        }

        /**
         * 设置右边按钮显示文字
         *
         * @param ensureTitle
         * @return
         */
        public Builder setEnsureTitle(String ensureTitle) {
            this.sureMsg = ensureTitle;
            return this;
        }

        public ConfirmCancelDialog build() {
            return new ConfirmCancelDialog(this);
        }
    }
}