package com.xywy.drug.ui.search;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xywy.drug.R;
import com.xywy.drug.engine.search.SearchMedicineResult;
import com.xywy.drug.engine.search.SearchResult;
import com.xywy.drug.ui.medicine.MedicineListFragment;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SearchResultFragment extends Fragment {

    private ViewPager mViewPager;
    private MedicineListFragment mMedicineFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        if (view != null) {
            mMedicineFragment = new MedicineListFragment();

            mViewPager = (ViewPager)view.findViewById(R.id.search_result_view_pager);
            mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    switch (position) {
                        case 0:
                            return mMedicineFragment;
                        case 1:
                            return mMedicineFragment;
                        case 2:
                            return mMedicineFragment;
                        default:
                            break;
                    }
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

    public void updateSearchResult(SearchResult result) {
        if (result != null && result instanceof SearchMedicineResult) {
            mMedicineFragment.updateSearchResult((SearchMedicineResult)result);
        }
    }
}
