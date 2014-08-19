package com.gooddoctor.engine.account;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2014/8/16.
 */
public class Session {
    private static Session mCurrent;
    private String mSessionId;
    private RequestQueue mRequestQueue;

    public static Session establishSession(Context context, Token token) {
        return null;
    }

    public static Session currentSession() {
        return mCurrent;
    }

    private Session(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void getQuery() {

    }

    public void getFavourite() {

    }

    public void getEvaluation() {

    }

    public void getEvaluationPageInfo() {

    }

    public void submitEvaluation() {

    }

    public void submitQuery() {

    }
}
