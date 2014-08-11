package com.gooddoctor.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooddoctor.R;
import com.gooddoctor.ui.disease.DiseaseListActivity;
import com.gooddoctor.ui.medicine.MedicineCategoryListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if (view != null) {
            ButterKnife.inject(this, view);
        }
        return view;
    }

    @OnClick(R.id.home_find_medicine) void gotoMedicine() {
        Intent intent = new Intent(getActivity(), DiseaseListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.home_all_products) void gotoAllProducts() {
        Intent intent = new Intent(getActivity(), MedicineCategoryListActivity.class);
        startActivity(intent);
    }
}
