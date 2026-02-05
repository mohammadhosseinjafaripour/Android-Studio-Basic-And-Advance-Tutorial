package ir.farsibase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final Spinner sp4 = (Spinner)findViewById(R.id.spinner5);

      //  final String [] array = getResources().getStringArray(R.array.cit);
        //String [] h=new String [array.length];

        String temp = "45,050,000";
        int in =  Integer.parseInt(temp.replaceAll("[\\D]", ""));
        int len = Integer.valueOf(in).toString().length();
        String cd = String.valueOf(in);
        char []ch =  cd.toCharArray();
        ArrayList<String> al=new ArrayList<String>();
        for(int q=0 ;q<len;q++)
        {
            al.add(ch[q]+"");
        }
        int counter=0;
        for(int t=len;t>0;t--) {
            counter++;
            if (counter <= 6)
            {
               // al.remove(t);
            }

        }


/*
        for(int i = 0; i<cd.length(); ++i){
            digits[i] = Integer.parseInt(cd.substring(i, i+1));
            Toast.makeText(this, ""+digits[i], Toast.LENGTH_SHORT).show();

        }*/



       /* for (String f : array) {
            String [] i = f.split("-");
            h[counter]=i[0];
            counter++;
        }


        ArrayAdapter snprAdapter5 = new ArrayAdapter(Main3Activity.this,R.layout.support_simple_spinner_dropdown_item,h);
        sp4.setAdapter(snprAdapter5);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String [] i = array[position].split("-");
                Toast.makeText(Main3Activity.this, ""+i[1]+","+i[2], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        int pos = sp4.getSelectedItemPosition();*/
    }
}
