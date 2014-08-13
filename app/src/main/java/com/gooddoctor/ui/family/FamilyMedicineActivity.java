package com.gooddoctor.ui.family;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.gooddoctor.R;
import com.tuyuanlin.framework.widget.TitleBar;

public class FamilyMedicineActivity extends Activity {

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
