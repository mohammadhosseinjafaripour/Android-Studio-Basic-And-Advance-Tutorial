package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s2 extends AppCompatActivity {
    final CheckBox[] checkboxes = new CheckBox[16];
    final String[] ides = new String[16];
    int[] resID = new int[16];
    int cn = 0;
    int count = 0;
    ArrayList<String> al = new ArrayList<String>();
    private TextView f4s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s2);

        final int[] iii = new int[]
                {
                        R.id.f4s2v1,
                        R.id.f4s2v2,
                        R.id.f4s2v3,
                        R.id.f4s2v4,
                        R.id.f4s2v5,
                        R.id.f4s2v6,
                        R.id.f4s2v7,
                        R.id.f4s2v8,
                        R.id.f4s2v9,
                        R.id.f4s2v10,
                        R.id.f4s2v11,
                        R.id.f4s2v12,
                        R.id.f4s2v13,
                        R.id.f4s2v14,
                        R.id.f4s2v15,
                        R.id.f4s2v16
                };

        final CheckBox[] checkBoxList = new CheckBox[iii.length];

        String[] cs = getResources().getStringArray(R.array.checkboxesitems);
        final String[] priorty = {"1", "2", "2", "4", "5", "6","7","8","9","10","11","12","13","14","15","16"};

        ArrayList<String> a_1 = new ArrayList<String>(Arrays.asList(cs));
        ArrayList<String> b_1 = new ArrayList<String>(Arrays.asList(priorty));

        long seed = System.nanoTime()+12;
        Collections.shuffle(a_1, new Random(seed));
        Collections.shuffle(b_1, new Random(seed));

        String[] a__1  = new String[a_1.size()];
        final String []b__1=new String[b_1.size()];

        for (int f = 0; f <a_1.size(); f++) {
            a__1[f] = a_1.get(f).toString();
            b__1[f] = b_1.get(f).toString();

        }


        for (int i = 0; i < iii.length; i++) {
            checkBoxList[i] = (CheckBox) findViewById(iii[i]);
            checkBoxList[i].setText(a__1[i]);
            checkBoxList[i].setTag(i);
        }

        final ArrayList<String> answers = new ArrayList<String>();

        for (int t = 0; t < iii.length; t++) {
            checkBoxList[t] = (CheckBox) findViewById(iii[t]);
            //checkBoxList[t].setText(a__1[t]);

            final int finalI = t;
            checkBoxList[t].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cn < 10 && checkBoxList[finalI].isChecked()) {
                        answers.add(priorty[finalI]);
                        cn++;
                        al.add(b__1[cn]);
                        //Toast.makeText(activity_f4s2.this, Integer.toString(cn) + b__1[finalI], Toast.LENGTH_SHORT).show();

                    } else if (cn <= 10 && !checkBoxList[finalI].isChecked()) {
                        answers.remove(b__1[finalI]);
                        cn--;
                        al.remove(b__1[cn]);
                        //Toast.makeText(activity_f4s2.this, Integer.toString(cn) + b__1[cn], Toast.LENGTH_SHORT).show();
                    } else if (cn >= 10) {
                        checkBoxList[finalI].setChecked(false);
                        Toast.makeText(activity_f4s2.this, "ماکزیمم 10 مورد", Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }
        Button btn = (Button) findViewById(R.id.f4s2_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cn == 10) {

                    // TODO: 9/28/2017 insert to db

                    al.clear();
                    al= answers;
                    // TODO: 9/28/2017  end of insert to db
                    Intent intent = new Intent(activity_f4s2.this, activity_f4s3.class);
                    startActivity(intent);
                } else {
                    f4s2 = (TextView) findViewById(R.id.f4s2);
                    f4s2.setError("");
                    Toast.makeText(activity_f4s2.this, "لطفا 10 مورد انتخاب کنید ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}