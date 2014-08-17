package com.gooddoctor.engine.medicine;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.gooddoctor.data.gson.MedicineDetail;
import com.gooddoctor.data.gson.MedicineEvaluation;

import java.lang.ref.WeakReference;
import java.util.HashMap;

// This class is NOT thread-safe
public class MedicineInfoFetcher {
    private static int mRequestId = 0;
    private static final String MEDICINE_REQUEST_TAG = "MEDICINE_REQUEST";
    private static MedicineInfoFetcher mInstance;

    private RequestQueue mRequestQueue;
    private HashMap<Integer, WeakReference<MedicineFetcherListener<MedicineDetail>>> mDetailListener;
    private HashMap<Integer, WeakReference<MedicineFetcherListener<MedicineEvaluation>>> mEvaluationListener;

    public MedicineInfoFetcher getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MedicineInfoFetcher(context);
        }
        return mInstance;
    }

    private MedicineInfoFetcher(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mDetailListener = new HashMap<Integer, WeakReference<MedicineFetcherListener<MedicineDetail>>>();
        mEvaluationListener = new HashMap<Integer, WeakReference<MedicineFetcherListener<MedicineEvaluation>>>();
    }

    public void getMedicineDetailById(String medicineId, MedicineFetcherListener<MedicineDetail> listener) {

    }

    public void getMedicineEvaluationById(String medicineId, MedicineFetcherListener<MedicineEvaluation> listener) {

    }
}
