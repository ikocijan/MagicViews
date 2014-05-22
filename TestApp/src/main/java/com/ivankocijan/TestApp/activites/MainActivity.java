package com.ivankocijan.TestApp.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.magicviews.views.MagicButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @InjectView(R.id.preference_example)
    MagicButton preferenceExample;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

    }

    @OnClick(R.id.preference_example)
    protected void goToPrefs () {

        startActivity(new Intent(MainActivity.this, PreferenceExampleActivity.class));

    }

}
