package ir.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by jefferson on 7/28/2017.
 */

public class net extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(NetUtils.isNetworkAvailable(context))
        {
            Toast.makeText(context, "ON", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show();
        }

      
    }
}
