package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringDef;
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

public class activity_f4s6 extends AppCompatActivity {

    RadioGroup[] radioGroups=new RadioGroup[8];
    TextView[] textViews=new TextView[8];
    Boolean[] radiochecker=new Boolean[8];
    Boolean AllradioCheck=false;
    public  Button btn;
    public int[] radiobtnIds;
    public int[] RadioValues=new int[8];
    public Radiogroupchecker rgd=new Radiogroupchecker(this);
    String[] GBReult;

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s6);


        for(int i=0;i<8;i++)
        {
            RadioValues[i]=0;
        }

        radiobtnIds=new int[]{
                R.id.f4s6v1_1,
                R.id.f4s6v1_2,
                R.id.f4s6v1_3,
                R.id.f4s6v1_4,
                R.id.f4s6v1_5,
                R.id.f4s6v1_6,
                R.id.f4s6v1_7,
                R.id.f4s6v1_8,
                R.id.f4s6v1_9,
                R.id.f4s6v1_99

        };



       final int[] tvs=new int[]
                {
                        R.id.f4s6_tv1,
                        R.id.f4s6_tv2,
                        R.id.f4s6_tv3,
                        R.id.f4s6_tv4,
                        R.id.f4s6_tv5,
                        R.id.f4s6_tv6,
                        R.id.f4s6_tv7,
                        R.id.f4s6_tv8,
                };
        final int[] radioIds=new int[]
                {
                        R.id.f4s6v1,
                        R.id.f4s6v2,
                        R.id.f4s6v3,
                        R.id.f4s6v4,
                        R.id.f4s6v5,
                        R.id.f4s6v6,
                        R.id.f4s6v7,
                        R.id.f4s6v8,
                };
        for(int a=0;a<8;a++)
                {
                    radioGroups[a]= (RadioGroup) findViewById(radioIds[a]);
                    textViews[a]= (TextView) findViewById(tvs[a]);
                    textViews[a].setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                    radioGroups[a].setTag(a);
                }
//                for(int i=0;i<8;i++)
//                    radioGroups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                        int tag= Integer.parseInt(group.getTag().toString());
//                            final String value =
//                                    ((RadioButton) findViewById(radioGroups[tag].getCheckedRadioButtonId()))
//                                            .getText().toString();
//                            RadioValues[tag]=Integer.parseInt(value.toString());
//                            btn.setText("Radiogroup :"+(tag+1) + " Radiobutton :" + value);
//                        }
//                    });
        GBReult = rgd.RaddText(radioGroups);

     btn= (Button) findViewById(R.id.f4s6_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for(int i=0;i<8;i++)
                {
                    textViews[i].setError(null);
                }

                for(int i=0;i<8;i++)
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
                for(int i=0;i<8;i++)
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
                    // TODO: 9/28/2017 insert to database
                    for(int i=0;i<8;i++)
                    {
                        al.add(GBReult[i]);
                    }
                    // TODO: 9/28/2017 end of insert to database
                    Intent intent = new Intent(activity_f4s6.this, activity_f4s7.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(activity_f4s6.this, "لطفا تمامی موارد را بررسی کنید.", Toast.LENGTH_SHORT).show();
                }


            }


        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}