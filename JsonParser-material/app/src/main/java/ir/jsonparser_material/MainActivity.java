package ir.jsonparser_material;


import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> listing;

    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ProgressBar pb = (ProgressBar)findViewById(R.id.item_progress_bar);



        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        listing = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://programchi.ir")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APiService service = retrofit.create(APiService.class);
        Call<List<Product>> call = service.getbookdetails();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> list = response.body();
                Product product = null;
                for (int i = 0; i < list.size(); i++) {
                    product = new Product();
                    String name = list.get(i).getProductname();
                    String color = list.get(i).getColor();
                    String image = list.get(i).getImageurl();
                    String price = list.get(i).getPrice();
                    int id = list.get(i).getProductid();
                    product.setPrice(price);
                    product.setColor(color);
                    product.setProductname(name);
                    product.setImageurl(image);
                    product.setProductid(id);
                    listing.add(product);
                }


                Recycleradapter recyclerAdapter = new Recycleradapter(listing, ImageLoader.getInstance());
                final RecyclerView.LayoutManager recyce = new GridLayoutManager(MainActivity.this, 1);


                final LinearLayoutManager mLayoutManager;
                mLayoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);


                //recyclerView.addItemDecoration(new GridSpacingdecoration(1, dpToPx(10), true));
                recyclerView.setLayoutManager(recyce);
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);

                        if (dy > 0) {
                            // Recycle view scrolling down...
                            if(recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN) == false){
                                Toast.makeText(getApplicationContext(), "Reached the end of recycler view", Toast.LENGTH_LONG).show();
                                pb.setVisibility(View.VISIBLE);
                            }
                        }
                        if (dy < 0) {
                            // Recycle view scrolling up...
                            pb.setVisibility(View.GONE);
                        }

                    }
                });
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerAdapter);


            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    public class GridSpacingdecoration extends RecyclerView.ItemDecoration {

        private int span;
        private int space;
        private boolean include;

        public GridSpacingdecoration(int span, int space, boolean include) {
            this.span = span;
            this.space = space;
            this.include = include;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % span;

            if (include) {
                outRect.left = space - column * space / span;
                outRect.right = (column + 1) * space / span;

                if (position < span) {
                    outRect.top = space;
                }
                outRect.bottom = space;
            } else {
                outRect.left = column * space / span;
                outRect.right = space - (column + 1) * space / span;
                if (position >= span) {
                    outRect.top = space;
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}