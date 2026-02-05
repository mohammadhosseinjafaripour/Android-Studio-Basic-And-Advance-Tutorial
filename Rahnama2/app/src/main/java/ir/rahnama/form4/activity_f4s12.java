package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.rahnama.R;
import ir.rahnama.form0._start_03;
import ir.rahnama.form1.convertinttotext;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s12 extends AppCompatActivity {



    Boolean Ischeck=false;
    TextView tv;
    private RadioGroup radios;


    RadioGroup[] f4s12v2 = new RadioGroup[1];
    EditText f4s12v1;
    String f4s12v2_text="";
    TextView tv1;
    Boolean radiobol=false,edbol=false;
    String[] GBResult;
    Radiogroupchecker rgd = new Radiogroupchecker(this);

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s12);

        final convertinttotext convertint =  new convertinttotext();
        final EditText c_f4s12v1 = (EditText)findViewById(R.id.f4s12v1);
        final TextView convert_f4s12v1 = (TextView)findViewById(R.id.convert_f4s12v1);
        c_f4s12v1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try
                {
                    String check = s.toString();
                    if(check.startsWith("0")&&count==1)
                    {
                        c_f4s12v1.setError("خطا در ورود داده");
                        c_f4s12v1.setText("");
                    }
                    else {
                        convert_f4s12v1.setText(convertint.price_default(Integer.parseInt(s.toString())));

                    }
                }
                catch (Exception e)
                {
                    convert_f4s12v1.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        final SharedPreferences.Editor editor = getSharedPreferences("typecarmodel",MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        editor.apply();



        tv= (TextView) findViewById(R.id.f4s12);


        final EditText ed = (EditText) findViewById(R.id.f4s12v1);
        final int[] radiobuttonId = new int[]
                {
                        R.id.f4s12v2_1,
                        R.id.f4s12v2_2,
                        R.id.f4s12v2_3,
                        R.id.f4s12v2_4,
                        R.id.f4s12v2_5,
                        R.id.f4s12v2_6,
                        R.id.f4s12v2_7,
                        R.id.f4s12v2_8,
                        R.id.f4s12v2_9
                };
        int raidioIds=R.id.f4s12v2;

        radios= (RadioGroup) findViewById(raidioIds);


        final Button btn= (Button) findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag_final = true;


                for(int a=0;a<1;a++)
                {
                    if(radios.getCheckedRadioButtonId()<0)
                    {
                        tv.setError("");
                        Ischeck=false;
                    }
                    else
                    {
                        tv.setError(null);
                        Ischeck=true;
                    }
                    if(ed.getText().toString().matches(""))
                    {
                        Ischeck=false;
                        ed.setError("این فیلد الزامی است");
                    }
                }
                if(Ischeck)
                {


                    float fee = Float.parseFloat(ed.getText().toString());
                    if (fee < 1000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_1) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;
                    } else if (fee >= 1000000 && fee < 1500000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_2) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 1500000 && fee < 2000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_3) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 2000000 && fee < 3000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_4) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 3000000 && fee < 5000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_5) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 5000000 && fee < 7000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_6) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 7000000 && fee < 10000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_7) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 10000000 && fee < 20000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_8) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >=20000000 && radios.getCheckedRadioButtonId() != R.id.f4s12v2_9){
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else{
                        if (flag_final){
                            // TODO: 9/23/2017 start insert to database

                            al.clear();
                            RadioButton rb = (RadioButton) findViewById(radios.getCheckedRadioButtonId());
                            al.add(ed.getText().toString());
                            al.add(rb.getHint().toString());


                            // TODO: 9/23/2017 end insert to database

                            //end
                            Intent i = new Intent(activity_f4s12.this,_start_03.class);
                            startActivity(i);

                        }
                    }

                }
            }


        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}