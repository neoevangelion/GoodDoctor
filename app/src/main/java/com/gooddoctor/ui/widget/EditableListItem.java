package com.gooddoctor.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gooddoctor.R;

/**
 * Created by Administrator on 2014/8/9.
 */
public class EditableListItem extends FrameLayout {
    private ViewGroup mContentViewGroup;
    private View mDeleteButton;
    private View mEditButton;

    public EditableListItem(Context context) {
        super(context);
        initView();
    }

    public EditableListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public EditableListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setContentView(int resourceId) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(resourceId, mContentViewGroup);
    }

    public void setOnDeleteClickListener(OnClickListener listener) {
        mDeleteButton.setOnClickListener(listener);
    }

    public void setOnEditClickListener(OnClickListener listener) {
        mEditButton.setOnClickListener(listener);
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.list_item_editable, this);

        mContentViewGroup = (ViewGroup)findViewById(R.id.editable_list_item_layout_center);
        mDeleteButton = findViewById(R.id.editable_list_item_delete_button);
        mEditButton = findViewById(R.id.editable_list_item_edit_button);
    }
}
