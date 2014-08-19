package com.xywy.drug.engine.medicine;

import android.content.Context;
import android.util.SparseArray;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xywy.drug.data.gson.MedicineDetail;
import com.xywy.drug.data.gson.MedicineEvaluation;
import com.xywy.drug.engine.NetworkConst;
import com.xywy.drug.engine.ProtocolConst;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

// This class is NOT thread-safe
public class MedicineInfoFetcher {
    private static int mRequestId = 0;
    private static final String MEDICINE_REQUEST_TAG = "MEDICINE_REQUEST";
    private static MedicineInfoFetcher mInstance;

    private RequestQueue mRequestQueue;
    private SparseArray<WeakReference<MedicineFetcherListener<MedicineDetail>>> mDetailListener;
    private SparseArray<WeakReference<MedicineFetcherListener<MedicineEvaluation>>> mEvaluationListener;

    public MedicineInfoFetcher getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MedicineInfoFetcher(context);
        }
        return mInstance;
    }

    private MedicineInfoFetcher(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mDetailListener = new SparseArray<WeakReference<MedicineFetcherListener<MedicineDetail>>>();
        mEvaluationListener = new SparseArray<WeakReference<MedicineFetcherListener<MedicineEvaluation>>>();
    }

    public void getMedicineDetailById(String medicineId, MedicineFetcherListener<MedicineDetail> listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.GET_MEDICINE_DETAIL_BY_ID;
        url = String.format(url, medicineId);

        final int id = addListener(listener, mDetailListener);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Gson gson = new Gson();
                MedicineDetail detail = gson.fromJson(string, MedicineDetail.class);
                String result = detail.getResult();
                if (result.equals(ProtocolConst.WRONG_RESULT)) {
                    notifyListener(id, false, detail, mDetailListener);
                } else {
                    notifyListener(id, true, detail, mDetailListener);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                notifyListener(id, false, null, mDetailListener);
            }
        });

        request.setTag(MEDICINE_REQUEST_TAG);
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

    public void getMedicineEvaluationById(String medicineId, int num, MedicineFetcherListener<MedicineEvaluation> listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.GET_MEDICINE_EVALUATION_BY_ID;
        url = String.format(url, medicineId, num);

        final int id = addListener(listener, mEvaluationListener);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Gson gson = new Gson();
                MedicineEvaluation evaluation = gson.fromJson(string, MedicineEvaluation.class);
                String result = evaluation.getResult();
                if (result.equals(ProtocolConst.WRONG_RESULT)) {
                    notifyListener(id, false, evaluation, mEvaluationListener);
                } else {
                    notifyListener(id, true, evaluation, mEvaluationListener);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                notifyListener(id, false, null, mEvaluationListener);
            }
        });

        request.setTag(MEDICINE_REQUEST_TAG);
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

    private <T> int addListener(MedicineFetcherListener<T> listener, SparseArray<WeakReference<MedicineFetcherListener<T>>> list) {
        if (mRequestId == Integer.MAX_VALUE) {
            mRequestId = 0;
        } else {
            mRequestId++;
        }
        WeakReference<MedicineFetcherListener<T>> weakListener = new WeakReference<MedicineFetcherListener<T>>(listener);
        list.put(mRequestId, weakListener);
        return mRequestId;
    }

    private <T> void notifyListener(int id, boolean result, T data, SparseArray<WeakReference<MedicineFetcherListener<T>>> list) {
        WeakReference<MedicineFetcherListener<T>> weakListener = list.get(id);
        if (weakListener != null) {
            MedicineFetcherListener<T> listener = weakListener.get();
            if (listener != null) {
                listener.handleMedicineFetchResult(result, data);
            }
        }
    }
}
