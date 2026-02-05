package com.jfp.materialdesignpushnotificationpart2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import in.mamga.carousalnotification.Carousal;
import in.mamga.carousalnotification.CarousalItem;

public class MainActivity extends AppCompatActivity {
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button big=(Button)findViewById(R.id.bigcontentpush);
        Button normal=(Button)findViewById(R.id.normalpush);
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Carousal carousal = Carousal.with(getApplicationContext()).beginTransaction();


                carousal.setBigContentTitle("Title").setBigContentText("SubTitle");

                //1  , 2 , 4,  6 , 8 ,...

                CarousalItem Aitem = new CarousalItem("1","First","One","");

                CarousalItem Bitem = new CarousalItem("2","Second","two","http://wallpaper-gallery.net/images/image/image-13.jpg");

                CarousalItem Citem = new CarousalItem("3","Third","three","http://wallpaper-gallery.net/images/image/image-13.jpg");

                CarousalItem Ditem = new CarousalItem("4","Fourth","Four","http://wallpaper-gallery.net/images/image/image-13.jpg");



                carousal.addCarousalItem(Aitem);
                carousal.addCarousalItem(Bitem);
                carousal.addCarousalItem(Citem);
                carousal.addCarousalItem(Ditem);


                carousal.buildCarousal();



            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Carousal carousal = Carousal.with(getApplicationContext()).beginTransaction();


                carousal.setContentTitle("Title").setContentText("SubTitle");

                //1  , 2 , 4,  6 , 8 ,...

                CarousalItem Aitem = new CarousalItem("1","First","One","");

                CarousalItem Bitem = new CarousalItem("2","Second","two","http://wallpaper-gallery.net/images/image/image-13.jpg");

                CarousalItem Citem = new CarousalItem("3","Third","three","http://wallpaper-gallery.net/images/image/image-13.jpg");

                CarousalItem Ditem = new CarousalItem("4","Fourth","Four","http://wallpaper-gallery.net/images/image/image-13.jpg");



                carousal.addCarousalItem(Aitem);
                carousal.addCarousalItem(Bitem);
                carousal.addCarousalItem(Citem);
                carousal.addCarousalItem(Ditem);


                carousal.buildCarousal();



            }
        });

    }
}
