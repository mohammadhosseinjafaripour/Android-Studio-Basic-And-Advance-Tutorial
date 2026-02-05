package com.jfp.shareperefrence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button savedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        savedata=(Button)findViewById(R.id.save);

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().equals(null)&&password.getText().equals(null))
                {
                    Toast.makeText(MainActivity.this, "Email and Password is Empty :D", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data save Correctly :D", Toast.LENGTH_SHORT).show();
					
					
					
                    SharedPreferences.Editor editor=getSharedPreferences("ID",MODE_PRIVATE).edit();
                    editor.putString("email",email.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.commit();

                    Intent intent =new Intent(MainActivity.this,PassedData.class);
                    startActivity(intent);




                }
            }
        });

    }
}
