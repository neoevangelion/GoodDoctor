package com.gooddoctor.engine.search;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gooddoctor.engine.constant.NetworkConst;

import org.json.JSONObject;


public class SearchEngine {
    private RequestQueue mRequestQueue;
    private static final String SEARCH_REQUEST_TAG = "SEARCH_REQUEST";

    public SearchEngine(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void searchMedicineByKeyword(String keyWord, int pageSize, int page, final SearchResultListener listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.SEARCH_MEDICINE_BY_KEYWORD_QUERY;
        url = String.format(url, keyWord, pageSize, page);

        searchMedicineByUrl(url, listener);
    }

    public void searchMedicineByDiseaseId(String diseaseId, int pageSize, int page, final SearchResultListener listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.SEARCH_MEDICINE_BY_DISEASE_QUERY;
        url = String.format(url, diseaseId, pageSize, page);

        searchMedicineByUrl(url, listener);
    }

    public void cancelAll() {
        mRequestQueue.stop();
        mRequestQueue.cancelAll(SEARCH_REQUEST_TAG);
    }

    private void searchMedicineByUrl(String url, final SearchResultListener listener) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                if (listener != null) {
                    SearchMedicineResult result = SearchMedicineResult.createResultFromJson(string);
                    listener.handleSearchResult(result);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (listener != null) {
                    SearchMedicineResult result = new SearchMedicineResult();
                    result.setSucceed(false);
                    listener.handleSearchResult(result);
                }
            }
        });

        request.setTag(SEARCH_REQUEST_TAG);
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

}
