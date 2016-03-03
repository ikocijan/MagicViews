package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class CustomViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.inject(this);
    }
}
