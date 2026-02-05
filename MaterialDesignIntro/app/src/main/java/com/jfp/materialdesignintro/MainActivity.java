package com.jfp.materialdesignintro;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

public class MainActivity extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        //background Color of each Fragment
        int FirstColor= Integer.parseInt("#ddff00");
        int SecondColor= Integer.parseInt("#00ffe1");
        int ThirdColor= Integer.parseInt("#00ff15");
        int FourthColor= Integer.parseInt("#ff9100");

        Fragment fragment1= MaterialSlide.newInstance(R.drawable.computer,"Title","SubTile",R.color.black,R.color.black);
        Fragment fragment2= MaterialSlide.newInstance(R.drawable.microscope,"Title","SubTile",R.color.black,R.color.black);
        Fragment fragment3= MaterialSlide.newInstance(R.drawable.research,"Title","SubTile",R.color.black,R.color.black);
        Fragment fragment4= MaterialSlide.newInstance(R.drawable.science,"Title","SubTile",R.color.black,R.color.black);


        addSlide(fragment1,FirstColor);
        addSlide(fragment2,SecondColor);
        addSlide(fragment3,ThirdColor);
        addSlide(fragment4,FourthColor);

        //skip button Text Color :D
        setSkipButtonTextColor(Color.parseColor("#ff9100"));
        //Done Button Text Color
        setDoneButtonTextColor(Color.parseColor("#ff9100"));

        setDoneText("پایان");
        setSkipText("رد شدن");

        //show skip button :D
        showSkip();
        // hide Skip Button :(
        hideSkip();
        // show done button :d
        showDone();
        // hide done button :(
        hideDone();
        //show next button :D
        showNext();
        //hide next button :(
        hideNext();
        //hide dot
        hideIndicatorDots();
        //show dot :D
        showIndicatorDots();



    }

    @Override
    public void onSkipPressed() {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDonePressed() {

        // use shareprefrence for show this activity once :D
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
