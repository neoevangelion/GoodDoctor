package com.gooddoctor.engine.search;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gooddoctor.engine.NetworkConst;

import java.lang.ref.WeakReference;
import java.util.HashMap;

// This class is NOT thread-safe
public class SearchEngine {

    private static final String SEARCH_REQUEST_TAG = "SEARCH_REQUEST";
    private static int mRequestId = 0;
    private RequestQueue mRequestQueue;
    private static SearchEngine mInstance;
    private HashMap<Integer, WeakReference<SearchResultListener>> mListenerList;

    public static SearchEngine getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SearchEngine(context);
        }
        return mInstance;
    }

    private SearchEngine(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mListenerList = new HashMap<Integer, WeakReference<SearchResultListener>>();
    }

    public void searchMedicineByKeyword(String keyWord, int pageSize, int page, SearchResultListener listener) {
        String url = NetworkConst.HOST_NAME + NetworkConst.SEARCH_MEDICINE_BY_KEYWORD_QUERY;
        url = String.format(url, keyWord, pageSize, page);

        searchMedicineByUrl(url, listener);
    }

    public void searchQueryByKeyword(String keyWord, SearchResultListener listener) {

    }

    public void searchDiseaseByKeyword(String keyWord, SearchResultListener listener) {

    }

    public void searchMedicineByDiseaseId(String diseaseId, int pageSize, int page, SearchResultListener listener) {

    }

    public void cancelAll() {
        mRequestQueue.stop();
        mRequestQueue.cancelAll(SEARCH_REQUEST_TAG);
    }

    private int addListener(SearchResultListener listener) {
        if (mRequestId == Integer.MAX_VALUE) {
            mRequestId = 0;
        } else {
            mRequestId++;
        }
        WeakReference<SearchResultListener> weakListener = new WeakReference<SearchResultListener>(listener);
        mListenerList.put(mRequestId, weakListener);
        return mRequestId;
    }

    private void notifyListener(int id, SearchResult result) {
        WeakReference<SearchResultListener> weakListener = mListenerList.get(id);
        if (weakListener != null && weakListener.get() != null) {
            weakListener.get().handleSearchResult(result);
        }
    }

    private void searchMedicineByUrl(String url, SearchResultListener listener) {
        final int id = addListener(listener);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                SearchMedicineResult result = SearchMedicineResult.createResultFromJson(string);
                notifyListener(id, result);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                SearchMedicineResult result = new SearchMedicineResult();
                result.setSucceed(false);
                notifyListener(id, result);
            }
        });

        request.setTag(SEARCH_REQUEST_TAG);
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

}
