package com.jfp.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=(Spinner)findViewById(R.id.spinner);

        List<String> categroies=new ArrayList<String>();
        categroies.add("Cloth");
        categroies.add("Machine");
        categroies.add("Computer");
        categroies.add("personal");
        categroies.add("Education");
        categroies.add("Bicycle");
        categroies.add("Motorcycle");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,categroies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected :"+item, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
