package com.gooddoctor.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2014/8/9.
 */
public class DockMenu extends FrameLayout {
    private boolean mIsCollapsed = false;
    private View mDetailView;
    private CollapsibleMenu mMenuView;

    public DockMenu(Context context) {
        super(context);
    }

    public DockMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DockMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setMenuView(CollapsibleMenu view) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
        mMenuView = view;
    }

    public void setDetailView(View view) {
        LayoutParams layoutParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
        mDetailView = view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int detailViewMeasureSpec = MeasureSpec.makeMeasureSpec((int)(width * 0.65), MeasureSpec.EXACTLY);
        mDetailView.measure(detailViewMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int childWidth = mDetailView.getMeasuredWidth();
        int childLeft = 0;
        if (!mIsCollapsed) {
            childLeft = r;
        } else {
            childLeft = r - childWidth;
        }
        mDetailView.layout(childLeft, t, childLeft + childWidth, b);
    }

    public void ExpandMenu() {
        if (!mIsCollapsed) {
            return;
        }

        TranslateAnimation animation = new TranslateAnimation(0, 0, mDetailView.getWidth(), 0);
        animation.setDuration(500);
        animation.setAnimationListener(mAnimationListener);
        mDetailView.setAnimation(animation);
        animation.start();

        mMenuView.expand();

        mIsCollapsed = false;
    }

    public void CollapseMenu() {
        if (mIsCollapsed) {
            return;
        }

        TranslateAnimation animation = new TranslateAnimation(0, 0, -1 * mDetailView.getWidth(), 0);
        animation.setDuration(500);
        animation.setAnimationListener(mAnimationListener);
        mDetailView.setAnimation(animation);
        animation.start();

        mMenuView.collapse();

        mIsCollapsed = true;
    }

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            requestLayout();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
