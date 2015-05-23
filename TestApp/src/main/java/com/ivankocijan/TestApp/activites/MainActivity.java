package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

    }

    @OnClick(R.id.preference_example)
    protected void goToPrefs() {

        startActivity(new Intent(MainActivity.this, PreferenceExampleActivity.class));

    }

    @OnClick(R.id.layout_example)
    protected void goToLayoutExample() {
        startActivity(new Intent(MainActivity.this, LayoutExampleActivity.class));

    }

    @OnClick(R.id.code_example)
    protected void goToCodeExample() {
        startActivity(new Intent(MainActivity.this, CodeExampleActivity.class));

    }


}
