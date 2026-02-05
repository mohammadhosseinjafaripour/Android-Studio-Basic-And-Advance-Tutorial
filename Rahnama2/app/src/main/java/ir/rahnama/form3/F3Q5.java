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

public class F3Q5 extends AppCompatActivity {

    final ArrayList<String> al = new ArrayList<String>();
    private RadioGroup[] radioGroups = new RadioGroup[50];
    private TextView[] textViews = new TextView[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q5);


        int[] textViewId = new int[]{
                R.id.f3s5v1tv,
                R.id.f3s5v2tv,
                R.id.f3s5v3tv,
                R.id.f3s5v4tv,
                R.id.f3s5v5tv,
                R.id.f3s5v6tv,
                R.id.f3s5v7tv,
                R.id.f3s5v8tv,
                R.id.f3s5v9tv,
                R.id.f3s5v10tv,
                R.id.f3s5v11tv,
                R.id.f3s5v12tv,
                R.id.f3s5v13tv,
                R.id.f3s5v14tv,
                R.id.f3s5v15tv,
                R.id.f3s5v16tv,
                R.id.f3s5v17tv,
                R.id.f3s5v18tv,
                R.id.f3s5v19tv,
                R.id.f3s5v20tv,
                R.id.f3s5v21tv,
                R.id.f3s5v22tv,
                R.id.f3s5v23tv,
                R.id.f3s5v24tv,
                R.id.f3s5v25tv,
                R.id.f3s5v26tv,
                R.id.f3s5v27tv,
                R.id.f3s5v28tv,
                R.id.f3s5v29tv,
                R.id.f3s5v30tv,
                R.id.f3s5v31tv,
                R.id.f3s5v32tv,
                R.id.f3s5v33tv,
                R.id.f3s5v34tv,
                R.id.f3s5v35tv,
                R.id.f3s5v36tv,
                R.id.f3s5v37tv,
                R.id.f3s5v38tv,
                R.id.f3s5v39tv,
                R.id.f3s5v40tv,
                R.id.f3s5v41tv,
                R.id.f3s5v42tv,
                R.id.f3s5v43tv,
                R.id.f3s5v44tv,
                R.id.f3s5v45tv,
                R.id.f3s5v46tv,
                R.id.f3s5v47tv,
                R.id.f3s5v48tv,
                R.id.f3s5v49tv,
                R.id.f3s5v50tv,
        };
        final int[] radioIds = new int[]
                {
                        R.id.f3s5v1,
                        R.id.f3s5v2,
                        R.id.f3s5v3,
                        R.id.f3s5v4,
                        R.id.f3s5v5,
                        R.id.f3s5v6,
                        R.id.f3s5v7,
                        R.id.f3s5v8,
                        R.id.f3s5v9,
                        R.id.f3s5v10,
                        R.id.f3s5v11,
                        R.id.f3s5v12,
                        R.id.f3s5v13,
                        R.id.f3s5v14,
                        R.id.f3s5v15,
                        R.id.f3s5v16,
                        R.id.f3s5v17,
                        R.id.f3s5v18,
                        R.id.f3s5v19,
                        R.id.f3s5v20,
                        R.id.f3s5v21,
                        R.id.f3s5v22,
                        R.id.f3s5v23,
                        R.id.f3s5v24,
                        R.id.f3s5v25,
                        R.id.f3s5v26,
                        R.id.f3s5v27,
                        R.id.f3s5v28,
                        R.id.f3s5v29,
                        R.id.f3s5v30,
                        R.id.f3s5v31,
                        R.id.f3s5v32,
                        R.id.f3s5v33,
                        R.id.f3s5v34,
                        R.id.f3s5v35,
                        R.id.f3s5v36,
                        R.id.f3s5v37,
                        R.id.f3s5v38,
                        R.id.f3s5v39,
                        R.id.f3s5v40,
                        R.id.f3s5v41,
                        R.id.f3s5v42,
                        R.id.f3s5v43,
                        R.id.f3s5v44,
                        R.id.f3s5v45,
                        R.id.f3s5v46,
                        R.id.f3s5v47,
                        R.id.f3s5v48,
                        R.id.f3s5v49,
                        R.id.f3s5v50
                };
        for (int a = 0; a < radioIds.length; a++) {
            radioGroups[a] = (RadioGroup) findViewById(radioIds[a]);
            textViews[a] = (TextView) findViewById(textViewId[a]);

            radioGroups[a].setTag(a);
        }


        Button next = (Button) findViewById(R.id.f3s5_next);
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
                    Radiogroupchecker radiogroupchecker = new Radiogroupchecker(F3Q5.this);
                    String[] rad = radiogroupchecker.Radd(radioGroups);

                    // TODO: 9/23/2017 start insert to database

                    al.clear();
                    for (String a : rad) {

                        al.add(a);
                    }

                    // TODO: 9/23/2017 end insert to database


                    startActivity(new Intent(F3Q5.this, F3Q6.class));

                }
                else{
                    Toast.makeText(F3Q5.this, "لطفا تمامی فیلد ها را بررسی کنید.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
