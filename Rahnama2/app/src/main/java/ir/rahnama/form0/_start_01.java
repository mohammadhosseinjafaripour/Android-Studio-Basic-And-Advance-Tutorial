package ir.rahnama.form0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.rahnama.R;
import ir.rahnama.form1.dbHandler;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class _start_01 extends AppCompatActivity {


    Boolean flag_zone = false;
    Boolean flag_area = false;
    Boolean flag_block = false;
    Boolean flag_address = false;


    dbHandler db;

    SharedPreferences shpr;




    List<String> s1_list;
    List<String> s1_list_text = new ArrayList<String>();
    List<String> s1_list_temp = new ArrayList<String>();//temp
    List<String> s1_list_id = new ArrayList<String>();
    List<String> s1_list_phone_code = new ArrayList<String>();


    List<String> s2_list ;
    List<String> s2_list_text = new ArrayList<String>();
    List<String> s2_list_temp = new ArrayList<String>();
    List<String> s2_list_id = new ArrayList<String>();


    List<String> s3_list ;
    List<String> s3_list_text = new ArrayList<String>();
    List<String> s3_list_temp = new ArrayList<String>();
    List<String> s3_list_id = new ArrayList<String>();

    String state_id;
    String city_id;
    String village_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._start_01);

        db = new dbHandler(getBaseContext());

        shpr = getApplicationContext().getSharedPreferences("MKRdatabase", 0);
        final SharedPreferences.Editor editor = shpr.edit();




        final Spinner s1 = (Spinner) findViewById(R.id.state);
        final Spinner s2 = (Spinner) findViewById(R.id.city);
        final Spinner s3 = (Spinner)findViewById(R.id.village);

        s1_list = db.viewOneRowState();

        s1_list_temp = s1_list;

        s1_list_text.add("نام استان را انتخاب کنید");
        s1_list_id.add("0");

        s1_list_phone_code.add("0");

        for(String da : s1_list){
            //valuesword.put("id", "");
            String[] words=da.split("#%");

            s1_list_id.add(words[0]);
            s1_list_text.add(words[1]);
            s1_list_phone_code.add(words[2]);
        }


        final ArrayAdapter<String> adapter1  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s1_list_text );
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s2_list_text );
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s3_list_text );






        final EditText zone = (EditText)findViewById(R.id.zone);
        final EditText area = (EditText)findViewById(R.id.area);
        final EditText block = (EditText)findViewById(R.id.block);
        final EditText address = (EditText)findViewById(R.id.address);






        //Show state
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0 ) {
                    String id1 = s1_list_id.get(position);

                    editor.putString("phonecode", s1_list_phone_code.get(position));
                    editor.commit();
                    //phone_code.setText(s1_list_phone_code.get(position).toString());

                    state_id = id1;

                    s2_list = db.viewOneRowCity(state_id);

                    s2_list_id.clear();
                    s2_list_text.clear();
                    s2_list_text.add("انتخاب کنید");
                    s2_list_id.add("0");

                    for (String da : s2_list) {
                        //valuesword.put("id", "");
                        String[] words = da.split("#%");
                        s2_list_id.add(words[0]);
                        s2_list_text.add(words[1]);
                    }
                    s2_list.clear();

                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s2.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();
                }else {
                   // Toast.makeText(_.this, "داده ای وجود ندارد", Toast.LENGTH_LONG).show();
                    s2.setAdapter(null);
                    s3.setAdapter(null);
                    // phone_code.setText("");
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //Show city
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                if (position > 0) {
                    String idcity = s2_list_id.get(position);
                    city_id = idcity;

                    s3_list = db.viewOneRowVillage(state_id, city_id);

                    s3_list_id.clear();
                    s3_list_text.clear();
                    s3_list_text.add("انتخاب کنید");
                    s3_list_id.add("0");
                    for (String da : s3_list) {
                        String[] words = da.split("#%");
                        s3_list_id.add(words[0]);
                        s3_list_text.add(words[1]);
                    }
                    s3_list.clear();

                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s3.setAdapter(adapter3);
                    adapter3.notifyDataSetChanged();

                } else {

                    s3.setAdapter(null);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Show village
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter3);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {

                //String id2=bliststrid.get(position)+"--"+bfaclistid.get(position);
                //Toast.makeText(readfile.this, id2, Toast.LENGTH_LONG).show();
                if (position > 0) {
                    String villageid = s3_list_id.get(position);
                    village_id = villageid;

                    //Toast.makeText(details.this, state_id+"--"+city_id+"--"+village_id, Toast.LENGTH_LONG).show();

                }else{

                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });





        Button next = (Button) findViewById(R.id.f1_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(s1.getSelectedItemPosition()==0)
                {
                    Toast.makeText(_start_01.this, "لطفا نام استان را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                if(s2.getSelectedItemPosition()==0)
                {
                    Toast.makeText(_start_01.this, "لطفا  نام شهر را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }if(s1.getSelectedItemPosition()==0)
                {
                    Toast.makeText(_start_01.this, "لطفا نام روستا را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }

                if(zone.getText().toString().matches(""))
                {
                    flag_zone = false;
                    zone.setError("این فیلد الزامی است.");
                }
                else
                {
                    flag_zone = true;
                    zone.setError(null);
                }

                if(area.getText().toString().matches(""))
                {
                    flag_area = false;
                    area.setError("این فیلد الزامی است.");
                }
                else
                {
                    flag_area = true;
                    area.setError(null);

                }
                if(block.getText().toString().matches(""))
                {
                    flag_block = false;
                    block.setError("این فیلد الزامی است.");

                }
                else
                {
                    flag_block = true;
                    block.setError(null);
                }
                if(address.getText().toString().matches(""))
                {
                    flag_address = false;
                    address.setError("این فیلد الزامی است.");
                }
                else
                {
                    flag_address = true;
                    address.setError(null);

                }

                if(flag_zone&&flag_area&&flag_block&&flag_address)
                {
                   Intent  intent = new Intent(_start_01.this,_start_03.class);
                    startActivity(intent);

                }
            }
        });







    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
