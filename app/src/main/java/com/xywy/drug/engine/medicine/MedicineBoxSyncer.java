package com.xywy.drug.engine.medicine;

import android.content.Context;

import com.xywy.drug.data.dao.DBMedicineBox;
import com.xywy.drug.data.gson.MedicineBox;
import com.xywy.drug.engine.account.Session;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedicineBoxSyncer implements MedicineBoxEngineListener {
    private enum SyncState {
        SYNC_STATE_IDLE,
        SYNC_STATE_GET_REMOTE_LIST,
        SYNC_STATE_GET_LOCAL_LIST,
        SYNC_STATE_MERGE,
        SYNC_STATE_UPDATE_REMOTE_LIST,
        SYNC_STATE_ADD_REMOTE_LIST,
        SYNC_STATE_ADD_LOCAL_LIST
    }

    private SyncState mState;
    private MedicineBoxEngine mEngine;
    private Session mSession;
    private String mUserId;
    private WeakReference<MedicineBoxSyncListener> mListener;
    private List<MedicineBox> mRemoteList;
    private List<MedicineBox> mLocalList;
    private List<MedicineBox> mUpdatedLocalList;

    public MedicineBoxSyncer(Context context, MedicineBoxEngine engine) {
        mEngine = engine;
        mSession = Session.defaultSession(context);
        mState = SyncState.SYNC_STATE_IDLE;
    }

    public void startSync(MedicineBoxSyncListener listener) {
        if (mState != SyncState.SYNC_STATE_IDLE || mSession == null) {
            notifyListener(false);
            return;
        }

        mUserId = mSession.getUserId();
        mListener = new WeakReference<MedicineBoxSyncListener>(listener);
        mUpdatedLocalList = new ArrayList<MedicineBox>();

        enterState(SyncState.SYNC_STATE_GET_REMOTE_LIST);
    }

    @Override
    public void handleRemoteMedicineBoxResult(boolean result, List<MedicineBox> data) {
        switch (mState) {
            case SYNC_STATE_GET_REMOTE_LIST:
                if (result) {
                    mRemoteList = data;
                    enterState(SyncState.SYNC_STATE_GET_LOCAL_LIST);
                } else {
                    notifyListener(false);
                }
                break;
            case SYNC_STATE_UPDATE_REMOTE_LIST:
                //Should go on even if update failed
                enterState(SyncState.SYNC_STATE_ADD_REMOTE_LIST);
                break;
            case SYNC_STATE_ADD_REMOTE_LIST:
                //Should go on even if add failed
                enterState(SyncState.SYNC_STATE_ADD_LOCAL_LIST);
                break;
            default:
                break;
        }
    }

    private void enterState(SyncState state) {
        mState = state;
        switch (mState) {
            case SYNC_STATE_GET_REMOTE_LIST:
                mEngine.getRemoteMedicineBoxByUserId(mUserId, this);
                break;
            case SYNC_STATE_GET_LOCAL_LIST:
                List<DBMedicineBox> localList = mEngine.getLocalMedicineBoxByUserId(mUserId);
                mLocalList = MedicineBoxMapping.fromLocal(localList);
                enterState(SyncState.SYNC_STATE_MERGE);
                break;
            case SYNC_STATE_MERGE:
                merge(mLocalList, mRemoteList);
                enterState(SyncState.SYNC_STATE_UPDATE_REMOTE_LIST);
                break;
            case SYNC_STATE_UPDATE_REMOTE_LIST:
                mEngine.updateRemoteMedicineBox(mUpdatedLocalList, this);
                break;
            case SYNC_STATE_ADD_REMOTE_LIST:
                mEngine.addRemoteMedicineBox(mLocalList, this);
                break;
            case SYNC_STATE_ADD_LOCAL_LIST:
                mEngine.addLocalMedicineBox(MedicineBoxMapping.fromRemote(mRemoteList));
                enterState(SyncState.SYNC_STATE_IDLE);
                notifyListener(true);
                break;
            default:
                break;
        }
    }

    private void notifyListener(boolean result) {
        enterState(SyncState.SYNC_STATE_IDLE);
        MedicineBoxSyncListener listener = mListener.get();
        if (listener != null) {
            listener.handleMedicineBoxSyncResult(result);
        }
    }

    private void merge(List<MedicineBox> localList, List<MedicineBox> remoteList) {
        Iterator<MedicineBox> localIt = localList.iterator();

        while (localIt.hasNext()) {
            Iterator<MedicineBox> remoteIt = remoteList.iterator();
            while(remoteIt.hasNext()) {
                MedicineBox local = localIt.next();
                MedicineBox remote = remoteIt.next();

                if (isSameId(local, remote)) {
                    if (!isSameData(local, remote)) {
                        mUpdatedLocalList.add(local);
                    }
                    localIt.remove();
                    remoteIt.remove();
                    break;
                }
            }
        }
    }

    private boolean isSameId(MedicineBox local, MedicineBox remote) {
        if (local.getId().equals(remote.getId())) {
            return true;
        }
        return false;
    }

    private boolean isSameData(MedicineBox local, MedicineBox remote) {
        if (local.getId().equals(remote.getId())) {
            //TODO need verify all data
            return true;
        }
        return false;
    }
}
