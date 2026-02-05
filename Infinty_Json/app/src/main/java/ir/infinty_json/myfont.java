package ir.infinty_json;

/**
 * Created by Reza on 9/8/2017.
 */
import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by jefferson on 3/26/2017.
 */

public class myfont extends Application {
    public void onCreate()
    {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()

                .setDefaultFontPath("IRANSansFaNum.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
