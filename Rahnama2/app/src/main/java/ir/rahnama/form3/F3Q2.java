package ir.rahnama.form3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

import ir.rahnama.R;
import ir.rahnama.form1.convertinttotext;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class F3Q2 extends AppCompatActivity {

//    boolean[] flag = new boolean[43];
    boolean finalFlag = true;
    private ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3_q2);


        final TextView tv = (TextView) findViewById(R.id.F3S2);

        final EditText et_f3S2v2 = (EditText) findViewById(R.id.F3S2V2);




        final int[][] multi = new int[][]{
//              RadioButton OK   RadioButton KO  EditText        TextView        convert
                {R.id.F3S2V1,    R.id.F3S2V3,   R.id.F3S2V2,   R.id.F3S2_tv1 , R.id.convert_F3S2V2  },
                {R.id.F3S2V4,    R.id.F3S2V6,   R.id.F3S2V5,   R.id.F3S2_tv2 , R.id.convert_F3S2V5 },
                {R.id.F3S2V7,    R.id.F3S2V9,   R.id.F3S2V8,   R.id.F3S2_tv3 , R.id.convert_F3S2V8},
                {R.id.F3S2V10,   R.id.F3S2V12,  R.id.F3S2V11,  R.id.F3S2_tv4 , R.id.convert_F3S2V11},
                {R.id.F3S2V13,   R.id.F3S2V15,  R.id.F3S2V14,  R.id.F3S2_tv5 , R.id.convert_F3S2V14},
                {R.id.F3S2V16,   R.id.F3S2V18,  R.id.F3S2V17,  R.id.F3S2_tv6 , R.id.convert_F3S2V17},
                {R.id.F3S2V19,   R.id.F3S2V21,  R.id.F3S2V20,  R.id.F3S2_tv7 , R.id.convert_F3S2V20},
                {R.id.F3S2V22,   R.id.F3S2V24,  R.id.F3S2V23,  R.id.F3S2_tv8 , R.id.convert_F3S2V23},
                {R.id.F3S2V25,   R.id.F3S2V27,  R.id.F3S2V26,  R.id.F3S2_tv9 , R.id.convert_F3S2V26},
                {R.id.F3S2V28,   R.id.F3S2V30,  R.id.F3S2V29,  R.id.F3S2_tv10 , R.id.convert_F3S2V29},
                {R.id.F3S2V31,   R.id.F3S2V33,  R.id.F3S2V32,  R.id.F3S2_tv11 , R.id.convert_F3S2V32},
                {R.id.F3S2V34,   R.id.F3S2V36,  R.id.F3S2V35,  R.id.F3S2_tv12 , R.id.convert_F3S2V35},
                {R.id.F3S2V37,   R.id.F3S2V39,  R.id.F3S2V38,  R.id.F3S2_tv13 , R.id.convert_F3S2V38},
                {R.id.F3S2V40,   R.id.F3S2V42,  R.id.F3S2V41,  R.id.F3S2_tv14 , R.id.convert_F3S2V41},
                {R.id.F3S2V43,   R.id.F3S2V45,  R.id.F3S2V44,  R.id.F3S2_tv15 , R.id.convert_F3S2V44},
                {R.id.F3S2V46,   R.id.F3S2V48,  R.id.F3S2V47,  R.id.F3S2_tv16 , R.id.convert_F3S2V47},
                {R.id.F3S2V49,   R.id.F3S2V51,  R.id.F3S2V50,  R.id.F3S2_tv17 , R.id.convert_F3S2V50},
                {R.id.F3S2V52,   R.id.F3S2V54,  R.id.F3S2V53,  R.id.F3S2_tv18 ,R.id.convert_F3S2V53},
                {R.id.F3S2V55,   R.id.F3S2V57,  R.id.F3S2V56,  R.id.F3S2_tv19 , R.id.convert_F3S2V56},
                {R.id.F3S2V58,   R.id.F3S2V60,  R.id.F3S2V59,  R.id.F3S2_tv19 , R.id.convert_F3S2V59},
                {R.id.F3S2V61,   R.id.F3S2V63,  R.id.F3S2V62,  R.id.F3S2_tv20 , R.id.convert_F3S2V62},
                {R.id.F3S2V64,   R.id.F3S2V66,  R.id.F3S2V65,  R.id.F3S2_tv21 , R.id.convert_F3S2V65},
                {R.id.F3S2V67,   R.id.F3S2V69,  R.id.F3S2V68,  R.id.F3S2_tv22 , R.id.convert_F3S2V68},
                {R.id.F3S2V70,   R.id.F3S2V72,  R.id.F3S2V71,  R.id.F3S2_tv23 , R.id.convert_F3S2V71},
                {R.id.F3S2V73,   R.id.F3S2V75,  R.id.F3S2V74,  R.id.F3S2_tv24 , R.id.convert_F3S2V74},
                {R.id.F3S2V76,   R.id.F3S2V78,  R.id.F3S2V77,  R.id.F3S2_tv25 , R.id.convert_F3S2V77},
                {R.id.F3S2V79,   R.id.F3S2V81,  R.id.F3S2V80,  R.id.F3S2_tv26 , R.id.convert_F3S2V80},
                {R.id.F3S2V82,   R.id.F3S2V84,  R.id.F3S2V83,  R.id.F3S2_tv26 , R.id.convert_F3S2V83},
                {R.id.F3S2V85,   R.id.F3S2V87,  R.id.F3S2V86,  R.id.F3S2_tv27 , R.id.convert_F3S2V86},
                {R.id.F3S2V88,   R.id.F3S2V90,  R.id.F3S2V89,  R.id.F3S2_tv28 , R.id.convert_F3S2V89},
                {R.id.F3S2V91,   R.id.F3S2V93,  R.id.F3S2V92,  R.id.F3S2_tv29 , R.id.convert_F3S2V92},
                {R.id.F3S2V94,   R.id.F3S2V96,  R.id.F3S2V95,  R.id.F3S2_tv30 , R.id.convert_F3S2V95},
                {R.id.F3S2V97,   R.id.F3S2V99,  R.id.F3S2V98,  R.id.F3S2_tv31 , R.id.convert_F3S2V98},
                {R.id.F3S2V100,  R.id.F3S2V102, R.id.F3S2V101, R.id.F3S2_tv32 , R.id.convert_F3S2V101},
                {R.id.F3S2V103,  R.id.F3S2V105, R.id.F3S2V104, R.id.F3S2_tv33 , R.id.convert_F3S2V104},
                {R.id.F3S2V106,  R.id.F3S2V108, R.id.F3S2V107, R.id.F3S2_tv34 , R.id.convert_F3S2V107},
                {R.id.F3S2V109,  R.id.F3S2V111, R.id.F3S2V110, R.id.F3S2_tv35 , R.id.convert_F3S2V110},
                {R.id.F3S2V112,  R.id.F3S2V114, R.id.F3S2V113, R.id.F3S2_tv36 , R.id.convert_F3S2V113},
                {R.id.F3S2V115,  R.id.F3S2V117, R.id.F3S2V116, R.id.F3S2_tv37 , R.id.convert_F3S2V116},
                {R.id.F3S2V118,  R.id.F3S2V120, R.id.F3S2V119, R.id.F3S2_tv38 , R.id.convert_F3S2V119},
                {R.id.F3S2V121,  R.id.F3S2V123, R.id.F3S2V122, R.id.F3S2_tv39 , R.id.convert_F3S2V122},
                {R.id.F3S2V124,  R.id.F3S2V126, R.id.F3S2V125, R.id.F3S2_tv40 , R.id.convert_F3S2V125},
                {R.id.F3S2V127,  R.id.F3S2V129, R.id.F3S2V128, R.id.F3S2_tv41 , R.id.convert_F3S2V128}
        };

        final TextView[] listOfTextView = new TextView[43];
        final CheckBox[] listOfCheckBoxsOk = new CheckBox[43];
        final CheckBox[] listOfCheckBoxsKo = new CheckBox[43];
        final EditText[] listOfEditText = new EditText[43];
        final TextView[] convertTv = new TextView[43];
        final convertinttotext convertint =  new convertinttotext();

        for (int i = 0; i < 43; i++) {
            listOfCheckBoxsOk[i] = (CheckBox) findViewById(multi[i][0]);
            listOfCheckBoxsKo[i] = (CheckBox) findViewById(multi[i][1]);
            listOfEditText[i] = (EditText) findViewById(multi[i][2]);
            listOfTextView[i] = (TextView) findViewById(multi[i][3]);
            convertTv[i] = (TextView) findViewById(multi[i][4]);


            final int finalI = i;
            listOfCheckBoxsOk[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listOfCheckBoxsOk[finalI].isChecked()) {
                        listOfCheckBoxsKo[finalI].setVisibility(View.GONE);
                        listOfEditText[finalI].setVisibility(View.GONE);
                    } else {
                        listOfCheckBoxsKo[finalI].setVisibility(View.VISIBLE);
                        listOfEditText[finalI].setVisibility(View.VISIBLE);
                    }
                }
            });
            listOfCheckBoxsKo[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listOfCheckBoxsKo[finalI].isChecked()) {
                        listOfCheckBoxsOk[finalI].setVisibility(View.GONE);
                        listOfEditText[finalI].setVisibility(View.GONE);
                    } else {
                        listOfCheckBoxsOk[finalI].setVisibility(View.VISIBLE);
                        listOfEditText[finalI].setVisibility(View.VISIBLE);
                    }
                }
            });
            listOfEditText[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {
                        convertTv[finalI].setText(convertint.price_convert_1000(Integer.parseInt(s.toString())));
                    }
                    catch (Exception e)
                    {
                        convertTv[finalI].setText("");
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            listOfEditText[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (listOfEditText[finalI].getText().toString().matches("")){
                        listOfCheckBoxsKo[finalI].setVisibility(View.VISIBLE);
                        listOfCheckBoxsOk[finalI].setVisibility(View.VISIBLE);
                    }else{
                        listOfCheckBoxsKo[finalI].setVisibility(View.GONE);
                        listOfCheckBoxsOk[finalI].setVisibility(View.GONE);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }


        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finalFlag = true;


                for (int i = 0; i < 43; i++) {
                    if (listOfCheckBoxsKo[i].isChecked() || listOfCheckBoxsOk[i].isChecked() || !listOfEditText[i].getText().toString().matches("")) {
//                        flag[i] = true;
                        listOfTextView[i].setError(null);
                    } else {
//                        flag[i] = false;
                        finalFlag = false;
                        listOfTextView[i].setError("");
                        listOfEditText[i].setError("این فیلد الزامی است");
                    }
                }

                Toast.makeText(F3Q2.this, (finalFlag)?"true":"false", Toast.LENGTH_SHORT).show();

                if (finalFlag) {

                    // TODO: 9/23/2017 start insert to database
                    arrayList.clear();
                    for (int i = 0; i < 43; i++) {
                        if (listOfCheckBoxsOk[i].isChecked()) {

                            arrayList.add("1");
                        } else if (listOfCheckBoxsKo[i].isChecked()) {
                            arrayList.add("0");
                        } else {
                            arrayList.add(listOfEditText[i].getText().toString());
                        }
                    }

                    // TODO: 9/23/2017 end insert to database


//                    MyDebug myDebug = new MyDebug(F3Q2.this, arrayList);

                    startActivity(new Intent(F3Q2.this, F3Q5.class));
                }
            }
        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
