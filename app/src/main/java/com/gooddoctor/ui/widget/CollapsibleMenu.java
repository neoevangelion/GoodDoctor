package com.gooddoctor.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2014/8/9.
 */
public abstract class CollapsibleMenu extends View {
    public CollapsibleMenu(Context context) {
        super(context);
    }

    public CollapsibleMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CollapsibleMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void collapse();

    public abstract void expand();
}
