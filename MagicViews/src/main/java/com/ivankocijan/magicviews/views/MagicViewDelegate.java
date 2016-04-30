package com.ivankocijan.magicviews.views;

import com.ivankocijan.magicviews.FontView;
import com.ivankocijan.magicviews.MagicViews;
import com.ivankocijan.magicviews.R;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jmarkovic on 15/04/16.
 */
class MagicViewDelegate implements FontView {

    private static final String MATCH_ALL_CHARACTERS = "(.)";

    private static final String ADD_SPACE_TO_CHARACTER = "$1 ";

    private final TextView magicView;

    MagicViewDelegate(@NonNull TextView magicView) {
        this.magicView = magicView;
    }

    /**
     * Set's attributes to TextView if they exist
     */
    void setAttributes(AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = this.magicView.getContext().obtainStyledAttributes(attrs, R.styleable.MagicFont);
            String fontName = a.getString(R.styleable.MagicFont_font);
            float characterSpacing = a.getFloat(R.styleable.MagicFont_characterSpacing, 0);

            setFont(fontName);
            setCharacterSpacing(characterSpacing);

            a.recycle();
        }
    }

    public void setFont(String fontName) {
        if (fontName == null) {
            fontName = MagicViews.INSTANCE.getDefaultFontName();

            if (fontName == null) {
                return;
            }
        }

        this.magicView.setTypeface(MagicViews.INSTANCE.getFont(fontName));
    }

    public void setCharacterSpacing(float characterSpacing) {
        if (characterSpacing != 0) {
            String originalText = this.magicView.getText().toString();

            if (originalText.length() > 1) {
                originalText = originalText.replaceAll(MATCH_ALL_CHARACTERS, ADD_SPACE_TO_CHARACTER);

                SpannableString finalText = new SpannableString(originalText);
                finalText.setSpan(new ScaleXSpan(characterSpacing), 0, originalText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                this.magicView.setText(finalText, TextView.BufferType.SPANNABLE);
            }
        }
    }

}
