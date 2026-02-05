package com.samsung;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jefferson on 5/23/2017.
 */

public class Tasks extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String language = settings.getString("language", "");
        if(language.toString()=="1") {
            SharedPreferences settings1 = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putString("language","2");
            editor.commit();
        }
        else {
            Intent i = new Intent(context,Main2Activity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}