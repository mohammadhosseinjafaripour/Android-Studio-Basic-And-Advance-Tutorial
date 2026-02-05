package ir.rahnama.form1;


import android.app.Application;

import ir.rahnama.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by jefferson on 3/26/2017.
 */

public class Font extends Application {
    public void onCreate()
    {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()

                .setDefaultFontPath("iransans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}