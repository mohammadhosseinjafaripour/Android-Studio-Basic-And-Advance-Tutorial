package ir.rahnama.form0;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import ir.rahnama.R;
import ir.rahnama.form1.dbHandler;


public class Splash extends AppCompatActivity {

    dbHandler db;

    SharedPreferences shpr;
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        db = new dbHandler(getBaseContext());

        shpr = getApplicationContext().getSharedPreferences("MKRdatabase", 0);
        final SharedPreferences.Editor editor = shpr.edit();
        if(!shpr.contains("insert_db")) {
            editor.putBoolean("insert_db", false);
            editor.commit();
        }

        if(!shpr.contains("codephone")) {
            editor.putString("codephone", null);
            editor.commit();
        }

        sh = getSharedPreferences("MKRdatabase", 0);




        //Create  DATA IN DB

        if (!(sh.getBoolean("insert_db",false))) {
            try {
                db.addDataBrand(readfile("_car_brand.txt"));
                db.addDataCarChina(readfile("_car_china.txt"));
                db.addDataCarExport(readfile("_car_export.txt"));
                db.addDataCarFactory(readfile("_car_factory.txt"));
                db.addDataCarModel(readfile("_car_model.txt"));
                db.addDataType(readfile("_car_type.txt"));
                db.addDataCarTip(readfile("_car_tip.txt"));
                db.addDataState(readfile("_state.txt"));
                db.addDataCity(readfile("_city.txt"));
                db.addDataVillage(readfile("_village.txt"));
                db.addDataCarComper(readfile("_car_compare.txt"));
                //if(!shpr.contains("key_login")) {
                editor.putBoolean("insert_db", true);
                editor.commit();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        try
        {
            Thread timerthread = new Thread(){
                public void run()
                {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        Intent intent = new Intent(Splash.this,_start_01.class);
                        startActivity(intent);
                    }
                }
            };
            timerthread.start();
        }
        catch (Exception e) {
        }
    }

    public String readfile(String namefile){
        String text = "0";

        try {
            InputStream is = getAssets().open(namefile);

            // We guarantee that the available method returns the total
            // size of the asset...  of course, this does mean that a single
            // asset can't be more than 2 gigs.
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
    text = new String(buffer);

} catch (IOException e) {
        // Should never happen!
        throw new RuntimeException(e);
        }
        return text;
        }
}