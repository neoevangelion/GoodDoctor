package com.gooddoctor.ui.medicine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.gooddoctor.R;
import com.gooddoctor.ui.widget.CollapsibleMenu;

/**
 * Created by Administrator on 2014/8/10.
 */
public class MedicineCategoryMenu extends FrameLayout implements CollapsibleMenu {
    public MedicineCategoryMenu(Context context) {
        super(context);
        initView();
    }

    public MedicineCategoryMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MedicineCategoryMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    @Override
    public void collapse() {

    }

    @Override
    public void expand() {

    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_medicine_category, this);


    }
}
