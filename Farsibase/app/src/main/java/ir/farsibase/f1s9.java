package ir.farsibase;

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
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s9 extends AppCompatActivity {

    Boolean flag= false;

    String result_f1s9v1 = "";
    ArrayList<String> al=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s9);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);

        final String[] strv4 = getResources().getStringArray(R.array.f1s9v1);

        ArrayAdapter adapterv4 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, strv4);
        ListView spv4 = (ListView) findViewById(R.id.f1s9v1);
        spv4.setAdapter(adapterv4);

        spv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==5)
                {
                    flag=true;
                    View v = (View)viewGroup.findViewById(R.id.hidden4);
                    v.setVisibility(v.VISIBLE);
                    result_f1s9v1="2";

                }
                else {
                    flag=false;
                    View v = (View)viewGroup.findViewById(R.id.hidden4);
                    v.setVisibility(v.GONE);
                    result_f1s9v1 ="1";
                    EditText edt = (EditText)findViewById(R.id.f1s9v2);
                    edt.setText("");
                }
            }
        });



        Button btnclick = (Button)findViewById(R.id.btnclick5);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag.equals(true))
                {
                    EditText edt = (EditText)findViewById(R.id.f1s9v2);
                    if(edt.getText().toString().matches(""))
                    {
                        edt.setError("این فیلد الزامی است.");
                    }
                    else
                    {

                        al.add(result_f1s9v1);
                        al.add(edt.getText().toString());
                        Intent i = new Intent(f1s9.this,f1s10.class);
                        startActivity(i);
                    }
                }
                else
                {
                    al.add(result_f1s9v1);
                    al.add("");
                    Intent i = new Intent(f1s9.this,f1s10.class);
                    startActivity(i);
                }
            }
        });
    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
