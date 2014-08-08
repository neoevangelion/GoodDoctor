package com.gooddoctor.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.gooddoctor.R;

public class SearchBar extends FrameLayout {

    private Button mSearchButton;
    private Button mInterceptButton;

    public SearchBar(Context context) {
        super(context);
        initView(context);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public void setOnInterceptClickListener(OnClickListener listener) {
        if (listener != null) {
            mInterceptButton.setOnClickListener(listener);
        }
    }

    public void setInterceptMode(boolean interceptMode) {
        mInterceptButton.setVisibility((interceptMode) ? VISIBLE : GONE);
    }

    public void setSearchButtonVisibility(boolean visibility) {
        mSearchButton.setVisibility((visibility) ? VISIBLE : GONE);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.widget_search_bar, this);

        EditText edit = (EditText)findViewById(R.id.search_bar_edit_text);
        mSearchButton = (Button)findViewById(R.id.search_bar_button);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mInterceptButton = new Button(context);
        mInterceptButton.setBackgroundColor(Color.TRANSPARENT);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(mInterceptButton, layoutParams);
        mInterceptButton.setVisibility(GONE);
    }



}
