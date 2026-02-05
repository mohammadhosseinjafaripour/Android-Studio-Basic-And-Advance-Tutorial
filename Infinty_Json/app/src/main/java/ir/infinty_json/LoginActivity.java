package ir.infinty_json;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {


    Context context ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText userEmail, userPassword;
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        TextView forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPassword = (EditText) findViewById(R.id.userPassword);
        context  = getApplicationContext();



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(userEmail.getText().toString().matches("")||userPassword.getText().toString().matches(""))
                {
                    Toast.makeText(LoginActivity.this, "فیلد نام کاربری / رمز عبور خالی است.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(online()) {
                        String url = "";
                            new AsyncFetch_login().execute(userEmail.getText().toString(), userPassword.getText().toString());

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "لطفا از صحت اتصال به اینترنت اطمینان پیدا کرده سپس دوباره تلاش کنید.", Toast.LENGTH_SHORT).show();
                    }
                }



                //Toast.makeText(LoginActivity.this, "Email : " + userEmail.getText().toString() + "\nPassword : " + userPassword.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "I forgot my password !! :(", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private class AsyncFetch_login extends AsyncTask<String, String, String> {



        ProgressDialog pdLoading = new ProgressDialog(LoginActivity.this);
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

                String link="http://www.farsibase.ir/demo/irankafpoosh-app/mypage/?Fpage=login";

                String data  = URLEncoder.encode("log", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("pwd", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("submit", "UTF-8") + "=" + URLEncoder.encode("ok", "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(10000);

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
            }
            else
            {
                Toast.makeText(context, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean online() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
