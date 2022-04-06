package com.inmo.component;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.inmoair.ui.dialog.AnimConfirmCancelDialog;
import com.inmoair.ui.toast.AirToast;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity {

    private AnimConfirmCancelDialog mConfirmCancelDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AirToast.showToast("蓝牙已连接");
//        AirToast.showIconToast(this, "蓝牙已连接", R.mipmap.ic_launcher);
        showAnimDialog();
    }

    private void showAnimDialog() {
        if (mConfirmCancelDialog == null) {
            mConfirmCancelDialog = new AnimConfirmCancelDialog(MainActivity.this, true);
        }

        if (mConfirmCancelDialog.isShowing()) {
            return;
        }
        mConfirmCancelDialog.setBtnText("取消", "确认");
        mConfirmCancelDialog.show();
        mConfirmCancelDialog.setTitle("确定把当前选中的9张美美照片同步到手机吗确定把当前选中的9张美美照片同步到手机?");
        mConfirmCancelDialog.setOnScrollListener(new AnimConfirmCancelDialog.OnScrollListener() {

            @Override
            public void ensure() {
                mConfirmCancelDialog.dismiss();
            }

            @Override
            public void cancel() {
                mConfirmCancelDialog.dismiss();
            }
        });
    }
}
