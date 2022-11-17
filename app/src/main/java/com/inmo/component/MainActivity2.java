package com.inmo.component;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.ImageUtils;
import com.inmoair.ui.dialog.EnsureDialogAct;

public class MainActivity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Intent intent = new Intent(this, EnsureDialogAct.class);
//        intent.putExtra(EnsureDialogAct.EXTRA_IS_SHOW_TOP_IMAGE,false);
//        intent.putExtra(EnsureDialogAct.EXTRA_TITLE,"titile");
//        intent.putExtra(EnsureDialogAct.EXTRA_SUB_TITLE, "v1.1.0");
//        intent.putExtra(EnsureDialogAct.EXTRA_LEFT_BTN_TEXT, "cancle");
//        intent.putExtra(EnsureDialogAct.EXTRA_RIGHT_BTN_TEXT, "ensure");
//        startActivityForResult(intent, 10000);
    }
}