package com.gooddoctor.engine.search;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gooddoctor.data.gson.MedicineOnlineList;
import com.gooddoctor.engine.constant.NetworkConst;

import org.json.JSONObject;


public class SearchEngine {
    private RequestQueue mRequestQueue;

    public SearchEngine(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void searchDisease(String keyWord, int pageSize, int page, final SearchResultListener listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.SEARCH_MEDICINE_BY_KEYWORD_QUERY;
        url = String.format(url, keyWord, pageSize, page);

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                MedicineOnlineList list = MedicineOnlineList.fromJson(jsonObject);

                if (listener != null) {
                    SearchMedicineResult result = new SearchMedicineResult();
                    if (list != null) {
                        result.setIsSucceed(true);
                        result.setMedicines(list);
                    } else {
                        result.setIsSucceed(false);
                    }
                    listener.handleSearchResult(result);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (listener != null) {
                    SearchMedicineResult result = new SearchMedicineResult();
                    result.setIsSucceed(false);
                    listener.handleSearchResult(result);
                }
            }
        });

        mRequestQueue.add(request);
        mRequestQueue.start();
    }
}
