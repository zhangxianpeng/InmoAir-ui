package com.inmo.component.demo;

import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.inmo.component.BaseActivity;
import com.inmo.component.R;
import com.inmo.ui.dialog.AnimConfirmCancelDialog;

public class ConfirmCancelDialogTestActivity extends BaseActivity {

    AnimConfirmCancelDialog mConfirmCancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);

        if (mConfirmCancelDialog == null) {
            mConfirmCancelDialog = new AnimConfirmCancelDialog(this);
        }

        if (mConfirmCancelDialog.isShowing()) {
            return;
        }

        mConfirmCancelDialog.setBtnText("Can", "Ens");
        mConfirmCancelDialog.show();
        mConfirmCancelDialog.setTitle("确定把当前选中的9张美美照片同步到手机吗?");
        mConfirmCancelDialog.setOnScrollListener(new AnimConfirmCancelDialog.OnScrollListener() {

            @Override
            public void ensure() {
                LogUtils.d("zxp", "ensure");
                mConfirmCancelDialog.dismiss();
            }

            @Override
            public void cancel() {
                LogUtils.d("zxp", "cancel");
                mConfirmCancelDialog.dismiss();
            }
        });
    }
}