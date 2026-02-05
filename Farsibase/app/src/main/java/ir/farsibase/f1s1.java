package ir.farsibase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by amir on 9/7/2017.
 */
public class f1s1 extends Activity {

    Button button;
    EditText name,age,family,phone,mobile,countfamily;
    String[] sports,sale;
    String[] idp;
    private RadioGroup g1,g2;
    private RadioButton sg1,sg2;
    private Button btnDisplay;
    Context context = this;
    TextView t1,t2;
    RadioButton rbman,rbwoman;
    Boolean rgv7 = false,rgv2=false;

    String f1s1v1,f1s1v2,f1s1v3,f1s1v4,f1s1v5,f1s1v6,f1s1v7;

    ArrayList<String> al=new ArrayList<String>();


    dbHandler db;
    String last_id;



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1s1);

        findViewsById();

        db = new dbHandler(getBaseContext());
        last_id = db.GetLastIdRow();



        addListenerOnButton();





       /* String[] countries = getResources().getStringArray(R.array.fuel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        phone.setAdapter(adapter);*/




    }

    private void findViewsById() {

        name = (EditText) findViewById(R.id.f1s1v1);
        age = (EditText) findViewById(R.id.f1s1v3);
        phone = (EditText) findViewById(R.id.f1s1v4);
        mobile = (EditText) findViewById(R.id.f1s1v5);
        countfamily = (EditText) findViewById(R.id.f1s1v6);
        button = (Button) findViewById(R.id.bt);
        g1 = (RadioGroup) findViewById(R.id.f1s1v2);
        g2 = (RadioGroup) findViewById(R.id.f1s1v7);
        btnDisplay = (Button) findViewById(R.id.bt);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.efect);


        rbman = (RadioButton)findViewById(R.id.man);
        rbwoman = (RadioButton)findViewById(R.id.woman);




    }

    public void addListenerOnButton() {
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Checker ch = new Checker();
                // get selected radio button from radioGroup
                int selectedId1 = g1.getCheckedRadioButtonId();
                int selectedId2 = g2.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                sg1 = (RadioButton) findViewById(selectedId1);
                sg2 = (RadioButton) findViewById(selectedId2);


                //f1s1v1 validation
                Boolean namefamily = ch.empty_checker(name.getText().toString(), name);
                //f1s1v3 validation
                Boolean bage = ch.age_checker(age.getText().toString(), age);
                //f1s1v4 validation
                Boolean bphaone = ch.phone_checker(phone.getText().toString(), phone);
                // f1s1v5 validation
                Boolean  bmobile = ch.mobile_checker(mobile.getText().toString(), mobile);
                // f1s1v6 validation
                Boolean bfacount = ch.count_family_checker(countfamily.getText().toString(), countfamily);

                //f1s1v2 validation
                if(selectedId1 <0){
                    t1.setError("انتخاب کنید");
                    rgv2=false;
                }else{
                    t1.setError(null);
                    rgv2=true;
                }

                //f1s1v7 validation
                if(selectedId2 <0){
                    t2.setError("انتخاب کنید");
                    rgv7=false;
                }else{
                    t2.setError(null);
                    rgv7=true;
                }


                //check finall validation
                if(bage && bphaone && bmobile && bfacount && namefamily && rgv2 && rgv7){

                    g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                            switch (checkedId)
                            {
                                case R.id.man:
                                    f1s1v2 = rbman.getText().toString();
                                    break;
                                case R.id.woman:
                                    f1s1v2 = rbwoman.getText().toString();
                                    break;
                            }
                        }
                    });

                    f1s1v1 = name.getText().toString();
                    f1s1v3 = age.getText().toString();
                    f1s1v4 = phone.getText().toString();
                    f1s1v5 = mobile.getText().toString();
                    f1s1v6 = countfamily.getText().toString();
                    f1s1v7 = sg2.getHint().toString();

                    al.add(f1s1v1);
                    al.add(f1s1v2);
                    al.add(f1s1v3);
                    al.add(f1s1v4);
                    al.add(f1s1v5);
                    al.add(f1s1v6);
                    al.add(f1s1v7);


                   /* HashMap<String, String> meMap=new HashMap<String, String>();
                    myhashmap mhashmap = new myhashmap();
                    meMap = mhashmap.gnstr(al,"f1s1v");

                    db.UpdateF1(last_id,meMap);*/


                   /*String aas = db.viewOneRow(last_id);
                    Toast.makeText(f1s1.this, aas, Toast.LENGTH_LONG).show();*/



                    if(sg2.getHint().equals("1")){
                        Intent i = new Intent(f1s1.this,f1s3.class);
                        startActivity(i);
                    }else{
                        Intent i = new Intent(f1s1.this,f1s2.class);
                        startActivity(i);
                    }
                }
            }

        });
    }

    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
