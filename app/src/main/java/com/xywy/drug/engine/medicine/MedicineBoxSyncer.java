package com.xywy.drug.engine.medicine;

import android.content.Context;

import com.xywy.drug.data.gson.MedicineBox;
import com.xywy.drug.engine.account.Session;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-20.
 */
public class MedicineBoxSyncer implements MedicineBoxEngineListener {
    private enum SyncState {
        SYNC_STATE_GET_REMOTE_LIST,
        SYNC_STATE_GET_LOCAL_LIST,
        SYNC_STATE_MERGE,
        SYNC_STATE_UPDATE_REMOTE_LIST,
        SYNC_STATE_UPDATE_LOCAL_LIST
    }

    private MedicineBoxEngine mEngine;
    private Session mSession;
    private WeakReference<MedicineBoxSyncListener> mListener;

    public MedicineBoxSyncer(Context context) {
        mEngine = new MedicineBoxEngine(context);
        mSession = Session.defaultSession(context);
    }

    public void startSync(MedicineBoxSyncListener listener) {
        mListener = new WeakReference<MedicineBoxSyncListener>(listener);
        mEngine.getRemoteMedicineBoxByUserId(mSession.getUserId(), this);
    }

    @Override
    public void handleRemoteMedicineBoxResult(boolean result, List<MedicineBox> data) {

    }

    private void enterState(SyncState state) {
        switch (state) {
            case SYNC_STATE_GET_REMOTE_LIST:
                break;
            default:
                break;
        }
    }
}
