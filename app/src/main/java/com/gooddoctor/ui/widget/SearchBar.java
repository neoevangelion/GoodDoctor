package com.gooddoctor.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.gooddoctor.R;

import java.lang.ref.WeakReference;

public class SearchBar extends FrameLayout {

    private Button mSearchButton;
    private Button mCancelButton;
    private Button mInterceptButton;
    private EditText mEdit;
    private WeakReference<SearchActionHandler> mActionHandler;

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

    public void setSearchButtonVisibility(int visibility) {
        mSearchButton.setVisibility(visibility);
    }

    public void setSearchActionHandler(SearchActionHandler handler) {
        mActionHandler = new WeakReference<SearchActionHandler>(handler);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.widget_search_bar, this);

        mEdit = (EditText)findViewById(R.id.search_bar_edit_text);
        mSearchButton = (Button)findViewById(R.id.search_bar_search_button);
        mCancelButton = (Button)findViewById(R.id.search_bar_cancel_button);

        mSearchButton.setVisibility(GONE);
        mCancelButton.setVisibility(VISIBLE);

        mSearchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActionHandler != null) {
                    SearchActionHandler handler = mActionHandler.get();
                    if (handler != null) {
                        handler.onSearch(mEdit.getText().toString());
                    }
                }
            }
        });

        mCancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActionHandler != null) {
                    SearchActionHandler handler = mActionHandler.get();
                    if (handler != null) {
                        handler.onCancel();
                    }
                }
            }
        });

        mEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mCancelButton.setVisibility(GONE);
                    mSearchButton.setVisibility(VISIBLE);
                } else {
                    mSearchButton.setVisibility(GONE);
                    mCancelButton.setVisibility(VISIBLE);
                }
            }
        });

        mInterceptButton = new Button(context);
        mInterceptButton.setBackgroundColor(Color.TRANSPARENT);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(mInterceptButton, layoutParams);
        mInterceptButton.setVisibility(GONE);
    }



}
