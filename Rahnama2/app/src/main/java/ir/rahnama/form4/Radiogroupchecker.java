package ir.rahnama.form4;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by jefferson on 9/19/2017.
 */

public class Radiogroupchecker {

    public Activity activity;

    public  String result;
    public  String[] r;

    public  String result2;
    public  String r2;
    public String[] RaddText(final RadioGroup[] radioGroups)
    {
        r=new String[radioGroups.length];
        for(int i=0;i<radioGroups.length;i++) {
            final int count = i;
            radioGroups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    int tag = Integer.parseInt(group.getTag().toString());
                    final String value =
                            ((RadioButton) activity.findViewById(radioGroups[tag].getCheckedRadioButtonId()))
                                    .getText().toString();
                    result = (value).toString();
                    r[count] = result;
                }
            });
        }
        return r;

    }

    public String RaddText(final RadioGroup radioGroups)
    {
        r2="";
        radioGroups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                // int tag= Integer.parseInt(group.getTag().toString());
                final String value =
                        ((RadioButton) activity.findViewById(radioGroups.getCheckedRadioButtonId()))
                                .getText().toString();
                result2=(value).toString();
                r2=result2;
            }
        });
        return r2;

    }


    //_________________

    public String[] RadHint(final RadioGroup[] radioGroups)
    {

        r=new String[radioGroups.length];
        for(int i=0;i<radioGroups.length;i++) {
            final int count = i;
            radioGroups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    int tag = Integer.parseInt(group.getTag().toString());
                    final String value =
                            ((RadioButton) activity.findViewById(radioGroups[tag].getCheckedRadioButtonId()))
                                    .getHint().toString();
                    result = (value).toString();
                    r[count] = result;

                }
            });
        }
        return r;

    }


    public String RaddHint(final RadioGroup radioGroups)
    {
        r2="";
        radioGroups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                // int tag= Integer.parseInt(group.getTag().toString());
                final String value =
                        ((RadioButton) activity.findViewById(radioGroups.getCheckedRadioButtonId()))
                                .getHint().toString();
                result2=(value).toString();
                r2=result2;
            }
        });
        return r2;

    }




    public Radiogroupchecker(Activity _activity)
    {
        this.activity=_activity;

    }
}