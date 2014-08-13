package com.tuyuanlin.framework.tools;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by eWalk_iOS on 14-8-12.
 */
public class TimingAlarmHelper {
    private static final String INTENT_ACTION = "com.timingalarm.TIME_OUT";
    private static final String INTENT_SCHEME = "alarming";
    private static final String INTENT_AUTHORITY = "com.timingalarm";

    public static <T extends BroadcastReceiver> void addTimingAlarm(Context context, String key, Map<String, String> data, Calendar startTime, long interval, Class<T> broadcaseClass) {
        PendingIntent pendingIntent = getPendingIntent(context, key, data, broadcaseClass, 0);

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, startTime.getTimeInMillis(), interval, pendingIntent);
    }

    public static <T extends BroadcastReceiver> void removeTimingAlarm(Context context, String key, Class<T> broadcaseClass) {
        PendingIntent pendingIntent = getPendingIntent(context, key, null, broadcaseClass, 0);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

    public static <T extends BroadcastReceiver> void updateTimingAlarm(Context context, String key, Map<String, String> data, Calendar startTime, long interval, Class<T> broadcaseClass) {
        removeTimingAlarm(context, key, broadcaseClass);
        addTimingAlarm(context, key, data, startTime, interval, broadcaseClass);
    }

    private static <T extends BroadcastReceiver> PendingIntent getPendingIntent(Context context, String key, Map<String, String> data, Class<T> broadcaseClass, int flag) {
        Intent intent = new Intent(context, broadcaseClass);
        intent.setAction(INTENT_ACTION);
        Uri uri = new Uri.Builder().scheme(INTENT_SCHEME).authority(INTENT_AUTHORITY).path(key).build();
        intent.setData(uri);

        if (data != null) {
            for (String name : data.keySet()) {
                intent.putExtra(name, data.get(name));
            }
        }

        return PendingIntent.getBroadcast(context, 1, intent, flag);
    }
}
