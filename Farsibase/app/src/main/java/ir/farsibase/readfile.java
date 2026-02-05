package ir.farsibase;

/**
 * Created by amir on 9/17/2017.
 */

import android.app.Activity;
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
import java.util.List;


/**
 * Demonstration of styled text resources.
 */
public class readfile extends Activity
{
    dbHandler db;
    Spinner s1,s2,s3,s4,s5;
    String[] itemsid;

    List<String> listType;
    List<String> tliststr = new ArrayList<String>();
    List<String> tliststrid = new ArrayList<String>();
	
	List<String> listFactory;
    List<String> fliststr = new ArrayList<String>();
    List<String> fliststrid = new ArrayList<String>();

    List<String> listBrand ;
    List<String> bliststr = new ArrayList<String>();
    List<String> bfaclistid = new ArrayList<String>();
    List<String> bliststrid = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // See assets/res/any/layout/styled_text.xml for this
        // view layout definition.
        setContentView(R.layout.read);



        db = new dbHandler(getBaseContext());


        try {
            db.addDataBrand(readfile("_car_brand.txt"));
            db.addDataCarChina(readfile("_car_china.txt"));
            db.addDataCarExport(readfile("_car_export.txt"));
            db.addDataCarFactory(readfile("_car_factory.txt"));
            db.addDataCarModel(readfile("_car_model.txt"));
            db.addDataType(readfile("_car_type.txt"));
            db.addDataCarTip(readfile("_car_tip.txt"));
        } catch (JSONException e) {
            e.printStackTrace();
        }









        listType = db.viewOneRowType();

        for(String da : listType){
            //valuesword.put("id", "");
            String[] words1=da.split("#%");
            tliststrid.add(words1[0]);
            tliststr.add(words1[1]);
        }
		
		 listFactory = db.viewOneRowFactory();

		for(String da : listFactory){
							//valuesword.put("id", "");
							String[] words3=da.split("#%");
							fliststrid.add(words3[0]);
							fliststr.add(words3[1]);
						}


        s1  = (Spinner)findViewById(R.id.spinner1);
        s2  = (Spinner)findViewById(R.id.spinner2);
		s3  = (Spinner)findViewById(R.id.spinner3);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                tliststr );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                                            //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                                            String id1=tliststrid.get(position);
                                            Toast.makeText(readfile.this, id1, Toast.LENGTH_LONG).show();
                                        }

                                        public void onNothingSelected(AdapterView<?> parent) {
                                        }
                                    });
									
									
									


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                fliststr );
				

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);


        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                //String id2=bliststrid.get(position)+"--"+bfaclistid.get(position);
                //Toast.makeText(readfile.this, id2, Toast.LENGTH_LONG).show();
				String id2=fliststrid.get(position);
				
				        listBrand = db.viewOneRowBrand(position+1);

						for(String da : listBrand){
							//valuesword.put("id", "");
							String[] words2=da.split("#%");
							bliststrid.add(words2[0]);
							bfaclistid.add(words2[1]);
							bliststr.add(words2[2]);
						}
				
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
		
		
		
		
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                bliststr );
				

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter3);


        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //Toast.makeText(readfile.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                String id2=bliststrid.get(position)+"--"+bfaclistid.get(position);
                Toast.makeText(readfile.this, id2, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }



    public String readfile(String namefile){
        String text = "0";

        try {
            InputStream is = getAssets().open(namefile);

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
