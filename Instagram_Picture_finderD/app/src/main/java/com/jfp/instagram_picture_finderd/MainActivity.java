package com.jfp.instagram_picture_finderd;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    String username;
    String img_url;
    private ProgressDialog pDialog;
    ImageView img;
    Context contex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText=(EditText)findViewById(R.id.editText);
        Button down=(Button)findViewById(R.id.down);
        img =(ImageView)findViewById(R.id.imageView);



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FullScreenImage.class);
                Bundle extras = new Bundle();
                extras.putString("img", img_url);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().matches(""))
                {
                    Toast.makeText(MainActivity.this, "ID is Empty :( why tell me", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (isOnline()) {
                        username = editText.getText().toString().trim();
                        new GetUrl().execute();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "No network Connection :(", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    class DownloadFile extends AsyncTask<String,Integer,Long> {
        ProgressDialog mProgressDialog = new ProgressDialog(MainActivity.this);// Change Mainactivity.this with your activity name.
        String strFolderName;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.setMessage("Downloading Image :D ");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.show();
        }
        @Override
        protected Long doInBackground(String... aurl) {
            int count;
            try {
                URL url = new URL((String) aurl[0]);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                Calendar cc = Calendar.getInstance();
                int year=cc.get(Calendar.YEAR);
                int month=cc.get(Calendar.MONTH);
                int mDay = cc.get(Calendar.DAY_OF_MONTH);
                int min = 1;
                int max = 1000 ;
                Random r = new Random();
                int i1 = r.nextInt(max - min + 1) + min;
                String all= year+month+mDay+i1+"".trim();
                String targetFileName=all+".jpg";//Change name and subname
                int lenghtOfFile = conexion.getContentLength();
                String PATH = Environment.getExternalStorageDirectory()+ "/"+"JFP_Downloader"+"/";
                File folder = new File(PATH);
                if(!folder.exists()){
                    folder.mkdir();//If there is no folder it will be created.
                }
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(PATH+targetFileName);
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress ((int)(total*100/lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {}
            return null;
        }
        protected void onProgressUpdate(Integer... progress) {
            mProgressDialog.setProgress(progress[0]);
            if(mProgressDialog.getProgress()==mProgressDialog.getMax()){
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Image Downloaded :D just for kianosh", Toast.LENGTH_LONG).show();


            }
        }
        protected void onPostExecute(String result) {
        }
    }



    private class GetUrl extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall("https://www.instagram.com/"+username+"/?__a=1".trim());

            //Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject sys  = jsonObj.getJSONObject("user");
                    img_url=sys.getString("profile_pic_url_hd");
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "ID IS Wrong :(",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            Picasso.with(getApplicationContext())
                    .load(img_url)
                    .into(img, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(getApplicationContext())
                                    .load(img_url)
                                    .error(R.drawable.ic_action_name)
                                    .into(img);
                        }
                    });
            new DownloadFile().execute(img_url);


        }

    }

    public Boolean isOnline()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}
