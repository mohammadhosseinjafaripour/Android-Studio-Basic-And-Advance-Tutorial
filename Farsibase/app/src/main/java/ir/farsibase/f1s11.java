package ir.farsibase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class f1s11 extends AppCompatActivity {

    Boolean flag= false;

    ArrayList<String> al=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s11);



        final RadioGroup rg = (RadioGroup)findViewById(R.id.f1s11v1);
        final RadioButton rb1  = (RadioButton)findViewById(R.id.f1s11v1_1);
        final RadioButton rb2  = (RadioButton)findViewById(R.id.f1s11v1_2);
        final RadioButton rb3  = (RadioButton)findViewById(R.id.f1s11v1_3);
        final RadioButton rb4  = (RadioButton)findViewById(R.id.f1s11v1_4);

        final TextView tx = (TextView)findViewById(R.id.textysusberror);




        Button btn = (Button)findViewById(R.id.btnclick7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("State",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                if (rg.getCheckedRadioButtonId() <= 0) {
                    tx.setError("");
                }

                else {

                    RadioButton radioButton = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
                    al.add(radioButton.getHint().toString());
                }

            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
