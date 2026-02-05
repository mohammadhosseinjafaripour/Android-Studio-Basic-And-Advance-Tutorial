

package com.jfp.patternlockscreen.app;

import android.os.Bundle;

import com.jfp.patternlockscreen.R;
import com.jfp.patternlockscreen.util.ThemeUtils;


public class MainActivity extends ThemedAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ThemeUtils.applyTheme(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
    }
}
