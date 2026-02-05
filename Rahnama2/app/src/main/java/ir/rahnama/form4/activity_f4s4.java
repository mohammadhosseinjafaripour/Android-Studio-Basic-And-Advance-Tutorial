package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.rahnama.R;
import ir.rahnama.form1.dbHandler;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s4 extends AppCompatActivity {
    RadioGroup[] radioGroups=new RadioGroup[32];
    TextView[] textViews=new TextView[32];
    Boolean[] radiochecker=new Boolean[32];
    Boolean AllradioCheck=false;
    Spinner f4s4v1;
    String f4s4v1_text="";
    Boolean edcheck=false;
    String[] GBResult;




    List<String> stv_list ;
    List<String> stv_list_text = new ArrayList<String>();
    List<String> stv_list_id = new ArrayList<String>();
    List<String> stv_list_modelid = new ArrayList<String>();
    List<String> stv_list_typeid = new ArrayList<String>();
    List<String> stv_list_thiscar = new ArrayList<String>();
    List<String> stv_list_compare = new ArrayList<String>();
    dbHandler db;
    String car_name;
    SharedPreferences sh;



    ArrayList<String> al=new ArrayList<String>();
    public Radiogroupchecker rgd=new Radiogroupchecker(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s4);






        f4s4v1 = (Spinner) findViewById(R.id.f4s4v1);


        sh = getSharedPreferences("typecarmodel",MODE_PRIVATE);


        db = new dbHandler(getBaseContext());

        //shareperfrence
        stv_list = db.viewOneRowCarComper(sh.getString("f4_mark_id",null));/////////////////////////////////////////////////////////////////////

        stv_list_compare.add(" ماشین رقابتی ");
        //stv_list_compare.add("0");

        for(String da : stv_list) {
            //valuesword.put("id", "");
            String[] words = da.split("#%");

            stv_list_id.add(words[0]);
            stv_list_modelid.add(words[1]);
            stv_list_typeid.add(words[2]);
            // car.setText(words[3]);
            Integer countre = 4;
            while (countre < words.length){
                if(!words[countre].equals(null)) {
                    stv_list_compare.add(" ماشین "+words[countre]);
                }
                countre++;
            }
        }


        final ArrayAdapter<String> adapter1  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,stv_list_compare );







        //Show state
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f4s4v1.setAdapter(adapter1);
        f4s4v1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();

                if (position > 0 ) {
                    String id1 = stv_list_compare.get(position);

                    car_name = id1;
                    Toast.makeText(activity_f4s4.this, id1, Toast.LENGTH_LONG).show();

                }else {
                    //Toast.makeText(read_3.this, "داده ای وجود ندارد", Toast.LENGTH_LONG).show();
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });







        final int radiogroups[]=new int[]
             {
                    R.id.f4s4v2,
                    R.id.f4s4v3,
                    R.id.f4s4v4,
                    R.id.f4s4v5,
                    R.id.f4s4v6,
                    R.id.f4s4v7,
                    R.id.f4s4v8,
                    R.id.f4s4v9,
                    R.id.f4s4v10,
                    R.id.f4s4v11,
                    R.id.f4s4v12,
                    R.id.f4s4v13,
                    R.id.f4s4v14,
                    R.id.f4s4v15,
                    R.id.f4s4v16,
                    R.id.f4s4v17,
                    R.id.f4s4v18,
                    R.id.f4s4v19,
                    R.id.f4s4v20,
                    R.id.f4s4v21,
                    R.id.f4s4v22,
                    R.id.f4s4v23,
                    R.id.f4s4v24,
                    R.id.f4s4v25,
                    R.id.f4s4v26,
                    R.id.f4s4v27,
                    R.id.f4s4v28,
                    R.id.f4s4v29,
                    R.id.f4s4v30,
                    R.id.f4s4v31,
                    R.id.f4s4v32,
                    R.id.f4s4v33,
             };
        int tvErrors[]=new int[]
                {
                        R.id.f4s4_tv2,
                        R.id.f4s4_tv3,
                        R.id.f4s4_tv4,
                        R.id.f4s4_tv5,
                        R.id.f4s4_tv6,
                        R.id.f4s4_tv7,
                        R.id.f4s4_tv8,
                        R.id.f4s4_tv9,
                        R.id.f4s4_tv10,
                        R.id.f4s4_tv11,
                        R.id.f4s4_tv12,
                        R.id.f4s4_tv13,
                        R.id.f4s4_tv14,
                        R.id.f4s4_tv15,
                        R.id.f4s4_tv16,
                        R.id.f4s4_tv17,
                        R.id.f4s4_tv18,
                        R.id.f4s4_tv19,
                        R.id.f4s4_tv20,
                        R.id.f4s4_tv21,
                        R.id.f4s4_tv22,
                        R.id.f4s4_tv23,
                        R.id.f4s4_tv24,
                        R.id.f4s4_tv25,
                        R.id.f4s4_tv26,
                        R.id.f4s4_tv27,
                        R.id.f4s4_tv28,
                        R.id.f4s4_tv29,
                        R.id.f4s4_tv30,
                        R.id.f4s4_tv31,
                        R.id.f4s4_tv32,
                        R.id.f4s4_tv33,
                };
                for(int i=0;i<32;i++)
                {
                     radioGroups[i]= (RadioGroup) findViewById(radiogroups[i]);
                     textViews[i]= (TextView) findViewById(tvErrors[i]);
                     radioGroups[i].setTag(i);
                }


       GBResult = rgd.RaddText(radioGroups);
        Button btn= (Button) findViewById(R.id.f4s4_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<32;i++)
                {
                    textViews[i].setError(null);
                }

                if(f4s4v1.getSelectedItemPosition()==0)
                {
                    Toast.makeText(activity_f4s4.this, "لطفا بخش رقابت پذیری را انتخال کنید", Toast.LENGTH_SHORT).show();
                    edcheck=false;
                }else
                {
                    edcheck=true;
                    //f4s4v1_text=f4s4v1.getText().toString();
                    //get spinner selected item it's edit text you change it to spinner !
                }
                for(int i=0;i<32;i++)
                {
                    if(radioGroups[i].getCheckedRadioButtonId()<=0)
                    {
                        textViews[i].setError("");
                        radiochecker[i]=false;
                    }
                    else
                    {
                        textViews[i].setError(null);
                        radiochecker[i]=true;
                    }
                }
                for(int i=0;i<32;i++)
                {
                    if(radiochecker[i]==true)
                    {
                    AllradioCheck=true;
                    }else
                    {
                        AllradioCheck=false;
                        break;
                    }
                }
                if(AllradioCheck && edcheck)
                {
                    // TODO: 9/28/2017  insert to database
                    al.clear();
                    al.add(car_name);
                    for(int i=0;i<32;i++)
                    {
                        al.add(GBResult[i]);
                    }

                    // TODO: 9/28/2017 end of insert to database
                    Intent intent = new Intent(activity_f4s4.this, activity_f4s5.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(activity_f4s4.this, "لطفا تمامی موارد را بررسی کنید.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}