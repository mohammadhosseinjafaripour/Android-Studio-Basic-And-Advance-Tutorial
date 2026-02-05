

package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

import ir.rahnama.R;
import ir.rahnama.form1.convertinttotext;
import ir.rahnama.form1.dbHandler;
import ir.rahnama.form3.F3Q1;
import ir.rahnama.yearChecker;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s1 extends AppCompatActivity {
    Boolean bol = true;
    RadioGroup[] radioGroups = new RadioGroup[4];
    RadioGroup[] radioGroups2 = new RadioGroup[3];
    String[] GBResult;
    String[] GBResult2;
    ArrayList<String> al = new ArrayList<String>();
    //_________PART 1_______________
    EditText f4s1v4, f4s1v5, f4s1v9;
    String f4s1v4_text = "", f4s1v5_text = "", f4s1v9_text = "";
    RadioGroup f4s1v6, f4s1v7, f4s1v8, f4s1v10;
    TextView P1_tv1, P1_tv2, P1_tv3, P1_tv4;
    Boolean[] P1_flags = new Boolean[8];
    Boolean P1_flag2 = false;
    //_____________PART 2_________________
    EditText f4s1v14, f4s1v15;
    String f4s1v14_text = "", f4s1v15_text = "";
    RadioGroup f4s1v16, f4s1v17, f4s1v18;
    TextView P2_tv1, P2_tv2, P2_tv3;
    Boolean[] P2_flags = new Boolean[5];
    Boolean P2_flag2 = false;
    Boolean ALl = false;
    Radiogroupchecker rgd = new Radiogroupchecker(this);
    Radiogroupchecker rgd2 = new Radiogroupchecker(this);
    Boolean spinner1bool = false, spinner2bool = false, spinner3bool = false, Allspinnerbool = false;
    Boolean spinner4bool = false, spinner5bool = false, spinner6bool = false, Allspinnerbool2 = false;

    Spinner f4s1v1, f4s1v2, f4s1v3;
    Spinner f4s1v11, f4s1v12, f4s1v13;


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


    String f4s1v1_id;
    String f4s1v2_id;
    String f4s1v3_id;

    String f4s1v11_id;
    String f4s1v12_id;
    String f4s1v13_id;


    TextView error_f4s1v1, error_f4s1v2, error_f4s1v3, error_f4s1v11, error_f4s1v12, error_f4s1v13;


    int [] year = {93,94,95,96};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s1);


        error_f4s1v1 = (TextView) findViewById(R.id.error_f4s1v1);
        error_f4s1v2 = (TextView) findViewById(R.id.error_f4s1v2);
        error_f4s1v3 = (TextView) findViewById(R.id.error_f4s1v3);

        error_f4s1v11 = (TextView) findViewById(R.id.error_f4s1v11);
        error_f4s1v12 = (TextView) findViewById(R.id.error_f4s1v12);
        error_f4s1v13 = (TextView) findViewById(R.id.error_f4s1v13);


        final convertinttotext convertint = new convertinttotext();
        final EditText c_f4s1v9 = (EditText) findViewById(R.id.f4s1v9);
        final TextView convert_f4s1v9 = (TextView) findViewById(R.id.convert_f4s1v9);
        c_f4s1v9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    convert_f4s1v9.setText(convertint.price_default(Integer.parseInt(s.toString())));
                } catch (Exception e) {
                    convert_f4s1v9.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //Register SharedPreference
        final SharedPreferences.Editor editor = getSharedPreferences("typecarmodel", MODE_PRIVATE).edit();


        db = new dbHandler(getBaseContext());

        s1_list = db.viewAllBrand_savari();
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


        s4_list = db.viewAllBrand_savari();
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


        int[] radiogroupsIds = new int[]
                {
                        R.id.f4s1v6,
                        R.id.f4s1v7,
                        R.id.f4s1v8,
                        R.id.f4s1v10,
                };
        int[] radiogroupsIds2 = new int[]
                {
                        R.id.f4s1v16,
                        R.id.f4s1v17,
                        R.id.f4s1v18,
                };
        for (int i = 0; i < 4; i++) {
            radioGroups[i] = (RadioGroup) findViewById(radiogroupsIds[i]);
        }

        for (int i = 0; i < 3; i++) {
            radioGroups2[i] = (RadioGroup) findViewById(radiogroupsIds2[i]);
        }

        for (int i = 0; i < 8; i++) {
            P1_flags[i] = false;
        }
        for (int i = 0; i < 5; i++) {
            P2_flags[i] = false;
        }

        //___________________PART 1_________________

        f4s1v1 = (Spinner) findViewById(R.id.f4s1v1);
        f4s1v2 = (Spinner) findViewById(R.id.f4s1v2);
        f4s1v3 = (Spinner) findViewById(R.id.f4s1v3);


        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s1_list_text);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s2_list_text);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s3_list_text);


        //Show all brand -1
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s1v1.setAdapter(adapter1);
        f4s1v1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {
                    String id1 = s1_list_id.get(position);

                    f4s1v1_id = id1;

                    s2_list = db.viewRowModel_savari(f4s1v1_id);

                    s2_list_id.clear();
                    s2_list_text.clear();
                    s2_list_text.add("انتخاب کنید.");
                    s2_list_id.add("0");

                    for (String da : s2_list) {
                        //valuesword.put("id", "");
                        String[] words = da.split("#%");
                        s2_list_id.add(words[0]);
                        s2_list_text.add("مدل " + words[1]);
                    }
                    s2_list.clear();

                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s1v2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                } else {
                    f4s1v2.setAdapter(null);
                    f4s1v3.setAdapter(null);
                    String[] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v2.setAdapter(adapter_2);
                    adapter_2.notifyDataSetChanged();
                    ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v3.setAdapter(adapter_3);
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
        f4s1v2.setAdapter(adapter2);
        f4s1v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                if (position > 0) {
                    String idmodel = s2_list_id.get(position);
                    f4s1v2_id = idmodel;
                    s3_list = db.nametip(f4s1v2_id);//brand id

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
                    f4s1v3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();
                } else {
                    f4s1v3.setAdapter(null);
                    String[] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v3.setAdapter(adapter_3);
                    adapter_3.notifyDataSetChanged();
                }


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //show tip name -1
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s1v3.setAdapter(adapter3);
        f4s1v3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    f4s1v3_id = s3_list_id.get(position);
                    //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                    //Toast.makeText(f1s4.this, "ty="+type_id+"--bra="+brand_id+"--mod="+model_id+"--tip="+tip_id, Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        f4s1v4 = (EditText) findViewById(R.id.f4s1v4);
        f4s1v5 = (EditText) findViewById(R.id.f4s1v5);
        f4s1v9 = (EditText) findViewById(R.id.f4s1v9);

        f4s1v6 = (RadioGroup) findViewById(R.id.f4s1v6);
        f4s1v7 = (RadioGroup) findViewById(R.id.f4s1v7);
        f4s1v8 = (RadioGroup) findViewById(R.id.f4s1v8);
        f4s1v10 = (RadioGroup) findViewById(R.id.f4s1v10);

        P1_tv1 = (TextView) findViewById(R.id.P1_rg1_error);
        P1_tv2 = (TextView) findViewById(R.id.P1_rg2_error);
        P1_tv3 = (TextView) findViewById(R.id.P1_rg3_error);
        P1_tv4 = (TextView) findViewById(R.id.P1_rg4_error);
        //______________PART 2_______________________

        f4s1v11 = (Spinner) findViewById(R.id.f4s1v11);
        f4s1v12 = (Spinner) findViewById(R.id.f4s1v12);
        f4s1v13 = (Spinner) findViewById(R.id.f4s1v13);


        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s4_list_text);
        final ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s5_list_text);
        final ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s6_list_text);


        //Show all brand -1
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s1v11.setAdapter(adapter4);
        f4s1v11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {
                    String id1 = s4_list_id.get(position);

                    f4s1v11_id = id1;

                    s5_list = db.viewRowModel_savari(f4s1v11_id);

                    s5_list_id.clear();
                    s5_list_text.clear();
                    s5_list_text.add("انتخاب کنید.");
                    s5_list_id.add("0");

                    for (String da : s5_list) {
                        //valuesword.put("id", "");
                        String[] words = da.split("#%");
                        s5_list_id.add(words[0]);
                        s5_list_text.add("مدل " + words[1]);
                    }
                    s5_list.clear();

                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s1v12.setAdapter(adapter5);
                    adapter5.notifyDataSetChanged();
                } else {
                    f4s1v12.setAdapter(null);
                    f4s1v13.setAdapter(null);
                    String[] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v12.setAdapter(adapter_2);
                    adapter_2.notifyDataSetChanged();
                    ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v13.setAdapter(adapter_3);
                    adapter_3.notifyDataSetChanged();
                    //s3.setAdapter(null);
                    //phone_code.setText("");
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Show model -1
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s1v12.setAdapter(adapter5);
        f4s1v12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                if (position > 0) {
                    String idmodel = s5_list_id.get(position);
                    f4s1v12_id = idmodel;
                    s6_list = db.nametip(f4s1v12_id);//brand id

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
                    f4s1v13.setAdapter(adapter6);
                    adapter6.notifyDataSetChanged();
                } else {
                    f4s1v13.setAdapter(null);
                    String[] select = getResources().getStringArray(R.array.select);
                    ArrayAdapter<String> adapter_3 = new ArrayAdapter<String>(activity_f4s1.this, android.R.layout.simple_spinner_item, select);
                    f4s1v13.setAdapter(adapter_3);
                    adapter_3.notifyDataSetChanged();
                }


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //show tip name -1
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s1v13.setAdapter(adapter6);
        f4s1v13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {

                    f4s1v13_id = s6_list_id.get(position);
                    //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                    //Toast.makeText(f1s4.this, "ty="+type_id+"--bra="+brand_id+"--mod="+model_id+"--tip="+tip_id, Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        f4s1v14 = (EditText) findViewById(R.id.f4s1v14);
        f4s1v15 = (EditText) findViewById(R.id.f4s1v15);

        f4s1v16 = (RadioGroup) findViewById(R.id.f4s1v16);
        f4s1v17 = (RadioGroup) findViewById(R.id.f4s1v17);
        f4s1v18 = (RadioGroup) findViewById(R.id.f4s1v18);

        P2_tv1 = (TextView) findViewById(R.id.P2_rg1_eror);
        P2_tv2 = (TextView) findViewById(R.id.P2_rg2_error);
        P2_tv3 = (TextView) findViewById(R.id.P2_rg3_error);

        GBResult = rgd.RadHint(radioGroups);
        GBResult2 = rgd2.RadHint(radioGroups2);
        final Button btn = (Button) findViewById(R.id.f4s1_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bol = true;
                f4s1v4.setError(null);
                f4s1v5.setError(null);
                f4s1v9.setError(null);

                f4s1v14.setError(null);
                f4s1v15.setError(null);


                //Part 1 Textboxs________________________________________________


                int mode;

                if(f4s1v11.getSelectedItemPosition()!=0 ||
                        f4s1v12.getSelectedItemPosition()!=0||
                        f4s1v13.getSelectedItemPosition()!=0||
                        !f4s1v14.getText().toString().matches("")||
                        !f4s1v15.getText().toString().matches("") ||
                        f4s1v16.getCheckedRadioButtonId()!=-1||
                        f4s1v17.getCheckedRadioButtonId()!=-1||
                        f4s1v18.getCheckedRadioButtonId()!=-1)
                {
                    mode=2;
                }
                else
                {
                    mode = 1;
                }


                switch (mode)
                {
                    case 1 :
                        yearChecker checker = new yearChecker(activity_f4s1.this);
                        if (f4s1v4.getText().toString().matches("")) {
                            f4s1v4.setError(null);
                            f4s1v4.setError("این فیلد الزامی است");
                            P1_flags[0] = false;
                        }
                        else if (!checker.checkyear(f4s1v4))
                        {
                            P1_flags[0] = false;
                        }
                        else {
                            if (f4s1v4.length() < 2) {
                                P1_flags[0] = false;
                                f4s1v4.setError(null);
                                f4s1v4.setError("دو رقمی وارد کنید");
                            } else {
                                P1_flags[0] = true;
                                f4s1v4_text = f4s1v4.getText().toString();
                            }
                        }
                        if (f4s1v5.getText().toString().matches("")) {
                            f4s1v5.setError(null);
                            f4s1v5.setError("این فیلد الزامی است");
                            P1_flags[1] = false;
                        } else {
                            if (f4s1v5.length() < 2) {
                                P1_flags[1] = false;
                                f4s1v5.setError(null);
                                f4s1v5.setError("دو رقمی وارد کنید");
                            } else {
                                P1_flags[1] = true;
                                f4s1v5_text = f4s1v5.getText().toString();
                            }
                        }

                        if (f4s1v9.getText().toString().matches("")) {
                            f4s1v9.setError("این فیلد الزامی است");
                            P1_flags[2] = false;
                        } else {
                            P1_flags[2] = true;
                            f4s1v9_text = f4s1v9.getText().toString();
                        }
                        //part 1 radiogroups______________________________________________
                        if (f4s1v6.getCheckedRadioButtonId() <= 0) {
                            P1_tv1.setError("این فیلد الزامی است");
                            P1_flags[3] = false;
                        } else {
                            P1_tv1.setError(null);
                            P1_flags[3] = true;
                        }
                        if (f4s1v7.getCheckedRadioButtonId() <= 0) {
                            P1_tv2.setError("این فیلد الزامی است");
                            P1_flags[4] = false;
                        } else {
                            P1_tv2.setError(null);
                            P1_flags[4] = true;
                        }
                        if (f4s1v8.getCheckedRadioButtonId() <= 0) {
                            P1_tv3.setError("این فیلد الزامی است");
                            P1_flags[5] = false;
                        } else {
                            P1_tv3.setError(null);
                            P1_flags[5] = true;
                        }
                        if (f4s1v10.getCheckedRadioButtonId() <= 0) {
                            P1_tv4.setError("این فیلد الزامی است");
                            P1_flags[6] = false;
                        } else {
                            P1_tv4.setError(null);
                            P1_flags[6] = true;
                        }
                        for (int i = 0; i < 7; i++) {
                            if (P1_flags[i] == false) {
                                P1_flag2 = false;
                            } else {
                                P1_flag2 = true;
                            }
                        }
                        if (f4s1v1.getSelectedItemPosition() == 0) {
                            error_f4s1v1.setError("");
                            Toast.makeText(v.getContext(), "لطفا مارک را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner1bool = false;
                        } else {
                            error_f4s1v1.setError(null);
                            spinner1bool = true;
                        }
                        if (f4s1v2.getSelectedItemPosition() == 0) {
                            error_f4s1v2.setError("");
                            Toast.makeText(activity_f4s1.this, "لطفا مدل را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner2bool = false;
                        } else {
                            error_f4s1v2.setError(null);
                            spinner2bool = true;
                        }
                        if (f4s1v3.getSelectedItemPosition() == 0) {
                            error_f4s1v3.setError("");
                            Toast.makeText(activity_f4s1.this, "لطفا ت خودرو را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner3bool = false;
                        } else {
                            error_f4s1v3.setError(null);
                            spinner3bool = true;
                        }
                        for (int i = 0; i < 5; i++) {
                            if (P1_flags[i] == true) {
                                P1_flag2 = true;
                            } else {
                                P1_flag2 = false;
                                break;
                            }
                        }
                        if (spinner1bool && spinner2bool && spinner3bool) {
                            Allspinnerbool = true;
                        } else {
                            Allspinnerbool = false;
                        }
                        if(P1_flag2 &&Allspinnerbool)
                        {
                            editor.putString("f4_mark_id", f4s1v2_id);
                            editor.commit();
                            editor.apply();

                            al.clear();
                            al.add(Integer.toString(f4s1v1.getSelectedItemPosition() + 1));
                            al.add(Integer.toString(f4s1v2.getSelectedItemPosition() + 1));
                            al.add(Integer.toString(f4s1v3.getSelectedItemPosition() + 1));
                            al.add(f4s1v4_text);
                            al.add(f4s1v5_text);
                            for (int i = 0; i < 3; i++) {
                                al.add(GBResult[i]);
                            }
                            al.add(f4s1v9_text);
                            al.add(GBResult[3]);

                            al.add(Integer.toString(f4s1v11.getSelectedItemPosition() + 1));
                            al.add(Integer.toString(f4s1v12.getSelectedItemPosition() + 1));
                            al.add(Integer.toString(f4s1v13.getSelectedItemPosition() + 1));
                            al.add(f4s1v14_text);
                            al.add(f4s1v15_text);
                            for (int i = 0; i < 3; i++) {
                                al.add(GBResult2[i]);
                            }

                            Intent intent = new Intent(activity_f4s1.this, activity_f4s2.class);
                            startActivity(intent);
                        }
                        else
                        break;
                    case 2 :

                        yearChecker checker1 = new yearChecker(activity_f4s1.this);
                        if (f4s1v4.getText().toString().matches("")) {
                            f4s1v4.setError(null);
                            f4s1v4.setError("این فیلد الزامی است");
                            P1_flags[0] = false;
                        }
                        else if (!checker1.checkyear(f4s1v4))
                        {
                            P1_flags[0] = false;
                        }
                        else {
                            if (f4s1v4.length() < 2) {
                                P1_flags[0] = false;
                                f4s1v4.setError(null);
                                f4s1v4.setError("دو رقمی وارد کنید");
                            } else {
                                P1_flags[0] = true;
                                f4s1v4_text = f4s1v4.getText().toString();
                            }
                        }
                        if (f4s1v5.getText().toString().matches("")) {
                            f4s1v5.setError(null);
                            f4s1v5.setError("این فیلد الزامی است");
                            P1_flags[1] = false;
                        } else {
                            if (f4s1v5.length() < 2) {
                                P1_flags[1] = false;
                                f4s1v5.setError(null);
                                f4s1v5.setError("دو رقمی وارد کنید");
                            } else {
                                P1_flags[1] = true;
                                f4s1v5_text = f4s1v5.getText().toString();
                            }
                        }

                        if (f4s1v9.getText().toString().matches("")) {
                            f4s1v9.setError("این فیلد الزامی است");
                            P1_flags[2] = false;
                        } else {
                            P1_flags[2] = true;
                            f4s1v9_text = f4s1v9.getText().toString();
                        }
                        //part 1 radiogroups______________________________________________
                        if (f4s1v6.getCheckedRadioButtonId() <= 0) {
                            P1_tv1.setError("این فیلد الزامی است");
                            P1_flags[3] = false;
                        } else {
                            P1_tv1.setError(null);
                            P1_flags[3] = true;
                        }
                        if (f4s1v7.getCheckedRadioButtonId() <= 0) {
                            P1_tv2.setError("این فیلد الزامی است");
                            P1_flags[4] = false;
                        } else {
                            P1_tv2.setError(null);
                            P1_flags[4] = true;
                        }
                        if (f4s1v8.getCheckedRadioButtonId() <= 0) {
                            P1_tv3.setError("این فیلد الزامی است");
                            P1_flags[5] = false;
                        } else {
                            P1_tv3.setError(null);
                            P1_flags[5] = true;
                        }
                        if (f4s1v10.getCheckedRadioButtonId() <= 0) {
                            P1_tv4.setError("این فیلد الزامی است");
                            P1_flags[6] = false;
                        } else {
                            P1_tv4.setError(null);
                            P1_flags[6] = true;
                        }
                        for (int i = 0; i < 7; i++) {
                            if (P1_flags[i] == false) {
                                P1_flag2 = false;
                            } else {
                                P1_flag2 = true;
                            }
                        }
                        if (f4s1v1.getSelectedItemPosition() == 0) {
                            error_f4s1v1.setError("");
                            Toast.makeText(v.getContext(), "لطفا مارک را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner1bool = false;
                        } else {
                            error_f4s1v1.setError(null);
                            spinner1bool = true;
                        }
                        if (f4s1v2.getSelectedItemPosition() == 0) {
                            error_f4s1v2.setError("");
                            Toast.makeText(activity_f4s1.this, "لطفا مدل را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner2bool = false;
                        } else {
                            error_f4s1v2.setError(null);
                            spinner2bool = true;
                        }
                        if (f4s1v3.getSelectedItemPosition() == 0) {
                            error_f4s1v3.setError("");
                            Toast.makeText(activity_f4s1.this, "لطفا ت خودرو را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner3bool = false;
                        } else {
                            error_f4s1v3.setError(null);
                            spinner3bool = true;
                        }
                        //___________PART 2___________________

                        //part 2 Edit Texts_____________

                        if (f4s1v14.getText().toString().matches("")) {
                            f4s1v14.setError(null);
                            f4s1v14.setError("این فیلد الزامی است");
                            P2_flags[0] = false;
                        }
                        else if (!checker1.checkyear(f4s1v14))
                        {
                            P2_flags[0] = false;
                        }
                        else {
                            if (f4s1v14.length() < 2) {
                                P2_flags[0] = false;
                                f4s1v14.setError(null);
                                f4s1v14.setError("دو رقمی وارد کنید");
                            } else {
                                P2_flags[0] = true;
                                f4s1v14_text = f4s1v14.getText().toString();
                            }
                        }
                        if (f4s1v15.getText().toString().matches("")) {
                            f4s1v15.setError(null);
                            f4s1v15.setError("این فیلد الزامی است");
                            P2_flags[1] = false;
                        } else {
                            if (f4s1v15.length() < 2) {
                                P2_flags[1] = false;
                                f4s1v15.setError(null);
                                f4s1v15.setError("دو رقمی وارد کنید");
                            } else {
                                P2_flags[1] = true;
                                f4s1v15_text = f4s1v15.getText().toString();
                            }
                        }
                        //part 1 radiogroups______________________________________________
                        if (f4s1v16.getCheckedRadioButtonId() <= 0) {
                            P2_tv1.setError("این فیلد الزامی است");
                            P2_flags[2] = false;
                        } else {
                            P1_tv1.setError(null);
                            P2_flags[2] = true;
                        }
                        if (f4s1v17.getCheckedRadioButtonId() <= 0) {
                            P2_tv2.setError("این فیلد الزامی است");
                            P2_flags[3] = false;
                        } else {
                            P1_tv2.setError(null);
                            P2_flags[3] = true;
                        }
                        if (f4s1v18.getCheckedRadioButtonId() <= 0) {
                            P2_tv3.setError("این فیلد الزامی است");
                            P2_flags[4] = false;
                        } else {
                            P1_tv3.setError(null);
                            P2_flags[4] = true;
                        }

                        for (int i = 0; i < 5; i++) {
                            if (P2_flags[i] == true) {
                                P2_flag2 = true;
                            } else {
                                P2_flag2 = false;
                                break;
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            if (P1_flags[i] == true) {
                                P1_flag2 = true;
                            } else {
                                P1_flag2 = false;
                                break;
                            }
                        }

                        if (f4s1v11.getSelectedItemPosition() == 0) {
                            error_f4s1v11.setError("");
                            Toast.makeText(getApplicationContext(), "لطفا مارک را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner4bool = false;
                        } else {
                            error_f4s1v11.setError(null);
                            spinner4bool = true;
                        }
                        if (f4s1v12.getSelectedItemPosition() == 0) {
                            error_f4s1v12.setError("");
                            Toast.makeText(getApplicationContext(), "لطفا مدل را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner5bool = false;
                        } else {
                            error_f4s1v12.setError(null);
                            spinner5bool = true;
                        }
                        if (f4s1v13.getSelectedItemPosition() == 0) {
                            error_f4s1v13.setError("");
                            Toast.makeText(getApplicationContext(), "لطفا ت خودرو را انتخاب نمایید", Toast.LENGTH_SHORT);
                            spinner6bool = false;
                        } else {
                            error_f4s1v13.setError(null);
                            spinner6bool = true;
                        }
                        if (spinner4bool && spinner5bool && spinner6bool) {
                            Allspinnerbool2 = true;
                        } else {
                            Allspinnerbool2 = false;
                        }
                        // Toast.makeText(activity_f4s1.this, P1_flag2 + "," + P2_flag2 + "," + Allspinnerbool + "," + Allspinnerbool2, Toast.LENGTH_LONG).show();
                        if (P1_flag2 && P2_flag2 && Allspinnerbool && Allspinnerbool2) {
                            editor.putString("f4_mark_id", f4s1v2_id);
                            editor.commit();
                            editor.apply();

                            al.clear();
                            al.add(f4s1v1_id);
                            al.add(f4s1v2_id);
                            al.add(f4s1v3_id);
                            al.add(f4s1v4_text);
                            al.add(f4s1v5_text);
                            for (int i = 0; i < 3; i++) {
                                al.add(GBResult[i]);
                            }
                            al.add(f4s1v9_text);
                            al.add(GBResult[3]);

                            al.add(f4s1v11_id);
                            al.add(f4s1v12_id);
                            al.add(f4s1v13_id);
                            al.add(f4s1v14_text);
                            al.add(f4s1v15_text);
                            for (int i = 0; i < 3; i++) {
                                al.add(GBResult2[i]);
                            }

                            Intent intent = new Intent(activity_f4s1.this, activity_f4s2.class);
                            startActivity(intent);
                        }

                        break;
                }

            }

        });
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
