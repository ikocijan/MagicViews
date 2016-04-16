package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.TypefacePreference;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ivankocijan on 23.05.2014..
 */
public class MagicEditTextPreference extends EditTextPreference implements TypefacePreference {

    private MagicPreferenceDelegate delegate;

    public MagicEditTextPreference(Context context) {
        this(context, null);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MagicEditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        this.delegate = new MagicPreferenceDelegate();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MagicEditTextPreference);
            String titleTypeface = a.getString(R.styleable.MagicEditTextPreference_editTextPrefTitleTypeFace);
            float titleCharacterSpacing = a.getFloat(R.styleable.MagicEditTextPreference_editTextPrefTitleCharacterSpacing, 0);
            String summaryTypeface = a.getString(R.styleable.MagicEditTextPreference_editTextPrefSummaryTypeFace);
            float summaryCharacterSpacing = a.getFloat(R.styleable.MagicEditTextPreference_editTextPrefSummaryCharacterSpacing, 0);
            a.recycle();

            delegate.setAttributes(titleTypeface, titleCharacterSpacing,
                    summaryTypeface, summaryCharacterSpacing);
        }
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        delegate.onBindView(view);
    }

    @Override
    public void setTitleTypeface(String typeface) {
        delegate.setTitleTypeface(typeface);
    }

    @Override
    public void setTitleCharacterSpacing(float characterSpacing) {
        delegate.setTitleCharacterSpacing(characterSpacing);
    }

    @Override
    public void setSummaryTypeface(String typeface) {
        delegate.setSummaryTypeface(typeface);
    }

    @Override
    public void setSummaryCharacterSpacing(float characterSpacing) {
        delegate.setSummaryCharacterSpacing(characterSpacing);
    }

    @Override
    public void setTypeface(String typeFaceName) {
        delegate.setTypeface(typeFaceName);
    }

    @Override
    public void setCharacterSpacing(float characterSpacing) {
        delegate.setCharacterSpacing(characterSpacing);
    }
}
