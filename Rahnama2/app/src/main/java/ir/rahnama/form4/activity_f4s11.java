package ir.rahnama.form4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class activity_f4s11 extends AppCompatActivity {


    EditText f4s11v1;
    Boolean Ischeck=false;
    String f4s11v1_text="";

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s11);



                    f4s11v1= (EditText) findViewById(R.id.f4s11v1);



       final Button btn= (Button) findViewById(R.id.f4s11_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f4s11v1.setError(null);
                    if(f4s11v1.getText().toString().matches(""))
                    {
                       f4s11v1.setError("این فیلد الزامی است");
                        Ischeck=false;
                    }
                    else if (f4s11v1.getText().toString().startsWith("0"))
                    {
                        f4s11v1.setError("خطا در ورود داده");
                        f4s11v1.setText("");
                    }
                    else
                    {
                        f4s11v1.setError(null);
                        Ischeck=true;
                        f4s11v1_text=f4s11v1.getText().toString();
                    }
                if(Ischeck)
                {
                    // TODO: 9/28/2017 start insert to database
                    al.clear();
                    al.add(f4s11v1_text);
                    Intent intent=new Intent(activity_f4s11.this,activity_f4s12.class);
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