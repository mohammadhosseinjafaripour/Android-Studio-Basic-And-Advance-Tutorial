package ir.farsibase;

import android.content.Context;
import android.content.Intent;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s6 extends AppCompatActivity {


    Boolean all_1=false;
    Boolean all_2=false;
    Boolean all_3=false;
    Boolean all_4=false;
    Boolean all_5=false;




    int flag =0;
    Boolean flag_edt = false;
    Boolean flag_edt2 = false;

    Boolean flag_fr;

    //first
    Boolean flag__1=false;
    Boolean flag__2=false;
    Boolean flag__3=false;
    Boolean flag__4=false;
    Boolean flag__5=false;
    Boolean flag__6=false;
    Boolean flag__7=false;
    Boolean flag_month = false;
    Boolean flag_mark1 = false;
    Boolean flag_model1 = false;
    Boolean flag_tip1 = false;

    Boolean flag_mark2 = false;
    Boolean flag_model2 = false;
    Boolean flag_tip2 = false;



    //second

    Boolean flag___1=false;
    Boolean flag___2=false;
    Boolean flag___3=false;
    Boolean flag___4=false;
    Boolean flag_mark3 = false;
    Boolean flag_model3 = false;
    Boolean flag_tip3 = false;


    //third

    Boolean flag1 = false;
    Boolean flag2 = false;
    Boolean flag3 = false;
    Boolean flag4 = false;
    Boolean flag_month2 = false;

    Boolean flag_mark4 = false;
    Boolean flag_model4 = false;
    Boolean flag_tip4 = false;

    Boolean flag_f1s6v37 = false;
    ArrayList<String> al=new ArrayList<String>();
    EditText f1s6v26;
    EditText f1s6v28;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s6);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);


        final LinearLayout li_2 = (LinearLayout)findViewById(R.id.line2f1s6hidden);
        final LinearLayout li_1= (LinearLayout)findViewById(R.id.line1f1s6hidden);
        final LinearLayout li_3=(LinearLayout) findViewById(R.id.line3f1s6hidden);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.f1s6v4);
        final RadioButton rberror = (RadioButton)findViewById(R.id.f1s6v4_1);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                rberror.setError(null);
                switch(checkedId)
                {
                    case R.id.f1s6v4_1:
                        flag = 1;
                        viewGroup.invalidate();
                        li_1.setVisibility(View.VISIBLE);
                        li_3.setVisibility(View.GONE);
                        li_2.setVisibility(View.GONE);
                        if(flag==1)
                        {
                            final Spinner f1s6v5 = (Spinner) findViewById(R.id.f1s6v5) ;

                            final Spinner f1s6v6  = (Spinner) findViewById(R.id.f1s6v6) ;

                            final Spinner f1s6v7 =(Spinner)findViewById(R.id.f1s6v7);

                            String [] array = getResources().getStringArray(R.array.company);






                            //other

                            final Spinner f1s6v9 =(Spinner)findViewById(R.id.f1s6v9);

                            final Spinner f1s6v10 =(Spinner)findViewById(R.id.f1s6v10);

                            final Spinner f1s6v11 =(Spinner)findViewById(R.id.f1s6v11);



                            //

/*
                            ArrayAdapter snprAdapter56 = new ArrayAdapter(f1s6.this,R.layout.support_simple_spinner_dropdown_item,array);
                            spinner4.setAdapter(snprAdapter56);
                            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                                    final int [] arr2 =new int[]{
                                            R.array.brand_1,
                                            R.array.brand_2,
                                            R.array.brand_3,
                                            R.array.brand_4,
                                            R.array.brand_5,
                                            R.array.brand_6,
                                            R.array.brand_7,
                                            R.array.brand_8,
                                            R.array.brand_9,
                                            R.array.brand_10,
                                            R.array.brand_11,
                                            R.array.brand_12,
                                            R.array.brand_13,
                                            R.array.brand_14,
                                            R.array.brand_15,
                                            R.array.brand_16,
                                            R.array.brand_17,
                                            R.array.brand_18,
                                            R.array.brand_19,
                                            R.array.brand_20,
                                            R.array.brand_21,
                                            R.array.brand_22,
                                            R.array.brand_23

                                    };
                                    String [] array = getResources().getStringArray(arr2[position]);
                                    ArrayAdapter snprAdapter2 = new ArrayAdapter(f1s6.this,R.layout.support_simple_spinner_dropdown_item,array);
                                    spinner5.setAdapter(snprAdapter2);

                                    spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            int [] ar1 = new int[]{
                                                    R.array.tip_1,
                                                    R.array.tip_2,
                                                    R.array.tip_3,
                                                    R.array.tip_4,
                                                    R.array.tip_5,
                                                    R.array.tip_6
                                            };
                                            int [] ar2 = new int[]{
                                                    R.array.tip__1,
                                                    R.array.tip__2,
                                                    R.array.tip__3,
                                                    R.array.tip__4,
                                                    R.array.tip__5
                                            };
                                            int [] ar3 = new int[]
                                                    {
                                                            R.array.tip___1,
                                                            R.array.tip___2
                                                    };
                                            int [] ar4 = new int[]
                                                    {
                                                            R.array.tip____1,
                                                            R.array.tip____2,
                                                            R.array.tip____3,
                                                            R.array.tip____4

                                                    };
                                            int []ar5= new int[]
                                                    {
                                                            R.array.tip_____1
                                                    };
                                            int [] ar6 = new int []
                                                    {
                                                            R.array.tip______1,
                                                            R.array.tip______2
                                                    };
                                            int [] ar7 = new int []
                                                    {
                                                            R.array.tip_______1
                                                    };
                                            int []ar8 = new int []
                                                    {
                                                            R.array.tip________1
                                                    };

                                            int [] ar9 = new int[]
                                                    {
                                                            R.array.tip_________1
                                                    };
                                            int []ar10 = new int []
                                                    {
                                                            R.array.tip__________1
                                                    };
                                            int []ar11 = new int []
                                                    {
                                                            R.array.tip___________1
                                                    };
                                            int []ar12 = new int []
                                                    {
                                                            R.array.tip____________1,
                                                            R.array.tip____________2
                                                    };
                                            int []ar13 = new int []
                                                    {
                                                            R.array.tip_____________1
                                                    };
                                            int []ar14 = new int []
                                                    {
                                                            R.array.tip______________1
                                                    };
                                            int []ar15 = new int []
                                                    {
                                                            R.array.tip_______________1
                                                    };
                                            int []ar16 = new int []
                                                    {
                                                            R.array.tip________________1
                                                    };
                                            int []ar17 = new int []
                                                    {
                                                            R.array.tip_________________1
                                                    };
                                            int []ar18 = new int []
                                                    {
                                                            R.array.tip__________________1
                                                    };
                                            int []ar19 = new int []
                                                    {
                                                            R.array.tip___________________1
                                                    };
                                            int []ar20 = new int []
                                                    {
                                                            R.array.tip____________________1
                                                    };
                                            int []ar21 = new int []
                                                    {
                                                            R.array.tip_____________________1
                                                    };
                                            int []ar22 = new int []
                                                    {
                                                            R.array.tip______________________1
                                                    };
                                            int []ar23 = new int []
                                                    {
                                                            R.array.tip_______________________1,
                                                            R.array.tip_______________________2,
                                                            R.array.tip_______________________3
                                                    };



                                            int [][] arr5=new int[][]{
                                                    ar1,ar2,ar3,ar4,ar5,ar6,ar7,ar8,ar9,ar10,ar11,ar12,ar13,ar14,ar15,ar16,ar17,ar18,ar19,ar20,ar21,ar22,ar23
                                            };
                                            int position_array = spinner4.getSelectedItemPosition();




                                            String [] array = getResources().getStringArray(arr5[position_array][position]);


                                            ArrayAdapter snprAdapter2 = new ArrayAdapter(f1s6.this,R.layout.support_simple_spinner_dropdown_item,array);
                                            spinner6.setAdapter(snprAdapter2);

                                            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    //ico
                                                    int [] ar1 = new int []{
                                                            R.array.m1,
                                                            R.array.m2,
                                                            R.array.m3,
                                                            R.array.m4,
                                                            R.array.m5,
                                                            R.array.m6,
                                                            R.array.m7,
                                                            R.array.m8,
                                                            R.array.m9,
                                                            R.array.m10,
                                                            R.array.m11
                                                    };
                                                    //peguo
                                                    int [] ar2 = new int []{
                                                            R.array.m_1,
                                                            R.array.m_2,
                                                            R.array.m_3,
                                                            R.array.m_4,
                                                            R.array.m_5,
                                                            R.array.m_6,
                                                            R.array.m_7,
                                                            R.array.m_8,
                                                            R.array.m_9,
                                                            R.array.m_10,
                                                            R.array.m_11,
                                                            R.array.m_12,
                                                            R.array.m_13,
                                                            R.array.m_14,
                                                            R.array.m_15
                                                    };
                                                    //dongfeng
                                                    int []ar3 = new int []{
                                                            R.array.m__1
                                                    };
                                                    //reno
                                                    int []ar4 = new int []{
                                                            R.array.m___1,
                                                            R.array.m___2,
                                                            R.array.m___3,
                                                            R.array.m___4,
                                                            R.array.m___5,
                                                            R.array.m___6
                                                    };
                                                    //sozoki
                                                    int [] arr5_1 = new int []{
                                                            R.array.m____1,
                                                            R.array.m____2,
                                                            R.array.m____3

                                                    };
                                                    //hyma
                                                    int []ar5 = new int []{
                                                            R.array.m_____1,
                                                            R.array.m_____2,
                                                            R.array.m_____3
                                                    };
                                                    //siapa-kiya
                                                    int[]ar6= new int []{
                                                            R.array.m______1,
                                                            R.array.m______2,
                                                            R.array.m______3,
                                                            R.array.m______4,
                                                            R.array.m______5,
                                                            R.array.m______6,
                                                            R.array.m______7,
                                                            R.array.m______8,
                                                            R.array.m______9,
                                                            R.array.m______10

                                                    };
                                                    //siapa-saipa

                                                    int[]ar7= new int []{
                                                            R.array.m_______1,
                                                            R.array.m_______2,
                                                            R.array.m_______3,
                                                            R.array.m_______4,
                                                            R.array.m_______5,
                                                            R.array.m_______6
                                                    };

                                                    int []ar7_1 = new int []{
                                                            R.array.j1,
                                                            R.array.j2,
                                                            R.array.j3,
                                                            R.array.j4,
                                                            R.array.j5,
                                                            R.array.j6,
                                                            R.array.j7,
                                                            R.array.j9,
                                                            R.array.j10,
                                                            R.array.j11,
                                                            R.array.j12,
                                                            R.array.j13,
                                                            R.array.j14,

                                                    };
//                                zotia
                                                    int[]ar8= new int []{
                                                            R.array.m________1,
                                                            R.array.m________2,
                                                            R.array.m________3
                                                    };
//                                zantan
                                                    int[]ar9 = new int []{
                                                            R.array.m_________1,
                                                            R.array.m_________2

                                                    };
//                                citroen
                                                    int[]ar10 = new int []{
                                                            R.array.m__________1,
                                                            R.array.m__________2


                                                    };
//                                parskhodroreno
                                                    int[]ar12 = new int []{
                                                            R.array.m____________1,
                                                            R.array.m____________2,
                                                            R.array.m____________3,
                                                            R.array.m____________4,
                                                            R.array.m____________5,
                                                            R.array.m____________6


                                                    };
                                                    //                                berliance
                                                    int[]ar11 = new int []{
                                                            R.array.m___________1,
                                                            R.array.m___________2,
                                                            R.array.m___________3,
                                                            R.array.m___________4,
                                                            R.array.m___________5,
                                                            R.array.m___________6,
                                                            R.array.m___________7,
                                                            R.array.m___________8


                                                    };


//                                gili
                                                    int[]ar13 = new int []{
                                                            R.array.m_____________1

                                                    };
//                                lifan
                                                    int[]ar14 = new int []{
                                                            R.array.m______________1,
                                                            R.array.m______________2,
                                                            R.array.m______________3,
                                                            R.array.m______________4,
                                                            R.array.m______________5

                                                    };
//                                jack
                                                    int[]ar15 = new int []{
                                                            R.array.m_______________1,
                                                            R.array.m_______________2,
                                                            R.array.m_______________3,
                                                            R.array.m_______________4,
                                                            R.array.m_______________5

                                                    };

                                                    int []ar16= new int []{
                                                            R.array.m________________1,
                                                            R.array.m________________2,
                                                            R.array.m________________3
                                                    };

                                                    int[]ar17= new int[]{
                                                            R.array.m_________________1
                                                    };
                                                    int[]ar18 = new int []
                                                            {
                                                                    R.array.m__________________1
                                                            };
                                                    int[]ar19 = new int []{
                                                            R.array.m__________________2
                                                    };


                                                    int []ar20= new int []
                                                            {
                                                                    R.array.m___________________1,
                                                                    R.array.m___________________2,
                                                                    R.array.m___________________3,
                                                                    R.array.m___________________4,
                                                                    R.array.m___________________5,
                                                                    R.array.m___________________6,
                                                                    R.array.m___________________7,
                                                                    R.array.m___________________8,
                                                                    R.array.m___________________9,
                                                                    R.array.m___________________10,
                                                                    R.array.m___________________11,
                                                                    R.array.m___________________12,
                                                                    R.array.m___________________13,
                                                                    R.array.m___________________14,
                                                                    R.array.m___________________15,
                                                                    R.array.m___________________16,
                                                                    R.array.m___________________17,
                                                                    R.array.m___________________18,
                                                                    R.array.m___________________19,
                                                                    R.array.m___________________20,
                                                                    R.array.m___________________21,
                                                                    R.array.m___________________22,
                                                                    R.array.m___________________23,
                                                                    R.array.m___________________24
                                                            };
                                                    int []ar21 = new int []{
                                                            R.array.m____________________1,
                                                            R.array.m____________________2
                                                    };
                                                    int []ar22 = new int []{
                                                            R.array.m_____________________1,
                                                            R.array.m_____________________2,
                                                            R.array.m_____________________3,
                                                            R.array.m_____________________4,
                                                            R.array.m_____________________5,
                                                            R.array.m_____________________6,
                                                            R.array.m_____________________7,
                                                            R.array.m_____________________8,
                                                            R.array.m_____________________9,
                                                            R.array.m_____________________10,
                                                            R.array.m_____________________11,
                                                            R.array.m_____________________12,
                                                            R.array.m_____________________13,
                                                            R.array.m_____________________14,
                                                            R.array.m_____________________15,
                                                            R.array.m_____________________16,
                                                            R.array.m_____________________17
                                                    };
                                                    int[]ar23 = new int []
                                                            {
                                                                    R.array.m______________________1,
                                                                    R.array.m______________________2,
                                                                    R.array.m______________________3,
                                                                    R.array.m______________________4,
                                                                    R.array.m______________________5,
                                                                    R.array.m______________________6,
                                                                    R.array.m______________________7,
                                                                    R.array.m______________________8,
                                                                    R.array.m______________________9,
                                                                    R.array.m______________________10,
                                                                    R.array.m______________________11,
                                                                    R.array.m______________________12,
                                                                    R.array.m______________________13

                                                            };
                                                    int[]ar24 = new int []{
                                                            R.array.m_______________________1,
                                                            R.array.m_______________________2,
                                                            R.array.m_______________________3,
                                                            R.array.m_______________________4,
                                                            R.array.m_______________________5,
                                                            R.array.m_______________________6,
                                                            R.array.m_______________________7,
                                                            R.array.m_______________________8

                                                    };
                                                    int []ar25 = new int []
                                                            {
                                                                    R.array.m________________________1,
                                                                    R.array.m________________________2,
                                                                    R.array.m________________________3,
                                                                    R.array.m________________________4,
                                                                    R.array.m________________________5,
                                                                    R.array.m________________________6,
                                                                    R.array.m________________________7,
                                                                    R.array.m________________________8,
                                                                    R.array.m________________________9,
                                                                    R.array.m________________________10,
                                                                    R.array.m________________________11,
                                                                    R.array.m________________________12,
                                                                    R.array.m________________________13,
                                                                    R.array.m________________________14,
                                                                    R.array.m________________________15,
                                                                    R.array.m________________________16

                                                            };
                                                    int []ar26 = new int []{
                                                            R.array.m_________________________1,
                                                            R.array.m_________________________2,
                                                            R.array.m_________________________3,
                                                            R.array.m_________________________4,
                                                            R.array.m_________________________5,
                                                            R.array.m_________________________6,
                                                            R.array.m_________________________7,
                                                            R.array.m_________________________8


                                                    } ;

                                                    int []ar27 = new int []{
                                                            R.array.m__________________________1,
                                                            R.array.m__________________________2,
                                                            R.array.m__________________________3,
                                                            R.array.m__________________________4,
                                                            R.array.m__________________________5,
                                                            R.array.m__________________________6,
                                                            R.array.m__________________________7,
                                                            R.array.m__________________________8,
                                                            R.array.m__________________________9,
                                                            R.array.m__________________________10
                                                    };
                                                    int []ar28 = new int []{
                                                            R.array.m___________________________1,
                                                            R.array.m___________________________2,
                                                            R.array.m___________________________3,
                                                            R.array.m___________________________4
                                                    };

                                                    int []ar29 = new int []{
                                                            R.array.m____________________________1,
                                                            R.array.m____________________________2,
                                                            R.array.m____________________________3,
                                                            R.array.m____________________________4,
                                                            R.array.m____________________________5,
                                                            R.array.m____________________________6,
                                                            R.array.m____________________________7,
                                                            R.array.m____________________________8,
                                                            R.array.m____________________________9,
                                                            R.array.m____________________________10,
                                                            R.array.m____________________________11,
                                                            R.array.m____________________________13,
                                                            R.array.m____________________________14,
                                                            R.array.m____________________________15,
                                                            R.array.m____________________________16,
                                                            R.array.m____________________________17,
                                                            R.array.m____________________________18,
                                                            R.array.m____________________________19,
                                                            R.array.m____________________________20,
                                                            R.array.m____________________________21,
                                                            R.array.m____________________________22,
                                                            R.array.m____________________________23,
                                                            R.array.m____________________________24,
                                                            R.array.m____________________________25,
                                                            R.array.m____________________________26,
                                                            R.array.m____________________________27,
                                                            R.array.m____________________________28,
                                                            R.array.m____________________________29,
                                                            R.array.m____________________________30,
                                                            R.array.m____________________________31,
                                                            R.array.m____________________________32,
                                                            R.array.m____________________________33,
                                                            R.array.m____________________________34

                                                    };

                                                    int []ar30 = new int []{
                                                            R.array.m_____________________________1,
                                                            R.array.m_____________________________2,
                                                            R.array.m_____________________________3,
                                                            R.array.m_____________________________4
                                                    };

                                                    int []ar31 = new int []{
                                                            R.array.m______________________________1,
                                                            R.array.m______________________________2,
                                                            R.array.m______________________________3,
                                                            R.array.m______________________________4,
                                                            R.array.m______________________________5

                                                    };
                                                    int []ar32 = new int []{
                                                            R.array.m_______________________________1,
                                                            R.array.m_______________________________2,
                                                            R.array.m_______________________________3
                                                    };

                                                    int []ar33 = new int []{
                                                            R.array.m________________________________1,
                                                            R.array.m________________________________2,
                                                            R.array.m________________________________3,
                                                            R.array.m________________________________4
                                                    };

                                                    int []ar34 = new int []{
                                                            R.array.m_________________________________1,
                                                            R.array.m_________________________________2

                                                    };
                                                    int []ar35 = new int []{
                                                            R.array.m__________________________________1,
                                                            R.array.m__________________________________2,
                                                            R.array.m__________________________________3,
                                                            R.array.m__________________________________4

                                                    };
                                                    int []ar36 = new int []{
                                                            R.array.m___________________________________1,
                                                            R.array.m___________________________________2

                                                    };
                                                    int []ar37 = new int []{
                                                            R.array.m____________________________________1,
                                                            R.array.m____________________________________2,
                                                            R.array.m____________________________________3,
                                                            R.array.m____________________________________4,
                                                            R.array.m____________________________________5

                                                    };

                                                    int []ar38 = new int []{
                                                            R.array.m_____________________________________1,
                                                            R.array.m_____________________________________2,

                                                    };
                                                    int []ar39 = new int []{
                                                            R.array.m______________________________________1,
                                                            R.array.m______________________________________2,
                                                            R.array.m______________________________________3,
                                                            R.array.m______________________________________4,
                                                            R.array.m______________________________________5,
                                                            R.array.m______________________________________6,
                                                            R.array.m______________________________________7

                                                    };












                                                    //first brand array
                                                    int [][] ar_al = new int [][]{
                                                            ar1,ar2,ar3,ar4,arr5_1,ar5
                                                    };
                                                    int [][] ar_al1 = new int [][]{
                                                            ar6,ar7_1,ar7,ar8,ar9,ar10
                                                    };
                                                    int [][] ar_al2 = new int [][]{
                                                            ar11,ar12
                                                    };
                                                    int [][] ar_al3 = new int [][]{
                                                            ar13,ar14,ar15,ar16
                                                    };
                                                    int [][] ar_a14 = new int [][]{
                                                            ar17
                                                    };
                                                    int[][] ar_a15 = new int [][]{
                                                            ar18,ar19
                                                    };

                                                    int [][] ar_a16 = new int [][]{
                                                            ar20
                                                    };
                                                    int [][] ar_a17 = new int [][]
                                                            {
                                                                    ar21
                                                            };
                                                    int [][] ar_a18 = new int [][]
                                                            {
                                                                    ar22
                                                            };
                                                    int [][] ar_a19 = new int [][]
                                                            {
                                                                    ar23
                                                            };
                                                    int[][] ar_a20 = new int [][]
                                                            {
                                                                    ar24
                                                            };
                                                    int [][]ar_a21 = new int[][]
                                                            {
                                                                    ar25,ar26
                                                            };
                                                    int [][] ar_a22 = new int [][]
                                                            {
                                                                    ar27
                                                            };
                                                    int [][] ar_a23 = new int [][]
                                                            {
                                                                    ar28
                                                            };
                                                    int [][] ar_a24 = new int [][]
                                                            {
                                                                    ar29
                                                            };
                                                    int [][] ar_a25 = new int [][]
                                                            {
                                                                    ar30
                                                            };
                                                    int [][] ar_a26 = new int [][]
                                                            {
                                                                    ar31
                                                            };
                                                    int [][] ar_a27 = new int [][]{
                                                            ar32
                                                    };
                                                    int [][] ar_a28 = new int [][]{
                                                            ar33
                                                    };
                                                    int [][] ar_a29 = new int [][]{
                                                            ar34
                                                    };
                                                    int [][] ar_a30 = new int [][]{
                                                            ar35
                                                    };
                                                    int [][] ar_a31 = new int [][]{
                                                            ar36
                                                    };
                                                    int [][] ar_a32 = new int [][]{
                                                            ar37,ar38,ar39
                                                    };



                                                    int [][][] arr_all = new int[][][]{
                                                            ar_al,ar_al1,ar_al2,ar_al3,ar_a14,ar_a15,ar_a16,ar_a17,ar_a18,ar_a19,ar_a20,ar_a21,ar_a22,ar_a23,ar_a24,ar_a25,ar_a26,ar_a27,ar_a28,ar_a29,ar_a30,ar_a31,ar_a32
                                                    };


                                                    int first_ps = spinner4.getSelectedItemPosition();
                                                    int second_ps = spinner5.getSelectedItemPosition();
                                                    int third_ps = spinner6.getSelectedItemPosition();
                                                    String [] array = getResources().getStringArray(arr_all[first_ps][second_ps][third_ps]);
                                                    //ArrayAdapter snprAda = new ArrayAdapter(spinner.this,R.layout.support_simple_spinner_dropdown_item,array);
                                                    //sp4.setAdapter(snprAda);
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {



                                        }
                                    });

                                    //Toast.makeText(spinner.this, ""+array[position], Toast.LENGTH_SHORT).show();



                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            */





                            final RadioGroup f1s6v8 = (RadioGroup)findViewById(R.id.f1s6v8);
                            final RadioButton f1s6v8_1 = (RadioButton)findViewById(R.id.f1s6v8_1);
                            final RadioButton f1s6v8_2 = (RadioButton)findViewById(R.id.f1s6v8_2);

                            f1s6v8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    f1s6v8_1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v9:
                                            f1s6v8_1.getText();
                                            f1s6v8_1.getHint();
                                            break;
                                        case R.id.f1s6v10:
                                            f1s6v8_2.getText();
                                            f1s6v8_2.getHint();
                                            break;
                                    }
                                }
                            });

                            final RadioGroup f1s6v12= (RadioGroup)findViewById(R.id.f1s6v12);
                            final RadioButton rb = (RadioButton)findViewById(R.id.f1s6v12_1);
                            final RadioButton rb2 = (RadioButton)findViewById(R.id.f1s6v12_2);
                            f1s6v12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    rb.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v12_1:
                                            rb.getText();
                                            rb.getHint();
                                            break;
                                        case R.id.f1s6v12_2:
                                            rb2.getText();
                                            rb2.getHint();
                                            break;
                                    }
                                }
                            });

                            final RadioGroup f1s6v16 = (RadioGroup)findViewById(R.id.f1s6v16);
                            final RadioButton f1s6v16_1 = (RadioButton)findViewById(R.id.f1s6v16_1);
                            final RadioButton f1s6v16_2 = (RadioButton)findViewById(R.id.f1s6v16_2);
                            f1s6v16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    f1s6v16_1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v16_1:
                                            f1s6v16_1.getText();
                                            f1s6v16_1.getHint();
                                            break;
                                        case R.id.f1s6v16_2:
                                            f1s6v16_2.getText();
                                            f1s6v16_2.getHint();
                                            break;
                                    }
                                }
                            });

                            final EditText f1s6v13 = (EditText)findViewById(R.id.f1s6v13);
                            final EditText f1s6v14 = (EditText)findViewById(R.id.f1s6v14);
                            final EditText f1s6v15 = (EditText)findViewById(R.id.f1s6v15);
                            final EditText f1s6v17 = (EditText)findViewById(R.id.f1s6v17);
                            final EditText f1s6v18 = (EditText)findViewById(R.id.f1s6v18);
                            Button btn = (Button)findViewById(R.id.btnclick3);

                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if(f1s6v13.getText().toString().matches(""))
                                    {
                                        f1s6v13.setError("این فیلد الزامی است.");
                                        flag__1=false;
                                    }
                                    else {
                                        f1s6v13.getText();
                                        flag__1=true;
                                    }

                                    if(f1s6v14.getText().toString().matches(""))
                                    {
                                        flag_month = false;
                                        f1s6v14.setError("این فیلد الزامی است.");
                                    }
                                    else if(!(Integer.parseInt(f1s6v14.getText().toString())>=1) || !(Integer.parseInt(f1s6v14.getText().toString())<=12))
                                    {
                                        flag_month = false;
                                        f1s6v14.setError("لطفا ماه را بین 1 تا 12 وارد کنید.");
                                    }
                                    else
                                    {
                                        flag_month = true;
                                    }
                                    if(f1s6v15.getText().toString().matches(""))
                                    {
                                        f1s6v15.setError("این فیلد الزامی است");
                                        flag__2=false;
                                    }
                                    else
                                    {
                                        f1s6v15.getText();
                                        flag__2=true;
                                    }
                                    if(f1s6v17.getText().toString().matches(""))
                                    {
                                        f1s6v17.setError("این فیلد الزامی است");
                                        flag__3=false;
                                    }
                                    else
                                    {
                                        f1s6v17.getText();
                                        flag__3=true;
                                    }
                                    if(f1s6v18.getText().toString().matches(""))
                                    {
                                        f1s6v18.setError("این فیلد الزامی است");
                                        flag__4=false;
                                    }
                                    else
                                    {
                                        flag__4=true;
                                        f1s6v18.getText();
                                    }
                                    if(f1s6v8.getCheckedRadioButtonId()<=0)
                                    {
                                        f1s6v8_1.setError("این فیلد الزامی است");
                                        flag__5=false;
                                    }
                                    else
                                    {
                                        flag__5=true;

                                    }
                                    if(f1s6v12.getCheckedRadioButtonId()<=0)
                                    {
                                        rb.setError("این فیلد الزامی است.");
                                        flag__6=false;
                                    }
                                    else
                                    {
                                        flag__6=true;
                                    }
                                    if(f1s6v16.getCheckedRadioButtonId()<=0)
                                    {
                                        f1s6v16_1.setError("این فیلد الزامی است.");
                                        flag__7=false;
                                    }
                                    else
                                    {
                                        flag__7=true;

                                    }

                                    if(f1s6v5.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_mark1 = false;
                                    }
                                    else
                                    {
                                        flag_mark1 = true;
                                    }
                                    if(f1s6v6.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_model1 = false;
                                    }
                                    else
                                    {
                                        flag_model1 = true;
                                    }
                                    if(f1s6v7.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_tip1 = false;
                                    }
                                    else
                                    {
                                        flag_tip1 = true;
                                    }

                                    if(f1s6v9.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_mark2 = false;
                                    }
                                    else
                                    {
                                        flag_mark2 = true;
                                    }
                                    if(f1s6v10.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_model2 = false;
                                    }
                                    else
                                    {
                                        flag_model2 = true;
                                    }
                                    if(f1s6v11.getSelectedItemPosition()==0){
                                        Toast.makeText(f1s6.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_tip2 = false;
                                    }
                                    else
                                    {
                                        flag_tip2 = true;
                                    }


                                    Toast.makeText(f1s6.this, ""+flag__1+flag__2+flag__3+flag__4+flag__5+flag__6+flag__7+flag_month+flag_tip1+flag_model1+flag_mark1+flag_tip2+flag_model2+flag_mark2, Toast.LENGTH_SHORT).show();

                                    if (flag__1&&flag__2&&flag__3&&flag__4&&flag__5&&flag__6&&flag__7&&flag_month&&flag_tip1&&flag_model1&&flag_mark1&&flag_tip2&&flag_model2&&flag_mark2)
                                    {
                                        RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                                        RadioButton f1s6v8_sellected = (RadioButton)findViewById(f1s6v8.getCheckedRadioButtonId());
                                        RadioButton f1s6v12_sellected = (RadioButton)findViewById(f1s6v12.getCheckedRadioButtonId());
                                        RadioButton f1s6v16_sellected = (RadioButton)findViewById(f1s6v16.getCheckedRadioButtonId());
                                        String f1s6v4_str = f1s6v4_sellected.getHint().toString();
                                        String f1s6v5_str = Integer.toString(f1s6v5.getSelectedItemPosition()+1);
                                        String f1s6v6_str = Integer.toString(f1s6v6.getSelectedItemPosition()+1);
                                        String f1s6v7_str = Integer.toString(f1s6v7.getSelectedItemPosition()+1);
                                        String f1s6v8_str = f1s6v8_sellected.getHint().toString();
                                        String f1s6v9_str = Integer.toString(f1s6v9.getSelectedItemPosition()+1);
                                        String f1s6v10_str =  Integer.toString(f1s6v10.getSelectedItemPosition()+1);
                                        String f1s6v11_str =  Integer.toString(f1s6v11.getSelectedItemPosition()+1);
                                        String f1s6v12_str = f1s6v12_sellected.getHint().toString();
                                        String f1s6v13_str = f1s6v13.getText().toString();
                                        String f1s6v14_str = f1s6v14.getText().toString();
                                        String f1s6v15_str = f1s6v15.getText().toString();
                                        String f1s6v16_str = f1s6v16_sellected.getHint().toString();
                                        String f1s6v17_str = f1s6v17.getText().toString();
                                        String f1s6v18_str =  f1s6v18.getText().toString();


                                        al.add(f1s6v4_str);
                                        al.add(f1s6v5_str);
                                        al.add(f1s6v6_str);
                                        al.add(f1s6v7_str);
                                        al.add(f1s6v8_str);
                                        al.add(f1s6v9_str);
                                        al.add(f1s6v10_str);
                                        al.add(f1s6v11_str);
                                        al.add(f1s6v12_str);
                                        al.add(f1s6v13_str);
                                        al.add(f1s6v14_str);
                                        al.add(f1s6v15_str);
                                        al.add(f1s6v16_str);
                                        al.add(f1s6v17_str);
                                        al.add(f1s6v18_str);

                                        Intent i = new Intent(f1s6.this,f1s7.class);
                                        startActivity(i);
                                    }



                                }
                            });


                        }
                        break;
                    case R.id.f1s6v4_2:
                        viewGroup.invalidate();
                        li_1.setVisibility(View.GONE);
                        li_2.setVisibility(View.VISIBLE);
                        flag=2;
                        li_3.setVisibility(View.GONE);
                        if(flag==2)
                        {


                            final Spinner f1s6v19 = (Spinner)findViewById(R.id.f1s6v19);
                            final Spinner f1s6v20 = (Spinner)findViewById(R.id.f1s6v20);
                            final Spinner f1s6v21 = (Spinner)findViewById(R.id.f1s6v21);

                            String [] array = getResources().getStringArray(R.array.company);







                            final RadioGroup f1s6v22 =(RadioGroup)findViewById(R.id.f1s6v22);
                            final RadioButton f1s6v22_1= (RadioButton)findViewById(R.id.f1s6v22_1);
                            final RadioButton f1s6v22_2= (RadioButton)findViewById(R.id.f1s6v22_2);

                            f1s6v22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                                    f1s6v22_1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v22_1:
                                            f1s6v22_1.getText();
                                            f1s6v22_1.getHint();
                                            break;
                                        case R.id.f1s6v22_2:
                                            f1s6v22_2.getHint();
                                            f1s6v22_2.getText();
                                            break;
                                    }
                                }
                            });
                            final EditText f1s6v23 = (EditText)findViewById(R.id.f1s6v23);
                            Button btnclick = (Button)findViewById(R.id.btnclick3);
                            final RadioGroup f1s6v24 = (RadioGroup)findViewById(R.id.f1s6v24);
                            final RadioButton f1s6v24_1 = (RadioButton)findViewById(R.id.f1s6v24_1);
                            final RadioButton f1s6v24_2 = (RadioButton)findViewById(R.id.f1s6v24_2);
                            final RadioButton f1s6v24_3 = (RadioButton)findViewById(R.id.f1s6v24_3);
                            final RadioButton f1s6v24_4 = (RadioButton)findViewById(R.id.f1s6v24_4);
                            f1s6v24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    f1s6v24_1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v24_1:
                                            f1s6v24_1.getText();
                                            f1s6v24_1.getHint();
                                            break;
                                        case R.id.f1s6v24_2:
                                            f1s6v24_2.getText();
                                            f1s6v24_2.getHint();
                                            break;
                                        case R.id.f1s6v24_3:
                                            f1s6v24_3.getText();
                                            f1s6v24_3.getHint();
                                            break;
                                        case R.id.f1s6v24_4:
                                            LinearLayout li = (LinearLayout)findViewById(R.id.linerGone);
                                            li.setVisibility(View.VISIBLE);
                                            f1s6v24_4.getText();
                                            f1s6v24_4.getHint();
                                            flag_edt2=true;
                                            break;

                                    }
                                }
                            });
                            btnclick.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {


                                    if(f1s6v23.getText().toString().matches(""))
                                    {
                                        f1s6v23.setError("این فیلد الزامی است.");
                                        flag___1=false;
                                    }
                                    else
                                    {
                                        f1s6v23.getText();
                                        flag___1=true;
                                    }
                                    if(f1s6v24.getCheckedRadioButtonId()<=0)
                                    {
                                        f1s6v24_1.setError("این فیلد الزامی است.");
                                        flag___2=false;
                                    }
                                    else
                                    {
                                        flag___2=true;
                                    }
                                    if (f1s6v22.getCheckedRadioButtonId()<=0)
                                    {
                                        f1s6v22_1.setError("این فیلد الزامی است.");
                                        flag___3=false;
                                    }
                                    else
                                    {
                                        flag___3=true;
                                    }

                                    if(f1s6v19.getSelectedItemPosition()==0)
                                    {
                                        flag_mark3 =false;
                                        Toast.makeText(f1s6.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        flag_mark3 = true;
                                    }
                                    if(f1s6v20.getSelectedItemPosition()==0)
                                    {
                                        flag_model3 =false;
                                        Toast.makeText(f1s6.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        flag_model3 = true;
                                    }
                                    if(f1s6v21.getSelectedItemPosition()==0)
                                    {
                                        flag_tip3 = false;
                                        Toast.makeText(f1s6.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                                    }
                                    else
                                    {
                                        flag_tip3 = true;
                                    }

                                    if(flag_edt2.equals(true))
                                    {
                                         f1s6v26= (EditText)findViewById(R.id.f1s6v26);
                                        if(f1s6v26.getText().toString().matches(""))
                                        {
                                            f1s6v26.setError("این فیلد الزامی است.");
                                            flag___4=false;
                                        }
                                        else
                                        {
                                            f1s6v26.getText();
                                            flag___4=true;
                                        }
                                    }

                                    if(flag_edt2) {

                                        if (flag___1 && flag___2 && flag___3&&flag___4&&flag_mark3&&flag_tip3&&flag_model3) {
                                            RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                                            RadioButton f1s6v22_sellected = (RadioButton)findViewById(f1s6v22.getCheckedRadioButtonId());
                                            RadioButton f1s6v24_sellected = (RadioButton)findViewById(f1s6v24.getCheckedRadioButtonId());

                                            String f1s6v4_str = f1s6v4_sellected.getHint().toString();
                                            String f1s6v19_str = Integer.toString(f1s6v19.getSelectedItemPosition()+1);
                                            String f1s6v20_str = Integer.toString(f1s6v20.getSelectedItemPosition()+1);
                                            String f1s6v21_str = Integer.toString(f1s6v21.getSelectedItemPosition()+1);
                                            String f1s6v22_str = f1s6v22_sellected.getHint().toString();
                                            String f1s6v23_str = f1s6v23.getText().toString();
                                            String f1s6v24_str = f1s6v24_sellected.getHint().toString();
                                            String f1s6v25_str = "";
                                            String f1s6v26_str = f1s6v26.getText().toString();



                                            al.add(f1s6v4_str);
                                            al.add(f1s6v19_str);
                                            al.add(f1s6v20_str);
                                            al.add(f1s6v21_str);
                                            al.add(f1s6v22_str);
                                            al.add(f1s6v23_str);
                                            al.add(f1s6v24_str);
                                            al.add(f1s6v25_str);
                                            al.add(f1s6v26_str);
                                            Intent i = new Intent(f1s6.this,f1s7.class);
                                            startActivity(i);

                                        }
                                    }
                                    else
                                    {
                                        if (flag___1 && flag___2 && flag___3&&flag_mark3&&flag_tip3&&flag_model3) {

                                            RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                                            RadioButton f1s6v22_sellected = (RadioButton)findViewById(f1s6v22.getCheckedRadioButtonId());
                                            RadioButton f1s6v24_sellected = (RadioButton)findViewById(f1s6v24.getCheckedRadioButtonId());

                                            String f1s6v4_str = f1s6v4_sellected.getHint().toString();
                                            String f1s6v19_str = Integer.toString(f1s6v19.getSelectedItemPosition()+1);
                                            String f1s6v20_str = Integer.toString(f1s6v20.getSelectedItemPosition()+1);
                                            String f1s6v21_str = Integer.toString(f1s6v21.getSelectedItemPosition()+1);
                                            String f1s6v22_str = f1s6v22_sellected.getHint().toString();
                                            String f1s6v23_str = f1s6v23.getText().toString();
                                            String f1s6v24_str = f1s6v24_sellected.getHint().toString();
                                            String f1s6v25_str = "";
                                            String f1s6v26_str ="";



                                            al.add(f1s6v4_str);
                                            al.add(f1s6v19_str);
                                            al.add(f1s6v20_str);
                                            al.add(f1s6v21_str);
                                            al.add(f1s6v22_str);
                                            al.add(f1s6v23_str);
                                            al.add(f1s6v24_str);
                                            al.add(f1s6v25_str);
                                            al.add(f1s6v26_str);

                                            Intent i = new Intent(f1s6.this,f1s7.class);
                                            startActivity(i);
                                        }
                                    }

                                }
                            });

                        }
                        break;
                    case R.id.f1s6v4_3:
                        flag =3;
                        li_1.setVisibility(View.GONE);
                        li_2.setVisibility(View.GONE);
                        li_3.setVisibility(View.VISIBLE);
                        if (flag==3)
                        {
                            final RadioGroup f1s6v27 = (RadioGroup)findViewById(R.id.f1s6v27);
                            final RadioButton f1s6v27_1 = (RadioButton)findViewById(R.id.f1s6v27_1);
                            final RadioButton f1s6v27_2 = (RadioButton)findViewById(R.id.f1s6v27_2);
                            final RadioButton f1s6v27_3 = (RadioButton)findViewById(R.id.f1s6v27_3);
                            final RadioButton f1s6v27_4 = (RadioButton)findViewById(R.id.f1s6v27_4);
                            RadioButton f1s6v27_5 = (RadioButton)findViewById(R.id.f1s6v27_5);

                            f1s6v27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    View v = (View)viewGroup.findViewById(R.id.f1s6v44);
                                    f1s6v27_1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v27_1:
                                            f1s6v27_1.getHint();
                                            f1s6v27_1.getText();
                                            v.setVisibility(View.GONE);
                                            break;
                                        case R.id.f1s6v27_2:
                                            f1s6v27_2.getText();
                                            f1s6v27_2.getHint();
                                            v.setVisibility(View.GONE);
                                            break;
                                        case R.id.f1s6v27_3:
                                            f1s6v27_3.getHint();
                                            f1s6v27_3.getText();
                                            v.setVisibility(View.GONE);
                                            break;
                                        case R.id.f1s6v27_4:
                                            f1s6v27_4.getHint();
                                            f1s6v27_4.getText();
                                            v.setVisibility(View.GONE);
                                            break;
                                        case R.id.f1s6v27_5:
                                            flag_edt=true;
                                            v.setVisibility(v.VISIBLE);
                                            break;
                                        //inja
                                    }
                                }
                            });

                            final Spinner f1s6v29 = (Spinner)findViewById(R.id.f1s6v29);
                            final Spinner f1s6v30 =(Spinner)findViewById(R.id.f1s6v30);
                            final Spinner f1s6v31 = (Spinner)findViewById(R.id.f1s6v31);


                            final RadioGroup f1s6v36 = (RadioGroup)findViewById(R.id.f1s6v36);
                            final RadioButton f1s6v36_1 = (RadioButton)findViewById(R.id.f1s6v36_1);
                            final RadioButton f1s6v36_2 = (RadioButton)findViewById(R.id.f1s6v36_1);
                            f1s6v36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v36_1:
                                            f1s6v36_1.getHint();
                                            break;
                                        case R.id.f1s6v36_2:
                                            f1s6v36_2.getHint();
                                            break;
                                    }
                                }
                            });
                            final EditText f1s6v37 = (EditText) findViewById(R.id.f1s6v37);





                            String [] array = getResources().getStringArray(R.array.company);



                            final RadioGroup f1s6v32 = (RadioGroup)findViewById(R.id.f1s6v32);
                            final RadioButton radiobtn1 = (RadioButton)findViewById(R.id.f1s6v32_1);
                            final RadioButton radiobtn2 = (RadioButton)findViewById(R.id.f1s6v32_2);
                            f1s6v32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                    radiobtn1.setError(null);
                                    switch (checkedId)
                                    {
                                        case R.id.f1s6v32_1:
                                            radiobtn1.getText();
                                            radiobtn2.getHint();
                                            break;
                                        case R.id.f1s6v32_2:
                                            radiobtn2.getHint();
                                            radiobtn2.getText();
                                            break;
                                    }
                                }
                            });

                            final EditText f1s6v33 = (EditText)findViewById(R.id.f1s6v33);
                            final EditText f1s6v34 = (EditText)findViewById(R.id.f1s6v34);
                            final EditText f1s6v35 = (EditText)findViewById(R.id.f1s6v35);


                            Button btnclick = (Button)findViewById(R.id.btnclick3);
                            btnclick.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (f1s6v27.getCheckedRadioButtonId() <= 0) {
                                        f1s6v27_1.setError("این فیلد الزامی است.");
                                        flag1 = false;
                                    } else {
                                        flag1 = true;
                                    }
                                    if (f1s6v32.getCheckedRadioButtonId() <= 0) {
                                        radiobtn1.setError("این فیلد الزامی است");
                                        flag2 = false;
                                    } else {
                                        flag2 = true;
                                    }
                                    if (f1s6v33.getText().toString().matches("")) {
                                        f1s6v33.setError("این فیلد الزامی است.");
                                        flag3 = false;
                                    } else {
                                        f1s6v33.getText();
                                        flag3 = true;
                                    }
                                    if (f1s6v34.getText().toString().matches("")) {
                                        f1s6v34.setError("این فیلد الزامی است.");
                                        flag_month2 = false;
                                    } else if (!(Integer.parseInt(f1s6v34.getText().toString()) >= 1) || !(Integer.parseInt(f1s6v34.getText().toString()) <= 12))
                                    {
                                        flag_month2 = false;
                                        f1s6v34.setError("ماه را بین 1 تا 12 وارد کنید.");
                                    }
                                    else
                                    {
                                        flag_month2 = true;
                                    }
                                    if(f1s6v35.getText().toString().matches(""))
                                    {
                                        f1s6v35.setError("این فیلد الزامی است");
                                        flag4=false;
                                    }
                                    else
                                    {
                                        f1s6v35.getText();
                                        flag4=true;
                                    }

                                    if(f1s6v29.getSelectedItemPosition()==0)
                                    {
                                        Toast.makeText(f1s6.this, "لطفا مارک را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_mark4 = false;
                                    }
                                    else
                                    {
                                        flag_mark4 = true;
                                    }
                                    if(f1s6v30.getSelectedItemPosition()==0)
                                    {
                                        Toast.makeText(f1s6.this, "لطفا مدل را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_model4 = false;

                                    }
                                    else
                                    {
                                        flag_model4 = true;
                                    }
                                    if(f1s6v31.getSelectedItemPosition()==0)
                                    {
                                        Toast.makeText(f1s6.this, "لطفا تیپ را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                                        flag_tip4 = false;
                                    }
                                    else
                                    {
                                        flag_tip4 = true;
                                    }

                                    if(f1s6v37.getText().toString().matches(""))
                                    {
                                        f1s6v37.setError("این فیلد الزامی است.");
                                        flag_f1s6v37 = false;
                                    }
                                    else
                                    {
                                        flag_f1s6v37 = true;
                                    }

                                    if (flag_edt.equals(true)) {
                                         f1s6v28 = (EditText) findViewById(R.id.f1s6v28);
                                        if (f1s6v28.getText().toString().matches("")) {
                                            f1s6v28.setError("این فیلد الزامی است.");
                                        } else {
                                            f1s6v28.getText();
                                            f1s6v28.getHint();
                                            if(flag1&&flag2&&flag3&&flag4&&flag_month2&&flag_mark4&&flag_tip4&&flag_model4)
                                            {


                                                RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                                                RadioButton f1s6v27_sellected = (RadioButton)findViewById(f1s6v27.getCheckedRadioButtonId());
                                                RadioButton f1s6v32_sellected = (RadioButton)findViewById(f1s6v32.getCheckedRadioButtonId());
                                                RadioButton f1s6v36_sellected = (RadioButton)findViewById(f1s6v36.getCheckedRadioButtonId());

                                                String f1s6v4_str = f1s6v4_sellected.getHint().toString();
                                                String f1s6v27_str = f1s6v27_sellected.getHint().toString();
                                                String f1s6v28_str = f1s6v28.getText().toString();
                                                String f1s6v29_str = Integer.toString(f1s6v29.getSelectedItemPosition()+1);
                                                String f1s6v30_str = Integer.toString(f1s6v30.getSelectedItemPosition()+1);
                                                String f1s6v31_str = Integer.toString(f1s6v31.getSelectedItemPosition()+1);
                                                String f1s6v32_str = f1s6v32_sellected.getHint().toString();
                                                String f1s6v33_str = f1s6v33.getText().toString();
                                                String f1s6v34_str = f1s6v34.getText().toString();
                                                String f1s6v35_str = f1s6v35.getText().toString();
                                                String f1s6v36_str = f1s6v36_sellected.getHint().toString();
                                                String f1s6v37_str = f1s6v37.getText().toString();



                                                al.add(f1s6v4_str);
                                                al.add(f1s6v27_str);
                                                al.add(f1s6v28_str);
                                                al.add(f1s6v29_str);
                                                al.add(f1s6v30_str);
                                                al.add(f1s6v31_str);
                                                al.add(f1s6v32_str);
                                                al.add(f1s6v33_str);
                                                al.add(f1s6v34_str);
                                                al.add(f1s6v35_str);
                                                al.add(f1s6v36_str);
                                                al.add(f1s6v37_str);


                                                Intent intent = new Intent(f1s6.this,f1s7.class);
                                                startActivity(intent);
                                            }
                                            else {
                                            }
                                        }
                                    }
                                    else
                                    {
                                        Toast.makeText(f1s6.this, ""+flag1+flag2+flag3+flag4+flag_month2+flag_mark4+flag_tip4+flag_model4, Toast.LENGTH_SHORT).show();

                                        if(flag1&&flag2&&flag3&&flag4&&flag_month2&&flag_mark4&&flag_tip4&&flag_model4)
                                        {

                                            RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                                            RadioButton f1s6v27_sellected = (RadioButton)findViewById(f1s6v27.getCheckedRadioButtonId());
                                            RadioButton f1s6v32_sellected = (RadioButton)findViewById(f1s6v32.getCheckedRadioButtonId());
                                            RadioButton f1s6v36_sellected = (RadioButton)findViewById(f1s6v36.getCheckedRadioButtonId());

                                            String f1s6v4_str = f1s6v4_sellected.getHint().toString();
                                            String f1s6v27_str = f1s6v27_sellected.getHint().toString();
                                            String f1s6v28_str = "";
                                            String f1s6v29_str = Integer.toString(f1s6v29.getSelectedItemPosition()+1);
                                            String f1s6v30_str = Integer.toString(f1s6v30.getSelectedItemPosition()+1);
                                            String f1s6v31_str = Integer.toString(f1s6v31.getSelectedItemPosition()+1);
                                            String f1s6v32_str = f1s6v32_sellected.getHint().toString();
                                            String f1s6v33_str = f1s6v33.getText().toString();
                                            String f1s6v34_str = f1s6v34.getText().toString();
                                            String f1s6v35_str = f1s6v35.getText().toString();
                                            String f1s6v36_str = f1s6v36_sellected.getHint().toString();
                                            String f1s6v37_str = f1s6v37.getText().toString();



                                            al.add(f1s6v4_str);
                                            al.add(f1s6v27_str);
                                            al.add(f1s6v28_str);
                                            al.add(f1s6v29_str);
                                            al.add(f1s6v30_str);
                                            al.add(f1s6v31_str);
                                            al.add(f1s6v32_str);
                                            al.add(f1s6v33_str);
                                            al.add(f1s6v34_str);
                                            al.add(f1s6v35_str);
                                            al.add(f1s6v36_str);
                                            al.add(f1s6v37_str);


                                            Intent intent = new Intent(f1s6.this,f1s7.class);
                                            startActivity(intent);
                                        }
                                        else {
                                        }
                                    }

                                }
                            });

                        }
                        break;
                    case R.id.f1s6v4_4:
                        flag=4;
                        li_1.setVisibility(View.GONE);
                        li_3.setVisibility(View.GONE);
                        li_2.setVisibility(View.GONE);
                        if(flag==4)
                        {
                            Button btm = (Button)findViewById(R.id.btnclick3);
                            btm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    RadioButton f1s6v4_sellected = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

                                    String f1s6v4_str = f1s6v4_sellected.getHint().toString();

                                    al.add(f1s6v4_str);

                                    Intent i = new Intent(f1s6.this,f1s7.class);
                                    startActivity(i);
                                }
                            });

                        }
                        break;
                }
            }
        });


    }

    //load font
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
