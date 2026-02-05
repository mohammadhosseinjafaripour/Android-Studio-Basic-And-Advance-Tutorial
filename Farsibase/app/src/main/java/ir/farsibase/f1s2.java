package ir.farsibase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s2 extends AppCompatActivity {

    dbHandler db;
    String last_id;
    ArrayList<String> al=new ArrayList<String>();

    Boolean bv1 = false , bv2 = false , bv3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s2);

        db = new dbHandler(getBaseContext());
        last_id = db.GetLastIdRow();

        final EditText f1s2v1 = (EditText)findViewById(R.id.f1s2v1);
        final EditText f1s2v2 = (EditText)findViewById(R.id.f1s2v2);
        final EditText f1s2v3 = (EditText)findViewById(R.id.f1s2v3);

        Button btn = (Button)findViewById(R.id.btnclicks);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //f1s2v1 validation
                if(f1s2v1.getText().toString().matches(""))
                {
                    bv2=false;
                    f1s2v1.setError("این فیلد الزامی است.");
                } else {
                    bv2=true;
                }
                //f1s2v2 validation
                if(f1s2v2.getText().toString().matches(""))
                {
                    bv3=false;
                    f1s2v2.setError("این فیلد الزامی است.");
                } else
                {
                    bv3=true;
                }
                //f1s2v3 validation
                if(f1s2v3.getText().toString().matches(""))
                {
                    bv1=false;
                    f1s2v3.setError("این فیلد الزامی است.");
                } else {
                    bv1=true;
                }

                if(bv1 && bv2 && bv3 )
                {
                    al.add(f1s2v1.getText().toString());
                    al.add(f1s2v2.getText().toString());
                    al.add(f1s2v3.getText().toString());

                   /* HashMap<String, String> meMap=new HashMap<String, String>();
                    myhashmap mhashmap = new myhashmap();
                    meMap = mhashmap.gnstr(al,"f1s2v");
                    //db.UpdateF1(last_id,meMap);*/

                    Intent i = new Intent(f1s2.this,f1s3.class);
                    startActivity(i);
                }




            }
        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
