package com.xywy.drug.engine.search;

import com.xywy.drug.data.gson.MedicineList;
import com.xywy.drug.engine.ProtocolConst;
import com.google.gson.Gson;


/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class SearchMedicineResult extends SearchResult {
    private MedicineList mMedicines;

    public static SearchMedicineResult createResultFromJson(String json) {
        SearchMedicineResult result = new SearchMedicineResult();
        Gson gson = new Gson();
        result.mMedicines = gson.fromJson(json, MedicineList.class);

        if (result.mMedicines.getResult() != null && result.mMedicines.getResult().equals(ProtocolConst.WRONG_RESULT)) {
            result.setSucceed(false);
        } else {
            result.setSucceed(true);
        }
        return result;
    }

    public MedicineList getMedicines() {
        return mMedicines;
    }
}
