package com.samsung;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by jefferson on 5/25/2017.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Calendar updateTime = Calendar.getInstance();
        updateTime.setTimeZone(TimeZone.getTimeZone("GMT+5:00"));
        updateTime.set(Calendar.HOUR_OF_DAY, 3);
        updateTime.set(Calendar.MINUTE, 00);

        Intent i = new Intent(context, Tasks.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarms = (AlarmManager) context.getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, recurringDownload);
    }
}