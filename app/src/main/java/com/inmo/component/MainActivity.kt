package com.inmo.component

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addConfirmCancelDialogBelowProgress()
        btn_ui.setOnClickListener {
            val intent = Intent(this, UiActivity::class.java)
            startActivity(intent)
        }
        btn_net.setOnClickListener {
            val intent = Intent(this, NetworkActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addConfirmCancelDialogBelowProgress() {
        // ConfirmCancelDialog
//        ConfirmCancelDialog commonDialog = new ConfirmCancelDialog.Builder(this)
//                .setListener(new ConfirmCancelDialog.Builder.DialogListener() {
//                    @Override
//                    public void sure() {
//                        // TODO: 2021/11/2
//                    }
//
//                    @Override
//                    public void cancel() {
//                        // TODO: 2021/11/2
//                    }
//                })
//                .setCloseIconVisible(false)
//                .setTitleVisible(false)
//                .setCancelBtnVisible(false)
//                .setTitle("更新通知")
//                .setContent("当前版本暂不可用，请下载最新版本，以便享受优质内容。")
//                .build();
//        commonDialog.show();
//        val loadingDialog = LoadingDialog(this@MainActivity)
//        loadingDialog.show("", false, false)
    }
}