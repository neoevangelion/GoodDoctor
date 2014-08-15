package com.gooddoctor.data.dao;

import android.content.Context;

import com.gooddoctor.engine.DataBaseConst;

/**
 * Created by eWalk_iOS on 14-8-12.
 */
public class DataBaseUtil {
    public static DaoSession newDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,
                DataBaseConst.DATABASE_FILENAME, null);
        DaoMaster daoMaster = new DaoMaster(helper.getReadableDatabase());
        return daoMaster.newSession();
    }
}
