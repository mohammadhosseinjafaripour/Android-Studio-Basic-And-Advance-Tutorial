package ir.kafpoosh;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ChangePasswordActivity extends AppCompatActivity {


    Context context;

    Address address = new Address();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        TextView title_page = (TextView) toolbar.findViewById(R.id.textView);
        title_page.setText("");
        title_page.setVisibility(View.GONE);

        ImageView backActivity = (ImageView) toolbar.findViewById(R.id.backBtn);
        backActivity.setVisibility(View.VISIBLE);
        backActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePasswordActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        final EditText oldPassword, newPassword, confirmNewPassword;
        Button changeBtn = (Button) findViewById(R.id.changeBtn);
        oldPassword = (EditText) findViewById(R.id.oldPassword);
        newPassword = (EditText) findViewById(R.id.newPassword);
        confirmNewPassword = (EditText) findViewById(R.id.confirmNewPassword);
        context = getApplicationContext();


        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (oldPassword.getText().toString().matches("") || newPassword.getText().toString().matches("") || confirmNewPassword.getText().toString().matches("")) {
                    Toast.makeText(ChangePasswordActivity.this, "لطفا تمام فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                } else {
                    if (!newPassword.getText().toString().equals(confirmNewPassword.getText().toString())){
                        Toast.makeText(context, "خطا : رمز عبور مطابقت ندارد !", Toast.LENGTH_SHORT).show();
                    }else{
                        if (online()) {
                            String url = "";
                            new AsyncFetch_change().execute(oldPassword.getText().toString(), newPassword.getText().toString(), confirmNewPassword.getText().toString());

                        } else {
                            Toast.makeText(ChangePasswordActivity.this, "لطفا از صحت اتصال به اینترنت اطمینان پیدا کرده سپس دوباره تلاش کنید.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


                //Toast.makeText(LoginActivity.this, "Email : " + userEmail.getText().toString() + "\nPassword : " + userPassword.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class AsyncFetch_change extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(ChangePasswordActivity.this);
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
            try {
                String old = (String) arg0[0];
                String new_pass = (String) arg0[1];
                String c_new_pass = (String) arg0[2];
                String link = address.BaseAddress+"/mypage/?Fpage=login";
                String data = URLEncoder.encode("old", "UTF-8") + "=" + URLEncoder.encode(old, "UTF-8");
                data += "&" + URLEncoder.encode("new", "UTF-8") + "=" + URLEncoder.encode(new_pass, "UTF-8");
                data += "&" + URLEncoder.encode("cnew", "UTF-8") + "=" + URLEncoder.encode(c_new_pass, "UTF-8");
                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(10000);
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            } catch (InterruptedIOException iioe) {
                iioe.printStackTrace();
                return "000";
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return "000";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();
            JSONObject mainObject = null;
            String flag = "";
            String user_id = "";
            try {
                mainObject = new JSONObject(result);
                flag = mainObject.getString("is_login");
                user_id = mainObject.getString("user_id");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (flag == "true") {
                Toast.makeText(context, "تغییر رمز با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(ChangePasswordActivity.this, MainActivity.class));
            } else {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();//todo catching responses
            }
        }
    }

    private boolean online() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
