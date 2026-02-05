package ir.kafpoosh;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RequestHistoryActivity extends AppCompatActivity {


    String email;
    String pass;
    String user_id;

    private static final int LOAD_LIMIT = 20;
    private String lastId = "0";
    private boolean itShouldLoadMore = true;
    private List<RequestHistory> OrderHistoryList;
    RequestRecyclerAdapter hRecyclerAdapter;


    /*AMGH-*/
    private Toolbar toolbar;
    private ListView listView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    String[] titles;
    int[] images;
    private ListView lv;
    private ImageView userProfile;
    private TextView Email_tv;
    private TextView UserName_tv;
    /*end drawer*/

    Address address = new Address();

    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_status);


        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                OrderHistoryList.clear();
                refreshItems();
            }
        });


        /*start toolbar*/
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        TextView product_tv = (TextView) toolbar.findViewById(R.id.textView);
        product_tv.setText("لیست سفارشات");
        product_tv.setTextSize(17);

        ListView listView = (ListView) findViewById(R.id.listView);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.nav_header_main, listView, false);
        listView.addHeaderView(header, null, false);

        SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);

        email = sharedPreferences.getString("email", null);
        pass = sharedPreferences.getString("pass", null);
        user_id = sharedPreferences.getString("user_id", null);


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


        OrderHistoryList = new ArrayList<>();
        RecyclerView historyRecyclerView = (RecyclerView) findViewById(R.id.historyRecyclerView);
        historyRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        historyRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        hRecyclerAdapter = new RequestRecyclerAdapter(OrderHistoryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        historyRecyclerView.setLayoutManager(mLayoutManager);
        historyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        historyRecyclerView.setAdapter(hRecyclerAdapter);
        historyRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), historyRecyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                if (OrderHistoryList.size() > 0) {
                    RequestHistory product = OrderHistoryList.get(position);
                    Intent intent = new Intent(RequestHistoryActivity.this, SingleActivity.class);
                    intent.putExtra("id", product.get_id());
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        if (online()) {
            firstLoadData();
        } else {
            Toast.makeText(this, "لطفا دستگاه خود را به اینترنت متصل کنید.", Toast.LENGTH_SHORT).show();
        }
        historyRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            // for this tutorial, this is the ONLY method that we need, ignore the rest
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        if (itShouldLoadMore) {
                            loadMore();
                        }
                    }
                }
            }
        });
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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
                    startActivity(new Intent(RequestHistoryActivity.this, MainActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 2:
                    startActivity(new Intent(RequestHistoryActivity.this, RequestHistoryActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(RequestHistoryActivity.this, ChangePasswordActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 4:
                    startActivity(new Intent(RequestHistoryActivity.this, RequestHistoryActivity.class));
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


        ProgressDialog pdLoading = new ProgressDialog(RequestHistoryActivity.this);
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

                    Picasso.with(RequestHistoryActivity.this)
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

    private boolean online() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mDrawerLayout.closeDrawers();
        finish();
    }


    private void firstLoadData() {

        String url = address.BaseAddress + "/mypage/?Fpage=sample_list&limit=" + LOAD_LIMIT + "&userName=" + email + "&passWord=" + pass + "&submit=" + "ok" + "&user_id=" + user_id;

        itShouldLoadMore = false;

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("در حال دریافت داده ...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        /*final String urls = "http://httpbin.org/get?param1=hello";


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, urls, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        //Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.d("Error.Response", response);
                    }
                }
        );
        queue.add(getRequest);*/


        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                itShouldLoadMore = true;


                JSONObject jsonObj = response;

                JSONArray ja_data = null;
                try {
                    ja_data = jsonObj.getJSONArray("sample");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (ja_data.length() <= 0) {
                    Toast.makeText(RequestHistoryActivity.this, "داده ای وجود ندارد !", Toast.LENGTH_SHORT).show();

                    return;
                }

                for (int i = 0; i < ja_data.length(); i++) {
                    try {
                        JSONObject jObj = ja_data.getJSONObject(i);


                        //JSONObject jsonObject = response.getJSONObject(i);


                        lastId = jObj.getString("sample_id");

                        String sample_product_id = jObj.getString("sample_product_id");
                        String model = jObj.getString("sample_product_model");


                        OrderHistoryList.add(new RequestHistory(model, sample_product_id));
                        hRecyclerAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                itShouldLoadMore = true;
                progressDialog.dismiss();
                Toast.makeText(RequestHistoryActivity.this, "خطا در اتصال به اینترنت !", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(RequestHistoryActivity.this)
                        .setMessage(error.toString())
                        .show();
            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);


    }


    private void loadMore() {

        String url = address.BaseAddress + "/mypage/?Fpage=sample_list&limit=" + LOAD_LIMIT + "&userName=" + email + "&passWord=" + pass + "&submit=" + "ok" + "&user_id=" + user_id + "&last_id=" + lastId;

        itShouldLoadMore = false;

        final ProgressBar progressWheel = (ProgressBar) this.findViewById(R.id.progress_wheel);
        progressWheel.setVisibility(View.VISIBLE);
        try {

            JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressWheel.setVisibility(View.GONE);

                    itShouldLoadMore = true;

                    JSONObject jObject = response;

                    Boolean finished_data = true;

                    Iterator<String> keys = jObject.keys();
                    try {
                        String keyValue = (String) keys.next();
                        Boolean valueString = jObject.getBoolean(keyValue);
                        //Toast.makeText(HistoryActivity.this, valueString, Toast.LENGTH_SHORT).show();
                        if (!valueString) {
                            finished_data = false;
                            itShouldLoadMore = false;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();


                    }

                    if (finished_data) {
                        JSONObject jsonObj = response;

                        JSONArray ja_data = null;
                        try {
                            ja_data = jsonObj.getJSONArray("sample");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        for (int i = 0; i < jsonObj.length(); i++) {
                            try {
                                JSONObject jObj = ja_data.getJSONObject(i);


                                //JSONObject jsonObject = response.getJSONObject(i);

                                lastId = jObj.getString("sample_id");

                                String sample_product_id = jObj.getString("sample_product_id");
                                String model = jObj.getString("sample_product_model");


                                OrderHistoryList.add(new RequestHistory(model, sample_product_id));
                                hRecyclerAdapter.notifyDataSetChanged();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    } else {
                        Toast.makeText(RequestHistoryActivity.this, "داده ای وجود ندارد", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressWheel.setVisibility(View.GONE);
                    itShouldLoadMore = true;
//                Toast.makeText(HistoryActivity.this, "خطا در ارتباط با شبکه !\n عدم اتصال به اینترنت !", Toast.LENGTH_SHORT).show();
                    Toast.makeText(RequestHistoryActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            Volley.newRequestQueue(this).add(jsonArrayRequest);
        } catch (Exception e) {

        }

    }


    void refreshItems() {
        firstLoadData();
        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
