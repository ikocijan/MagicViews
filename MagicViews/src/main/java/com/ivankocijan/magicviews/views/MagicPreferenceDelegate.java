package com.ivankocijan.magicviews.views;

import android.view.View;
import android.widget.TextView;

/**
 * Created by jmarkovic on 16/04/16.
 */
class MagicPreferenceDelegate {

    private String titleTypeface, summaryTypeface;
    private float titleCharacterSpacing, summaryCharacterSpacing;
    private MagicViewDelegate titleDelegate, summaryDelegate;

    MagicPreferenceDelegate() {
    }

    public void setAttributes(String titleTypeface, float titleCharacterSpacing,
            String summaryTypeface, float summaryCharacterSpacing) {
        this.titleTypeface = titleTypeface;
        this.titleCharacterSpacing = titleCharacterSpacing;
        this.summaryTypeface = summaryTypeface;
        this.summaryCharacterSpacing = summaryCharacterSpacing;
    }

    public void onBindView(View view) {
        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        if (titleView != null) {
            titleDelegate = new MagicViewDelegate(titleView);
            titleDelegate.setTypeface(this.titleTypeface);
            titleDelegate.setCharacterSpacing(this.titleCharacterSpacing);
        }
        TextView summaryView = (TextView) view.findViewById(android.R.id.summary);
        if (summaryView != null) {
            summaryDelegate = new MagicViewDelegate(summaryView);
            summaryDelegate.setTypeface(this.summaryTypeface);
            summaryDelegate.setCharacterSpacing(this.summaryCharacterSpacing);
        }
    }

    public void setTypeface(String typeFaceName) {
        setTitleTypeface(typeFaceName);
        setSummaryTypeface(typeFaceName);
    }

    public void setCharacterSpacing(float characterSpacing) {
        setTitleCharacterSpacing(characterSpacing);
        setSummaryCharacterSpacing(characterSpacing);
    }

    public void setTitleTypeface(String typeface) {
        this.titleTypeface = typeface;
        if (titleDelegate != null) {
            titleDelegate.setTypeface(typeface);
        }
    }

    public void setTitleCharacterSpacing(float titleCharacterSpacing) {
        this.titleCharacterSpacing = titleCharacterSpacing;
        if (titleDelegate != null) {
            titleDelegate.setCharacterSpacing(titleCharacterSpacing);
        }
    }

    public void setSummaryTypeface(String summaryTypeface) {
        this.summaryTypeface = summaryTypeface;
        if (summaryDelegate != null) {
            summaryDelegate.setTypeface(summaryTypeface);
        }
    }

    public void setSummaryCharacterSpacing(float summaryCharacterSpacing) {
        this.summaryCharacterSpacing = summaryCharacterSpacing;
        if (summaryDelegate != null) {
            summaryDelegate.setCharacterSpacing(summaryCharacterSpacing);
        }
    }
}
