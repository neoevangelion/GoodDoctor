package com.gooddoctor.ui.medicine;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooddoctor.R;
import com.gooddoctor.engine.search.SearchMedicineResult;


public class MedicineListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medicine_list, container, false);
    }

    public void updateSearchResult(SearchMedicineResult result) {

    }
}
