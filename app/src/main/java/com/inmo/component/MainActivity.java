package com.inmo.component;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.inmoair.ui.dialog.AnimConfirmCancelDialog;

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
            mConfirmCancelDialog = new AnimConfirmCancelDialog(MainActivity.this, 2);
        }

        if (mConfirmCancelDialog.isShowing()) {
            return;
        }
        mConfirmCancelDialog.setBtnText("取消", "确认");
        mConfirmCancelDialog.show();
        mConfirmCancelDialog.setTitle("是否恢复出场设置?");
        mConfirmCancelDialog.setMiddleMsg("清除的数据无法还原，请谨慎操作");
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
