package ir.farsibase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s4 extends AppCompatActivity {

    Boolean flag_all=false;




    Boolean field_1 = false , field_2 = false;


    ArrayList<String> al=new ArrayList<String>();



    //first section validation
    Boolean all_0 = false;
    Boolean all_1 = false;
    Boolean all_2 = false;
    Boolean all_3 = false;
    Boolean all_5 = false;
    Boolean all_6 = false;
    Boolean all_7 = false;
    Boolean all_8 = false;


    //second section validation

    Boolean all0 = false;
    Boolean all1 = false;
    Boolean all2 = false;
    Boolean all3 = false;
    Boolean all5 = false;
    Boolean all6 = false;
    Boolean all7 = false;
    Boolean all8 = false;
    Boolean all9 = false;
    Boolean all10 = false;
    Boolean all11 = false;
    Boolean spbrand2 = false;
    Boolean spmodel2 = false;
    Boolean sptip2 = false;






    Boolean flag_car= false;
    Boolean flag_truck=false;



    Boolean flag_all0 = false;
    Boolean flag_all1=false;
    Boolean flag_all2=false;
    Boolean flag_all3=false;
    Boolean flag_all4=false;
    Boolean flag_all5=false;


    String flag = "0";
    int car;
    int truck;
    Spinner f1s4v2;
    Spinner f1s4v3;
    Spinner f1s4v4;
    Boolean spbrand1 = false;
    Boolean spmodel1 = false;
    Boolean sptip1 = false;

    String result_f1s4v1="";
    String result_f1s4v12="";
    String result_f1s4v23="";
    String result_f1s4v9="";
    String result_f1s4v20="";
    String result_f1s4v31="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s4);
        final SharedPreferences.Editor editor=getSharedPreferences("State",MODE_PRIVATE).edit();



        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);


        SharedPreferences preferences =getSharedPreferences("State",MODE_PRIVATE);
        if(preferences!=null) {
            String c = preferences.getString("car", "");
            String t = preferences.getString("truck", "");
            car = Integer.parseInt(c);
            truck = Integer.parseInt(t);
            View vs = (View)viewGroup.findViewById(R.id.linman_hidden);
            View vs1 = (View)viewGroup.findViewById(R.id.linman_hidden2);
            View vs2 = (View)viewGroup.findViewById(R.id.linman_hidden3);


            /*final EditText ef1s4v9 = (EditText)findViewById(R.id.f1s4v9);
            final TextView price = (TextView)findViewById(R.id.price_f1s4v1);
            final convertinttotext in = new convertinttotext();
            ef1s4v9.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {
                        int finalprice = Integer.parseInt(ef1s4v9.getText().toString()) * 1000000;
                        price.setText(in.convertNumberToWords(finalprice));
                    }
                    catch (Exception e)
                    {

                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });*/


//            if(car>0)
//            {
//                flag="s1";
//                vs.setVisibility(View.VISIBLE);
//                if(truck>0)
//                {
//                    flag="2sv";
//                    vs1.setVisibility(View.VISIBLE);
//                }
//            }
//            else if(truck>0)
//            {
//                flag="1v";
//                vs.setVisibility(View.VISIBLE);
//            }
//            else if( car+ truck>2)
//            {
//              //  vs2.setVisibility();
//            }

            if(car>0)
            {
                flag="s1";
                vs.setVisibility(View.VISIBLE);

            }
            if(truck>0)
            {
                flag="1v";
                vs1.setVisibility(View.VISIBLE);
            }
            if(car+truck>2)
            {
                flag="2sv";
                vs2.setVisibility(View.VISIBLE);

            }


        }



        final RadioGroup f1s4v1 =(RadioGroup)findViewById(R.id.f1s4v1);

        final RadioButton radioButton4 =(RadioButton)findViewById(R.id.f1s4v1_1);
        final RadioButton radioButton5 =(RadioButton)findViewById(R.id.f1s4v1_2);
        final RadioButton radioButton6 =(RadioButton)findViewById(R.id.f1s4v1_3);
        final RadioButton radioButton7 =(RadioButton)findViewById(R.id.f1s4v1_4);
        f1s4v1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                radioButton4.setError(null);
                switch (checkedId)
                {
                    case R.id.f1s4v1_1:

                        String [] array = getResources().getStringArray(R.array.company);
                        f1s4v2 = (Spinner)findViewById(R.id.f1s4v2);
                        f1s4v3 = (Spinner)findViewById(R.id.f1s4v3);
                        f1s4v4 = (Spinner)findViewById(R.id.f1s4v4);
                        result_f1s4v1 = radioButton4.getHint().toString();

                        break;
                    case R.id.f1s4v1_2:
                        result_f1s4v1 = radioButton5.getHint().toString();
                        break;
                    case R.id.f1s4v1_3:
                        result_f1s4v1 = radioButton6.getHint().toString();
                        break;
                    case R.id.f1s4v1_4:
                        result_f1s4v1 = radioButton7.getHint().toString();
                        break;
                }
            }
        });



        final RadioGroup f1s4v9 = (RadioGroup)findViewById(R.id.f1s4v9);
        final RadioButton rb1 = (RadioButton)findViewById(R.id.f1s4v9_1);
        final RadioButton rb2 = (RadioButton)findViewById(R.id.f1s4v9_2);


        f1s4v9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s4v9_1 :
                        rb1.getText();
                        rb1.getHint();
                        //all_4=true;

                        break;
                    case R.id.f1s4v9_2:
                        rb2.getHint();
                        rb2.getHint();
                        //all_4=true;
                        break;

                }
            }
        });

        final Spinner f1s4v10 = (Spinner)findViewById(R.id.f1s4v10);
        final String [] f1s4v_13 = getResources().getStringArray(R.array.fuel);
        ArrayAdapter snprAdapter6 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_13);
        f1s4v10.setAdapter(snprAdapter6);
        f1s4v10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v10.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Spinner f1s4v11 = (Spinner)findViewById(R.id.f1s4v11);
        final String [] f1s4v_11 = getResources().getStringArray(R.array.type);
        ArrayAdapter snprAdapter7 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_11);
        f1s4v11.setAdapter(snprAdapter7);
        f1s4v11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v11.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //section 2

        final RadioGroup radiogroup_section2 = (RadioGroup) findViewById(R.id.f1s4v12);
        final RadioButton rb_section1 = (RadioButton)findViewById(R.id.f1s4v12_1);
        final RadioButton rb_section2 = (RadioButton)findViewById(R.id.f1s4v12_2);
        final RadioButton rb_section3 = (RadioButton)findViewById(R.id.f1s4v12_3);
        final RadioButton rb_section4 = (RadioButton)findViewById(R.id.f1s4v12_4);

        final String result_2 ;

        radiogroup_section2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s4v12_1:
                      //  result_2 = rb_section1.getText().toString();
                        result_f1s4v12 = rb_section1.getHint().toString();
                        break;
                    case R.id.f1s4v12_2:
                        result_f1s4v12 = rb_section2.getHint().toString();
                        break;
                    case R.id.f1s4v12_3:
                        result_f1s4v12 = rb_section3.getHint().toString();
                        break;
                    case R.id.f1s4v12_4:
                        result_f1s4v12 = rb_section4.getHint().toString();
                        break;
                }
            }
        });

        final Spinner f1s4v13 = (Spinner)findViewById(R.id.f1s4v13);
        final String [] f1s4v_16 = getResources().getStringArray(R.array.brand);
        ArrayAdapter snprAdapt = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_16);
        f1s4v13.setAdapter(snprAdapt);

        f1s4v13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
            {
                String result  = f1s4v13.getSelectedItem().toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        final Spinner f1s4v14 = (Spinner)findViewById(R.id.f1s4v14);
        final String [] f1s4v_14 = getResources().getStringArray(R.array.model);
        ArrayAdapter snprAdapter17 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_14);
        f1s4v14.setAdapter(snprAdapter17);
        f1s4v14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v14.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner f1s4v15 = (Spinner)findViewById(R.id.f1s4v15);
        final String [] f1s4v_15 = getResources().getStringArray(R.array.tip);
        ArrayAdapter snprAdapter9 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_15);
        f1s4v15.setAdapter(snprAdapter9);
        f1s4v15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v15.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final RadioGroup f1s4v20 = (RadioGroup)findViewById(R.id.f1s4v20);
        final RadioButton rab1 = (RadioButton)findViewById(R.id.f1s4v20_1);
        final RadioButton rab2 = (RadioButton)findViewById(R.id.f1s4v20_2);


        f1s4v20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s4v20_1 :
                        rab1.getText();
                        rab1.getHint();
                        break;
                    case R.id.f1s4v20_2:
                        rab2.getHint();
                        rab2.getHint();
                        break;

                }
            }
        });


        final Spinner f1s4v21 = (Spinner)findViewById(R.id.f1s4v21);
        final String [] f1s4v_21 = getResources().getStringArray(R.array.fuel);
        ArrayAdapter snprAdapter10 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_21);
        f1s4v21.setAdapter(snprAdapter10);
        f1s4v21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v21.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Spinner f1s4v22 = (Spinner)findViewById(R.id.f1s4v22);
        final String [] f1s4v_22 = getResources().getStringArray(R.array.type);
        ArrayAdapter snprAdapter11 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_22);
        f1s4v22.setAdapter(snprAdapter11);
        f1s4v22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v22.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //section 3

        RadioGroup section3_radiogroup = (RadioGroup)findViewById(R.id.f1s4v23);
        RadioButton rb_section3_1 = (RadioButton)findViewById(R.id.f1s4v23_1);
        RadioButton rb_section3_2 = (RadioButton)findViewById(R.id.f1s4v23_2);
        RadioButton rb_section3_3 = (RadioButton)findViewById(R.id.f1s4v23_3);
        RadioButton rb_section3_4 = (RadioButton)findViewById(R.id.f1s4v23_4);
        section3_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s4v23_1:
                        break;
                    case R.id.f1s4v23_2:
                        break;
                    case R.id.f1s4v23_3:
                        break;
                    case R.id.f1s4v23_4:
                        break;


                }
            }
        });

        final Spinner f1s4v24 = (Spinner)findViewById(R.id.f1s4v24);
        final String [] f1s4v_24 = getResources().getStringArray(R.array.brand);
        ArrayAdapter snprA = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_24);
        f1s4v24.setAdapter(snprA);

        f1s4v24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
            {
                String result  = f1s4v24.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Spinner f1s4v25 = (Spinner)findViewById(R.id.f1s4v25);
        final String [] f1s4v_25 = getResources().getStringArray(R.array.model);
        ArrayAdapter snprAdapter29 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_25);
        f1s4v25.setAdapter(snprAdapter29);
        f1s4v25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v25.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner f1s4v26 = (Spinner)findViewById(R.id.f1s4v26);
        final String [] f1s4v_26 = getResources().getStringArray(R.array.tip);
        ArrayAdapter snprAdapterArrayAdapter = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_26);
        f1s4v26.setAdapter(snprAdapterArrayAdapter);
        f1s4v26.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v26.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final RadioGroup f1s4v31 = (RadioGroup)findViewById(R.id.f1s4v31);
        final RadioButton rbg1 = (RadioButton)findViewById(R.id.f1s4v31_1);
        final RadioButton rbg2 = (RadioButton)findViewById(R.id.f1s4v31_2);


        f1s4v31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s4v31_1 :
                        rbg1.getText();
                        rbg1.getHint();
                        break;
                    case R.id.f1s4v31_2:
                        rbg2.getHint();
                        rbg2.getHint();
                        break;

                }
            }
        });

        final Spinner f1s4v32 = (Spinner)findViewById(R.id.f1s4v32);
        final String [] f1s4v_32 = getResources().getStringArray(R.array.fuel);
        ArrayAdapter snprAdapter65 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_32);
        f1s4v32.setAdapter(snprAdapter65);
        f1s4v32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v32.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner f1s4v33 = (Spinner)findViewById(R.id.f1s4v33);
        final String [] f1s4v_33 = getResources().getStringArray(R.array.type);
        ArrayAdapter snprAdapter48 = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,f1s4v_33);
        f1s4v33.setAdapter(snprAdapter48);
        f1s4v33.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f1s4v33.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        // first section adpater
        final Spinner typeoffuel = (Spinner)findViewById(R.id.f1s4v10);
        String [] fuel = getResources().getStringArray(R.array.fuel);
        ArrayAdapter snp = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,fuel);
        typeoffuel.setAdapter(snp);

        final Spinner spgirbox = (Spinner)findViewById(R.id.f1s4v11);
        String [] girbox = getResources().getStringArray(R.array.type);
        ArrayAdapter sn = new ArrayAdapter(f1s4.this, R.layout.support_simple_spinner_dropdown_item,girbox);
        spgirbox.setAdapter(sn);

        //


        Button btnclick = (Button)findViewById(R.id.f1s4v7___);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText f1s4v5 = (EditText)findViewById(R.id.f1s4v5);
                EditText f1s4v6 = (EditText)findViewById(R.id.f1s4v6);
                EditText f1s4v7 = (EditText)findViewById(R.id.f1s4v7);
                EditText f1s4v8 = (EditText)findViewById(R.id.f1s4v8);

                //section 2
                EditText f1s4v16 = (EditText)findViewById(R.id.f1s4v16);
                EditText f1s4v17 = (EditText) findViewById(R.id.f1s4v17);
                EditText f1s4v18 = (EditText)findViewById(R.id.f1s4v18);
                EditText f1s4v19 = (EditText)findViewById(R.id.f1s4v19);
                //section 3
                EditText f1s4v27 = (EditText)findViewById(R.id.f1s4v27);
                EditText f1s4v28 = (EditText)findViewById(R.id.f1s4v28);
                EditText f1s4v29 = (EditText)findViewById(R.id.f1s4v29);
                EditText f1s4v30 = (EditText)findViewById(R.id.f1s4v30);

                RadioGroup f1s4v23 = (RadioGroup)findViewById(R.id.f1s4v23);
                final RadioButton f1s4v23_1 = (RadioButton)findViewById(R.id.f1s4v23_1);
                final RadioButton f1s4v23_2 = (RadioButton)findViewById(R.id.f1s4v23_2);
                final RadioButton f1s4v23_3 = (RadioButton)findViewById(R.id.f1s4v23_3);
                final RadioButton f1s4v23_4 = (RadioButton)findViewById(R.id.f1s4v23_4);

                f1s4v23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        switch (checkedId)
                        {
                            case R.id.f1s4v23_1:
                                result_f1s4v23 = f1s4v23_1.getHint().toString();
                                break;
                            case R.id.f1s4v23_2:
                                result_f1s4v23 = f1s4v23_2.getHint().toString();
                                break;
                            case R.id.f1s4v23_3:
                                result_f1s4v23 = f1s4v23_3.getHint().toString();
                                break;
                            case R.id.f1s4v23_4:
                                result_f1s4v23 = f1s4v23_4.getHint().toString();
                                break;

                        }
                    }
                });





                    switch (flag)
                    {
                        case "s1":

                            TextView terror = (TextView)findViewById(R.id.textView24_f1s4verror);
                            if(f1s4v1.getCheckedRadioButtonId()<=0)
                            {
                                terror.setError("");
                                all_0 = false;
                            }
                            else
                            {
                                terror.setError(null);
                                all_0 = true;
                            }
                            try {
                                if (f1s4v2.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا برند را انتخاب نمایید", Toast.LENGTH_SHORT).show();
                                    spbrand1 = false;
                                } else {
                                    spbrand1 = true;
                                }

                                if (f1s4v3.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    spmodel1 = false;

                                } else {
                                    spmodel1 = true;
                                }
                                if (f1s4v4.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    sptip1 = false;

                                } else {
                                    sptip1 = true;
                                }
                            }
                            catch (Exception e)
                        {

                        }
                            if(f1s4v5.getText().toString().matches(""))
                            {
                                f1s4v5.setError("این فیلد الزامی است.");
                                all_1=false;
                            }
                            else if(f1s4v5.getText().length()<2)
                            {
                                f1s4v5.setError("سال را به درستی وارد کنید.");
                                all_1=false;
                            }
                            else
                            {
                                f1s4v5.getText();
                                all_1=true;

                               /* String temp = "13";
                                temp+=edt.getText().toString();
                                int current_car =13;
                                current_car += Integer.parseInt(temp);
                                editor.putInt("year_car",current_car);*/
                            }
                            if(f1s4v6.getText().toString().matches(""))
                            {
                                f1s4v6.setError("این فیلد الزامی است.");
                                all_2=false;
                            }
                            else if(!(Integer.parseInt(f1s4v6.getText().toString())>=1) || !(Integer.parseInt(f1s4v6.getText().toString())<=12))
                            {
                                f1s4v6.setError("ماه را به درستی وارد کنید.");
                                all_2=false;
                                f1s4v6.setText("00");
                            }
                            else
                            {
                                f1s4v6.getText();
                                all_2=true;
                            }
                            if(f1s4v7.getText().toString().matches(""))
                            {
                                f1s4v7.setError("این فیلد الزامی است.");
                                all_3=false;
                            }
                            else if(f1s4v7.getText().length()<2)
                            {
                                f1s4v7.setError("سال را به درستی وارد کنید.");
                                all_3=false;
                            }
                            else
                            {
                                f1s4v7.getText();
                                all_3=true;

                            }
                            if(f1s4v8.getText().toString().matches(""))
                            {
                                f1s4v8.setError("این فیلد الزامی است.");
                                all_5=false;
                            }
                            else
                            {
                                f1s4v8.getText();
                                all_5=true;
                            }
                            if(f1s4v9.getCheckedRadioButtonId()<=0)
                            {
                                rb1.setError("این فیلد الزامی است.");
                                all_6=false;
                            }
                            else
                            {
                                rb1.setError(null);
                                all_6=true;
                            }

                            if(typeoffuel.getSelectedItemPosition()==0)
                            {
                                Toast.makeText(f1s4.this, "لطفا نوع سوخت خودرو را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                all_7 = false;
                            }
                            else
                            {
                                all_7 = true;
                            }

                            if(spgirbox.getSelectedItemPosition()==0)
                            {
                                all_8 = false;
                            }
                            else
                            {
                                all_8 = true;
                            }

                            Toast.makeText(f1s4.this, ""+all_0 + all_1 + all_2 + all_3 + all_5 + all_6 + all_7 + all_8 + spmodel1 + sptip1 + spbrand1, Toast.LENGTH_LONG).show();
                            if(all_0 && all_1 && all_2 && all_3 && all_5 && all_6 && all_7 && all_8 && spmodel1 && sptip1 && spbrand1)
                            {
                                // start insert to database

                                String f1s4v1_str = result_f1s4v1;
                                String f1s4v2_str = Integer.toString(f1s4v2.getSelectedItemPosition()+1);
                                String f1s4v3_str =  Integer.toString(f1s4v3.getSelectedItemPosition()+1);
                                String f1s4v4_str =  Integer.toString(f1s4v4.getSelectedItemPosition()+1);
                                String f1s4v5_str = f1s4v5.getText().toString();
                                String f1s4v6_str =  f1s4v6.getText().toString();
                                String f1s4v7_str = f1s4v7.getText().toString();
                                String f1s4v8_str = f1s4v8.getText().toString();
                                String f1s4v9_str = (f1s4v9.getCheckedRadioButtonId()==R.id.f1s4v9_1)?"1":"2";
                                String f1s4v10_str = Integer.toString(f1s4v10.getSelectedItemPosition()+1);
                                String f1s4v11_str = Integer.toString(f1s4v11.getSelectedItemPosition());


                                al.add(f1s4v1_str);
                                al.add(f1s4v2_str);
                                al.add(f1s4v3_str);
                                al.add(f1s4v4_str);
                                al.add(f1s4v5_str);
                                al.add(f1s4v6_str);
                                al.add(f1s4v7_str);
                                al.add(f1s4v8_str);
                                al.add(f1s4v9_str);
                                al.add(f1s4v10_str);
                                al.add(f1s4v11_str);




                                // TODO: 9/22/2017  end insert to database




                                Intent i = new Intent(f1s4.this,f1s5.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(f1s4.this, "برخی از فیلد ها ناقص هستند !", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "1v":

                            if(radiogroup_section2.getCheckedRadioButtonId()<=0)
                            {
                                rb_section1.setError("");
                                all0 = false;
                            }
                            else
                            {
                                rb_section1.setError(null);
                                all0 = true;
                            }
                            if(f1s4v13.getSelectedItemPosition()==0)
                            {
                                all1 = false;
                                Toast.makeText(f1s4.this, "لطفا یک برند انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all1 = true;
                            }
                            if(f1s4v14.getSelectedItemPosition()==0)
                            {
                                all2 = false;
                                Toast.makeText(f1s4.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all2 = true;
                            }
                            if(f1s4v15.getSelectedItemPosition()==0)
                            {
                                Toast.makeText(f1s4.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                all3 = false;
                            }
                            else
                            {
                                all3 = true;
                            }

                            if(f1s4v16.getText().toString().matches(""))
                            {
                                all5 = false;
                            }
                            else if(f1s4v16.getText().length()<2)
                            {
                                f1s4v5.setError("سال را به درستی وارد کنید.");
                                all_1=false;
                            }
                            else
                            {
                                all5 = true;
                                f1s4v16.getText();
                            }

                            if(f1s4v17.getText().toString().matches(""))
                            {
                                all6 = false;
                                f1s4v17.setError("این فیلد الزامی است.");
                            }
                            else if(!(Integer.parseInt(f1s4v17.getText().toString())>=1) || !(Integer.parseInt(f1s4v17.getText().toString())<=12))
                            {
                                all6 = false;
                                f1s4v17.setError("لطفا ماه را بین 1 تا 12 انتخاب کنید.");
                            }
                            else
                            {
                                all6 = true;
                                f1s4v17.getText();
                            }
                            if(f1s4v18.getText().toString().matches(""))
                            {
                                all7 = false;
                                f1s4v18.setError("لطفا سال را به درستی وارد کنید.");
                            }
                            else
                            {
                                all7 = true;
                            }
                            if(f1s4v19.getText().toString().matches(""))
                            {
                                all8 = false;
                                f1s4v19.setError("این فیلد الزامی است.");
                            }
                            else
                            {
                                all8 = true;
                                f1s4v19.getText();
                            }
                            if(f1s4v20.getCheckedRadioButtonId()<=0)
                            {
                                rab1.setError("");
                                all9=false;
                            }
                            else {
                                rab1.setError(null);
                                all9=true;
                            }
                            if(f1s4v21.getSelectedItemPosition()==0)
                            {
                                all10 = false;
                                Toast.makeText(f1s4.this, "لطفا نوع سوخت خودرو را انتخاب کنید", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all10 = true;
                            }
                            if(f1s4v22.getSelectedItemPosition()==0)
                            {
                                all11 = false;
                                Toast.makeText(f1s4.this, "لطفا نوع گیربکس را مشخص کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all11 = true;
                            }
                            Toast.makeText(f1s4.this, ""+all0 + all1 + all2 + all3 + all5 + all6 + all7 + all8 + all9 + all10 + all11, Toast.LENGTH_LONG).show();

                            if(all0 && all1 && all2 && all3 && all5 && all6 && all7 && all8 && all9 && all10 && all11)
                            {

                                String f1s4v12_str = result_f1s4v12;
                                String f1s4v13_str = Integer.toString(f1s4v13.getSelectedItemPosition()+1);
                                String f1s4v14_str = Integer.toString(f1s4v14.getSelectedItemPosition()+1);
                                String f1s4v15_str = Integer.toString(f1s4v15.getSelectedItemPosition()+1);

                                String f1s4v16_str = f1s4v16.getText().toString();
                                String f1s4v17_str =  f1s4v17.getText().toString();
                                String f1s4v18_str = f1s4v18.getText().toString();
                                String f1s4v19_str = f1s4v19.getText().toString();
                                String f1s4v20_str = (f1s4v20.getCheckedRadioButtonId()==R.id.f1s4v9_1)?"1":"2";
                                String f1s4v21_str = Integer.toString(f1s4v21.getSelectedItemPosition()+1);
                                String f1s4v22_str = Integer.toString(f1s4v22.getSelectedItemPosition()+1);
                                al.add(f1s4v12_str);
                                al.add(f1s4v13_str);
                                al.add(f1s4v14_str);
                                al.add(f1s4v15_str);
                                al.add(f1s4v16_str);
                                al.add(f1s4v17_str);
                                al.add(f1s4v18_str);
                                al.add(f1s4v19_str);
                                al.add(f1s4v20_str);
                                al.add(f1s4v21_str);
                                al.add(f1s4v22_str);
                            Intent i = new Intent(f1s4.this,f1s5.class);
                            startActivity(i);
                            }
                            else
                                {
                            Toast.makeText(f1s4.this, "برخی از فیلد ها ناقص هستند !", Toast.LENGTH_SHORT).show();
                                }

                            break;
                        case "2sv":

                            //first


                            TextView terror1 = (TextView)findViewById(R.id.textView24_f1s4verror);
                            if(f1s4v1.getCheckedRadioButtonId()<=0)
                            {
                                terror1.setError("");
                                all_0 = false;
                            }
                            else
                            {
                                terror1.setError(null);
                                all_0 = true;
                            }
                            try {
                                if (f1s4v2.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا برند را انتخاب نمایید", Toast.LENGTH_SHORT).show();
                                    spbrand1 = false;
                                } else {
                                    spbrand1 = true;
                                }

                                if (f1s4v3.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    spmodel1 = false;

                                } else {
                                    spmodel1 = true;
                                }
                                if (f1s4v4.getSelectedItemPosition() == 0) {
                                    Toast.makeText(f1s4.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    sptip1 = false;

                                } else {
                                    sptip1 = true;
                                }
                            }
                            catch (Exception e)
                            {

                            }
                            if(f1s4v5.getText().toString().matches(""))
                            {
                                f1s4v5.setError("این فیلد الزامی است.");
                                all_1=false;
                            }
                            else if(f1s4v5.getText().length()<2)
                            {
                                f1s4v5.setError("سال را به درستی وارد کنید.");
                                all_1=false;
                            }
                            else
                            {
                                f1s4v5.getText();
                                all_1=true;

                               /* String temp = "13";
                                temp+=edt.getText().toString();
                                int current_car =13;
                                current_car += Integer.parseInt(temp);
                                editor.putInt("year_car",current_car);*/
                            }
                            if(f1s4v6.getText().toString().matches(""))
                            {
                                f1s4v6.setError("این فیلد الزامی است.");
                                all_2=false;
                            }
                            else if(!(Integer.parseInt(f1s4v6.getText().toString())>=1) || !(Integer.parseInt(f1s4v6.getText().toString())<=12))
                            {
                                f1s4v6.setError("ماه را به درستی وارد کنید.");
                                all_2=false;
                                f1s4v6.setText("00");
                            }
                            else
                            {
                                f1s4v6.getText();
                                all_2=true;
                            }
                            if(f1s4v7.getText().toString().matches(""))
                            {
                                f1s4v7.setError("این فیلد الزامی است.");
                                all_3=false;
                            }
                            else if(f1s4v7.getText().length()<2)
                            {
                                f1s4v7.setError("سال را به درستی وارد کنید.");
                                all_3=false;
                            }
                            else
                            {
                                f1s4v7.getText();
                                all_3=true;

                            }
                            if(f1s4v8.getText().toString().matches(""))
                            {
                                f1s4v8.setError("این فیلد الزامی است.");
                                all_5=false;
                            }
                            else
                            {
                                f1s4v8.getText();
                                all_5=true;
                            }
                            if(f1s4v9.getCheckedRadioButtonId()<=0)
                            {
                                rb1.setError("این فیلد الزامی است.");
                                all_6=false;
                            }
                            else
                            {
                                rb1.setError(null);
                                all_6=true;
                            }

                            if(typeoffuel.getSelectedItemPosition()==0)
                            {
                                Toast.makeText(f1s4.this, "لطفا نوع سوخت خودرو را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                all_7 = false;
                            }
                            else
                            {
                                all_7 = true;
                            }

                            if(spgirbox.getSelectedItemPosition()==0)
                            {
                                all_8 = false;
                            }
                            else
                            {
                                all_8 = true;
                            }

                            Toast.makeText(f1s4.this, ""+all_0 + all_1 + all_2 + all_3 + all_5 + all_6 + all_7 + all_8 + spmodel1 + sptip1 + spbrand1, Toast.LENGTH_LONG).show();
                            if(all_0 && all_1 && all_2 && all_3 && all_5 && all_6 && all_7 && all_8 && spmodel1 && sptip1 && spbrand1)
                            {
                                field_1 = true;
                            }
                            else
                            {
                                field_2 = false;
                            }

                            //

                            //second


                            if(radiogroup_section2.getCheckedRadioButtonId()<=0)
                            {
                                rb_section1.setError("");
                                all0 = false;
                            }
                            else
                            {
                                rb_section1.setError(null);
                                all0 = true;
                            }
                            if(f1s4v13.getSelectedItemPosition()==0)
                            {
                                all1 = false;
                                Toast.makeText(f1s4.this, "لطفا یک برند انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all1 = true;
                            }
                            if(f1s4v14.getSelectedItemPosition()==0)
                            {
                                all2 = false;
                                Toast.makeText(f1s4.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all2 = true;
                            }
                            if(f1s4v15.getSelectedItemPosition()==0)
                            {
                                Toast.makeText(f1s4.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                all3 = false;
                            }
                            else
                            {
                                all3 = true;
                            }

                            if(f1s4v16.getText().toString().matches(""))
                            {
                                all5 = false;
                            }
                            else if(f1s4v16.getText().length()<2)
                            {
                                f1s4v5.setError("سال را به درستی وارد کنید.");
                                all_1=false;
                            }
                            else
                            {
                                all5 = true;
                                f1s4v16.getText();
                            }

                            if(f1s4v17.getText().toString().matches(""))
                            {
                                all6 = false;
                                f1s4v17.setError("این فیلد الزامی است.");
                            }
                            else if(!(Integer.parseInt(f1s4v17.getText().toString())>=1) || !(Integer.parseInt(f1s4v17.getText().toString())<=12))
                            {
                                all6 = false;
                                f1s4v17.setError("لطفا ماه را بین 1 تا 12 انتخاب کنید.");
                            }
                            else
                            {
                                all6 = true;
                                f1s4v17.getText();
                            }
                            if(f1s4v18.getText().toString().matches(""))
                            {
                                all7 = false;
                                f1s4v18.setError("لطفا سال را به درستی وارد کنید.");
                            }
                            else
                            {
                                all7 = true;
                            }
                            if(f1s4v19.getText().toString().matches(""))
                            {
                                all8 = false;
                                f1s4v19.setError("این فیلد الزامی است.");
                            }
                            else
                            {
                                all8 = true;
                                f1s4v19.getText();
                            }
                            if(f1s4v20.getCheckedRadioButtonId()<=0)
                            {
                                rab1.setError("");
                                all9=false;
                            }
                            else {
                                rab1.setError(null);
                                all9=true;
                            }
                            if(f1s4v21.getSelectedItemPosition()==0)
                            {
                                all10 = false;
                                Toast.makeText(f1s4.this, "لطفا نوع سوخت خودرو را انتخاب کنید", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all10 = true;
                            }
                            if(f1s4v22.getSelectedItemPosition()==0)
                            {
                                all11 = false;
                                Toast.makeText(f1s4.this, "لطفا نوع گیربکس را مشخص کنید.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                all11 = true;
                            }
                            Toast.makeText(f1s4.this, ""+all0 + all1 + all2 + all3 + all5 + all6 + all7 + all8 + all9 + all10 + all11, Toast.LENGTH_LONG).show();

                            if(all0 && all1 && all2 && all3 && all5 && all6 && all7 && all8 && all9 && all10 && all11)
                            {
                                field_2 =true;
                            }
                            else
                            {
                                field_2 = false;
                            }

                            if(field_1&&field_2)
                            {
                                String f1s4v1_str = result_f1s4v1;
                                String f1s4v2_str = Integer.toString(f1s4v2.getSelectedItemPosition()+1);
                                String f1s4v3_str =  Integer.toString(f1s4v3.getSelectedItemPosition()+1);
                                String f1s4v4_str =  Integer.toString(f1s4v4.getSelectedItemPosition()+1);
                                String f1s4v5_str = f1s4v5.getText().toString();
                                String f1s4v6_str =  f1s4v6.getText().toString();
                                String f1s4v7_str = f1s4v7.getText().toString();
                                String f1s4v8_str = f1s4v8.getText().toString();
                                String f1s4v9_str = (f1s4v9.getCheckedRadioButtonId()==R.id.f1s4v9_1)?"1":"2";
                                String f1s4v10_str = Integer.toString(f1s4v10.getSelectedItemPosition()+1);
                                String f1s4v11_str = Integer.toString(f1s4v11.getSelectedItemPosition());
                                String f1s4v12_str = result_f1s4v12;
                                String f1s4v13_str = Integer.toString(f1s4v13.getSelectedItemPosition()+1);
                                String f1s4v14_str = Integer.toString(f1s4v14.getSelectedItemPosition()+1);
                                String f1s4v15_str = Integer.toString(f1s4v15.getSelectedItemPosition()+1);
                                String f1s4v16_str = f1s4v16.getText().toString();
                                String f1s4v17_str =  f1s4v17.getText().toString();
                                String f1s4v18_str = f1s4v18.getText().toString();
                                String f1s4v19_str = f1s4v19.getText().toString();
                                String f1s4v20_str = (f1s4v20.getCheckedRadioButtonId()==R.id.f1s4v9_1)?"1":"2";
                                String f1s4v21_str = Integer.toString(f1s4v21.getSelectedItemPosition()+1);
                                String f1s4v22_str = Integer.toString(f1s4v22.getSelectedItemPosition()+1);

                                String f1s4v23_str = result_f1s4v23;
                                String f1s4v24_str = Integer.toString(f1s4v24.getSelectedItemPosition()+1);
                                String f1s4v25_str = Integer.toString(f1s4v25.getSelectedItemPosition()+1);
                                String f1s4v26_str = Integer.toString(f1s4v26.getSelectedItemPosition()+1);
                                String f1s4v27_str = f1s4v27.getText().toString();
                                String f1s4v28_str =  f1s4v28.getText().toString();
                                String f1s4v29_str = f1s4v29.getText().toString();
                                String f1s4v30_str = f1s4v30.getText().toString();
                                String f1s4v31_str = (f1s4v31.getCheckedRadioButtonId()==R.id.f1s4v9_1)?"1":"2";
                                String f1s4v32_str = Integer.toString(f1s4v32.getSelectedItemPosition()+1);
                                String f1s4v33_str = Integer.toString(f1s4v33.getSelectedItemPosition()+1);



                                al.add(f1s4v1_str);
                                al.add(f1s4v2_str);
                                al.add(f1s4v3_str);
                                al.add(f1s4v4_str);
                                al.add(f1s4v5_str);
                                al.add(f1s4v6_str);
                                al.add(f1s4v7_str);
                                al.add(f1s4v8_str);
                                al.add(f1s4v9_str);
                                al.add(f1s4v10_str);
                                al.add(f1s4v11_str);
                                al.add(f1s4v12_str);
                                al.add(f1s4v13_str);
                                al.add(f1s4v14_str);
                                al.add(f1s4v15_str);
                                al.add(f1s4v16_str);
                                al.add(f1s4v17_str);
                                al.add(f1s4v18_str);
                                al.add(f1s4v19_str);
                                al.add(f1s4v20_str);
                                al.add(f1s4v21_str);
                                al.add(f1s4v22_str);

                                al.add(f1s4v23_str);
                                al.add(f1s4v24_str);
                                al.add(f1s4v25_str);
                                al.add(f1s4v26_str);
                                al.add(f1s4v27_str);
                                al.add(f1s4v28_str);
                                al.add(f1s4v29_str);
                                al.add(f1s4v30_str);
                                al.add(f1s4v31_str);
                                al.add(f1s4v32_str);
                                al.add(f1s4v33_str);

                                Intent  i = new Intent(f1s4.this,f1s5.class);
                                startActivity(i);
                            }
                            else
                            {

                            }

                            //year
                            f1s4v27.getText();
                            //month
                            f1s4v28.getText();
                            //sal sakht
                            f1s4v29.getText();
                            //bahaye kharid
                            f1s4v30.getText();
                            //mark / brand
                            f1s4v24.getSelectedItem().toString();
                            //model
                            f1s4v25.getSelectedItem().toString();
                            //tip
                            f1s4v26.getSelectedItem().toString();
                            //noe sokht
                            f1s4v32.getSelectedItem().toString();
                            //girbox
                            f1s4v33.getSelectedItem().toString();


                            //
                            break;
                    }


                    Toast.makeText(f1s4.this, ""+flag, Toast.LENGTH_SHORT).show();



                //SharedPreferences preferences =getSharedPreferences("State",MODE_PRIVATE);
                //Boolean state= preferences.getBoolean("car",false);
               // if(state.equals(true))
               // {

               // }
               /* else
                {
                    //do nothing :D
                }
                //section 3
                if(editText4.getText().toString().matches(""))
                {
                 editText4.setError("این فیلد الزامی است");
                }
                else {
                    editText4.getText();
                }
                if(editText5.getText().toString().matches(""))
                {
                    editText5.setError("این فیلد الزامی است.");
                }
                else
                {
                    editText5.getText();
                }
                if(editText6.getText().toString().matches(""))
                {
                    editText6.setError("این فیلد الزامی است.");
                }
                else
                {
                    editText6.getText();
                }
                if(editText7.getText().toString().matches(""))
                {
                    editText7.setError("این فیلد الزامی است.");
                }
                else
                {
                    editText7.getText();
                }
                if(radioGp.getCheckedRadioButtonId()<=0)
                {
                    rbg1.setError("این فیلد الزامی است.");
                }

                if(radioGroup1.getCheckedRadioButtonId()<=0)
                {
                    radioButton4.setError("این فیلد الزامی است.");
                }
                else
                {

                }*/






            }
        });




    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
