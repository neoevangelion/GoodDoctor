package com.xywy.drug.engine.medicine;

import android.content.Context;
import android.util.SparseArray;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.xywy.drug.data.dao.DBMedicineBox;
import com.xywy.drug.data.dao.DBMedicineBoxDao;
import com.xywy.drug.data.dao.DataUtil;
import com.xywy.drug.data.gson.MedicineBox;

import java.lang.ref.WeakReference;
import java.util.List;

import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;

public class MedicineBoxEngine {
    private static int mRequestId = 0;
    private static final String MEDICINE_BOX_REQUEST_TAG = "MEDICINE_BOX_REQUEST";
    private Context mContext;
    private RequestQueue mRequestQueue;
    private SparseArray<WeakReference<MedicineBoxEngineListener>> mListenerList;

    public MedicineBoxEngine(Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void getRemoteMedicineBoxByUserId(String userId, MedicineBoxEngineListener listener) {
        final int id = addListener(listener);

    }

    public void addRemoteMedicineBox(List<MedicineBox> entity, MedicineBoxEngineListener listener) {
        final int id = addListener(listener);

    }

    public void deleteRemoteMedicineBox(List<MedicineBox> entity, MedicineBoxEngineListener listener) {
        final int id = addListener(listener);

    }

    public void updateRemoteMedicineBox(List<MedicineBox> entity, MedicineBoxEngineListener listener) {
        final int id = addListener(listener);

    }

    public List<DBMedicineBox> getLocalMedicineBoxByUserId(String userId) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        QueryBuilder<DBMedicineBox> queryBuilder = dao.queryBuilder();
        queryBuilder.where(DBMedicineBoxDao.Properties.Owner.eq(userId));
        return queryBuilder.list();
    }

    public void deleteLocalMedicineBox(DBMedicineBox entity) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.delete(entity);
    }

    public void deleteLocalMedicineBox(List<DBMedicineBox> entitys) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.deleteInTx(entitys);
    }

    public void addLocalMedicineBox(DBMedicineBox entity) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.insert(entity);
    }

    public void addLocalMedicineBox(List<DBMedicineBox> entitys) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.insertInTx(entitys);
    }

    public void updateLocalMedicineBox(DBMedicineBox entity) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.insertOrReplace(entity);
    }

    public void updateLocalMedicineBox(List<DBMedicineBox> entitys) {
        DBMedicineBoxDao dao = DataUtil.getMedicineBoxDao(mContext);
        dao.insertOrReplaceInTx(entitys);
    }

    private int addListener(MedicineBoxEngineListener listener) {
        if (mRequestId == Integer.MAX_VALUE) {
            mRequestId = 0;
        } else {
            mRequestId ++;
        }
        WeakReference<MedicineBoxEngineListener> weakListener = new WeakReference<MedicineBoxEngineListener>(listener);
        mListenerList.put(mRequestId, weakListener);
        return mRequestId;
    }

    private void notifyListener(int id, boolean result, List<MedicineBox> data) {
        WeakReference<MedicineBoxEngineListener> weakListener = mListenerList.get(id);
        if (weakListener != null) {
            MedicineBoxEngineListener listener = weakListener.get();
            if (listener != null) {
                listener.handleRemoteMedicineBoxResult(result, data);
            }
        }
    }
}
