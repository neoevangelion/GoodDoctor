package com.gooddoctor.ui.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CachedFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentList;

    public CachedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<Fragment>();
    }

    public void addFragment(int index, Fragment fragment) {
        mFragmentList.add(index, fragment);
    }

    @Override
    public Fragment getItem(int i) {
        if (i >= 0 && i < mFragmentList.size()) {
            return mFragmentList.get(i);
        }
        
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
