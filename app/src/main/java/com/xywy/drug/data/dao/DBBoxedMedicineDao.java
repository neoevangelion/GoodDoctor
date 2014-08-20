package com.xywy.drug.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.xywy.drug.data.dao.DBBoxedMedicine;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DBBOXED_MEDICINE.
*/
public class DBBoxedMedicineDao extends AbstractDao<DBBoxedMedicine, Long> {

    public static final String TABLENAME = "DBBOXED_MEDICINE";

    /**
     * Properties of entity DBBoxedMedicine.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MedicineId = new Property(1, String.class, "medicineId", false, "MEDICINE_ID");
        public final static Property MedicineName = new Property(2, String.class, "medicineName", false, "MEDICINE_NAME");
        public final static Property CompanyName = new Property(3, String.class, "companyName", false, "COMPANY_NAME");
    };


    public DBBoxedMedicineDao(DaoConfig config) {
        super(config);
    }
    
    public DBBoxedMedicineDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DBBOXED_MEDICINE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'MEDICINE_ID' TEXT," + // 1: medicineId
                "'MEDICINE_NAME' TEXT," + // 2: medicineName
                "'COMPANY_NAME' TEXT);"); // 3: companyName
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DBBOXED_MEDICINE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DBBoxedMedicine entity) {
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
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(4, companyName);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DBBoxedMedicine readEntity(Cursor cursor, int offset) {
        DBBoxedMedicine entity = new DBBoxedMedicine( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // medicineId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // medicineName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // companyName
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DBBoxedMedicine entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMedicineId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMedicineName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCompanyName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DBBoxedMedicine entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DBBoxedMedicine entity) {
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
