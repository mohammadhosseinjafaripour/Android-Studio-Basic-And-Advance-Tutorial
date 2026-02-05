package ir.rahnama.form1;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by jefferson on 9/19/2017.
 */

public class Radiogroupchecker {

    public Activity activity;
    int ff=0;
    public String checker (int RadioGroup , final int[] radioButtons)
    {
        RadioGroup radioGroup = (RadioGroup)activity.findViewById(RadioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                ff= checkedId;
                for(int i = 0;i<=radioButtons.length;i++) {
                    if (checkedId == radioButtons[i]) {
                        ff = radioButtons[i];
                    }
                    else
                    {

                    }
                }
            }
        });

        return Integer.toString(ff);
    }

    public Radiogroupchecker(Activity _activity)
    {
        this.activity=_activity;

    }
}
