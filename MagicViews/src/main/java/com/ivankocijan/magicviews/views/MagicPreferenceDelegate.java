package com.ivankocijan.magicviews.views;

import android.view.View;
import android.widget.TextView;

/**
 * Created by jmarkovic on 16/04/16.
 */
class MagicPreferenceDelegate {

    private String titleFontName, summaryFontName;
    private float titleCharacterSpacing, summaryCharacterSpacing;
    private MagicViewDelegate titleDelegate, summaryDelegate;

    MagicPreferenceDelegate() {
    }

    public void setAttributes(String titleFontName, float titleCharacterSpacing,
            String summaryFontName, float summaryCharacterSpacing) {
        this.titleFontName = titleFontName;
        this.titleCharacterSpacing = titleCharacterSpacing;
        this.summaryFontName = summaryFontName;
        this.summaryCharacterSpacing = summaryCharacterSpacing;
    }

    public void onBindView(View view) {
        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        if (titleView != null) {
            titleDelegate = new MagicViewDelegate(titleView);
            titleDelegate.setFont(this.titleFontName);
            titleDelegate.setCharacterSpacing(this.titleCharacterSpacing);
        }
        TextView summaryView = (TextView) view.findViewById(android.R.id.summary);
        if (summaryView != null) {
            summaryDelegate = new MagicViewDelegate(summaryView);
            summaryDelegate.setFont(this.summaryFontName);
            summaryDelegate.setCharacterSpacing(this.summaryCharacterSpacing);
        }
    }

    public void setFont(String fontName) {
        setTitleFont(fontName);
        setSummaryFont(fontName);
    }

    public void setCharacterSpacing(float characterSpacing) {
        setTitleCharacterSpacing(characterSpacing);
        setSummaryCharacterSpacing(characterSpacing);
    }

    public void setTitleFont(String fontName) {
        this.titleFontName = fontName;
        if (titleDelegate != null) {
            titleDelegate.setFont(fontName);
        }
    }

    public void setTitleCharacterSpacing(float titleCharacterSpacing) {
        this.titleCharacterSpacing = titleCharacterSpacing;
        if (titleDelegate != null) {
            titleDelegate.setCharacterSpacing(titleCharacterSpacing);
        }
    }

    public void setSummaryFont(String fontName) {
        this.summaryFontName = fontName;
        if (summaryDelegate != null) {
            summaryDelegate.setFont(fontName);
        }
    }

    public void setSummaryCharacterSpacing(float summaryCharacterSpacing) {
        this.summaryCharacterSpacing = summaryCharacterSpacing;
        if (summaryDelegate != null) {
            summaryDelegate.setCharacterSpacing(summaryCharacterSpacing);
        }
    }
}
