package com.gooddoctor.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.gooddoctor.data.Disease;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DISEASE.
*/
public class DiseaseDao extends AbstractDao<Disease, Long> {

    public static final String TABLENAME = "DISEASE";

    /**
     * Properties of entity Disease.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Pinyin = new Property(2, String.class, "pinyin", false, "PINYIN");
        public final static Property ProductNum = new Property(3, Integer.class, "productNum", false, "PRODUCT_NUM");
    };


    public DiseaseDao(DaoConfig config) {
        super(config);
    }
    
    public DiseaseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DISEASE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NAME' TEXT," + // 1: name
                "'PINYIN' TEXT," + // 2: pinyin
                "'PRODUCT_NUM' INTEGER);"); // 3: productNum
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DISEASE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Disease entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String pinyin = entity.getPinyin();
        if (pinyin != null) {
            stmt.bindString(3, pinyin);
        }
 
        Integer productNum = entity.getProductNum();
        if (productNum != null) {
            stmt.bindLong(4, productNum);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Disease readEntity(Cursor cursor, int offset) {
        Disease entity = new Disease( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // pinyin
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3) // productNum
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Disease entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPinyin(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setProductNum(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Disease entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Disease entity) {
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
