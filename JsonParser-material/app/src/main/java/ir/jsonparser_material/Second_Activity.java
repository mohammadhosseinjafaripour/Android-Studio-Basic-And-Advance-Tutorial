package ir.jsonparser_material;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Second_Activity extends AppCompatActivity {

    List<String> details;

    Context context;

    List<Product> listing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        context = getApplicationContext();


        final Bundle data = getIntent().getExtras();

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(data.getString("id"));


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


                        Product detai = new Product();
                        detai =  list.get(Integer.parseInt(data.getString("id"))-1);
                        textView.setText(detai.getProductname());

                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {
                    }

                });





            }
        });

    }



}
