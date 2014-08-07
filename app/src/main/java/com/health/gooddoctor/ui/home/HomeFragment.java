package com.health.gooddoctor.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.health.gooddoctor.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if (view != null) {
            view.findViewById(R.id.home_find_medicine).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_common_medicine).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_family_medicine_box).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_user_account).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_setting).setOnClickListener(mItemClickListener);

            view.findViewById(R.id.home_nearby_shop).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_all_products).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_medicine_notification).setOnClickListener(mItemClickListener);
            view.findViewById(R.id.home_consultant).setOnClickListener(mItemClickListener);
        }
        return view;
    }

    private View.OnClickListener mItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.home_find_medicine:
                    break;
                default:
                    break;
            }
        }
    };
}
