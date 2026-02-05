package ir.farsibase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try
        {
            Thread timerthread = new Thread(){
                public void run()
                {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent = new Intent(Splash.this,Login.class);
                        startActivity(intent);
                    }
                }
            };
            timerthread.start();
        }
        catch (Exception e) {
        }
    }
}