package com.inmo.component.demo;

import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.inmo.component.BaseActivity;
import com.inmo.component.R;
import com.inmo.ui.dialog.AnimConfirmCancelDialog;

public class IconConfirmCancelDialogTestActivity extends BaseActivity {
    private static final String TAG = IconConfirmCancelDialogTestActivity.class.getSimpleName();
    AnimConfirmCancelDialog mConfirmCancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);
        showDialog();
    }

    private void showDialog() {
        if (mConfirmCancelDialog == null) {
            mConfirmCancelDialog = new AnimConfirmCancelDialog(this);
        }

        if (mConfirmCancelDialog.isShowing()) {
            return;
        }
        mConfirmCancelDialog.setBtnText("取消", "确认");
        mConfirmCancelDialog.show();
        mConfirmCancelDialog.setTitle("确定把当前选中的9张美美照片同步到手机吗?");
        mConfirmCancelDialog.setIcon(R.drawable.ic_launcher_background);
        mConfirmCancelDialog.setTitleMarginTop();
        mConfirmCancelDialog.setOnScrollListener(new AnimConfirmCancelDialog.OnScrollListener() {

            @Override
            public void ensure() {
                LogUtils.d(TAG, "ensure");
                mConfirmCancelDialog.dismiss();
            }

            @Override
            public void cancel() {
                LogUtils.d(TAG, "cancel");
                mConfirmCancelDialog.dismiss();
            }
        });
    }
}