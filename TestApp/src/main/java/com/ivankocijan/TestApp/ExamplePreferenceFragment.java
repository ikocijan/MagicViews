package com.ivankocijan.TestApp;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class ExamplePreferenceFragment extends PreferenceFragment {

    private volatile static ExamplePreferenceFragment preferenceFragment;

    public static ExamplePreferenceFragment getInstance () {

        if (preferenceFragment == null) {

            synchronized (ExamplePreferenceFragment.class) {

                if (preferenceFragment == null) {

                    preferenceFragment = new ExamplePreferenceFragment();

                }

            }

        }

        return preferenceFragment;

    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.example_preference);

    }
}
