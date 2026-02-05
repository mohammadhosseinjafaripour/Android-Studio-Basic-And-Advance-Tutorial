package com.jfp.shareperefrence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassedData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passed_data);
        final TextView Email =(TextView)findViewById(R.id.Email);
        final TextView Password=(TextView)findViewById(R.id.Password);
        Button GetData=(Button)findViewById(R.id.GetData);

        GetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences =getSharedPreferences("ID",MODE_PRIVATE);
                String email_= preferences.getString("email",null);
                String password_= preferences.getString("password",null);
                Email.setText(email_);
                Password.setText(password_);

            }
        });
    }
}
