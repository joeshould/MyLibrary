package com.zxh.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Joeshould on 2018/4/20.
 */

public class VerticalArticleView extends LinearLayout {


    private View rootView;
    private ImageView ivArticleImage;
    private TextView tvArticleTitle;
    private TextView tvArticleDesc;
    private ImageView tvArticleArrow;
    private Context context;

    public VerticalArticleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        rootView = LayoutInflater.from(context).inflate(R.layout.vertical_article_view, this, true);
        ivArticleImage = (ImageView) findViewById(R.id.iv_article_image);
        tvArticleTitle = (TextView) findViewById(R.id.tv_article_title);
        tvArticleDesc = (TextView) findViewById(R.id.tv_article_desc);
        tvArticleArrow = (ImageView) findViewById(R.id.tv_article_arrow);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.VerticalArticleView_tlb);
        if (attributes != null) {
            initAttributes(attributes);
            attributes.recycle();
        }
    }

    private void initAttributes(TypedArray attributes) {
        //处理titleBar背景色
        int titleBarBackGroundColor = attributes.getColor(R.styleable.VerticalArticleView_tlb_background_color, Color.GREEN);
        setBackgroundColor(titleBarBackGroundColor);
        int titleBarBackGroundRSId = attributes.getResourceId(R.styleable.VerticalArticleView_tlb_background_drawable, R.color.colorPrimary);
        setBackgroundResource(titleBarBackGroundRSId);
        //先处理左边图片
        boolean leftImageVisible = attributes.getBoolean(R.styleable.VerticalArticleView_tlb_left_image_drawable_visible, true);
        if (leftImageVisible) {
            ivArticleImage.setVisibility(View.VISIBLE);
            //设置左边图片icon
            int leftImageDrawable = attributes.getResourceId(R.styleable.VerticalArticleView_tlb_left_image_drawable, R.drawable.ic_keyboard_arrow_left_white_24dp);
            if (leftImageDrawable != -1) {
                ivArticleImage.setImageResource(leftImageDrawable);
            }
        } else {
            ivArticleImage.setVisibility(View.GONE);
        }

        String leftText = attributes.getString(R.styleable.VerticalArticleView_tlb_left_text);
        if (!TextUtils.isEmpty(leftText)) {
            tvArticleTitle.setText(leftText);
        }
        //设置左边按钮文字颜色
        int leftTextColor = attributes.getColor(R.styleable.VerticalArticleView_tlb_right_text_color, Color.WHITE);
        tvArticleTitle.setTextColor(leftTextColor);

        boolean rightImageVisible = attributes.getBoolean(R.styleable.VerticalArticleView_tlb_right_image_drawable_visible, true);
        if (leftImageVisible) {
            tvArticleArrow.setVisibility(View.VISIBLE);
            int leftImageDrawable = attributes.getResourceId(R.styleable.VerticalArticleView_tlb_right_image_drawable, R.drawable.ic_keyboard_arrow_left_white_24dp);
            if (leftImageDrawable != -1) {
                tvArticleArrow.setImageResource(leftImageDrawable);
            }
        } else {
            tvArticleArrow.setVisibility(View.GONE);
        }

        String rightText = attributes.getString(R.styleable.VerticalArticleView_tlb_right_text);
        if (!TextUtils.isEmpty(rightText)) {
            tvArticleDesc.setText(rightText);
        }

        int rightTextColor = attributes.getColor(R.styleable.VerticalArticleView_tlb_right_text_color, Color.WHITE);
        tvArticleDesc.setTextColor(rightTextColor);
    }


}
