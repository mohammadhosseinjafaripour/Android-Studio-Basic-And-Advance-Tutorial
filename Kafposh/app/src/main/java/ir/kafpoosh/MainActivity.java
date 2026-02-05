package ir.kafpoosh;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
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
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    private static final int LOAD_LIMIT = 12;


    private String lastId = "0";


    private boolean itShouldLoadMore = true;

    private RecyclerAdapter recyclerAdapter;
    private List<Product> recyclerModels;
    SwipeRefreshLayout mSwipeRefreshLayout;


    ImageView userProfile;
    TextView UserName_tv, Email_tv;

    /*AMGH-*/
    private Toolbar toolbar;
    private ListView listView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    String[] titles;
    int[] images;

    private ListView lv;

    Address address = new Address();

    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recycler_view);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerModels.clear();
                refreshItems();
            }
        });


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        TextView toolbar_tv = (TextView) toolbar.findViewById(R.id.textView);
        toolbar_tv.setText("لیست محصولات");
        toolbar_tv.setTextSize(15);

        sh = getSharedPreferences("helper", 0);



        ListView listView = (ListView) findViewById(R.id.listView);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.nav_header_main, listView, false);
        listView.addHeaderView(header, null, false);

        SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);

        String email = sharedPreferences.getString("email", null);
        String pass = sharedPreferences.getString("pass", null);

        userProfile = (ImageView) header.findViewById(R.id.userProfile);
        Email_tv = (TextView) header.findViewById(R.id.userEmail);
        UserName_tv = (TextView) header.findViewById(R.id.userName);

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


        // you must assign all objects to avoid nullPointerException
        recyclerModels = new ArrayList<>();


        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerAdapter = new RecyclerAdapter(recyclerModels, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                if (recyclerModels.size() > 0) {
                    Product product = recyclerModels.get(position);
                    Intent intent = new Intent(MainActivity.this, SingleActivity.class);
                    intent.putExtra("id", Integer.toString(product.getProductid()));
                    intent.putExtra("title", product.getTitle());
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        firstLoadData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

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
        if (online()) {
            new AsyncFetch_user().execute(email, pass);
        }
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

        if (!sh.getBoolean("first_time", false)) {

        showForToolbar(MainActivity.this,
                ((MainActivity) MainActivity.this).toolbar,
                R.string.explain,
                menu.findItem(R.id.action_settings));

        }
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
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, HistoryActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, ChangePasswordActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 4:
                    startActivity(new Intent(MainActivity.this, RequestHistoryActivity.class));
                    mDrawerLayout.closeDrawers();
                    break;
                case 5:
                    mDrawerLayout.closeDrawers();
                    android.os.Process.killProcess(android.os.Process.myPid());
                    break;
            }
        }
    }

    private void firstLoadData() {

        String url = address.BaseAddress + "/mypage/?Fpage=product_list&limit=" + LOAD_LIMIT;

        itShouldLoadMore = false;

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("در حال دریافت داده ...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressDialog.dismiss();
                itShouldLoadMore = true;

                if (response.length() <= 0) {
                    Toast.makeText(MainActivity.this, "داده ای وجود ندارد !", Toast.LENGTH_SHORT).show();

                    return;
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        lastId = jsonObject.getString("id");


                        int id = jsonObject.getInt("id");
                        String title = jsonObject.getString("title");
                        String model = jsonObject.getString("model");
                        String imgUrl = jsonObject.getString("image");

                        recyclerModels.add(new Product(id, title, model, imgUrl));
                        recyclerAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                itShouldLoadMore = true;
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "خطا در اتصال به اینترنت !", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(error.toString())
                        .show();
            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);


    }

    private void loadMore() {

        String url = address.BaseAddress + "/mypage/?Fpage=product_list&last_id=" + lastId + "&limit=" + LOAD_LIMIT;

        itShouldLoadMore = false;

        final ProgressBar progressWheel = (ProgressBar) this.findViewById(R.id.progress_wheel);
        progressWheel.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressWheel.setVisibility(View.GONE);

                itShouldLoadMore = true;

                if (response.length() <= 0) {
                    // we need to check this, to make sure, our dataStructure JSonArray contains
                    // something
                    Toast.makeText(MainActivity.this, "داده ای وجود ندارد !", Toast.LENGTH_SHORT).show();
                    return; // return will end the program at this point
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        lastId = jsonObject.getString("id");


                        int id = jsonObject.getInt("id");
                        String title = jsonObject.getString("title");
                        String model = jsonObject.getString("model");
                        String imgUrl = jsonObject.getString("image");

                        recyclerModels.add(new Product(id, title, model, imgUrl));
                        recyclerAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressWheel.setVisibility(View.GONE);
                itShouldLoadMore = true;
                Toast.makeText(MainActivity.this, "خطا در ارتباط با شبکه !\n عدم اتصال به اینترنت !", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);

    }

    void refreshItems() {
        firstLoadData();
        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private class AsyncFetch_user extends AsyncTask<String, String, String> {


        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
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

                    Picasso.with(MainActivity.this)
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


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setMessage("آیا می خواهید خارج شوید ؟");
                alert.setTitle("");
                alert.setCancelable(false);
                alert.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        SharedPreferences.Editor sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE).edit();
                        sharedPreferences.clear();
                        sharedPreferences.apply();
                        sharedPreferences.commit();
                        android.os.Process.killProcess(android.os.Process.myPid());

                    }
                });

                alert.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                });

                alert.show();
            }
        });


    }




    public static void showForToolbar(Activity activity, final Toolbar toolbar, int message, final MenuItem menuItem) {
        Target homeTarget = new Target() {
            @Override
            public Point getPoint() {
                int actionBarWidth = toolbar.getWidth();
                int y = actionBarWidth - (menuItem.getIcon().getIntrinsicWidth() * menuItem.getOrder());
                return new Point(y, toolbar.getHeight());
            }
        };
        new ShowcaseView.Builder(activity)
                .setStyle(R.style.CustomShowcaseTheme2)
                .setTarget(homeTarget)
                .setContentText(message)
                .hideOnTouchOutside()
                .build().setButtonText("باشه");
    }


}
