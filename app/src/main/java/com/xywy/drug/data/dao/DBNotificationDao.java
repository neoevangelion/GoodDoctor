package com.xywy.drug.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.xywy.drug.data.dao.DBNotification;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DBNOTIFICATION.
*/
public class DBNotificationDao extends AbstractDao<DBNotification, Long> {

    public static final String TABLENAME = "DBNOTIFICATION";

    /**
     * Properties of entity DBNotification.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MedicineId = new Property(1, String.class, "medicineId", false, "MEDICINE_ID");
        public final static Property MedicineName = new Property(2, String.class, "medicineName", false, "MEDICINE_NAME");
        public final static Property Duration = new Property(3, Integer.class, "duration", false, "DURATION");
        public final static Property RepeatPerDay = new Property(4, Integer.class, "repeatPerDay", false, "REPEAT_PER_DAY");
        public final static Property TimePoints = new Property(5, String.class, "timePoints", false, "TIME_POINTS");
        public final static Property SyncId = new Property(6, String.class, "syncId", false, "SYNC_ID");
        public final static Property Owner = new Property(7, String.class, "owner", false, "OWNER");
        public final static Property NotificationEnabled = new Property(8, Boolean.class, "notificationEnabled", false, "NOTIFICATION_ENABLED");
    };


    public DBNotificationDao(DaoConfig config) {
        super(config);
    }
    
    public DBNotificationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DBNOTIFICATION' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'MEDICINE_ID' TEXT," + // 1: medicineId
                "'MEDICINE_NAME' TEXT," + // 2: medicineName
                "'DURATION' INTEGER," + // 3: duration
                "'REPEAT_PER_DAY' INTEGER," + // 4: repeatPerDay
                "'TIME_POINTS' TEXT," + // 5: timePoints
                "'SYNC_ID' TEXT," + // 6: syncId
                "'OWNER' TEXT," + // 7: owner
                "'NOTIFICATION_ENABLED' INTEGER);"); // 8: notificationEnabled
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DBNOTIFICATION'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DBNotification entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String medicineId = entity.getMedicineId();
        if (medicineId != null) {
            stmt.bindString(2, medicineId);
        }
 
        String medicineName = entity.getMedicineName();
        if (medicineName != null) {
            stmt.bindString(3, medicineName);
        }
 
        Integer duration = entity.getDuration();
        if (duration != null) {
            stmt.bindLong(4, duration);
        }
 
        Integer repeatPerDay = entity.getRepeatPerDay();
        if (repeatPerDay != null) {
            stmt.bindLong(5, repeatPerDay);
        }
 
        String timePoints = entity.getTimePoints();
        if (timePoints != null) {
            stmt.bindString(6, timePoints);
        }
 
        String syncId = entity.getSyncId();
        if (syncId != null) {
            stmt.bindString(7, syncId);
        }
 
        String owner = entity.getOwner();
        if (owner != null) {
            stmt.bindString(8, owner);
        }
 
        Boolean notificationEnabled = entity.getNotificationEnabled();
        if (notificationEnabled != null) {
            stmt.bindLong(9, notificationEnabled ? 1l: 0l);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DBNotification readEntity(Cursor cursor, int offset) {
        DBNotification entity = new DBNotification( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // medicineId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // medicineName
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // duration
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // repeatPerDay
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // timePoints
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // syncId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // owner
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0 // notificationEnabled
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DBNotification entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMedicineId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMedicineName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDuration(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setRepeatPerDay(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setTimePoints(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSyncId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOwner(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setNotificationEnabled(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DBNotification entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DBNotification entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
