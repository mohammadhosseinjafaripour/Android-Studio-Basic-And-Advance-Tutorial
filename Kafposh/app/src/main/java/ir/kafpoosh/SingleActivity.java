package ir.kafpoosh;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SingleActivity extends AppCompatActivity {


    /*AMGH-*/
    private Toolbar toolbar;
    private ListView listView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    String[] titles;
    int[] images;

    private ListView lv;
    /*end drawer*/

    CarouselView carouselView;

    String[] sampleNetworkImageURLs;


    TextView modelTv;
    TextView dimensionTv;
    TextView areaTv;
    TextView thicknessTv;
    TextView klassTv;

    Address address;

    String email;
    String pass;

    int pid = 0;
    private boolean loaded_flag = false;
    private ImageView userProfile;
    private TextView Email_tv;
    private TextView UserName_tv;

    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);


        address = new Address();

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        modelTv = (TextView) findViewById(R.id.model);
        dimensionTv = (TextView) findViewById(R.id.dimension);
        areaTv = (TextView) findViewById(R.id.area);
        thicknessTv = (TextView) findViewById(R.id.thickness);
        klassTv = (TextView) findViewById(R.id.klass);


        relativeLayout = (RelativeLayout) findViewById(R.id.hidden_relative);
        final ImageView imageView = (ImageView) findViewById(R.id.full_screen_img);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                if (online()) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    Picasso.with(SingleActivity.this)
                            .load(sampleNetworkImageURLs[position])
                            .fit().centerCrop()
                            .error(R.drawable.warrning)
                            .into(imageView);
                } else {
                    Toast.makeText(SingleActivity.this, "لطفا دستگاه خود را به اینترنت متصل کنید", Toast.LENGTH_SHORT).show();
                }


            }
        });
        Button btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
            }
        });

        /*start toolbar*/
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        TextView toolbar_tv = (TextView) toolbar.findViewById(R.id.textView);
        toolbar_tv.setText("جزئیات محصول");
        ListView listView = (ListView) findViewById(R.id.listView);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.nav_header_main, listView, false);
        listView.addHeaderView(header, null, false);

        SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);

        email = sharedPreferences.getString("email", null);
        pass = sharedPreferences.getString("pass", null);
        final String user_id = sharedPreferences.getString("user_id", null);

        userProfile = (ImageView) header.findViewById(R.id.userProfile);
        Email_tv = (TextView) header.findViewById(R.id.userEmail);
        UserName_tv = (TextView) header.findViewById(R.id.userName);
        if (online()) {
            new AsyncFetch_user().execute(email, pass);
        }


        titles = getResources().getStringArray(R.array.list_items);

        images = new int[]{
                R.drawable.contact_list2,
                R.drawable.ic_add,
                R.drawable.ic_lock_outline_black_24dp,
                R.drawable.health_report,
                R.drawable.close
        };

        MyAdapter myAdapter = new MyAdapter(getApplicationContext());
