package com.gooddoctor.engine;

import com.android.volley.RequestQueue;

/**
 * Created by eWalk_iOS on 14-8-15.
 */
public class MedicineEngine {
    private RequestQueue mRequestQueue;
    private static final String SEARCH_REQUEST_TAG = "MEDICINE_REQUEST";

    private static MedicineEngine mInstance = new MedicineEngine();

    public static MedicineEngine defaultEngine() {
        return mInstance;
    }

    public void getMedicineByDiseaseId(String diseaseId) {

    }

    public void getMedicineDetailById(String medicineId) {

    }

    
}
