package com.xywy.drug.engine.account;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2014/8/16.
 */
public class Session {
    private String mSessionId;
    private RequestQueue mRequestQueue;

    public static void establishSession(Context context, Token token) {

    }

    public static Session restoreSession(Context context, String sessionId) {
        Session session = new Session(context);
        session.mSessionId = sessionId;
        return session;
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
