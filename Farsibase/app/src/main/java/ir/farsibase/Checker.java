package ir.farsibase;

import android.os.AsyncTask;
import android.widget.EditText;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by amir on 9/8/2017.
 */
public class Checker {

    public Boolean age_checker(String age,EditText et){

        EditText et1;
        et1 = et;
        if(!(age.length() == 0)) {
            if (Integer.parseInt(age) >= 18 && Integer.parseInt(age) < 100) {
                return true;
            }
        }else{
            et1.setError("خالی");
            return false;
        }
        //et1.setTextColor(Color.parseColor("#FFFA5151"));
        //et1.requestFocus();
        et1.setError("سن بیشتر 18 و کمتر از 100");
        return false;

        //asan motor
    }

    public Boolean phone_checker(String phone,EditText etph){
        EditText et11;
        et11 = etph;

        if(!(phone.length() == 0)){
        if(phone.length()>=8 && phone.length()<10){
            return true;
        }

        }else{
            et11.setError("خالی می باشد");
            return false;
        }

        //et11.setTextColor(Color.parseColor("#FFFA5151"));
        et11.setError("خطا در ورود شماره تلفن");
        return false;
    }

    public Boolean mobile_checker(String mobile,EditText etmobile){
        EditText et11;
        et11 = etmobile;

        if(!(mobile.length() == 0)){
            if(mobile.length()== 11 ){
                return true;
            }

        }else{
            et11.setError("خالی می باشد");
            return false;
        }

        //et11.setTextColor(Color.parseColor("#FFFA5151"));
        et11.setError("خطا در ورود شماره موبایل");
        return false;
    }

    public Boolean count_family_checker(String countfamily,EditText etcountfamily){
        EditText et11;
        et11 = etcountfamily;

        if(!(countfamily.length() == 0)){
            if(Integer.parseInt(countfamily) >= 1 && Integer.parseInt(countfamily)< 15 ){
                return true;
            }

        }else{
            et11.setError("خالی می باشد");
            return false;
        }

        //et11.setTextColor(Color.parseColor("#FFFA5151"));
        et11.setError("خطا در ورود داده");
        return false;
    }

    public Boolean empty_checker(String name,EditText etph){
        EditText et11;
        et11 = etph;

        if(!(name.length() == 0)){
            if(name.length()>3 && name.length()<40){
                return true;
            }
        }
        et11.setError("خالی می باشد");
        return false;
    }




}
