package ir.farsibase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by amir on 9/11/2017.
 */
public class f1s5 extends Activity {

    Button button;

    String[] sports,sale;
    private RadioGroup g1,g2;
    Context context = this;
    RadioButton radioButton,radioButton1,radioButton2,radioButton3;
    RadioButton radioButton4,radioButton5,radioButton6,radioButton7;

    ArrayList<String> al=new ArrayList<String>();





    Boolean field_1 = false;

    Boolean field_2 = false;



    private Button btnDisplay;
    EditText idkar,idvanet,hazenehkar,hazenehvanet;
    ArrayAdapter<String> adapter;
    String[] idp;
    LinearLayout la_kar,la_vanet;
    RadioGroup radioGroup,radioGroup1;
    TextView terror,terror2;
    Boolean flag_1=false,flag_2=false,flag_3=false,flag_4=false,flag_5=false,flag_6=false;

    Boolean flag_firstone=false;
    Boolean flag_second=false;
    Boolean flag_third=false;


    Boolean edit_falg =false;
    Boolean edit_flag_vanet=false;

    Boolean bcar=false,bvanet=false;
//    SharedPreferences preferences=getSharedPreferences("State",MODE_PRIVATE);

    int car = 0,truck=0;

    String flag = "0";
    private RadioGroup f1s5v2;
    private RadioGroup f1s5v5;

