package com.ivankocijan.magicviews;

/**
 * Created by jmarkovic on 16/04/16.
 */
public interface FontPreference extends FontView {

    void setTitleFont(String fontName);
    void setTitleCharacterSpacing(float characterSpacing);
    void setSummaryFont(String fontName);
    void setSummaryCharacterSpacing(float characterSpacing);

}
