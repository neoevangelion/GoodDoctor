package com.gooddoctor.ui.notification;

import android.app.Activity;

import android.app.AlarmManager;
import android.os.Bundle;
import com.gooddoctor.R;
import com.gooddoctor.engine.MedicineAlarmReceiver;
import com.tuyuanlin.framework.tools.TimingAlarmHelper;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditNotificationActivity extends Activity {

    public static final String NEW_NOTIFICATION_ACTION      = "com.gooddoctor.notification.INSERT";
    public static final String UPDATE_NOTIFICATION_ACTION   = "com.gooddoctor.notification.EDIT";

    private boolean mIsNewNotification = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notification);
        ButterKnife.inject(this);

        String action = getIntent().getAction();
        if (action != null) {
            if (action.equals(NEW_NOTIFICATION_ACTION)) {
                mIsNewNotification = true;
            } else if (action.equals(UPDATE_NOTIFICATION_ACTION)) {
                mIsNewNotification = false;
            }
        }
    }

    private void updateOrCreateAlarm() {

    }

    @OnClick(R.id.edit_notification_submit_button) void onSubmit() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);

        if (mIsNewNotification) {
            TimingAlarmHelper.addTimingAlarm(this, "100", null, calendar, AlarmManager.INTERVAL_DAY, MedicineAlarmReceiver.class);
        } else {
            TimingAlarmHelper.updateTimingAlarm(this, "100", null, calendar, AlarmManager.INTERVAL_DAY, MedicineAlarmReceiver.class);
        }
    }
}
