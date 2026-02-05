package ir.farsibase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.PopupMenu;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Reza on 9/8/2017.
 */
public class f1s7 extends Activity {

    /**
     * Called when the activity is first created
     */

    Boolean flag= false;
    Boolean flag_= false;

    ArrayList<String> al=new ArrayList<String>();


    Boolean flag_ed_first=false;

    Boolean flag_yearsago = false;
    Boolean flag_car_type = false;
    Boolean flag_stateofcar = false;
    Boolean flag_stateofcar2 = false;


    Boolean flag_all1= false;
    Boolean flag_all2= false;
    Boolean flag_all3= false;
    Boolean flag_all4= false;
    Boolean flag_all5=false;
    Boolean flag_all6 = false;
    Boolean flag_all7 = false;
    Boolean flag_all8 = false;
    private boolean flag_f1s7v15= false;
    private Boolean flag_edt_f1s7v15= false;
    private Boolean flag_f1s7v16= false;
    private Boolean flagreturn_f1s7v17= false;
    private Boolean flag_f1s7v18= false;
    private boolean flag_f1s7v19= false;
    private boolean flag_f1s7v20= false;
    private boolean flag_f1s7v1= false;
    private boolean flag_f1s7v2= false;
    private Boolean flag_f1s7v3= false;
    private boolean flag_f1s7v4= false;
    private boolean flag_f1s7v5= false;
    private Boolean flag_f1s7v6= false;
    private boolean flag_f1s7v7_show= false;
    private boolean flag_f1s7v7= false;
    private boolean flag_f1s7v8= false;
    private boolean flag_f1s7v9= false;
    private boolean flag_f1s7v10= false;
    private boolean flag_f1s7v11= false;
    private boolean flag_f1s7v12= false;
    private boolean flag_f1s7v12_show= false;
    private boolean flag_f1s7v14= false;
    private boolean flag_f1s7v17_show= false;
    private boolean flag_f1s7v16_show= false;
    private boolean flag_f1s7v2_show= false;
    private Boolean flag_filed1= false;
    private Boolean flag_filed2= false;
    private boolean flag_filed3= false;
    private boolean flag_filed4= false;
    private boolean flag_f1s7v13 = false;
    private boolean flag_f1s7v17 = false;

    String result_f1s7v6 ="";



