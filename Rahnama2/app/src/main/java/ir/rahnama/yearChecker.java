package ir.rahnama;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Reza on 9/25/2017.
 */
public class yearChecker {
    public Activity activity;

    public Boolean checkbig(String number1, String number2) {
        int yearV1 = Integer.parseInt(number1.toString());
        int yearV2 = Integer.parseInt(number2.toString());

        if (yearV1 <= yearV2) {
            return true;
        } else {
            Toast.makeText(activity, "سال ساخت خودرو و سال خرید مقایرت دارند", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public Boolean checkbig_new(String number1, String number2) {
        int yearV1 = Integer.parseInt(number1.toString());
        int yearV2 = Integer.parseInt(number2.toString());

        if (yearV1 <= yearV2) {
            return true;
        } else {
            Toast.makeText(activity, "سال ساخت خودرو و سال خرید مقایرت دارند", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    public Boolean checkyear(EditText edtyear) {
        if (edtyear.getText().toString().matches("")) {
            return false;
        } else {
            int temp =  Integer.parseInt(edtyear.getText().toString());
            if(temp==93||temp==94||temp==95||temp==96)
            {
                return true;
            }
            else
            {
                Toast.makeText(activity, "سال ساخت باید بین 93 تا 96 باشد.", Toast.LENGTH_SHORT).show();
                return false;
            }


        }
    }

    public yearChecker(Activity _activity) {
        this.activity = _activity;

    }
}
