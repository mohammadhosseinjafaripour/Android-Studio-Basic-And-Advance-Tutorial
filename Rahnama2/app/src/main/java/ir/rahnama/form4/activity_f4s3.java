package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.rahnama.MyDebug;
import ir.rahnama.R;
import ir.rahnama.form1.dbHandler;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s3 extends AppCompatActivity {

    RadioGroup[] radios = new RadioGroup[3];
    TextView[] textViews = new TextView[3];
    Boolean[] ischeck = new Boolean[]{false, false, false};
    Boolean AllrgCheck = false;
    Spinner f4s3v1, f4s3v2, f4s3v3;
    Boolean spinner1bool = false, spinner2bool = false, spinner3bool = false, Allspinnerbool = false;
    Radiogroupchecker rgd = new Radiogroupchecker(this);
    String[] GBResult;


    List<String> stv_list;
    List<String> stv_list_text = new ArrayList<String>();
    List<String> stv_list_id = new ArrayList<String>();
    List<String> stv_list_modelid = new ArrayList<String>();
    List<String> stv_list_typeid = new ArrayList<String>();
    List<String> stv_list_thiscar = new ArrayList<String>();
    List<String> stv_list_compare = new ArrayList<String>();
    dbHandler db;
    String car1_name;
    String car2_name;
    String car3_name;


    List<String> spinner_temp_text_1 = new ArrayList<String>();
    List<String> spinner_temp_text_2 = new ArrayList<String>();
    List<String> spinner_temp_text_3 = new ArrayList<String>();


    SharedPreferences sh;

    ArrayList<String> al = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s3);


        db = new dbHandler(getBaseContext());


        f4s3v1 = (Spinner) findViewById(R.id.f4s3v1);
        f4s3v2 = (Spinner) findViewById(R.id.f4s3v2);
        f4s3v3 = (Spinner) findViewById(R.id.f4s3v3);


        //shareperfrence
        sh = getSharedPreferences("typecarmodel", MODE_PRIVATE);

        stv_list = db.viewOneRowCarComper(sh.getString("f4_mark_id", null));/////////////////////////////////////////////////////////////////////

        stv_list_compare.add(" ماشین رقابتی ");
        spinner_temp_text_1.add(" ماشین رقابتی ");
        spinner_temp_text_2.add(" ماشین رقابتی ");
        spinner_temp_text_3.add(" ماشین رقابتی ");
        //stv_list_compare.add("0");

        for (String da : stv_list) {
            //valuesword.put("id", "");
            String[] words = da.split("#%");

            stv_list_id.add(words[0]);
            stv_list_modelid.add(words[1]);
            stv_list_typeid.add(words[2]);
            // car.setText(words[3]);
            Integer countre = 4;
            while (countre < words.length) {
                if (!words[countre].equals(null)) {
                    stv_list_compare.add(" ماشین " + words[countre]);
                    spinner_temp_text_1.add(" ماشین " + words[countre]);
                }
                countre++;
            }
        }


        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_temp_text_1);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_temp_text_2);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_temp_text_3);


        //Show state
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s3v1.setAdapter(adapter1);
        f4s3v1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {


                    String name = spinner_temp_text_1.get(position);

                    car1_name = name;

                    spinner_temp_text_2.clear();

                    //stv_list_compare.add("0");


                    for (String da : spinner_temp_text_1) {

                        spinner_temp_text_2.add(da);

                    }
                    spinner_temp_text_2.remove(position);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s3v2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();

                    // Toast.makeText(activity_f4s3.this, id1, Toast.LENGTH_LONG).show();

                } else {
                    f4s3v2.setAdapter(null);
                    spinner_temp_text_2.clear();
                    spinner_temp_text_2.add(" ماشین رقابتی ");
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s3v2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();


                    f4s3v3.setAdapter(null);
                    spinner_temp_text_3.clear();
                    spinner_temp_text_3.add(" ماشین رقابتی ");
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s3v3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();

                    //Toast.makeText(read_3.this, "داده ای وجود ندارد", Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Show state
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s3v2.setAdapter(adapter2);
        f4s3v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {


                    String name = spinner_temp_text_2.get(position);

                    car2_name = name;

                    spinner_temp_text_3.clear();

                    //stv_list_compare.add("0");


                    for (String da : spinner_temp_text_2) {

                        spinner_temp_text_3.add(da);

                    }
                    spinner_temp_text_3.remove(position);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s3v3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();

                    // Toast.makeText(activity_f4s3.this, id1, Toast.LENGTH_LONG).show();

                } else {
                    f4s3v3.setAdapter(null);
                    spinner_temp_text_3.clear();
                    spinner_temp_text_3.add(" ماشین رقابتی ");
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    f4s3v3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();
                    //Toast.makeText(read_3.this, "داده ای وجود ندارد", Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Show state
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s3v3.setAdapter(adapter2);
        f4s3v3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0) {
                    String car3 = spinner_temp_text_3.get(position);
                    car3_name = car3;

                    Toast.makeText(activity_f4s3.this, car1_name+car2_name+car3_name, Toast.LENGTH_LONG).show();

                } else {
                    //Toast.makeText(read_3.this, "داده ای وجود ندارد", Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        int[] radioIds = new int[]
                {
                        R.id.f4s3v4,
                        R.id.f4s3v5,
                        R.id.f4s3v6
                };
        int[] tvs = new int[]
                {
                        R.id.f4s3_tv1,
                        R.id.f4s3_tv2,
                        R.id.f4s3_tv3
                };

        for (int a = 0; a < 3; a++) {
            radios[a] = (RadioGroup) findViewById(radioIds[a]);
            textViews[a] = (TextView) findViewById(tvs[a]);
            radios[a].setTag(a);
        }

        GBResult = rgd.RadHint(radios);
        final Button btn = (Button) findViewById(R.id.f4s3_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btn.setText(GBResult[0] + " " + GBResult[1] + " " + GBResult[2]);
                for (int i = 0; i < 3; i++) {
                    textViews[i].setError(null);
                }
                for (int a = 0; a < 3; a++) {
                    if (radios[a].getCheckedRadioButtonId() <= 0) {
                        ischeck[a] = false;
                        textViews[a].setError("");
                    } else {
                        ischeck[a] = true;
                        textViews[a].setError(null);
                    }

                }
                for (int i = 0; i < 3; i++) {
                    if (ischeck[i] == true) {
                        AllrgCheck = true;
                    } else {
                        AllrgCheck = false;
                        break;
                    }
                }


                if (f4s3v1.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "لطفا مارک را انتخاب نمایید", Toast.LENGTH_SHORT);
                    spinner1bool = false;
                } else {
                    spinner1bool = true;
                }
                if (f4s3v2.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "لطفا مدل را انتخاب نمایید", Toast.LENGTH_SHORT);
                    spinner2bool = false;
                } else {
                    spinner2bool = true;
                }
                if (f4s3v3.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "لطفا ت خودرو را انتخاب نمایید", Toast.LENGTH_SHORT);
                    spinner3bool = false;
                } else {
                    spinner3bool = true;
                }
                if (spinner1bool && spinner2bool && spinner3bool) {
                    Allspinnerbool = true;
                } else {
                    Allspinnerbool = false;
                }


                if (AllrgCheck && Allspinnerbool) {

                    // TODO: 9/28/2017  insert to database
                    al.clear();
                    al.add(car1_name);
                    al.add(car2_name);
                    al.add(car3_name);

                    for (int i = 0; i < 3; i++) {
                        al.add(GBResult[i]);
                    }

                    Intent intent = new Intent(activity_f4s3.this, activity_f4s4.class);
                    startActivity(intent);
                }


            }


        });
    }

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}