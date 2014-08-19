package com.xywy.drug.ui.medicinebox;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.xywy.drug.R;
import com.zlianjie.framework.widget.TitleBar;

public class MedicineBoxListActivity extends Activity {

    private TitleBar mTitleBar;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_medicine);

        mTitleBar = (TitleBar)findViewById(R.id.family_title_bar);
        mListView = (ListView)findViewById(R.id.family_list_view);
    }

}
