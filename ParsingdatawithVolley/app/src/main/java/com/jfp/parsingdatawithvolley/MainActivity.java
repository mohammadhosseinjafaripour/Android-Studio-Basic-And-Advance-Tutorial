package com.jfp.parsingdatawithvolley;

import android.content.Context;
import android.content.Entity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.toolbox.HttpClientStack;

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

public class MainActivity extends AppCompatActivity {

    HttpResponse response;
    String str;
    JSONObject json=null;
    String id,email,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
           new Getdatafromdatabase(MainActivity.this).execute();
        }
        catch (Exception e)
        {

        }
    }
    private class Getdatafromdatabase extends AsyncTask<Void, Void, Void> {
        public Context context;


        public Getdatafromdatabase(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpClient myClient = new DefaultHttpClient();
            HttpPost myConnection = new HttpPost("http://studioapk.ir/bebinobego/send-data.php");

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
                json = jArray.getJSONObject(1);






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
                id = json.getString("id");
                email = json.getString("email");
                name = json.getString("name");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
