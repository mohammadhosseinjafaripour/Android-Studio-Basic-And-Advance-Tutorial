package ir.php;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {

    private String mJSONURLString = "https://programchi.ir/api/time.php";

    private Context mContext;
    private Activity mActivity;

    private Handler mHandler = new Handler();
    private long mStartRX = 0;
    private long mStartTX = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartRX = TrafficStats.getTotalRxBytes();
        mStartTX = TrafficStats.getTotalTxBytes();
        if (mStartRX == TrafficStats.UNSUPPORTED || mStartTX == TrafficStats.UNSUPPORTED) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Uh Oh!");
            alert.setMessage("Your device does not support traffic stat monitoring.");
            alert.show();
        } else {
            mHandler.postDelayed(mRunnable, 1000);
        }


/*



        mContext = getApplicationContext();
        mActivity = MainActivity.this;



        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject student = response.getJSONObject(i);

                                String time = student.getString("time");
                                Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
        */
    }
    private final Runnable mRunnable = new Runnable() {
        public void run() {

            long rxBytes = TrafficStats.getTotalRxBytes()- mStartRX;
            Toast.makeText(mContext, ""+rxBytes, Toast.LENGTH_SHORT).show();
            long txBytes = TrafficStats.getTotalTxBytes()- mStartTX;
            Toast.makeText(mContext, ""+txBytes, Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(mRunnable, 1000);
        }
    };
}
