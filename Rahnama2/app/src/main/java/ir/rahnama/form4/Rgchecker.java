package ir.rahnama.form4;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by MyCroft on 9/19/2017.
 */

public class Rgchecker {

    public Activity activity;
    public Rgchecker(Activity _activity)
    {
        this.activity=_activity;

    }
    public int i=0;
    public int re=0;
    String[] q={"1","2","3","4","5","6","7","8","9","10"};
    public int checker(int radiogroupId, final int[] radiobuttonsIds, int textviewId, RadioGroup RadioGroups, TextView Errorview, final RadioButton[] radiobuttons)
    {
        if(radiobuttons.length!=radiobuttonsIds.length)
            return 0;
        RadioGroups= (RadioGroup)this.activity.findViewById(radiogroupId);
        Errorview= (TextView) this.activity.findViewById(textviewId);
        for(int a=0;a<radiobuttons.length;a++)
        {
            radiobuttons[a]= (RadioButton)this.activity.findViewById(radiobuttonsIds[a]);
        }



            RadioGroups.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                final int finalI = i;
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    for(int i=0;i<radiobuttonsIds.length;i++)
                    {

                        if(checkedId==radiobuttonsIds[i])
                        {
                         re=checkedId;
                        }
                    }
                }
            });

        return re;

    }



}
