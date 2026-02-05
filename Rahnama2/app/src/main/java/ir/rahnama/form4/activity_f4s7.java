package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s7 extends AppCompatActivity {


    EditText[] editTexts=new EditText[10];
    Boolean[] Ischeck = new Boolean[10];
    Boolean AlledCheck=false;
    String[] editTexts_texts = new String[10];

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s7);
            for(int i=0;i<10;i++)
            {
                Ischeck[i]=false;
            }
        int[] edIds=new int[]
                {
                        R.id.f4s7v1,
                        R.id.f4s7v2,
                        R.id.f4s7v3,
                        R.id.f4s7v4,
                        R.id.f4s7v5,
                        R.id.f4s7v6,
                        R.id.f4s7v7,
                        R.id.f4s7v8,
                        R.id.f4s7v9,
                        R.id.f4s7v10
                };


        for(int a=0;a<10;a++)
                {
                    editTexts[a]= (EditText) findViewById(edIds[a]);
                }


        Button btn= (Button) findViewById(R.id.f4s7_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int a=0;a<10;a++)
                {
                    if(editTexts[a].getText().toString().matches(""))
                    {
                        editTexts[a].setError("این فیلد الزامی است");
                        Ischeck[a]=false;
                    }
                    else
                    {
                        editTexts[a].setError(null);
                        Ischeck[a]=true;
                        editTexts_texts[a]=editTexts[a].getText().toString();
                    }
                }
                for(int i=0;i<10;i++)
                {
                    if(Ischeck[i]==true)
                    {
                        AlledCheck=true;
                    }
                    else
                    {
                        AlledCheck=false;
                        break;
                    }
                }
                if(AlledCheck)
                {

                    // TODO: 9/28/2017 start insert to dataabse
                    al.clear();
                    for(int i=0;i<10;i++)
                    {
                        al.add(editTexts_texts[i]);
                    }
                    // TODO: 9/28/2017 end of insert to database
                    Intent intent=new Intent(activity_f4s7.this,activity_f4s8.class);
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