    EditText f1s7v3;
    EditText f1s7v7;
    EditText f1s7v13;
    private String result_f1s7v16;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1s7);




        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);


        final String[] strv1 = getResources().getStringArray(R.array.f1s7v1);
        ArrayAdapter adpater = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,strv1);
        final Spinner f1s7v1 = (Spinner) findViewById(R.id.f1s7v1);
        f1s7v1.setAdapter(adpater);

        f1s7v1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(f1s7.this, ""+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(f1s7.this, "Nothing", Toast.LENGTH_SHORT).show();
            }
        });


        String[] strv2 = getResources().getStringArray(R.array.f1s7v2);

        ArrayAdapter adapterv2 = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, strv2);
        final Spinner f1s7v2 = (Spinner) findViewById(R.id.f1s7v2);
        f1s7v2.setAdapter(adapterv2);

        f1s7v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(f1s7.this, ""+f1s7v2.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final RadioGroup f1s7v4 = (RadioGroup) findViewById(R.id.f1s7v4);
        final RadioButton f1s7v4_1 = (RadioButton)findViewById(R.id.f1s7v4_1);
        final RadioButton f1s7v4_2 = (RadioButton)findViewById(R.id.f1s7v4_2);

        f1s7v4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s7v4_1:
                        f1s7v4_1.getHint();
                        break;
                    case R.id.f1s7v4_2:
                        f1s7v4_2.getHint();
                        break;
                }

            }
        });

        //inja

        final Spinner f1s7v8 = (Spinner)findViewById(R.id.f1s7v8);

        final Spinner f1s7v9 = (Spinner)findViewById(R.id.f1s7v9);
        final Spinner f1s7v10 = (Spinner)findViewById(R.id.f1s7v10);




        final RadioGroup f1s7v14 = (RadioGroup) findViewById(R.id.f1s7v14);
        final RadioButton f1s7v14_1 =(RadioButton)findViewById(R.id.f1s7v14_1);
        final RadioButton f1s7v14_2 =(RadioButton)findViewById(R.id.f1s7v14_2);

        f1s7v14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.f1s7v14_1:
                        f1s7v14_1.getHint();
                        break;
                    case R.id.f1s7v14_2:
                        f1s7v14_2.getHint();
                        break;
                }
            }
        });


        final String[] strv6 = getResources().getStringArray(R.array.f1s7v6);

        ArrayAdapter adapterv6 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, strv6);
        final ListView f1s7v6 = (ListView) findViewById(R.id.f1s7v6);
        f1s7v6.setAdapter(adapterv6);
        f1s7v6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String state="";
                if(position==0)
                {
                    state=strv6[0];
                    View v = (View)viewGroup.findViewById(R.id.liner__hidden);
                    v.setVisibility(View.GONE);
                    flag_f1s7v7_show=false;
                    result_f1s7v6="1";
                    EditText f1s7v7 = (EditText)findViewById(R.id.f1s7v7);
                    f1s7v7.setText("");

                }
                else
                {
                    state=strv6[1];
                    Toast.makeText(f1s7.this, ""+state, Toast.LENGTH_SHORT).show();
                    View v = (View)viewGroup.findViewById(R.id.liner__hidden);
                    v.setVisibility(View.VISIBLE);
                    result_f1s7v6="2";
                    flag_f1s7v7_show=true;

                }
            }
        });





        //tops ok
        ArrayAdapter adapterv9 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, strv6);
        final ListView f1s7v16 = (ListView) findViewById(R.id.f1s7v16);
        f1s7v16.setAdapter(adapterv9);
        f1s7v16.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String state="";
                if(position==0)
                {
                    state=strv6[0];
                    View v = (View)viewGroup.findViewById(R.id.limnv_hidden);
                    v.setVisibility(View.GONE);
                    flag_f1s7v16_show  =false;
                    result_f1s7v16 = "1";
                    EditText f1s7v17 = (EditText)findViewById(R.id.f1s7v17);
                    f1s7v17.setText("");
                }
                else
                {
                    state=strv6[1];
                    View v = (View)viewGroup.findViewById(R.id.limnv_hidden);
                    v.setVisibility(View.VISIBLE);
                    result_f1s7v16 = "2";
                    flag_f1s7v16_show= true;

                }
            }
        });



        f1s7v2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    View v = (View)viewGroup.findViewById(R.id.hidden1);
                    v.setVisibility(v.VISIBLE);
                    flag_f1s7v2_show=true;
                }else{
                    View v = (View)viewGroup.findViewById(R.id.hidden1);
                    v.setVisibility(v.GONE);
                    flag_f1s7v2_show=false;
                    EditText f1s7v3 = (EditText)findViewById(R.id.f1s7v3);
                    f1s7v3.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        final Spinner f1s7v18 = (Spinner)findViewById(R.id.f1s7v18);
        final Spinner f1s7v19 = (Spinner)findViewById(R.id.f1s7v19);
        final Spinner f1s7v20 = (Spinner)findViewById(R.id.f1s7v20);

        //first there



        //last there




        ArrayAdapter adapterv7 = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, strv2);
        final Spinner f1s7v12 = (Spinner) findViewById(R.id.f1s7v12);
        f1s7v12.setAdapter(adapterv7);

        f1s7v12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3) {
                    View v = (View)viewGroup.findViewById(R.id.hidden2);
                    v.setVisibility(v.VISIBLE);
                    flag_f1s7v12_show=true;
                }else{
                    View v = (View)viewGroup.findViewById(R.id.hidden2);
                    v.setVisibility(v.GONE);
                    flag_f1s7v12_show=false;
                    EditText f1s7v13 = (EditText)findViewById(R.id.f1s7v13);
                    f1s7v13.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


   //spg
        final Spinner f1s7v11 = (Spinner)findViewById(R.id.f1s7v11);
        ArrayAdapter adapterv72 = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, strv1);
        f1s7v11.setAdapter(adapterv72);
        f1s7v11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Button btnclick = (Button)findViewById(R.id.bt12);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText f1s7v17 = (EditText)findViewById(R.id.f1s7v17);



                if(f1s7v1.getSelectedItemPosition()==0)
                {
                    flag_f1s7v1 = false;
                    Toast.makeText(f1s7.this, "لطفا مورد اول را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag_f1s7v1 = true;
                }

                if(f1s7v2.getSelectedItemPosition()==0)
                {
                    flag_f1s7v2 = false;
                    Toast.makeText(f1s7.this, "لطفا نوع خودرو را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag_f1s7v2 = true;
                }
                if(flag_f1s7v2_show)
                {
                     f1s7v3 = (EditText)findViewById(R.id.f1s7v3);
                    if(f1s7v3.getText().toString().matches(""))
                    {
                        f1s7v3.setError("این فیلد الزامی است.");
                        flag_f1s7v3 = false;
                    }
                    else
                    {
                        f1s7v3.getText();
                        flag_f1s7v3 = true;
                    }
                }

                TextView tx = (TextView)findViewById(R.id.textView6_22);

                if(f1s7v4.getCheckedRadioButtonId()<=0)
                {
                    flag_f1s7v4 = false;
                    tx.setError("");
                }
                else
                {
                    flag_f1s7v4 = true;
                    tx.setError(null);
                }


                EditText f1s7v5 = (EditText)findViewById(R.id.f1s7v5);
                if(f1s7v5.getText().toString().matches(""))
                {
                    f1s7v5.setError("این فیلد الزامی است.");
                    flag_f1s7v5 = false;
                }
                else
                {
                    f1s7v5.getText();
                    flag_f1s7v5 = true;
                }

                TextView ers = (TextView)findViewById(R.id.te_gxtVi2_ew9);
                if(f1s7v6.getCheckedItemCount()<=0)
                {
                    ers.setError("");
                    flag_f1s7v6 = false;
                }
                else
                {
                    flag_f1s7v6 = true;

                    ers.setError(null);
                    if(flag_f1s7v7_show)
                    {
                         f1s7v7 = (EditText)findViewById(R.id.f1s7v7);
                        if(f1s7v7.getText().toString().matches(""))
                        {
                            f1s7v7.setError("این فیلد الزامی است.");
                            flag_f1s7v7 = false;
                        }
                        else
                        {
                            f1s7v7.getText();
                            flag_f1s7v7 = true;

                        }
                    }
                }

                if(f1s7v8.getSelectedItemPosition()==0)
                {
                    Toast.makeText(f1s7.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v8 = false;
                }
                else
                {
                    flag_f1s7v8 = true;
                }

                if(f1s7v9.getSelectedItemPosition()==0)
                {
                    Toast.makeText(f1s7.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v9 = false;
                }
                else
                {
                    flag_f1s7v9 =true;
                }

                if(f1s7v10.getSelectedItemPosition()==0)
                {
                    Toast.makeText(f1s7.this, "لطفا تیپ را وارد کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v10=false;
                }
                else
                {
                    flag_f1s7v10=true;
                }


                if(f1s7v11.getSelectedItemPosition()==0)
                {
                    Toast.makeText(f1s7.this, "لطفا مورد دوم را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v11 = false;
                }
                else
                {
                    flag_f1s7v11 = true;
                }
                if(f1s7v12.getSelectedItemPosition()==0)
                {
                    flag_f1s7v12 = false;
                    Toast.makeText(f1s7.this, "لطفا نوع خودرو را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else if(f1s7v12.getSelectedItemPosition()==3)
                {
                    flag_f1s7v12= true;

                    if(flag_f1s7v12_show)
                    {
                         f1s7v13 = (EditText)findViewById(R.id.f1s7v13);
                        if(f1s7v13.getText().toString().matches(""))
                        {
                            f1s7v13.setError("این فیلد الزامی است.");
                            flag_f1s7v13 =false;
                        }
                        else
                        {
                            flag_f1s7v13 =true;
                            f1s7v13.getText();
                        }
                    }
                }
                else
                {
                    flag_f1s7v12 = true;
                }
                if(f1s7v14.getCheckedRadioButtonId()<=0)
                {
                    Toast.makeText(f1s7.this, "لطفا وضعیت خودرو را مشخص کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v14 = false;
                }
                else
                {
                    flag_f1s7v14 = true;
                }

                EditText f1s7v15 = (EditText)findViewById(R.id.f1s7v15);
                if(f1s7v15.getText().toString().matches(""))
                {
                    f1s7v15.setError("این فیلد الزامی است.");
                    flag_f1s7v15 = false;
                }
                else
                {
                    flag_f1s7v15 = true;
                    f1s7v15.getText();
                }

                if(f1s7v16.getCheckedItemCount()<=0)
                {
                    Toast.makeText(f1s7.this, "لطفا نحوه خرید را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                    flag_f1s7v16 =false;
                }
                else if(flag_f1s7v16_show)
                {
                    flag_f1s7v16 =true;


                    if(f1s7v17.getText().toString().matches(""))
                    {
                        f1s7v17.setError("این فیلد الزامی است.");
                        flag_f1s7v17 = false;
                    }
                    else
                    {
                        flag_f1s7v17 = true;
                        f1s7v17.getText();
                    }
                }
                else {
                    flag_f1s7v16 = true;
                }

                if(f1s7v18.getSelectedItemPosition()==0)
                {
                    flag_f1s7v18 = false;
                    Toast.makeText(f1s7.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag_f1s7v18 = true;
                }

               if(f1s7v19.getSelectedItemPosition()==0)
                {
                    flag_f1s7v19 = false;
                    Toast.makeText(f1s7.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag_f1s7v19 = true;
                }


                if(f1s7v20.getSelectedItemPosition()==0)
                {
                    flag_f1s7v20 = false;
                    Toast.makeText(f1s7.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag_f1s7v20 = true;
                }

                //Toast.makeText(f1s7.this, ""+flag_f1s7v1+flag_f1s7v2+flag_f1s7v4+flag_f1s7v5+flag_f1s7v6+flag_f1s7v8+flag_f1s7v9+flag_f1s7v10, Toast.LENGTH_SHORT).show();
                if(flag_f1s7v1&&flag_f1s7v2&&flag_f1s7v4&&flag_f1s7v5&&flag_f1s7v6&&flag_f1s7v8&&
                        flag_f1s7v9&&flag_f1s7v10&&flag_f1s7v11&&flag_f1s7v12&&flag_f1s7v14&&
                        flag_f1s7v15&&flag_f1s7v16&&flag_f1s7v18&&flag_f1s7v19&&flag_f1s7v20)
                {
                    if(flag_f1s7v2_show)
                    {
                        if(flag_f1s7v3)
                        {
                            flag_filed1 = true;
                        }
                        else
                        {
                            flag_filed1 = false;
                        }
                    }
                    else if(flag_f1s7v2)
                    {
                        flag_filed1 = true;
                    }
                    if(flag_f1s7v7_show)
                    {
                        if(flag_f1s7v7)
                        {
                            flag_filed2 = true;
                        }
                        else
                        {
                            flag_filed2 = false;
                        }
                    }
                    else if( flag_f1s7v6)
                    {
                        flag_filed2 = true;
                    }
                    if(flag_filed1&&flag_filed2)
                    {
                        Toast.makeText(f1s7.this, "yes filed 1 va 2", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(f1s7.this, "no filed 1 va 2", Toast.LENGTH_SHORT).show();
                    }


                    // field 3 va 4


                    if(flag_f1s7v12_show)
                    {
                        if(flag_f1s7v13)
                        {
                            flag_filed3 = true;
                        }
                        else
                        {
                            flag_filed3 = false;
                        }
                    }
                    else if( flag_f1s7v12)
                    {
                        flag_filed3 = true;
                    }
                    if(flag_f1s7v16_show)
                    {
                        if(flag_f1s7v17)
                        {
                            flag_filed4 = true;
                        }
                        else
                        {
                            flag_filed4 = false;
                        }
                    }
                    else if(flag_f1s7v16)
                    {
                        flag_filed4 = true;
                    }
                    if(flag_filed3&&flag_filed4)
                    {
                        Toast.makeText(f1s7.this, "yes filed 3 va 4", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(f1s7.this, "no filed 3 va 4", Toast.LENGTH_SHORT).show();
                    }

                    if(flag_filed1&&flag_filed2&&flag_filed3&&flag_filed4)
                    {

                        RadioButton f1s7v4_sellected = (RadioButton)findViewById(f1s7v4.getCheckedRadioButtonId());
                        RadioButton f1s7v14_sellected = (RadioButton)findViewById(f1s7v14.getCheckedRadioButtonId());


                        String f1s7v1_str = Integer.toString(f1s7v1.getSelectedItemPosition()+1);
                        String f1s7v2_str =Integer.toString(f1s7v2.getSelectedItemPosition()+1);
                        String f1s7v3_str = f1s7v3.getText().toString();
                        String f1s7v4_str = f1s7v4_sellected.getHint().toString();
                        String f1s7v5_str = f1s7v5.getText().toString();
                        String f1s7v6_str = result_f1s7v6;
                        String f1s7v7_str = f1s7v7.getText().toString();
                        String f1s7v8_str =Integer.toString(f1s7v8.getSelectedItemPosition()+1);
                        String f1s7v9_str =Integer.toString(f1s7v9.getSelectedItemPosition()+1);
                        String f1s7v10_str =Integer.toString(f1s7v10.getSelectedItemPosition()+1);



                        String f1s7v11_str = Integer.toString(f1s7v11.getSelectedItemPosition()+1);
                        String f1s7v12_str =Integer.toString(f1s7v12.getSelectedItemPosition()+1);
                        String f1s7v13_str = f1s7v13.getText().toString();
                        String f1s7v14_str = f1s7v14_sellected.getHint().toString();
                        String f1s7v15_str = f1s7v15.getText().toString();
                        String f1s7v16_str = result_f1s7v16;
                        String f1s7v17_str = f1s7v17.getText().toString();
                        String f1s7v18_str =Integer.toString(f1s7v18.getSelectedItemPosition()+1);
                        String f1s7v19_str =Integer.toString(f1s7v19.getSelectedItemPosition()+1);
                        String f1s7v20_str =Integer.toString(f1s7v20.getSelectedItemPosition()+1);




                        al.add(f1s7v1_str);
                        al.add(f1s7v2_str);
                        al.add(f1s7v3_str);
                        al.add(f1s7v4_str);
                        al.add(f1s7v5_str);
                        al.add(f1s7v6_str);
                        al.add(f1s7v7_str);
                        al.add(f1s7v8_str);
                        al.add(f1s7v9_str);
                        al.add(f1s7v10_str);
                        al.add(f1s7v11_str);
                        al.add(f1s7v12_str);
                        al.add(f1s7v13_str);
                        al.add(f1s7v14_str);
                        al.add(f1s7v15_str);
                        al.add(f1s7v16_str);
                        al.add(f1s7v17_str);
                        al.add(f1s7v18_str);
                        al.add(f1s7v19_str);
                        al.add(f1s7v20_str);


                        Intent i  =new Intent(f1s7.this,f1s8.class);
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

