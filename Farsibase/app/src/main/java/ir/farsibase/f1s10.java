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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class f1s10 extends AppCompatActivity {

    Boolean flag = false;

    ArrayList<String> al=new ArrayList<String>();

    String  result_f1s10v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1s10);


        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);

        final String[] strv4 = getResources().getStringArray(R.array.f1s10v1);

        ArrayAdapter adapterv4 = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, strv4);
        final ListView spv4 = (ListView) findViewById(R.id.f1s10v1);
        spv4.setAdapter(adapterv4);

        spv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result_f1s10v1 = Integer.toOctalString(position+1);
            }
        });




        Button btnclick = (Button)findViewById(R.id.btnclick6);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(spv4.getCheckedItemCount()==0)
                {
                    Toast.makeText(f1s10.this, "لطفا یکی از موارد بالا را انتخاب کنید.", Toast.LENGTH_SHORT).show();
                }
                else {

                    al.add(result_f1s10v1);

                    Intent i = new Intent(f1s10.this,f1s11.class);
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
