package ir.farsibase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final Spinner sp = (Spinner)findViewById(R.id.spinner);

        final Spinner sp2 = (Spinner)findViewById(R.id.spinner2);

        final Spinner sp3 = (Spinner)findViewById(R.id.spinner3);

        final Spinner sp4 = (Spinner)findViewById(R.id.spinner4);


        String [] array = getResources().getStringArray(R.array.company);
        /*List<String> myResArrayList = Arrays.asList(array);
        List<String> statements = new ArrayList<String>();
        statements.add(0,"");
        int coun = 1;
        for(int ls = 0 ;ls<array.length;ls++)
        {
            statements.add(coun,array[ls]);
            coun++;
            if(array.length==coun)
                break;
        }
        String[] array2 = new String[myResArrayList.size()];
        for (int i = 0; i < myResArrayList.size(); i++) {
            array2[i] = statements.get(i);
        }*/


        ArrayAdapter snprAdapter5 = new ArrayAdapter(spinner.this,R.layout.support_simple_spinner_dropdown_item,array);
        sp.setAdapter(snprAdapter5);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    ArrayAdapter snprAdapter2 = new ArrayAdapter(spinner.this,R.layout.support_simple_spinner_dropdown_item,array);
                    sp2.setAdapter(snprAdapter2);

                sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        int position_array = sp.getSelectedItemPosition();




                        String [] array = getResources().getStringArray(arr5[position_array][position]);


                        ArrayAdapter snprAdapter2 = new ArrayAdapter(spinner.this,R.layout.support_simple_spinner_dropdown_item,array);
                        sp3.setAdapter(snprAdapter2);

                        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


                                int first_ps = sp.getSelectedItemPosition();
                                int second_ps = sp2.getSelectedItemPosition();
                                int third_ps = sp3.getSelectedItemPosition();
                                String [] array = getResources().getStringArray(arr_all[first_ps][second_ps][third_ps]);
                                ArrayAdapter snprAda = new ArrayAdapter(spinner.this,R.layout.support_simple_spinner_dropdown_item,array);
                                sp4.setAdapter(snprAda);
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
    }
}
