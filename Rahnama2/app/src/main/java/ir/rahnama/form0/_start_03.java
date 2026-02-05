package ir.rahnama.form0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class _start_03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._start_03);

        TextView t_form_1 = (TextView)findViewById(R.id.f1_next);
        TextView t_form_2 = (TextView)findViewById(R.id.f2_next);
        TextView t_form_3 = (TextView)findViewById(R.id.f3_next);
        TextView t_form_4 = (TextView)findViewById(R.id.f4_next);
        TextView t_form_5 = (TextView)findViewById(R.id.f5_next);
        TextView t_form_6 = (TextView)findViewById(R.id.f6_next);


        t_form_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i  =new Intent(_start_03.this,f1s1.class);
//                startActivity(i);

            }
        });
        t_form_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i  =new Intent(_start_03.this,f2s1.class);
//                startActivity(i);
            }
        });
        t_form_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i  =new Intent(_start_03.this,F3Q1.class);
//                startActivity(i);

            }
        });
        t_form_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i  =new Intent(_start_03.this,activity_f4s1.class);
//                startActivity(i);
            }
        });
        t_form_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i  =new Intent(_start_03.this,F5Q1.class);
//                startActivity(i);

            }
        });
        t_form_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i  =new Intent(_start_03.this, F6S1.class);
//                startActivity(i);

            }
        });

    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
