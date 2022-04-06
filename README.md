Inmo Air UI

项目地址：
项目包含：
1.1 不带Icon的Toast。 调用方法：
AirToast.showToast("蓝牙已连接");

1.2 二次确认弹框。 调用方式：
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


