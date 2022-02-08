package com.inmo.ui.loading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.inmo.ui.R;

/**
 * @author Administrator
 * 菊花进度展示弹窗
 */
public class LoadingView extends androidx.appcompat.widget.AppCompatImageView {
    AnimationDrawable animationDrawable;

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        animationDrawable = (AnimationDrawable) this.getDrawable();
    }

    public void showLoadingView() {
        this.setVisibility(View.VISIBLE);
        startAnim();
    }

    public void hideLoadingView() {
        endAnim();
        this.setVisibility(View.INVISIBLE);
    }

    private void startAnim() {
        if (animationDrawable != null)
            animationDrawable.start();
    }

    private void endAnim() {
        if (animationDrawable != null)
            animationDrawable.stop();
    }
}
