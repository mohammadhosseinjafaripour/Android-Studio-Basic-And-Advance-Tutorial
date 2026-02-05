package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q9 extends AppCompatActivity {


    ArrayList<String> al = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q9);

        final EditText et = (EditText) findViewById(R.id.F3S9V1);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().toString().matches("")){
                    et.setError("این فیلد الزامی است");
                }else if (Integer.parseInt(et.getText().toString()) >= 15){
                    et.setError("خارج از محدوده");
                }else if (et.getText().toString().startsWith("0"))
                {
                    et.setError("خطا در ورود داده");
                    et.setText("");
                }
                else{

                    // TODO: 9/23/2017 start insert to database

                    al.clear();
                    al.add(et.getText().toString());

                    // TODO: 9/23/2017 end insert to database




                    startActivity(new Intent(F3Q9.this, F3Q10.class));
                }
            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
