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


public class F3Q11 extends AppCompatActivity {
    private boolean Ischeck = false;

    ArrayList<String> al =  new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q11);

        int[] edIds = new int[]
                {
                        R.id.F3S11V1
                };


        final EditText[] ed = new EditText[1];
        for (int a = 0; a < 1; a++) {
            ed[a] = (EditText) findViewById(edIds[a]);
        }


        final Button btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int a = 0; a < 1; a++) {
                    if (ed[a].getText().toString().matches("")) {
                        ed[a].setError("این فیلد الزامی است");
                        Ischeck = false;
                    }else if (Integer.parseInt(ed[a].getText().toString())>=15 || Integer.parseInt(ed[a].getText().toString())<1) {
                        ed[a].setError("لطفا بزرگتر از 1 و کوچکتر از 15 وارد کنید");
                        Ischeck = false;
                    }else if (ed[0].getText().toString().startsWith("0"))
                    {
                        ed[0].setError("خطا در ورود داده");
                        ed[0].setText("");
                    }
                    else {
                        Ischeck = true;
                    }
                }
                if (Ischeck) {
                    // TODO: 9/28/2017 inset to db
                    al.clear();
                    al.add(ed[0].getText().toString());

                    Intent intent = new Intent(F3Q11.this, F3Q12.class);
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
