package com.jfp.exitappwithbackpress;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed()
    {
        //first methode
     new AlertDialog.Builder(this)
             .setTitle("خروج")
             .setMessage("آیا می خواهید از برنامه خارج شوید ؟")
             .setPositiveButton("بله",new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     MainActivity.super.onBackPressed();
                 }
             })
             .setNegativeButton("خیر",null)
             .create().show();

        //second methode
        //ّDouble click for exit
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "برای خروج دوبار دکمه خروج را بفشارید", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);


    }
}
