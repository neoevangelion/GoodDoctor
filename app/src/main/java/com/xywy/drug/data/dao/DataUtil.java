package com.xywy.drug.data.dao;

import android.content.Context;

import com.xywy.drug.engine.DataBaseConst;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by eWalk_iOS on 14-8-12.
 */
public class DataUtil {
    public static DaoSession newDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,
                DataBaseConst.DATABASE_FILENAME, null);
        DaoMaster daoMaster = new DaoMaster(helper.getReadableDatabase());
        return daoMaster.newSession();
    }

    public static DBMedicineBoxDao getMedicineBoxDao(Context context) {
        DaoSession session = DataUtil.newDaoSession(context);
        return session.getDBMedicineBoxDao();
    }

    public static DBBoxedMedicineDao getBoxedMedicineDao(Context context) {
        DaoSession session = DataUtil.newDaoSession(context);
        return session.getDBBoxedMedicineDao();
    }

    public static DBNotificationDao getNotificationDao(Context context) {
        DaoSession session = DataUtil.newDaoSession(context);
        return session.getDBNotificationDao();
    }

    public static DBSearchHistoryDao getSearchHistoryDao(Context context) {
        DaoSession session = DataUtil.newDaoSession(context);
        return session.getDBSearchHistoryDao();
    }
}
