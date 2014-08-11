package com.gooddoctor.ui.disease;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gooddoctor.R;
import com.gooddoctor.data.gson.DiseaseList;
import com.gooddoctor.engine.constant.NetworkConst;
import com.google.gson.Gson;

import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;

public class DiseaseListActivity extends Activity implements ExpandableListView.OnChildClickListener{

    @InjectView(R.id.disease_list_list_view)
    ExpandableListView mListView;

    private DiseaseListAdapter mAdapter;

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

    private void updateData() {
        String url = NetworkConst.HOST_NAME + NetworkConst.GET_DISEASE_LIST_QUERY;

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                DiseaseList data = gson.fromJson(jsonObject.toString(), DiseaseList.class);
                mAdapter.setData(data);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("DiseaseListActivity", volleyError.getLocalizedMessage());
            }
        });

        requestQueue.add(request);
        requestQueue.start();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        return true;
    }
}
