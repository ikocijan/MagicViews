package com.ivankocijan.TestApp.activites;

import com.ivankocijan.TestApp.R;
import com.ivankocijan.magicviews.MagicFontSpan;
import com.ivankocijan.magicviews.views.MagicTextView;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jmarkovic on 24/02/16.
 */
public class MagicFontSpanExampleActivity extends Activity {

    @InjectView(R.id.tv_long_text) MagicTextView tvLongText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_font_span_example);
        ButterKnife.inject(this);

        SpannableStringBuilder builder = new SpannableStringBuilder(getString(R.string.magic_font_span_text));

        builder.setSpan(new MagicFontSpan("open_sans_semi_bold.ttf"), 15, 23, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        builder.setSpan(new MagicFontSpan("open_sans_light.ttf"), 27, 44, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        builder.setSpan(new MagicFontSpan("galaxyfaraway.ttf"),
                builder.length() - 10,
                builder.length() - 1,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        tvLongText.setText(builder);
    }
}
