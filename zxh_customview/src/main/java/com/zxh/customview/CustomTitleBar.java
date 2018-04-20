package com.zxh.customview;

import android.content.Context;
import android.content.res.TypedArray;


import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Joeshould on 2018/4/20.
 */

public class CustomTitleBar extends RelativeLayout {
    private Button titleBarLeftBtn;
    private Button titleBarRightBtn;
    private TextView titleBarTitle;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title_bar, this, true);
        titleBarLeftBtn = (Button) findViewById(R.id.title_bar_left);
        titleBarRightBtn = (Button) findViewById(R.id.title_bar_right);
        titleBarTitle = (TextView) findViewById(R.id.title_bar_title);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar_tlb);
        if (attributes != null) {
            //处理titleBar背景色
            int titleBarBackGroundColor = attributes.getColor(R.styleable.CustomTitleBar_tlb_title_background_color, Color.GREEN);
            setBackgroundColor(titleBarBackGroundColor);
            int titleBarBackGroundRSId = attributes.getResourceId(R.styleable.CustomTitleBar_tlb_title_background_drawable, R.color.colorPrimary);
            setBackgroundResource(titleBarBackGroundRSId);
            //先处理左边按钮
            //获取是否要显示左边按钮
            boolean leftButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_tlb_left_button_visible, true);
            if (leftButtonVisible) {
                titleBarLeftBtn.setVisibility(View.VISIBLE);
            } else {
                titleBarLeftBtn.setVisibility(View.INVISIBLE);
            }
            //设置左边按钮的文字
            String leftButtonText = attributes.getString(R.styleable.CustomTitleBar_tlb_left_button_text);
            if (!TextUtils.isEmpty(leftButtonText)) {
                titleBarLeftBtn.setText(leftButtonText);
                //设置左边按钮文字颜色
                int leftButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_tlb_left_button_text_color, Color.WHITE);
                titleBarLeftBtn.setTextColor(leftButtonTextColor);
            }
            boolean leftButtonDrawableVisible = attributes.getBoolean(R.styleable.CustomTitleBar_tlb_left_button_drawable_visible, true);
            if (leftButtonDrawableVisible) {
                //设置左边图片icon
                int leftButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_tlb_left_button_drawable, R.drawable.ic_keyboard_arrow_left_white_24dp);
                if (leftButtonDrawable != -1) {
                    titleBarLeftBtn.setCompoundDrawablesWithIntrinsicBounds(leftButtonDrawable, 0, 0, 0);  //设置到哪个控件的位置（）
                }
            }

            //处理标题
            //先获取标题是否要显示图片icon
            int titleTextDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_tlb_title_text_drawable, -1);
            if (titleTextDrawable != -1) {
                titleBarTitle.setBackgroundResource(titleTextDrawable);
            } else {
                //如果不是图片标题 则获取文字标题
                String titleText = attributes.getString(R.styleable.CustomTitleBar_tlb_title_text);
                if (!TextUtils.isEmpty(titleText)) {
                    titleBarTitle.setText(titleText);
                }
                //获取标题显示颜色
                int titleTextColor = attributes.getColor(R.styleable.CustomTitleBar_tlb_title_text_color, Color.WHITE);
                titleBarTitle.setTextColor(titleTextColor);
            }

            //先处理右边按钮
            //获取是否要显示右边按钮
            boolean rightButtonVisible = attributes.getBoolean(R.styleable.CustomTitleBar_tlb_right_button_visible, true);
            if (rightButtonVisible) {
                titleBarRightBtn.setVisibility(View.VISIBLE);
            } else {
                titleBarRightBtn.setVisibility(View.INVISIBLE);
            }
            //设置右边按钮的文字
            String rightButtonText = attributes.getString(R.styleable.CustomTitleBar_tlb_right_button_text);
            if (!TextUtils.isEmpty(rightButtonText)) {
                titleBarRightBtn.setText(rightButtonText);
                //设置右边按钮文字颜色
                int rightButtonTextColor = attributes.getColor(R.styleable.CustomTitleBar_tlb_right_button_text_color, Color.WHITE);
                titleBarRightBtn.setTextColor(rightButtonTextColor);
            }
            boolean rightButtonDrawableVisible = attributes.getBoolean(R.styleable.CustomTitleBar_tlb_right_button_drawable_visible, true);
            if (rightButtonDrawableVisible) {
                //设置右边图片icon
                int rightButtonDrawable = attributes.getResourceId(R.styleable.CustomTitleBar_tlb_right_button_drawable, -1);
                if (rightButtonDrawable != -1) {
                    titleBarRightBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, rightButtonDrawable, 0);  //设置到哪个控件的位置（）
                }
            }
            attributes.recycle();
        }
    }

    public void setTitleClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            titleBarLeftBtn.setOnClickListener(onClickListener);
            titleBarRightBtn.setOnClickListener(onClickListener);
        }
    }

    public Button getTitleBarLeftBtn() {
        return titleBarLeftBtn;
    }

    public Button getTitleBarRightBtn() {
        return titleBarRightBtn;
    }

    public TextView getTitleBarTitle() {
        return titleBarTitle;
    }

}
