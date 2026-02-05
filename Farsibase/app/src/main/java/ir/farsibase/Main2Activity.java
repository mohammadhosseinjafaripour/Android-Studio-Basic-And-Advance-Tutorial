package ir.farsibase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    int cn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String[] a = getResources().getStringArray(R.array.F2S22_1);
        final ArrayList<String> a_1 = new ArrayList<String>(Arrays.asList(a));

        String[] b = {"checkBox1", "checkBox2", "checkBox3", "checkBox4", "checkBox5", "checkBox6"};
        final String[] priorty = {"1", "2", "2", "4", "5", "6",};

        final String selected_pririty[] = new String[20];


        ArrayList<String> b_1 = new ArrayList<String>(Arrays.asList(b));

        final int[] i = new int[]
                {
                        R.id.checkBox1,
                        R.id.checkBox2,
                        R.id.checkBox3,
                        R.id.checkBox4,
                        R.id.checkBox5,
                        R.id.checkBox6
                };

        long seed = System.nanoTime()+12;
        Collections.shuffle(a_1, new Random(seed));
        Collections.shuffle(b_1, new Random(seed));

        String[] a__1  = new String[a_1.size()];
        String []b__1=new String[b_1.size()];

        for (int f = 0; f <a_1.size(); f++) {
            a__1[f] = a_1.get(f).toString();
            b__1[f] = b_1.get(f).toString();

        }

        final CheckBox []ch = new CheckBox[20];
        int counter=0;
        for(int h=0;h<a_1.size();h++) {
                ch[h] = (CheckBox) findViewById(i[h]);
                ch[h].setText(a__1[h]);
            final int finalCounter = counter;

            ch[h].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ch[finalCounter].isChecked())
                    {

                        Toast.makeText(Main2Activity.this, "check is "+ch[finalCounter].getText().toString(), Toast.LENGTH_SHORT).show();
                        selected_pririty[finalCounter]=ch[finalCounter].getText().toString();
                        cn++;
                        Toast.makeText(Main2Activity.this, ""+cn, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        cn=0;
                        for(int i =0; i<a.length;i++)
                        {
                            ch[i].setChecked(false);

                        }
                        Toast.makeText(Main2Activity.this, "لطفا تمامی الویت ها را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            counter++;
        }








    }
}
