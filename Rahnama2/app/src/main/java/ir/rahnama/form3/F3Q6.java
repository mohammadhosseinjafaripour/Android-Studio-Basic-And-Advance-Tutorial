package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q6 extends AppCompatActivity {

    final ArrayList<String> al = new ArrayList<String>();
    private RadioGroup[] radioGroups = new RadioGroup[8];
    private TextView[] textViews = new TextView[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q6);






        int[] textViewId = new int[]{
                R.id.f3s6v1tv,
                R.id.f3s6v2tv,
                R.id.f3s6v3tv,
                R.id.f3s6v4tv,
                R.id.f3s6v5tv,
                R.id.f3s6v6tv,
                R.id.f3s6v7tv,
                R.id.f3s6v8tv
        };
        final int[] radioIds = new int[]
                {
                        R.id.f3s6v1,
                        R.id.f3s6v2,
                        R.id.f3s6v3,
                        R.id.f3s6v4,
                        R.id.f3s6v5,
                        R.id.f3s6v6,
                        R.id.f3s6v7,
                        R.id.f3s6v8
                };
        for (int a = 0; a < radioIds.length; a++) {
            radioGroups[a] = (RadioGroup) findViewById(radioIds[a]);
            textViews[a] = (TextView) findViewById(textViewId[a]);

            radioGroups[a].setTag(a);
        }


        Button next = (Button) findViewById(R.id.f3s6_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag_final = true;

                for (int i = 0; i < radioIds.length; i++) {
                    if (radioGroups[i].getCheckedRadioButtonId() <= 0) {
                        flag_final = false;
                        textViews[i].setError("");
                    } else {
                        textViews[i].setError(null);
                    }
                }


                if (flag_final) {
                    Radiogroupchecker radiogroupchecker = new Radiogroupchecker(F3Q6.this);
                    String[] rad = radiogroupchecker.Radd(radioGroups);

                    // TODO: 9/23/2017 start insert to database

                    al.clear();
                    for (String a : rad) {

                        al.add(a);
                    }

                    // TODO: 9/23/2017 end insert to database


                    startActivity(new Intent(F3Q6.this, F3Q7.class));

                }
                else
                {
                    Toast.makeText(F3Q6.this, "لطفا تمامی فیلد ها را بررسی کنید.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
