package ir.rahnama;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by jefferson on 9/27/2017.
 */

public class yearcheckerforswitch {
    public Activity activity;

    public Boolean checkbig(String number1,String number2)
    {
        int yearV1 = Integer.parseInt(number1.toString());
        int yearV2 = Integer.parseInt(number2.toString());

        if(yearV1<=yearV2)
        {
            return true;
        }
        else
        {
            //Toast.makeText(activity, "سال ساخت خودرو و سال خرید مقایرت دارند", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public yearcheckerforswitch(Activity _activity)
    {
        this.activity=_activity;

    }
}
