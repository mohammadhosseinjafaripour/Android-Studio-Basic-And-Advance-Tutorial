package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
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

public class F3Q12 extends AppCompatActivity {

    private RadioGroup rg;
    private boolean Ischeck = false;
    private ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q12);


        final convertinttotext convertint =  new convertinttotext();
        final EditText c_F3S12V1 = (EditText)findViewById(R.id.F3S12V1);
        final TextView convert_F3S12V1 = (TextView)findViewById(R.id.convert_F3S12V1);
        c_F3S12V1.addTextChangedListener(new TextWatcher() {
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
                        c_F3S12V1.setError("خطا در ورود داده");
                        c_F3S12V1.setText("");
                    }
                    else {
                        convert_F3S12V1.setText(convertint.price_default(Integer.parseInt(s.toString())));
                    }
                }
                catch (Exception e)
                {
                    convert_F3S12V1.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






       /* final EditText ed = (EditText) findViewById(R.id.F3S12V1);

        rg= (RadioGroup) findViewById(R.id.F3S12V2);

        final TextView tv = (TextView) findViewById(R.id.F3S12);
        final Button btn= (Button) findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId()<=0)
                {
                    tv.setError("");
                }else if(ed.getText().toString().matches("")){
                    ed.setError("این فیلد الزامی است");
                }
                else
                {
                    Toast.makeText(F3Q12.this, "send", Toast.LENGTH_SHORT).show();
                }


            }


        });
*/











        final EditText ed = (EditText) findViewById(R.id.F3S12V1);
        final int[] radiobuttonId = new int[]
                {
                        R.id.F3S12V2_1,
                        R.id.F3S12V2_2,
                        R.id.F3S12V2_3,
                        R.id.F3S12V2_4,
                        R.id.F3S12V2_5,
                        R.id.F3S12V2_6,
                        R.id.F3S12V2_7,
                        R.id.F3S12V2_8,
                        R.id.F3S12V2_9
                };


        rg = (RadioGroup) findViewById(R.id.F3S12V2);


        final TextView tv = (TextView) findViewById(R.id.F3S12);
        final Button btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag_final = true;
                Ischeck = true;

                if (ed.getText().toString().matches("")) {
                    Ischeck = false;
                    ed.setError("این فیلد الزامی است");
                }

                if (rg.getCheckedRadioButtonId() < 0) {
                    tv.setError("");
                    Ischeck = false;
                } else {
                    tv.setError(null);
                }

                if (Ischeck) {
                    float fee = Float.parseFloat(ed.getText().toString());
                    if (fee < 1 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_1) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;
                    } else if (fee >= 1000000 && fee < 1500000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_2) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 1500000 && fee < 2000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_3) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 2000000 && fee < 3000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_4) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 3000000 && fee < 5000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_5) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 5000000 && fee < 7000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_6) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 7000000 && fee < 10000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_7) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 10000000 && fee < 20000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_8) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >=20000000 && rg.getCheckedRadioButtonId() != R.id.F3S12V2_9){
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else{
                        if (flag_final){
                            // TODO: 9/23/2017 start insert to database

                            arrayList.clear();
                            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                            arrayList.add(ed.getText().toString());
                            arrayList.add(rb.getHint().toString());

                            Intent i = new Intent(F3Q12.this,_start_03.class);
                            startActivity(i);


                            // TODO: 9/23/2017 end insert to database



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
