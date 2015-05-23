package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.magicviews.views.MagicTextView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CodeExampleActivity extends Activity {

    @InjectView(R.id.wrapper)
    LinearLayout wrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_example);
        ButterKnife.inject(this);
        addViews();
    }

    private void addViews() {

        MagicTextView magicTextView = new MagicTextView(this);
        magicTextView.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        magicTextView.setText("TextView");
        magicTextView.setFont("open_sans_regular.ttf");

        MagicTextView magicTextView2 = new MagicTextView(this);
        magicTextView.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        magicTextView.setText("TextView2");
        magicTextView.setFont("open_sans_semi_bold.ttf");

        MagicTextView magicTextView3 = new MagicTextView(this);
        magicTextView.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        magicTextView.setText("TextView3");

        wrapper.addView(magicTextView);
        wrapper.addView(magicTextView2);
        wrapper.addView(magicTextView3);


    }


}
