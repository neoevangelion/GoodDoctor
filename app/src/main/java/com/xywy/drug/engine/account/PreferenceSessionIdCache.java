package com.xywy.drug.engine.account;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by eWalk_iOS on 14-8-20.
 */
public class PreferenceSessionIdCache implements SessionIdCache {
    private static final String SHARE_PREFERENCE_NAME = "com_xywy_drug";
    private static final String SESSION_ID_KEY = "session_id";
    private SharedPreferences mSharedPreferences;

    public PreferenceSessionIdCache(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void save(String sessionId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SESSION_ID_KEY, sessionId);
        editor.commit();
    }

    @Override
    public String restore() {
        return mSharedPreferences.getString(SESSION_ID_KEY, "");
    }
}
