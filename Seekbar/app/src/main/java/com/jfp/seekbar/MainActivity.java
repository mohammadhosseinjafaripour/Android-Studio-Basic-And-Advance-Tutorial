package com.jfp.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView progress = (TextView)findViewById(R.id.progress);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);

        progress.setText(""+seekBar.getProgress() + "/"+ seekBar.getMax() );
        
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                Toast.makeText(getApplicationContext(), "Start changing progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Start Touching seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                progress.setText(""+progress + "/ " + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Touch finished", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
