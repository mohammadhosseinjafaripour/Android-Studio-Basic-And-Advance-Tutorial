package com.batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new ContextWrapper(MainActivity.this).registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        // now you can get the level and scale from this intent variable
        int level = i.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = i.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float battPct = level/(float)scale;

        Toast.makeText(this, ""+battPct, Toast.LENGTH_SHORT).show();

    }
}
