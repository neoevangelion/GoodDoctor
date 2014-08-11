package com.gooddoctor.ui.medicine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gooddoctor.R;
import com.gooddoctor.engine.search.SearchMedicineResult;


public class MedicineListFragment extends Fragment {
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_list, container, false);
        mListView = (ListView) view.findViewById(R.id.medicine_list_view);
        return view;
    }

    public void updateSearchResult(SearchMedicineResult result) {

    }
}
