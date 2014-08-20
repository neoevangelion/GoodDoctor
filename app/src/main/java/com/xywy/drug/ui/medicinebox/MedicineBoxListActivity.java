package com.xywy.drug.ui.medicinebox;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.xywy.drug.R;
import com.zlianjie.framework.widget.TitleBar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MedicineBoxListActivity extends Activity {

    @InjectView(R.id.family_title_bar) TitleBar mTitleBar;
    @InjectView(R.id.family_list_view) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_medicine);
        ButterKnife.inject(this);
    }



}
