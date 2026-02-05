package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import ir.rahnama.R;
import ir.rahnama.form1.Checker;
import ir.rahnama.form1.dbHandler;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q8 extends AppCompatActivity {

    ArrayList<String> al = new ArrayList<String>();

    EditText G_f4s8v1;
    Spinner  G_f4s8v2;
    EditText G_f4s8v3;
    Spinner  G_f4s8v4;
    Spinner  G_f4s8v5;
    Spinner  G_f4s8v6;
    Spinner  G_f4s8v7;
    EditText G_f4s8v8;
    Spinner  G_f4s8v9;
    Spinner  G_f4s8v10;
    Spinner  G_f4s8v11;
    EditText G_f4s8v12;
    EditText G_f4s8v13;
    Boolean perfect=false;
    String this1,this2,this3,this4,this5,this6,this7,this8,this9,this10,this11;

    String  S_f3s8v1, S_f3s8v2, S_f3s8v3,
            S_f3s8v4, S_f3s8v5, S_f3s8v6,
            S_f3s8v7, S_f3s8v8, S_f3s8v9,
            S_f3s8v10, S_f3s8v11, S_f3s8v12,
            S_f3s8v13;

    TextView f4s8v2_t;
    TextView f4s8v4_t;
    TextView f4s8v5_t;
    TextView f4s8v6_t;
    TextView f4s8v7_t;
    TextView f4s8v9_t;
    TextView f4s8v10_t;
    TextView f4s8v11_t;

    Button send;

    dbHandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q8);

        db = new dbHandler(getBaseContext());

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);


        f4s8v2_t = (TextView) findViewById(R.id.f3s8v2_t);
        f4s8v4_t = (TextView) findViewById(R.id.f3s8v4_t);
        f4s8v5_t = (TextView) findViewById(R.id.f3s8v5_t);
        f4s8v6_t = (TextView) findViewById(R.id.f3s8v6_t);
        f4s8v7_t = (TextView) findViewById(R.id.f3s8v7_t);
        f4s8v9_t = (TextView) findViewById(R.id.f3s8v9_t);
        f4s8v10_t = (TextView) findViewById(R.id.f3s8v10_t);
        f4s8v11_t = (TextView) findViewById(R.id.f3s8v11_t);

        G_f4s8v1 =  (EditText) findViewById(R.id.F3S8V1);
        G_f4s8v2 =   (Spinner) findViewById(R.id.F3S8V2);
        G_f4s8v3 =  (EditText) findViewById(R.id.F3S8V3);
        G_f4s8v4 =   (Spinner) findViewById(R.id.F3S8V4);
        G_f4s8v5 =   (Spinner) findViewById(R.id.F3S8V5);
        G_f4s8v6 =   (Spinner) findViewById(R.id.F3S8V6);
        G_f4s8v7 =   (Spinner) findViewById(R.id.F3S8V7);
        G_f4s8v8 =  (EditText) findViewById(R.id.F3S8V8);
        G_f4s8v9 =   (Spinner) findViewById(R.id.F3S8V9);
        G_f4s8v10 =  (Spinner) findViewById(R.id.F3S8V10);
        G_f4s8v11 =  (Spinner) findViewById(R.id.F3S8V11);
        G_f4s8v12 = (EditText) findViewById(R.id.F3S8V12);
        G_f4s8v13 = (EditText) findViewById(R.id.F3S8V13);




        final String[] f4s25v_2 = getResources().getStringArray(R.array.gender);
        ArrayAdapter snprAdapter2 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_2);
        G_f4s8v2.setAdapter(snprAdapter2);
        G_f4s8v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s25v_4 = getResources().getStringArray(R.array.marriedCondition);
        ArrayAdapter snprAdapter4 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_4);
        G_f4s8v4.setAdapter(snprAdapter4);
        G_f4s8v4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v4.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s25v_5 = getResources().getStringArray(R.array.grade);
        ArrayAdapter snprAdapter5 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_5);
        G_f4s8v5.setAdapter(snprAdapter5);
        G_f4s8v5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v5.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s25v_6 = getResources().getStringArray(R.array.f5s25v6);
        ArrayAdapter snprAdapter6 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_6);
        G_f4s8v6.setAdapter(snprAdapter6);
        G_f4s8v6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v6.getSelectedItem().toString();

                if (position == 10) {
                    View v = (View)viewGroup.findViewById(R.id.liner_F3S8V12);
                    v.setVisibility(v.VISIBLE);
                } else {
                    View v = (View)viewGroup.findViewById(R.id.liner_F3S8V12);
                    v.setVisibility(v.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //__________________________________________pasokh go

        final String[] f4s8v_7 = getResources().getStringArray(R.array.gender);
        ArrayAdapter snprAdapter7 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s8v_7);
        G_f4s8v7.setAdapter(snprAdapter7);
        G_f4s8v7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v7.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s25v_9 = getResources().getStringArray(R.array.marriedCondition);
        ArrayAdapter snprAdapter9 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_9);
        G_f4s8v9.setAdapter(snprAdapter9);
        G_f4s8v9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v9.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s8v_10 = getResources().getStringArray(R.array.grade);
        ArrayAdapter snprAdapter10 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s8v_10);
        G_f4s8v10.setAdapter(snprAdapter10);
        G_f4s8v10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v10.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final String[] f4s25v_11 = getResources().getStringArray(R.array.f5s25v6);
        ArrayAdapter snprAdapter11 = new ArrayAdapter(F3Q8.this, R.layout.support_simple_spinner_dropdown_item, f4s25v_11);
        G_f4s8v11.setAdapter(snprAdapter11);
        G_f4s8v11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = G_f4s8v11.getSelectedItem().toString();

                if (position == 10) {
                    View v = (View)viewGroup.findViewById(R.id.liner_F3S8V13);
                    v.setVisibility(v.VISIBLE);
                } else {
                    View v = (View)viewGroup.findViewById(R.id.liner_F3S8V13);
                    v.setVisibility(v.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateF5S25()){

                    // TODO: 9/26/2017 Insert to DB

                    al.clear();
                    S_f3s8v1 = G_f4s8v1.getText().toString();
                    S_f3s8v2 = Integer.toString(G_f4s8v2.getSelectedItemPosition());
                    S_f3s8v3 = G_f4s8v3.getText().toString();
                    S_f3s8v4 = Integer.toString(G_f4s8v4.getSelectedItemPosition());
                    S_f3s8v5 = Integer.toString(G_f4s8v5.getSelectedItemPosition());
                    S_f3s8v6 = Integer.toString(G_f4s8v6.getSelectedItemPosition());
                    S_f3s8v7 = Integer.toString(G_f4s8v7.getSelectedItemPosition());
                    S_f3s8v8 = G_f4s8v8.getText().toString();
                    S_f3s8v9 = Integer.toString(G_f4s8v9.getSelectedItemPosition());
                    S_f3s8v10 = Integer.toString(G_f4s8v10.getSelectedItemPosition());
                    S_f3s8v11 = Integer.toString(G_f4s8v11.getSelectedItemPosition());
                    S_f3s8v12 = G_f4s8v12.getText().toString();
                    S_f3s8v13 = G_f4s8v13.getText().toString();

                    al.add(S_f3s8v1);
                    al.add(S_f3s8v2);
                    al.add(S_f3s8v3);
                    al.add(S_f3s8v4);
                    al.add(S_f3s8v5);
                    al.add(S_f3s8v6);
                    al.add(S_f3s8v7);
                    al.add(S_f3s8v8);
                    al.add(S_f3s8v9);
                    al.add(S_f3s8v10);
                    al.add(S_f3s8v11);
                    al.add(S_f3s8v12);
                    al.add(S_f3s8v13);


                    Intent intent = new Intent(F3Q8.this,F3Q9.class);
                    startActivity(intent);
                }
            }
        });

    }
    protected Boolean ValidateF5S25 (){

        Checker myChecker = new Checker();

        //Row 1
        //----------------------------------------------

        if(G_f4s8v1.getText().toString().matches("")){
            G_f4s8v1.setError("این فیلد الزامی است");
        }else {
            G_f4s8v1.setError(null);
            this1 = "OK";
        }

        if(G_f4s8v2.getSelectedItemPosition() == 0){
            f4s8v2_t.setError("");
        }else {
            f4s8v2_t.setError(null);
            this2 = "OK";
        }

        if(myChecker.age_checker(G_f4s8v3.getText().toString(), G_f4s8v3)){
            G_f4s8v3.setError(null);
            this3 = "OK";
        }

        if(G_f4s8v4.getSelectedItemPosition() == 0){
            f4s8v4_t.setError("");
        }else {
            f4s8v4_t.setError(null);
            this4 = "OK";
        }

        if(G_f4s8v5.getSelectedItemPosition() == 0){
            f4s8v5_t.setError("");
        }else {
            f4s8v5_t.setError(null);
            this5 = "OK";
        }

        if(G_f4s8v6.getSelectedItemPosition() == 0){
            f4s8v6_t.setError("");
        }else {
            f4s8v6_t.setError(null);
            this6 = "OK";
        }

        if(G_f4s8v6.getSelectedItemPosition() == 10){
            if(G_f4s8v12.getText().toString().matches("")){
                G_f4s8v12.setError("این فیلد الزامی است");
                this6 = "NO";
            }else {
                G_f4s8v12.setError(null);
                this6 = "OK";
            }
        }

        //Row 2
        //----------------------------------------------

        if(G_f4s8v7.getSelectedItemPosition() == 0){
            f4s8v7_t.setError("");
        }else {
            f4s8v7_t.setError(null);
            this7 = "OK";
        }

        if(myChecker.age_checker(G_f4s8v8.getText().toString(), G_f4s8v8)){
            G_f4s8v8.setError(null);
            this8 = "OK";
        }

        if(G_f4s8v9.getSelectedItemPosition() == 0){
            f4s8v9_t.setError("");
        }else {
            f4s8v9_t.setError(null);
            this9 = "OK";
        }

        if(G_f4s8v10.getSelectedItemPosition() == 0){
            f4s8v10_t.setError("");
        }else {
            f4s8v10_t.setError(null);
            this10 = "OK";
        }

        if(G_f4s8v11.getSelectedItemPosition() == 0){
            f4s8v11_t.setError("");
        }else {
            f4s8v11_t.setError(null);
            this11 = "OK";
        }

        if(G_f4s8v11.getSelectedItemPosition() == 10){
            if(G_f4s8v13.getText().toString().matches("")){
                G_f4s8v13.setError("این فیلد الزامی است");
                this11 = "NO";
            }else {
                G_f4s8v13.setError(null);
                this11 = "OK";
            }
        }

        if(this1 == "OK" && this2 == "OK" && this3 == "OK" && this4 == "OK" && this5 == "OK" && this6 == "OK" && this7 == "OK" && this8 == "OK" && this9 == "OK" && this10 == "OK" && this11 == "OK"){
            perfect = true;
        }

        return perfect;
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
