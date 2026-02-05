package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ir.rahnama.R;
import ir.rahnama.form1.convertinttotext;
import ir.rahnama.form1.dbHandler;
import ir.rahnama.yearChecker;
import ir.rahnama.yearcheckerforswitch;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q1 extends AppCompatActivity {

    Boolean[] check = new Boolean[8];

    ArrayList<String> arrayList = new ArrayList<String>();




    dbHandler db;


    List<String> list_temp_1;
    List<String> list_text_temp_1 = new ArrayList<String>();
    List<String> list_id_temp_1 = new ArrayList<String>();

    List<String> list_temp_2;
    List<String> list_text_temp_2 = new ArrayList<String>();
    List<String> list_id_temp_2 = new ArrayList<String>();

    List<String> list_temp_3;
    List<String> list_text_temp_3 = new ArrayList<String>();
    List<String> list_id_temp_3 = new ArrayList<String>();


    List<String> list_temp_4;
    List<String> list_text_temp_4 = new ArrayList<String>();
    List<String> list_id_temp_4 = new ArrayList<String>();

    List<String> list_temp_5;
    List<String> list_text_temp_5 = new ArrayList<String>();
    List<String> list_id_temp_5 = new ArrayList<String>();

    List<String> list_temp_6;
    List<String> list_text_temp_6 = new ArrayList<String>();
    List<String> list_id_temp_6 = new ArrayList<String>();

    List<String> s1_list;
    List<String> s1_list_text = new ArrayList<String>();
    List<String> s1_list_id = new ArrayList<String>();


    List<String> s2_list;
    List<String> s2_list_text = new ArrayList<String>();
    List<String> s2_list_id = new ArrayList<String>();

    List<String> s3_list;
    List<String> s3_list_text = new ArrayList<String>();
    List<String> s3_list_id = new ArrayList<String>();


    List<String> s4_list;
    List<String> s4_list_text = new ArrayList<String>();
    List<String> s4_list_id = new ArrayList<String>();


    List<String> s5_list;
    List<String> s5_list_text = new ArrayList<String>();
    List<String> s5_list_id = new ArrayList<String>();

    List<String> s6_list;
    List<String> s6_list_text = new ArrayList<String>();
    List<String> s6_list_id = new ArrayList<String>();




    String f3s1v1_id;
    String f3s1v2_id;
    String f3s1v3_id;

    String f3s1v9_id;
    String f3s1v10_id;
    String f3s1v11_id;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q1);






        final convertinttotext convertint =  new convertinttotext();
        final EditText c_F3S1V7 = (EditText) findViewById(R.id.F3S1V7);
        final TextView convert_F3S1V7 = (TextView)findViewById(R.id.convert_F3S1V7);
        c_F3S1V7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try
                {
                    convert_F3S1V7.setText(convertint.price_default(Integer.parseInt(s.toString())));
                }
                catch (Exception e)
                {
                    convert_F3S1V7.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        final EditText c_F3S1V15 = (EditText) findViewById(R.id.F3S1V15);

        final TextView convert_F3S1V15 = (TextView)findViewById(R.id.convert_F3S1V15);
        c_F3S1V15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try
                {
                    convert_F3S1V15.setText(convertint.price_default(Integer.parseInt(s.toString())));
                }
                catch (Exception e)
                {
                    convert_F3S1V15.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





        db = new dbHandler(getBaseContext());







        final Spinner sp_F3S1V1 = (Spinner) findViewById(R.id.F3S1V1);
        final Spinner sp_F3S1V2 = (Spinner) findViewById(R.id.F3S1V2);
        final Spinner sp_F3S1V3 = (Spinner) findViewById(R.id.F3S1V3);


        final ArrayAdapter<String> adapter1  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s1_list_text );
        final ArrayAdapter<String> adapter2  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s2_list_text );
        final ArrayAdapter<String> adapter3  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s3_list_text );




        list_temp_1 = db.viewRowTip("1");
        Set<String> setidbrand = new HashSet<String>();

        list_id_temp_1.clear();
        list_text_temp_1.clear();


        for (String da : list_temp_1) {
            String[] words = da.split("#%");
            setidbrand.add(words[2]);//arr id brand for sql query
            list_id_temp_1.add(words[3]);// arr id model
            list_text_temp_1.add(words[4]);// arr tip name
        }

        list_temp_1.clear();

        s1_list = db.viewRowBrand(setidbrand);
        setidbrand.clear();

        s1_list_text.clear();
        s1_list_id.clear();

        s1_list_text.add("انتخاب کنید");
        s1_list_id.add("0");

        for (String da : s1_list) {
            String[] words = da.split("#%");
            s1_list_id.add(words[0]);
            s1_list_text.add(words[2]);
        }
        s1_list.clear();

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V2.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();


        final Spinner sp_F3S1V9 = (Spinner) findViewById(R.id.F3S1V9);
        final Spinner sp_F3S1V10 = (Spinner) findViewById(R.id.F3S1V10);
        final Spinner sp_F3S1V11 = (Spinner) findViewById(R.id.F3S1V11);





        final ArrayAdapter<String> adapter4  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s4_list_text );
        final ArrayAdapter<String> adapter5  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s5_list_text );
        final ArrayAdapter<String> adapter6  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s6_list_text );





        list_temp_2 = db.viewRowTip("1");
        Set<String> setidbrand2 = new HashSet<String>();

        list_id_temp_2.clear();
        list_text_temp_2.clear();


        for (String da : list_temp_2) {
            String[] words = da.split("#%");
            setidbrand2.add(words[2]);//arr id brand for sql query
            list_id_temp_2.add(words[3]);// arr id model
            list_text_temp_2.add(words[4]);// arr tip name
        }

        list_temp_2.clear();

        s4_list = db.viewRowBrand(setidbrand2);
        setidbrand2.clear();

        s4_list_text.clear();
        s4_list_id.clear();

        s4_list_text.add("انتخاب کنید");
        s4_list_id.add("0");

        for (String da : s4_list) {
            String[] words = da.split("#%");
            s4_list_id.add(words[0]);
            s4_list_text.add(words[2]);
        }
        s4_list.clear();

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V10.setAdapter(adapter4);
        adapter4.notifyDataSetChanged();

        //Show all brand -1
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V1.setAdapter(adapter1);
        sp_F3S1V1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {

                    String id1 = s1_list_id.get(position);

                    f3s1v1_id = id1;

                    s2_list = db.viewRowModel_savari(f3s1v1_id);

                    s2_list_id.clear();
                    s2_list_text.clear();
                    s2_list_text.add("انتخاب کنید.");
                    s2_list_id.add("0");

                    for (String da : s2_list) {
                        //valuesword.put("id", "");
                        String[] words = da.split("#%");
                        s2_list_id.add(words[0]);
                        s2_list_text.add("مدل "+words[1]);
                    }
                    s2_list.clear();

                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_F3S1V2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                } else {
                    sp_F3S1V2.setAdapter(null);
                    sp_F3S1V3.setAdapter(null);
                    String [] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_2  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V2.setAdapter(adapter_2);
                    adapter_2.notifyDataSetChanged();
                    ArrayAdapter<String> adapter_3  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V3.setAdapter(adapter_3);
                    adapter_3.notifyDataSetChanged();

                    //s3.setAdapter(null);
                    //phone_code.setText("");
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Show model -1
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V2.setAdapter(adapter2);
        sp_F3S1V2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                if(position > 0) {
                    String idmodel = s2_list_id.get(position);
                    f3s1v2_id = idmodel;
                    s3_list = db.nametip(f3s1v2_id);//brand id

                    s3_list_id.clear();
                    s3_list_text.clear();

                    s3_list_text.add("انتخاب کنید");
                    s3_list_id.add("0");

                    for (String da : s3_list) {
                        String[] words = da.split("#%");
                        s3_list_id.add(words[0]);
                        s3_list_text.add(" تیپ " + words[1]);
                    }
                    s3_list.clear();

                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_F3S1V3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();
                }else{
                    sp_F3S1V3.setAdapter(null);
                    String [] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_3  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V3.setAdapter(adapter_3);
                    adapter_3.notifyDataSetChanged();
                }


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //show tip name -1
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V3.setAdapter(adapter3);
        sp_F3S1V3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    f3s1v3_id = s3_list_id.get(position);
                    //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                    //Toast.makeText(f1s4.this, "ty="+type_id+"--bra="+brand_id+"--mod="+model_id+"--tip="+tip_id, Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });














        //Show all brand -1
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V9.setAdapter(adapter4);
        sp_F3S1V9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {
                    String id1 = s4_list_id.get(position);

                    f3s1v9_id = id1;

                    s5_list = db.viewRowModel_savari(f3s1v9_id);

                    s5_list_id.clear();
                    s5_list_text.clear();
                    s5_list_text.add("انتخاب کنید.");
                    s5_list_id.add("0");

                    for (String da : s5_list) {
                        //valuesword.put("id", "");
                        String[] words = da.split("#%");
                        s5_list_id.add(words[0]);
                        s5_list_text.add("مدل "+words[1]);
                    }
                    s5_list.clear();

                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_F3S1V10.setAdapter(adapter5);
                    adapter5.notifyDataSetChanged();
                } else {
                    sp_F3S1V10.setAdapter(null);
                    sp_F3S1V11.setAdapter(null);
                    String [] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_10  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V10.setAdapter(adapter_10);
                    adapter_10.notifyDataSetChanged();
                    ArrayAdapter<String> adapter_11  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V11.setAdapter(adapter_11);
                    adapter_11.notifyDataSetChanged();
                    //s3.setAdapter(null);
                    //phone_code.setText("");
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Show model -1
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V10.setAdapter(adapter5);
        sp_F3S1V10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                if(position > 0) {
                    String idmodel = s5_list_id.get(position);
                    f3s1v10_id = idmodel;
                    s6_list = db.nametip(f3s1v10_id);//brand id

                    s6_list_id.clear();
                    s6_list_text.clear();

                    s6_list_text.add("انتخاب کنید");
                    s6_list_id.add("0");

                    for (String da : s6_list) {
                        String[] words = da.split("#%");
                        s6_list_id.add(words[0]);
                        s6_list_text.add(" تیپ " + words[1]);
                    }
                    s6_list.clear();

                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_F3S1V11.setAdapter(adapter6);
                    adapter6.notifyDataSetChanged();
                }else{
                    sp_F3S1V11.setAdapter(null);
                    String [] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_11  = new ArrayAdapter<String>(F3Q1.this, android.R.layout.simple_spinner_item, select );
                    sp_F3S1V11.setAdapter(adapter_11);
                    adapter_11.notifyDataSetChanged();
                }


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //show tip name -1
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_F3S1V11.setAdapter(adapter6);
        sp_F3S1V11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    f3s1v11_id = s6_list_id.get(position);
                    //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                    //Toast.makeText(f1s4.this, "ty="+type_id+"--bra="+brand_id+"--mod="+model_id+"--tip="+tip_id, Toast.LENGTH_LONG).show();

                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });














        final EditText ed_F3S1V4 = (EditText) findViewById(R.id.F3S1V4); //year
        final EditText ed_F3S1V5 = (EditText) findViewById(R.id.F3S1V5); //month
        final EditText ed_F3S1V6 = (EditText) findViewById(R.id.F3S1V6); //create year
        final EditText ed_F3S1V7 = (EditText) findViewById(R.id.F3S1V7);

        final EditText ed_F3S1V12 = (EditText) findViewById(R.id.F3S1V12); //year
        final EditText ed_F3S1V13 = (EditText) findViewById(R.id.F3S1V13); //month
        final EditText ed_F3S1V14 = (EditText) findViewById(R.id.F3S1V14); //create year
        final EditText ed_F3S1V15 = (EditText) findViewById(R.id.F3S1V15);

        final RadioGroup rg_F3S1V8 = (RadioGroup) findViewById(R.id.F3S1V8);
        final RadioGroup rg_F3S1V16 = (RadioGroup) findViewById(R.id.F3S1V16);


        final TextView tv_1 = (TextView) findViewById(R.id.F3S1_tv1);
        final TextView tv_2 = (TextView) findViewById(R.id.F3S1_tv2);


        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yearcheckerforswitch checker = new yearcheckerforswitch(F3Q1.this);
                int mode = 0 ;
                if(sp_F3S1V9.getSelectedItemPosition()!=0||
                        sp_F3S1V10.getSelectedItemPosition()!=0||
                        sp_F3S1V11.getSelectedItemPosition()!=0 ||
                        !ed_F3S1V12.getText().toString().matches("")||
                        !ed_F3S1V13.getText().toString().matches("")||
                        !ed_F3S1V14.getText().toString().matches("")||
                        !ed_F3S1V15.getText().toString().matches(""))
                {
                    mode  = 2 ;
                 //   Toast.makeText(F3Q1.this, "mode2", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mode = 1 ;
                  //  Toast.makeText(F3Q1.this, "mode1", Toast.LENGTH_SHORT).show();
                }

                switch (mode)
                {
                    case 1 :
                        boolean flag_final= true;
                        if (sp_F3S1V1.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            flag_final = false;
                        }
                        else if (sp_F3S1V2.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final = false;
                        }
                        else if (sp_F3S1V3.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            flag_final = false;
                        }
                        else if (ed_F3S1V4.getText().toString().matches("")) {
                            ed_F3S1V4.setError("این فیلد الزامی است");
                        }else if (Integer.parseInt(ed_F3S1V4.getText().toString()) <50) {
                            ed_F3S1V4.setError("لطفا بزرگتر از 50 وارد کنید");
                        } else if (ed_F3S1V5.getText().toString().matches("")) {
                            ed_F3S1V5.setError("این فیلد الزامی است");
                        }else if (Integer.parseInt(ed_F3S1V5.getText().toString()) <00 || Integer.parseInt(ed_F3S1V5.getText().toString()) >12) {
                            ed_F3S1V5.setError("لطفا از 1 تا 12 وارد کنید");
                        }else if (ed_F3S1V6.getText().toString().matches("")) {
                            ed_F3S1V6.setError("این فیلد الزامی است");
                        } else if (Integer.parseInt(ed_F3S1V6.getText().toString()) <50) {
                            ed_F3S1V6.setError("لطفا بزرگتر از 50 وارد کنید");
                        }else if (ed_F3S1V7.getText().toString().matches("")) {
                            ed_F3S1V7.setError("این فیلد الزامی است");
                        } else if (rg_F3S1V8.getCheckedRadioButtonId() < 0) {
                            tv_1.setError("");
                        }

                        else {
                            if (flag_final) {
                                // TODO: 9/23/2017 start insert to database

                                arrayList.clear();
                                arrayList.add(Integer.toString(sp_F3S1V1.getSelectedItemPosition() + 1));
                                arrayList.add(Integer.toString(sp_F3S1V2.getSelectedItemPosition() + 1));
                                arrayList.add(Integer.toString(sp_F3S1V3.getSelectedItemPosition() + 1));
                                arrayList.add(ed_F3S1V4.getText().toString());
                                arrayList.add(ed_F3S1V5.getText().toString());
                                arrayList.add(ed_F3S1V6.getText().toString());
                                arrayList.add(ed_F3S1V7.getText().toString());
                                arrayList.add((rg_F3S1V8.getCheckedRadioButtonId() == R.id.F3S1V8_1) ? "0" : "1");

                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");


                                // TODO: 9/23/2017 end insert to database

                                startActivity(new Intent(F3Q1.this, F3Q2.class));


                            }
                        }

                        break;
                    case 2 :
                        boolean flag_final2= true;
                        if (sp_F3S1V1.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                            flag_final2 = false;
                        }
                        if (sp_F3S1V2.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final2 = false;
                        }
                        if (sp_F3S1V3.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final2 = false;
                        }
                        if (sp_F3S1V9.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final2 = false;
                        }
                        if (sp_F3S1V10.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final2 = false;
                        }
                        if (sp_F3S1V11.getSelectedItemPosition() == 0) {
                            Toast.makeText(F3Q1.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                            flag_final2 = false;
                        }



                        if (ed_F3S1V4.getText().toString().matches("")) {
                            ed_F3S1V4.setError("این فیلد الزامی است");
                        }else if (Integer.parseInt(ed_F3S1V4.getText().toString()) <50) {
                            ed_F3S1V4.setError("لطفا بزرگتر از 50 وارد کنید");
                        } else if (ed_F3S1V5.getText().toString().matches("")) {
                            ed_F3S1V5.setError("این فیلد الزامی است");
                        }else if (Integer.parseInt(ed_F3S1V5.getText().toString()) <1 || Integer.parseInt(ed_F3S1V5.getText().toString()) >12) {
                            ed_F3S1V5.setError("لطفا از 1 تا 12 وارد کنید");
                        } else if (checker.checkbig(ed_F3S1V4.getText().toString(),ed_F3S1V6.getText().toString())) {
                            Toast.makeText(F3Q1.this, "سال ساخت خودرو و سال خرید مقایرت دارند", Toast.LENGTH_SHORT).show();
                        }
                        else if (ed_F3S1V6.getText().toString().matches("")) {
                            ed_F3S1V6.setError("این فیلد الزامی است");
                        } else if (Integer.parseInt(ed_F3S1V6.getText().toString()) <50) {
                            ed_F3S1V6.setError("لطفا بزرگتر از 50 وارد کنید");
                        }else if (ed_F3S1V7.getText().toString().matches("")) {
                            ed_F3S1V7.setError("این فیلد الزامی است");
                        } else if (rg_F3S1V8.getCheckedRadioButtonId() < 0) {
                            tv_1.setError("");
                        } else if (ed_F3S1V12.getText().toString().matches("")) {
                            ed_F3S1V12.setError("این فیلد الزامی است");
                        }else if (Integer.parseInt(ed_F3S1V12.getText().toString()) <50) {
                            ed_F3S1V12.setError("لطفا بزرگتر از 50 وارد کنید");
                        } else if (ed_F3S1V13.getText().toString().matches("")) {
                            ed_F3S1V13.setError("این فیلد الزامی است");
                        } else if (Integer.parseInt(ed_F3S1V13.getText().toString()) <00 || Integer.parseInt(ed_F3S1V13.getText().toString()) >12) {
                            ed_F3S1V13.setError("لطفا از 1 تا 12 وارد کنید");
                        }else if (ed_F3S1V14.getText().toString().matches("")) {
                            ed_F3S1V14.setError("این فیلد الزامی است");
                        } else if (checker.checkbig(ed_F3S1V12.getText().toString(),ed_F3S1V14.getText().toString())) {
                            Toast.makeText(F3Q1.this, "سال ساخت خودرو و سال خرید مقایرت دارند", Toast.LENGTH_SHORT).show();
                        } else if (Integer.parseInt(ed_F3S1V14.getText().toString()) <50) {
                            ed_F3S1V14.setError("لطفا بزرگتر از 50 وارد کنید");
                        } else if (ed_F3S1V15.getText().toString().matches("")) {
                            ed_F3S1V15.setError("این فیلد الزامی است");
                        } else if (rg_F3S1V16.getCheckedRadioButtonId() < 0) {
                            tv_2.setError("");
                        }


                        else {


                            if (flag_final2){
                                // TODO: 9/23/2017 start insert to database

                                arrayList.clear();
                                arrayList.add(f3s1v1_id);
                                arrayList.add(f3s1v2_id);
                                arrayList.add(f3s1v3_id);
                                arrayList.add(ed_F3S1V4.getText().toString());
                                arrayList.add(ed_F3S1V5.getText().toString());
                                arrayList.add(ed_F3S1V6.getText().toString());
                                arrayList.add(ed_F3S1V7.getText().toString());
                                arrayList.add((rg_F3S1V8.getCheckedRadioButtonId()==R.id.F3S1V8_1)?"0":"1");

                                arrayList.add(f3s1v9_id);
                                arrayList.add(f3s1v10_id);
                                arrayList.add(f3s1v11_id);
                                arrayList.add(ed_F3S1V12.getText().toString());
                                arrayList.add(ed_F3S1V13.getText().toString());
                                arrayList.add(ed_F3S1V14.getText().toString());
                                arrayList.add(ed_F3S1V15.getText().toString());
                                arrayList.add((rg_F3S1V16.getCheckedRadioButtonId()==R.id.F3S1V16_1)?"0":"1");


                                // TODO: 9/23/2017 end insert to database

//                    MyDebug myDebug = new MyDebug(F3Q1.this, arrayList);

                                startActivity(new Intent(F3Q1.this, F3Q2.class));
                            }
                        }
                        break;
                }



            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