//        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        listView.setOnItemClickListener(new DrawerItemClickListener());

        /* end start toolbar*/


        //find views
        TextView titleTv = (TextView) findViewById(R.id.singleTitle);
        Button requestSample = (Button) findViewById(R.id.requestSample);
        Button send = (Button) findViewById(R.id.send);


        String title = "noTitle";

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pid = Integer.parseInt(bundle.getString("id", null));
            title = bundle.getString("title", null);
            titleTv.setText(title);
        }


        requestSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (!isFinishing()) {
                            new AlertDialog.Builder(SingleActivity.this)
                                    .setTitle("")
                                    .setMessage("آیا از درخواست خود مطمئن هستید ؟")
                                    .setCancelable(false)
                                    .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (online()) {
                                                new AsyncFetch_req().execute(Integer.toString(pid), modelTv.getText().toString(), user_id);//todo param
                                            } else {
                                                Toast.makeText(SingleActivity.this, "لطفا از صحت اتصال به اینترنت مطمئن شوید.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).show();
                        }
                    }
                });
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LayoutInflater inflater = LayoutInflater.from(SingleActivity.this);
                        final View view = inflater.inflate(R.layout.custom_edt_checkbox, null);
                        final AlertDialog.Builder alert = new AlertDialog.Builder(SingleActivity.this);
                        final EditText edittext = (EditText) view.findViewById(R.id.dimension_edt);
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_below_edt);


                        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
                        edittext.setHint("متر مربع");
                        alert.setView(view);
                        alert.setCancelable(false);
                        alert.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String YouEditTextValue = edittext.getText().toString();
                                if (!YouEditTextValue.equals("")) {
                                    if (online()) {
                                        //product_id=1&product_model=1&user_id=1&meter=120&submit=ok
                                        new AsyncFetch_send().execute(Integer.toString(pid), modelTv.getText().toString(), user_id, YouEditTextValue);//todo param
                                    } else {
                                        Toast.makeText(SingleActivity.this, "لطفا از صحت اتصال به اینترنت مطمئن شوید.", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(SingleActivity.this, "لطفا متراژ را تعیین کنید.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        alert.setNegativeButton("لغو", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        });
                        final AlertDialog alertDialog = alert.show();
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                                } else {
                                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                                }
                            }
                        });


                    }
                });
            }
        });


        /*carousel links filling*/
        if (online()) {
            new AsyncFetch_json().execute(Integer.toString(pid));
        }

    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private boolean online() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private class AsyncFetch_req extends AsyncTask<String, String, String> {


        ProgressDialog pdLoading = new ProgressDialog(SingleActivity.this);
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
                String product_id = (String) arg0[0];
                String product_model = (String) arg0[1];
                String user_id = (String) arg0[2];


                //product_id=1&product_model=1&user_id=1&meter=120&submit=ok
                String link = address.BaseAddress + "/mypage/?Fpage=set_sample&";

                String data = URLEncoder.encode("product_id", "UTF-8") + "=" + URLEncoder.encode(product_id, "UTF-8");
                data += "&" + URLEncoder.encode("product_model", "UTF-8") + "=" + URLEncoder.encode(product_model, "UTF-8");
                data += "&" + URLEncoder.encode("userName", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("passWord", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(user_id, "UTF-8");
                data += "&" + URLEncoder.encode("submit", "UTF-8") + "=" + URLEncoder.encode("ok", "UTF-8");

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
            Boolean flag = false;
            try {
                mainObject = new JSONObject(result);
                flag = mainObject.getBoolean("status");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (flag) {
                Toast.makeText(SingleActivity.this, "درخواست با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SingleActivity.this, "خطا در انجام عملیات ! لطفا با مدیر سایت تماس حاصل فرمایید.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private class AsyncFetch_send extends AsyncTask<String, String, String> {


        ProgressDialog pdLoading = new ProgressDialog(SingleActivity.this);
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
                String product_id = (String) arg0[0];
                String product_model = (String) arg0[1];
                String user_id = (String) arg0[2];
                String meter = (String) arg0[3];


                //product_id=1&product_model=1&user_id=1&meter=120&submit=ok
                String link = address.BaseAddress + "/mypage/?Fpage=set_order&";

                String data = URLEncoder.encode("product_id", "UTF-8") + "=" + URLEncoder.encode(product_id, "UTF-8");
                data += "&" + URLEncoder.encode("product_model", "UTF-8") + "=" + URLEncoder.encode(product_model, "UTF-8");
                data += "&" + URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(user_id, "UTF-8");
                data += "&" + URLEncoder.encode("userName", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                data += "&" + URLEncoder.encode("passWord", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("meter", "UTF-8") + "=" + URLEncoder.encode(meter, "UTF-8");
                data += "&" + URLEncoder.encode("submit", "UTF-8") + "=" + URLEncoder.encode("ok", "UTF-8");

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
            Boolean flag = false;
            String message = "";
            try {
                mainObject = new JSONObject(result);
                flag = mainObject.getBoolean("status");
                message = mainObject.getString("message");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (flag) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SingleActivity.this);
                builder.setMessage(message.toString());
                builder.setPositiveButton("باشه", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            } else {
                Toast.makeText(SingleActivity.this, "خطا در انجام عملیات ! لطفا با مدیر سایت تماس حاصل فرمایید.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private class AsyncFetch_json extends AsyncTask<String, String, String> {


        ProgressDialog pdLoading = new ProgressDialog(SingleActivity.this);
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
                String id = (String) arg0[0];

                String link = address.BaseAddress + "/mypage/?Fpage=get_product&product_id=" + id;

                String data = URLEncoder.encode("log", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");

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

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(result);
                Boolean p_status = jsonObject.getBoolean("status");
//                String p_title = jsonObject.getString("title");
                String p_size = jsonObject.getString("size");
                String p_model = jsonObject.getString("model");
                String p_box_meter = jsonObject.getString("box_meter");
                String p_thickness = jsonObject.getString("thickness");
                String p_klass = jsonObject.getString("class");

                modelTv.setText(p_model);
                dimensionTv.setText(p_size);
                areaTv.setText(p_box_meter);
                thicknessTv.setText(p_thickness);
                klassTv.setText(p_klass);
                if (p_size.toString().equals("")) {
                    dimensionTv.setText("تعریف نشده");
                }
                if (p_box_meter.toString().equals("")) {
                    areaTv.setText("تعریف نشده");
                }
                if (p_thickness.toString().equals("")) {
                    thicknessTv.setText("تعریف نشده");
                }
                if (p_klass.toString().equals("")) {
                    klassTv.setText("تعریف نشده");
                }



                if (p_status) {
                    JSONArray jsonimages = jsonObject.getJSONArray("images");
                    sampleNetworkImageURLs = new String[jsonimages.length()];
                    for (int i = 0; i < jsonimages.length(); i++) {
                        sampleNetworkImageURLs[i] = (String) jsonimages.get(i);
                        carouselView.setImageListener(new ImageListener() {
                            @Override
                            public void setImageForPosition(int position, ImageView imageView) {
                                Picasso.with(getApplicationContext()).load(sampleNetworkImageURLs[position]).fit().centerCrop().into(imageView);
                            }
                        });
                        carouselView.setPageCount(sampleNetworkImageURLs.length);
                    }
                    carouselView.pauseCarousel();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Animation RightSwipe = AnimationUtils.loadAnimation(SingleActivity.this, R.anim.animation);
                        modelTv.startAnimation(RightSwipe);
                        dimensionTv.startAnimation(RightSwipe);
                        areaTv.startAnimation(RightSwipe);
                        klassTv.startAnimation(RightSwipe);
                        thicknessTv.startAnimation(RightSwipe);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mDrawerLayout.openDrawer(GravityCompat.END);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflaer;

        public MyAdapter(Context context) {
            mInflaer = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile/IRANSansMobile(FaNum).ttf");

            if (convertView == null) {
                view = mInflaer.inflate(R.layout.list_items, null);
            } else {
                view = convertView;
            }
            TextView textView = (TextView) view.findViewById(R.id.list_text);
            ImageView imageView = (ImageView) view.findViewById(R.id.list_image);
            textView.setText(titles[position]);
            textView.setTypeface(typeface);
            imageView.setImageResource(images[position]);
            return view;
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            selectitem(position);
        }

        private void selectitem(int position) {

            switch (position) {
                case 1:
                    finish();
                    startActivity(new Intent(SingleActivity.this, MainActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 2:
                    startActivity(new Intent(SingleActivity.this, HistoryActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(SingleActivity.this, ChangePasswordActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 4:
                    startActivity(new Intent(SingleActivity.this, RequestHistoryActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 5:
                    mDrawerLayout.closeDrawers();
                    android.os.Process.killProcess(android.os.Process.myPid());
                    break;
            }
        }
    }

    private class AsyncFetch_user extends AsyncTask<String, String, String> {


        ProgressDialog pdLoading = new ProgressDialog(SingleActivity.this);
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
                String userName = (String) arg0[0];
                String pass = (String) arg0[1];

                String link = address.BaseAddress + "/mypage/?Fpage=login&";

                String data = URLEncoder.encode("log", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8");
                data += "&" + URLEncoder.encode("pwd", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                data += "&" + URLEncoder.encode("submit", "UTF-8") + "=" + URLEncoder.encode("ok", "UTF-8");

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

            String name_family = "";
            String email = "";
            final String image;
            try {
                mainObject = new JSONObject(result);
                name_family = mainObject.getString("name_family");
                email = mainObject.getString("email");
                image = mainObject.getString("user_image");


                Email_tv.setText(email);
                UserName_tv.setText(name_family);
                if (!image.equals("")) {

                    Picasso.with(SingleActivity.this)
                            .load(image)
                            .error(R.drawable.user_default)
                            .into(userProfile);

                } else {
                    //// TODO: 10/19/2017  set icon error
                    userProfile.setImageResource(R.drawable.user_default);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (relativeLayout.getVisibility() == View.VISIBLE) {
            relativeLayout.setVisibility(View.GONE);
        } else {
            mDrawerLayout.closeDrawers();
            finish();
        }


    }
}






