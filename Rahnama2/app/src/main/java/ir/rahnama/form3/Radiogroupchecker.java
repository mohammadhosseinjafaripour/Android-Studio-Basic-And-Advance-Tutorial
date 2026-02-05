package ir.rahnama.form3;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by jefferson on 9/19/2017.
 */

public class Radiogroupchecker {

    private Activity activity;

    public String result;
    public String[] r;

    public String[] Radd(final RadioGroup[] radioGroups) {
        r = new String[radioGroups.length];
        for (RadioGroup radioGroup : radioGroups)
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    int tag = Integer.parseInt(group.getTag().toString());
                    final String value =
                            ((RadioButton) activity.findViewById(radioGroups[tag].getCheckedRadioButtonId()))
                                    .getText().toString();
                    r[tag] = value;
                }
            });
        return r;

    }

    public Radiogroupchecker(Activity _activity) {
        this.activity = _activity;

    }
}