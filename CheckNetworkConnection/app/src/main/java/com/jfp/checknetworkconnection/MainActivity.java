package com.jfp.checknetworkconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=(TextView)findViewById(R.id.netinfo);

        if(isOnline())
        {
            Toast.makeText(this, "Network is on", Toast.LENGTH_SHORT).show();
            textView.setText("network is on");
        }
        else {
            Toast.makeText(this, "Network is Off", Toast.LENGTH_SHORT).show();
            textView.setText("network is off");
        }
    }

    public boolean isOnline()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null && networkInfo.isConnectedOrConnecting();
    }
}
