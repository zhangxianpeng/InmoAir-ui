package com.inmo.ui.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.inmo.ui.R;
import com.inmo.ui.utils.DimenUtil;

import java.text.DecimalFormat;

/**
 * 自定义进度条
 *
 * @author Admininstrator
 * @date 2021-11-01
 */
public class CommonProgressBar extends View {
    /**
     * 进度条最大值
     */
    private float mMax = 100;
    /**
     * 进度条当前值
     */
    private float mProgress = 0;
    /**
     * 默认已完成颜色
     */
    private final int DEFAULT_FINISHED_COLOR = getResources().getColor(R.color.colorPrimary);
    /**
     * 默认未完成颜色
     */
    private final int DEFAULT_UNFINISHED_COLOR = getResources().getColor(R.color.colorAccent);
    /**
     * 已完成进度颜色
     */
    private int mReachedBarColor;
    /**
     * 未完成进度颜色
     */
    private int mUnreachedBarColor;
    /**
     * 进度条高度
     */
    private float mBarHeight;
    /**
     * 圆角大小
     */
    private float mCornerValue = 0;
    /**
     * 文字颜色
     */
    private int mTextColor;
    /**
     * 文字后缀
     */
    private String mSuffix = "%";
    /**
     * 文字前缀
     */
    private String mPrefix = "";
    /**
     * 未完成进度条所在矩形区域
     */
    private RectF mUnreachedRectF = new RectF(0, 0, 0, 0);
    /**
     * 已完成进度条所在矩形区域
     */
    private RectF mReachedRectF = new RectF(0, 0, 0, 0);
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 是否显示进度文字
     */
    private boolean mTextVisibility;


    public CommonProgressBar(Context context) {
        this(context, null);
    }

    public CommonProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initPainters();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonProgressBar);
        mMax = typedArray.getInteger(R.styleable.CommonProgressBar_maxValue, (int) mMax);
        mProgress = typedArray.getInteger(R.styleable.CommonProgressBar_currentValue, (int) mProgress);
        mReachedBarColor = typedArray.getColor(R.styleable.CommonProgressBar_reachedBarColor, DEFAULT_FINISHED_COLOR);
        mUnreachedBarColor = typedArray.getColor(R.styleable.CommonProgressBar_unreachedBarColor, DEFAULT_UNFINISHED_COLOR);
        mTextColor = typedArray.getColor(R.styleable.CommonProgressBar_textColor, DEFAULT_UNFINISHED_COLOR);
        mSuffix = TextUtils.isEmpty(typedArray.getString(R.styleable.CommonProgressBar_suffix)) ? mSuffix : typedArray.getString(R.styleable.CommonProgressBar_suffix);
        mPrefix = TextUtils.isEmpty(typedArray.getString(R.styleable.CommonProgressBar_preSuffix)) ? mPrefix : typedArray.getString(R.styleable.CommonProgressBar_preSuffix);
        mBarHeight = typedArray.getDimension(R.styleable.CommonProgressBar_height, DimenUtil.dp2px(context, 2));
        mCornerValue = typedArray.getInteger(R.styleable.CommonProgressBar_corner, (int) mCornerValue);
        mTextVisibility = typedArray.getBoolean(R.styleable.CommonProgressBar_textVisibility, true);
        typedArray.recycle();
    }

    private void initPainters() {
        // 抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 防抖动
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        calculateDrawRectFWithoutProgressText();
        mPaint.setColor(mUnreachedBarColor);
        canvas.drawRoundRect(mUnreachedRectF, mCornerValue, mCornerValue, mPaint);

        mPaint.setColor(mReachedBarColor);
        canvas.drawRoundRect(mReachedRectF, mCornerValue, mCornerValue, mPaint);

        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mBarHeight * 0.6f);
        String mCurrentDrawText = new DecimalFormat("#").format(getProgress() * 100 / getMax());
        mCurrentDrawText = mPrefix + mCurrentDrawText + mSuffix;
        float mDrawTextWidth = mPaint.measureText(mCurrentDrawText);
        if (mTextVisibility && getProgress() > 0 && mReachedRectF.right > mDrawTextWidth) {
            canvas.drawText(mCurrentDrawText, mReachedRectF.right - mDrawTextWidth - mBarHeight * 0.4f, (int) ((getHeight() / 2.0f) - ((mPaint.descent() + mPaint.ascent()) / 2.0f)), mPaint);
        }
    }

    private void calculateDrawRectFWithoutProgressText() {
        mReachedRectF.left = getPaddingLeft();
        mReachedRectF.top = getHeight() / 2.0f - mBarHeight / 2.0f;
        mReachedRectF.right = (getWidth() - getPaddingLeft() - getPaddingRight()) / (getMax() * 1.0f) * getProgress() + getPaddingLeft();
        mReachedRectF.bottom = getHeight() / 2.0f + mBarHeight / 2.0f;

        mUnreachedRectF.left = getPaddingLeft();
        mUnreachedRectF.top = getHeight() / 2.0f + -mBarHeight / 2.0f;
        mUnreachedRectF.right = getWidth() - getPaddingRight();
        mUnreachedRectF.bottom = getHeight() / 2.0f + mBarHeight / 2.0f;
    }

    public float getMax() {
        return mMax;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setMax(int max) {
        this.mMax = max;
        invalidate();
    }

    public void setProgress(float progress) {
        this.mProgress = checkProgress(progress);
        invalidate();
    }

    private float checkProgress(float progress) {
        if (progress < 0) return 0;
        return progress > mMax ? mMax : progress;
    }
}


