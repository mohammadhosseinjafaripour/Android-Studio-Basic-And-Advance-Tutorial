package com.jfp.bottomdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kcode.bottomlib.BottomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btndialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog dialog = BottomDialog.newInstance("Title",new String[]{"item1","item2"});
                dialog.show(getSupportFragmentManager(),"dialog");
                dialog.setListener(new BottomDialog.OnClickListener() {
                    @Override
                    public void click(int position) {
                        Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
