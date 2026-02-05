package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s5 extends AppCompatActivity {

    RadioGroup[] radioGroups=new RadioGroup[50];
    TextView[] textViews=new TextView[50];
    Boolean[] radiochecker=new Boolean[50];
    Boolean AllradioCheck=false;
    final Radiogroupchecker rgd=new Radiogroupchecker(this);
    String[] GBResult;

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s5);


        int[] radioIds=new int[]
                {
                        R.id.f4s5v1,
                        R.id.f4s5v2,
                        R.id.f4s5v3,
                        R.id.f4s5v4,
                        R.id.f4s5v5,
                        R.id.f4s5v6,
                        R.id.f4s5v7,
                        R.id.f4s5v8,
                        R.id.f4s5v9,
                        R.id.f4s5v10,
                        R.id.f4s5v11,
                        R.id.f4s5v12,
                        R.id.f4s5v13,
                        R.id.f4s5v14,
                        R.id.f4s5v15,
                        R.id.f4s5v16,
                        R.id.f4s5v17,
                        R.id.f4s5v18,
                        R.id.f4s5v19,
                        R.id.f4s5v20,
                        R.id.f4s5v21,
                        R.id.f4s5v22,
                        R.id.f4s5v23,
                        R.id.f4s5v24,
                        R.id.f4s5v25,
                        R.id.f4s5v26,
                        R.id.f4s5v27,
                        R.id.f4s5v28,
                        R.id.f4s5v29,
                        R.id.f4s5v30,
                        R.id.f4s5v31,
                        R.id.f4s5v32,
                        R.id.f4s5v33,
                        R.id.f4s5v34,
                        R.id.f4s5v35,
                        R.id.f4s5v36,
                        R.id.f4s5v37,
                        R.id.f4s5v38,
                        R.id.f4s5v39,
                        R.id.f4s5v40,
                        R.id.f4s5v41,
                        R.id.f4s5v42,
                        R.id.f4s5v43,
                        R.id.f4s5v44,
                        R.id.f4s5v45,
                        R.id.f4s5v46,
                        R.id.f4s5v47,
                        R.id.f4s5v48,
                        R.id.f4s5v49,
                        R.id.f4s5v50,
                };
        int[] tvErrors=new int[]
                {
                        R.id.f4s5_tv1,
                        R.id.f4s5_tv2,
                        R.id.f4s5_tv3,
                        R.id.f4s5_tv4,
                        R.id.f4s5_tv5,
                        R.id.f4s5_tv6,
                        R.id.f4s5_tv7,
                        R.id.f4s5_tv8,
                        R.id.f4s5_tv9,
                        R.id.f4s5_tv10,
                        R.id.f4s5_tv11,
                        R.id.f4s5_tv12,
                        R.id.f4s5_tv13,
                        R.id.f4s5_tv14,
                        R.id.f4s5_tv15,
                        R.id.f4s5_tv16,
                        R.id.f4s5_tv17,
                        R.id.f4s5_tv18,
                        R.id.f4s5_tv19,
                        R.id.f4s5_tv20,
                        R.id.f4s5_tv21,
                        R.id.f4s5_tv22,
                        R.id.f4s5_tv23,
                        R.id.f4s5_tv24,
                        R.id.f4s5_tv25,
                        R.id.f4s5_tv26,
                        R.id.f4s5_tv27,
                        R.id.f4s5_tv28,
                        R.id.f4s5_tv29,
                        R.id.f4s5_tv30,
                        R.id.f4s5_tv31,
                        R.id.f4s5_tv32,
                        R.id.f4s5_tv33,
                        R.id.f4s5_tv34,
                        R.id.f4s5_tv35,
                        R.id.f4s5_tv36,
                        R.id.f4s5_tv37,
                        R.id.f4s5_tv38,
                        R.id.f4s5_tv39,
                        R.id.f4s5_tv40,
                        R.id.f4s5_tv41,
                        R.id.f4s5_tv42,
                        R.id.f4s5_tv43,
                        R.id.f4s5_tv44,
                        R.id.f4s5_tv45,
                        R.id.f4s5_tv46,
                        R.id.f4s5_tv47,
                        R.id.f4s5_tv48,
                        R.id.f4s5_tv49,
                        R.id.f4s5_tv50,
                };

        for(int i=0;i<50;i++)
        {
            radioGroups[i]= (RadioGroup) findViewById(radioIds[i]);
            textViews[i]= (TextView) findViewById(tvErrors[i]);
            textViews[i].setTextColor(Color.parseColor("#000000"));
            textViews[i].setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            radioGroups[i].setTag(i);
        }
           GBResult = rgd.RaddText(radioGroups);

       final Button btn= (Button) findViewById(R.id.f4s5_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               // btn.setText(GBResult[0]+" "+GBResult[1]+" "+GBResult[2]);
                for(int i=0;i<8;i++)
                {
                    textViews[i].setError(null);
                }

                for(int i=0;i<50;i++)
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
                for(int i=0;i<50;i++)
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
                if(AllradioCheck)
                {
                    al.clear();
                    // TODO: 9/28/2017 start insert to database
                    for(int i=0;i<50;i++)
                    {
                        al.add(GBResult[i]);
                    }
                    Intent intent = new Intent(activity_f4s5.this, activity_f4s6.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(activity_f4s5.this, "لطفا تمامی موارد را بررسی کنید.", Toast.LENGTH_SHORT).show();
                }


            }


        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}