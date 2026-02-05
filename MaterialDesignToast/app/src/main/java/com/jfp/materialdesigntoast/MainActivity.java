package com.jfp.materialdesigntoast;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.steamcrafted.loadtoast.LoadToast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button error=(Button)findViewById(R.id.error);
        Button show=(Button)findViewById(R.id.show);
        Button sucess=(Button)findViewById(R.id.sucess);

        final LoadToast loadToast = new LoadToast(MainActivity.this);
        loadToast.setText("Sending reply....");
        loadToast.setTextColor(Color.WHITE);
        loadToast.setBackgroundColor(Color.BLACK);

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadToast.error();

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadToast.show();

            }
        });

        sucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadToast.success();

            }
        });
    }
}
