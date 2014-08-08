package com.gooddoctor.ui.search;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooddoctor.R;
import com.gooddoctor.engine.search.SearchResult;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SearchResultFragment extends Fragment {

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        if (view != null) {
            mViewPager = (ViewPager)view.findViewById(R.id.search_result_view_pager);
            mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return null;
                }

                @Override
                public int getCount() {
                    return 3;
                }
            });
        }
        return view;
    }

    public void setSearchResult(SearchResult result) {

    }
}
