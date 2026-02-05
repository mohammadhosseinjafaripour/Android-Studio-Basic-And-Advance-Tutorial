package ir.rahnama.form0;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;


    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getApplicationContext();

        final EditText user = (EditText)findViewById(R.id.user_);
        final EditText pass = (EditText)findViewById(R.id.pass_);
        Button btn = (Button)findViewById(R.id.login_pass_click);


        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim1);
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim2);

        user.setVisibility(View.VISIBLE);
        pass.setVisibility(View.VISIBLE);
        btn.setVisibility(View.VISIBLE);

        user.startAnimation(animFadeIn);
        pass.startAnimation(animFadeIn);
        btn.startAnimation(animFadeIn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(user.getText().toString().matches("")||pass.getText().toString().matches(""))
                {
                    Toast.makeText(Login.this, "فیلد نام کاربری / رمز عبور خالی است.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(online()) {

                        new AsyncFetch_login().execute(user.getText().toString(), pass.getText().toString());
                    }
                    else
                    {
                        Toast.makeText(context, "لطفا از صحت اتصال به اینترنت اطمینان پیدا کرده سپس دوباره تلاش کنید.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


    private class AsyncFetch_login extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(Login.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\t دریافت اطلاعات");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... arg0) {

            try{
                String email = (String)arg0[0];
                String pass  = (String)arg0[1];

                String link="http://farsibase.ir/demo/rahnama/mypage/?Fpage=login";

                String data  = URLEncoder.encode("log", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("pwd", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("submit", "UTF-8") + "=" + URLEncoder.encode("ok", "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }

                return sb.toString();
            }
            catch (InterruptedIOException iioe)
            {
                iioe.printStackTrace();
                return "000";
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return  "000";
            }

        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();

            JSONObject mainObject = null;
            String flag="";
            String user_id="";
            try {
                mainObject = new JSONObject(result);
                flag = mainObject.getString("is_login");
                user_id = mainObject.getString("user_id");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (flag=="true") {
                Toast.makeText(context, "ورود موفقیت آمیز بود.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this,_start_01.class);
                startActivity(i);


            }
            else
            {
                Toast.makeText(context, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();

            }
        }

    }

    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private boolean online() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
