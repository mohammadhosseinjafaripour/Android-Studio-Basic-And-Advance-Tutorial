package ir.kafpoosh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences shpr;
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        shpr = getApplicationContext().getSharedPreferences("helper", 0);

        final SharedPreferences.Editor editor = shpr.edit();
        if (!shpr.contains("first_time")) {
            editor.putBoolean("first_time", false);
            editor.commit();
        }

        sh = getSharedPreferences("helper", 0);


        if (!(sh.getBoolean("first_time", false))) {

            editor.putBoolean("first_time", true);
            editor.commit();
        }

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

//                Toast.makeText(SplashActivity.this, "TimeOut !!!", Toast.LENGTH_SHORT).show();

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