    EditText f1s5v1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1s5);



        idkar = (EditText) findViewById(R.id.f1s5v1);
        idvanet = (EditText) findViewById(R.id.f1s5v4);
        hazenehkar = (EditText) findViewById(R.id.f1s5v3);
        hazenehvanet = (EditText) findViewById(R.id.f1s5v6);



        btnDisplay = (Button) findViewById(R.id.btnclick9);

        la_kar = (LinearLayout) findViewById(R.id.la_kar);
        la_vanet = (LinearLayout) findViewById(R.id.la_vanet);
        f1s5v2 =(RadioGroup)findViewById(R.id.f1s5v2);
        f1s5v5 = (RadioGroup)findViewById(R.id.f1s5v5);

        radioButton = (RadioButton)findViewById(R.id.f1s5v2_1);
        radioButton1= (RadioButton)findViewById(R.id.f1s5v2_2);
        radioButton2= (RadioButton)findViewById(R.id.f1s5v2_3);
        radioButton3= (RadioButton)findViewById(R.id.f1s5v2_4);

        radioButton4 = (RadioButton)findViewById(R.id.f1s5v5_1);
        radioButton5= (RadioButton)findViewById(R.id.f1s5v5_2);
        radioButton6= (RadioButton)findViewById(R.id.f1s5v5_3);
        radioButton7= (RadioButton)findViewById(R.id.f1s5v5_4);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);


        View vs = (View)viewGroup.findViewById(R.id.line_hseshidden);
        View vs1 = (View)viewGroup.findViewById(R.id.line_hseshidden2);



        SharedPreferences preferences =getSharedPreferences("State",MODE_PRIVATE);
        if(preferences!=null) {
            String c = preferences.getString("car", "");
            String t = preferences.getString("truck", "");
            car = Integer.parseInt(c);
            truck = Integer.parseInt(t);

            f1s5v1 = (EditText)findViewById(R.id.f1s5v1);
            f1s5v1.setText(preferences.getString("car",null));
            EditText e2 = (EditText)findViewById(R.id.f1s5v4);
            e2.setText(preferences.getString("truck",null));
        }


        if(car>0)
        {
            flag="s1";
            vs.setVisibility(View.VISIBLE);
            if(truck>0)
            {
                flag="2sv";
                vs1.setVisibility(View.VISIBLE);
            }
        }
        else if(truck>0)
        {
            flag="1v";
            vs.setVisibility(View.VISIBLE);
        }






        f1s5v2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s5v2_1:
                        radioButton.getText();
                        flag_1=true;
                        edit_falg=false;
                        la_kar.setVisibility(View.GONE);
                        break;
                    case R.id.f1s5v2_2:
                        radioButton1.getText();
                        flag_1=true;
                        edit_falg=false;
                        la_kar.setVisibility(View.GONE);
                        break;
                    case R.id.f1s5v2_3:
                        radioButton2.getText();
                        edit_falg=false;
                        flag_1=true;
                        la_kar.setVisibility(View.GONE);
                        edit_falg=false;
                        break;
                    case R.id.f1s5v2_4:
                        radioButton3.getText();
                        flag_1=true;
                        la_kar.setVisibility(View.VISIBLE);
                        edit_falg = true;
                        break;
                }
            }
        });
        f1s5v5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s5v5_1:
                        flag_2=true;
                        la_vanet.setVisibility(View.GONE);
                        edit_flag_vanet=false;
                        break;
                    case R.id.f1s5v5_2:
                        flag_2=true;
                        la_vanet.setVisibility(View.GONE);
                        edit_flag_vanet=false;
                        break;
                    case R.id.f1s5v5_3:
                        flag_2=true;
                        la_vanet.setVisibility(View.GONE);
                        edit_flag_vanet=false;
                        break;
                    case R.id.f1s5v5_4:
                        flag_2=true;
                        la_vanet.setVisibility(View.VISIBLE);
                        edit_flag_vanet=true;
                        break;
                }

            }
        });


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                switch (flag) {
                    case "s1":

                        if(idkar.getText().toString().matches(""))
                        {
                            idkar.setError("این فیلد الزامی است.");
                            flag_5=false;
                        }
                        else
                        {
                            flag_5=true;
                        }

                        if(f1s5v2.getCheckedRadioButtonId()<=0)
                        {
                            radioButton.setError("این فیلد الزامی است.");
                            flag_firstone=false;
                        }
                        else
                        {
                            flag_firstone=true;
                            Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                        }



                        if(edit_falg)
                        {
                            if(hazenehkar.getText().toString().matches(""))
                            {
                                hazenehkar.setError("این فیلد الزامی است.");
                                bcar=false;
                            }
                            else
                            {
                                hazenehkar.getText();
                                bcar=true;
                            }

                            if(flag_5&&flag_firstone&&bcar)
                            {
                                RadioButton f1s5v2_sellected = (RadioButton)findViewById(f1s5v2.getCheckedRadioButtonId());
                                String f1s5v1_str = f1s5v1.getText().toString();
                                String f1s5v2_str = f1s5v2_sellected.getHint().toString();
                                String f1s5v3_str =  hazenehkar.getText().toString();

                                al.add(f1s5v1_str);
                                al.add(f1s5v2_str);
                                al.add(f1s5v3_str);

                                Intent i = new Intent(f1s5.this,f1s6.class);
                                startActivity(i);
                            }
                        }
                        else
                        {
                            if(flag_5&&flag_firstone)
                            {
                                RadioButton f1s5v2_sellected = (RadioButton)findViewById(f1s5v2.getCheckedRadioButtonId());
                                String f1s5v1_str = f1s5v1.getText().toString();
                                String f1s5v2_str = f1s5v2_sellected.getHint().toString();

                                al.add(f1s5v1_str);
                                al.add(f1s5v2_str);
                                al.add("");
                                Intent i = new Intent(f1s5.this,f1s6.class);
                                startActivity(i);

                            }
                        }
                        break;
                    case "1v" :
                        if(idvanet.getText().toString().matches(""))
                        {
                            idvanet.setError("این فیلد الزامی است.");
                            flag_6=false;
                        }
                        else
                        {
                            idvanet.getText();
                            flag_6=true;
                        }
                        if(f1s5v5.getCheckedRadioButtonId()<=0)
                        {
                            radioButton4.setError("این فیلد الزامی است.");
                            flag_second=false;
                        }
                        else
                        {
                            flag_second=true;
                        }


                        if(edit_flag_vanet)
                        {
                            if(hazenehvanet.getText().toString().matches(""))
                            {
                                hazenehvanet.setError("این فیلد الزامی است.");
                                bvanet=false;
                            }
                            else
                            {
                                hazenehvanet.getText();
                                bvanet=true;
                            }
                            if(flag_6&&flag_second&&bvanet)
                            {
                                RadioButton f1s5v5_sellected = (RadioButton)findViewById(f1s5v5.getCheckedRadioButtonId());
                                String f1s5v4_str = idvanet.getText().toString();
                                String f1s5v5_str = f1s5v5_sellected.getHint().toString();
                                String f1s5v6_str =  hazenehvanet.getText().toString();

                                al.add(f1s5v4_str);
                                al.add(f1s5v5_str);
                                al.add(f1s5v6_str);

                                Intent is = new Intent(f1s5.this, f1s6.class);
                                startActivity(is);

                            }
                            else
                            {
                                Toast.makeText(f1s5.this, "همه فیلد ها ضروری هستند.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            if(flag_6&&flag_second)
                            {
                                RadioButton f1s5v5_sellected = (RadioButton)findViewById(f1s5v5.getCheckedRadioButtonId());
                                String f1s5v4_str = idvanet.getText().toString();
                                String f1s5v5_str = f1s5v5_sellected.getHint().toString();

                                al.add(f1s5v4_str);
                                al.add(f1s5v5_str);
                                al.add("");
                                Intent is = new Intent(f1s5.this, f1s6.class);
                                startActivity(is);
                            }
                        }

                        break;
                    case  "2sv":

                        if(idkar.getText().toString().matches(""))
                        {
                            idkar.setError("این فیلد الزامی است.");
                            flag_5=false;
                        }
                        else
                        {
                            flag_5=true;
                        }

                        if(f1s5v2.getCheckedRadioButtonId()<=0)
                        {
                            radioButton.setError("این فیلد الزامی است.");
                            flag_firstone=false;
                        }
                        else
                        {
                            flag_firstone=true;
                            Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                        }

                        if(edit_falg)
                        {
                            if(hazenehkar.getText().toString().matches(""))
                            {
                                hazenehkar.setError("این فیلد الزامی است.");
                                bcar=false;
                            }
                            else
                            {
                                hazenehkar.getText();
                                bcar=true;
                            }
                            if(flag_5&&flag_firstone&&bcar)
                            {
                                Toast.makeText(context, "ok car edt", Toast.LENGTH_SHORT).show();
                                field_1 = true;
                            }
                            else
                            {
                                field_1 = false;
                            }
                        }
                        else
                        {
                            if(flag_5&&flag_firstone)
                            {
                                Toast.makeText(context, "ok car", Toast.LENGTH_SHORT).show();
                                field_1 = true;
                            }
                            else
                            {
                                field_1 = false;
                            }
                        }

                        if(idvanet.getText().toString().matches(""))
                        {
                            idvanet.setError("این فیلد الزامی است.");
                            flag_6=false;
                        }
                        else
                        {
                            idvanet.getText();
                            flag_6=true;
                        }
                        if(f1s5v5.getCheckedRadioButtonId()<=0)
                        {
                            radioButton4.setError("این فیلد الزامی است.");
                            flag_second=false;
                        }
                        else
                        {
                            flag_second=true;
                        }


                        if(edit_flag_vanet)
                        {
                            if(hazenehvanet.getText().toString().matches(""))
                            {
                                hazenehvanet.setError("این فیلد الزامی است.");
                                bvanet=false;
                            }
                            else
                            {
                                hazenehvanet.getText();
                                bvanet=true;
                            }
                            if(flag_6&&flag_second&&bvanet)
                            {
                                field_2 = true;
                            }
                            else
                            {
                                Toast.makeText(f1s5.this, "همه فیلد ها ضروری هستند.", Toast.LENGTH_SHORT).show();
                                field_2 = false;
                            }
                        }
                        else
                        {
                            if(flag_6&&flag_second)
                            {
                                field_2 = true;
                            }
                            else
                            {
                                field_2 = false;
                            }
                        }

                        if(field_1&&field_2)
                        {
                            Intent i = new Intent(f1s5.this,f1s6.class);
                            startActivity(i);
                        }





                        break;

                }


            }
        });


    }

    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
