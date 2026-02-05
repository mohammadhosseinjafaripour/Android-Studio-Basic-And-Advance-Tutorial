package ir.farsibase;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class details extends AppCompatActivity {

    String result_1, result_2, result_3;
    dbHandler db;
    String last_id;

    ArrayList<String> listvalue=new ArrayList<String>();

    String a_1,a_2,a_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        SharedPreferences.Editor editor=getSharedPreferences("myshare",MODE_PRIVATE).edit();
        editor.putString("active_activity","");
        editor.commit();

        final String[] city = new String[]{"thr", "esf", "krz", "frs", "azs", "kzt", "gln", "krm", "hmd", "krs", "bsh", "mzn"};
        final String[] sity = new String[]{"thr", "esf", "msh", "shz", "tbz", "ahz", "rsh", "krm", "hmd", "krs", "bsh", "sri"};
        final String[] state = new String[]{"", "rza", "nsh", "fsa", "mrg", "dzf", "anz", "bam", "mlr", "smb", "dsh", "nsh"};

      //  db = new dbHandler(getBaseContext());

       // last_id = db.GetLastIdRow();
       // Toast.makeText(this, db.viewOneRow(last_id), Toast.LENGTH_SHORT).show();

        editor.putString("active_activity","details");
        editor.commit();



        SharedPreferences preferences =getSharedPreferences("myshare",MODE_PRIVATE);

/*
        if(preferences.getString("active_activity","").equals("details")) {

        }*/




     /*   Criteria criteria = new Criteria();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        final int la = (int) (location.getLatitude() * 1E6);
        final int lo = (int) (location.getLongitude() * 1E6);*/











        final Spinner spinner = (Spinner)findViewById(R.id.spi_details1);
        final String [] array = getResources().getStringArray(R.array.cit);
        final ArrayAdapter sn = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,array);
        spinner.setAdapter(sn);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spi_details2);

        final Spinner spinner2 = (Spinner)findViewById(R.id.spi_details3);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arr = getResources().getStringArray(R.array.city0);
                String[] arr1 = getResources().getStringArray(R.array.city1);
                String[] arr2 = getResources().getStringArray(R.array.city2);
                String[] arr3 = getResources().getStringArray(R.array.city3);
                String[] arr4 = getResources().getStringArray(R.array.city4);
                String[] arr5 = getResources().getStringArray(R.array.city5);
                String[] arr6 = getResources().getStringArray(R.array.city6);
                String[] arr7 = getResources().getStringArray(R.array.city7);
                String[] arr8 = getResources().getStringArray(R.array.city8);
                String[] arr9 = getResources().getStringArray(R.array.city9);
                String[] arr10 = getResources().getStringArray(R.array.city10);
                String[] arr11 = getResources().getStringArray(R.array.city11);


                int i = spinner.getSelectedItemPosition();

                String[] st1 = getResources().getStringArray(R.array.state1);
                String[] st2 = getResources().getStringArray(R.array.state2);
                String[] st3 = getResources().getStringArray(R.array.state3);
                String[] st4 = getResources().getStringArray(R.array.state4);
                String[] st5 = getResources().getStringArray(R.array.state5);
                String[] st6 = getResources().getStringArray(R.array.state6);
                String[] st7 = getResources().getStringArray(R.array.state7);
                String[] st8 = getResources().getStringArray(R.array.state8);
                String[] st9 = getResources().getStringArray(R.array.state9);
                String[] st10 = getResources().getStringArray(R.array.state10);
                String[] st11 = getResources().getStringArray(R.array.state11);






                if(i==0)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr);
                    spinner1.setAdapter(s2);
                    String text = spinner.getSelectedItem().toString();
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                    Toast.makeText(details.this, ""+text, Toast.LENGTH_SHORT).show();
                    String txt = spinner1.getSelectedItem().toString();


                }
                else if(position==1)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr1);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st1);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];

                }
                else if(position==2)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr2);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st2);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==3)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr3);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st3);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==4)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr4);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st4);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==5)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr5);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st5);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==6)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr6);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st6);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==7)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr7);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st7);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==8)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr8);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st8);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==9)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr9);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st9);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==10)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr10);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st10);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }
                else if(position==11)
                {
                    final ArrayAdapter s2 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,arr11);
                    spinner1.setAdapter(s2);
                    final ArrayAdapter s3 = new ArrayAdapter(details.this, R.layout.support_simple_spinner_dropdown_item,st11);
                    spinner2.setAdapter(s3);
                    a_1= city[i];
                    a_2 = sity[i];
                    a_3 = state[i];
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        Button btn = (Button)findViewById(R.id.detail_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




//                db.gnerateOneRow();
  //              last_id = db.GetLastIdRow();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String currentDateandTime = sdf.format(new Date());

                HashMap<String, String> meMap=new HashMap<String, String>();
                meMap.put("longitude","test");
                meMap.put("latitude","test");
                meMap.put("state",a_1);
                meMap.put("city",a_2);
                meMap.put("village",a_3);
                meMap.put("phone_code","12");
                meMap.put("date_client",currentDateandTime);

               // Toast.makeText(details.this, a_1+","+a_2+","+a_3+""+currentDateandTime, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(details.this,f1s1.class);
                startActivity(i);
               // db.UpdateF1(last_id,meMap);


            }
        });


    }
}
