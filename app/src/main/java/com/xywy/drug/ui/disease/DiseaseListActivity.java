package com.xywy.drug.ui.disease;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xywy.drug.R;
import com.xywy.drug.data.gson.DiseaseResultData;
import com.xywy.drug.engine.NetworkConst;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DiseaseListActivity extends Activity implements ExpandableListView.OnChildClickListener{

    @InjectView(R.id.disease_list_list_view)
    ExpandableListView mListView;

    private DiseaseListAdapter mAdapter;
    private RequestQueue mRequestQueue;
    private static final String DISEASE_LIST_FETCH_REQUEST_TAG = "DISEASE_LIST_FETCH_REQUEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);

        ButterKnife.inject(this);

        mAdapter = new DiseaseListAdapter(this);
        mListView.setAdapter(mAdapter);

        mListView.setOnChildClickListener(this);

        updateData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRequestQueue.stop();
        mRequestQueue.cancelAll(DISEASE_LIST_FETCH_REQUEST_TAG);
    }

    private void updateData() {
        String url = NetworkConst.HOST_NAME + NetworkConst.GET_DISEASE_LIST_QUERY;

        mRequestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                DiseaseResultData data = null;
                try {
                    data = gson.fromJson(s, DiseaseResultData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mAdapter.setData(data);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        });

        request.setTag(DISEASE_LIST_FETCH_REQUEST_TAG);
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        return true;
    }
}
