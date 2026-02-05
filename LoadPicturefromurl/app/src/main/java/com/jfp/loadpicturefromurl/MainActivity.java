package com.jfp.loadpicturefromurl;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgurl=(ImageView)findViewById(R.id.imageurl);
        Picasso.with(this)
                .load("https://media.kulturbanause.de/blog/2015/12/material-design.png")
                .centerCrop()
                .error(R.drawable.error)
                .into(imgurl, new Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "Success full Loading Image", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this, "Failed Loading image", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
