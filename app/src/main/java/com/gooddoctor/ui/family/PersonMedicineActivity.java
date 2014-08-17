package com.gooddoctor.ui.family;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


import com.gooddoctor.R;
import com.tuyuanlin.framework.widget.TitleBar;


public class PersonMedicineActivity extends Activity {
    private TitleBar mTitleBar;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_medicine);

        mTitleBar = (TitleBar)findViewById(R.id.person_title_bar);
        mListView = (ListView)findViewById(R.id.person_list_view);
    }
}
