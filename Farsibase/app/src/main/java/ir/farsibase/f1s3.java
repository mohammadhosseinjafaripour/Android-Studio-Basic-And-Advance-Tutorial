package ir.farsibase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s3 extends AppCompatActivity {

    String flag = "0";

    Boolean all_1 = false;
    Boolean all_2 = false;
    Boolean all_3 = false;
    Boolean all_4 = false;

    ArrayList<String> al=new ArrayList<String>();
    dbHandler db;
    String last_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s3);

        //db = new dbHandler(getBaseContext());
        //last_id = db.GetLastIdRow();




        final RadioGroup f1s3v1 = (RadioGroup) findViewById(R.id.f1s3v1);
        final LinearLayout yes3lin = (LinearLayout)findViewById(R.id.yes3lin) ;
        final LinearLayout no3lin = (LinearLayout)findViewById(R.id.no3lin) ;
        final RadioButton yes = (RadioButton)findViewById(R.id.f1s3v1_1);
        final RadioButton no = (RadioButton)findViewById(R.id.f1s3v1_2);

        final RadioGroup f1s3v5 = (RadioGroup)findViewById(R.id.f1s3v5);
        final RadioButton chboxyes3 =(RadioButton) findViewById(R.id.f1s3v5_1);
        final RadioButton chboxno3 = (RadioButton) findViewById(R.id.f1s3v5_2);
        Button checkbtn = (Button)findViewById(R.id.checkbtn3);
        final EditText edtcar3 = (EditText)findViewById(R.id.f1s3v3);
        final EditText edttruck3 = (EditText)findViewById(R.id.f1s3v4);


        f1s3v1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.f1s3v1_1:
                        yes3lin.setVisibility(View.VISIBLE);
                        flag="1";
                        yes.getText();
                        if(no3lin.getVisibility() == View.VISIBLE)
                        {
                            no3lin.setVisibility(View.GONE);
                        }
                        break;
                    case R.id.f1s3v1_2:
                        no3lin.setVisibility(View.VISIBLE);
                        flag = "2";
                        no.getText();
                        if(yes3lin.getVisibility()==View.VISIBLE)
                        {
                            yes3lin.setVisibility(View.GONE);
                        }
                        break;
                }
            }
        });

        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.f1s3v5_1);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.f1s3v5_2);

        f1s3v5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s3v5_1:
                        radioButton1.getHint();
                        break;
                    case R.id.f1s3v5_2:
                        radioButton2.getHint();
                        break;

                }
            }
        });


        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txerror = (TextView)findViewById(R.id.textView_error_res);
                TextView texterror = (TextView)findViewById(R.id.text_error12_View13);
                TextView terror = (TextView)findViewById(R.id.textVie_error_w15);




                if(flag=="1") {
                    txerror.setError(null);
                    if (edtcar3.getText().toString().matches("") && edttruck3.getText().toString().matches("")) {
                        texterror.setError("حداقل یکی از فیلد های زیر را پر کنید.");
                    } else if (!edtcar3.getText().toString().matches("") || !edttruck3.getText().toString().matches("")) {
                        edtcar3.getText();
                        edttruck3.getText();
                        txerror.setError(null);

                        if(edtcar3.getText().toString().matches(""))
                        {
                            edtcar3.setText("0");
                        }
                        if(edttruck3.getText().toString().matches(""))
                        {
                            edttruck3.setText("0");
                        }
                        SharedPreferences.Editor editor=getSharedPreferences("State",MODE_PRIVATE).edit();
                        editor.putString("car",edtcar3.getText().toString());
                        editor.putString("truck",edttruck3.getText().toString());
                        editor.apply();

                        //start insert to database

                        String f1s3v3 = edtcar3.getText().toString();
                        String f1s3v4 = edttruck3.getText().toString();

                        al.add("1");
                        al.add(f1s3v3);
                        al.add(f1s3v4);

                        //end insert to database

                        Intent i = new Intent(f1s3.this,f1s4.class);
                        startActivity(i);
                    }
                }
                else if(flag=="2") {
                    txerror.setError(null);
                    if(!chboxno3.isChecked()&& !chboxyes3.isChecked())
                    {
                        terror.setError("لطفا یک فیلد را انتخاب کنید.");
                    }
                    else
                    {
                        if(chboxno3.isChecked()) {
                            chboxno3.getHint();
                        }
                        else if (chboxyes3.isChecked()) {
                            chboxyes3.getHint();
                        }
                        else
                        {
                            chboxno3.getHint();
                            chboxyes3.getHint();
                        }

                        // start insert to database
                        al.add("2");
                        al.add((f1s3v5.getCheckedRadioButtonId()==R.id.f1s3v5_1)?"1":"2");

                        // end insert to database
                        Intent in = new Intent(f1s3.this,f1s6.class);
                        startActivity(in);
                    }

                }
                else
                {
                    txerror.setError("حداقل یکی از فیلد های زیر را انتخاب کنید.");
                }
            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
