package com.gooddoctor.engine.search;

import com.gooddoctor.data.MedicineList;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class SearchMedicineResult extends SearchResult {
    private MedicineList mMedicines;

    public MedicineList getMedicines() {
        return mMedicines;
    }

    public void setMedicines(MedicineList mMedicines) {
        this.mMedicines = mMedicines;
    }
}
