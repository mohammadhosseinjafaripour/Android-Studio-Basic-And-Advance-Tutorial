package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.BoringLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import ir.rahnama.MyDebug;
import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s8 extends AppCompatActivity {


    EditText[] editTexts=new EditText[3];
    EditText Ed_liner1;
    LinearLayout liner1;

    EditText Ed_liner2;
    LinearLayout liner2;
    Boolean Ischeck1=false;
    Boolean Ischeck2=false;
    Boolean[] edcheckes=new Boolean[]{false,false,false};
    Boolean Alledcheck=false;
    int lin1=0,lin2=0;
    int[] spin=new int[6];
    String[] result=new String[13];
    String[] ed_texts=new String[3];
    TextView[] textViews = new TextView[6];
    TextView[] job_textviews = new TextView[2];
    Boolean[] spinbool=new Boolean[6];

    ArrayList<String> al=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s8);
            liner1= (LinearLayout) findViewById(R.id.f4s8_liner1);
            Ed_liner1= (EditText) findViewById(R.id.F4S8V12);

            liner2= (LinearLayout) findViewById(R.id.f4s8_liner2);
            Ed_liner2= (EditText) findViewById(R.id.F4S8V13);

            for(int i=0;i<13;i++)
            {
                result[i]="";
            }
        int[] textviewIds=new int[]
                {
                        R.id.f4s8_P1_tv1,
                        R.id.f4s8_P1_tv3,
                        R.id.f4s8_P1_tv4,
                        R.id.f4s8_P2_tv6,
                        R.id.f4s8_P2_tv8,
                        R.id.f4s8_P2_tv9
                };
        int[] jobtextviesid = new int[]
                {
                        R.id.f4s8_P1_tv5,
                        R.id.f4s8_P2_tv10
                };
        for(int i=0;i<6;i++)
        {
            textViews[i] = (TextView) findViewById(textviewIds[i]);
        }
        for(int i=0;i<2;i++)
        {
            job_textviews[i] = (TextView) findViewById(jobtextviesid[i]);
        }



        final Spinner f4s8v2 = (Spinner)findViewById(R.id.F4S8V2);
        final String [] f4s8v_2 = getResources().getStringArray(R.array.f4s8_gender);
        ArrayAdapter snprAdapter2 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_2);
        f4s8v2.setAdapter(snprAdapter2);
        f4s8v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v2.getSelectedItem().toString();
                spin[0]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner f4s8v4 = (Spinner)findViewById(R.id.F4S8V4);
        final String [] f4s8v_4 = getResources().getStringArray(R.array.f4s8_taahol);
        ArrayAdapter snprAdapter4 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_4);
        f4s8v4.setAdapter(snprAdapter4);
        f4s8v4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v4.getSelectedItem().toString();
                spin[1]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner f4s8v5 = (Spinner)findViewById(R.id.F4S8V5);
        final String [] f4s8v_5 = getResources().getStringArray(R.array.f4s8_tahsilat);
        ArrayAdapter snprAdapter5 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_5);
        f4s8v5.setAdapter(snprAdapter5);
        f4s8v5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v5.getSelectedItem().toString();
                spin[2]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        final Spinner f4s8v6 = (Spinner)findViewById(R.id.F4S8V6);
        final String [] f4s8v_6 = getResources().getStringArray(R.array.f4s8_job);
        ArrayAdapter snprAdapter6 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_6);
        f4s8v6.setAdapter(snprAdapter6);
        f4s8v6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v6.getSelectedItem().toString();

                if(position==13)
                {
                    liner1.setVisibility(View.VISIBLE);
                     lin1=position;
                }
                else
                {
                    liner1.setVisibility(View.GONE);
                    Ischeck1=false;
                    lin1=position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//__________________________________________pasokh go

        final Spinner f4s8v7 = (Spinner)findViewById(R.id.F4S8V7);
        final String [] f4s8v_7 = getResources().getStringArray(R.array.f4s8_gender);
        ArrayAdapter snprAdapter7 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_7);
        f4s8v7.setAdapter(snprAdapter7);
        f4s8v7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v7.getSelectedItem().toString();
                spin[3]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner f4s8v9 = (Spinner)findViewById(R.id.F4S8V9);
        final String [] f4s8v_9 = getResources().getStringArray(R.array.f4s8_taahol);
        ArrayAdapter snprAdapter9 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_9);
        f4s8v9.setAdapter(snprAdapter9);
        f4s8v9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v9.getSelectedItem().toString();
                spin[4]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner f4s8v10 = (Spinner)findViewById(R.id.F4S8V10);
        final String [] f4s8v_10 = getResources().getStringArray(R.array.f4s8_tahsilat);
        ArrayAdapter snprAdapter10 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_10);
        f4s8v10.setAdapter(snprAdapter10);
        f4s8v10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v10.getSelectedItem().toString();
                spin[5]=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        final Spinner f4s8v11 = (Spinner)findViewById(R.id.F4S8V11);
        final String [] f4s8v_11 = getResources().getStringArray(R.array.f4s8_job);
        ArrayAdapter snprAdapter11 = new ArrayAdapter(activity_f4s8.this, R.layout.support_simple_spinner_dropdown_item,f4s8v_11);
        f4s8v11.setAdapter(snprAdapter11);
        f4s8v11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result  = f4s8v11.getSelectedItem().toString();

                if(position==13)
                {
                    liner2.setVisibility(View.VISIBLE);
                    lin2=position;
                }
                else
                {
                    liner2.setVisibility(View.GONE);
                    lin2=position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        int[] edIds=new int[]
                {
                        R.id.F4S8V1,
                        R.id.F4S8V3,
                        R.id.F4S8V8,
                };


                  for(int a=0;a<3;a++)
                {
                    editTexts[a]= (EditText) findViewById(edIds[a]);
                }


       final Button btn= (Button) findViewById(R.id.f4s8_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                for(int i=0;i<13;i++)
                {
                    result[i]="";
                }
                Ischeck1=false;
                Ischeck2=false;
                for (int a = 0; a < 3; a++) {
                    if (editTexts[a].getText().toString().matches("")) {
                        editTexts[a].setError("این فیلد الزامی است");
                        edcheckes[a]=false;
                    } else {
                        editTexts[a].setError(null);
                        edcheckes[a] =true;
                        ed_texts[a]=editTexts[a].getText().toString();
                    }
                    for(int b=0;b<3;b++)
                    {
                        if(edcheckes[b]==true) {
                            Alledcheck = true;
                        }
                        else {
                            Alledcheck=false;
                            break;
                        }
                    }
                }
                if (lin1==13) {
                    if (Ed_liner1.getText().toString().matches(""))
                    {
                        Ed_liner1.setError("این فیلد الزامی است");
                        Ischeck1 = false;
                    }
                    else
                    {

                        Ed_liner1.getText();
                        Ed_liner1.setError(null);
                        Ischeck1 = true;
                        result[11]=Ed_liner1.getText().toString();
                    }
                } else {
                    if(lin1==0)
                    {
                        job_textviews[0].setError("");
                        Ischeck1=false;
                    }
                    else if(lin1!=13 && lin1!=0) {
                        job_textviews[0].setError(null);
                        Ed_liner1.setError(null);
                        Ischeck1 = true;
                        result[5]=Integer.toString(f4s8v6.getSelectedItemPosition());
                    }
                }
                if (lin2==13)
                {
                    if (Ed_liner2.getText().toString().matches(""))
                    {
                        Ed_liner2.setError("این فیلد الزامی است");
                        Ischeck2 = false;
                    }
                    else {
                        Ed_liner2.getText();
                        Ed_liner2.setError(null);
                        Ischeck2 = true;
                        result[12]=Ed_liner2.getText().toString();
                    }
                } else {
                    if(lin2==0)
                    {
                        job_textviews[1].setError("");
                        Ischeck2=false;
                    } else if(lin2!=13 && lin2!=0){
                        job_textviews[1].setError(null);
                        Ed_liner2.setError(null);
                        Ischeck2 = true;
                        result[10]=Integer.toString(f4s8v11.getSelectedItemPosition());
                    }
                }
                for(int i=0;i<6;i++) {
                    if (spin[i] == 0) {
                        textViews[i].setError("");
                        spinbool[i]=false;
                    } else {
                        textViews[i].setError(null);
                        spinbool[i]=true;
                    }
                }



                for(int i=0;i<6;i++) {
                    if(spinbool[i]==true)
                    {
                        Alledcheck=true;
                    }
                    else
                    {
                        Alledcheck=false;
                        break;
                    }
                }



                if(edcheckes[0])
                    result[0]=editTexts[0].getText().toString();

                if(edcheckes[1])
                    result[2]=editTexts[1].getText().toString();

                if(edcheckes[2])
                    result[7]=editTexts[2].getText().toString();

                //__________________
                if(spinbool[0])
                    result[1]=Integer.toString(f4s8v2.getSelectedItemPosition());

                if(spinbool[1])
                    result[3]=Integer.toString(f4s8v4.getSelectedItemPosition());

                if(spinbool[2])
                    result[4]=Integer.toString(f4s8v5.getSelectedItemPosition());

                if(spinbool[3])
                    result[6]=Integer.toString(f4s8v7.getSelectedItemPosition());

                if(spinbool[4])
                    result[8]=Integer.toString(f4s8v9.getSelectedItemPosition());

                if(spinbool[5])
                    result[9]=Integer.toString(f4s8v10.getSelectedItemPosition());

                if (Alledcheck && Ischeck1 && Ischeck2) {

                    al.clear();
                    // TODO: 9/28/2017  insert to database
                    for(int i=0;i<13;i++)
                    {
                        al.add(result[i]);
                    }
                    // TODO: 9/28/2017 end of insert to database
                  //  MyDebug myDebug = new MyDebug(activity_f4s8.this,al);

                    Intent intent = new Intent(activity_f4s8.this, activity_f4s9.class);
                    startActivity(intent);
                } else {
                    Alledcheck = false;
                }
               // btn.setText(Alledcheck+" "+Ischeck1+" "+Ischeck2+"\n"+edcheckes[0]+" "+edcheckes[1]+" "+edcheckes[2]);
            }

        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}