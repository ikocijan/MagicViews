package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.R;
import com.ivankocijan.magicviews.FontPreference;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ivankocijan on 22.05.2014..
 */
public class MagicPreference extends Preference implements FontPreference {

    private MagicPreferenceDelegate delegate;

    public MagicPreference(Context context) {
        super(context);
        init(null);
    }

    public MagicPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MagicPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MagicPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.delegate = new MagicPreferenceDelegate();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MagicPreference);
            String titleFontName = a.getString(R.styleable.MagicPreference_prefTitleFont);
            float titleCharacterSpacing = a.getFloat(R.styleable.MagicPreference_prefTitleCharacterSpacing, 0);
            String summaryFontName = a.getString(R.styleable.MagicPreference_prefSummaryFont);
            float summaryCharacterSpacing = a.getFloat(R.styleable.MagicPreference_prefSummaryCharacterSpacing, 0);
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
