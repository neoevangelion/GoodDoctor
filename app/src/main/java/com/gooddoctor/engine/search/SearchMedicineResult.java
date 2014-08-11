package com.gooddoctor.engine.search;

import com.gooddoctor.data.gson.MedicineOnlineList;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class SearchMedicineResult extends SearchResult {
    private MedicineOnlineList mMedicines;

    public MedicineOnlineList getMedicines() {
        return mMedicines;
    }

    public void setMedicines(MedicineOnlineList mMedicines) {
        this.mMedicines = mMedicines;
    }
}
