package com.jfp.getnumber;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        final TextView txt = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ArrayList<HashMap<String,String>> LIST = new ArrayList<HashMap<String,String>>();
                Context myContext = null; // where com.example is the owning  app containing the preferences
                try {
                    myContext = createPackageContext("org.telegram.messenger",
                            Context.CONTEXT_IGNORE_SECURITY);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                SharedPreferences testPrefs = myContext.getSharedPreferences
                        ("userconfing", Context.MODE_WORLD_READABLE);

                Toast.makeText(myContext, ""+testPrefs.getString("user","shit"), Toast.LENGTH_SHORT).show();
                Toast.makeText(myContext, ""+testPrefs.getAll(), Toast.LENGTH_SHORT).show();
                Map<String, ?> items = testPrefs .getAll();
                for(String s : items.keySet()){
                  String value=  items.get(s).toString();
                    Toast.makeText(myContext, ""+value, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
                    //org.telegram.messenger
