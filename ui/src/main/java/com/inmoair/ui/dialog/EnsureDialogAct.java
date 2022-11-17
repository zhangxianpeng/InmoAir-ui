package com.inmoair.ui.dialog;

import static android.view.KeyEvent.KEYCODE_NUMPAD_ENTER;
import static android.view.KeyEvent.KEYCODE_SPACE;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.inmoair.ui.R;
import com.inmoair.ui.databinding.ActivityEnsureDialogBinding;

/**
 * @author Administrator
 * 以Act的方式展现dialog,避免dialog直接获取焦点
 */
public class EnsureDialogAct extends AppCompatActivity {

    private ActivityEnsureDialogBinding mBinding;
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_SUB_TITLE = "subTitle";
    public static final String EXTRA_LEFT_BTN_TEXT = "leftBtnText";
    public static final String EXTRA_RIGHT_BTN_TEXT = "rightBtnText";
    public static final String EXTRA_IS_SHOW_TOP_IMAGE = "isShowTopImage";
    public static final String EXTRA_ICON = "topImage";
    /**
     * 标题
     */
    private String title;
    /**
     * 二级标题
     */
    private String subTitle;
    /**
     * 左边按钮
     */
    private String leftBtnText;
    /**
     * 右边按钮
     */
    private String rightBtnText;
    /**
     * 顶部图标是否展示
     */
    private boolean isShowTopImage;
    private byte[] appIcon;
    private Bitmap icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_ensure_dialog);
        if (getIntent() == null) return;
        isShowTopImage = getIntent().getBooleanExtra(EXTRA_IS_SHOW_TOP_IMAGE, false);
        appIcon = getIntent().getByteArrayExtra(EXTRA_ICON);
        if (isShowTopImage) {
            icon = BitmapFactory.decodeByteArray(appIcon, 0, appIcon.length);
        }
        title = getIntent().getStringExtra(EXTRA_TITLE);
        subTitle = getIntent().getStringExtra(EXTRA_SUB_TITLE);
        leftBtnText = getIntent().getStringExtra(EXTRA_LEFT_BTN_TEXT);
        rightBtnText = getIntent().getStringExtra(EXTRA_RIGHT_BTN_TEXT);
        initViews();
    }

    private void initViews() {
        if (isShowTopImage) {
            mBinding.ivTop.setVisibility(View.VISIBLE);
            mBinding.tvTitle.setVisibility(View.GONE);

            mBinding.ivTop.setImageBitmap(icon);
        } else {
            mBinding.ivTop.setVisibility(View.GONE);
            mBinding.tvTitle.setVisibility(View.VISIBLE);

            if (TextUtils.isEmpty(title)) return;
            mBinding.tvTitle.setText(title);
        }

        if (!TextUtils.isEmpty(subTitle)) {
            mBinding.tvSubtitle.setText(subTitle);
        }

        if (!TextUtils.isEmpty(leftBtnText)) {
            mBinding.tvCancel.setText(leftBtnText);
        }

        if (!TextUtils.isEmpty(rightBtnText)) {
            mBinding.tvEnsure.setText(rightBtnText);
        }
    }

    private boolean isSelectRight = true;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 戒指
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (isSelectRight) {
                    translationLeft();
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (!isSelectRight) {
                    translationRight();
                }
                break;
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_ESCAPE:
                finish();
                break;
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KEYCODE_SPACE:
            case KEYCODE_NUMPAD_ENTER:
                if (isSelectRight) {
                    rightBtnClickEvent();
                } else {
                    leftBtnClickEvent();
                }
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void translationLeft() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -148, 0, 0);
        translateAnimation.setFillAfter(true);
        mBinding.viewSelect.startAnimation(translateAnimation);
        mBinding.tvCancel.setTextColor(ContextCompat.getColor(this, R.color.colorBlack));
        mBinding.tvEnsure.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        isSelectRight = false;
    }

    private void translationRight() {
        TranslateAnimation translateAnimation1 = new TranslateAnimation(-148, 0, 0, 0);
        translateAnimation1.setFillAfter(true);
        mBinding.viewSelect.startAnimation(translateAnimation1);
        mBinding.tvEnsure.setTextColor(ContextCompat.getColor(this, R.color.colorBlack));
        mBinding.tvCancel.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        isSelectRight = true;
    }

    private void rightBtnClickEvent() {
        Intent intent = getIntent();
        intent.putExtra("btnClickEvent", "right");
        setResult(RESULT_OK, intent);
        finish();
    }

    private void leftBtnClickEvent() {
        Intent intent = getIntent();
        intent.putExtra("btnClickEvent", "left");
        setResult(RESULT_OK, intent);
        finish();
    }
}