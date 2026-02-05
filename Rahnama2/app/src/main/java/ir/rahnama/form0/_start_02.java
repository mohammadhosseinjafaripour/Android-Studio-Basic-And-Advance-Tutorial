package ir.rahnama.form0;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class _start_02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._start_02);

        Button send = (Button) findViewById(R.id.f2_next);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_start_02.this, "فرم با موفقیت ارسال شد", Toast.LENGTH_SHORT).show();
            }
        });


    }
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
