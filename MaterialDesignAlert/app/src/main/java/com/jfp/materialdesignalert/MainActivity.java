package com.jfp.materialdesignalert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter.create(MainActivity.this)
                        .setTitle("Title")
                        .setText("Text :D")
                        .show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter.create(MainActivity.this)
                        .setText("TExt")
                        .setTitle("title")
                        .setBackgroundColor(R.color.colorAccent)
                        .show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alerter.create(MainActivity.this)
                        .setText("Text")
                        .setTitle("Title")
                        .setIcon(R.drawable.Icon)
                        .show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alerter.create(MainActivity.this)
                        .setText("Text")
                        .setTitle("Title")
                        //1000 equal to  1 second :D
                        .setDuration(1000)

                        //click listiner
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Clicked :D", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });

    }
}
