package com.gooddoctor.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gooddoctor.R;

public class TitleBar extends FrameLayout {

    private TextView mTitleTextView;
    private Button mBackButton;
    private String mTitleStr;

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar, defStyle, 0);

        String title = null;
        if (typedArray != null) {
            mTitleStr = typedArray.getString(R.styleable.TitleBar_titleText);
            typedArray.recycle();
        }
        initView(context);
    }

    public void setBackOnClickListener(OnClickListener listener) {
        if (listener != null) {
            mBackButton.setOnClickListener(listener);
        }
    }

    public void setBackButtonVisibility(int visibility) {
        mBackButton.setVisibility(visibility);
    }

    public void setRightView(View view) {
        if (view == null) {
            return;
        }

        ViewGroup container = (ViewGroup)findViewById(R.id.title_bar_layout_center);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(view, layoutParams);
    }

    public void setCenterView(View view) {
        if (view == null) {
            return;
        }

        mTitleTextView.setVisibility(GONE);
        ViewGroup container = (ViewGroup)findViewById(R.id.title_bar_layout_right);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(view, layoutParams);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.widget_title_bar, this);

        mTitleTextView = (TextView)findViewById(R.id.title_bar_text_view);

        mBackButton = (Button)findViewById(R.id.title_bar_back_button);

        if (mTitleStr != null) {
            mTitleTextView.setText(mTitleStr);
        }
    }
}
