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

public class activity_f4s9 extends AppCompatActivity {


    EditText f4s9v1;
    Boolean Ischeck=false;
    String f4s9v1_text="";

    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_f4s9);


        f4s9v1= (EditText) findViewById(R.id.f4s9v1);



        Button btn= (Button) findViewById(R.id.f4s9_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(f4s9v1.getText().toString().matches(""))
                    {
                        f4s9v1.setError("این فیلد الزامی است");
                        Ischeck=false;
                    }
                    else if (f4s9v1.getText().toString().startsWith("0"))
                    {
                        f4s9v1.setError("خطا در ورود داده");
                        f4s9v1.setText("");
                    }
                    else
                    {
                        f4s9v1.setError(null);
                        Ischeck=true;
                        f4s9v1_text=f4s9v1.getText().toString();
                    }
                if(Ischeck)
                {
                    al.clear();
                    // TODO: 9/28/2017 start insert to database
                    al.add(f4s9v1_text);
                    Intent intent=new Intent(activity_f4s9.this,activity_f4s10.class);
                    startActivity(intent);
                    // TODO: 9/28/2017 end of insert to database
                }

                }


        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}