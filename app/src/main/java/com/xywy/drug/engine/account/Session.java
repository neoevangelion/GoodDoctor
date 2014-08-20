package com.xywy.drug.engine.account;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2014/8/16.
 */
public class Session {
    private String mUserId;
    private RequestQueue mRequestQueue;
    private SessionIdCache mSessionIdCache;
    private static Session mCurrentSession;

    public static void establishSession(Context context, Token token) {

    }

    public static Session defaultSession(Context context) {
        if (mCurrentSession == null) {
            Session session = new Session(context);
            if (session.mUserId != null && session.mUserId.length() > 0) {
                mCurrentSession = session;
            }
        }
        return mCurrentSession;
    }

    private Session(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mSessionIdCache = new PreferenceSessionIdCache(context);
        mUserId = mSessionIdCache.restore();
    }

    public void abolish() {
        mCurrentSession.mSessionIdCache.save("");
        mCurrentSession = null;
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

    public String getUserId() {
        return mUserId;
    }
}
