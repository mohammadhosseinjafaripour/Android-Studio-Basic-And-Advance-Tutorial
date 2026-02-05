package ir.kafpoosh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by jefferson on 10/30/2017.
 */

public class IntroActivity extends AppIntro {

    SharedPreferences shpr;
    SharedPreferences sh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shpr = getApplicationContext().getSharedPreferences("Intro", 0);

        final SharedPreferences.Editor editor = shpr.edit();
        if (!shpr.contains("first_time")) {
            editor.putBoolean("first_time", false);
            editor.commit();
        }

        sh = getSharedPreferences("Intro", 0);


        if (!(sh.getBoolean("first_time", false))) {

            editor.putBoolean("first_time", true);
            editor.commit();
        } else {
            finish();
            Intent intent = new Intent(IntroActivity.this, SplashActivity.class);
            startActivity(intent);
        }

        addSlide(AppIntroFragment.newInstance("سلام", "خوش آمدید", R.mipmap.ic_launcher, Color.parseColor("#FF4081")));
        addSlide(AppIntroFragment.newInstance("Hi", "StartUp", R.mipmap.ic_launcher, Color.parseColor("#FF4434")));
        addSlide(AppIntroFragment.newInstance("Hi", "StartUp", R.mipmap.ic_launcher, Color.parseColor("#FF4921")));
        addSlide(AppIntroFragment.newInstance("Hi", "StartUp", R.mipmap.ic_launcher, Color.parseColor("#FF2154")));
        addSlide(AppIntroFragment.newInstance("Hi", "StartUp", R.mipmap.ic_launcher, Color.parseColor("#FF9254")));


        setSeparatorColor(Color.parseColor("#2196F3"));
        setSeparatorColor(Color.parseColor("#dadada"));
        setSkipText("رد شدن");
        setDoneText("شروع");

        showSkipButton(true);
        setProgressButtonEnabled(true);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
        Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}