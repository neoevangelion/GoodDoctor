package com.gooddoctor.engine.search;

import com.gooddoctor.data.gson.MedicineResultData;
import com.gooddoctor.engine.ProtocolConst;
import com.google.gson.Gson;


/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class SearchMedicineResult extends SearchResult {
    private MedicineResultData mMedicines;

    public static SearchMedicineResult createResultFromJson(String json) {
        SearchMedicineResult result = new SearchMedicineResult();
        Gson gson = new Gson();
        result.mMedicines = gson.fromJson(json, MedicineResultData.class);

        if (result.mMedicines.getResult() != null && result.mMedicines.getResult().equals(ProtocolConst.WRONG_RESULT)) {
            result.setSucceed(false);
        } else {
            result.setSucceed(true);
        }
        return result;
    }

    public MedicineResultData getMedicines() {
        return mMedicines;
    }
}
