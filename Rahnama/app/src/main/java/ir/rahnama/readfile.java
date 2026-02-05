package ir.rahnama;

/**
 * Created by amir on 9/17/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * Demonstration of styled text resources.
 */
public class readfile extends Activity
{
    dbHandler db;
    Spinner s1,s2,s3,s4,s5;
    String[] itemsid;

    List<String> listType;
    List<String> typeliststr = new ArrayList<String>();
    List<String> typeliststrtemp = new ArrayList<String>();//temp
    List<String> typeliststrid = new ArrayList<String>();


    List<String> listBrand ;
    List<String> bliststr = new ArrayList<String>();
    List<String> bliststrtemp = new ArrayList<String>();
    List<String> bfaclistid = new ArrayList<String>();
    List<String> bliststrid = new ArrayList<String>();


    List<String> listFactory ;
    List<String> fliststr = new ArrayList<String>();
    List<String> fliststrid = new ArrayList<String>();


    List<String> listModel ;
    List<String> mliststr = new ArrayList<String>();
    List<String> mliststrtemp = new ArrayList<String>();
    List<String> mliststrid = new ArrayList<String>();


    List<String> listTip ;
    List<String> listTiptemp ;
    List<String> tipliststr = new ArrayList<String>();

    List<String> tipliststridfactory = new ArrayList<String>();
    List<String> tipliststridbrand = new ArrayList<String>();
    List<String> tipliststridmodel = new ArrayList<String>();


   List<String> listtiptxt;

   List<String> txtnametip = new ArrayList<String>();
    List<String> txtnametipid = new ArrayList<String>();





    String facttory_id;
    String brand_id;
    String model_id;
    String type_id;
    String tip_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // See assets/res/any/layout/styled_text.xml for this
        // view layout definition.
        setContentView(R.layout.read);

        ccconvert x = new ccconvert();

        Toast.makeText(this,  x.GetFigures("10000"), Toast.LENGTH_SHORT).show();

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
