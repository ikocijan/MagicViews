package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.magicviews.views.MagicAutoCompleteTextView;
import com.ivankocijan.magicviews.views.MagicButton;
import com.ivankocijan.magicviews.views.MagicCheckBox;
import com.ivankocijan.magicviews.views.MagicCheckedTextView;
import com.ivankocijan.magicviews.views.MagicEditText;
import com.ivankocijan.magicviews.views.MagicMultiAutoCompleteTextView;
import com.ivankocijan.magicviews.views.MagicRadioButton;
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
        magicTextView.setTextAppearance(this, R.style.Text);
        magicTextView.setText("TextView");
        magicTextView.setTypeface("open_sans_semi_bold.ttf");

        MagicEditText magicEditText = new MagicEditText(this);
        magicEditText.setTextAppearance(this, R.style.Text);
        magicEditText.setHint("Edit text");
        magicEditText.setTypeface("open_sans_semi_bold.ttf");

        MagicButton magicButton = new MagicButton(this);
        magicButton.setTextAppearance(this, R.style.Text);
        magicButton.setText("Button");
        magicButton.setTypeface("open_sans_semi_bold.ttf");

        MagicCheckBox magicCheckBox = new MagicCheckBox(this);
        magicCheckBox.setTextAppearance(this, R.style.Text);
        magicCheckBox.setText("Checkbox");
        magicCheckBox.setTypeface("open_sans_semi_bold.ttf");

        MagicCheckedTextView magicCheckedTextView = new MagicCheckedTextView(this);
        magicCheckedTextView.setTextAppearance(this, R.style.Text);
        magicCheckedTextView.setText("Checked text view");
        magicCheckedTextView.setTypeface("open_sans_semi_bold.ttf");

        MagicRadioButton magicRadioButton = new MagicRadioButton(this);
        magicRadioButton.setTextAppearance(this, R.style.Text);
        magicRadioButton.setText("Radio button");
        magicRadioButton.setTypeface("open_sans_semi_bold.ttf");

        MagicAutoCompleteTextView magicAutoCompleteTextView = new MagicAutoCompleteTextView(this);
        magicAutoCompleteTextView.setTextAppearance(this, R.style.Text);
        magicAutoCompleteTextView.setText("Autocomplete");
        magicAutoCompleteTextView.setTypeface("open_sans_semi_bold.ttf");

        MagicMultiAutoCompleteTextView magicMultiAutoCompleteTextView = new MagicMultiAutoCompleteTextView(this);
        magicMultiAutoCompleteTextView.setTextAppearance(this, R.style.Text);
        magicMultiAutoCompleteTextView.setText("Multi autocomplete");
        magicMultiAutoCompleteTextView.setTypeface("open_sans_semi_bold.ttf");

        wrapper.addView(magicTextView);
        wrapper.addView(magicEditText);
        wrapper.addView(magicButton);
        wrapper.addView(magicCheckBox);
        wrapper.addView(magicCheckedTextView);
        wrapper.addView(magicRadioButton);
        wrapper.addView(magicAutoCompleteTextView);
        wrapper.addView(magicMultiAutoCompleteTextView);


    }


}
