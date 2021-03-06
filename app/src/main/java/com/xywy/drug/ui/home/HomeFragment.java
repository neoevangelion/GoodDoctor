package com.xywy.drug.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xywy.drug.R;
import com.xywy.drug.ui.account.LoginActivity;
import com.xywy.drug.ui.disease.DiseaseListActivity;
import com.xywy.drug.ui.medicine.MedicineCategoryListActivity;
import com.xywy.drug.ui.medicine.MedicineMapActivity;
import com.xywy.drug.ui.notification.EditNotificationActivity;

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

    @OnClick(R.id.home_medicine_notification) void gotoNotification() {
        Intent intent = new Intent(getActivity(), EditNotificationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.home_nearby_shop) void gotoMedicineMap() {
        Intent intent = new Intent(getActivity(), MedicineMapActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.home_user_account) void gotoAccount() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
