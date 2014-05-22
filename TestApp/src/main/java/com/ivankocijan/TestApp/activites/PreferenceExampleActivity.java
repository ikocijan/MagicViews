package com.ivankocijan.TestApp.activites;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.WindowManager;

import com.ivankocijan.TestApp.ExamplePreferenceFragment;
import com.ivankocijan.TestApp.R;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class PreferenceExampleActivity extends Activity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.preference_screen);

        Fragment settings = ExamplePreferenceFragment.getInstance();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, settings);
        fragmentTransaction.commit();

    }

}
