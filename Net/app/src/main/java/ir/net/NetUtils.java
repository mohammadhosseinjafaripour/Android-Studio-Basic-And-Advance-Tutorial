package ir.net;

/**
 * Created by jefferson on 7/28/2017.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connection = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = null;
        if (connection != null) {
            nInfo = connection.getActiveNetworkInfo();
        }
        if (nInfo == null || !nInfo.isConnectedOrConnecting()) {
            return false;
        }

        if (nInfo == null || !nInfo.isConnected()) {
            return false;
        }
        if (nInfo != null
                && ((nInfo.getType() == ConnectivityManager.TYPE_MOBILE) || (nInfo
                .getType() == ConnectivityManager.TYPE_WIFI))) {
            if (nInfo.getState() != NetworkInfo.State.CONNECTED
                    || nInfo.getState() == NetworkInfo.State.CONNECTING) {
                return false;
            }
        }
        return true;
    }
}