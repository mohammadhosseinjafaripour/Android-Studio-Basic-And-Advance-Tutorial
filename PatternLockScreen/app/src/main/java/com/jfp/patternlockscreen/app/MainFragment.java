

package com.jfp.patternlockscreen.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import me.zhanghai.android.patternlock.sample.R;
import me.zhanghai.android.patternlock.sample.util.PreferenceContract;
import me.zhanghai.android.patternlock.sample.util.PreferenceUtils;

public class MainFragment extends PreferenceFragmentCompat
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        PreferenceUtils.getPreferences(getActivity())
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        PreferenceUtils.getPreferences(getActivity())
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case PreferenceContract.KEY_THEME:
                getActivity().recreate();
        }
    }
}
