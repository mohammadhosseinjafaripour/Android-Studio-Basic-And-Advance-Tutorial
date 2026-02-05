package com.jfp.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);

        final CheckBox male = (CheckBox)findViewById(R.id.male);
        final CheckBox female = (CheckBox)findViewById(R.id.female);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(male.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "مرد", Toast.LENGTH_SHORT).show();
                }
                if(female.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "زن", Toast.LENGTH_SHORT).show();
                }
                if(male.isChecked()&&female.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "مرد و زن", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
