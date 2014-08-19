package com.zlianjie.framework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2014/8/9.
 */
public class SideMenuView extends FrameLayout {
    private boolean mIsCollapsed = false;
    private View mDetailView;
    private CollapsibleMenu mMenuView;

    public SideMenuView(Context context) {
        super(context);
    }

    public SideMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SideMenuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setMenuView(View view) {
        if (view == null || !(view instanceof CollapsibleMenu)) {
            return;
        }

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
        mMenuView = (CollapsibleMenu)view;
    }

    public void setDetailView(View view) {
        if (view == null) {
            return;
        }

        LayoutParams layoutParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
        mDetailView = view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mDetailView != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int detailViewMeasureSpec = MeasureSpec.makeMeasureSpec((int) (width * 0.65), MeasureSpec.EXACTLY);
            mDetailView.measure(detailViewMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (mDetailView != null) {
            int childWidth = mDetailView.getMeasuredWidth();
            int childLeft = 0;
            if (!mIsCollapsed) {
                childLeft = getMeasuredWidth();
            } else {
                childLeft = getMeasuredWidth() - childWidth;
            }
            mDetailView.layout(childLeft, 0, childLeft + childWidth, mDetailView.getMeasuredHeight());
        }
    }

    public void expandMenu() {
        if (mMenuView == null || mDetailView == null || !mIsCollapsed) {
            return;
        }

        TranslateAnimation animation = new TranslateAnimation(0, mDetailView.getWidth(), 0, 0);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(mAnimationListener);
        mDetailView.setAnimation(animation);
        animation.start();

        mMenuView.expand();

        mIsCollapsed = false;
    }

    public void collapseMenu() {
        if (mMenuView == null || mDetailView == null || mIsCollapsed) {
            return;
        }

        TranslateAnimation animation = new TranslateAnimation(0, -1 * mDetailView.getWidth(), 0, 0);
        animation.setDuration(500);
        animation.setAnimationListener(mAnimationListener);
        animation.setFillAfter(true);
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
            mDetailView.clearAnimation();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
