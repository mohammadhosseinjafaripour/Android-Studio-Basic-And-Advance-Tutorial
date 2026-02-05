package ir.infinty_json;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private static final int LOAD_LIMIT = 5;


    private String lastId = "0";


    private boolean itShouldLoadMore = true;

    private RecyclerAdapter recyclerAdapter;
    private List<Product> recyclerModels;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // you must assign all objects to avoid nullPointerException
        recyclerModels = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(recyclerModels, ImageLoader.getInstance());

        final RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.loadmore_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Product product = recyclerModels.get(position);
                Toast.makeText(MainActivity.this, ""+product.getProductid(), Toast.LENGTH_SHORT).show();
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





    }







    private void firstLoadData() {

        String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?limit=" + LOAD_LIMIT;

        itShouldLoadMore = false;

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressDialog.dismiss();
                itShouldLoadMore = true;

                if (response.length() <= 0) {
                    Toast.makeText(MainActivity.this, "No data available", Toast.LENGTH_SHORT).show();

                    return;
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);



                        lastId = jsonObject.getString("id");

                        String id = jsonObject.getString("productid");
                        int Productname = jsonObject.getInt("title");
                        String x = jsonObject.getString("title");
                        String y = jsonObject.getString("description");

                        recyclerModels.add(new Product(Productname,x));
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
                Toast.makeText(MainActivity.this, "network error!", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(error.toString())
                        .show();
            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);


    }




    private void loadMore() {


        String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?action=loadmore&lastId=" + lastId + "&limit=" + LOAD_LIMIT;

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
                    Toast.makeText(MainActivity.this, "no data available", Toast.LENGTH_SHORT).show();
                    return; // return will end the program at this point
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        lastId = jsonObject.getString("id");
                        int title = jsonObject.getInt("title");
                        String description = jsonObject.getString("description");

                        recyclerModels.add(new Product(title, description));
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
                Toast.makeText(MainActivity.this, "Failed to load more, network error", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);

    }

}
