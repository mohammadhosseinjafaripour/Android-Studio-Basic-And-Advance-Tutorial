package ir.farsibase;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jefferson on 9/15/2017.
 */

public class Utils {

    public String get_time() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public String get_location(Context context) {

        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        return longitude+","+latitude;
    }
}
