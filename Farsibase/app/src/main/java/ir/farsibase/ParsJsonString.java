package ir.farsibase;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 1/26/2017.
 */
public class ParsJsonString {

    private String jsonstring;
    List<type_model> data=new ArrayList<>();

    List<String> update = new ArrayList<String>();
    List<String> formessage = new ArrayList<String>();
    List<String> formlogin = new ArrayList<String>();

    dbHandler db;
    Context context;



    public ParsJsonString(String result) {

        jsonstring = result;
    }

    public List jsonpars() throws JSONException {

        String v1,v2;

        JSONObject jsonObj = new JSONObject(jsonstring);

        // Extract data from json and store into ArrayList as class objects
        for(int i=1;i<=jsonObj.length();i++){

            type_model type = new type_model();

            JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
            type.setName(json_data.getString("name"));
            data.add(type);
        }

        return data;
    }









}
