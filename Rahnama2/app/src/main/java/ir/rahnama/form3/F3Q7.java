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

public class F3Q7 extends AppCompatActivity {


    private EditText[] editTextList;
    final ArrayList<Boolean> checkBool = new ArrayList<Boolean>();
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q7);

        int editTextId[] = new int[] {
                R.id.f3s7v1,
                R.id.f3s7v2,
                R.id.f3s7v3,
                R.id.f3s7v4,
                R.id.f3s7v5,
                R.id.f3s7v6,
                R.id.f3s7v7,
                R.id.f3s7v8,
                R.id.f3s7v9,
                R.id.f3s7v10
        };

        editTextList = new EditText[10];

        // editText findView
        for (int i = 0; i < editTextId.length; i++) {
            editTextList[i] = (EditText) findViewById(editTextId[i]);
        }

        Button next = (Button) findViewById(R.id.f3s7_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < editTextList.length; i++) {
                    checkBool.add(EditText_ValidCheck(editTextList[i].getText().toString(), editTextList[i]));
                }

                if (checkBool.contains(false)){
                    checkBool.clear();
                }else{



                    // TODO: 9/23/2017 start insert to databse

                    arrayList.clear();
                    for (int i =0; i<editTextList.length;i++){
                        arrayList.add(editTextList[i].getText().toString());
                    }
                    // TODO: 9/23/2017 end insert to databse



                    startActivity(new Intent(F3Q7.this, F3Q8.class));
                }
            }
        });

    }


    private boolean EditText_ValidCheck(String text, EditText editText) {
        if (text.matches("")) {
            editText.setError("این فیلد الزامی است");
            return false;
        }
        else return true;
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
