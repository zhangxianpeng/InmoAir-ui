package com.inmo.ui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.inmo.ui.R;

/**
 * 类似switch控件
 * 自定义View-开关
 *
 * @author Administrator
 * @date 2021-11-05
 */
public class SwitchButton extends LinearLayout {

    /**
     * 装载的ImageView
     */
    private ImageView rootImageView;
    /**
     * 默认状态
     */
    private boolean isOn = false;
    /**
     * 开关切换状态监听
     */
    private SwitchChangedListner listener;

    public SwitchButton(Context context) {
        super(context);
        initWidget(context);
    }

    public SwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidget(context);
    }

    private void initWidget(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_switch_btn, this);
        rootImageView = (ImageView) view.findViewById(R.id.iv_switch);
        addListeners();
    }

    private void addListeners() {
        rootImageView.setOnClickListener(v -> {
            isOn = !isOn;
            rootImageView.setImageResource(isOn ? R.mipmap.icon_switch_on : R.mipmap.icon_switch_off);
            if (null != listener) {
                listener.switchChanged(getId(), isOn);
            }
        });
    }

    public void setOnSwitchListener(SwitchChangedListner switchListener) {
        this.listener = switchListener;
    }

    /**
     * 开关状态监听器
     *
     * @author llew
     */
    public interface SwitchChangedListner {
        void switchChanged(Integer viewId, boolean isOn);
    }
}
