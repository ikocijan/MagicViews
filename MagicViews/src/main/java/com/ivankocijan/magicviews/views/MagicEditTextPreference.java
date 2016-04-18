package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.FontPreference;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ivankocijan on 23.05.2014..
 */
public class MagicEditTextPreference extends EditTextPreference implements FontPreference {

    private MagicPreferenceDelegate delegate;

    public MagicEditTextPreference(Context context) {
        super(context);
        init(null);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MagicEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.delegate = new MagicPreferenceDelegate();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MagicEditTextPreference);
            String titleFontName = a.getString(R.styleable.MagicEditTextPreference_editTextPrefTitleFont);
            float titleCharacterSpacing = a.getFloat(R.styleable.MagicEditTextPreference_editTextPrefTitleCharacterSpacing, 0);
            String summaryFontName = a.getString(R.styleable.MagicEditTextPreference_editTextPrefSummaryFont);
            float summaryCharacterSpacing = a.getFloat(R.styleable.MagicEditTextPreference_editTextPrefSummaryCharacterSpacing, 0);
            a.recycle();

            delegate.setAttributes(titleFontName, titleCharacterSpacing,
                    summaryFontName, summaryCharacterSpacing);
        }
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        if (!view.isInEditMode()) {
            delegate.onBindView(view);
        }
    }

    @Override
    public void setTitleFont(String fontName) {
        delegate.setTitleFont(fontName);
    }

    @Override
    public void setTitleCharacterSpacing(float characterSpacing) {
        delegate.setTitleCharacterSpacing(characterSpacing);
    }

    @Override
    public void setSummaryFont(String fontName) {
        delegate.setSummaryFont(fontName);
    }

    @Override
    public void setSummaryCharacterSpacing(float characterSpacing) {
        delegate.setSummaryCharacterSpacing(characterSpacing);
    }

    @Override
    public void setFont(String fontName) {
        delegate.setFont(fontName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        delegate.setCharacterSpacing(characterSpacing);
    }
}
