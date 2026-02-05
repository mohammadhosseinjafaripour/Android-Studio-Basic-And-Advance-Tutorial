package ir.farsibase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jefferson on 9/18/2017.
 */

public class myhashmap {

    public HashMap<String,String> gnstr(ArrayList arr ,String textvalue){

        HashMap<String, String> meMap=new HashMap<String, String>();

        Integer counter =0;
        Iterator itr=arr.iterator();

        while(itr.hasNext()){

            meMap.put(textvalue + Integer.toString(counter + 1), itr.next().toString());
            counter++;
        }

        return meMap;
    }

}
