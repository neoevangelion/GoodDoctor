package com.xywy.drug.ui.medicinebox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


import com.xywy.drug.R;
import com.xywy.drug.data.dao.DBMedicineBox;
import com.xywy.drug.engine.DataBaseConst;
import com.xywy.drug.engine.account.Session;
import com.xywy.drug.engine.medicine.MedicineBoxEngine;
import com.xywy.drug.engine.medicine.MedicineBoxSyncListener;
import com.xywy.drug.engine.medicine.MedicineBoxSyncer;
import com.zlianjie.framework.widget.TitleBar;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MedicineBoxActivity extends Activity implements MedicineBoxSyncListener {
    @InjectView(R.id.person_title_bar) TitleBar mTitleBar;
    @InjectView(R.id.person_list_view) ListView mListView;

    private MedicineBoxSyncer mSyncer;
    private MedicineBoxEngine mEngine;
    private MedicineBoxListAdapter mAdapter;
    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_medicine);
        ButterKnife.inject(this);

        mEngine = new MedicineBoxEngine(this);
        mSyncer = new MedicineBoxSyncer(this, mEngine);

        mAdapter = new MedicineBoxListAdapter(this);
        mListView.setAdapter(mAdapter);

        refreshList();
    }

    private void refreshList() {
        Session session = Session.defaultSession(this);
        if (session != null) {
            mUserId = session.getUserId();
            mSyncer.startSync(this);
        } else {
            mUserId = DataBaseConst.MEDICINE_BOX_ANONYMOUS_OWNER;
            updateData();
        }
    }

    private void updateData() {
        List<DBMedicineBox> list = mEngine.getLocalMedicineBoxByUserId(mUserId);
        mAdapter.setData(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void handleMedicineBoxSyncResult(boolean result) {
        if (result) {
            updateData();
        }
    }
}
