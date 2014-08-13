package com.gooddoctor.engine.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.gooddoctor.data.dao.DaoSession;
import com.gooddoctor.data.dao.DataBaseUtil;
import com.gooddoctor.data.dao.Notification;
import com.gooddoctor.data.dao.NotificationDao;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

public class MedicineAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getData().toString(), Toast.LENGTH_LONG).show();
    }
}
