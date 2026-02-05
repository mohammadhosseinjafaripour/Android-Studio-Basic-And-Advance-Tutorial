package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import ir.rahnama.form1.convertinttotext;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q10 extends AppCompatActivity {

    private RadioGroup rg;
    private boolean Ischeck = false;
    private ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q10);


        final EditText ed = (EditText) findViewById(R.id.F3S10V1);
        final convertinttotext convertint =  new convertinttotext();
        final TextView convert_F3S10V1 = (TextView)findViewById(R.id.convert_F3S10V1);
        ed.addTextChangedListener(new TextWatcher() {
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
                        ed.setError("خطا در ورود داده");
                        ed.setText("");
                    }
                    else {
                        convert_F3S10V1.setText(convertint.price_default(Integer.parseInt(s.toString())));
                    }
                }
                catch (Exception e)
                {
                    convert_F3S10V1.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        rg = (RadioGroup) findViewById(R.id.F3S10V2);


        final TextView tv = (TextView) findViewById(R.id.F3S10);
        final Button btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ischeck = true;

                boolean flag_final = true;


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

                    if (fee < 1000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_1) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;
                    } else if (fee >= 1000000 && fee < 1500000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_2) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 1500000 && fee < 2000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_3) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 2000000 && fee < 3000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_4) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >= 3000000 && fee < 5000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_5) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 5000000 && fee < 7000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_6) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 7000000 && fee < 10000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_7) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else if (fee >= 10000000 && fee < 20000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_8) {
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    } else if (fee >=20000000 && rg.getCheckedRadioButtonId() != R.id.F3S10V2_9){
                        ed.setError("بازه درست را انتخاب کنید");
                        flag_final = false;

                    }else{
                        if (flag_final){
                            // TODO: 9/23/2017 start insert to database

                            arrayList.clear();
                            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                            arrayList.add(ed.getText().toString());
                            arrayList.add(rb.getHint().toString());


                            // TODO: 9/23/2017 end insert to database



                            Intent intent = new Intent(F3Q10.this, F3Q11.class);
                            startActivity(intent);
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
