package com.ivankocijan.magicviews;

/**
 * Created by jmarkovic on 16/04/16.
 */
public interface TypefacePreference extends TypefaceView {

    void setTitleTypeface(String typeface);
    void setTitleCharacterSpacing(float characterSpacing);
    void setSummaryTypeface(String typeface);
    void setSummaryCharacterSpacing(float characterSpacing);

}
