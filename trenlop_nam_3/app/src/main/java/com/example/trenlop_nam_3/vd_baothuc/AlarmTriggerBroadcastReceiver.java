package com.example.trenlop_nam_3.vd_baothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AlarmTriggerBroadcastReceiver extends BroadcastReceiver {

    private final static String TAG_ALARM_TRIGGER_BROADCAST = "ALARM_TRIGGER_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String alarmType = intent.getStringExtra(Main_a.ALARM_TYPE);

        String alarmDescription = intent.getStringExtra(Main_a.ALARM_DESCRIPTION);

        Log.d(TAG_ALARM_TRIGGER_BROADCAST, alarmDescription);

        Toast.makeText(context, alarmDescription + " type: "+ alarmType, Toast.LENGTH_LONG).show();
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();

    }
}
