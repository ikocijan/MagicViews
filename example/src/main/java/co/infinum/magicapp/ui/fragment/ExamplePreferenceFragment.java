package co.infinum.magicapp.ui.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import co.infinum.magicapp.R;

/**
 * Created by jmarkovic on 17/04/16.
 */
public class ExamplePreferenceFragment extends PreferenceFragment {

    public static ExamplePreferenceFragment newInstance() {
        return new ExamplePreferenceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_example);
    }
}
